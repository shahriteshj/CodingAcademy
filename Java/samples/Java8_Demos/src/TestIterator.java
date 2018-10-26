import java.util.*;
public class TestIterator{
	public static void main(String arg[])
	{
		//Sample list
		List<Integer> data = new ArrayList<Integer>();
		for(int i=1;i<=100;i++) data.add(i);

		Spliterator it=data.spliterator();
		Spliterator it2 = it.trySplit();

		it.forEachRemaining(System.out::println);
	}
}
