package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

/**
 * 
 * Classe responsável por ser o controlador entre o resource e a camada DAO
 *
 * @author Daniel da Silva <danielzt007@outlook.com>
 * @since 02/07/2017 22:04:21
 * @version 1.0
 */
public class ClienteController {
	
	public ArrayList<Cliente> listarTodos(){
		System.out.println("Enviando para o GIT");
		return ClienteDAO.getInstance().listarTodos();
	}
	
	public Cliente buscarNome(String nome){
		System.out.println("ListarNome no Controller...");
		return ClienteDAO.getInstance().buscarNome(nome);
	}
	
}
