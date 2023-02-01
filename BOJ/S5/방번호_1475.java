package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		int[] arr = new int[num.length()];
		
		for(int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}
		
		int[] cntSet = new int[10];
		for(int n : arr) {
			if(n == 9 || n == 6) {
				if(cntSet[6] > cntSet[9]) cntSet[9]++;
				else cntSet[6]++;
			}
			else cntSet[n]++;
		}
		
		int ans = 0;
		for(int i : cntSet) {
			ans = Math.max(ans, i);
		}
		System.out.println(ans);
	}

}
