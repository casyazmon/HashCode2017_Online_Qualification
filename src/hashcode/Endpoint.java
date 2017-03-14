package hashcode;

import java.util.Hashtable;

public class Endpoint {
    public int datacenterLatency;
    public int numberCacheServer;
    public Hashtable<Integer,Integer> cacheservers;
    public Endpoint(int datacenterLatency,int numberCacheServer){
        this.datacenterLatency = datacenterLatency;
        this.numberCacheServer = numberCacheServer;
        this.cacheservers = new Hashtable<Integer,Integer>();
    }
    
    public void addCacheServer(int index,int latency){
        this.cacheservers.put(index, latency);
    }
    
}
