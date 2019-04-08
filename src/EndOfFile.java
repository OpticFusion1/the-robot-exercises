import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EndOfFile {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int line = 1;//count for loop that says do this x amount of times starting with one.
        while (scanner.hasNextLine()) {//While loop runs while there is a next line to process is true.
            System.out.println(line + " " + scanner.nextLine());//print each line number followed by a single space and string passed through the scanner.
            line++;//increment count by one to start next iteration of loop and it will stop incrementing when loop condition is false.
        }
        scanner.close();//if next line not available condition for while loop is false and scanner will close.
    }
}

