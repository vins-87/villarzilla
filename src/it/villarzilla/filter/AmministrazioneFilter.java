package it.villarzilla.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.villarzilla.manager.AmministrazioneManager;

@WebFilter("/portaleAdmin/*")
public class AmministrazioneFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		AmministrazioneManager loginBean = (AmministrazioneManager)((HttpServletRequest)request).getSession().getAttribute("adminManager");

		if (loginBean == null || !loginBean.isLogged()) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/loginAdmin.xhtml");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// DEVE rimanere vuoto
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// DEVE rimanere vuoto
	}

}