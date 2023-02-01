package 일주차;

import java.util.Scanner;

public class 동명이인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String name = sc.next();
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			String cmp = sc.next();
			if(cmp.contains(name)) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

}
