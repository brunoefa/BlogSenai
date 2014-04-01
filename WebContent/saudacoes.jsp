<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>
<jsp:include page="partes/titulo-pagina.jsp">
	<jsp:param value="Saudações" name="titulo"/>
</jsp:include>

<div class="container marketing">
	<h1>Olá ${nome}${comprimento}</h1>
</div>		

<jsp:include page="partes/rodape.jsp"></jsp:include>