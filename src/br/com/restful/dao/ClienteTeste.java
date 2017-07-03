package br.com.restful.dao;

import br.com.restful.model.Cliente;

public class ClienteTeste {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		cliente = dao.buscarNome("Alice");
		
		System.out.println(cliente.toString());

	}

}
