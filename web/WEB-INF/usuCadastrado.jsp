
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="br.com.zuuuum.persistence.entidade.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Cadastro efetuado com sucesso</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        </style>
    </head>
    <body class="w3-light-grey">
        <div align="center" class="w3-panel w3-red w3-leftbar w3-padding-32">
            <h1><%= usuario.getNome()%>, seu cadastro foi efetuado com sucesso!</h1>
            <a href="login.html" class="w3-btn w3-padding-large">Voltar</a><br /> 
        </div>

    </body>
</html>
