<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 

<%@ page import="java.util.Map"%>

<% 
Map<Boolean, String> resp = (Map<Boolean, String>) request.getAttribute("entradaDuplicada");
%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Normalize -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
    />

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100..900&display=swap"
      rel="stylesheet"
    />

    <title>Novo Contato</title>

    <link rel="icon" href="images/phone_icon.svg" />
    <link rel="stylesheet" href="css/novoContato.css" />
  </head>
  <body>
    <main>
      <h1>Criar novo contato</h1>

      <% if (resp != null && resp.containsKey(Boolean.TRUE)){%>
      	<p class="error">Erro <%= resp.get(Boolean.TRUE) %> Já Existe!</p>
      <%}%>
      

      <form name="formContato" action="insert" method="post">
        <table>
          <tr class="campoNome">
            <td>
              <input
                class="caixa1"
                type="text"
                name="nome"
                id="nome"
                placeholder="Nome"
                onblur="validarNome()"
              />
            </td>
            <td id="msg-erro-nome"></td>
          </tr>

          <tr class="campoFone">
            <td>
              <input
                class="caixa2"
                maxlength="15"
                type="tel"
                name="fone"
                id="fone"
                placeholder="Fone"
                onkeyup="handlePhone(event)"
                onblur="validarTelefone()"
              />
            </td>
            <td id="msg-erro-fone"></td>
          </tr>

          <tr class="campoEmail">
            <td>
              <input
                class="caixa1"
                maxlength="60"
                type="text"
                name="email"
                id="email"
                placeholder="Email"
                onblur="validarEmail()"
              />
            </td>
            <td id="msg-erro-email"></td>
          </tr>
        </table>

        <div class="campAdicionar">
          <input
            class="btnAdicionar"
            type="button"
            value="Adicionar"
            onclick="validarCampos()"
          />
        </div>
      </form>
      
    </main>

    <script src="scripts/mascaraTelefone.js"></script>
    <script src="scripts/validadorCampos.js"></script>
  </body>
</html>
