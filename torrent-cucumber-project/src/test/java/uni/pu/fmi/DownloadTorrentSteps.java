package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.TorrentPageModel;

public class DownloadTorrentSteps {
	TorrentPageModel torrentPage = new TorrentPageModel();
	
	@Given("^Потребителят отваря страницата на торент\\(Теглене на торент\\)$")
	public void OpenTorrentPage() throws Throwable {
	    torrentPage.navigateToMe();
	}

	@When("^Потребителят не е влязъл в профила си\\(Теглене на торент\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Теглене на торент\\) \"([^\"]*)\"$")
	public void ShowDownloadMessage(String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, torrentPage.getDownloadMessage());
	}

	@Given("^Торентa има (\\d+) брой изтегляния$")
	public void SetTorrentDownloads(int downloads) throws Throwable {
	    torrentPage.setTorrentDownloads(downloads);
	}

	@When("^Потребителят е влязъл в профила си\\(Теглене на торент\\)$")
	public void UserIsLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(true);
	}

	@When("^Кликне върху бутона за теглене$")
	public void кликне_върху_бутона_за_теглене() throws Throwable {
	    torrentPage.clickDownloadButton();
	}

	@Then("^Торента вече има (\\d+) брой изтегляния$")
	public void торента_вече_има_брой_изтегляния(int expected) throws Throwable {
	    assertEquals(expected, torrentPage.getTorrentDownloads());
	}
}
