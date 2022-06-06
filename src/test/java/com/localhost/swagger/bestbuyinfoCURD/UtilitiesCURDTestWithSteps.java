package com.localhost.swagger.bestbuyinfoCURD;


import com.localhost.swagger.bestbuyinfo.UtilitiesStep;
import com.localhost.swagger.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class UtilitiesCURDTestWithSteps extends TestBase {


        @Steps
        UtilitiesStep utilitiesStep;

        @Test
        public void test001() {
                utilitiesStep.getVersiondetal().statusCode(200);
                utilitiesStep.getHealthcheckupDetail().statusCode(200);
        }
}






