package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.TorrentPageModel;

public class CommentOnTorrentSteps {
	TorrentPageModel torrentPage = new TorrentPageModel();
	
	@Given("^Потребителят отваря страницата на торент\\(Коментиране на торент\\)$")
	public void OpenTorrentPage() throws Throwable {
	    torrentPage.navigateToMe();
	}

	@When("^Потребителя не е влязъл в профила си\\(Коментиране на торент\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Коментиране на торент\\) \"([^\"]*)\"$")
	public void ShowCommentMessage(String expected) throws Throwable {
	    assertEquals(expected, torrentPage.getCommentMessage());
	}

	@When("^Потребителя е влязъл в профила си\\(Коментиране на торент\\)$")
	public void UserIsLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(true);
	}

	@When("^Въвежда текст \"([^\"]*)\" в полето за създаване на коментар$")
	public void SetCommentText(String text) throws Throwable {
	    torrentPage.setCommentText(text);
	}

	@When("^Натиска върху бутон публикувай$")
	public void ClickPublishCommentButton() throws Throwable {
	    torrentPage.clickPublishCommentButton();
	}
}
