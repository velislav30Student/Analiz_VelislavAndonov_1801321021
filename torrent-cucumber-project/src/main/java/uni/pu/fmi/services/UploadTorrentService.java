package uni.pu.fmi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import uni.pu.fmi.Catalog;
import uni.pu.fmi.Genre;
import uni.pu.fmi.Torrent;
import uni.pu.fmi.Type;
import uni.pu.fmi.User;

public class UploadTorrentService {
	
	private static List<Catalog> catalogs;
	private static List<Type> gameTypes;
	private static List<Genre> gameGenres;
	private static List<Torrent> torrents;

	public static String uploadTorrent(String title, String description, String catalogName, String typeName,
			String genreName1, String genreName2, String genreName3) {
		User user = UserSessionService.getCurrentUser();
		if(user == null) {
			return "Влезте в профила си или се регистрирайте";
		}
		
		initializeComponents();
		
		if(title.isBlank()) {
			return "Въведете заглавие";
		}
		
		if(description.isBlank()) {
			return "Въведете описание";
		}
		
		if(genreName1.equals(genreName2) && !genreName1.isBlank() || genreName1.equals(genreName3) && !genreName1.isBlank() 
				|| genreName3.equals(genreName2) && !genreName2.isBlank()) {
			return "Не повтаряйте жанрове";
		}
		
		Catalog catalog = getCatalogByName(catalogName);
		if(catalog == null) {
			return "Изберете валиден каталог";
		}
		
		Type type = getTypeByName(typeName,catalog);
		if(type == null) {
			return "Изберете валиден тип";
		}
		
		List<Genre> genres = new ArrayList<Genre>();
		genres.add(getGenreByName(genreName1,catalog));
		genres.add(getGenreByName(genreName2,catalog));
		genres.add(getGenreByName(genreName3,catalog));
		genres = genres.stream().filter(g->g!=null).collect(Collectors.toList());
		
		if(genres.isEmpty()) {
			return "Изберете поне един валиден жанр";
		}
		
		Torrent torrent = new Torrent(title,description,type,genres,user);
		addTorrentToList(torrent);
		return "Торентът е качен успешно";
	}
	
	private static Genre getGenreByName(String genreName, Catalog catalog) {
		return catalog.getGenres().stream().filter(g->g.getTitle().equals(genreName)).findFirst().orElse(null);
	}

	private static Type getTypeByName(String typeName, Catalog catalog) {
		return catalog.getTypes().stream().filter(t->t.getTitle().equals(typeName)).findFirst().orElse(null);
	}
	
	private static Catalog getCatalogByName(String catalogName) {
		return catalogs.stream().filter(c->c.getTitle().equals(catalogName)).findFirst().orElse(null);
	}
	
	public static void initializeComponents() {
		gameTypes = new ArrayList<Type>();
		gameTypes.add(new Type("Linux"));
		gameTypes.add(new Type("PC ISO"));
		
		gameGenres = new ArrayList<Genre>();
		gameGenres.add(new Genre("RPG"));
		gameGenres.add(new Genre("Стратегия"));
		gameGenres.add(new Genre("Приключенски"));
		gameGenres.add(new Genre("Екшън"));
		
		catalogs = new ArrayList<Catalog>();
		catalogs.add(new Catalog("Игри",gameTypes,gameGenres));
		
		torrents = new ArrayList<Torrent>();
	}

	private static void addTorrentToList(Torrent torrent) {
		torrents.add(torrent);
	}
	
	
	
	
}
