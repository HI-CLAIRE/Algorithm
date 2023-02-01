package IM대비SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 일회용 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int min = sc.nextInt();	// 최소인원
			int max = sc.nextInt(); // 최대인원
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] cntarr = new int[101];
			for(int i : arr) {
				cntarr[i]++;
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<101; i++) {
				if(cntarr[i] != 0) list.add(cntarr[i]);
			}
			
			int ans = -1;
			int len = list.size();
			for(int i=1; i<len-1; i++) {
				int t1 = i;
				for(int j=i+1; j<len; j++) {
					int c1=0, c2=0, c3=0;
					int t2 = j;
					for(int k=0; k<t1; k++) 
						c1 += list.get(k);
					for(int k=t1; k<t2; k++) 
						c2 += list.get(k);
					c3 = N - (c1+c2);
					
					if(c1<min || c2<min || c3<min || c1>max || c2>max || c3>max) {
						
						continue;
					}
					ans = Integer.MAX_VALUE;
					int mini = Math.min(c1, Math.min(c2, c3));
					int maxi = Math.max(c1, Math.max(c2, c3));
					
					ans = Math.min(ans, maxi-mini);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
