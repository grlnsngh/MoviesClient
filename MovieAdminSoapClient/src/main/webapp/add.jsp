<%-- 
    Document   : add
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
        <title>Add Movie</title>
        <script>
            function validateForm() {
                var title = document.forms["myForm"]["title"].value;
                var producer = document.forms["myForm"]["producer"].value;
                var director = document.forms["myForm"]["director"].value;
                if (title == "") {
                    alert("Title must be filled out");
                    return false;
                }
                if (allLetter(producer)) {
                    alert("No numeric characters allowed in Producer");
                    return false;
                }
                if (allLetter(director)) {
                    alert("No numeric characters allowed in Director");
                    return false;
                }
            }
            function allLetter(inputtxt)
            {
                var letters = /^[A-Za-z]+$/;
                if (inputtxt.value.match(letters))
                {
                    return true;
                } else
                {
                    return false;
                }
            }
        </script>
    </head>
    <body>

        <form name="myForm" class="box" action="Servlet" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
            <h1>Add movie</h1> 
            <input type="text" name="title" placeholder="Title"/>            
            <input type="text" name="producer" placeholder="Producer"/>
            <input type="text" name="director" placeholder="Director"/>
            <div class="upload-btn-wrapper">
                <button class="btn">Upload Image</button>
                <input type="file" name="img" placeholder="Image"/>
            </div>

            <input type="submit" name="add"  value="Add"/>

            <div style="color: #FFFFFF">
                ${handlerError}
                ${imageError}
            </div>
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
