import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
Problem Url > https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class ClimbingLeaderboard {

 
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice, int uniqueCount) {
        int[] res = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            int left = 0;
            int right = uniqueCount;
            int mid = 0;
            int lastSmallestIndex = -1;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (scores[mid] == alice[i]) {
                    lastSmallestIndex = mid + 1;
                    break;
                } else if (scores[mid] > alice[i]) {
                    left = mid + 1;
                } else if (scores[mid] < alice[i]) {
                    right = mid - 1;
                    lastSmallestIndex = mid + 1;
                }
            }
            res[i] = lastSmallestIndex;
        }

        return res;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int j=0;
        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            if(i==0||(j-1>-1&&scoresItem!= scores[j-1])){
             scores[j] = scoresItem;
                j++;
            }
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice,j);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

