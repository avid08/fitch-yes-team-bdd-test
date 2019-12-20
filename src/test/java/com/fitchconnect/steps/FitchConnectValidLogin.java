package com.fitchconnect.steps;

import com.fitchconnect.pages.HomePage;
import com.fitchconnect.pages.LoginPage;
import com.fitchconnect.pages.MemberPage;
import com.fitchconnect.pages.PageManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class FitchConnectValidLogin {

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private MemberPage member = PageManager.getInstance().getMember();

	@Given("User opens test browser")
	public void user_opens_test_browser() {
		System.out.println("Opening website.");
	}

	@When("User goes to {string} website")
	public void user_goes_to_website(String website) {
		home.goToHomepage(website);
	}

	@Then("User clicks LOGIN")
	public void user_clicks_LOGIN() {
		home.clickLogIn();
	}

	@Then("User clicks Fitch Connect")
	public void user_clicks_Fitch_Connect() {
		home.clickFitchConnect();
	}

	@Then("User is taken to Fitch Connect login page")
	public void user_is_taken_to_Fitch_Connect_login_page() {
		login.verify_LoginPage();
	}

	@Then("User enters {string} as username")
	public void user_enters_as_username(String username) {
		login.enterUsername(username);
	}

	@Then("User enters {string} as password")
	public void user_enters_as_password(String password) {
		login.enterPassword(password);
	}

	@Then("User clicks on Log In button")
	public void user_clicks_on_Log_In_button() {
		login.clickSubmit();
	}

	@Then("User is taken to member home page")
	public void user_is_taken_to_member_home_page() {
		member.verify_MemberPage();
	}

	@Then("User clicks log out")
	public void user_clicks_log_out() {
		member.logout();
	}

	@Then("User closes test browser")
	public void user_closes_test_browser() {
		System.out.println("Closing browser.");
	}

}
