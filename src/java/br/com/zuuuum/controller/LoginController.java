package br.com.zuuuum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.zuuuum.persistence.entidade.Usuario;
import br.com.zuuuum.persistence.jdbc.UsuarioDAO;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sessao = req.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(login, senha);
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuarioAutenticado = dao.autenticar(usuario);
		
		if(usuarioAutenticado != null){
			
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuario", usuarioAutenticado);
			sessao.setMaxInactiveInterval(60*5);
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
			
		} else {
			resp.getWriter().print("<script> window.alert('Login ou senha invalidos!');"
					+ "location.href='login.html';</script>");
		}
		
	}
	
}
