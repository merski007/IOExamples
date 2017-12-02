package ioexamples;

import java.io.File;
import java.util.ArrayList;
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
        List<String> lineList = service.readContactFile(file);
        List<List<String>> contactList = new ArrayList<List<String>>();
        
        // part 1
        for(int i = 0; i < lineList.size(); i++){
            List<String> temp = Arrays.asList(lineList.get(i).split("\\|"));
            contactList.add(temp);
        }
        
//        System.out.println(contactList.get(1).get(0));
        // winner winner, chicken dinner
        // this allows me to access the elements in the array list
        // i can now access each row within the record
        // a little more parse action is needed, but it's almost there
        
        
        String[] contactName;
        String[] cityStZip;
        for(List<String> s : contactList){
//            System.out.println(s);
            contactName = s.get(0).split(" ");
            cityStZip = s.get(2).split(" ");
            System.out.println("Last name: "+contactName[1]+"\nZipcode: "+cityStZip[cityStZip.length - 1]);
        }
        
        // part 2
        // this section of codes adds an address to the file
//        lineList = Arrays.asList(
//            "Aaron Rodgers",
//            "123 Green Bay Ave",
//            "Green Bay, WI 53756"
//        );
//        
//        service.writeFile(file, lineList, true);

        // part 3
        String name = contactList.get(1).get(0);
        cityStZip = contactList.get(1).get(2).split(" ");
        System.out.println(name+"'s state: "+cityStZip[cityStZip.length-2]);
        
    }
}

