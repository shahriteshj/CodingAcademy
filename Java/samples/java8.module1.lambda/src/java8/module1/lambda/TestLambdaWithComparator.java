package java8.module1.lambda;
import java.util.*;

public class TestLambdaWithComparator {

	public static void main(String[] args) {
		List<Person> friends = new LinkedList<>();
		friends.add(new Person("Ashwarya", "Bacchan", 38));
		friends.add(new Person("Kareena","Kapoor",35));
		friends.add(new Person("Pareenity","Chopra",28));
		friends.add(new Person("Kangna","Ranout",30));
		friends.add(new Person("Alia","Bhatt",24));
		//Old style : compare by age
	/*	Collections.sort(friends, new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge()-o2.getAge();
			}

		});*/
		
		//New Style: compare by age using LAMBDA
		
		Collections.sort(friends, (p1,p2)-> {return p1.getAge()-p2.getAge();});
		
		display("After sorting by age", friends);
	}
	
	static void display(String msg, List<Person> list){
		System.out.println("Displaying friends : "+msg);
		for(Person p : list){
			System.out.println(p);
		}
	}

}
