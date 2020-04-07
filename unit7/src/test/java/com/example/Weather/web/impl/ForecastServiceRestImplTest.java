package com.example.Weather.web.impl;

import com.example.Weather.web.ForecastService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;





@SpringBootTest(
        properties = {
        InteractiveShellApplicationRunner
                .SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner
                .SPRING_SHELL_SCRIPT_ENABLED + "=false"
})


class ForecastServiceRestImplTest {

    @Autowired
    private ForecastService forecastService;

    @Test
    void getForecast() {
        String fore = forecastService.getForecast("Krasnoyarsk");
        System.out.println(fore);
        Assertions.assertNotNull(fore);
    }
}