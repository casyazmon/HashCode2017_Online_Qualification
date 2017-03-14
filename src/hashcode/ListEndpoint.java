package hashcode;

import java.util.ArrayList;

/**
 *
 * @author kevmax
 */
public class ListEndpoint {
    public static int number;
    
    public static ArrayList<Endpoint> endpoints;
    
    public static void setNumber(int num){
        number = num;
        endpoints = new ArrayList<Endpoint>();
    }
    
    public static void addEndpoint(Endpoint endpoint){
        endpoints.add(endpoint);
    }
}
