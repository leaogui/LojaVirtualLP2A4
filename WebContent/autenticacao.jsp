<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

	String cpf = request.getParameter("inputEmail3");
	String senha = request.getParameter("senha");	
	
	if (cpf.equals("111.111.111-11") && senha.equals("123") ){
		
	request.getSession().setAttribute("sessao",cpf);
	response.sendRedirect("index.jsp");
	
}
	else{
		
		
		%>
		
		<script>
		alert("Usuário não encontrado.");
		location ="login.jsp";
		</script>
		
		<%
}
%>