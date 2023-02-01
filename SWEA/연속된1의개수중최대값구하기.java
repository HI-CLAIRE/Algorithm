package IM대비SWEA;
import java.util.Scanner;

public class 연속된1의개수중최대값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			String num = sc.next();
			
			char[] arr = new char[N];
			
			int cnt = 0, ans = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = num.charAt(i);
				if(arr[i] == '1') cnt++;
				else cnt = 0;
				ans = Math.max(ans, cnt);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

}
