package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 원재의메모리복구하기 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 for(int tc=1; tc<=T; tc++) {
			 int cnt = 0;
			 sb.append("#").append(tc).append(" ");
			 String str = br.readLine();
			 if(str.charAt(0) == '1') cnt++;
			 for(int i=0; i<str.length() - 1; i++) {
				 if(str.charAt(i) == '0' && str.charAt(i+1) == '1') cnt++;
				 if(str.charAt(i) == '1' && str.charAt(i+1) == '0') cnt++;
			 }
			 sb.append(cnt);
			 sb.append("\n");
		 }
		 System.out.println(sb.toString());
	}
}
