package hashcode;

import hashcode.*;

public class HashCode {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        traitement("kittens");
        traitement("me_at_the_zoo");
        traitement("trending_today");
        traitement("videos_worth_spreading");
    }
    
    public static void traitement(String file) {
        LoadFile load = new LoadFile(file+".in");
        BrainStorming bs = new BrainStorming(file+"-output.in");
        bs.dispatchVideo();
    }
}
