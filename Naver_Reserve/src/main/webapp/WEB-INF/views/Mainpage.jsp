<%@page import="java.util.ArrayList"%>
<%@page import="com.springbook.app.product.impl.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.app.display.impl.DisplayVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% String email = (String)session.getAttribute("email"); %>
<%
	List<ProductVO> product = (List) request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title> 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

    <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./myreservation.html" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="<%if(email!=null){   %>myreservation <%}else{ %>login<%} %>" class="btn_my"> <span class="viewReservation" title="예약확인"><%if(email!=null){   %><%=email %><%}else{ %>  예약확인<%} %></span> </a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <!-- 
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e" style="display:none;">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e" style="display:none;">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                	 슬라이딩기능: 이미지 (type = 'th')를 순차적으로 노출 
                                <ul class="visual_img">
                                </ul>
                            </div>
                            <span class="nxt_fix" style="display:none;"></span>
                        </div>
                    </div>
                </div> -->
                <div id="slider-wrap">
			<ul id="slider">
				<%
					for (ProductVO vo : product) {
				%>
				<li>
				 
					<div>
						<h3></h3>
						<span><!-- <%=vo.getContent() %>--></span>
					</div> 
					<img src="${pageContext.request.contextPath}/resources/<%=vo.getSave_file_name()%>">
				</li>
				<%
					}
				%>

			</ul>

			<div class="slider-btns" id="next">
				<span>▶</span>
			</div>
			<div class="slider-btns" id="previous">
				<span>◀</span>
			</div>

			<div id="slider-pagination-wrap">
				<ul>
				</ul>
			</div>
		</div>
            </div>
            <div class="section_event_tab">
                <ul class="event_tab_lst tab_lst_min">
                    <li class="item" data-category="0">
                        <a class="anchor active"> <span>전체리스트</span> </a>
                    </li>
                    <li class="item" data-category="1">
                        <a class="anchor"> <span>전시</span> </a>
                    </li>
                    <li class="item" data-category="2">
                        <a class="anchor"> <span>뮤지컬</span> </a>
                    </li>
                    <li class="item" data-category="3">
                        <a class="anchor"> <span>콘서트</span> </a>
                    </li>
                    <li class="item" data-category="4">
                        <a class="anchor"> <span>클래식</span> </a>
                    </li>
                    <li class="item" data-category="5">
                        <a class="anchor"> <span>연극</span> </a>
                    </li>
                    <!-- li class="item" data-category="7">
                        <a class="anchor"> <span>클래스</span> </a>
                    </li>
                    <li class="item" data-category="8">
                        <a class="anchor"> <span>체험</span> </a>
                    </li>
                    <li class="item" data-category="9">
                        <a class="anchor last"> <span>키즈</span> </a>
                    </li -->
                </ul>		
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink">10개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                   <%int count=0;
                   for(ProductVO vo :product){ %>
                   
					<% System.out.println(vo.getId());%>
					<%if(count%4==0){
						%>
					
                    <ul class="lst_event_box">
                        <li class="item">
                            <a href="/naver/detail?id=<%=vo.getId() %>" class="item_book">
                                <div class="item_preview"> <img alt="<%=vo.getDescription() %>" class="img_thumb" src="${pageContext.request.contextPath}/resources/<%=vo.getSave_file_name()%>"> <span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span><%=vo.getDescription() %></span> <small class="sm"></small> </h4>
                                    <p class="event_txt_dsc"><%=vo.getContent() %></p>
                                </div>
                            </a>
                        </li>
                     <%} else if(count%4==1){ %>
                        <li class="item">
                            <a href="/naver/detail?id=<%=vo.getId() %>" class="item_book">
                                <div class="item_preview"> <img alt="<%=vo.getDescription() %>" class="img_thumb" src="${pageContext.request.contextPath}/resources/<%=vo.getSave_file_name()%>"> <span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span><%=vo.getDescription() %></span> <small class="sm"></small> </h4>
                                    <p class="event_txt_dsc"><%=vo.getContent() %></p>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <%}else if(count%4==2){
						%>
					
                    <ul class="lst_event_box2">
                        <li class="item">
                            <a href="/naver/detail?id=<%=vo.getId() %>" class="item_book">
                                <div class="item_preview"> <img alt="<%=vo.getDescription() %>" class="img_thumb" src="${pageContext.request.contextPath}/resources/<%=vo.getSave_file_name()%>"> <span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span><%=vo.getDescription() %></span> <small class="sm"></small> </h4>
                                    <p class="event_txt_dsc"><%=vo.getContent() %></p>
                                </div>
                            </a>
                        </li>
                     <%} else if(count%4==3){ %>
                        <li class="item">
                            <a href="/naver/detail?id=<%=vo.getId() %>" class="item_book">
                                <div class="item_preview"> <img alt="<%=vo.getDescription() %>" class="img_thumb" src="${pageContext.request.contextPath}/resources/<%=vo.getSave_file_name()%>"> <span class="img_border"></span> </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span><%=vo.getDescription() %></span> <small class="sm"></small> </h4>
                                    <p class="event_txt_dsc"><%=vo.getContent() %></p>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <%} %>
					<% count++;
					if(count%4==0) break;
                    } %>
                    <!-- 더보기 -->  
                    <div class="more">
                        <button class="btn" onclick="btn()")><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>


    <script type="rv-template" id="promotionItem">
        <li class="item" style="background-image: url(http://211.249.62.123/productImages/${productId}/${productImageId});">
            <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
                <div class="event_txt">
                    <h4 class="event_txt_tit"></h4>
                    <p class="event_txt_adr"></p>
                    <p class="event_txt_dsc"></p>
                </div>
            </a>
        </li>
        </script>

    <script type="rv-template" id="itemList">
            <li class="item">
                <a href="detail.html?id=${id}" class="item_book">
                    <div class="item_preview">
                        <img alt="${description}" class="img_thumb" src="http://211.249.62.123/productImages/${id}?type=th">
                        <span class="img_border"></span>
                    </div>
                    <div class="event_txt">
                        <h4 class="event_txt_tit"> <span>${description}</span> <small class="sm">${placeName}</small> </h4>
                        <p class="event_txt_dsc">${content}</p>
                    </div>
                </a>
            </li>
        </script>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

