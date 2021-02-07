package uni.pu.fmi.models;

import uni.pu.fmi.services.UploadTorrentService;
import uni.pu.fmi.services.UserSessionService;

public class UploadTorrentScreenModel {

	private String title;
	private String description;
	private String catalogName;
	private String typeName;
	private String genreName1;
	private String genreName2;
	private String genreName3;
	private String message;

	public void navigateToMe() {
		System.out.println("Екрана за качване на торенти е отворен");
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCatalog(String catalogName) {
		this.catalogName = catalogName;
	}

	public void setType(String typeName) {
		this.typeName = typeName;
	}

	public void setGenres(String genreName1, String genreName2, String genreName3) {
		this.genreName1 = genreName1;
		this.genreName2 = genreName2;
		this.genreName3 = genreName3;
	}

	public void clickUploadButton() {
		message = UploadTorrentService.uploadTorrent(title,description,catalogName,typeName,genreName1,genreName2, genreName3);
	}

	public String getUploadMessage() {
		if(message==null) {
			clickUploadButton();
		}
		return message;
	}

	public void setUserLoggedIn(boolean b) {
		if(b) {
			UserSessionService.LogIn();
		}
		else {
			UserSessionService.LogOut();
		}
	}
}
