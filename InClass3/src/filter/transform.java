/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;
import java.util.*;
import java.io.*;

/**
 *
 * @author Eddie
 */
public class transform implements fileFilter{
    
    @Override
    public void doFilter(Scanner sc,PrintWriter pw){
        sc.useDelimiter("");
        while(sc.hasNext()){
            pw.print(Character.toUpperCase(sc.next().charAt(0)));
        }
        
    }
    
}
