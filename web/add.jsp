
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h3>Agregar Nuevo Usuario</h3>
        <hr>
        <br>
        <form action="Controlador" method="POST">
            <label>Nombres:</label>
            <input type="text" name="txtNom">
            <label>Dni:</label>
            <input type="number" name="txtDni">
            <input type="submit" name="accion" value="Guardar">
            <input type="submit" name="accion" value="Regresar">
        </form>
    </center>
    </body>
</html>
