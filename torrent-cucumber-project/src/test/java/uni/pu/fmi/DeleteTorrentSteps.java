package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.TorrentPageModel;

public class DeleteTorrentSteps {
	TorrentPageModel torrentPage = new TorrentPageModel();

	@Given("^Потребителят отваря страницата на торент\\(Изтриване на торент\\)$")
	public void потребителят_отваря_страницата_на_торент_Изтриване_на_торент() throws Throwable {
	    torrentPage.navigateToMe();
	}
	
	@When("^Потребителя кликва върху бутона за изтриване$")
	public void ClickDeleteButton() throws Throwable {
	    torrentPage.clickDeleteTorrentButton();
	}

	@When("^Потребителя не е влязъл в профила си\\(Изтриване на торент\\)$")
	public void UserIsNotLoggedIn() throws Throwable {
	    torrentPage.setIsUserLoggedIn(false);
	}
	
	@When("^Потребителят е влязъл в профила си\\(Изтриване на торент\\)$")
	public void потребителят_е_влязъл_в_профила_си_Изтриване_на_торент() throws Throwable {
		torrentPage.setIsUserLoggedIn(true);
	}

	@When("^Потребителя притежава административни права$")
	public void UserIsAdmin() throws Throwable {
		torrentPage.setIsUserAdmin(true);
	}

	@When("^Потребителя не притежава административни права$")
	public void UserIsNotAdmin() throws Throwable {
		torrentPage.setIsUserAdmin(false);
	}
	
	@Then("^Вижда съобщение\\(Изтриване на торент\\) \"([^\"]*)\"$")
	public void ShowMessage(String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, torrentPage.getDeleteMessage());
	}
	
}
