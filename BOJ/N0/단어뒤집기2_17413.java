package BOJ;

import java.util.Scanner;

public class 단어뒤집기2_17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringBuilder rev = new StringBuilder();
		
		String str = sc.nextLine();
		
		boolean tag = false;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(!tag) {
				if(c == '<') {
					sb.append(rev.reverse());
					sb.append('<');
					rev.delete(0, rev.length());
					tag = true;
				}
				else if(c == ' ') {
					sb.append(rev.reverse());
					sb.append(' ');
					rev.delete(0, rev.length());
				}
				else if(i == str.length() - 1) {
					rev.append(c);
					sb.append(rev.reverse());
				}
				else rev.append(c);				
			}
			
			else {
				if(c == '>') {
					sb.append('>');
					tag = false;
				}
				else sb.append(c);
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}

}
