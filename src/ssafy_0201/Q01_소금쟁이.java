package ssafy_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01_소금쟁이 {
	static int T, size, num;
	static int[][] map;
	static int pos[][] = {{1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트케이스
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken()); //연못크기
			num = Integer.parseInt(st.nextToken()); //소금쟁이 수
			
			map= new int[size][size];
			int idx = 0; //방문했던 소금쟁이 자리 또 가는 소금쟁이 수
			
			for (int i = 0; i < num; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st2.nextToken());
				int col = Integer.parseInt(st2.nextToken());
				int dir = Integer.parseInt(st2.nextToken());
				
				if(map[row][col] ==0) map[row][col] =i+1;
				else {
					idx=i+1; break;
				}
				
				for (int j = 3; j >0; j--) {
					row += j * pos[dir-1][0];
					col += j * pos[dir-1][1];
					if(row<0 || row>=size || col <0 || col>=size) break;
					if(map[row][col] != 0) {
						idx = i+1;
						break;
					}
					map[row][col] = i+1;
				}
			}
			System.out.println("#"+(tc+1)+" "+idx);	
		}
	}
}
