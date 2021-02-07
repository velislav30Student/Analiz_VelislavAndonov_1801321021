package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Torrent extends Rating {

    /**
     * Default constructor
     */
    public Torrent() {
    }

    public Torrent(String title, String description, Type type, List<Genre> genres, User uploader) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.genres = genres;
		this.uploader = uploader;
		ratings = new ArrayList<Rating>();
		ratingAvr = 0;
		comments = new ArrayList<Comment>();
	}

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private User uploader;

    /**
     * 
     */
    private float ratingAvr;

    /**
     * 
     */
    private int downloadCount;

    /**
     * 
     */
    private Type type;

    /**
     * 
     */
    private List<Genre> genres;

    /**
     * 
     */
    private List<Rating> ratings;

    /**
     * 
     */
    private List<Comment> comments;

    /**
     * @return
     */
    public void updateAverageRating() {
    	float sum = 0;
    	int count = 0;
        for (Rating r : ratings) {
			sum+=r.getValue();
			count++;
        }
        float temp = (sum/count) * 100;
        float temp2 = Math.round(temp);
        ratingAvr=temp2/100;
    }

	public String getTitle() {
		return title;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void download() {
		downloadCount++;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public float getRating() {
		return ratingAvr;
	}

	public void addRating(Rating rating) {
		Rating userRating = ratings.stream().filter(r->r.getUser().getUsername().equals(rating.getUser().getUsername())).findFirst().orElse(null);
		if(userRating == null) {
			if(rating.getValue()!=0) {
				ratings.add(rating);	
			}	
		}
		else {
			if(rating.getValue()==0) {
				ratings.remove(userRating);
			}
			else {
				userRating.setValue(rating.getValue());
			}
		}
		updateAverageRating();
	}

	public Type getType() {
		return type;
	}
	
	public List<Genre> getGenres(){
		return genres;
	}

	public List<Comment> getComments(){
		return comments;
	}
	
	public List<Rating> getRatings(){
		return ratings;
	}
}