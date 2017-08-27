package br.com.zuuuum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zuuuum.persistence.entidade.Jogador;
import br.com.zuuuum.persistence.jdbc.JogadorDAO;

@WebServlet("/jogcontroller")
public class JogadorController extends HttpServlet {

	public JogadorController() {
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
			Integer idade = Integer.parseInt(req.getParameter("idade"));
			Integer gols = Integer.parseInt(req.getParameter("gols"));
			
			Jogador jogador = new Jogador(nome, idade, gols);
			JogadorDAO jogadorDAO = new JogadorDAO();
			jogadorDAO.cadastrar(jogador);
			
			List<Jogador> lista = jogadorDAO.listar();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listarJogador.jsp");
			dispacher.forward(req, resp);
			
		} else if(x.equals("alterar")){
			
			Integer id;
			String nome = req.getParameter("nome");
			Integer idade = Integer.parseInt(req.getParameter("idade"));
			Integer gols = Integer.parseInt(req.getParameter("gols"));

			if(req.getParameter("id").equals("") == false){
				
				id = Integer.parseInt(req.getParameter("id"));
				Jogador jogador = new Jogador(id, nome, idade, gols);
				JogadorDAO jogadorDAO = new JogadorDAO();
				jogadorDAO.alterar(jogador);
				List<Jogador> lista = jogadorDAO.listar();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listarJogador.jsp");
				dispacher.forward(req, resp);
				
			} else {
				
				Jogador jogador = new Jogador( nome, idade, gols);
				JogadorDAO jogadorDAO = new JogadorDAO();
				jogadorDAO.cadastrar(jogador);
				List<Jogador> lista = jogadorDAO.listar();
				req.setAttribute("lista", lista);
				RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listarJogador.jsp");
				dispacher.forward(req, resp);
				
			}
			
		} else if(x.equals("deletar")){
			
			Integer id;
			id = Integer.parseInt(req.getParameter("id"));
			Jogador jogador = new Jogador();
			jogador.setId(id);
			JogadorDAO jogadorDAO = new JogadorDAO();
			jogadorDAO.deletar(jogador);
			
			List<Jogador> lista = jogadorDAO.listar();
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listarJogador.jsp");
			dispacher.forward(req, resp);
			
		} else if(x.equals("listar")){
			
			JogadorDAO dao = new JogadorDAO();
			List<Jogador> lista = dao.listar();
			
			req.setAttribute("lista", lista);
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listarJogador.jsp");
			dispacher.forward(req, resp);
			
		} else {
			
			RequestDispatcher dispacher = req.getRequestDispatcher("login.html");
			dispacher.forward(req, resp);
			
		}
		
		
		
		
		
		
		
		
	}

}
