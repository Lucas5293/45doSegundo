package mthumb.a45doSegundoWeb.models;

import mthumb.a45doSegundoWeb.core.JSONMapper;

/** Entidade que representa uma liga
 *  @author lucas
 */
public class League {
	
	@JSONMapper(field="idLeague", on = "countrys")
	public int id;
	@JSONMapper(field="strLeague", on = "countrys")
	public String nome;
	@JSONMapper(field="strCountry", on = "countrys")
	public String pais;
	
	public String getNome() {return nome;}
	
	public void setNome(String nome) {this.nome = nome;}
	
	public String getPais() {return pais;}
	
	public void setPais(String pais) {this.pais = pais;}

}
