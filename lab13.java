import java.util.*;
import java.io.*;
public class lab13 {
	
	public ArrayList<Integer> streamArray;
	
	public void readData(String filename) {
		streamArray = new ArrayList<Integer>();
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while ((inn = input.readLine()) != null) {
				streamArray.add(Integer.parseInt(inn));
			}
			input.close();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.toString());
			System.exit(0);
		}
			
	}
	
	public long getTotalCount() {
		return streamArray.stream().count();
	}
	
	public long getOddCount() {
		return streamArray.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount() {
		return streamArray.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return streamArray.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1() {
		Integer[] listSorted = streamArray.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
		return listSorted;
	}
	
	public Integer[] getResult2() {
		Integer[] list = streamArray.stream().map(x -> x*x).map(x -> x*3).limit(50).toArray(Integer[]::new);
		return list;
	}
	
	public Integer[] getResult3() {
		Integer[] list = streamArray.stream().filter(x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
		return list;
	}
	
	
	
	
}
