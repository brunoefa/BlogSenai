<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>
<jsp:include page="partes/slide.jsp"></jsp:include>

	
	<div class="container marketing">
		<c:forEach items="${lista}" var="post">
		<div class="row featurette">
			<div class="col-md-12">
				<h2 class="featurette-heading">
					<a href="post?acao=mostrar&id=${post.id}">${post.titulo}</a>
				</h2>
				<c:if test="${post.status eq 0}">
					<span class="label label-default">Rascunho</span>
				</c:if>
				<p class="lead">${post.resumo}
				<a href="post?acao=mostrar&id=${post.id}">Leia mais</a></p>
				<h4 class="autor"> ${post.autor}, <fmt:formatDate value="${post.data}" pattern="E, d MMM yyyy HH:mm"/></h4>
			</div>
		</div>
		<hr class="featurette-divider">
		</c:forEach>
	</div>		

<jsp:include page="partes/rodape.jsp"></jsp:include>