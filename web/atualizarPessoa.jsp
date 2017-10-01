<%-- 
    Document   : atualizarPessoa.jsp
    Created on : 30/09/2017, 22:36:31
    Author     : danilomonteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
        <table border=1>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Senha</th>
                <th>Nível</th>
                <th>Ação</th>
            
            </tr>
          
                <c:forEach items="${pessoas}" var="pessoa">
                    <tr id="pessoa">
                        <td class ="td-id"><c:out value="${pessoa.id}"/></td>
                        <td class="td-nome"><c:out value="${pessoa.nome}"/></td>
                        <td class="td-senha"><c:out value="${pessoa.senha}" /></td>
                        <td class="td-nivel"><c:out value="${pessoa.nivel}" /></td>

                        
                    </tr>    
                    
                    
                    
                </c:forEach>
                
                
           
            
        </table>
        <form method="post" action="ControllerPessoa?action=atualizar">
            
            <div class="grupo">
		<label for="nome"> Nome: </label>
		<input type="text" name="nome"
                        class="ipt-nome">
                <br>
                <label for="nome"> nível: </label>
		<input type="text" name="nivel"
                       class="ipt-nivel">
                <label for="nome"> senha: </label>
		<input type="text" name="senha"
                       placeholder="Senha" class="ipt-senha">
                <input type="hidden" name="id" value="" class ="ipt-id">
                
                <input type="submit" value="Enviar">
               
	    </div>
        </form>
       <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <script src="js/form.js"></script>
    </body>
</html>
