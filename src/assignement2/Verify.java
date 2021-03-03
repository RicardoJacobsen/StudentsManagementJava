/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignement2;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author ricar
 */

public class Verify {
public static int integer;           
 public static Scanner input = new Scanner (System.in);
 
    public static void  tryInt(){
             
         boolean flag = false;
         do {
             try {
                  
              integer = input.nextInt();
            
              flag=true;
            } catch (InputMismatchException e) {
            
                System.out.println("It is not a number, PLEASE TRY AGAIN");
                 input.nextLine();
            }
        
        
    
            
            
        } while (flag==false);
        
        
    
    
    }
}
