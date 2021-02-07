package uni.pu.fmi.services;

import java.util.ArrayList;
import java.util.List;

import uni.pu.fmi.Genre;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.Type;
import uni.pu.fmi.User;

public class SeeFavouriteTorrentsService {

	private static String message;

	public static String ShowFavouriteTorrents(String username) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			message = "Влезте в профила си или се регистрирайте";
			return "";
		}
		InitializeCurrentUser(username);
		if(user.getFavouriteTorrents().isEmpty()) {
			message = "Добавете торенти към любими";
			return "";
		}
		String favouriteTorrentsList = "";
		for (Torrent t : user.getFavouriteTorrents()) {
			favouriteTorrentsList += ", " + t.getTitle();
		}
		favouriteTorrentsList = favouriteTorrentsList.substring(2);
		return favouriteTorrentsList;
	}
	
	public static String getMessage() {
		return message;
	}
	
	private static void InitializeCurrentUser(String username) {
		User user = UserSessionService.getCurrentUser();
		
		Type type = new Type("sample");
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(new Genre("sample"));
		
		switch (username) {
		case "name":
			user.addToFavourites(new Torrent("Sample","sample",type,genres,new User()));
			break;
		case "name2":
			user.addToFavourites(new Torrent("Sample1","sample",type,genres,new User()));
			user.addToFavourites(new Torrent("Sample2","sample",type,genres,new User()));
			break;
		case "name3":
			user.addToFavourites(new Torrent("Sample1","sample",type,genres,new User()));
			user.addToFavourites(new Torrent("Sample2","sample",type,genres,new User()));
			user.addToFavourites(new Torrent("Sample3","sample",type,genres,new User()));
			break;
		}
	}
}
