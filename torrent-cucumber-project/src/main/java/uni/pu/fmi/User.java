package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class User {

    /**
     * Default constructor
     */
    public User() {
    	favouriteTorrents = new ArrayList<Torrent>();
    }
    
    public User(String username,String password,String gender,String email) {
    	this.username = username;
    	this.password = password;
    	this.gender = gender;
    	this.email = email;
    	isAdmin = false;
    	favouriteTorrents = new ArrayList<Torrent>();
    }

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private boolean isAdmin;

    /**
     * 
     */
    private List<Torrent> favouriteTorrents;












    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username 
     * @return
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender 
     * @return
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin 
     * @return
     */
    public void setIsAdmin(boolean isAdmin) {
    	this.isAdmin = isAdmin;
    }

	public boolean IsTorrentInFavourites(Torrent torrent) {
		return favouriteTorrents.stream().anyMatch(t->t.getTitle().equals(torrent.getTitle()));
	}

	public void removeFromFavourites(Torrent torrent) {
		Torrent torrentToRemove = favouriteTorrents.stream().filter(t->t.getTitle().equals(torrent.getTitle())).findFirst().orElse(null);
		if(torrentToRemove!=null) {
			favouriteTorrents.remove(torrent);
		}
	}

	public void addToFavourites(Torrent torrent) {
		if(torrent!=null) {
			favouriteTorrents.add(torrent);
		}
	}

	public List<Torrent> getFavouriteTorrents() {
		return favouriteTorrents;
	}

}