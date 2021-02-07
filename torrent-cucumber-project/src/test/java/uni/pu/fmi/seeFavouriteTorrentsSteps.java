package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.FavouriteTorrentsScreenModel;

public class seeFavouriteTorrentsSteps {
	FavouriteTorrentsScreenModel favTorrentsModel = new FavouriteTorrentsScreenModel();
	
	@Given("^Потребителя отваря екран за преглед на любими торенти$")
	public void OpenFavouriteTorrentsScreen() throws Throwable {
		favTorrentsModel.navigateToMe();
	}

	@When("^Потребителя не е влязъл в профила си\\(Преглед на любими торенти\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    favTorrentsModel.SetUserIsLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Преглед на любими торенти\\) \"([^\"]*)\"$")
	public void ShowSeeFavouritesMessage(String expected) throws Throwable {
	    assertEquals(expected, favTorrentsModel.getSeeFavouriteTorrentsMessage());
	}

	@When("^Потребителят \"([^\"]*)\" е влязъл в профила си\\(Преглед на любими торентит\\)$")
	public void UserIsLoggedInWithUsername(String username) throws Throwable {
	    favTorrentsModel.SetUserIsLoggedInWithUsername(username);
	}

	@Then("^Вижда списък с торенти - \"([^\"]*)\"$")
	public void ShowFavouriteTorrentsList(String expected) throws Throwable {
	    assertEquals(expected, favTorrentsModel.getFavouriteTorrentList());
	}
}
