<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>

<jsp:include page="partes/titulo-pagina.jsp">
    <jsp:param name="titulo" value="${post.titulo}"/>
</jsp:include>

<div class="container marketing">
	<div class="row featurette">
		<div class="col-md-12">
			<h4 class="autor">${post.autor}</h4>
			<p class="lead">${post.texto}</p>
		</div>
	</div>
	<hr class="featurette-divider">
	<a href="post?acao=confirmar&id=${post.id}" class="btn-lg btn-danger">Deletar Post</a>
	<a href="post?acao=editar&id=${post.id}" class="btn-lg btn-info">Editar Post</a>
</div>

<jsp:include page="partes/rodape.jsp"></jsp:include>