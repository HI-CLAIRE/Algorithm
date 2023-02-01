package IM대비SWEA;

import java.util.Scanner;

public class 전기버스3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int K = sc.nextInt();	// 한 번에 갈 수 있는 최대 정류장
			int N = sc.nextInt();	// 정류장 수
			int M = sc.nextInt();	// 충전기가 있는 정류장 수
			
			boolean[] map = new boolean[N+K];	// 현재 정류장에서 K번만큼 더 가볼 거니까
			
			// 정류장이 있는 곳은 true
			for(int i=0; i<M; i++) {
				map[sc.nextInt()] = true;
			}
			
			int start = 0, next = 0, ans = 0;
			out : while(true) {
				
				// 중간에 정류장이 있는지 판별
				// 중간에 정류장이 있다면 가장 먼 정류장을 다음 시작점으로 만들어줘야 한다.
				for(int i=start; i<=start + K; i++) {
					// 현재지점이 더 가다가 마지막 종점을 지났다면 while문을 빠져나온다.
					if(i >= N) {
						break out;
					}
					// 정류장이 있다면 가장 먼 정류장을 다음 시작점으로 갱신
					if(map[i]) {
						next = i;
					}
				}

				// 중간에 정류장이 없어서 충전을 못한 것이므로 0을 출력하고 종료
				if(start == next) {
					ans = 0;
					break;
				}
				
				// 다음 시작지점을 저장해두었던 가장 먼 정류장으로 갱신
				start = next;
				
				// 충전횟수
				ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
