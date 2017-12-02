package ioexamples;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mjmersenski
 */
public class Practice2 {
    public static void main(String[] args) throws Exception {
        File file = new File("src"+File.separatorChar+"contactList.txt");
        FileService service = new FileService();
        List<Map<String,String>> contactList = new ArrayList<>();
        
        contactList = service.readContactFile2(file);
        
        // part 1
        for(Map m : contactList){
//            System.out.println(m);
            System.out.println("Last name: "+m.get("ContactLastName")+", Zipcode: "+m.get("ContactZip"));
        }
        
        // part 2
        Map contactInfo = new LinkedHashMap<>();
        contactInfo.put("ContactFirstName", "Aaron");
        contactInfo.put("ContactLastName", "Rodgers");
        contactInfo.put("ContactAddress", "123 main st");
        contactInfo.put("ContactCity", "Green Bay");
        contactInfo.put("ContactSt", "WI");
        contactInfo.put("ContactZip", "54229");
        
        contactList.add(contactInfo);
        // append is set to false because i'm adding the contactInfo to the
        // main list i read into, otherwise if would need to create a new
        // List<Map<String,String>> object and i could append only those values
        service.writeFile2(file, contactList, false);
        
        // part 3
        System.out.println(contactList.get(1).get("ContactLastName") + "'s State: "
             + contactList.get(1).get("ContactSt"));
        
        
    }
}
