import java.time.Clock;
import java.util.*;
import java.util.stream.Stream;

public class StreamDemo3 {

	public static void main(String[] args) {

		List<Product> productList = new LinkedList<Product>();
		populate(productList);
		System.out.println("The orginal [Unsorted] Data:");
		printAll(productList);

		populate(productList);
		System.out.println("After normal sort:");
		sortNormal(productList);
		printAll(productList);

		populate(productList);
		System.out.println("After sort using Lambda [without Parallel Streams]");
		sortNew(productList);
		printAll(productList);

		populate(productList);
		System.out.println("After sort using Parallel streams");
		sortParrellel(productList);
		printAll(productList);

	}

	static void sortNormal(List<Product> list) {
		Collections.sort(list, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	static void sortNew(List<Product> list) {
		Collections.sort(list, (p1, p2) -> p1.getName().compareTo(p2.getName()));
	}

	static void sortParrellel(List<Product> list) {
		list.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));
	}

	static void populate(List<Product> list) {
		list.clear();
		list.add(new Product(101, "HP Sleekbook 14\"", "14 \" AMD E1-1200 with 2GB ram", 23000));
		list.add(new Product(102, "HP 15 Series laptop", "15.7 \" Core i5 with 4GB ram", 40000));
		list.add(new Product(103, "Dell Inspiron 15 3000", "15.7 \" Core i5 with 4GB ram", 42000));
		list.add(new Product(104, "Seagate Portable HDD", "2.5\" Portable HDD", 4200));
		list.add(new Product(105, "Toshiba Satelite Notebook", "15.7 \" Core i5 with 4GB ram", 38000));
		list.add(new Product(106, "Lenovo Notebook", "15.7 \" Core i3 with 2GB ram", 34500));
		list.add(new Product(107, "Acer Aspire notebook ", "15.7 \" Core i5 with 4GB ram", 40000));
		list.add(new Product(108, "Dell Inspiron 15 5000", "15.7 \" Core i7 with 6GB ram", 54000));
	
	}

	static void printAll(List<Product> list) {
		Stream s = list.stream();
		list.stream().forEach(System.out::println);
	}
}
