package SWEA;

//import java.util.Arrays;
import java.util.Scanner;

public class 쉬운거스름돈_1970 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//			int[] ans = new int[7];
			
			System.out.println("#"+tc);
			int[] ans = {0, 0, 0, 0, 0, 0, 0, 0};
			for(int i=0; i<coin.length; i++)
			{
				
				if(N / coin[i] > 0)
				{
					ans[i] = N / coin[i];
//					System.out.println(coin[i] + "원: " + N / coin[i]);
					N %= coin[i];
				}
				System.out.print(ans[i] + " ");
				
			}
			System.out.println();
		}
		sc.close();
	}

}
