package DSA;

// Strings are IMMUTABLE -- meaning (it cannot be changed)
public class Strings {

    // Print Letters function using CharAt Method
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    // company - Intuit |||||| Check if a String is palindrome -- ("racecar" , "madam" , "noon")
    public static boolean isPalindrome(String str) { // O(n)
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Get Shortest path
    public static void getShortestPath(String path){ // O(n)
        // String path = "WNEENESENNN";
        int x=0, y =0;

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            if (direction == 'S') {
                y--;
            } else if (direction == 'N') {
                y++;
            } else if (direction == 'W') {
                x--;
            } else{
                x++;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        float shortest_Path = (float) Math.sqrt(X2 + Y2) ;
        System.out.println(shortest_Path);
    }

    // Find largest String
    public static String largestString(String fruits[]) { // O(x*n) -- x is length of a string 
        // String fruits[]={"apple", "mango", "banana"};
        String largeString = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if (largeString.compareTo(fruits[i])<0) {
                largeString = fruits[i];
            }
        }
        return largeString;
    }

    // company- Code-Nation [Convert Each First Letter Of Each Word to UpperCase]
    public static String toUpperCase(String str) { // O(n)
        StringBuilder sb = new StringBuilder("");

        // Converting the first character
        char ch = Character.toUpperCase( str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++) {
             if (str.charAt(i)== ' ') {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
             } else{
                  sb.append(str.charAt(i));
             }
        }
        
        return sb.toString();
    }

    // company - Amazon [String Compression]
    public static String stringCompression(String str) { // O(n)
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i+1) ) {
                count++;
                i++;
           }
           sb.append(str.charAt(i));
           if (count>1) {
            sb.append(count.toString());
           } 
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "aabbbccddd";
       System.out.println(stringCompression(str));
    }
}







// Two ways of defining a String
//          String str1 = "abcd"; // First way
//          String str2 = new String("abcd"); // Second way

// String name = sc.next(); // will allow only one word
// String name = sc.nextLine(); // will allow full sentence

// String length function
//          String fullName = "Rehan Mohammed";
//          System.out.println(fullName.length()); // fullName.length() is a function - don't confuse it with array.length

// Concatenation -- joining multiple strings together
//          String firstName = "Rehan";
//          String lastName = "Mohammed";
//          String age = "20";
//          String fullName = "My name is " + firstName + " " + lastName + " and my age is " + age;

// CharAt Method
//          printLetters(fullName);
//          System.out.println(firstName.charAt(1));

// Strings Comparison
//         String str1 = "Rehan";  // equal
//         String str2 = "Rehan";  // equal
//         String str3 = new String("Rehan");  // not equal

//         if (str1 == str2) {
//             System.out.println("Strings are equal!");
//         } else {
//             System.out.println("Strings are not equal!");
//         }
//         if (str1 == str3) {
//             System.out.println("Strings are equal!");
//         } else {
//             System.out.println("Strings are not equal!");
//         }
//         if (str1.equals(str3) ) {
//             System.out.println("Strings are equal!");
//         } else {
//             System.out.println("Strings are not equal!");
//         }

// Substring Method
//          String fullName = "Rehan Mohammed";
//          System.out.println(fullName.substring(0, 7));