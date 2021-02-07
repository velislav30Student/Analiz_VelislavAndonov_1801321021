package uni.pu.fmi;
import java.util.*;

import uni.pu.fmi.services.AddTorrentToFavouritesService;
import uni.pu.fmi.services.CommentinService;
import uni.pu.fmi.services.DeleteTorrentService;
import uni.pu.fmi.services.DownloadTorrentService;
import uni.pu.fmi.services.RatingTorrentService;
import uni.pu.fmi.services.UploadTorrentService;
import uni.pu.fmi.services.UserSessionService;

/**
 * 
 */
public class Engine {

    /**
     * Default constructor
     */
    public Engine() {
    	gui = new GUI();
    	currentUser = UserSessionService.getCurrentUser();
    	torrents = new ArrayList<Torrent>();
    	catalogs = new ArrayList<Catalog>();
    	users = new ArrayList<User>();
    }

    /**
     * 
     */
    private GUI gui;

    /**
     * 
     */
    private User currentUser;

    /**
     * 
     */
    private List<Torrent> torrents;

    /**
     * 
     */
    private List<Catalog> catalogs;

    /**
     * 
     */
    private List<User> users;







    /**
     * @param username 
     * @param password 
     * @param gender 
     * @param email 
     * @return
     */
    public void Register(String username, String password, String gender, String email) {
        //TO DO
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public void Login(String username, String password) {
        //TO DO
    }

    /**
     * @param catalog 
     * @return
     */
    public List<Type> getTypesBelongingToCatalog(Catalog catalog) {
        // TODO implement here
        return null;
    }

    /**
     * @param catalog 
     * @return
     */
    public List<Genre> getGenresBelongingToCatalog(Catalog catalog) {
        // TODO implement here
        return null;
    }

    /**
     * @param title 
     * @param description 
     * @param type 
     * @param genres 
     * @param uploader 
     * @return
     */
    public void uploadTorrent(String title, String description,String catalogName, String typeName, String genreName1,String genreName2,String genreName3) {
        UploadTorrentService.uploadTorrent(title, description, catalogName, typeName, genreName1, genreName2, genreName3);
    }

    /**
     * @param torrent 
     * @return
     */
    public void downloadTorrent(Torrent torrent) {
        DownloadTorrentService.downloadTorrent(torrent);
    }

    /**
     * @param torrent 
     * @param user 
     * @return
     */
    public void deleteTorrent(Torrent torrent) {
        DeleteTorrentService.deleteTorrent(torrent);
    }

    /**
     * @param torrent 
     * @param user 
     * @param value 
     * @return
     */
    public void rateTorrent(Torrent torrent, int value) {
        RatingTorrentService.RateTorrent(torrent, torrent.getRating(), value);
    }

    /**
     * @param torrent 
     * @param user 
     * @param text
     */
    public void commentOnTorrent(Torrent torrent, String text) {
        CommentinService.publishComment(text, torrent);
    }

    /**
     * @param catalog 
     * @return
     */
    public List<Torrent> searchTorrentsByCatalog(Catalog catalog, String text) {
        // TODO implement here
        return null;
    }

    /**
     * @param catalog 
     * @param types 
     * @return
     */
    public List<Torrent> searchTorrentsByCatalogAndType(Catalog catalog, List<Type> types, String text) {
        // TODO implement here
        return null;
    }

    /**
     * @param catalog 
     * @param types 
     * @return
     */
    public List<Torrent> searchTorrentsByCatalogAndGenre(Catalog catalog, List<Genre> genres, String text) {
        // TODO implement here
        return null;
    }

    /**
     * @param catalog 
     * @param types 
     * @param genres 
     * @return
     */
    public List<Torrent> searchTorrentsByCatalogTypeAndGenre(Catalog catalog, List<Type> types, List<Genre> genres, String text) {
        // TODO implement here
        return null;
    }

    /**
     * @param torrent 
     * @param user 
     * @return
     */
    public void addTorrentToFavourites(Torrent torrent) {
        AddTorrentToFavouritesService.addToFavourites(torrent);
    }

}