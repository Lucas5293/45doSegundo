package com.mthumb.a45doSegundoWeb.core;

import org.junit.Test;

import com.mthumb.a45doSegundoWeb.controllers.ControllerLeague;
import com.mthumb.a45doSegundoWeb.impl.ControllerLeagueImpl;

/**
 * Created by lucas on 10/03/2018.
 */

public class ServiceHandlerTest{

    public ControllerLeague controllerLeague;

    @Test
    public void test() throws Exception {
        controllerLeague = (ControllerLeague) ServiceHandler.get(ControllerLeagueImpl.class);
        controllerLeague.getLeagues();
    }
}
