package maven.demo;




public class Principal {
	
	public static void main(String[] args) {
		String nome;
		String cor;
		int code;
		int valor;
		Pesquisanodb pesquisa = new Pesquisanodb();
		Pesquisanodb[] pesquisas=null;
		int q = 1;
		
		DAO dao = new DAO();
		
		dao.conectar();
		while(q!=0) {
		System.out.println("======Menu======");
		System.out.println("1) Listar");
		System.out.println("2) Inserir");
		System.out.println("3) Excluir");
		System.out.println("4) Atualizar");
		System.out.println("5) Sair");
		System.out.println("\n Digite sua opção: ");
		int x = MyIO.readInt();
		
		
		
		switch(x) {
		  case 1:
		    // Listar 
			  
			  pesquisas = dao.getItens();
			  System.out.println("==== Mostrar usuários === ");		
			  for(int i = 0; i < pesquisas.length; i++) {
				  System.out.println(pesquisas[i].toString());
			  }
			  
			  
		    break;
		  case 2:
		    // Inserir 
			  System.out.println("Digite o nome do produto: ");
			  nome = MyIO.readLine();
			  System.out.println("Digite a cor do produto: ");
			  cor = MyIO.readLine();
			  System.out.println("Digite o valor do produto: ");
			  valor = MyIO.readInt();
			  System.out.println("Digite o código do produto: ");
			  code = MyIO.readInt();
			  pesquisa.setNome(nome); pesquisa.setCor(cor); pesquisa.setValor(valor); pesquisa.setCode(code);
			  dao.inserirUsuario(pesquisa);
			  
			  break;
		  case 3:
		    // Excluir
			  System.out.println("Digite o código do produto a ser excluido: ");
			  code = MyIO.readInt();
			  dao.excluirUsuario(code);
			  
			  break;
		  case 4:
			// Atualizar
			  System.out.println("Digite o código do produto que quer atualizar: ");
			  code = MyIO.readInt(); 
			  System.out.println("Digite o nome do produto: ");
			  nome = MyIO.readLine();
			  System.out.println("Digite a cor do produto: ");
			  cor = MyIO.readLine();
			  System.out.println("Digite o valor do produto: ");
			  valor = MyIO.readInt();
			  pesquisa.setNome(nome); pesquisa.setCor(cor); pesquisa.setValor(valor); pesquisa.setCode(code);
			  dao.atualizarUsuario(pesquisa);
			  
			  break;
		  case 5:
			// Sair
			  
			  q = 0;
			  
			  break;
			}
		}
		
		dao.close();
	}
}