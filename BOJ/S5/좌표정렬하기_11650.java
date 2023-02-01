package S5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬하기_11650 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N;
		N = scan.nextInt();
		
		int[][] array = new int[N][2];
		
		for(int i = 0; i < N; i++) {
		
			array[i][0] = scan.nextInt();
			array[i][1] = scan.nextInt();
		}
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		for(int i = 0; i < N; i++) {
			System.out.println(array[i][0] + " " + array[i][1]);
		}
		scan.close();
	}
}