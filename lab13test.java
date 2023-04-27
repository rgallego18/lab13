import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lab13test {
	
	lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "lab13_input_data.txt";
	String expectedResultsFilename = "lab13_expected_results.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		lab = new lab13();
		lab.readData(inputFilename);
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
			expectedResult1 = new Integer[testData.get(0).size()];
			for (int i = 0; i < testData.get(0).size(); i++) {
				expectedResult1[i] = testData.get(0).get(i);
			}
			
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
			expectedResult2 = new Integer[testData.get(1).size()];
			for (int i = 0; i < testData.get(1).size(); i++) {
				expectedResult2[i] = testData.get(1).get(i);
			}
			
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
			expectedResult3 = new Integer[testData.get(2).size()];
			for (int i = 0; i < testData.get(2).size(); i++) {
				expectedResult3[i] = testData.get(2).get(i);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}

	@Test
	public void getTotalCountTest() {
		assertEquals(lab.getTotalCount(), 1000);
	}
	
	@Test
	public void getOddCount() {
		assertEquals(lab.getOddCount(), 507);
	}
	
	@Test
	public void getEvenCount() { 
		assertEquals(lab.getEvenCount(), 493);
	}
	
	@Test
	public void getDistinctGreaterThanFiveCount() {
		assertEquals(lab.getDistinctGreaterThanFiveCount(), 94);
	}
	
	@Test
	public void getResult1() {
		assertArrayEquals(lab.getResult1(), expectedResult1);	
	}
	
	@Test
	public void getResult2() {
		assertArrayEquals(lab.getResult2(), expectedResult2);	
	}
	
	@Test
	public void getResult3() {
		assertArrayEquals(lab.getResult3(), expectedResult3);	
	}
	

}
