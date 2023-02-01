package SWEA;

import java.util.Scanner;

public class 평균값구하기_2071 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			int ans = 0;
			for(int i=0; i<10; i++)
			{
				ans += sc.nextInt();
			}
			System.out.printf("#%d %.0f\n", tc, ans/10.0);
		}
	}

}
