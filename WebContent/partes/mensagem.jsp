<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty mensagem}">
<div class="alert-container">
	<div class="alert alert-success"><b>\o/</b> ${mensagem}</div>
</div>
</c:if>