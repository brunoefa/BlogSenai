<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>

<jsp:include page="partes/titulo-pagina.jsp">
    <jsp:param name="titulo" value="${post.titulo}"/>
</jsp:include>

<div class="container marketing">
	<h2>Tem certeza que deseja deletar o post: ${titulo}?</h2>
	<a href="post?acao=deletar&id=${id}" class="btn-lg btn-primary">Ok</a>
	<a href="post?acao=mostrar&id=${id}" class="btn-lg btn-info ">Cancelar</a>
</div>

<jsp:include page="partes/rodape.jsp"></jsp:include>