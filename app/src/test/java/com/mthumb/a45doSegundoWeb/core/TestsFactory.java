package com.mthumb.a45doSegundoWeb.core;

import org.junit.Test;

/**
 * Created by lucas on 10/03/2018.
 */

public class TestsFactory {

    private ServiceHandler service;

    public TestsFactory(){
        service = new ServiceHandler();
        try {
            service.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServiceHandler getServiceHandler(){
        return  service;
    }
}
