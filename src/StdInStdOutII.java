import java.util.Scanner;

public class StdInStdOutII {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        String s = scan.nextLine();//Scan for string last

        if(s.isEmpty()){//if string input is empty scan again to the next line.
            s = scan.nextLine();
        }


        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

