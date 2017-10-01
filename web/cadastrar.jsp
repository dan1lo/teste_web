<%-- 
    Document   : cadastrar.jsp
    Created on : 30/09/2017, 08:54:25
    Author     : danilomonteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualizar Pessoa</h1>
        <h2> <a href="index.html"> Página inicial </a></h2>
        <div><form action="ControllerPessoa?action=cadastrarPessoa" method='post' >
                        Nome: <input type="text" name="nome"> <br>
                        Nível: <input type="text" name="nivel"> <br>
                        Senha: <input type="text" name="senha"> <br>
                        <input type='submit' value="enviar">
                     </form>
            
                </div>
    </body>
      <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
