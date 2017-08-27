<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="br.com.zuuuum.persistence.entidade.*" %>
<%
    List<Jogador> lista = (List<Jogador>) request.getAttribute("lista");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista</title>
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
            <h1>Lista de Jogadores</h1>
            <br />
            <img border="1" alt="jogador" src="img/jogador.png" width="172px" height="256px"/>
            <br />
            <fieldset>
                <legend align="center">Alteração e Exclusão</legend>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Gols</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                    </tr>
                    <% for (Jogador jogador : lista) {%>
                    <tr>
                    <form action="jogcontroller" method="post">
                        <td>Id: <%=jogador.getId()%><input type="hidden" name="id" value="<%=jogador.getId()%>" /></td>
                        <td>Nome: <input type="text" name="nome" value="<%=jogador.getNome()%>" class="w3-input w3-border"  placeholder="Nome"/></td>
                        <td>Idade: <input type="text" name="idade" value="<%=jogador.getIdade()%>" class="w3-input w3-border"  placeholder="Idade"/></td>
                        <td>Gols: <input type="text" name="gols" value="<%=jogador.getGols()%>" class="w3-input w3-border"  placeholder="Gols"/></td>
                        <input type="hidden" name="x" value="alterar"/>
                        <td><input type="submit" value="Alterar" class="w3-btn w3-dark-grey w3-margin-top"/></td>
                    </form>
                    <form action="jogcontroller" method="post">
                        <input type="hidden" name="id" value="<%=jogador.getId()%>"/>
                        <input type="hidden" name="x" value="deletar"/>
                        <td><input type="submit" value="Deletar" class="w3-btn w3-dark-grey w3-margin-top"/></td>
                    </form>
                    </tr>
                    <% }%>
                </table>
            </fieldset>
            <fieldset>
                <legend align="center">Novo Jogador</legend>
                <table border="1">
                    <tr>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Gols</th>
                        <th>Cadastrar</th>
                    </tr>
                    <tr>
                    <form action="jogcontroller" method="post">
                        <td>Nome: <input type="text" name="nome" value="" class="w3-input w3-border"  placeholder="Nome"/></td>
                        <td>Idade: <input type="text" name="idade" value="" class="w3-input w3-border"  placeholder="Idade"/></td>
                        <td>Gols: <input type="text" name="gols" value="" class="w3-input w3-border"  placeholder="Gols"/></td>
                        <input type="hidden" name="x" value="cadastrar"/>
                        <td><input type="submit" value="cadastrar" class="w3-btn w3-dark-grey w3-margin-top"/></td>
                        </tr>
                </table>
            </fieldset>
            <a href="profile.jsp">Voltar</a>
        </div>
    </body>
</html>