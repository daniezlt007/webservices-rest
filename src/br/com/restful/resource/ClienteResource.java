package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restful.controller.ClienteController;
import br.com.restful.dao.ClienteDAO;
import br.com.restful.model.Cliente;

import com.google.gson.Gson;

/**
 * 
 * Classe responsável por conter os metodos REST de acesso ao webservice
 *
 * @author Daniel da Silva <danielzt007@outlook.com>
 * @since 02/07/2017 22:04:21
 * @version 1.0
 */
@Path("/cliente")
public class ClienteResource {

	/**
	 * 
	 * Método responsável por fazer chamada ao controller
	 *
	 * @return ArrayList<Cliente> 
	 * @author Daniel da Silva <danielzt007@outlook.com>
	 * @since 02/07/2017 22:04:21
 	 * @version 1.0
 	 */
	@GET
	@Path("/listarTodos")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> listarTodos(){
		return new ClienteController().listarTodos();
	}
	
	@GET
	@Path("/listarNome/{nome}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente listarNome(@PathParam("nome") String nome){
		Cliente cliente = null;
		try {
			cliente = ClienteDAO.getInstance().buscarNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
}
