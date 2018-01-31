<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>쇼핑몰</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/css.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <a href="index.html"><h3 class="w3-wide"><b>쇼핑닷컴</b></h3></a>
  </div>
  <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
    <a href="#" class="w3-bar-item w3-button">셔츠</a>
    <a href="#" class="w3-bar-item w3-button">바지</a>
    <a href="#" class="w3-bar-item w3-button">모자</a>   
    <a href="#" class="w3-bar-item w3-button">신발</a>
   
  </div>
  <a href="http://localhost:8080/user/login" class="w3-bar-item w3-button w3-padding">로그인</a>
  <a href="http://localhost:8080/company/mycompany" class="w3-bar-item w3-button w3-padding">쇼핑닷컴 소개</a>
  <a href="http://localhost:8080/company/contactus"  class="w3-bar-item w3-button w3-padding">찾아오시는길</a>
  <a href="http://localhost:8080/board/boardlist" class="w3-bar-item w3-button w3-padding">패션 커뮤니티</a>

   <a href="http:www.facebook.com" class="w3-bar-item w3-button w3-padding">페이스북<i class="fa fa-facebook-official w3-hover-opacity w3-large"></i></a>
   <a href="http:www.instagram.com" class="w3-bar-item w3-button w3-padding">인스타그램<i class="fa fa-instagram w3-hover-opacity w3-large"></i></a>
   <a href="http:www.twitter.com" class="w3-bar-item w3-button w3-padding">트위터<i class="fa fa-twitter w3-hover-opacity w3-large"></i></a>
  <a href="#footer" class="w3-bar-item w3-button w3-padding">Contact</a>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding" onclick="document.getElementById('newsletter').style.display='block'">간편로그인</a>
  <a href="#footer"  class="w3-bar-item w3-button w3-padding">Subscribe</a>
</nav>

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">쇼핑닷컴</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>

  <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left">쇼핑닷컴 오픈</p>
       
    <p class="w3-right">
    <c:if test="${not empty key}">
      <a href="http://localhost:8080/company/my" style="color: red">나의 장바구니<i class="fa fa-shopping-cart w3-margin-right"></i></a>
    </c:if>  
      <a href="http://www.naver.com">검색<i class="fa fa-search"></i></a>
    </p>
  </header>

  <!-- Image header -->
  <div class="w3-display-container w3-container">
    <img src="/resources/images/Koala.jpg" alt="main" style="width:100%">
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
      <h1 class="w3-jumbo w3-hide-small">쇼핑닷컴</h1>
      <h1 class="w3-hide-large w3-hide-medium">겨울 신상 세일</h1>
      <h1 class="w3-hide-small">COLLECTION 2018</h1>
      <p><a href="newsale.html" class="w3-button w3-black w3-padding-large w3-large">인기신상</a></p>
    </div>
  </div>

   <!-- End page content -->
</div>

<!-- Newsletter Modal -->
<div id="newsletter" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('newsletter').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">간편 로그인</h2>
      <p>간편하게 로그인 하세요</p>
      <p><input class="w3-input w3-border" type="text" placeholder="아이디"></p>
      <p><input class="w3-input w3-border" type="text" placeholder="비밀번호"></p>
      <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom" onclick="document.getElementById('newsletter').style.display='none'">확인</button>
      <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom" onclick="document.getElementById('newsletter').style.display='none'">취소</button>
    </div>
  </div>
</div>

<script>
// Accordion
function myAccFunc() {
    var x = document.getElementById("demoAcc");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

// Click on the "Jeans" link on page load to open the accordion for demo purposes
document.getElementById("myBtn").click();


// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}
</script>

</body>
</html>
