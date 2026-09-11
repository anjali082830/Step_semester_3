package session_2_stringoperationsconcept.class_problems;

public class Banktransactionreferencegenetor {
    static String generatereference(String accountnumber, String transactiontype, String date){
        StringBuilder sb = new StringBuilder();
        sb.append(accountnumber.substring(0, 4));
        sb.append("-");
        sb.append(transactiontype.substring(0, 3).toUpperCase());
        sb.append("-");
        sb.append(date.replaceAll("-", ""));
        return sb.toString();   
    
}

public static void main(String[] args) {
        String accountnumber = "1234567890";
        String transactiontype = "debit";
        String date = "2023-10-15";
        System.out.println(generatereference(accountnumber, transactiontype, date));    
}
}
