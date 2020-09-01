import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttack {

       // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int canAttack = 0;
        Set<String> obstaclesSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }
        int tempR, tempC;
        tempR = r_q;
        tempC = c_q + 1;
        while (tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempC++;
            canAttack++;
        }
        tempC = c_q - 1;
        while (tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempC--;
            canAttack++;
        }

        tempR = r_q + 1;
        tempC = c_q;
        while (tempR <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR++;
            canAttack++;
        }
        tempR = r_q - 1;
        while (tempR > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR--;
            canAttack++;
        }
        tempR = r_q + 1;
        tempC = c_q + 1;
        while (tempR <= n && tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR++;
            tempC++;
            canAttack++;
        }
        tempR = r_q + 1;
        tempC = c_q - 1;
        while (tempR <= n && tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR++;
            tempC--;
            canAttack++;
        }
        tempR = r_q - 1;
        tempC = c_q - 1;
        while (tempR > 0 && tempC > 0 && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR--;
            tempC--;
            canAttack++;
        }
        tempR = r_q - 1;
        tempC = c_q + 1;
        while (tempR > 0 && tempC <= n && !obstaclesSet.contains(tempR + "-" + tempC)) {
            tempR--;
            tempC++;
            canAttack++;
        }

        return canAttack;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

