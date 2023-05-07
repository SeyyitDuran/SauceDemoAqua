package com.eurotech.saucedemoaqua.stepdefs;

import com.eurotech.saucedemoaqua.pages.LoginPage;
import com.eurotech.saucedemoaqua.pages.ProductPage;
import com.eurotech.saucedemoaqua.utilities.ConfigurationReader;
import com.eurotech.saucedemoaqua.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    LoginPage loginPage=new LoginPage();
    ProductPage productPage=new ProductPage();

    @Given("the user in on the login page")
    public void theUserInOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String userName, String userPassword) {
    loginPage.login(userName,userPassword);
    }

    @Then("the user should be able login successfully")
    public void theUserShouldBeAbleLoginSuccessfully() {
    String expectedHeader="Products";
    String actualHeader=productPage.header.getText();

    Assert.assertEquals(expectedHeader,actualHeader);
    }
}
