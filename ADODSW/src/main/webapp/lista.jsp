<%@page import="java.sql.SQLException"%>
<%@page import="controller.*"%>
<%@page import="java.util.ArrayList;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busca</title>
</head>
<body>

	<%
		try {
			Crud busca = new Crud();
			ArrayList<Usuario> lista = busca.busca();
			for (Usuario usuario : lista) {
				out.println("Código: " + usuario.getId_usuario() + ": Nome: " + usuario.getNome());
				out.println(" CPF: " + usuario.getCpf());
				out.println(" Email: " + usuario.getEmail());
				out.println(" Senha: " + usuario.getSenha());
				out.println("<br><br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

</body>
</html>

