<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="br.com.hedo.aula4.Pessoa"%>
<%@page import="br.com.hedo.aula4.PessoaDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>Cadastro Pessoa</title>
        <style>
            form:first-of-type{
                margin-top: 30px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="pessoa" method="POST">
                <div class="form-group col-md-10">
                    <label for="inputNome">Nome</label>
                    <input type="text" id="inputNome" class= "form-control" name="pessoa.nome" placeholder="Ex. Maria José da Silva"/>
                </div>
                <div class="form-group col-md-8">
                    <label for="inputIdade">Idade</label>
                    <input type="number" id="inputIdade" class="form-control" name="pessoa.idade" placeholder="Ex. 48" min="0"/>
                </div>
                <div class="radio col-md-4">
                    <label>
                        <input type="radio" value ="Masculino" name="pessoa.sexo"/>
                        Masculino
                    </label>
                </div>
                <div class="radio col-md-4">
                    <label>
                        <input type="radio" value ="Feminino" name="pessoa.sexo"/>
                        Feminino
                    </label>
                </div>
                <div class="radio col-md-4">
                    <label>
                        <input type="radio" value ="Outros" name="pessoa.sexo"/>
                        Outros
                    </label>
                </div>
                <div class="form-group col-md-5">
                    <button class="btn btn-info" type="submit">Enviar</button>
            </form>
        </div> 

        <table class="table table-striped">
            <thead class="thead-inverse">
                <tr>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Sexo</th>
                </tr>
            </thead>

            <%
                List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
                request.setAttribute("pessoas",pessoas);
            %>
            <tbody>
                <c:forEach items="${pessoas}" var="Pessoas">
                    <tr>
                        <td>
                            ${Pessoas.nome}
                        </td>
                        <td>
                            ${Pessoas.idade}
                        </td>
                        <td>
                            ${Pessoas.sexo}
                        </td>
                    </tr>
                </c:forEach>
            <tbody>
        </table>
    </body>
</html>
