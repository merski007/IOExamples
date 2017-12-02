package ioexamples;

import java.util.List;
import java.util.Map;

/**
 *
 * @author mjmersenski
 */
public class PracticeFormatter {
    public String marksFormat(Map<String,String> data){
        /*
            ContactFirstName ContactLastName
            ContactAddress
            ContactCity, ContactSt ContactZip
        */
        
        final String CR = "\n";
        final String SP = " ";
        String result = "";
        result += data.get("ContactFirstName") + " " + data.get("ContactLastName") + CR;
        result += data.get("ContactAddress") + CR;
        result += data.get("ContactCity") + ", " + data.get("ContactSt") + " " + data.get("ContactZip");
        
        return result;
            
    }
}
