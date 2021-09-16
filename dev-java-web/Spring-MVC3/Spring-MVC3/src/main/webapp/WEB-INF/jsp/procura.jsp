<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Procura</title>
    </head>
    <body>
        <div class="container">
            <h1>Procura de Alunos</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Telefone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${result}" var="aluno">
                        <tr>
                            <td>${aluno.nome}</td>
                            <td>${aluno.telefone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>    
            <a href="/">Voltar</a> 
        </div>
    </body>
</html>
