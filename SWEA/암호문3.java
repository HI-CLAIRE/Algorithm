package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			LinkedList<String> lst = new LinkedList<>();
			
			for(int i=0; i<N; i++)
				lst.add(sc.next());
			
			int M = sc.nextInt();
			
			for(int i=0; i<M;i++) {
				String c = sc.next();
				int X, Y;
				switch(c) {
				
				case("I"):
					X = sc.nextInt();
					Y = sc.nextInt();
					for(int j=0; j<Y; j++)
						lst.add(X+j, sc.next());
					break;
				
				case("D"):
					X = sc.nextInt();
					Y = sc.nextInt();
					for(int j=0; j<Y; j++)
						lst.remove(X+j);
					break;
				
				case("A"):
					Y = sc.nextInt();
					for(int j=0; j<Y; j++)
						lst.addLast(sc.next());
				}
			}
			
			//출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for(int i=0; i<10; i++) {
				sb.append(" ").append(lst.get(i));
			}
			System.out.println(sb);
		}

	}

}
