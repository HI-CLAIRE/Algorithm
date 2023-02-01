package BOJ;

import java.util.Scanner;

public class 빙고_2578 {
	public static int isBingo(int[][] map) {
		int cnt = 0;
		for(int i=0; i<5; i++) {      
			int sumH = 0, sumV = 0;				
			for(int j=0; j<5; j++) {
				sumH += map[i][j];  //세로 확인
				sumV += map[j][i];  //가로 확인
			}
			if(sumH == 0) cnt++;
			if(sumV == 0) cnt++;
		}
		int sumR = 0, sumL = 0;
		for(int i=0; i<5; i++) {  
			sumR += map[i][i];    //우측 대각선 확인
			sumL += map[4-i][i];  //좌측 대각선 확인
		}
		if(sumR == 0) cnt++; 
		if(sumL == 0) cnt++;  
		if(cnt >= 3) return 1;    //빙고면 1
		else return 0;            //아니면 0
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[5][5];      //빙고판 
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				map[i][j] = sc.nextInt();
				
		for(int n=0; n<25; n++) {
			int num = sc.nextInt();
			for(int i=0; i<5; i++) 
				for(int j=0; j<5; j++)
					if(map[i][j] == num)
						map[i][j] = 0;    //같으면 0으로 바꿔치기
			int bingo = isBingo(map);
			if(bingo == 1) {
				System.out.println(n+1);
				break;
			}
		}
		sc.close();
	}
}