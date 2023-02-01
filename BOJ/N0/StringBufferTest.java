package BOJ;

public class StringBufferTest {
public static void main(String[] args) {
	String str = "level";
	StringBuffer sb= new StringBuffer(str);
	System.out.println(sb.reverse().toString());
	System.out.println(str.equals(sb.reverse().toString()));
}
}
