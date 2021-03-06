<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 새글쓰기" />
    <meta name="Description" content="게시판 새글쓰기" />
    
    <title>${boardNm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
     <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
     $(document).ready(function(event){
    	 $('#golist').click(function(event){
    		 location.href=location.href="/board/articleimagelist/${boardcd}?searchWord=${searchWord}&curPage=${curPage}"; 
    	 });
     });
     
           
    </script>
   
</head>
<body>

	<div id="wrap">
      
    <div id="header">
        <%@ include file="../inc/header.jsp" %>
    </div>

    <div id="main-menu">
        <%@ include file="../inc/main-menu.jsp" %>
    </div> 

		<div id="container">
			<div id="content" style="min-height: 800px;">
				<div id="url-navi">BBS</div>

				<!-- 본문 시작 -->
				<h1>${boardNm }</h1>
				<div id="bbs">
					<h2>글쓰기</h2>
					<form id="writeForm" action="/board/articleimagewrite" method="post" enctype="multipart/form-data" onsubmit="return check()">
						<p style="margin: 0; padding: 0;">
							<input type="hidden" name="boardcd" value="${boardcd }" />
						</p>
						<table id="write-form">
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" size="50" /></td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="content" rows="17"></textarea>
								</td>
							</tr>

							<tr>
								<td>파일첨부</td>
                                <td><form action="/upload/imageupload" enctype="multipart/form-data" method="post">
                                     Upload Directory : <input type="text" name="upDir" value="c:/upload/" /><br />
                                       <br /> <input type="file" name="image" /> <input type="submit" value="이미지저장" />
                                      </form> 
                                </td>
								<td><input type="file" name="upload" /></td>
							</tr>
						</table>
						<div style="text-align: center; padding-bottom: 15px;">
							<input type="submit" value="전송" />
							
							<input type="button" value="목록" id="goList" />
						</div>
					</form>
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
