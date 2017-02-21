//Emanuel Rios
//exr161430
package inclass3;
import filter.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Eddie
 */
public class InClass3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner sc = new Scanner(new File("test.txt"));
        PrintWriter pw = new PrintWriter("out.txt");
        
        //System.out.println(sc.next());
        
        
        encryption e = new encryption(5);
        e.doFilter(sc,pw);
        System.out.println("done");

        /*
        transform t = new transform();
        t.doFilter(sc,pw);
        
        
        unchange u = new unchange();
        u.doFilter(sc, pw);
                
        
        
        doublespace s = new doublespace();
        s.doFilter(sc, pw);
        */
        
        
        
        
        
        pw.close();
        sc.close();
        
    }
    
}
