package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 키큰사람_11292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			
			double max = 0;
			ArrayList<String> arr = new ArrayList<String>();
			while(n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a  = st.nextToken();
				double b = Double.parseDouble(st.nextToken());
				
				if(b < max)
					continue;
				if(b > max)
					arr = new ArrayList<String>();
				arr.add(a);
				max = b;
			}
			for(String s : arr) {
				sb.append(s).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
