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
    <style>
       .w3-sidebar a {font-family: "Roboto", sans-serif}
        body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
    </style>
    <body class="w3-content" style="max-width:1200px">
    <script src="/resuorces/js/jquery-3.1.1.js"></script>
    <script src="/resuorces/js/effect.js"></script>
    
    

    <!-- 구글 지도 -->
    <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDI7XpD7FZ70br7V_Y6SklfdUEASGMmVC0"></script>

    <!-- GoogoleMap Asynchronously Loading the API ********************************************* -->
    <script>
        function initialize() {
            var mapLocation = new google.maps.LatLng('37.569752', '126.985644'); // 지도에서 가운데로 위치할 위도와 경도
            var markLocation = new google.maps.LatLng('37.569752', '126.985644'); // 마커가 위치할 위도와 경도

            var mapOptions = {
                center: mapLocation, // 지도에서 가운데로 위치할 위도와 경도(변수)
                zoom: 18, // 지도 zoom단계
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map-canvas"), // id: map-canvas, body에 있는 div태그의 id와 같아야 함
                mapOptions);

            var size_x = 60; // 마커로 사용할 이미지의 가로 크기
            var size_y = 60; // 마커로 사용할 이미지의 세로 크기

            // 마커로 사용할 이미지 주소
            var image = new google.maps.MarkerImage( 'http://www.larva.re.kr/home/img/boximage3.png',
                new google.maps.Size(size_x, size_y),
                '',
                '',
                new google.maps.Size(size_x, size_y));

            var marker;
            marker = new google.maps.Marker({
                position: markLocation, // 마커가 위치할 위도와 경도(변수)
                map: map,
                icon: image, // 마커로 사용할 이미지(변수)
//             info: '말풍선 안에 들어갈 내용',
                title: '서대전네거리역이지롱~' // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
            });

            var content = "이곳은 서대전네거리역이다! <br/> 지하철 타러 가자~"; // 말풍선 안에 들어갈 내용

            // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
            var infowindow = new google.maps.InfoWindow({ content: content});

            google.maps.event.addListener(marker, "click", function() {
                infowindow.open(map,marker);
            });



        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>

</head>
<body>
 <%@ include file="/WEB-INF/views/shop/sidebar.jsp" %>
 <!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px">
 <section id="page1" data-role="page">


    <div data-role="content" class="content" class="m_bg">
        <div class="s_main">
        <hr>
            <h2 class="sub_tit helv bold">LOCATION</h2>
            <div id="map-canvas" style="height:330px ; width: 1032px"></div>

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ad_box">
                <colgroup>
                    <col width="80px" />
                    <col />
                </colgroup>
                <tr>
                    <th>Address</th>
                    <td>서울시 강남구 강남대로</td>
                </tr>
                <tr>
                    <th>Tel</th>
                    <td>
                        <span class="tab_text">02.1234.5678</span>
                        <input type="button" class="btn_base btn_tel" value="통화하기" onClick="location.href='tel:0212345678';" />
                    </td>
                </tr>
                <tr>
                    <th>E-mail</th>
                    <td>
                        <span class="tab_text">aaa@aa.co.kr</span>
                        <input type="button" class="btn_base btn_email" value="이메일 보내기" onClick="location.href='mailto:aaa@aa.co.kr';" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
  

 
</section>
</div>

</body>
</html>