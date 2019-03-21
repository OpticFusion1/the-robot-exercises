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
        String test1 = "Happy";
        String test2 = "Podiversery";
        String test3 = "Counterdiaglyph";
        String test4 = "UNCOPYRIGHTABLE";

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

//Testing done on CodeWars site
}
/* CodeWars Solutions:

Shortest solution suggested:
public static boolean  isIsogram(String str) {
    return str.length() == str.toLowerCase().chars().distinct().count();

Another solution:

public class isogram {
    public static boolean  isIsogram(String str) {
        str = str.toLowerCase();
        for(char ch : str.toCharArray()){
            if(str.indexOf(ch) != str.lastIndexOf(ch)) return false;
        }
        return true;
    }
}

Solution that is similiar to my solution:

public class isogram {
  public static boolean isIsogram(String str) {

    if (str.equals("")) {
      return true;
    }

    str = str.toLowerCase();
    char[] arr = str.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      for (int x = 0; x < i; x++) {
        if (arr[i] == arr[x]) {
        return false;
        }
      }
    }
    return true;
  }

}


    */