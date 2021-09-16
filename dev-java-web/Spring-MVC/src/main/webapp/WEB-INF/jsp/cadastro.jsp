<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Cadastro</title>
    </head>
    <body>
        <div class="container"> 
            <div class="col-md-6 cadastro">
                <h1>Cadastro de Aluno</h1>
                <div>
                    <form action="cadastrar" method="post">
                        <div class="form-group">
                            Nome
                            <input type="text" name="nome" id="nome" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            Telefone
                            <input type="text" name="telefone" id="telefone" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <input type="submit" id="submit" class="btn-primary" value="Cadastrar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
