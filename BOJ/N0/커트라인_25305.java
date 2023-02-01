package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 커트라인_25305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++)
			arr.add(sc.nextInt());
		Collections.sort(arr);
		Collections.reverse(arr);
		System.out.println(arr.get(k - 1));
	}
}
