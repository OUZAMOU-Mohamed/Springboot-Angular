package org.sid.Dao;

import java.util.List;

import org.sid.Entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepository extends MongoRepository<Client, String> {
	List<Client>findAllByNomContains(String nom);

}
