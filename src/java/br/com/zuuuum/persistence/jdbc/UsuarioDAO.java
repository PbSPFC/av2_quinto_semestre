package br.com.zuuuum.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zuuuum.persistence.entidade.Usuario;

public class UsuarioDAO {
	
	
	public void md5() {
		String sql = "update usuario set senha = md5(senha)";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha) values(?,?,md5(?))";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getLogin());
				stm.setString(3, usuario.getSenha());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=md5(?) where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setString(1, usuario.getNome());
				stm.setString(2, usuario.getLogin());
				stm.setString(3, usuario.getSenha());
				stm.setInt(4, usuario.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario){
		Integer id = usuario.getId();
		if(id == null){
			cadastrar(usuario);
		} else {
			alterar(usuario);
		}
	}
	
	public void deletar(Usuario usuario) {
		String sql = "delete from usuario where id=?";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)) {
				stm.setInt(1, usuario.getId());
				stm.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public List<Usuario> listar(){
		List<Usuario> usuario = new ArrayList<>();
		
		String sql = "select * from usuario order by id";

		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
				while(rs.next()){
					usuario.add(new Usuario(rs.getInt("id"), 
							rs.getString("nome"), 
							rs.getString("login"), 
							rs.getString("senha")));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	
	public Usuario autenticar(Usuario usu1){
		
		String sql = "select * from usuario where login=? and senha=md5(?)";
		
		try (Connection con = ConexaoFactory.getConnection()) {
			try (PreparedStatement stm = con.prepareStatement(sql)){
				stm.setString(1, usu1.getLogin());
				stm.setString(2, usu1.getSenha());
				
				ResultSet rs = stm.executeQuery();
				if(rs.next()){
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
					
					return usuario;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
