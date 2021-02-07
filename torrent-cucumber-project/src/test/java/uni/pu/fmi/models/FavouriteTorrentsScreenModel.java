package uni.pu.fmi.models;

import uni.pu.fmi.services.SeeFavouriteTorrentsService;
import uni.pu.fmi.services.UserSessionService;

public class FavouriteTorrentsScreenModel {

	private String username;

	public void navigateToMe() {
		System.out.println("Екрана за любими торенти е отворен");
	}

	public void SetUserIsLoggedIn(boolean b) {
		if(b) {
			UserSessionService.LogIn();
		}
		else {
			UserSessionService.LogOut();
		}
	}

	public String getSeeFavouriteTorrentsMessage() {
		SeeFavouriteTorrentsService.ShowFavouriteTorrents(username);
		return SeeFavouriteTorrentsService.getMessage();
	}

	public String getFavouriteTorrentList() {
		return SeeFavouriteTorrentsService.ShowFavouriteTorrents(username);
	}

	public void SetUserIsLoggedInWithUsername(String username) {
		SetUserIsLoggedIn(true);
		this.username = username;
	}

}
