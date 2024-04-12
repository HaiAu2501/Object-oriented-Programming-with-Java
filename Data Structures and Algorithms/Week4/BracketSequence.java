import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BracketSequence {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        br.close();
        generateParenthesis(a, 0, 0, "");
        bw.flush();
        bw.close();
    }

    private static void generateParenthesis(int[] a, int open, int index, String current) throws IOException {
        if (index == a.length) {
            if (open == 0) { // only valid if all open brackets are closed
                bw.write(current + " ");
            }
            return;
        }

        if (a[index] == 0) { // '?' case, try both open '(' and close ')'
            if (open + 1 <= a.length / 2) { // add open bracket if it doesn't exceed half
                generateParenthesis(a, open + 1, index + 1, current + "1");
            }
            if (open > 0) { // add close bracket if there is an unmatched open bracket
                generateParenthesis(a, open - 1, index + 1, current + "2");
            }
        } else { // '(' or ')'
            if (a[index] == 1) { // '('
                if (open + 1 <= a.length / 2) {
                    generateParenthesis(a, open + 1, index + 1, current + "1");
                }
            } else { // ')'
                if (open > 0) {
                    generateParenthesis(a, open - 1, index + 1, current + "2");
                }
            }
        }
    }
}
