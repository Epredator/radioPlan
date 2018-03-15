package com.boot;

import pl.etroya.radioplan.controller.HomeController;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @org.junit.Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das Boot, reporting for duty!");


    }
}
