package org.roof.monitor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import au.com.bytecode.opencsv.CSVWriter;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>Description: </p>
 * <p>Title: ToExport.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年6月3日 下午3:09:41</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class ToExport {
	/*xlsx最大容纳1048576行 csv最大容纳1048576行 xls最大容纳65536行*/
	private static final int defaultXlsMaxNum = 1 << 16 ;//65536
	private static final int defaultCsvMaxNum = 1 << 20 ;//1048576
	
	public void export(HttpServletRequest request, HttpServletResponse response, List<JSONObject> list){
		HttpSession session = request.getSession();
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = session.getAttribute("userName").toString();
		}
		String title = request.getParameter("FileTitle");//标题名称
		String headerStr = request.getParameter("HeaderTitle");//一级表头名称;一级表头index名称;(二级表头名称;二级表头开始index;二级表头结束index)
		String [] headerStrArray = headerStr.split(";#;");
		if(headerStrArray.length > 0){
			String [] firstTitleNames = headerStrArray[0].split(",#,");//例如"时间"
			String [] firstTitleIndexNames = headerStrArray[1].split(",#,");//例如"time"
			String [] firstTitleIndexIsHiddens = headerStrArray[2].split(",#,");//例如"true"
			if(headerStrArray.length <= 3){//只有一级表头 
				exportToExcelOrCsv (firstTitleNames,firstTitleIndexNames,firstTitleIndexIsHiddens,
						null,null,null,
						list,title,response,userName);
			}else{//目前最多只支持二级表头
				String [] secondTitleNames = headerStrArray[3].split(",#,");
				String [] secondTitleStartIndexs = headerStrArray[4].split(",#,");
				String [] secondTitleEndIndexs = headerStrArray[5].split(",#,");
				exportToExcelOrCsv (firstTitleNames,firstTitleIndexNames,firstTitleIndexIsHiddens,
						secondTitleNames,secondTitleStartIndexs,secondTitleEndIndexs,
						list,title,response,userName);
			}
		}else{
			try {
				throw new Exception("导出数据获取表头信息失败!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void exportToExcelOrCsv(String [] firstTitleNames, String [] firstTitleIndexNames,String [] firstTitleIndexIsHiddens,
			String [] secondTitleNames,String [] secondTitleStartIndexs,String [] secondTitleEndIndexs,
			List<JSONObject> list, String title, HttpServletResponse response, String userName){
		if(list != null){
			if(list.size() >= defaultXlsMaxNum){
				if(list.size() <= defaultCsvMaxNum){
					exportToCSV(firstTitleNames,firstTitleIndexNames,
							list,title,response,userName);
				}else{
					/*需要拆分为多个文件,暂不处理,抛出异常!*/
					/**
					 * int fileNum = list.size / defaultCsvMaxNum + 1;
					 * for(int i = 0;i < fileNum; i++){
					 * 		int beginIndex = i * defaultCsvMaxNum;
					 * 		int endIndex = (i+1) * defaultCsvMaxNum -1;
					 * 		int pageSize = defaultCsvMaxNum;
					 * 	①  List<JSONObject> dividedList = list.subList(beginIndex,endIndex);//前提是list能存储那么多数据,内存不溢出
					 * 	②  List<JSONObject> dividedList = XXDao.getXXX(Params....,beginIndex,pageSize);//分页去数据库查.
					 * 		exportToCSV(firstTitleNames,firstTitleIndexNames,
								dividedList,title+"i",response,userName);
					 * }
					 */
					try {
						throw new Exception("文件行数过多,导出失败!");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else{
				exportToExcel(firstTitleNames,firstTitleIndexNames,firstTitleIndexIsHiddens,
						secondTitleNames,secondTitleStartIndexs,secondTitleEndIndexs,
						list,title,response,userName);
			}
		}
	}
	
	private void exportToExcel(String [] firstTitleNames, String [] firstTitleIndexNames,String [] firstTitleIndexIsHiddens,
			String [] secondTitleNames,String [] secondTitleStartIndexs,String [] secondTitleEndIndexs,
			List<JSONObject> list, String title, HttpServletResponse response, String userName){
		/*创建sheet*/
		HSSFWorkbook wb = new HSSFWorkbook();
		Sheet sh = wb.createSheet();
		
		/*设置标题样式:居中,颜色*/
		HSSFCellStyle cs = wb.createCellStyle();
		cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cs.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
		
		/*处理第一行文件名称*/
		SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String create_time = formater.format(new Date());
		StringBuffer remark = new StringBuffer();
		remark.append("创建人：" + userName+"	"+"创建时间：" + create_time);
		
		Row row = sh.createRow(0);
		Cell cel = row.createCell(0);
		cel.setCellValue(remark.toString());
//		cel.setCellStyle(cs);
		sh.addMergedRegion(new CellRangeAddress(0,0,0,firstTitleNames.length-1));
		
		/*处理第二行二级表头名称*/
		if(secondTitleNames != null){
			row = sh.createRow(sh.getLastRowNum() + 1);
			for(int j = 0 ;j < secondTitleStartIndexs.length; j++){
				int startCol  = Integer.parseInt(secondTitleStartIndexs[j]);
				int endCol  = Integer.parseInt(secondTitleEndIndexs[j]);
				cel = row.createCell(startCol);
				cel.setCellValue(secondTitleNames[j]);
				cel.setCellStyle(cs);
				sh.addMergedRegion(new CellRangeAddress(1, 1, startCol, endCol));
			}
		}
		
		/*处理第二(三)行一级表头名称*/
		row = sh.createRow(sh.getLastRowNum() + 1);
		for(int i = 0 ;i < firstTitleNames.length;i++){
			cel = row.createCell(i);
			cel.setCellValue(firstTitleNames[i]);
			cel.setCellStyle(cs);
			sh.setColumnWidth(i, 15 * 256);//设置宽度
			if("true".equals(firstTitleIndexIsHiddens[i])){
				sh.setColumnHidden(i, true);//折叠隐藏列				
			}
		}
		
		/*处理excel数据*/
		for(int j =0 ;j < list.size();j++){
			row = sh.createRow(sh.getLastRowNum() + 1);
			for(int i = 0 ;i < firstTitleIndexNames.length;i++){
				cel = row.createCell(i);
				if(i==0 && "rn".equals(firstTitleIndexNames[0])){
					sh.setColumnWidth(i, 5 * 256);//设置宽度
					cel.setCellValue(j+1);//设置行号
				}else{
					cel.setCellValue(list.get(j).getString(firstTitleIndexNames[i]));					
				}
			}
		}

		/*设置response消息头*/
		OutputStream out = null;
		try {
			String fileName = java.net.URLEncoder.encode(title, "UTF-8") + ".xls";
			response.setHeader("Content-Type","application/vnd.ms-excel;charset=UTF-8");  
			response.setHeader("Content-Disposition","attachment;filename=" + fileName);
			response.setHeader("Connection", "close");//当前正在使用的tcp链接在请求处理完毕后会被断掉
			response.addHeader("Pargam", "no-cache");  
			response.addHeader("Cache-Control", "no-cache");//请求或响应消息不能缓存
			
			out = response.getOutputStream();
			wb.write(out);
			out.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void exportToCSV(String [] firstTitleNames, String [] firstTitleIndexNames,
			List<JSONObject> list, String title, HttpServletResponse response, String userName){
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + title + ".csv");
		
		CSVWriter writer = null;
		try {
			writer = new CSVWriter(new OutputStreamWriter(response.getOutputStream(), "GBK"));
			// 文档信息
			writer.writeNext(new String[]{title});
			writer.writeNext(new String[] { "创建人:" + userName });
			SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			String create_time = formater.format(new Date());
			writer.writeNext(new String[] { "创建时间:" + create_time});
			// 表头信息
			writer.writeNext(firstTitleNames);
			
			if(list != null && !list.isEmpty()){
				int count = list.size();
				String[] rowStrArr = new String[firstTitleIndexNames.length];
				for (int i = 0; i < count; i++) {
					for (int j = 0; j < firstTitleNames.length; j++) {
						if (list.get(i).get(firstTitleIndexNames[j]) == null) {
							rowStrArr[j] = "";
						} else {
							rowStrArr[j] = "\t"+list.get(i).getString(firstTitleIndexNames[j]);
						}
					}
					writer.writeNext(rowStrArr);
					if ((i+1) % 500 == 0) {
						writer.flush();
					}
				}
				rowStrArr = null;
			}
			writer.flush();
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
