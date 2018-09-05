<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Ejemplo de JdbcTemplate</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Tabla base de datos connect</h1>
                <p>
                    <a href="<c:url value="anadir.htm" />" class="btn btn-success"> Agregar estudiante</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Cedula</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Correo</th>
                            <th>N carnet</th>
                            <th>Nivel est</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id_estudiante}" /></td>
                                <td><c:out value="${dato.nombres}" /></td>
                                <td><c:out value="${dato.apellidos}" /></td>
                                <td><c:out value="${dato.correo}" /></td>
                                <td><c:out value="${dato.codigo_carnet}" /></td>
                                <td><c:out value="${dato.id_nivel_estudio}" /></td>
                                <td>
                                    <a href="<c:url value="editar.htm?id=${dato.id_estudiante}" />">Editar</a>
                                    <a href="<c:url value="eliminar.htm?id=${dato.id_estudiante}" />">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </body>
</html>
