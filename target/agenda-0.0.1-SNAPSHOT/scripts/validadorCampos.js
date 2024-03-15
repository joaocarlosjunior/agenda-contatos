function validarCampos(){
    
    const nome = formContato.nome.value;
    const fone = formContato.fone.value;
    
    if(nome === ""){
        alert('Prencha o campo nome');
        formContato.nome.focus();
        return false;
    }else if(fone === ""){
        alert('Prencha o campo fone');
        formContato.fone.focus();
        return false;
    }else{
        document.forms["formContato"].submit();
    }
}