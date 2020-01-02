package org.sid.Entities;

import java.io.Serializable;
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
@ToString
public class Analyse implements Serializable {

	@Id
	private String identifiant;
	private String nom;
	private Date date;
	private double prix;
	private  Boolean etatAnalyse;
	
	@DBRef
	private Client client;
	
	
}
