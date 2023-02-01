package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				list.add(Integer.parseInt(st.nextToken()));				
			}
			
			Collections.sort(list);
			System.out.println(list.get(list.size()-3));
		}

	}

}
