package com.localhost.swagger.bestbuyinfoCURD;


import com.localhost.swagger.bestbuyinfo.ServicesSteps;
import com.localhost.swagger.testbase.TestBase;
import com.localhost.swagger.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithSteps extends TestBase {

    static String name = "Mobile Shop" + TestUtils.getRandomValue();
    static int serviceID;

    @Steps
    ServicesSteps servicesSteps;

    @Title("This will create new store")
    @Test
    public void test001() {

        ValidatableResponse response = servicesSteps.createService(name);
        response.log().all().statusCode(201);
        serviceID = response.log().all().extract().path("id");
        System.out.println(serviceID);


    }

    @Title("Verify if the services is created")
    @Test
    public void test002() {
        HashMap<String, Object> serviceMap = servicesSteps.getServicesInfoById(serviceID);
        Assert.assertThat(serviceMap, hasValue(name));
        System.out.println(serviceMap);
    }

    @Test
    public void test003() {

        name = name + "_updated";
        servicesSteps.updateService(serviceID, name).log().all().statusCode(200);
        HashMap<String, Object> storeyMap = servicesSteps.getServicesInfoById(serviceID);
        Assert.assertThat(storeyMap, hasValue(name));

    }

    @Title("Delete Service and verify if the Service is deleted")
    @Test
    public void test004() {
        servicesSteps.deleteService(serviceID).statusCode(200);
        servicesSteps.getServiceById(serviceID).statusCode(404);
    }
}

