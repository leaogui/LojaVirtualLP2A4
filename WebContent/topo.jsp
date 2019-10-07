<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
   
	String log = (String)session.getAttribute("admin");
    
	if(log == null){
		
	%>
	
	<script>
	
	alert("Faça login!")
	
	location = "/ProjetoWEB/login.jsp";
	
	</script>
	
	<%
}
%>