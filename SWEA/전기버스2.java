package IM대비SWEA;

import java.util.Scanner;

public class 전기버스2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int K = sc.nextInt(); // 충전하면 갈 수 있는 거리 
			int N = sc.nextInt(); // 정류장 수  
			int M = sc.nextInt(); // 충전기가 있는 정류장 번호
		
			int arr[] = new int[N + 1];
			
			for(int i=0; i<M; i++) {
				arr[sc.nextInt()] = 1;
			}
			
			boolean finished = true;
			
			int charge_cnt = 0;
			int current_idx = 0;
			
			out : while(finished) {
				int lastchargeSt = -1;
				for(int i = current_idx + 1; i <= current_idx + K; i++) {
					if(i == N) {
						break out;
					}
					if(arr[i] == 1) {
						lastchargeSt = i;
					}
				}
				
				if(lastchargeSt != -1) {
					charge_cnt++;
					current_idx = lastchargeSt;
				} else {
					finished = false;
				}
			}
			
			if(finished) {
				System.out.println("#" + tc + " " + charge_cnt);
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}

}
