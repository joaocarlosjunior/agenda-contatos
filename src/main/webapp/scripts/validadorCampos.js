function validarCampos() {
  const nome = formContato.nome.value;

  if (validarNome()) {
    formContato.nome.focus();
    return false;
  } else if (validarTelefone()) {
    formContato.fone.focus();
    return false;
  } else if (validarEmail()) {
    formContato.email.focus();
    return false;
  } else {
    document.forms["formContato"].submit();
  }
}

function validarEmail() {
  const email = formContato.email.value;

  var re = /\S+@\S+\.\S+/;

  if (re.test(email)) {
    document.getElementById("msg-erro-email").innerHTML =
      "<font color='#3df766'>E-mail válido </font>";
    return false;
  } else {
    document.getElementById("msg-erro-email").innerHTML =
      "<font color='#ff0000'>E-mail inválido </font>";
    return true;
  }
}

function validarTelefone() {
  const fone = formContato.fone.value;
  console.log(fone);
  console.log(fone.length);
  if (fone.length < 15) {
    document.getElementById("msg-erro-fone").innerHTML =
      "<font color='#ff0000'>Telefone inválido </font>";
    return true;
  } else {
    document.getElementById("msg-erro-fone").innerHTML =
      "<font color='#3df766'>Telefone válido </font>";
    return false;
  }
}

function validarNome() {
  const nome = formContato.nome.value;

  if (nome === "" || temNumero(nome)) {
    document.getElementById("msg-erro-nome").innerHTML =
      "<font color='#ff0000'>Nome inválido </font>";
    return true;
  } else {
    document.getElementById("msg-erro-nome").innerHTML =
      "<font color='#3df766'>Nome válido </font>";
    return false;
  }
}

function temNumero(string) {
  return /\d/.test(string);
}
