/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MfDevNet
 */
public class MyList {
    private static List<String> list = new ArrayList<>();

    public static List<String> getList() {
        return list;
    }
    
    public static void setName(String s){
        list.add(s);
        
    }
}
