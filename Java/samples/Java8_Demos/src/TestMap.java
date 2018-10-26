import java.util.*;
public class TestMap{
	public static void main(String arg[])
	{
		Map<Integer,String> data = new HashMap<Integer,String>();
		data.put(1,"Abc");
		data.put(2,"Xyz");
		data.put(3,"Pqr");
		data.put(4,"KBC");

		data.replaceAll((k,v)->(k%2==0)?"PPP":"ZZZ");

		System.out.println(data);

	}
}
