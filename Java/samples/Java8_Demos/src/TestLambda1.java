import java.util.*;

public class TestLambda1{
	public static void main(String arg[]){
		Integer[] data = {10,20,22,19,4,8,7,12};
		List<Integer> nList = Arrays.asList(data);
		
		Collections.sort(nList, new Comparator<Integer>(){
			public int compare(Integer n1,Integer n2){
				return n1-n2;
			}
		});
		
		System.out.println(nList);
		
		//Using lambda
		Collections.sort(nList, (n1,n2)->n2-n1 );
		
		System.out.println(nList);
	}
}