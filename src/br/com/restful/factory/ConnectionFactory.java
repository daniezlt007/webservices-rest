package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsável por conter os metodos criar e fechar o banco de dados.
 *
 * @author Daniel da Silva <danielzt007@outlook.com>
 * @since 02/07/2017 22:04:21
 * @version 1.0
 */
public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/webservice";
	private static final String USUARIO = "seu_usuario";
	private static final String SENHA = "sua_senha";
	

	/**
	 * 
	 * Método responsável por criar uma conexao com o banco 
	 *
	 * @return
	 * @author Daniel da Silva <danielzt007@outlook.com>
	 * @since 02/07/2017 22:04:21
 	 * @version 1.0
 	 */
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}
	}
}

