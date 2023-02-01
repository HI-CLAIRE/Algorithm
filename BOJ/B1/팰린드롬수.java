package B1;

import java.util.Scanner;

public class 팰린드롬수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
	
			if(str.equals("0")) break;
			
			StringBuilder sb = new StringBuilder(str);
			String rev = sb.reverse().toString();
			if(str.equals(rev)) System.out.println("yes");
			else System.out.println("no");
			
		}
		sc.close();
	}

}
