package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목이길수있을까_16955_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Character[][] map = new Character[10][10];
		
		for(int i=0; i<10; i++) {
			String str = br.readLine();			
			for(int j=0; j<10; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int[] dx = {0, 1, 1, 1, 0, -1, -1, -1, -1};
		int[] dy = {1, 1, 0, -1, -1, -1, 0, 1, 1};
		
		for(int y=0;y<10; y++) {
			for(int x=0; x<10;x++) {
				if(map[y][x] == 'X') {
					for(int d=0; d<8; d++) {
						int cnt = 1;
						for(int i=1; i<5;i++) {
							int nx = x + dx[d] * i;
							int ny = y + dy[d] * i;
							
							if(ny>=10 || nx>=10 || ny<0 || nx<0) break;
							
							if(map[ny][nx] == 'O') {
								break;
							}
							else if(map[ny][nx] == 'X') cnt++;
							if(cnt == 4 && i == 4) { 
								System.out.println(1);
								return;
							}
						}
						
					}
				}
			}
		}
		System.out.println(0);
	}

}


