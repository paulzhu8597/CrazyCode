package product;

public class Test {
public static void main(String[] args) {
	String a = "hello2";
	final String b = "hello";
	String c = "hello";
	String d = b + 2;
	String e = c + 2;
	System.out.println("d="+d);
	System.out.println("e="+e);
	System.out.println((a == d));//true
	System.out.println((a == e));//false
	System.out.println((e == "hello2"));//false
}
}
