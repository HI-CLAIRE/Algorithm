package IM대비SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장애물경주난이도 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] obs = new int[N];	// 장애물 배열 
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				obs[i] = Integer.parseInt(st.nextToken());
			}
			int up = 0, down = 0;
			for(int i=0; i<N-1; i++) {
				int diff = obs[i] - obs[i+1];
				
				// 내려오기 
				if(diff > 0) down = Math.max(down, diff);
				// 올라가기 
				else up = Math.max(up, Math.abs(diff));
			}
			sb.append("#").append(tc).append(" ").append(up).append(" ").append(down).append("\n");
		}
		System.out.print(sb.toString());
	}

}
