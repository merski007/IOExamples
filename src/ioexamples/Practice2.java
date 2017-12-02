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
        
        for(Map m : contactList){
            System.out.println(m);
        }
    }
}
