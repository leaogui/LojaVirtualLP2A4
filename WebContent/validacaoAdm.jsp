<%@page import="repo.AdminRepo, entidades.Admin" %>
<%
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	Admin admin = new Admin(login, senha);
	
	AdminRepo.addAdmin(admin);
%>
	<script>
		alert("Administrador cadastrado.");
		location="login.jsp";
	</script>