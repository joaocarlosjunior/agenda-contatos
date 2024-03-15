<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Contato"%>
<%@ page import="java.util.List"%>

<%
List<Contato> listaContatos = (List<Contato>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Normalize -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100..900&display=swap"
	rel="stylesheet" />

<title>Agenda de Contatos</title>
<link rel="icon" href="images/phone_icon.svg" />
<link rel="stylesheet" href="css/agenda.css" />

</head>
<body>
	<main>
		<h1>Agenda de Contatos</h1>
		<div>
			<a class="btn-novo-contato" href="novo.jsp">Novo Contato</a>
			<a class="btn-relatorio" href="report">Relatório</a>
		</div>

		<table>
			<tr>
				<th class="coluna">Id</th>
				<th class="coluna">Nome</th>
				<th class="coluna">Fone</th>
				<th class="coluna">Email</th>
				<th class="editar">Editar</th>
				<th class="excluir">Excluir</th>
			</tr>
			<%if(listaContatos != null){ %>
			<%
			for (int i = 0; i < listaContatos.size(); i++) { 
 			%> 
			<tr>
				<td class="coluna"><%= listaContatos.get(i).getId() %></td>
				<td class="coluna"><%=listaContatos.get(i).getNome()%></td>
				<td class="coluna"><%=listaContatos.get(i).getFone()%></td> 
				<td class="coluna"><%=listaContatos.get(i).getEmail()%></td>
				<td class="coluna-icon"> <a class="icons" href="select?id=<%=listaContatos.get(i).getId()%>"><img  src="images/icons/edit_icon.svg"></a>  </td>
				<td class="coluna-icon"> <a class="icons" href="javascript: confirmar(<%=listaContatos.get(i).getId()%>)"><img  src="images/icons/remove_icon.svg" ></a> </td>
			</tr>
				<%}%>
			<%}%>
		</table>

	</main>
	
	<script src="scripts/confirmador.js" ></script>
</body>
</html>
