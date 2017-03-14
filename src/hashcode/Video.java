package hashcode;

import java.util.Hashtable;

public class Video {
    public int size;
    public int index;
    public int totalRequest=0;
    public Hashtable<Integer,Integer> requests;
    
    public Video(int index,int size){
        this.size = size;
        this.index = index;
        this.requests = new Hashtable<Integer,Integer>();
    }
    
    public void addRequest(int endpoint,int number){
        this.requests.put(endpoint, number);
        this.totalRequest += number;
    }
    
}
