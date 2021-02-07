package uni.pu.fmi.services;

import uni.pu.fmi.Torrent;
import uni.pu.fmi.User;

public class AddTorrentToFavouritesService {

	public static String addToFavourites(Torrent torrent) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			return "Влезте в профила си или се регистрирайте";
		}
		else {
			if(user.IsTorrentInFavourites(torrent)) {
				user.removeFromFavourites(torrent);
				return "Торентът е премахнат от списъка с любими торенти";
			}
			else {
				user.addToFavourites(torrent);
				return "Торентът е добавен в списъка с любими торенти";
			}
		}
	}

}
