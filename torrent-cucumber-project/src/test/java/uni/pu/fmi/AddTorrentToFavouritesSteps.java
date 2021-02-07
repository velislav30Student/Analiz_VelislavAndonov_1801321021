package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.TorrentPageModel;

public class AddTorrentToFavouritesSteps {
	private TorrentPageModel torrentPage = new TorrentPageModel();
	
	@Given("^Потребителят отваря страницата на торент$")
	public void OpenTorrentPage() throws Throwable {
		torrentPage.navigateToMe();
	}

	@When("^Потребителят не е влязъл в профила си\\(Добавяна на торенти в любими\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Добавяна на торенти в любими\\) \"([^\"]*)\"$")
	public void ShowMessage(String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, torrentPage.getAddFavouritesMessage());
	}

	@Given("^Торентът не е в любимите торенти на потребителя$")
	public void TorrentIsNotInUserFavourites() throws Throwable {
	    torrentPage.TorrentIsInUserFavourites(false);
	}

	@When("^Потребителят е влязъл в профила си\\(Добавяна на торенти в любими\\)$")
	public void UserIsLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(true);
	}

	@When("^Кликне върху бутона за добавяне в любими$")
	public void ClickAddFavouriteButton() throws Throwable {
	    torrentPage.clickAddFavouritesButton();
	}

	@Given("^Торентът е в любимите торенти на потребителя$")
	public void TorrentIsInUserFavourites() throws Throwable {
		torrentPage.TorrentIsInUserFavourites(true);
	}
}
