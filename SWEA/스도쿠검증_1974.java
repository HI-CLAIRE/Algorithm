package SWEA;

import java.util.Scanner;

public class 스도쿠검증_1974 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			int[][] map = new int[9][9];
			int[][] cnt = new int[27][10];
			boolean check = true;
			
			for(int r=0; r<9; r++)
				for(int c=0; c<9; c++)
					map[r][c] = sc.nextInt();
			
			//가로 검사
			out : for(int r=0; r<9; r++)
			{
				for(int c=0; c<9; c++)
				{
					if(cnt[r][map[r][c]] == 0)
						cnt[r][map[r][c]] += 1;
					else
					{
						check = false;
						break out;
					}
				}
			}
			
			//세로 검사
			out : if(check == true)
			{
				for(int c=0; c<9; c++)
				{
					for(int r=0; r<9; r++)
					{
						if(cnt[c+9][map[r][c]] == 0)
							cnt[c+9][map[r][c]] += 1;
						else
						{
							check = false;
							break out;
						}
					}
				}
			}
			
			// 그리드 검사
			out : if(check == true)
			{
				for(int a=0; a<3; a++)
				{
					for(int b=0; b<3; b++)
					{
						for(int r=0; r<3; r++)
						{
							for(int c=0; c<3; c++)
							{
								if(cnt[3*a+b+18][map[3*a+r][3*b+c]] == 0)
									cnt[3*a+b+18][map[3*a+r][3*b+c]] += 1;
								else
								{
									check = false;
									break out;
								}
							}
						}
					}
				}
			}
			if(check == true)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}

	}

}
