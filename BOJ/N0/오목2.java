package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목2 {

	static int[][] map = new int[19][19];
	static int[] dx = {1, 1, 0, -1}; // 시계반대방향 
	static int[] dy = {0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int j=0; j<19; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[i][j] != 0) {
					for(int d=0; d<4; d++) {
						if(isomoq(i, j, d, map[i][j] , -1)) {
							System.out.println(map[i][j]);
							System.out.printf("%d %d\n", i + 1, j + 1);
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
		
	}


	//재귀함수
	//cnt -1, 5 일 때는 바둑알 다섯개의 앞 뒤 하나씩을 확인해줌
	static boolean isomoq(int x, int y, int d, int color, int cnt) {
		
		int nx = x + dx[d] * cnt;
		int ny = y + dy[d] * cnt;

		//탈출조건, 바둑알 다섯개의 색깔이 같고, 앞 뒤로 하나씩은 다른 색깔이거나 바둑알이 없을 때.
		if(cnt == 6)
			return true;

		//바둑판의 범위안에 있는지
		if(nx < 0 || ny < 0 || nx > 18 || ny > 18) {
			if (cnt == -1 || cnt == 5)
				return isomoq(x, y, d, color, cnt + 1);			//앞 뒤 바둑알의 경우 바둑판을 초과하는 범위라도 괜찮으니 재귀 진행
			return false;
		}

		//색깔판단
		if(map[nx][ny] == color && (cnt == -1 || cnt == 5))
			return false;
		else if(map[nx][ny] != color && (0 <= cnt && cnt <= 4))
			return false;  
		
		//모두 만족할 시 재귀 진행
		return isomoq(x, y, d, color, cnt + 1);
	}
}
