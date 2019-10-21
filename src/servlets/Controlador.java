package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Curso;
import entidades.Pagamento;


@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public String session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
		EntityManager em = emf.createEntityManager();
		
		
		String tipo = request.getParameter("formulario");
		
		
		if(tipo.equals("addc")) {
			
			String nome = request.getParameter("inputNome");
			String email = request.getParameter("inputEMAIL");
			String cpf = request.getParameter("inputEmail3");
			
			Cliente c = new Cliente(nome,email,cpf);
			
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			
			response.sendRedirect("index.jsp");
		}
		
		if(tipo.equals("altc")) {
			
		String nome = request.getParameter("inputNome");
		String email = request.getParameter("inputEMAIL");
		String cpf = request.getParameter("inputEmail3");
		
		Cliente c = em.find(Cliente.class, cpf);
		
		
		if (c == null) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Cliente Inexistente.');");
			out.println("location='/ProjetoWEB/clientes/index.jsp';");
			out.println("</script>");
			out.close();
		}
		
		
		else {
			
		c.setEmail(email);
		c.setNome(nome);
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		
		response.sendRedirect("index.jsp");
		}
		
		}
		
		if(tipo.equals("remoc")) {
			
		String cpf = request.getParameter("inputEmail3");
		
		Cliente c = em.find(Cliente.class, cpf);
		
		if (c == null) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Cliente Inexistente.');");
			out.println("location='/ProjetoWEB/clientes/index.jsp';");
			out.println("</script>");
			out.close();
		}
		
		else {
			
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		response.sendRedirect("index.jsp");
		
		}
		
		}
		
		
		if(tipo.equals("conc")) {
			
			String cpf = request.getParameter("inputEmail3");
			
			Cliente c = em.find(Cliente.class, cpf);
			
			if (c == null) {
				
				
				PrintWriter out = response.getWriter();
				
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Cliente Inexistente.');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
				
			}
			
			else {
				
				
				PrintWriter out = response.getWriter();
						
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+c.toString()+"');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
				
			}
			
		}
		
		
		if(tipo.equals("addcu")){
			
			
			String nome = request.getParameter("inputNome");
			String curso = request.getParameter("inputCURSO");
			String valor = request.getParameter("inputVALOR");
			String site = request.getParameter("inputSITE");
			
			
			Curso cur = new Curso(nome,curso,Float.parseFloat(valor), site);
			
			em.getTransaction().begin();
			em.persist(cur);
			em.getTransaction().commit();
			
			
			response.sendRedirect("index.jsp");
		}
		
		if(tipo.equals("altcu")){
			
			String nome = request.getParameter("inputNome");
			String curso = request.getParameter("inputCURSO");
			String valor = request.getParameter("inputVALOR");
			String site = request.getParameter("inputSITE");
			
			
			Curso cur = em.find(Curso.class, curso);
			
			
			if (cur == null) {
				
				
				PrintWriter out = response.getWriter();
				
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Curso Inexistente.');");
				out.println("location='/ProjetoWEB/cursos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			else {
				
			cur.setNome(nome);
			cur.setSite(site);
			cur.setValor(Float.parseFloat(valor));
			
			
			em.getTransaction().begin();
			em.merge(cur);
			em.getTransaction().commit();
			
			
			response.sendRedirect("index.jsp");
			
			}
			
		}
		
		if(tipo.equals("remocu")){
			
			
			String curso = request.getParameter("inputCURSO");
			
			Curso cur = em.find(Curso.class, curso);
			
			if (cur == null) {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Curso Inexistente.');");
				out.println("location='/ProjetoWEB/cursos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			else {
				
			em.getTransaction().begin();
			em.remove(cur);
			em.getTransaction().commit();
			
			response.sendRedirect("index.jsp");
			
			
			}
			
		}
		
		
		if(tipo.equals("concu")) {
			
			String curso = request.getParameter("inputCURSO");
			
			Curso cur = em.find(Curso.class, curso);
			
			if (cur == null) {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Curso Inexistente.');");
				out.println("location='/ProjetoWEB/cursos/index.jsp';");
				out.println("</script>");
				out.close();
				
				
			}
			
			
			else {
				
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+cur.toString()+"');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
		
			}
			
		}
		
		if(tipo.equals("altp")) {
			
			String cpf = request.getParameter("inputEmail3");
			String curso = request.getParameter("inputCURSO");
			String data_insc = request.getParameter("inputDATA");
			
			Pagamento pag = em.find(Pagamento.class, cpf);
			
			if (pag == null) {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente.');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
				
			}
			
			
			else {
				
			pag.setCurso(curso);
			pag.setData_insc(data_insc);
			
			em.getTransaction().begin();
			em.merge(pag);
			em.getTransaction().commit();
			
			response.sendRedirect("index.jsp");
			
			
			}
			
			
		}
		
		
		if(tipo.equals("addp")) {
			
			String cpf = request.getParameter("inputEmail3");
			String curso = request.getParameter("inputCURSO");
			String data_insc = request.getParameter("inputDATA");
			
			Pagamento pag = new Pagamento(cpf,curso,data_insc);
			
			em.getTransaction().begin();
			em.persist(pag);
			em.getTransaction().commit();
			
			response.sendRedirect("index.jsp");
			
			
		}
		
		
		if(tipo.equals("remop")) {
			
			String cpf = request.getParameter("inputEmail3");
			
			Pagamento pag = em.find(Pagamento.class, cpf);
			
			if (pag == null) {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente.');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			
			else {
				
			em.getTransaction().begin();
			em.remove(pag);
			em.getTransaction().commit();
			
			response.sendRedirect("index.jsp");
			}
			
			
		}
		
		
		if(tipo.equals("conp")) {
			
			String cpf = request.getParameter("inputEmail3");
			
			Pagamento pag = em.find(Pagamento.class, cpf);
			
			if (pag == null) {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Pagamento Inexistente.');");
				out.println("location='/ProjetoWEB/pagamentos/index.jsp';");
				out.println("</script>");
				out.close();
			}
			
			
			else {
				
				PrintWriter out = response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('"+pag.toString()+"');");
				out.println("location='/ProjetoWEB/clientes/index.jsp';");
				out.println("</script>");
				out.close();
				
			}
		}
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}