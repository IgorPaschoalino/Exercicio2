package maven.demo;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "banco";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirUsuario(Pesquisanodb pesquisa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO produtos (nome, cor, valor, code) "
					       + "VALUES ('"+pesquisa.getNome()+ "', '" + pesquisa.getCor() + "', '"  
					       + pesquisa.getValor() + "', " + pesquisa.getCode() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarUsuario(Pesquisanodb pesquisa) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE produtos SET nome = '" + pesquisa.getNome() + "', cor = '"  
				       + pesquisa.getCor() + "', valor = " + pesquisa.getValor() + ""
					   + " WHERE code = " + pesquisa.getCode();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirUsuario(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM produtos WHERE code = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Pesquisanodb[] getItens() {
		Pesquisanodb[] Pesquisa = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM produtos");		
	         if(rs.next()){
	             rs.last();
	             Pesquisa = new Pesquisanodb[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	 Pesquisa[i] = new Pesquisanodb(rs.getInt("code"), rs.getString("nome"), 
	                		                  rs.getString("cor"), rs.getInt("valor"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return Pesquisa;
	}

	
	
	}
