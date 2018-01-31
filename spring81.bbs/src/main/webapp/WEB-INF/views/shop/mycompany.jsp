<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="view-port" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
    <title>Mobile Project</title>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/images/app_icon.png" />
    <link rel="apple-touch-icon-precomposed" href="/resources/images/app_icon.png" />

    <link rel="stylesheet" href="/resources/css/css.css">
    <script src="/resuorces/js/jquery-3.1.1.js"></script>
    <script src="/resuorces/js/effect.js"></script>

    
    
    


</head>
<body>

<section id="page1" data-role="page">
    <%@ include file="/WEB-INF/views/shop/sidebar.jsp" %>

    <div data-role="content" class="content" class="m_bg">
        <div class="s_main">
          <hr>
            <h2 class="sub_tit helv bold">ABOUT US</h2>
            <div class="m_cont">
            <hr>
              <img alt="champs" src="/resources/images/chams.png" style="width: 100%">
                <p class="m_tit bold">누구나 쉽게 기초부터 다가갈 수 있도록 도와드립니다.</p>
                웹표준 코딩에 대한 두려움은 갖지 않도록 도와드립니다. 모바일 웹에 특화되어서 배우며 함께 만들어 가면서 같이 공부해봅시다.
                <br><br><br>
            </div>
        </div>
    </div>

  
</section>

</body>
</html>