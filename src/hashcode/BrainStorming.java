/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author kevmax
 */
public class BrainStorming {
    public String output_file;
    public BrainStorming(String output_file){
        this.output_file = output_file;
    }
    public void sortVideo(){
        Hashtable<Integer,Video> videos;
    }
    
    public List<Video> getSortedVideo(Collection<Video> videos){
        List<Video> list = new ArrayList<Video>(videos);
        list.sort(new Comparator<Video>(){
            @Override
            public int compare(Video o1, Video o2) {
                if(o1.totalRequest > o2.totalRequest)
                    return -1;
                else if (o1.totalRequest < o2.totalRequest)
                    return 1;
                else
                    return 0;
            }
            
        });
        return list;
    }
    
    public List<Integer> getSortedRequest(Video video,Enumeration<Integer> endpoints){
        List<Integer> list = Collections.list(endpoints);
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(video.requests.get(o1) > video.requests.get(o2))
                    return -1;
                else if (video.requests.get(o1) < video.requests.get(o2))
                    return 1;
                else
                    return 0;
            }
            
        });
        return list;
    }
    
    public List<Integer> getSortedCS(Endpoint e,Enumeration<Integer> cacheservers){
        List<Integer> list = Collections.list(cacheservers);
        list.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(e.cacheservers.get(o1) > e.cacheservers.get(o2))
                    return 1;
                else if (e.cacheservers.get(o1) < e.cacheservers.get(o2))
                    return -1;
                else
                    return 0;
            }
            
        });
        return list;
    }
    
    public void dispatchVideo(){
        
        List<Video> videos = this.getSortedVideo(ListVideo.videos.values());
        for (int i = 0; i < videos.size(); i++) {
            Video v = videos.get(i);
            List<Integer> requests = this.getSortedRequest(v, v.requests.keys());
            for (int j = 0; j < requests.size(); j++) {
                List<Integer> cacheservers = this.getSortedCS(ListEndpoint.endpoints.get(requests.get(j)),ListEndpoint.endpoints.get(requests.get(j)).cacheservers.keys());
                for (int k = 0; k < cacheservers.size(); k++) {
                    if(ListCacheServer.cacheservers.get(cacheservers.get(k)).addVideo(v)){
                        break;
                    }
                }
            }
        }
        this.generateSoumission();
    }
    
    public void generateSoumission(){
        try {
            FileWriter fw = new FileWriter(this.output_file);
            fw.write(ListCacheServer.number+"\n");
            Enumeration<CacheServer> e = ListCacheServer.cacheservers.elements();
            while(e.hasMoreElements()){
                CacheServer cs = e.nextElement();
                String str = cs.index+" ";
                for (int i = 0; i < cs.videos.size(); i++) {
                    str += cs.videos.get(i).index +" ";
                }
                str +="\n";
                fw.write(str);
            }
            fw.close();
        } catch (IOException e) {
            
        }
    }
}
