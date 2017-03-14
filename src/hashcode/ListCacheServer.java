package hashcode;

import java.util.ArrayList;
import java.util.Hashtable;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;


public class ListCacheServer {
    public static int number;
    public static int size;
    
    public static Hashtable<Integer,CacheServer> cacheservers;
    
    public static void setParams(int num,int s){
        number = num;
        size = s;
        cacheservers = new Hashtable<Integer,CacheServer>();
        for (int i = 0; i < num; i++) {
            addCacheServer(i,new CacheServer(i));
        }
    }
    
    public static void addCacheServer(int index,CacheServer cacheServer){
        cacheservers.put(index,cacheServer);
    }

}
