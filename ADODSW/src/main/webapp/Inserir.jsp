<%@page import="controller.Crud"%>
<%@page import="controller.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
<%
    try {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setCpf(request.getParameter("cpf"));

        Crud cr = new Crud();
        cr.cadastro(usuario);

        out.print("Usuário cadastrado com sucesso: " + usuario.getNome());
    } catch (Exception e) {
        e.printStackTrace();
        out.print("Erro ao cadastrar usuário.");
    }
%>
</body>
</html>
