package java8.module1.lambda;

import java.util.Scanner;

public class FunctionalDemo {

	public static void main(String[] args) {
		
		System.out.println("Testing Lambda on User-defined functional interface");
		System.out.println("User entered two numbers....");
		
		FunctionalSum sum = (n1,n2)-> {return n1+n2; };
		
		double k = 10.22, t = 22.01;
		
		double x = sum.doSum(k, t);
		System.out.println("Sum is : "+x);
		
		//Short-form
		//NOTE: i and v must not be declared anywhere in local scope
		doSum((i,v)-> i+v);
		
	}
	static void doSum(FunctionalSum sum){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two nubmers: ");
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		
		double ans = sum.doSum(num1, num2);
		System.out.println("Answer is "+ans);
		
	}
	
	static void doSub(DefaultSub sub){
		System.out.println(sub.sub(10.2, 11.2));
	}

}
