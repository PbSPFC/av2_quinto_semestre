package br.com.zuuuum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zuuuum.persistence.entidade.Usuario;
import br.com.zuuuum.persistence.jdbc.UsuarioDAO;

@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x = req.getParameter("x");
		
		if(x.equals("cadastrar")){
			
			String nome = req.getParameter("nome");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			
			Usuario usuario = new Usuario( nome, login, senha);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.cadastrar(usuario);
			
			List<Usuario> lista = usuarioDAO.listar();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listar.jsp");
			dispacher.forward(req, resp);
			
		} else if(x.equals("novoCadastrar")){
			
			String nome = req.getParameter("nome");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			
			Usuario usuario = new Usuario( nome, login, senha);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.cadastrar(usuario);
			
			req.setAttribute("usuario", usuario);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/usuCadastrado.jsp");
			dispacher.forward(req, resp);
			
		}else if(x.equals("alterar")){
			
			Integer id;
			String nome = req.getParameter("nome");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");

			if(req.getParameter("id").equals("") == false){
				
				id = Integer.parseInt(req.getParameter("id"));
				Usuario usuario = new Usuario(id, nome, login, senha);
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.alterar(usuario);
				List<Usuario> lista = usuarioDAO.listar();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listar.jsp");
				dispacher.forward(req, resp);
				
			} else {
				
				Usuario usuario = new Usuario( nome, login, senha);
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.cadastrar(usuario);
				List<Usuario> lista = usuarioDAO.listar();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listar.jsp");
				dispacher.forward(req, resp);
				
			}
			
		} else if(x.equals("deletar")){
			
			Integer id;
			id = Integer.parseInt(req.getParameter("id"));
			Usuario usuario = new Usuario();
			usuario.setId(id);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.deletar(usuario);
			
			List<Usuario> lista = usuarioDAO.listar();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listar.jsp");
			dispacher.forward(req, resp);
			
		} else if(x.equals("listar")){
			
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.listar();
			
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listar.jsp");
			dispacher.forward(req, resp);
			
		} else {
			
			RequestDispatcher dispacher = req.getRequestDispatcher("login.html");
			dispacher.forward(req, resp);
			
		}
		
		
		
		
		
		
		
		
	}

}
