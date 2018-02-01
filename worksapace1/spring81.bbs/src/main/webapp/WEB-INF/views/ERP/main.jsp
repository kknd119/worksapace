<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
<button>회원등록</button>
<button>책등록</button>
<button>새로고침</button>
<button>프로그램 종료</button>
</div>
<div>
<table>
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
<div>
  <div id='bookinf'>
  <form>
  <label>책제목</label><input type="text">
  <label>책 번호</label><input type="text">
  <label>출판사</label><input type="text">
  <label>저자</label><input type="text">
  <label>가격</label><input type="text">
  <label>장르</label><input type="text">
  <select>
   <option value="no ">NO</option>
   <option value="제목">제목</option>
   <option value="출판사">출판사</option>
   <option value="장르">장르</option>
   <option value="저자">저자</option>
   <option value="가격">가격</option>
   </select>
  <label>검색</label><input type="text">
  </form>
  
  
  
  
  <button>검색</button>
  <button>대여하기</button>
  <button>수정</button>
  <button>삭제 </button>
  <button>취소 </button>
  <table>
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
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
</table>
  
  </div>
  
    <hr>
    
    
  <div id='personinf'>
   <label>이름</label><input type='text'>
    <label>주민번호</label><input type='text'><input type='text'>
     <label>전화번호</label><input type='text'><input type='text'>
      <label>메일주소</label><input type='text'><input type='text'>
       <label>검색</label>
       <select>
       <option value="회원번호 ">회원번호</option>
       <option value="이름">이름</option>
       </select>
       <input type='text'>
       
       <button>회원삭제</button>
       <button>회원수정</button>
       <button>취소</button>
       
       <table>
 <tr>
  <th>회원정보     </th>
  <th>이름</th>
  <th>주민번호 </th>
  <th>전화번호     </th>
  <th>이메일주소</th>
 </tr>
 <tr>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>  
</table>
  </div>
  
  <hr>
  
  <div id='rentinf'>
  <button>반납완료</button>
        <table>
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
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td> 
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td> 
</table>
  
  </div>
 
</div>

</body>
</html>