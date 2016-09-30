package ceaser._006ZigZagConversion;


/**
 * 6. ZigZag Conversion
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	reference : http://www.cnblogs.com/sanghai/p/3632528.html
 * @Title:
 * @Description:
 * @Author:wangzequan
 * @Since:2016年9月30日 下午2:40:07
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2015 ~ 2016 版权所有
 */

public class ZigZagConversion {
	int frequency = 2;//频率
	int amplitude = 3;//振幅

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		ZigZagConversion  zzc = new ZigZagConversion();
		System.out.println(zzc.convert(str,3));

	}
	
	public  String convert(String text, int nRows){
		if(1==nRows){
			return text;
		}
		int i=0,j;
		String [] res = new String[nRows];
		for(int t=0;t<res.length;t++){
			res[t] = "";
		}
		int gap = nRows-2;
		while(i<text.length()){
			for(j=0;j<nRows && i<text.length();++j) res[j]+=text.charAt(i++);
			for(j=gap;j>0 && i<text.length();--j) res[j]+=text.charAt(i++);
		}
		String restr = "";
		for(i=0;i<res.length;++i){
			restr +=res[i];
		}		
		return restr;
	}
	
}
