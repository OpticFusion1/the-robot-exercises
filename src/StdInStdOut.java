import java.util.Scanner;

public class StdInStdOut {
//    TaskIn this challenge, you must read  integers from stdin and then print them to stdout. Each integer must beprinted on a new line. To make the problem a little easier, a portion of the code is provided for you in theeditor below.Input FormatThere are  lines of input, and each line contains a single integer.Sample Input42100125Sample Output42100125

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
