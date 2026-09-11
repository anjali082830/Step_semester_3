package session_2_stringoperationsconcept.class_problems;

import java.util.Scanner;
 class Fileextensionvalidator {
static String validatefileextension(String filename){
     int dot =filename.lastIndexOf('.');
     if(dot == -1){
        return "invalid file name";
     }
     
        String extension = filename.substring(dot+1);
     
        if(extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("dox") || extension.equalsIgnoreCase("zip")){
            return "valid file name";
        }
        else{
            return "invalid file name";
        }
     }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = sc.nextLine();
        System.out.println(validatefileextension(filename));
        
    }
    
}
