<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
<title>나의 장바구니</title>

</head>
<body>
<%@ include file="/WEB-INF/views/shop/sidebar.jsp" %>
 <!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">
<p>나의 장바구니 목록</p>
    <div id="container">
        <div id="content" style="min-height: 800px;">
            <div id="url-navi">BBS</div>
                
                <!-- 본문 시작 -->          
                <h1>${boardNm }</h1>
                <div id="bbs">
                    <table>
                    <tr>
                        <th style="width: 60px;">NO</th>
                        <th>TITLE</th>
                        <th style="width: 84px;">DATE</th>
                        <th style="width: 60px;">HIT</th>
                    </tr>
                    <!--  반복 구간 시작 -->
                    <c:forEach var="article" items="${articleList }" varStatus="status">    
                    <tr>
                        <td style="text-align: center;">${no - status.index}</td>
                        <td>
                            <a href="javascript:goView('${article.articleno }')">${article.title }</a>
                            <c:if test="${article.attachFileNum > 0 }">
                                <img src="/resources/images/attach.png" alt="첨부파일" />
                            </c:if>
                            <c:if test="${article.commentNum > 0 }">
                                <span class="bbs-strong">[${article.commentNum }]</span>
                            </c:if>
                        </td>
                        <td style="text-align: center;">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${article.regdate }" />
                        </td>
                        <td style="text-align: center;">${article.hit }</td>
                    </tr>
                    </c:forEach>
                    <!--  반복 구간 끝 -->
                    </table>
                        
                    <div id="paging" style="text-align: center;">
                        
                        <c:if test="${prevLink > 0 }">
                            <a href="javascript:goList(${prevLink })">[이전]</a>
                        </c:if>
                
                        <c:forEach var="i" items="${pageLinks }" varStatus="stat">
                            <c:choose>
                            <c:when test="${curPage == i}">
                                <span class="bbs-strong">${i }</span>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:goList(${i })">${i }</a>
                            </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        
                        <c:if test="${nextLink > 0 }">
                            <a href="javascript:goList(${nextLink })">[다음]</a>
                        </c:if>
                        
                    </div>
                
                    <div id="list-menu" style="text-align:  right;">
                         <input type="button" value="구매내역" onclick="location.href='http://localhost:8080/company/mysale'" />
                    </div>
                
                    <div id="search" style="text-align: center;">
                        <form id="searchForm" action="${url}" method="get" style="margin: 0;padding: 0;">
                            <p style="margin: 0;padding: 0;">
                                <input type="hidden" name="boardcd" value="${boardcd }" />
                                <input type="text" name="searchWord" size="15" maxlength="30" />
                                <input type="submit" value="검색" />
                            </p>    
                        </form>
                    </div>
                    
                </div>
                <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
  </div>
</body>
</html>