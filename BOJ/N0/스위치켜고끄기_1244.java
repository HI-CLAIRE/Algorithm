package BOJ;

import java.util.Scanner;

public class 스위치켜고끄기_1244 {


		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int[] arr = new int[N+1]; //0번을 안 쓸거임 

			for(int i = 1; i < N+1; i++)
				arr[i] = sc.nextInt();
			
			int st = sc.nextInt();
			for(int s=0; s<st; s++) {
				int gender = sc.nextInt();
				int pos = sc.nextInt();  //position
				if(gender == 1) {
					for(int i=1; i*pos<=N; i++)
						arr[pos*i] = 1 - arr[pos*i];
				}
				else if(gender == 2) {
					arr[pos] = 1 - arr[pos];
					for(int i=1; pos+i<=N&&pos-i>0; i++) {
						if(arr[pos+i] != arr[pos-i])
							break;
						else {
							arr[pos+i] = 1 - arr[pos+i];
							arr[pos-i] = 1 - arr[pos-i];
						}
					}
				}
			}
			
			for(int i = 1; i < N+1; i++) {
				System.out.print(arr[i] + " ");
				if(i%20 == 0)
					System.out.println();
			}
			sc.close();
		}
}
