function validar(cpf,email){
	validacaoemail(email)
	validacaocpf(cpf)
}


function validacaoemail(email){
	
	regex = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/gi
	
	valid = regex.test(email)
	
	if(valid == false){
		alert("email inválido")	
	}
	
	
}


function validacaocpf(cpf){
	
	regex = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/
	
	
	valid = regex.test(cpf)
	
	
	if(cpf == '000.000.000-00' || cpf == '111.111.111-11' || cpf == '222.222.222-22' || cpf == '333.333.333-33' || cpf == '444.444.44-44' || cpf == '555.555.555-55' || cpf == '666.666.666-66' || cpf == '777.777.777-77' || cpf == '888.888.888-88' || cpf == '999.999.999-99' || valid == false){
		alert("cpf inválido")		
		
	}

	
}

