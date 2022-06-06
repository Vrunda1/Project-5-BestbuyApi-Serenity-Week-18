package com.localhost.swagger.bestbuyinfo;

import com.localhost.swagger.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UtilitiesStep {

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getVersiondetal() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_UTILITIES)
                .then();
    }

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getHealthcheckupDetail() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_HEALTHCHECK)
                .then();
    }
}







