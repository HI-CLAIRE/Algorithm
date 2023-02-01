package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class 수이어가기_2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
				
		int max = 0;
		int tmp = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int n = N/2; n <= N; n++) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(N);
			arr.add(n);
			int i = 2;
			while(true) {
				arr.add(arr.get(i - 2) - arr.get(i - 1));
				if(arr.get(i) < 0) {
					arr.remove(i);
					break;
				}
				i++;
			}
			tmp = arr.size();
			if(max < tmp) {
				max = tmp;
				ans = arr;
			}
		}
		System.out.println(max);
		for(int i:ans)
			System.out.print(i + " ");
		sc.close();
	}

}
