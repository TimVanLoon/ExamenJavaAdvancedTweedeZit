package edu.ap.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import edu.ap.spring.Exam;
import java.awt.Point;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    
	@Autowired
	private Exam exam;

	@Autowired
	private Singleton singleton;	
	   
    @Test
    public void testgetTimesTwo() {
    		int[] intArray = new int[] { 11, 12, 13, 20, 25, 30, 37, 41, 50, 62, 78 };
    		int[] result = exam.getTimesTwo(intArray);
    		int[] expected = { 12, 20, 30, 50, 62, 78 };
    		if(Arrays.equals(result, expected)) {
    			singleton.setGrade(1, "testgetTimesTwo");
    		}	
    }
    
    @Test
    public void testcountUppercaseCharacters() {
    		int result = exam.countUppercaseCharacters("WiE hEEft ER examENstress?");
    		if(result == 8) {
    			singleton.setGrade(1, "testcountUppercaseCharacters");
    		}
    }

    @Test
    public void testcountChar() {
    		int result = exam.countChar(this.makeNamesList(), "e");
    		if(result == 6) {
    			singleton.setGrade(2, "testcountChar");
    		}
    }

    @Test
    public void testgetMaxY() {
    		int result = exam.getMaxY(this.makePointsList());
    		if(result == 9) {
    			singleton.setGrade(2, "testgetMaxY");
    		}
    }

    @Test
    public void getFileChanged() {
    		String path = SpringTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    		File f = new File(path.substring(0, path.indexOf("/target")) + "/src/test/java/edu/ap/spring/test/SpringTest.java");
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		System.out.println("SpringTest last modified : " + sdf.format(f.lastModified()));
    }
    
    private List<Point> makePointsList() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(-4, -8));
        result.add(new Point(-2, 9));
        result.add(new Point(-1, -8));
        result.add(new Point(0, -7));
        result.add(new Point(1, 1));
        result.add(new Point(2, 3));
        result.add(new Point(2, 3));
        result.add(new Point(2, -2));
        result.add(new Point(4, -1));

        return result;
    }
    
    private List<String> makeNamesList() {

		List<String> result = new ArrayList<String>();

		result.add("Sandra");
		result.add("Elke");
		result.add("Katlien");
		result.add("Kathleen");
		result.add("Kirsten");
		
		return result;
	}
}
