package hashcode;

import java.util.ArrayList;

public class CacheServer {
    public ArrayList<Video> videos;
    public int index;
    public CacheServer(int index){
        this.index = index;
        videos = new ArrayList<Video>();
    }
    
    public  boolean addVideo(Video video){
        int size = 0;
        if(this.videos.contains(video))
            return true;
        
        for (int i = 0; i < this.videos.size(); i++) {
           size += this.videos.get(i).size;
        }
        if(size + video.size <= ListCacheServer.size){
            this.videos.add(video);
            return true;
        }else
            return false;
    }
    
}
