package ioexamples;

import java.io.File;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author mjmersenski
 */
public class FileServiceTest extends TestCase {
    
    public FileServiceTest(String testName) {
        super(testName);
    }

    /**
     * Test of readFile method, of class FileService.
     */
    public void testReadFile() throws Exception {
        File file = new File("src"+File.separatorChar+"test.txt");
        FileService service = new FileService();
        List<String> lineList = service.readFile(file);
        int linesExpected = 5;
        int linesActual = lineList.size();
        assertEquals(linesExpected,linesActual);
    }
    
}
