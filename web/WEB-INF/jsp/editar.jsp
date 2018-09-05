<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Hola desde Spring Web MVC</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Listado de productos</a></li>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="estudiantes">
                            <h1>Complete el formulario</h1>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nombres">Nombre:</form:label>
                                <form:input path="nombres" cssClass="form-control" />
                                
                            </p>
                            <p>
                                <form:label path="apellidos">Apellidos</form:label>
                                <form:input path="apellidos" cssClass="form-control" />
                                
                            </p>
                            <p>
                                <form:label path="correo">Correo electrónico</form:label>
                                <form:input path="correo" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="codigo_carnet">Teléfono</form:label>
                                <form:input path="codigo_carnet" cssClass="form-control" />
                            </p>
                           <p>
                                <form:label path="id_nivel_estudio">Teléfono</form:label>
                                <form:input path="id_nivel_estudio" cssClass="form-control" />
                            </p>
                            <hr />
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
