<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <!-- ajax를 이용해보자 -->
    <script src="/resources/js/ajaxsetup.js"></script>
    <script type="text/javascript">
    $(document).ready(function(event){
        $('#aa').click(function(event){
            
            //ajax 호출
            if(confirm("정말로 전송하시겠습니까?")){
                var aa = 'ddong';
            
            $.ajax({
              url : 'http://localhost:8080/appr2'
             , data: {'aa':aa}        // 사용하는 경우에는 { data1:'test1', data2:'test2' }
             , type: 'post'       // get, post
             , timeout: 30000    // 30초
             , dataType: 'json'  // text, html, xml, json, jsonp, script
            }).done ( function(data,textStatus,xhr ) {
        // 통신이 시작되기 전에 이 함수를 타게 된다.
            	$('#commentlist').prepend(data);
                $('#addComment textarea').val('');  
             });
            }
        });
    });
    </script>
    
    
</head>
<body>   
    <p>  시간을 입력하세요 ${result}. </p>
    <form id="loginForm" action="appr" method="post" onsubmit="application/x-www-form-urlencoded">
                <p style="margin: 0; padding: 0;"> </p>                                  
                <table>
                    <tr>
                        <td style="width: 200px;">숫자</td>
                        <td style="width: 390px"><input type="text" name="no" style="width: 99%;" /></td>
                    </tr>
                   
                </table>
                <div style="text-align: center;padding: 15px 0;">
                    <input type="submit" value="확인" />
                    
                </div>
            </form>
            <p>확인을 누르세요 글씨 나옵니다.</p>
       <button id='aa'>확인</button>    
        <%@ include file="h1.jsp" %>
    
</body>
</html>
