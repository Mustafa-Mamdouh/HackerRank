import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//DUMMY Problem 
//Problem url >> https://www.hackerrank.com/challenges/the-time-in-words/problem
public class TimeInWords {

      static String[] hoursText = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "tweleve" };
    static String[] minutes = { "zero", "one minute", "two minutes", "three minutes", "four minutes", "five minutes",
            "six minutes", "seven minutes", "eight minutes", "nine minutes", "ten minutes", "eleven minutes",
            "twelve minutes", "thirteen minutes", "fourteen minutes", "quarter", "sixteen minutes", "seventeen minutes",
            "eighteen minutes", "nineteen minutes", "twenty minutes", "twenty one minutes", "twenty two minutes",
            "twenty three minutes", "twenty four minutes", "twenty five minutes", "twenty six minutes",
            "twenty seven minutes", "twenty eight minutes", "twenty nine minutes" };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        h = h % 12;
        if (m == 0) {
            return hoursText[h - 1] + " o' clock";
        }  else if (m == 1) {
            return "one minute past " + hoursText[h - 1];
        } else if (m == 30) {
            return "half past " + hoursText[h - 1];
        }else if (m < 30) {
            return minutes[m] + " past " + hoursText[h - 1];

        } else {            m%=30;
        m=30-m;

            return minutes[m] + " to " + hoursText[h];
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

