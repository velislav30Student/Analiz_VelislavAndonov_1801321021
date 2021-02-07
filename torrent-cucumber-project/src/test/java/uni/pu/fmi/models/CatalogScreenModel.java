package uni.pu.fmi.models;

import java.util.ArrayList;
import java.util.List;

import uni.pu.fmi.services.SearchTorrentService;
import uni.pu.fmi.services.UserSessionService;

public class CatalogScreenModel {

	private String searchText = "";
	private List<String> searchTypes = new ArrayList<String>();
	private List<String> searchGenres = new ArrayList<String>();
	private String torrentList;
	private String message;

	public void navigateToMe() {
		System.out.println("Екранът на каталог е отворен");
	}

	public void setSearchText(String text) {
		searchText = text;
	}

	public void addSearchType(String typeName) {
		if(!typeName.isBlank()) {
			searchTypes.add(typeName);
		}
	}

	public void addSearchGenre(String genreName) {
		if(!genreName.isBlank()) {
			searchGenres.add(genreName);
		}
	}

	public String getTorrentList() {
		return torrentList;
	}

	public void clickSearchButton() {
		torrentList = SearchTorrentService.Search(searchText,searchTypes,searchGenres);
		
	}

	public void SetIsUserLoggedIn(boolean b) {
		if(b) {
			UserSessionService.LogIn();
		}
		else {
			UserSessionService.LogOut();
		}
	}

	public String getMessage() {
		message = SearchTorrentService.getMessage();
		if(message==null) {
			clickSearchButton();
		}
		message = SearchTorrentService.getMessage();
		return message;
	}

}
