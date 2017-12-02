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
import java.util.List;

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
}
