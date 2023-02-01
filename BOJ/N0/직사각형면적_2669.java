package BOJ;

import java.util.Scanner;

public class 직사각형면적_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		for (int n = 0; n < 4; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int len = sc.nextInt();
			int height = sc.nextInt();

			// 범위만큼 1로 채우기
			for (int i = x; i < len; i++)
				for (int j = y; j < height; j++)
					map[i][j] = 1;
		}
		// 채워진 사각형 면적 구하기
		int sum = 0;
		for (int[] row : map)
			for (int fill : row)
				sum += fill;
		System.out.println(sum);
		sc.close();
	}
}
