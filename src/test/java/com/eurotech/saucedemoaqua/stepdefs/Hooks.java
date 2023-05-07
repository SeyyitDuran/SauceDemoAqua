package com.eurotech.saucedemoaqua.stepdefs;

import com.eurotech.saucedemoaqua.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {//it runs all time
    @Before//cucumber
    public void setup() {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// in the before wait comment

    }


    @After//cucumber if any scenario will fail I can take ss
    public void tearDown(Scenario scenario) throws InterruptedException {
        //take the ss
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Thread.sleep(4000);
        Driver.closeDriver();
    }

}
