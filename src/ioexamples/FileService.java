package ioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mjmersenski
 */
public class FileService {
    private File file;
    private BufferedReader reader;
    private PrintWriter writer;
    
    
    public List<String> readFile(File file)throws FileNotFoundException, IOException, Exception{
        reader = new BufferedReader(new FileReader(file));
        
        List<String> lineList = new ArrayList<>();
        
        String line = reader.readLine();
        
        try{
            while(line != null){
                lineList.add(line);
                line = reader.readLine();
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
        
        return lineList;
    }
    
    public void writeFile(File file, List<String> data, boolean append) 
            throws FileNotFoundException, IOException, Exception{
        
        try{
        writer = 
                new PrintWriter(
                    new BufferedWriter(
                        new FileWriter(file, append)));
        
        for(String s : data){
            writer.println(s);
        }
        }catch(FileNotFoundException fnfe){
            throw fnfe;
        }catch(IOException ioe){
            throw ioe;
        }catch (Exception e){
            throw e;
        }finally{
            if(writer != null) writer.close();
        }
    }
    
    public List<String> readContactFile(File file)throws FileNotFoundException, IOException, Exception{
        reader = new BufferedReader(new FileReader(file));
        
        List<String> lineList = new ArrayList<>();
        
        String del = "|";
        
        String line = reader.readLine() + del;
        line += reader.readLine() + del;
        line += reader.readLine() + del;
        
        try{
            while(line != null){
                lineList.add(line);
                line = reader.readLine();
                if(line != null){
                    line += del;
                    line += reader.readLine() + del;
                    line += reader.readLine() + del;
                }
//                line = reader.readLine() + del;
//                line += reader.readLine() + del;
//                line += reader.readLine() + del;
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
        
        return lineList;
    }
    
    public List<Map<String,String>> readContactFile2(File file)throws FileNotFoundException, IOException, Exception{
        reader = new BufferedReader(new FileReader(file));
        
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
    
        public void writeFile2(File file, List<Map<String,String>> data, boolean append) 
            throws FileNotFoundException, IOException, Exception{
        
        try{
        writer = 
                new PrintWriter(
                    new BufferedWriter(
                        new FileWriter(file, append)));
        
//        for(String s : data){
//            writer.println(s);
//        }

        /*
            ContactFirstName ContactLastName
            ContactAddress
            ContactCity, ContactSt ContactZip
        */
        
//        final String CR = "\n";
//        final String SP = " ";
        String result = "";
        PracticeFormatter pm = new PracticeFormatter();
        for(Map m : data){
//            result += m.get("ContactFirstName") + " " + m.get("ContactLastName") + CR;
//            result += m.get("ContactAddress") + CR;
//            result += m.get("ContactCity") + ", " + m.get("ContactSt") + " " + m.get("ContactZip");
            result = pm.marksFormat(m);
            writer.println(result);
            result = "";
        }
        
        }catch(FileNotFoundException fnfe){
            throw fnfe;
        }catch(IOException ioe){
            throw ioe;
        }catch (Exception e){
            throw e;
        }finally{
            if(writer != null) writer.close();
        }
    }
}
