package com.localhost.swagger.bestbuyinfoCURD;


import com.localhost.swagger.bestbuyinfo.CategoriesSteps;
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
public class CategoriesCURDTestWithSteps extends TestBase {

        static  String name = "Electronics & Computers" + TestUtils.getRandomValue();
        static String id = "12" +TestUtils.getRandomValue();
        static String categoryId;

        @Steps
        CategoriesSteps categoriesSteps;

        @Title("This will create new Category")
        @Test
        public void test001() {
                ValidatableResponse response = categoriesSteps.createCategory(name,id);
                response.log().all().statusCode(201);
                categoryId = response.log().all().extract().path("id");
                System.out.println(categoryId);
        }
        @Title("Verify if the Category was created in application")
        @Test
        public void test002(){
                HashMap<String, Object> value = categoriesSteps.getCategoryinfoById(categoryId);
                Assert.assertThat(value, hasValue(name));
                System.out.println(value);
        }
        @Title("Update Category information and verify the updated information")
        @Test
        public void test003() {

                name = name + "_updated";
                categoriesSteps.updateCategory(categoryId,name,id).log().all().statusCode(200);
                HashMap<String, Object> value = categoriesSteps.getCategoryinfoById(categoryId);
                Assert.assertThat(value, hasValue(categoryId));
                System.out.println(value);
        }
        @Title("Delete the category and verify if the category is deleted!")
        @Test
        public void test004() {
                categoriesSteps.deleteCategory(categoryId).statusCode(200);
                categoriesSteps.getCategoryById(categoryId).statusCode(404);
        }


}
