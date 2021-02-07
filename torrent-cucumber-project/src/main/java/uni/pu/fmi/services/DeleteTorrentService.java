package uni.pu.fmi.services;

import java.util.ArrayList;
import java.util.List;

import uni.pu.fmi.Genre;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.Type;
import uni.pu.fmi.User;

public class DeleteTorrentService {

	private static List<Torrent> torrents;
	
	public static String deleteTorrent(Torrent torrent) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			return "Влезте с акаунт, притежаващ административни права";
		}
		if(user.getIsAdmin()) {
				initalizeComponents();
				deleteTorrentFromTorrentList(torrent);
				return "Торентът е изтрит";
		}
		else {
			return "Нямате необходимите права";
		}
	}
	
	private static void deleteTorrentFromTorrentList(Torrent torrent) {
		Torrent torrentToRemove = torrents.stream().filter(t->t.getTitle().equals(torrent)).findFirst().orElse(null);
		if(torrentToRemove!=null) {
			torrents.remove(torrentToRemove);
		}
	}

	private static void initalizeComponents() {
		torrents = new ArrayList<Torrent>();
		
		Type type = new Type("sample");
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(new Genre("sample"));
		Torrent torrent = new Torrent("sample","sample",type,genres,new User());
		
		torrents.add(torrent);
	}
}
