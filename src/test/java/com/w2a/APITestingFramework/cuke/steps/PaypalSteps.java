package com.w2a.APITestingFramework.cuke.steps;
import org.testng.Assert;

import com.w2a.APITestingFramework.cuke.apis.OrderAPI;
import com.w2a.APITestingFramework.cuke.base.BaseTest;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PaypalSteps {
	

	@Before
	public void setUp() {
		
		BaseTest.init();
		
	}
	
	@Given("^I want to get access token from PayPal api$")
		public void i_want_to_get_access_token_from_PayPal_api() {
		OrderAPI.getAccessToken();
			
	};
	
	@When("^I set currency code as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void i_set_currency_code_and_value(String currencyCode, String currencyValue) {
		

		BaseTest.response = OrderAPI.createOrder(currencyCode, currencyValue);
		
		
	}

	@And("^I verify the status as CREATED$")
	public void i_verify_the_status_as_created() {

		Assert.assertEquals(BaseTest.response.jsonPath().get("status").toString(), "CREATED");
	   
	};

}
