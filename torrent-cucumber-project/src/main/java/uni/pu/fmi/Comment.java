package uni.pu.fmi;
import java.util.*;

import org.joda.time.DateTime;

/**
 * 
 */
public class Comment {

    /**
     * Default constructor
     */
    public Comment() {
    }
    
    public Comment(User user,String text) {
    	this.user = user;
    	this.text = text;
    	this.date = DateTime.now();
    }

    /**
     * 
     */
    private User user;

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private DateTime date;


    public User getUser() {
    	return user;
    }
    
    public String getText() {
    	return text;
    }
    
    public void setText(String text) {
    	this.text = text;
    }

}