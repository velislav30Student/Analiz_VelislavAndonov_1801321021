package uni.pu.fmi.services;

import java.util.ArrayList;
import java.util.List;

import uni.pu.fmi.Catalog;
import uni.pu.fmi.Genre;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.Type;
import uni.pu.fmi.User;

public class SearchTorrentService {

	private static String message;
	private static ArrayList<Type> gameTypes;
	private static ArrayList<Genre> gameGenres;
	private static Catalog catalog;
	private static ArrayList<Torrent> gameTorrents;
	private static ArrayList<Torrent> foundTorrents;

	public static String Search(String searchText, List<String> searchTypes, List<String> searchGenres) {
		User user = UserSessionService.getCurrentUser();
		if(user==null) {
			message = "Влезте в профила си или се регистрирайте";
			return "";
		}
		initializeComponents();
		String torrentList = "";
		
		
		if(!searchText.isBlank()) {
			for (int i = foundTorrents.size()-1; i >= 0; i--) {
				if(!foundTorrents.get(i).getTitle().toLowerCase().contains(searchText.toLowerCase())) {
					foundTorrents.remove(i);
				}
			}
		}
		
		if(!searchTypes.isEmpty()) {
			for (int i = foundTorrents.size()-1; i >= 0; i--) {
				boolean hasType = false;
				for (int j = 0; j < searchTypes.size(); j++) {
					if(foundTorrents.get(i).getType().getTitle().equals(searchTypes.get(j))) {
						hasType = true;
						break;
					}
				}
				if(!hasType) {
					foundTorrents.remove(i);
				}
			}
		}
		
		if(!searchGenres.isEmpty()) {
			for (int i = foundTorrents.size()-1; i >= 0; i--) {
				if(!hasAllGenres(searchGenres, foundTorrents.get(i).getGenres())) {
					foundTorrents.remove(i);
				}
			}
			
		}
		
		if(foundTorrents.isEmpty()) {
			return torrentList;
		}
		
		for (Torrent t : foundTorrents) {
			torrentList+= ", " + t.getTitle();
		}
		
		return torrentList.substring(2);
	}
	
	private static void initializeComponents() {
		gameTypes = new ArrayList<Type>();
		gameTypes.add(new Type("XBox"));
		gameTypes.add(new Type("PC"));
		gameTypes.add(new Type("PS4"));
		
		gameGenres = new ArrayList<Genre>();
		gameGenres.add(new Genre("RPG"));
		gameGenres.add(new Genre("Strategy"));
		gameGenres.add(new Genre("Multiplayer"));
		
		catalog = new Catalog("Игри",gameTypes,gameGenres);
		
		gameTorrents = new ArrayList<Torrent>();
		Type type = gameTypes.get(1);
		ArrayList<Genre> genres = new ArrayList<Genre>();
		genres.add(gameGenres.get(0));
		gameTorrents.add(new Torrent("Skyrim - PC","",type,genres,new User()));
		
		type = gameTypes.get(0);
		genres = new ArrayList<Genre>();
		genres.add(gameGenres.get(0));
		gameTorrents.add(new Torrent("Skyrim - XBox","",type,genres,new User()));
		
		type = gameTypes.get(2);
		genres = new ArrayList<Genre>();
		genres.add(gameGenres.get(0));
		gameTorrents.add(new Torrent("Skyrim - PS4","",type,genres,new User()));
		
		type = gameTypes.get(1);
		genres = new ArrayList<Genre>();
		genres.add(gameGenres.get(1));
		gameTorrents.add(new Torrent("RimWorld","",type,genres,new User()));
		
		type = gameTypes.get(1);
		genres = new ArrayList<Genre>();
		genres.add(gameGenres.get(1));
		genres.add(gameGenres.get(2));
		gameTorrents.add(new Torrent("Warcraft","",type,genres,new User()));
		
		foundTorrents = new ArrayList<Torrent>();
		for (Torrent t : gameTorrents) {
			foundTorrents.add(t);
		}
	}
	
	public static String getMessage() {
		return message;
	}
	
	private static boolean hasAllGenres(List<String> searchGenres,List<Genre>torrentGenres) {
		boolean hasGenre = false;
		for (int i = 0; i < searchGenres.size(); i++) {
			for (int j = 0; j < torrentGenres.size(); j++) {
				if(torrentGenres.get(j).getTitle().equals(searchGenres.get(i))) {
					hasGenre=true;
					break;
				}
				else {
					hasGenre=false;
				}
			}
		}
		return hasGenre;
	}

}
