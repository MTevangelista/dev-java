<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Alterar</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-6 alterar">
                <h1>Alteração dos dados do aluno</h1>
                <form:form action="salvaraluno" method="post" modelAttribute="aluno">
                    <div class="form-group">
                        ID: ${aluno.id}
                        <form:hidden path="id" class="form-control"/>
                    </div>
                    <div class="form-group">
                        Nome: ${aluno.nome}
                        <form:input path="nome" class="form-control"/>
                    </div>
                    <div class="form-group">
                        Telefone: ${aluno.telefone}
                        <form:input path="telefone" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" id="submit" class="btn-primary" value="Salvar">
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
