package uni.pu.fmi.services;

import uni.pu.fmi.Torrent;
import uni.pu.fmi.User;

public class DownloadTorrentService {

	public static String downloadTorrent(Torrent currentTorrent) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			return "Влезте в профила си или се регистрирайте";
		}
		currentTorrent.download();
		return "Изтеглянето е успешно";
	}

}
