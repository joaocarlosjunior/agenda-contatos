function confirmar(id){
	const resposta = confirm("Confrima a exclusão deste contato?");
	
	if(resposta === true){
		window.location.href = "delete?id=" + id;
	}
}