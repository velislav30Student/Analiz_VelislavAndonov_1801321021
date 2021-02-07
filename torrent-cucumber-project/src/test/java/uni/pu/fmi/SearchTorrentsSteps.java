package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.CatalogScreenModel;

public class SearchTorrentsSteps {
	CatalogScreenModel catalogScreen = new CatalogScreenModel();
	
	@Given("^Потребителя орваря страница на каталог$")
	public void OpenCatalogScreen() throws Throwable {
	    catalogScreen.navigateToMe();
	}

	@When("^Въвежда стойност за търсене \"([^\"]*)\"$")
	public void SetSearchText(String text) throws Throwable {
	    catalogScreen.setSearchText(text);
	}

	@When("^Избере тип за търсене \"([^\"]*)\"$")
	public void SelectsSearchType(String typeName) throws Throwable {
	    catalogScreen.addSearchType(typeName);
	}

	@When("^Избере жанр за търсене \"([^\"]*)\"$")
	public void SelectSearchGenre(String genreName) throws Throwable {
		catalogScreen.addSearchGenre(genreName);
	}

	@When("^Натиска върху бутона за търсене$")
	public void ClickSearchButton() throws Throwable {
	    catalogScreen.clickSearchButton();
	}

	@Then("^Вижда списък с торенти \"([^\"]*)\"$")
	public void ShowTorrents(String expected) throws Throwable {
	    assertEquals(expected, catalogScreen.getTorrentList());
	}
	
	@When("^Потребителят не е влязъл в профила си\\(Търсене на торенти\\)$")
	public void UserIsLoggedIn() throws Throwable {
	    catalogScreen.SetIsUserLoggedIn(false);
	}

	@Then("^Вижда съобщение\\(Търсене на торенти\\) \"([^\"]*)\"$")
	public void вижда_съобщение_Търсене_на_торенти(String expected) throws Throwable {
	    assertEquals(expected, catalogScreen.getMessage());
	}

	@When("^Потребителят е влязъл в профила си\\(Търсене на торенти\\)$")
	public void потребителят_е_влязъл_в_профила_си_Търсене_на_торенти() throws Throwable {
		catalogScreen.SetIsUserLoggedIn(true);
	}
}
