package br.com.zuuuum.persistence.entidade;

public class Jogador {

	private int id;
	private String nome;
	private Integer idade;
	private Integer gols;
	
	public Jogador(){}
	
	public Jogador(Integer idade, Integer gols){
		this.idade = idade;
		this.gols = gols;
	}
	
	public Jogador(String nome, Integer idade, Integer gols){
		this.nome = nome;
		this.idade = idade;
		this.gols = gols;
	}
	
	public Jogador(int id, String nome, Integer idade, Integer gols){
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.gols = gols;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Integer getGols() {
		return gols;
	}
	public void setGols(Integer gols) {
		this.gols = gols;
	}

	@Override
	public String toString() {
		return "[Id: " + id + "]\n["
				+ "Nome: " + nome + "]\n["
						+ "Idade: " + idade + "]\n["
								+ "Gols: " + gols + "]";
	}
	
	public String toStringHTML() {
		return "[Id: " + id + "]<br />["
				+ "Nome: " + nome + "]<br />["
				+ "Idade: " + idade + "]<br />["
				+ "Gols: " + gols + "]<br />";
	}
	
	
}
