package stepDefinitions;

import pageobjects.UnitTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class Steps {

	UnitTest etsy = new UnitTest();
		
	@Given("^I navigate to the etsy homepage$")
	public void i_navigate_to_the_etsy_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.navigateToEtsyHomePage();
	}

	@Then("^I want to accept privacy settings$")
	public void i_want_to_accept_privacy_settings() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.acceptEtsyPrivacySettings();
	}

	@And("^I want to enter partial search string \"([^\"]*)\"$")
	public void i_want_to_enter_partial_search_string(String pstring) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.enterPartialSearchString(pstring);
	}

	@When("^I want to search for given string \"([^\"]*)\"$")
	public void i_want_to_search_for_given_string(String searchstring) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.searchGivenString(searchstring);
	}

	@Then("^I want to sort results by \"([^\"]*)\"$")
	public void i_want_to_sort_results_by(String sortBy) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.sortSearchResultsBy(sortBy);
	}

	@And("^I want to get first \"([^\"]*)\" prices$")
	public void i_want_to_get_first_prices(int nprices) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    etsy.getFirstNPrices(nprices);
	}
	
}
