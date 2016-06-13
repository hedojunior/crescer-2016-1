<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="pessoa" method="GET" class="form-horizontal">
                <div class="form-group">
                    <label class="">Nome</label>
                    <input type="text" class= "form-control" name="pessoa.nome"/>
                </div>
                <div class="form-group">
                    <label>Idade</label>
                    <input type="number" class="form-control" name="pessoa.idade"/>
                </div>
                <div class="form-group sexo">
                    <label for=".sexo">Sexo:</label>
                    <label>Masculino</label>
                    <input type="radio" value ="Masculino" name="pessoa.sexo"/>
                    <label>Feminino</label>
                    <input type="radio" value ="Feminino" name="pessoa.sexo"/>
                    <label>Outros</label>
                    <input type="radio" value ="Outros" name="pessoa.sexo"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-info" type="submit">Enviar</button>
            </form>
        </div>
    </body>
</html>
