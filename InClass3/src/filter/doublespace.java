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
public class doublespace implements fileFilter{
    
    @Override
    public void doFilter(Scanner sc, PrintWriter pw){
        while(sc.hasNext()){
            pw.println(sc.next());
            pw.println();
        }
    }
    
}
