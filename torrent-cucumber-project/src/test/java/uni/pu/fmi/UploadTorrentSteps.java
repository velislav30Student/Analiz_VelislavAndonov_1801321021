package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.UploadTorrentScreenModel;
import static org.junit.Assert.assertEquals;

public class UploadTorrentSteps {
	UploadTorrentScreenModel uploadTorrentScreen = new UploadTorrentScreenModel();
	
	@Given("^Потребителят отваря страницата за качване на торент$")
	public void openUploadTorrentScreen() throws Throwable {
		uploadTorrentScreen.navigateToMe();
	}

	@When("^Потребителят не е влязъл в профила си$")
	public void UserIsNotLoggedIn() throws Throwable {
	    uploadTorrentScreen.setUserLoggedIn(false);
	}
	
	@When("^Потребителят е влязъл в профила си$")
	public void UserIsLoggedIn() throws Throwable {
	    uploadTorrentScreen.setUserLoggedIn(true);
	}

	@When("^Въвежда заглавие \"([^\"]*)\"$")
	public void addTitle(String title) throws Throwable {
	    uploadTorrentScreen.setTitle(title);
	}

	@When("^Въвежда описание \"([^\"]*)\"$")
	public void addDescription(String description) throws Throwable {
	    uploadTorrentScreen.setDescription(description);
	}

	@When("^Въвежда каталог \"([^\"]*)\"$")
	public void addCatalog(String catalogName) throws Throwable {
	   uploadTorrentScreen.setCatalog(catalogName);
	}

	@When("^Въвежда тип \"([^\"]*)\"$")
	public void addType(String typeName) throws Throwable {
	    uploadTorrentScreen.setType(typeName);
	}

	@When("^Въвежда жанрове \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void addGenres(String genreName1, String genreName2, String genreName3) throws Throwable {
	    uploadTorrentScreen.setGenres(genreName1,genreName2,genreName3);
	}

	@When("^Кликва върху бутона за качване на торент$")
	public void ClickUploadButton() throws Throwable {
	    uploadTorrentScreen.clickUploadButton();
	}

	@Then("^Вижда съобщение \"([^\"]*)\"$")
	public void ShowMessage(String expectedMessage) throws Throwable {
		assertEquals(expectedMessage, uploadTorrentScreen.getUploadMessage());
	}

}
