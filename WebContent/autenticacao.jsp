<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="repositorio.AdminRepo, entidades.Admin" %>

<%

	String cpf = request.getParameter("inputEmail3");
	String senha = request.getParameter("senha");	
	Admin admin = AdminRepo.getAdmLogin(cpf,senha);
	
	if (admin == null){
		
		%>
		<script>
			alert("Administrador Não Encontrado");
			location="login.jsp";
		</script>
<%
	
}
	else{
		
		
		session.setAttribute("admin",cpf);
		response.sendRedirect("index.jsp");
		
}
%>