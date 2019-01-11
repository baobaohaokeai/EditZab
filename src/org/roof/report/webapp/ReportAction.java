package org.roof.report.webapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.roof.web.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reportAction")
public class ReportAction {
	 @Value("${hc_culb_url}")
	 private String hCubleUrl;
	
	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request, HttpSession httpSession) {
		String rpname=request.getParameter("rpname");
		//String reportUrl =null;
		UserDetails userDetails =  org.roof.web.user.service.api.BaseUserContext.getCurrentUser(request);
		User  currentUser = (User)userDetails;
		if(rpname!=null&&(currentUser.getOrg()!=null)){
		//model.addAttribute("reportUrl", gethCubleUrl()+"?repname="+rpname);
			//reportUrl=gethCubleUrl()+"?repname="+rpname+"&&para="+currentUser.getOrg().getId();
			System.out.println("userDetails.getUsername()"+gethCubleUrl()+"?repname="+rpname+".saiku"+"&&para="+currentUser.getOrg().getId());
			System.out.println("2222222222222222:"+currentUser.getOrg().getName());
			model.addAttribute("reportUrl", gethCubleUrl()+"?repname="+rpname+".saiku"+"&&para="+currentUser.getOrg().getId());
			}
		else if(rpname!=null&&(currentUser.getOrg()==null)){
			model.addAttribute("reportUrl", gethCubleUrl()+"?repname="+rpname+".saiku");
		    }
		else model.addAttribute("reportUrl", gethCubleUrl());
		
		if(rpname!=null&&rpname.equalsIgnoreCase(".action"))
			rpname = rpname.replace(".action", "");
		//System.out.println("userDetails.getUsername()"+((User)userDetails).getCreate_date());
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println("authentication.getPrincipal()"+authentication.getPrincipal());
//		User user = (User)authentication.getPrincipal();
//		System.out.println("user:"+user.getOrgIds());
//		System.out.println(gethCubleUrl()+"?repname="+rpname);
		
		return "/main.jsp";
	}

	public String gethCubleUrl() {
		return hCubleUrl;
	}
	
}