<script type="text/javascript">

	console.log("<%=email%>");
	var Category=0;
	var length = 4;
	//slide-wrap
	var slideWrapper = document.getElementById('slider-wrap');
	//current slideIndexition
	var slideIndex = 0;
	//items
	var slides = document.querySelectorAll('#slider-wrap ul li');
	//number of slides
	var totalSlides = slides.length;
	//get the slide width
	var sliderWidth = slideWrapper.clientWidth;
	//set width of items
	slides.forEach(function(element) {
		element.style.width = sliderWidth + 'px';
	})
	//set width to be 'x' times the number of slides
	var slider = document.querySelector('#slider-wrap ul#slider');
	slider.style.width = sliderWidth * totalSlides + 'px';

	// next, prev
	var nextBtn = document.getElementById('next');
	var prevBtn = document.getElementById('previous');
	nextBtn.addEventListener('click', function() {
		plusSlides(1);
	});
	prevBtn.addEventListener('click', function() {
		plusSlides(-1);
	});

	// hover
	slideWrapper.addEventListener('mouseover', function() {
		this.classList.add('active');
		clearInterval(autoSlider);
	});
	slideWrapper.addEventListener('mouseleave', function() {
		this.classList.remove('active');
		autoSlider = setInterval(function() {
			plusSlides(1);
		}, 3000);
	});

	function plusSlides(n) {
		showSlides(slideIndex += n);
	}

	function currentSlides(n) {
		showSlides(slideIndex = n);
	}

	function showSlides(n) {
		slideIndex = n;
		if (slideIndex == -1) {
			slideIndex = totalSlides - 1;
		} else if (slideIndex === totalSlides) {
			slideIndex = 0;
		}

		slider.style.left = -(sliderWidth * slideIndex) + 'px';
		pagination();
	}

	//pagination
	slides.forEach(function() {
		var li = document.createElement('li');
		document.querySelector('#slider-pagination-wrap ul').appendChild(li);
	})

	function pagination() {
		var dots = document.querySelectorAll('#slider-pagination-wrap ul li');
		dots.forEach(function(element) {
			element.classList.remove('active');
		});
		dots[slideIndex].classList.add('active');
	}

	pagination();
	var autoSlider = setInterval(function() {
		plusSlides(1);
	}, 3000);
	
	
	function btn(){
		$.ajax({
		type : "GET",
		url : "/naver/ajax",
		data : {"category123":Category},
		dataType : "json",
		success:function(data){
			console.log(data);
			var str =  "<ul class=\"lst_event_box\">"+ 
			"<li class=\"item\">" +
	   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
	     "<div class=\"item_preview\"> <img alt=\" " + data[length].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
	     "<div class=\"event_txt\">"+
	     "<h4 class=\"event_txt_tit\"> <span>" + data[length].description + "</span> <small class=\"sm\"></small> </h4>"+
	     "<p class=\"event_txt_dsc\">"+ data[length].content + "</p>"+
	     "</div>"+
	   	"</a>"+
			"</li>"+
			"<li class=\"item\">" +
	   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
	     "<div class=\"item_preview\"> <img alt=\" " + data[length+1].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+1].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
	     "<div class=\"event_txt\">"+
	     "<h4 class=\"event_txt_tit\"> <span>" + data[length+1].description + "</span> <small class=\"sm\"></small> </h4>"+
	     "<p class=\"event_txt_dsc\">"+ data[length+1].content + "</p>"+
	     "</div>"+
	   	"</a>"+
			"</li>"+
			"</ul>"+
			"<ul class=\"lst_event_box2\">"+ 
			"<li class=\"item\">" +
	   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
	     "<div class=\"item_preview\"> <img alt=\" " + data[length+2].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+2].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
	     "<div class=\"event_txt\">"+
	     "<h4 class=\"event_txt_tit\"> <span>" + data[length+2].description + "</span> <small class=\"sm\"></small> </h4>"+
	     "<p class=\"event_txt_dsc\">"+ data[length+2].content + "</p>"+
	     "</div>"+
	   	"</a>"+
			"</li>"+
			"<li class=\"item\">" +
	   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
	     "<div class=\"item_preview\"> <img alt=\" " + data[length+3].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+3].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
	     "<div class=\"event_txt\">"+
	     "<h4 class=\"event_txt_tit\"> <span>" + data[length+3].description + "</span> <small class=\"sm\"></small> </h4>"+
	     "<p class=\"event_txt_dsc\">"+ data[length+3].content + "</p>"+
	     "</div>"+
	   	"</a>"+
			"</li>"+
			"</ul>"+
	"<div class=\"more\">"+
	"<button class=\"btn\" onclick=\"btn()\"><span>더보기</span></button>"+
	"</div>"
	var choose = document.querySelector(".wrap_event_box");
	length = length+4;
	$(".more").remove();
	$(".wrap_event_box").append(str);
	
		}

		});  
	}

	
	$(".item").click(function(){

		$(this).removeClass('anchor active')
		Category = $(this).data("category"); 
 		
		$.ajax({
		type : "GET",
		url : "/naver/ajax", 
		data : {"category123":Category},
		dataType: "json",  
		success:function(data){
			length=0;
			 var str =  "<ul class=\"lst_event_box\">"+ 
				"<li class=\"item\">" +
		   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
		     "<div class=\"item_preview\"> <img alt=\" " + data[length].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
		     "<div class=\"event_txt\">"+
		     "<h4 class=\"event_txt_tit\"> <span>" + data[length].description + "</span> <small class=\"sm\"></small> </h4>"+
		     "<p class=\"event_txt_dsc\">"+ data[length].content + "</p>"+
		     "</div>"+
		   	"</a>"+
				"</li>"+
				"<li class=\"item\">" +
		   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
		     "<div class=\"item_preview\"> <img alt=\" " + data[length+1].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+1].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
		     "<div class=\"event_txt\">"+
		     "<h4 class=\"event_txt_tit\"> <span>" + data[length+1].description + "</span> <small class=\"sm\"></small> </h4>"+
		     "<p class=\"event_txt_dsc\">"+ data[length+1].content + "</p>"+
		     "</div>"+
		   	"</a>"+
				"</li>"+
				"</ul>"+
				"<ul class=\"lst_event_box2\">"+ 
				"<li class=\"item\">" +
		   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
		     "<div class=\"item_preview\"> <img alt=\" " + data[length+2].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+2].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
		     "<div class=\"event_txt\">"+
		     "<h4 class=\"event_txt_tit\"> <span>" + data[length+2].description + "</span> <small class=\"sm\"></small> </h4>"+
		     "<p class=\"event_txt_dsc\">"+ data[length+2].content + "</p>"+
		     "</div>"+
		   	"</a>"+
				"</li>"+
				"<li class=\"item\">" +
		   	"<a href=\"/naver/detail?id="+data[length].id+"\" class=\"item_book\">" +
		     "<div class=\"item_preview\"> <img alt=\" " + data[length+3].description + " \"class=\"img_thumb\" src=\"${pageContext.request.contextPath}/resources/" + data[length+3].save_file_name + " \"> <span class=\"img_border\"></span> </div>"+
		     "<div class=\"event_txt\">"+
		     "<h4 class=\"event_txt_tit\"> <span>" + data[length+3].description + "</span> <small class=\"sm\"></small> </h4>"+
		     "<p class=\"event_txt_dsc\">"+ data[length+3].content + "</p>"+
		     "</div>"+
		   	"</a>"+
				"</li>"+
				"</ul>"+
		"<div class=\"more\">"+
		"<button class=\"btn\" onclick=\"btn()\"><span>더보기</span></button>"+
		"</div>"
			var choose = document.querySelector(".wrap_event_box");
			$(".wrap_event_box").empty();
			console.log(data[0].content);
			$(".wrap_event_box").append(str);
			length=4;
			
		}
		
		}); 
	
		
	})
	$(".anchor").click(function(){
		
		$(this).attr('class','anchor active');
		
	}) 

</script>


</html>
