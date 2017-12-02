package ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mjmersenski
 */
public interface FileFormatStrategy {
    public abstract String encodesFormat(Map<String,String> data);
    
    public abstract List<Map<String,String>> readsFormat(File file, BufferedReader reader)throws IOException;
    
}
