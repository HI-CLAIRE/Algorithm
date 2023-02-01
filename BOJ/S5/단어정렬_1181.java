package S5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 단어정렬_1181 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		List<String> lst = new ArrayList<String>();
		lst.add(sc.next());
		for(int i=0; i<T - 1; i++) {
			String word = sc.next();
			for(int j=0; j<lst.size(); j++) {
				if(word.equals(lst.get(j)))
					break;
				else if(j == lst.size() - 1)
					lst.add(word);
			}
		}
		
		for(int i=0; i<lst.size(); i++) {
			for(int j=0; j<(lst.size() -  1) - i; j++) {
				String now = lst.get(j); 
				String next = lst.get(j + 1);
				if(	(now.length() > next.length()) ||
					(now.length() == next.length() && now.compareTo(next) > 0)) {
					String tmp = now;
					lst.set(j, next);
					lst.set(j + 1 , tmp);
					
				}
			}
		}
		
		for(String str : lst) {
			System.out.println(str);
		}
		sc.close();
		long end = System.currentTimeMillis();
		System.out.println("수행시간: " + (end - start) + " ms");
 	}

}
                          