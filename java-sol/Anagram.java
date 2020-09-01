import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//Problem URL > https://www.hackerrank.com/challenges/anagram/problem
public class Anagram {


    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        Set<Character> targetSet = new HashSet<>();
        int charCount[][] = new int[2][26];
        char[] charArray = s.toCharArray();
        int n = s.length();
        int count = 0;
        
        for (int i = 0; i < n / 2; i++) {
            charCount[0][charArray[i] - 'a']++;
            charCount[1][charArray[n - i - 1] - 'a']++;
            targetSet.add(charArray[n - i - 1]);
        }
        
        for (Character character : targetSet) {
            if (charCount[1][character- 'a']>charCount[0][character - 'a']) 
            count += (charCount[1][character - 'a'] - charCount[0][character - 'a']);
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

