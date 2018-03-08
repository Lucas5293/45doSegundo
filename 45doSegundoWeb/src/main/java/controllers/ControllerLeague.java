package controllers;

import static java.lang.String.format;

import java.util.List;
import java.util.Properties;

import api.APIConnection;
import core.ModelHandler;
import core.PropertiesFactory;
import models.League;

public class ControllerLeague{
		
	Properties propertiesApi;
	
	public ControllerLeague() throws Exception {
		propertiesApi=PropertiesFactory.get("api");
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
