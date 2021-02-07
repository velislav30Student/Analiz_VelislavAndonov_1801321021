package uni.pu.fmi.models;

import java.util.ArrayList;
import java.util.List;

import uni.pu.fmi.Genre;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.Type;
import uni.pu.fmi.User;
import uni.pu.fmi.services.AddTorrentToFavouritesService;
import uni.pu.fmi.services.CommentinService;
import uni.pu.fmi.services.DeleteTorrentService;
import uni.pu.fmi.services.DownloadTorrentService;
import uni.pu.fmi.services.RatingTorrentService;
import uni.pu.fmi.services.UserSessionService;

public class TorrentPageModel {

	private Torrent currentTorrent;
	private String message;
	private String commentText;
	private float currentTorrentRating;

	public void navigateToMe() {
		Type type = new Type("sample");
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(new Genre("sample"));
		currentTorrent = new Torrent("sample","sample",type,genres,new User());
		System.out.println("Екран на Торента е отворен");
	}

	public void setIsUserLoggedIn(boolean b) {
		if(b) {
			UserSessionService.LogIn();
		}
		else {
			UserSessionService.LogOut();
		}
	}

	public String getAddFavouritesMessage() {
		if(message==null) {
			clickAddFavouritesButton();
		}
		return message;
	}

	public void TorrentIsInUserFavourites(boolean b) {
		if(b) {
			AddTorrentToFavouritesService.addToFavourites(currentTorrent);
		}
	}

	public void clickAddFavouritesButton() {
		message = AddTorrentToFavouritesService.addToFavourites(currentTorrent);
	}
	
	public void clickDeleteTorrentButton() {
		message = DeleteTorrentService.deleteTorrent(currentTorrent);
	}

	
	public String getDeleteMessage() {
		if(message==null) {
			clickDeleteTorrentButton();
		}
		return message;
	}

	public void setIsUserAdmin(boolean b) {
		if(b) {
			UserSessionService.PromoteUser();
		}
		else {
			UserSessionService.DemoteUser();
		}
	}

	public void setTorrentDownloads(int downloads) {
		currentTorrent.setDownloadCount(downloads);
	}

	public int getTorrentDownloads() {
		return currentTorrent.getDownloadCount();
	}

	public void clickDownloadButton() {
		message = DownloadTorrentService.downloadTorrent(currentTorrent);
	}

	public String getDownloadMessage() {
		if(message == null) {
			clickDownloadButton();
		}
		return message;
	}

	public void setCommentText(String text) {
		commentText = text;
	}

	public String getCommentMessage() {
		if(message==null) {
			clickPublishCommentButton();
		}
		return message;
	}

	public void clickPublishCommentButton() {
		message = CommentinService.publishComment(commentText, currentTorrent);
	}

	public String getRatingMessage() {
		return RatingTorrentService.getMessage();
	}

	public void setIsUserLoggedInWithUsername(String username) {
		setIsUserLoggedIn(true);
		UserSessionService.getCurrentUser().setUsername(username);
	}

	public void SetTorrentCurrentRating(float rating) {
		currentTorrentRating = rating;
	}

	public void RateTorrent(int rating) {
		RatingTorrentService.RateTorrent(currentTorrent,currentTorrentRating,rating);
	}

	public String getTorrentRating() {
		return String.valueOf(currentTorrent.getRating());
	}
}
