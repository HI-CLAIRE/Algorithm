package IM대비SWEA;

import java.util.ArrayList;
import java.util.Scanner;

public class 새로운버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
		
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				int type = sc.nextInt();
				int start = sc.nextInt();
				int end = sc.nextInt();
				list.add(new int[] {type, start, end});
			}
			
			int[] cnt = new int[1001];
			
			for(int i=0; i<N; i++) {
				int type = list.get(i)[0];
				int start = list.get(i)[1];
				int end = list.get(i)[2];
				boolean flag = false;
				cnt[start]++;
				cnt[end]++;
				switch(type) {
				// 일반
				case 1:
					for(int j=start; j<=end; j++) {
						if(j==start || j==end) {
							continue;
						}
						cnt[j]++;
					} 
					break;
				
				// 급행
				case 2:
					for(int j=start; j<=end; j += 2) {
						if(j==start || j==end) {
							continue;
						}
						cnt[j]++;
					}
					break;
				// 광역
				case 3:
					if(isEven(start)) {
						for(int j=start; j<=end; j++) {
							if(j==start || j==end) {
								continue;
							}
							if(j % 4 == 0) {
								cnt[j]++;
							}
						}
					} else {
						for(int j=start; j<=end; j++) {
							if(j==start || j==end) {
								continue;
							}
							if(j % 3 == 0 && j % 10 != 0) cnt[j]++;
						}
					}
					break;
				}
			}
			int max = 0;
			for(int i : cnt)
				max = Math.max(i, max);
			System.out.println("#" + tc + " " + max);
		}

	}
	public static boolean isEven(int n) {
		if(n % 2 == 1) 
			return false; 
		return true;
	}

}
