<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>


<jsp:include page="partes/titulo-pagina.jsp">
    <jsp:param name="titulo" value="Cadastrar novo artigo"/>
</jsp:include>

<div class="container marketing">
	<div class="col-12">
		<form role="form" action="post" method="post" id="formPost">
			<input type="hidden" name="acao" value="salvar" id="acao">
			<input type="hidden" name="id" value="${post.id}" id="id">
			<div class="form-group">
				<label for="nome">Título</label>
				<input type="nome" class="form-control" id="titulo" name="titulo" placeholder="Título" required="required" value="${post.titulo}">
			</div>
			<div class="form-group">
				<label for="post">Post</label>
				<textarea class="form-control ckeditor" id="texto" name="texto" rows="18" placeholder="Boa sorte com o texto ;)" required="required">${post.texto}</textarea>
			</div>
			<div class="form-group">
				<label for="email">Resumo</label>
				<textarea class="form-control" id="resumo" name="resumo" rows="2" placeholder="Escreva um breve resumo" required="required">${post.resumo}</textarea>
			</div>
			<div class="form-group">
				<label for="assunto">Autor</label>
				<input type="text" class="form-control" id="autor" name="autor" placeholder="Quem é o autor do texto?" required="required" value="${post.autor}">
			</div>
			<button type="button" class="btn btn-primary btn-lg" id="publicar">Publicar</button>
			<button type="button" class="btn btn-success btn-lg" id="salvar">Salvar como rascunho</button>
		</form>
	</div>
</div>		

<jsp:include page="partes/rodape.jsp"></jsp:include>