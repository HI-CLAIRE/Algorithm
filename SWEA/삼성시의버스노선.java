package IM대비SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 삼성시의버스노선 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			bw.write("#" + tc);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a, b});
			}
			
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			
			int[] bus = new int[P];
			for(int i=0 ;i<P; i++) {
				st = new StringTokenizer(br.readLine());
				bus[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] cnt = new int[P+1];
			for(int i=0; i<N; i++) {
				int A = list.get(i)[0];
				int B = list.get(i)[1];
				
				for(int b : bus) {
					if(A<=b && b<= B) cnt[b]++;
				}
			}
			for(int i=1; i<=P; i++) {
				bw.write(" " + cnt[i]);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
