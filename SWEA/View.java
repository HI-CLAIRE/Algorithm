package SWEA;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[255][N];
			for(int x=0; x<N; x++) {
				int H = sc.nextInt();
				for(int y=0; y<H; y++) {
					map[y][x] = 1;
				}
			}
			int ans = 0;
			for(int y=0; y<255; y++) {
				for(int x=2; x<N-2; x++) {
					if(map[y][x] == 1) {
						for(int i = -2; i<=2; i++) {
							if(i == 0) continue;
							
							int nx = x + i;
							
							if(map[y][nx] == 1) break;
							else if(map[y][nx] == 0 && i==2) {
								ans++;
								break;								}
						}
						
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
