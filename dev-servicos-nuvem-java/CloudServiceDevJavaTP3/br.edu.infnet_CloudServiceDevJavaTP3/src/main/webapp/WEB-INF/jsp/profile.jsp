<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile</title>
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
                <strong>Profile</strong>
                <img src="images/logo.png" alt="CM Store" />
            </div>

            <div class="header-content">
                <strong>Cadastre-se na plataforma</strong>
                <p>O primeiro passo ? preencher esse formul?rio de cadastro</p>
            </div>
        </header>
        <div id="page-place-form" class="container">
            <main>
                <form method="post" action="handleUpdateUser">
                    <fieldset>
                        <legend>Sobre seus dados</legend>
                        <c:if test="${errorMessage != null}">
                            <legend class="error-message">${errorMessage}</legend>  
                        </c:if>   
                        
                            
                        <div class="input-block">
                            <input type="number" id="id" name="id" value="${user.id}" hidden/>
                        </div>    
                        <div class="input-block">
                            <label for="name">Nome</label>
                            <input type="text" id="name" name="name" value="${user.name}" required/>
                        </div>
                        <div class="input-block">
                            <label for="email">E-mail</label>
                            <input type="email" id="email" name="email" value="${user.email}" />
                        </div>
                        <div class="input-block">
                            <label for="phone">Telefone</label>
                            <input type="number" id="phone" name="phone" value="${user.phone}" required/>
                        </div>
                        <div class="input-block">
                            <label for="cep">CEP</label>
                            <input type="text" id="cep" name="cep" value="${user.cep}" required/>
                        </div>    
                        <div class="input-block">
                            <label for="address">Endere?o</label>
                            <input type="text" id="address" name="address" value="${user.address}" disabled/>
                        </div>
                    </fieldset>

                    <footer>
                        <p>
                            <img src="images/warning.svg" alt="Aviso importante" />
                            Importante! <br />
                            Preencha todos os dados
                        </p>
                        <button type="submit" id="submit">Salvar</button>
                    </footer>
                </form>
            </main>
        </div>
    </body>
</html>