package session_2_stringoperationsconcept.class_problems;

import java.util.Scanner;
public class Maskedphonenumber {
    static String maskphonenumber(String phone){
        if(phone.length() != 10){
            return "invalid number";
        }
        for(int i =0; i<phone.length();i++){
            if(!Character.isDigit(phone.charAt(i))){
                return "invalid number";
            }
        }
        StringBuilder sb =new StringBuilder();
        sb.append("xxxxxx");
        sb.append("-");
        sb.append(phone.substring(6));

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();
        System.out.println(maskphonenumber(phone));
    }
    
    
}
