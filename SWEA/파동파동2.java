package IM대비SWEA;

import java.util.Scanner;

public class 파동파동2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();	// 배열의 크기
			int[][] map = new int[N][N];
			
			int init = sc.nextInt();	// 시작값
			int r = sc.nextInt() - 1;	// 행
			int c = sc.nextInt() - 1;	// 열
			int D = sc.nextInt();		// 얼만큼씩 증감하는지
			
			map[r][c] = init;	// (r,c)값은 초기값
			
			int i = 1;	// 시행횟수 (근데 초기값이 주어지니까 1부터 시작했음)
			int next = 0; // D가 증감되고난 다음값
			// 즉 i가 한 번씩 증감될 때마다 next가 D만큼 바뀐다.
			// next = init + (D * i);

			// 어디까지 증감할지 모르기 때문에 무한루프를 돌려주면서 
			// while문 안에서 탈출조건으로 제어한다.
			while(true) {
				// next는 말그대로 다음 숫자
				// init에서 i만큼 반복된 D를 더해준다.
				next = init + (D * i);

				// 문제 조건에 최대값은 255까지 늘어날 수 있다고 했으므로
				if(next>=255) next = 255;
				
				// next의 값이 음수가 되거나 (파동파동 그림 2번)
				// 2차원 배열을 벗어나면 종료 (파동파동 그림 1번)
				if(next <= 0 || (r + i >= N && c + i >= N && r - i <0 && c - i < 0)) break;
				
				// i번째 테두리의 시작좌표(좌측 대각선 꼭지점, 서북)
				int nr = r - i;
				int nc = c - i;
				
				// 시작좌표를 기준으로 4개를 각자 따로 본다.
				// 시행횟수는 3 -> 5 -> 7 -> ...
				// 시행횟수별로 for문을 4번 돌릴 것이기 때문에! (테두리)
				for(int j=0; j<2*i+1; j++) {
					
					// 좌 (아래쪽으로++, 서북)
					if(nr+j>=0 && nr+j<N && nc>=0 && nc<N) {
						map[nr + j][nc] = next;
					}

					// 상 (오른쪽으로++, 서북)
					if(nc+j>=0 && nc+j<N && nr>=0 && nr<N) {
						map[nr][nc + j] = next;
					}

					// 하 (오른쪽으로++, 서남)
					if(r+i>=0 && r+i<N && nc+j>=0 && nc+j<N) {
						map[r + i][nc + j] = next;
					}

					// 우 (아래쪽으로++, 동북)
					if(c+i>=0 && c+i<N && nr+j>=0 && nr+j<N) {
						map[nr + j][c + i] = next;
					}
				}
				i++;
			}
//			printer(map, N);
			

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int y=0; y<N; y++) {
				int sum = 0;
				for(int x=0; x<N; x++) {
					sum += map[y][x];
				}
				sb.append(sum).append(" ");
			}
			System.out.println(sb.toString());
		}

	}
//	public static void printer(int[][] map, int N) {
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + "  ");
//			}
//			System.out.println();
//		}
//	}

}
