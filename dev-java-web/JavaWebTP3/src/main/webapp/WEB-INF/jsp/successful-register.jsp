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
                <img src="images/logo.png" alt="CM Store" />
            </div>

            <div class="header-content">
                <strong>Parabéns, ${user.name}!</strong>
                <p>O seu cadastro foi realizado com sucesso</p>
            </div>
        </header>
        <div id="page-place-form" class="container">
            <main>
                <form method="post" action="goToLogin">
                    <fieldset>
                        <legend>Sobre seus dados</legend>

                        <div class="input-block">
                            <label for="name">Nome</label>
                            <input type="text" id="name" name="name" value="${user.name}" disabled/>
                        </div>
                        <div class="input-block">
                            <label for="email">E-mail</label>
                            <input type="email" id="email" name="email" value="${user.email}" disabled/>
                        </div>
                    </fieldset>

                    <footer>
                        <p>
                            <img src="images/warning.svg" alt="Aviso importante" />
                            Importante! <br />
                            Agora você pode realizar login
                        </p>
                        <button type="submit" id="submit">Ir para tela de login</button>
                    </footer>
                </form>
            </main>
        </div>
    </body>
</html>