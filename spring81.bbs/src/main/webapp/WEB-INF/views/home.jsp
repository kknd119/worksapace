<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <meta charset="utf-8" /> 
    <title>Home</title>
    
    <style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
    background-image: url('/resources/images/homegate.jpg');
    min-height: 100%;
    background-position: center;
    background-size: cover;
}

.w1-display-topleft{position:absolute;left:0;top:0}
.w1-display-middle{position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);-ms-transform:translate(-50%,-50%)}
.w1-animate-top{position:relative;animation:animatetop 0.4s}@keyframes animatetop{from{top:-300px;opacity:0} to{top:0;opacity:1}}
.w1-jumbo{font-size:64px!important}  
.w1-border-grey,.w1-hover-border-grey:hover,.w1-border-gray,.w1-hover-border-gray:hover{border-color:#9e9e9e!important}  
.w1-center{text-align:center!important} 
.w1-display-bottomleft{position:absolute;left:0;bottom:0}
.w1-padding-large{padding:12px 24px!important}
.w1-text-white,.w1-hover-text-white:hover{color:#fff!important}
    </style>
</head>
<body>

<body>

<div class="bgimg w1-display-container w1-animate-opacity w1-text-white">
  <div class="w1-display-topleft w1-padding-large w1-xlarge">
    Logo
  </div>
  <div class="w1-display-middle">
    <h1 class="w1-jumbo w1-animate-top">Shopping.com</h1>
    <hr class="w1-border-grey" style="margin:auto;width:40%">
    <a href="http://localhost:8080/company/index"><p class="w1-large w1-center">E.N.T.E.R</p></a>
  </div>
  <div class="w1-display-bottomleft w1-padding-large">
    Powered by <a href="https://www.w1schools.com/w1css/default.asp" target="_blank">w1.css</a>
  </div>
</div>

</body>
</html>