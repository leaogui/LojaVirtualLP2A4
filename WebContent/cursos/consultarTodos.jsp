<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "javax.persistence.EntityManager, javax.persistence.EntityManagerFactory, javax.persistence.Persistence, javax.persistence.TypedQuery, entidades.Curso, java.util.List" %>
    <!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/js/bootstrap.min.js"></script>
    <link href="../lib/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../lib/css/padrao.css" rel="stylesheet" type="text/css">
  </head><body>
  <%@ include file="../topo.jsp" %>
    <div class="section section-danger text-justify">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12 text-center">
            <h1 class="text-center">Sistema de Gerenciamento de Cursos</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
                       <%
	            			EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
	            			EntityManager em = emf.createEntityManager();
	            			
	            			TypedQuery<Curso> query = em.createQuery("select c from Curso c", Curso.class); 
	            			
	            			List<Curso> cursos = query.getResultList();
	            			
	            			if (cursos.size() == 0){
	            				
	            				
	            		%>	
	            			<p>Não existe nenhum curso.</p><br><br><br>		
	            		<%
	            		
	            			}
	            			
	            			else
	            			{
	            				
	            				for (Curso c : cursos){
	            		%>	
	            					<p><%=c.toString()%></p><br><br>
	            					
	            		<%
	            			}
	            		}
	            		%>

                </div>
              </div>

          </div>
        </div>
    <footer>
      <div class="navbar navbar-fixed-bottom bgred">
        <div class="container">
          <div class="row">
            <div class="col-sm-12 text-center" style="top:13px;color:#fff;">Guigs Corporation</div>
          </div>
        </div>
      </div>
    </footer>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center corrigir">
            <a class="btn btn-default" href="/ProjetoWEB/cursos/index.jsp">Voltar</a>
          </div>
        </div>
      </div>
    </div>
  

</body></html>