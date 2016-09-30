package ceaser._007ReverseInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		Integer digital = -123456789;
		if(digital<0){
			System.out.println("-"+ri.solution(digital));
		}else{
			System.out.println(ri.solution(digital));
		}
	}

	public String solution(Integer digital){
		if(null!=digital){
			String str = String.valueOf(digital);
			StringBuffer sb = new StringBuffer(str);
			return sb.reverse().toString();
		}
		return "";
	}
}
