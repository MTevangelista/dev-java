<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet">
<title>Consulta</title>
</head>
<body>
    <div class="container">
	<h1>Consulta de Alunos</h1>
	<form method="get" action="procurar">
            <input type="text" name="keyword">
            <input type="submit" value="Procurar">
	</form>
	<h3><a href="cadastro">Novo aluno</a></h3>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Telefone</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista}" var="atributo"> 
                    <tr>
                        <td>${atributo.nome}</td>
                        <td>${atributo.telefone}</td>
                        <td>
                            <a href="alterar?id=${atributo.id}">Alterar</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="excluir?id=${atributo.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>