package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Catalog {

    /**
     * Default constructor
     */
    public Catalog() {
    }

    public Catalog(String title, List<Type> gameTypes, List<Genre> gameGenres) {
		this.title = title;
		this.types = gameTypes;
		this.genres = gameGenres;
	}

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private List<Type> types;

    /**
     * 
     */
    private List<Genre> genres;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Type> getTypes() {
		return types;
	}

	public List<Genre> getGenres() {
		// TODO Auto-generated method stub
		return genres;
	}

}