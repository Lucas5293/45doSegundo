package com.mthumb.a45doSegundoWeb.core;

import com.mthumb.a45doSegundoWeb.controllers.ControllerEvent;
import com.mthumb.a45doSegundoWeb.controllers.ControllerTeam;
import com.mthumb.a45doSegundoWeb.impl.ControllerEventImpl;
import com.mthumb.a45doSegundoWeb.impl.ControllerTeamImpl;
import com.mthumb.a45doSegundoWeb.models.Event;
import com.mthumb.a45doSegundoWeb.models.League;
import com.mthumb.a45doSegundoWeb.models.Team;
import org.junit.Before;
import org.junit.Test;

import com.mthumb.a45doSegundoWeb.controllers.ControllerLeague;
import com.mthumb.a45doSegundoWeb.impl.ControllerLeagueImpl;

/**
 * Created by lucas on 10/03/2018.
 */

public class ServiceHandlerTest{

    public ControllerLeague controllerLeague;
    public ControllerTeam controllerTeam;
    public ControllerEvent controllerEvent;

    @Before
    public void setUp(){
        controllerLeague = (ControllerLeague) ServiceHandler.get(ControllerLeagueImpl.class);
        controllerTeam = (ControllerTeam) ServiceHandler.get(ControllerTeamImpl.class);
        controllerEvent = (ControllerEvent) ServiceHandler.get(ControllerEventImpl.class);
    }

    @Test
    public void test() throws Exception {

        System.out.println("Ligas\n");

        for (League liga : controllerLeague.getLeagues()){
            System.out.println(liga.getNome());
        }

        System.out.println("\nTimes\n");

        for (Team team : controllerTeam.getTeamByName("sport")){
            System.out.println(team.getNome());
        }

        int id = controllerTeam.getTeamByName("sport").get(0).getId();

        System.out.println("\nJogos\n");

        for (Event event: controllerEvent.getLastFiveEventsByTeamId(id)){
            System.out.println(event.getHomeTeam()+" vs "+event.getAwayTeam());
        }

    }
}
