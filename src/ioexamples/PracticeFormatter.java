package ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mjmersenski
 */
public class PracticeFormatter {
    public String encodesMarksFormat(Map<String,String> data){
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
    
    public List<Map<String,String>> readsMarksFormat(File file, BufferedReader reader) throws IOException{
        List<Map<String,String>> contactList = new ArrayList<>();
        Map contactInfo = new LinkedHashMap<>();

        String line = reader.readLine();
        
        try{
            while(line != null){
                String[] contactName = line.split(" ");
                contactInfo.put("ContactFirstName", contactName[0]);
                contactInfo.put("ContactLastName", contactName[1]);
                line = reader.readLine();
                
                contactInfo.put("ContactAddress", line);
                line = reader.readLine();
                
                String[] contactCityStZip = line.split(",");
                String[] contactStZip = contactCityStZip[1].split(" ");
                contactInfo.put("ContactCity", contactCityStZip[0]);
                contactInfo.put("ContactSt", contactStZip[1]);
                contactInfo.put("ContactZip", contactStZip[2]);
                line = reader.readLine();
                
                contactList.add(contactInfo);
                contactInfo = new LinkedHashMap<>();
            }
        }catch(FileNotFoundException fnfe){
            throw fnfe;
        }catch(IOException ioe){
            throw ioe;
        }catch(Exception e){
            throw e;
        }finally{
            if(reader != null) reader.close();
        }
        
        return contactList;
        
    }
}
