package br.com.zuuuum.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes={DispatcherType.REQUEST}, urlPatterns="/*")
public class FilterAutentic implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession sessao = req.getSession(false);
		
		String uri = req.getRequestURI();
		
		if(sessao != null ||uri.lastIndexOf("login.html") != -1 || 
			uri.lastIndexOf("logincontroller") != -1 ||
                        uri.lastIndexOf("novoCadastro.html") != -1 ||
                        uri.lastIndexOf("usucontroller") != -1 ||
                        uri.lastIndexOf("usuCadastrado.jsp") != -1 ){
			
			chain.doFilter(req, resp);
			
		} else {
			resp.sendRedirect("login.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
