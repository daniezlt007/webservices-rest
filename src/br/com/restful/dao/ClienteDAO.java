package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Cliente;

/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Daniel da Silva <danielzt007@outlook.com>
 * @since 02/07/2017 22:04:21
 * @version 1.0
 */
public class ClienteDAO extends ConnectionFactory {

	private static ClienteDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Daniel da Silva <danielzt007@outlook.com>
	 * @since 02/07/2017 22:04:21
 	 * @version 1.0
 	 */
	public static ClienteDAO getInstance(){
		if(instance == null)
			instance = new ClienteDAO();
		return instance;
	}
	
	/**
	 * 
	 * M�todo respons�vel por listar todos os clientes do banco
	 *
	 * @return ArrayList<CLiente> clientes
	 * @author Daniel da Silva <danielzt007@outlook.com>
	 * @since 02/07/2017 22:04:21
 	 * @version 1.0
 	 */
	public ArrayList<Cliente> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;
		
		conexao = criarConexao();
		clientes = new ArrayList<Cliente>();
		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return clientes;
	}
	
	public Cliente buscarNome(String nome){
		Cliente cliente = null;
		Connection conexao = null;
		String sql = "select * from cliente where nome=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		conexao = criarConexao();
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nome);
			rs = pst.executeQuery();
			
			while(rs.next()){
				cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
			}
			return cliente;
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pst, rs);
		}
		
		return cliente;
	}
	
}
