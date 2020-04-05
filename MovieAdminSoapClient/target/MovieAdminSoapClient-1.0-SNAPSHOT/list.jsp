<%-- 
    Document   : list
    Author     : grlns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Raleway:200,400,800' rel='stylesheet' type='text/css'>        
        <link rel="stylesheet" type="text/css" href="demo.css" />
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" type="text/css" href="component.css" />
        <link rel="stylesheet" type="text/css" href="normalize.css" />        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">        
        <title>View Movies</title>
    </head>
    <body>
        <a href="add.jsp" class="btn btn-success btnS" style="margin-top: 30px; margin-left: 60px;">Add New Movie</a>
        <table border="1" class="dataframe data" style="margin-bottom: 60px;">
            <thead>
                <tr style="text-align: right;">                    
                    <th>TITLE</th>
                    <th>ID</th>
                    <th>PRODUCER</th>
                    <th>DIRECTOR</th>
                    <th>DELETE</th>
                    <th>UPDATE</th>
                </tr>
            </thead>
            <tbody>
            <form action="Servlet" method="post" enctype="multipart/form-data">
                <c:forEach var="list" items="${movies}">
                    <tr>
                        <th scope="row">${list.title}</th>
                        <td>${list.id}</td>
                        <td>${list.producer}</td>
                        <td>${list.director}</td>
                        <td><button class="btn btn-success btnS" type="submit" name="deleteid" value="${list.id}" class="btn"><i class="fa fa-trash"></i></button></td>
                        <td><button class="btn btn-success btnS" type="submit" name="updateid" value="${list.id}" class="btn"><i class="fa fa-edit"></i></button></td>
                    </tr>
                </c:forEach>
            </form>
            <tbody>
        </table>

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