package hashcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import hashcode.*;
import java.io.FileNotFoundException;

public class LoadFile {
    private File f_in;
    private BufferedReader f;
    private int request_description;
    public LoadFile(){
        
        f = null;
    }
    
    public LoadFile(String filename){
        this.f_in = new File(filename);
        try {
            f = new BufferedReader(new FileReader(this.f_in));
            String buf = f.readLine();
            String info[] = buf.split(" ");
            ListVideo.setNumber(Integer.parseInt(info[0]));
            ListCacheServer.setParams(Integer.parseInt(info[3]),Integer.parseInt(info[4]));
            ListEndpoint.setNumber(Integer.parseInt(info[1]));
            this.request_description = Integer.parseInt(info[2]);
            this.setVideoParams();
            this.setEndpoints();
            this.setRequest();
        } catch (IOException ex) {
            System.err.println(ex);;
        }
    }
    
    public void setVideoParams() throws FileNotFoundException, IOException{
        String buf = f.readLine();
        String infoVideo[] = buf.split(" ");
        for (int i = 0; i < infoVideo.length; i++) {
            ListVideo.addVideo(i,Integer.parseInt(infoVideo[i]));
        }
    }
    
    public void setEndpoints() throws IOException{
        for (int i = 0; i < ListEndpoint.number; i++) {
            String buf = f.readLine();
            String info[] = buf.split(" ");
            Endpoint endpoint = new Endpoint(Integer.parseInt(info[0]),Integer.parseInt(info[1]));
            for (int j = 0; j < Integer.parseInt(info[1]); j++) {
                buf = f.readLine();
                String infoCache[] = buf.split(" ");
                endpoint.addCacheServer(Integer.parseInt(infoCache[0]), Integer.parseInt(infoCache[1]));
            }
            ListEndpoint.addEndpoint(endpoint);
        }
    }
    
    public void setRequest() throws IOException{
        for (int i = 0; i < this.request_description; i++) {
            String buf = f.readLine();
            String info[] = buf.split(" ");
            ListVideo.videos.get(Integer.parseInt(info[0])).addRequest(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
        }
    }
}
