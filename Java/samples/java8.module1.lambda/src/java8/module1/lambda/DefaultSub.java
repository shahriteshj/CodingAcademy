package java8.module1.lambda;


public interface DefaultSub {

	default double sub(double n1,double n2){
		return n1-n2;
	}
}
