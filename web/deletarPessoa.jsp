<%-- 
    Document   : deletarPessoa.jsp
    Created on : 30/09/2017, 16:20:44
    Author     : danilomonteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <h1>Deletar Pessoa</h1>
        <h2> <a href="index.html"> Página inicial </a></h2>
        <table>
            <tr>
                <th>Pessoa Id</th>
                <th>Nome</th>
                <th>nivel</th>
                <th>senha</th>
                <th>acao</th>
            </tr>
            <tbody>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td><c:out value="${pessoa.id}"/></td>
                    <td><c:out value="${pessoa.nome}"/></td>
                    <td><c:out value="${pessoa.nivel}"/></td>
                    <td><c:out value="${pessoa.senha}"/></td>
                    <td> <form method="post" action="ControllerPessoa?action=deletar"> 
                            <input type="hidden" name="id" value="${pessoa.id}"> 
                            <input type="submit" value="deletar"> 
                        
                        </form> 
                </tr>               
                               
         
            </c:forEach>
        </tbody>
            
            
        </table>
    </body>
      <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
