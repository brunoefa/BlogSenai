<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="partes/cabecalho.jsp"></jsp:include>
<jsp:include page="partes/menu.jsp"></jsp:include>


<jsp:include page="partes/titulo-pagina.jsp">
    <jsp:param name="titulo" value="Entre em contato conosco"/>
</jsp:include>

<div class="container marketing">
	<div class="col-12">
		<form role="form" action="enviar">
			<div class="row">
				<div class="col-lg-6">
					<div class="form-group">
						<label for="nome">Nome</label>
						<input type="nome" class="form-control" id="nome" name="nome" placeholder="Seu nome" required="required">
					</div>
				</div>
				<div class="col-lg-6">
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" class="form-control" id="email" name="email"  placeholder="abc@exemplo.com" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="assunto">Assunto</label>
				<input type="text" class="form-control" id="assunto" name="assunto" placeholder="Seja direto" required="required">
			</div>
			<div class="form-group">
				<label for="mensagem">Mensagem</label>
				<textarea class="form-control" id="mensagem" rows="6" name="mensagem" placeholder="Seja claro" required="required"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
</div>		

<jsp:include page="partes/rodape.jsp"></jsp:include>