package hashcode;

import hashcode.*;
import java.util.Hashtable;

public class ListVideo {
    public static int number;
    public static Hashtable<Integer,Video> videos;
    
    public static void setNumber(int num){
        number = num;
        videos = new Hashtable<Integer,Video>();
    }
    
    public static void addVideo(int index,int size){
        Video video = new Video(index,size);
        videos.put(index,video);
    }
}
