package S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 설탕배달_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int bag = 0;
		
		while(true) {
			if(N%5==0) {
				bag += N/5;
				System.out.println(bag);
				break;
			}
			else {
				N-=3;
				bag++;
			}
			if(N<0) {
				System.out.println("-1");
				break;
			}
		}
		
	}
}