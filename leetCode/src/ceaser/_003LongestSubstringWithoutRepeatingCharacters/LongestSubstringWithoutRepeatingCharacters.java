package ceaser._003LongestSubstringWithoutRepeatingCharacters;

/**
 * Given a string, find the length of the longest substring without repeating characters.
	Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author Administrator
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String str = "err767abcdefghijkji";
		int start = 0;
		int end = 0;
		String longestSubstring = "";
		char [] strArr = str.toCharArray();
		for (int i = 0; i < strArr.length; i++) {
			char leveA = strArr[i];
			for (int j = i+1; j < strArr.length; j++) {
				char levelB = strArr[j];
				if(leveA==levelB){
					String innerLongestSubstring = str.substring(i,j);
					if(longestSubstring.length()<innerLongestSubstring.length()){
						longestSubstring = innerLongestSubstring;
					}
				}
			}
		}
		System.out.println(longestSubstring);
	}

}
