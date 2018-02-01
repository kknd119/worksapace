<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
  

<html>
<head>
    <meta charset="utf-8" /> 
    
    <meta name="Keywords" content="게시판 상세보기" />
    <meta name="Description" content="게시판 상세보기" />
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <title>${boardnm }</title>
    <script src="/resources/js/jquery-3.1.1.js"></script>  
   
    
    
   
   
    <script>
        $(document).ready( function(event){
            $('.boardlist').click( function(event) { 
                window.location.href = '/board/boardlist';
            } );
            $('.listlist').click( function(event) { 
                window.location.href = '/board/articleimagelist/${board.boardcd}';
            } );
            $('.boardwrite').click( function(event) { 
                window.location.href = '/board/boardimagewrite';
            } );
            $('.boardmodify').click( function(event) { 
                window.location.href = '/board/boardimagemodify?boardcd=${board.boardcd }';
            } );
            $('.boarddelete').click( function(event) {
            	
            	//form 태그 생성
                var f = document.createElement('form');
                // form 태그 속성 설정
                f.setAttribute('method','post');
                f.setAttribute('action','/board/boarddelete');
                f.setAttribute('enctype','application/x-www-form-urlencoded');
                // input 태그 속성 설정
                var i = document.createElement('input');
                 i.setAttribute('type','text');
                 i.setAttribute('name','boardcd');
                 i.setAttribute('value','${board.boardcd}');
                 
                 //input 태그를 form 태그에 속하게 한다.
                 f.appendChild(i)
                 //form 태그 submit
                 document.body.appendChild(f);
                 f.submit();
                
                
                
            } );  
        });
    </script>
   
   
   
    
   
   
</head>
<body>

<div id="wrap">
    <div id="header">
        <%@ include file="../inc/header.jsp" %>
    </div>

    <div id="main-menu">
         <%@ include file="/WEB-INF/views/shop/sidebar.jsp" %>
    </div> 

    <div id="container">
        <div id="content" style="min-height: 800px;">
            
            <!-- 본문 시작 -->
            <h1>Board View</h1>
            <div id="bbs">
                    <c:if test="${not empty msg }">
                    <p style="color: red;">정보삭제 실패했습니다.</p>
                    </c:if> 
                <table>
                    <tr>
                        <th style="text-align: left; width: 100px;">Borad Name</th>
                        <th style="text-align: left; color: #555;">${board.boardnm }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Board Code</th>
                        <th style="text-align: left; color: #555;">${board.boardcd }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Use YN</th>
                        <th style="text-align: left; color: #555;"><input type="checkbox" name="UseYN" readonly="readonly" <c:if test="${board.useYN}">checked="checked"</c:if> /> </th>
                    </tr>   
                </table>
            </div>

            <div style="text-align: left; padding-bottom: 15px;"> 
                <input type="button" class="boardlist"   value="목록" />
                <input type="button" class="listlist"   value="올린글 리스트" />
                <input type="button" class="boardwrite"  value="추가" />
                <input type="button" class="boardmodify" value="수정" />
                <input type="button" class="boarddelete" value="삭제" />
            </div>
            <!--  본문 끝 -->
            
        </div>
        <!-- content 끝 -->
        
    </div>
    <!--  container 끝 -->
    <div id="sidebar">
        <%@ include file="../inc/bbs-menu.jsp" %>
    </div>
    
    <div id="extra">
        <%@ include file="../inc/extra.jsp" %>
    </div>

    <div id="footer">
        <%@ include file="../inc/footer.jsp" %>
    </div>     
    
</div>


</body>
</html>
