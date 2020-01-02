package org.sid.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
	
	@Id
	private String code;
	private String nom;
	private String prenom;
	private String pathphoto;
	
	@DBRef
	private Collection<Analyse> analyses = new ArrayList<>();

	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + " , prenom="+prenom+" ]";
	}
}
