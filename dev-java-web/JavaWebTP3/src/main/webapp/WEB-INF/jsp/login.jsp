<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <!--Arquivos CSS-->
        <link rel="stylesheet" href="css/login.css">
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&family=Poppins&display=swap" rel="stylesheet">
    </head>

    <body>
        <header class="page-header">
            <div class="top-bar-container">
                <a href="/">
                    <img src="images/back.svg" alt="Voltar" />
                </a>Login</strong>
                <img src="https://fontmeme.com/permalink/210901/9921a6a3d96e1926773953d0010f93b2.png" alt="CM Store" />
            </div>

            <div class="header-content">
                <strong>Efetuar login na plataforma</strong>
                <p>O primeiro passo é preencher esse formulário de login</p>
            </div>
        </header>
        <div id="page-place-form" class="container">
            <main>
                <form method="get" action="handleLogin">
                    <fieldset>
                        <legend>Dados de Login</legend>          
                        <c:if test="${msg != null}">
                            <legend>${msg}</legend>  
                        </c:if>      
                        <div class="input-block">
                            <label for="email">E-mail</label>
                            <input type="email" id="email" name="email" required />
                        </div>
                        <div class="input-block">
                            <label for="password">Senha</label>
                            <input type="password" id="password" name="password" required/>
                        </div>
                    </fieldset>

                    <footer>
                        <p>
                            <img src="images/warning.svg" alt="Aviso importante" />
                            Importante! <br />
                            Agora você pode realizar login
                        </p>
                        <button type="submit" id="submit">Confirmar</button>
                    </footer>
                </form>
            </main>
        </div>
    </body>
</html>