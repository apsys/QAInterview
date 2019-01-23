/*
Strong Password

https://www.hackerrank.com/challenges/strong-password/problem

Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

Its length is at least .
It contains at least one digit.
It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+
She typed a random string of length  in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make her password strong?

Note: Here's the set of types of characters in a form you can paste in your solution:

numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"
Input Format

The first line contains an integer  denoting the length of the string.

The second line contains a string consisting of  characters, the password typed by Louise. Each character is either a lowercase/uppercase English alphabet, a digit, or a special character.

Constraints

Output Format

Print a single line containing a single integer denoting the answer to the problem.

Sample Input 0

3
Ab1
Sample Output 0

3
Explanation 0

She can make the password strong by adding  characters, for example, $hk, turning the password into Ab1$hk which is strong.

 characters aren't enough since the length must be at least .

Sample Input 1

11
#HackerRank
Sample Output 1

1
Explanation 1

The password isn't strong, but she can make it strong by adding a single digit.

*/

//Output:

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int len = 6 - password.length();
        int correction = 0;
        int count= 0;
        int d=0;
        int l=0;
        int u=0;
        int s=0;
        
        if(len < 0){
            len = 0;
        } 
        for(int i=0; i<password.length(); i++){
            if(password.charAt(i)>=48 && password.charAt(i)<=57 && d!=1){
                count++;
                d=1;
            } else if(password.charAt(i)>=97 && password.charAt(i)<=122 && l!=1){
                count++;
                l=1;
            } else if(password.charAt(i)>=65 && password.charAt(i)<=90 && u!=1){
                count++;
                u=1;
            } else if((password.charAt(i)=='!' || password.charAt(i)=='@' ||
                       password.charAt(i)=='#' || password.charAt(i)=='$' ||
                       password.charAt(i)=='%' || password.charAt(i)=='^' ||
                       password.charAt(i)=='&' || password.charAt(i)=='*' ||
                       password.charAt(i)== 40 || password.charAt(i)== 41 ||
                       password.charAt(i)=='+' || password.charAt(i)=='-') && s!=1){
                count++;
                s=1;
            }
        }
        
        if(len > 4-count){
            correction = len;
        } else{
            correction = 4-count;
        }
        
        return correction;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

