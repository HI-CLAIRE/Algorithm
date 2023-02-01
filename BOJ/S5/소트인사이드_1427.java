package S5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 소트인사이드_1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		while(N > 0) {
			list.add(N%10);
			N /= 10;
		}
		Collections.sort(list, Comparator.reverseOrder());
		for(int i : list) {
			System.out.print(i);
		}
	}

}
