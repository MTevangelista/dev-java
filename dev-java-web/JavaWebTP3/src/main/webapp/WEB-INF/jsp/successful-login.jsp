<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Successful register</title>
        <!--Arquivos CSS-->
        <link rel="stylesheet" href="css/signup.css">
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&family=Poppins&display=swap" rel="stylesheet">
    </head>

    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="images/back.svg" alt="Voltar" />
                </a>
                <strong>Successful register</strong>
                <img src="https://fontmeme.com/permalink/210901/9921a6a3d96e1926773953d0010f93b2.png" alt="CM Store" />
            </div>

            <div class="header-content">
                <strong>Parabéns, ${user.name}!</strong>
                <p>O seu login foi realizado com sucesso</p>
            </div>
        </header>
    </body>
</html>