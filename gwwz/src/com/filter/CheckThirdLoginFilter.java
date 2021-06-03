package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.util.PublicToolCheckParam;

public class CheckThirdLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		String email = (String)session.getAttribute("email");
		if(!PublicToolCheckParam.checkNullAndEmpty(email)){
			((HttpServletRequest)request).getRequestDispatcher("../third.jsp").forward(request,response);
		}
		else{
			//¼ÌÐøÌø×ª
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
