package BOJ;

import java.util.Scanner;

public class 음계_2920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		for(int i=0; i<8; i++)
			arr[i] = sc.nextInt();
		int sum = 0;
		for(int i=0; i<7; i++) {
			sum += Math.abs(arr[i+1] - arr[i]);
		}
		if(sum == 7) {
			if(arr[0] > arr[1])
				System.out.println("descending");
			else
				System.out.println("ascending");
			
		}
		else
			System.out.println("mixed");
	}

}
