package B1;

import java.util.Arrays;
import java.util.Scanner;

public class 세수정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}

}
