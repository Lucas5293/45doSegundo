package mthumb.a45doSegundoWeb.controllers;

import static java.lang.String.format;

import java.util.List;
import java.util.Properties;

import mthumb.a45doSegundoWeb.api.APIConnection;
import mthumb.a45doSegundoWeb.core.ModelHandler;
import mthumb.a45doSegundoWeb.core.PropertiesFactory;
import mthumb.a45doSegundoWeb.models.League;

public class ControllerLeague{
		
	Properties propertiesApi;
	
	public ControllerLeague() throws Exception {
		propertiesApi=new PropertiesFactory().get("api");
	}

	@SuppressWarnings("unchecked")
	public List<League> getLeagues() throws Exception {
		String result = APIConnection.sendGet(propertiesApi.getProperty("api.leagues.all"));
		return (List<League>) (Object) ModelHandler.toObjects(League.class,APIConnection.toJSON(result));
	}
	
	@SuppressWarnings("unchecked")
	public List<League> getLeaguesByCountry(String country) throws Exception {
		String result = APIConnection.sendGet(format(propertiesApi.getProperty("api.leagues.by.country"),country));
		return (List<League>) (Object) ModelHandler.toObjects(League.class,APIConnection.toJSON(result));
	}		
		

}
