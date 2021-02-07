package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.TorrentPageModel;

public class RateTorrentSteps {
	private TorrentPageModel torrentPage = new TorrentPageModel();
	
	@Given("^Потребителят отваря страницата на торент\\(Оценяване на торент\\)$")
	public void OpenTorrentPage() throws Throwable {
		torrentPage.navigateToMe();
	}

	@When("^Потребителят не е влязъл в профила си\\(Оценяване на торент\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Оценяване на торент\\) \"([^\"]*)\"$")
	public void ShowRatingMessage(String expected) throws Throwable {
	    assertEquals(expected, torrentPage.getRatingMessage());
	}

	@When("^Потребителят \"([^\"]*)\" е влязъл в профила си\\(Оценяване на торент\\)$")
	public void UserIsLoggedIn(String username) throws Throwable {
	    torrentPage.setIsUserLoggedInWithUsername(username);
	}

	@When("^Торента има текуща оценка (\\d+)$")
	public void SetTorrentCurrentRating(float rating) throws Throwable {
	    torrentPage.SetTorrentCurrentRating(rating);
	}

	@When("^Потребителя оцени торента с оценка (\\d+)$")
	public void RateTorrent(int rating) throws Throwable {
		torrentPage.RateTorrent(rating);
	}
	@When("^Потребителя променя оценката си на торента с оценка (\\d+)$")
	public void SetNewRating(int rating) throws Throwable {
	    torrentPage.RateTorrent(rating);
	}

	@Then("^На потребителя е показана нова оценка на торента \"([^\"]*)\"$")
	public void на_потребителя_е_показана_нова_оценка_на_торента(String expected) throws Throwable {
	    assertEquals(expected, torrentPage.getTorrentRating());
	}
}
