package org.sid.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.sid.Dao.ClientRepository;
import org.sid.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(name = "clientSoapWebservice")
public class ClientSoapWebservice {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@WebMethod
	public List<Client> getClientsByName(@WebParam(name = "nom")String nom){
		System.out.println(clientRepository.findAllByNomContains(nom));
		System.out.println(nom);
		return clientRepository.findAllByNomContains(nom);
	}
	

}
