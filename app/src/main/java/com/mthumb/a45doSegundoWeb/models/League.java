package com.mthumb.a45doSegundoWeb.models;

import com.mthumb.a45doSegundoWeb.core.EmptyOn;
import com.mthumb.a45doSegundoWeb.core.JSONMapper;
import com.mthumb.a45doSegundoWeb.core.JSONModel;

/** Entidade que representa uma liga
 *  @author lucas
 */
@JSONModel
@EmptyOn(field="countrys", value="null")
public class League {
	
	@JSONMapper(field="idLeague", on = "countrys")
	private int id;
	@JSONMapper(field="strLeague", on = "countrys")
	private String nome;
	@JSONMapper(field="strCountry", on = "countrys")
	private String pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {return nome;}
	
	public void setNome(String nome) {this.nome = nome;}
	
	public String getPais() {return pais;}
	
	public void setPais(String pais) {this.pais = pais;}

}
