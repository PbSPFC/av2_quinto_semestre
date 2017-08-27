<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="br.com.zuuuum.persistence.entidade.*" %>
<%
    session = request.getSession();
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        </style>
    </head>

    <body class="w3-light-grey">
        <div align="center" class="w3-container w3-padding-32 w3-red w3-opacity w3-card-2 w3-hover-opacity-off" style="margin:32px 0;">
            <fieldset>
                <legend align="center">Bem vindo <%= usuario.getNome()%>!!!</legend>
                <br /> 
                <img border="1" alt="User" src="img/user.png" width="128px" height="128px"/>
                <img border="1" alt="Jogador" src="img/jogador.png" width="96" height="128px"/>
                <br />
                <a href="formUsuario.html" class="w3-btn w3-dark-grey w3-margin-top">Cadastrar Usuário</a><br /> 
                <a href="formJogador.html" class="w3-btn w3-dark-grey w3-margin-top">Cadastrar Jogador</a><br /> 
                <a href="alterar.html" class="w3-btn w3-dark-grey w3-margin-top">Alterar Usuário</a><br />
                <a href="deletar.html" class="w3-btn w3-dark-grey w3-margin-top">Deletar Usuário</a><br />
                <form action="usucontroller" method="post">
                    <input type="hidden" name="x" value="listar" /> 
                    <input type="submit" value="Listar Usuários" class="w3-btn w3-dark-grey w3-margin-top"/>
                </form>
                <form action="jogcontroller" method="post">
                    <input type="hidden" name="x" value="listar" /> 
                    <input type="submit" value="Listar Jogadores" class="w3-btn w3-dark-grey w3-margin-top"/>
                </form>
                <br /> 

            </fieldset>
            <br />
            <form action="logincontroller" method="get">
                <input type="hidden" name="x" value="logout"/> 
                <input type="submit" value="Logout" class="w3-btn w3-padding-large"/>
            </form>

        </div>
    </body>
</html>