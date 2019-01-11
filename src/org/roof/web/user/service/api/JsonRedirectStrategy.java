package org.roof.web.user.service.api;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.roof.spring.Result;
import org.springframework.security.web.RedirectStrategy;

public class JsonRedirectStrategy implements RedirectStrategy {

	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		Result r = null;
		response.setContentType("application/json");
		if (StringUtils.equals(url, "/error")) {
			r = new Result(Result.FAIL, "用户名或者密码错误");
		} else {
			r = new Result(Result.SUCCESS, url);
		}

		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(Result.getStr(r).getBytes());
		outputStream.flush();

	}

}
