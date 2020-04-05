<%-- 
    Document   : login
    Author     : grlns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" type="text/css" href="component.css" />
        <link rel="stylesheet" type="text/css" href="normalize.css" />
        <title>Update Movie</title>
    </head>
    <body>

        <form class="box" action="Servlet" method="post" enctype="multipart/form-data">
            <h1>Update movie</h1> 
            <input type="text" name="title" placeholder="Title" value="${movies.title}" />
            <input type="text" name="producer" placeholder="Producer" value="${movies.producer}"/>
            <input type="text" name="director" placeholder="Director" value="${movies.director}"/>
            <div class="upload-btn-wrapper">
                <button class="btn">Upload Image</button>
                <input type="file" name="img" placeholder="Image"  value="${movies.image}"/>
            </div>
            <input type="submit" name="updateMovie"  value="Update"/>
            <!--            <a href="http://www.cakecounter.com/" target="_blank" type="submit">Add</a>-->
        </form>

        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
    </body>
</html>
