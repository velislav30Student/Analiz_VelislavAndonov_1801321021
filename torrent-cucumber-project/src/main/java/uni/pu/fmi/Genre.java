package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Genre {

    /**
     * Default constructor
     */
    public Genre() {
    }

    public Genre(String title) {
		this.title = title;
	}

    /**
     * 
     */
    private String title;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

}