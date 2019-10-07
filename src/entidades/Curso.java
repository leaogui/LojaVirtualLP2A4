package entidades;

import javax.persistence.Entity;

@Entity
public class Curso {
	
	private String nome;
	private String curso;
	private float valor;
	private String site;
	
	 
	public Curso(String nome,String curso, float valor, String site) {
		
		this.nome = nome;
		this.curso = curso;
		this.valor = valor;
		this.site = site;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}
	@Override
	public String toString() {
		return "Curso: Nome= " + nome + " Curso= " + curso + " Valor= " + valor + " Site= " + site;
	}
}