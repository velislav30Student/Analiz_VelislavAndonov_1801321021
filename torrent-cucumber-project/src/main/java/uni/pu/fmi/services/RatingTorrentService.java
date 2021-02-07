package uni.pu.fmi.services;

import uni.pu.fmi.Rating;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.User;

public class RatingTorrentService {

	private static String message = "";

	public static void RateTorrent(Torrent currentTorrent, float currentTorrentRating, int ratingValue) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			message = "Влезте в профила си или се регистрирайте";
			return;
		}
		InitializeTorrentRatings(currentTorrent, currentTorrentRating);
		Rating rating = new Rating(user,ratingValue);
		currentTorrent.addRating(rating);
	}
	
	private static void InitializeTorrentRatings(Torrent currentTorrent,float currentTorrentRating) {
		if(currentTorrentRating==5){
			User user = new User();
			user.setUsername("name1");
			currentTorrent.addRating(new Rating(user,5));
			user = new User();
			user.setUsername("name2");
			currentTorrent.addRating(new Rating(user,5));
			user = new User();
			user.setUsername("name3");
			currentTorrent.addRating(new Rating(user,5));
		}
	}

	public static String getMessage() {
		if(message.isBlank()) {
			message = "Влезте в профила си или се регистрирайте";
		}
		return message;
	}
}
