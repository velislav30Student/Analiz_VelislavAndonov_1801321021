package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Rating {

    /**
     * Default constructor
     */
    public Rating() {
    }
    
    public Rating(User user,int value) {
    	this.user = user;
    	this.value = value;
    }

    /**
     * 
     */
    private User user;

    /**
     * 
     */
    private int value;


    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

}