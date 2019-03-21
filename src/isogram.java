/*An isogram is a word that has no repeating letters,
consecutive or non-consecutive.
 Implement a function that determines
 whether a string that contains only letters is an isogram.
 Assume the empty string is an isogram. Ignore letter case.
 From Codewars.
 URL: https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java
 */


public class isogram {
    public static boolean  isIsogram(String str) {
        // TODO
        // Look to see if 2 characters are the same in a string.
        //
        String strToLowerCase = str.toLowerCase();
        //Ignoring letter case by making it all lowercase characters.
        for (int i = 0; i < strToLowerCase.length(); i++)
            //first for loop iterates through string as variable i.
            for (int x = i + 1; x < strToLowerCase.length(); x++)
                //second for loop iterates through string same way but stored
                // in a variable named x and starting at second character of string.
                //Variables would match if started at the same starting point.
                if (strToLowerCase.charAt(i) == strToLowerCase.charAt(x))
                    //if statement compares each iteration and returns false if matched.
                    return false;

        // If no characters matched,
        // return true
        return true;

    }
    //TODO
//Testing done on CodeWars site but need to write a test to show verification of successful test.
    public static void main(String[] args) {
        System.out.println();
    }
}
