<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Contato"%>

<%
Contato contato = (Contato) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">

<!-- Normalize -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">

<title>Editar Contato</title>
<link rel="icon" href="images/phone_icon.svg" />

<!-- CSS -->
<link rel="stylesheet" href="css/novoContato.css" />

</head>
<body>
	<main>
		<h1>Editar Contato</h1>

		<form name="formContato" action="update">
			<input type="hidden" id="contatoId" name="id"
				value="<%=contato.getId()%>">
			<table>
				<tr>
					<td><input value="<%=contato.getNome()%>" class="caixa1"
						type="text" name="nome" id="nome" placeholder="Nome"></td>
				</tr>
				<tr class="campoFone">
					<td><input value="<%=contato.getFone()%>" class="caixa2"
						maxlength="15" type="tel" name="fone" id="fone" placeholder="Fone"
						onkeyup="handlePhone(event)"
						onblur="validarTelefone(formContato.fone)"></td>
					<td id="msg-erro-fone"></td>
				</tr>
				<tr class="campoEmail">
					<td><input value="<%=contato.getEmail()%>" class="caixa1"
						maxlength="60" type="text" name="email" id="email"
						placeholder="Email" onblur="validarEmail(formContato.email)"></td>
					<td id="msg-erro-email"></td>
				</tr>
			</table>

			<div class="campAdicionar">
				<input class="btnAdicionar" type="button" value="Salvar"
					onclick="validarCampos()">
			</div>
		</form>
	</main>

	<!-- JS -->
	<script src="scripts/mascaraTelefone.js"></script>
	<script src="scripts/validadorTelefone.js"></script>
	<script src="scripts/validadorEmail.js"></script>
	<script src="scripts/validadorCampos.js"></script>
</body>
</html>