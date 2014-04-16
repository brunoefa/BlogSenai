<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach items="${lista}" var="post" varStatus="loop" begin="0" end="2">
		<li data-target="#myCarousel" data-slide-to="${loop.index}" class="${loop.index == 0 ? 'active' : ''}"></li>
		</c:forEach>
	</ol>
	<div class="carousel-inner">
		<c:forEach items="${lista}" var="post" varStatus="loop" begin="0" end="2">
		<div class="item ${loop.index == 0 ? 'active' : ''}">
			<img src="images/cover-0${loop.index + 1}.jpg" alt="First slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>${post.titulo}</h1>
					<p>${post.resumo}</p>
					<p><a class="btn btn-lg btn-primary" href="post?acao=mostrar&id=${post.id}" role="button">Leia mais</a></p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>

<jsp:include page="mensagem.jsp"></jsp:include>      
