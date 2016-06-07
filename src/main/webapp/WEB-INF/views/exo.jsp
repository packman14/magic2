<%-- 
    Document   : exo
    Created on : 7 juin 2016, 14:52:14
    Author     : ajc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script lang="javascript">
            function logging(msg)
            {
                alert('logging= '+msg);
            }
            </script>
    </head>
    <body>
        <h1 onmouseout="alert('BITE');", onmouseover="alert('CHATTE');">Hello World!</h1>
    </body>
</html>
