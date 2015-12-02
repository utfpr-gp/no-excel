package br.edu.utfpr.util;

import javax.servlet.http.HttpServletRequest;

public class Route {
	
	public static String getProjectUrl(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		return url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
	}

}
