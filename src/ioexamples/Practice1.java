package ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mjmersenski
 */
public class Practice1 {
    public static void main(String[] args)throws Exception {
//        File file = new File("src"+File.separatorChar+"test.txt");
//        FileService service = new FileService();
//        List<String> lineList = service.readFile(file);
//        
//        for(String s:lineList){
//            System.out.println(s);
//        }
//        
//        lineList = Arrays.asList(
//                "line number 1",
//                "line number 2",
//                "line number 3"
//        );
//        
//        service.writeFile(file, lineList, false);

        File file = new File("src"+File.separatorChar+"contactList.txt");
        FileService service = new FileService();
        List<String> lineList = service.readFile(file);
        
        for(String s : lineList){
            System.out.println(s);
        }
    }
}

