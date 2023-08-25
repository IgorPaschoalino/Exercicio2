package maven.demo;


public class Pesquisanodb {
	private int code; //codigo
	private String nome; //login
	private String cor; //senha
	private int valor; //sexo
	
	public Pesquisanodb() {
		this.code = -1;
		this.nome = "a";
		this.cor = "";
		this.valor = -1;
	}
	
	public Pesquisanodb(int codigo, String nome, String cor, int valor) {
		this.code = codigo;
		this.nome = nome;
		this.cor = cor;
		this.valor = valor;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int codigo) {
		this.code = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + code + ", nome=" + nome + ", cor=" + cor + ", valor=" + valor + "]";
	}	
}
