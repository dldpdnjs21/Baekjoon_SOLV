import java.io.*;
import java.util.*;

public class Main_BJ_2798_BlackJack {    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = Game(arr, N, M);
        System.out.println(result);
        
        sc.close();
        
    }

    private static int Game(int[] arr, int N, int M) {
        int result = 0;
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    int cardSum = arr[i] + arr[j] + arr[k];
                    
                    if(cardSum == M) {
                        return cardSum;  // M과 같으면 바로 리턴
                    } else if(cardSum < M && cardSum > result) {
                        result = cardSum;  // M보다 작으면서 가장 큰 값을 저장
                    }
                }
            }
        }
        return result;
    }
}
