<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">

  .w3-display-middle{position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);}
    .w3-black, .w3-hover-black:hover{
      color: #fff!important;
    background-color: #000!important;

    }
    .w3-bar{width: 100%;
    overflow: hidden;

    }
    .w3-bar .w3-button {
    white-space: normal;
}

.w3-bar .w3-bar-item {
    padding: 8px 16px;
    float: left;
    width: auto;
    border: none;
    display: block;
}


.w3-red, .w3-hover-red:hover {
    color: #fff!important;
    background-color: #f44336!important;
}
.myLink {
    display: none;
}

.w3-white, .w3-hover-white:hover {
    color: #000!important;
    background-color: #fff!important;
}

.w3-padding-16 {
    padding-top: 16px!important;
    padding-bottom: 16px!important;
}


.w3-container, .w3-panel {
    padding: 0.01em 16px;
}
table{ border: 1px black solid }
.w3-border {
    border: 1px solid #ccc!important;
}

.w3-input {
    padding: 8px;
    display: block;
    border: none;
    border-bottom: 1px solid #ccc;
    width: 200px;
}
.w3-light-grey{color:#000!important;background-color:#f1f1f1!important}

.table{padding:20px;}
.table_rent{width:900px;}
.table_person{width:800px;}
.table_book{width:800px;}

th {width: 120px}
td {width: 120px}
input { width: 200px
    
}

</style>
   <script src="/resources/js/jquery-3.1.1.js"></script>
    <!-- ajax를 이용해보자 -->
    <script src="/resources/js/ajaxsetup.js"></script>



</head>
<body class="w3-light-grey" style="width: 1500px height:1500px; position:absolute;">
<div style="width: 1000px;height: 500px">
<div>
  <div style="top: 500px">
<div class="header" >
 
<button>회원등록</button>
<button>책등록</button>
<button>새로고침</button>
<button>프로그램 종료</button>
</div>
<div>
<table class='table_header'>
 <tr>
  <th>이름</th>
  <th>책 제목</th>
  <th>대여 날짜</th>
 </tr>
 <tr>
  <td></td>
  <td></td>
  <td></td>
</table>
</div>
</div>

<div class="w3-black w3-hover-black" style="float: left;">
  <div class="w3-display-middle" style="width: 950px;height: 500px; left: 500px; top: 400px">
  <div class="w3-bar w3-black">

    <button class="w3-bar-item w3-button tablink w3-red" onclick="openLink(event,'book')">책</button>
    <button class="w3-bar-item w3-button tablink w3-red"  onclick="openLink(event,'person')">사람</button>
    <button class="w3-bar-item w3-button tablink w3-red"  onclick="openLink(event,'rent')">대여</button>

  </div>
   
  <div id='book' class="w3-container w3-white w3-padding-16 myLink" style="display: block;">
  <form>
  <div  class="table">
    <table class="table_book">
      <tr>
        <th></th><th></th>
      </tr>
      <tr>
        <td><label>책제목</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
      <tr>
        <td><label>책번호</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
      <tr>
        <td><label>출판사</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
       <tr>
        <td><label>저자</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
      <tr>
        <td><label>가격</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
      <tr>
        <td><label>장르</label></td><td><input class="w3-input w3-border" type="text"></td>
      </tr>
      <tr>
        <td>
           <select>
            <option value="no ">NO</option>
            <option value="제목">제목</option>
            <option value="출판사">출판사</option>
            <option value="장르">장르</option>
            <option value="저자">저자</option>
           <option value="가격">가격</option>
          </select>          
        </td> 
        
        <td><input class="w3-input w3-border" type="text"></td>     
      </tr>
  </table>
  </div>
  </form>
  
  
  
  
  <button>검색</button>
  <button>대여하기</button>
  <button>수정</button>
  <button>삭제 </button>
  <button>취소 </button>
  <div>
  <div  class="table" >
  <table class="table_book" >
 <tr>
  <th>NO     </th>
  <th>책 제목</th>
  <th>출판사 </th>
  <th>장르  </th>
  <th>저자  </th>
  <th>가격  </th>
  <th>대여정보</th>
 </tr>
 <tr>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
</table>
</div>
</div>
  
  </div>
  
  
    
  
  <div id='person' class="w3-container w3-white w3-padding-16 myLink" style="display: block;">
   <div  class="table">
   <table class="table_person">
     <tr>
       <th></th><th></th><th></th>
     </tr>
     <tr>
       <td><label>이름</label></td><td><input class="w3-input w3-border" type="text"></td><td></td>
     </tr>
     <tr>
       <td><label>주민번호</label></td><td><input class="w3-input w3-border" type="text"></td><td><input class="w3-input w3-border" type="text"></td>
     </tr>
     <tr>
       <td><label>전화번호</label></td><td><input class="w3-input w3-border" type="text"></td><td><input class="w3-input w3-border" type="text"></td>
     </tr>
     <tr>
       <td><label>메일주소</label></td><td><input class="w3-input w3-border" type="text"></td><td><input class="w3-input w3-border" type="text"></td>
     </tr>
     <tr>
      <td><label>검색</label></td>
       <td>
         <select>
         <option value="회원번호 ">회원번호</option>
         <option value="이름">이름</option>
         </select>
       </td>
       <td><input class="w3-input w3-border" type="text"></td><td></td>
     </tr>
   </table> 
   </div> 
       <button>검색</button>   
       <button>회원삭제</button>
       <button>회원수정</button>
       <button>취소</button>
       <div  class="table">
       <table class="table_person">
 <tr>
  <th>회원정보     </th>
  <th>이름</th>
  <th>주민번호 </th>
  <th>전화번호     </th>
  <th>이메일주소</th>
 </tr>
 <tr>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>  
</table>
</div>
  </div>
  

  
  
  <div id='rent' class="w3-container w3-white w3-padding-16 myLink" style="display: block;">
    
  <button>반납완료</button>
  <div  class="table">
        <table class="table_rent">
 <tr>
  <th>NO      </th>
  <th>이름     </th>
  <th>전화번호 </th>
  <th>주민번호  </th>
  <th>책 제목   </th>
  <th>출판사     </th>
  <th>장르       </th>
  <th>저자       </th>
  <th>책번호     </th>
  <th>대여날짜   </th>
 </tr>
 <tr>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td> 
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td>
  <td>a</td> 
</table class="table_rent">
</div>
  
  </div>
 
</div>
</div>
</div>
</div>
<script>
// Tabs

    
function openLink(evt, linkName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("myLink");
  for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(linkName).style.display = "block";
  evt.currentTarget.className += " w3-red";
}
// Click on the first tablink on load
document.getElementsByClassName("tablink")[0].click();


</script>

</body>
</html>