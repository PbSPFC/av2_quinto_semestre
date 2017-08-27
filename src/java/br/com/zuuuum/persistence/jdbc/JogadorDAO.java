package br.com.zuuuum.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zuuuum.persistence.entidade.Jogador;

public class JogadorDAO {

    public void md5() {
        String sql = "update jogador set gols = md5(gols)";

        try (Connection con = ConexaoFactory.getConnection()) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Jogador jogador) {
        String sql = "insert into jogador (nome, idade, gols) values(?,?,?)";

        try (Connection con = ConexaoFactory.getConnection()) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, jogador.getNome());
                stm.setInt(2, jogador.getIdade());
                stm.setInt(3, jogador.getGols());
                stm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Jogador jogador) {
        String sql = "update jogador set nome=?, idade=?, gols=? where id=?";

        try (Connection con = ConexaoFactory.getConnection()) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, jogador.getNome());
                stm.setInt(2, jogador.getIdade());
                stm.setInt(3, jogador.getGols());
                stm.setInt(4, jogador.getId());
                stm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Jogador jogador) {
        Integer id = jogador.getId();
        if (id == null) {
            cadastrar(jogador);
        } else {
            alterar(jogador);
        }
    }

    public void deletar(Jogador jogador) {
        String sql = "delete from jogador where id=?";

        try (Connection con = ConexaoFactory.getConnection()) {
            try (PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setInt(1, jogador.getId());
                stm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Jogador> listar() {
        List<Jogador> jogador = new ArrayList<>();

        String sql = "select * from jogador order by id";

        try (Connection con = ConexaoFactory.getConnection()) {
            try (PreparedStatement stm = con.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    jogador.add(new Jogador(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getInt("gols")));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jogador;
    }

}
