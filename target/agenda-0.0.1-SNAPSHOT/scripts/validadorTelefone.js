function validarTelefone(field){
    console.log(field.value);

    if(field.value.length < 15){
        document.getElementById("msg-erro-fone").innerHTML = 
        "<font color='#ff0000'>Telefone inválido </font>";
    }else{
        document.getElementById("msg-erro-fone").innerHTML = 
        "<font color='#3df766'>Telefone válido </font>";
    }
}