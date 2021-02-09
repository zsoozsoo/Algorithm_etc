package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baby_gin {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[11];
            int tri = 0, run=0;

            for (int j = 0; j <6 ; j++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            for (int j = 0; j < 11; j++) {
                if (arr[j] >= 3) {
                    tri += 1;
                    arr[j] -= 3;
                }

                else if (j-1>=0 && j+1<12 && arr[j - 1] >= 1 && arr[j] >= 1 && arr[j + 1] >= 1) {
                    if(arr[j-1]==2 && arr[j]==2 && arr[j+1]==2) {
                        run+=2;
                        arr[j - 1] -= 2; arr[j] -= 2; arr[j + 1] -= 2;
                    } else {
                        run += 1;
                        arr[j - 1] -= 1; arr[j] -= 1; arr[j + 1] -= 1;
                    }
                }
            }

            if((tri==1 && run==1) || (tri==2) || (run==2)) System.out.println("#"+(i+1)+" Yes!");
            else System.out.println("#"+(i+1)+" No!");


        }

    }
}
