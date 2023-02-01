package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sc.nextInt();
			int[] arr = new int[1000];
			for(int i=0; i<1000; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			int cnt = 0;
			int max = -1;
			int mod = arr[0];
			int flag = 0;
			for(int i=0; i<999; i++) {
				if(arr[i+1] == arr[i])
					cnt++;
				else cnt = 0;
				if(max < cnt) {
					max = cnt;
					mod = arr[i];
					flag = 1;
				} else if(max == cnt && flag == 1) {
					mod = arr[i];
					flag = 0;
				}
			}
			System.out.println("#" + tc + " " + mod);
		}
	}
}
