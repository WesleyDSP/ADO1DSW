package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConectorDAO;

public class Crud {
	
	private String sql;
	private Connection con;
	private PreparedStatement pdst;
	ArrayList<Usuario> usuarios;
	ResultSet rs;
	
	public void cadastro(Usuario usuario) {
		sql = "INSERT INTO usuario (nome_usuario, cpf, email, senha) VALUES (?, ?, ?, ?)";
		try {
			con = ConectorDAO.conecta();
			pdst = con.prepareStatement(sql);
			pdst.setString(1, usuario.getNome());
			pdst.setString(2, usuario.getCpf());
			pdst.setString(3, usuario.getEmail());
			pdst.setString(4, usuario.getSenha());
			pdst.execute();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> busca() {
		sql = "SELECT * FROM USUARIO";
		usuarios = new ArrayList<>();
		try {
			con = ConectorDAO.conecta();
			pdst = con.prepareStatement(sql);
			rs = pdst.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
