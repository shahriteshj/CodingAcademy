import java.util.*;
public class TestPSort{
	public static void main(String arg[])
	{
		int []data = {2,6,21,8,1,15};
		Arrays.parallelSort(data);
		
		for(int n: data)
			System.out.println(n);

	}
}
