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
public class encryption implements fileFilter{
    int key;
    
    public encryption(int i){
        key = i;
    }
    
    @Override
    public void doFilter(Scanner sc, PrintWriter pw){
        sc.useDelimiter("");
        while(sc.hasNext()){
            //System.out.println("in");
            char c;
            c = sc.next().charAt(0);
           
            if(c == '\n'){
                System.out.println("newline");
                pw.println();
                continue;
            }
            if((int)c + key > 127){
                System.out.println((char)(0 + (127 - (int)c + key)));
                pw.print((char)(0 + (127 - (int)c + key)));
            }
            else{
                System.out.println((char)((int)c + key));
                pw.print((char)((int)c + key));
            }
        }
    }
    
}
