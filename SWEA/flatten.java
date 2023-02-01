package SWEA;
import java.util.Arrays;
import java.util.Scanner;
public class flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int tc=1; tc<=10; tc++) {
			int num = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0; i<100; i++)
				arr[i] = sc.nextInt();
			for(int i=0; i<num; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));
		}
		sc.close();
	}
}
