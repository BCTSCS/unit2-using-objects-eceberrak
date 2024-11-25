/**
 * Lab Activity: String Methods and Wrapper Class Practice
 * Topics: String immutability, String methods, Wrapper classes
 */

public class MethodsLab {
    public static void main(String[] args) {
        // Section 1: String Methods and Immutability
        System.out.println("=== String Methods Practice ===\n");
        stringPractice();
        
        // Section 2: Wrapper Class Operations
        System.out.println("\n=== Wrapper Class Practice ===\n");
        wrapperPractice();
        
        // Section 3: Practice Exercises
        System.out.println("\n=== Practice Exercises ===\n");
        exercises();
        
        //value vs new
        System.out.println("\n=== Practice Exercises ===\n");
        exercises();

    }

    public static void stringPractice() {
        // Exercise 1: indexOf() and substring()
        String text = "Java is fun";
        System.out.println("Original string: " + text);
        
        // indexOf demonstrations
        System.out.println("indexOf 'Java': " + text.indexOf("Java"));
        System.out.println("indexOf 'a': " + text.indexOf('a'));
        System.out.println("indexOf 'a' from index 6: " + text.indexOf('a', 2));
        
        // substring demonstrations
        String sub1 = text.substring(7);
        String sub2 = text.substring(0,7);
        System.out.println("substring from 7: " + sub1);
        System.out.println("substring 0 to 7: " + sub2);
        
        // Exercise 2: String length and immutability
        String original = "Hello";
        System.out.println("\nOriginal string: " + original);
        System.out.println("Length: " + original.length());
        
        // Demonstrate immutability
        original.concat(" World");
        System.out.println("After concat: " + original);
        
        // Correct way to modify
        original = original.concat(" World");
        System.out.println("After reassignment: " + original);
        
        // Exercise 3: compareTo and equals
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        String str4 = new String("apple");
        
        System.out.println("\nString comparison results:");
        System.out.println("apple compareTo banana: " + str1.compareTo(str2));
        System.out.println("banana compareTo apple: " + str2.compareTo(str1));
        System.out.println("apple compareTo apple: " + str1.compareTo(str3));
        
        System.out.println("\nEquals comparison results:");
        System.out.println("str1.equals(str3): " + str1.equals(str3));
        System.out.println("str1.equals(str4): " + str1.equals(str4));
        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1 == str4: " + (str1 == str4));
    }

    public static void wrapperPractice() {
        // Exercise 1: Autoboxing and Unboxing
        Integer wrap = 100;  // autoboxing
        int primitive = wrap;  // unboxing
        
        System.out.println("Wrapped value: " + wrap);
        System.out.println("Primitive value: " + primitive);
        
        // Exercise 2: Wrapper Immutability
        Integer num = 5;
        Integer num2=num;
        System.out.println("\nOriginal Integer: " + num);
        
        // This creates a new Integer object
        num++;  // unbox, increment, autobox
        System.out.println("After increment: num: " + num+ "num2: "+num2);
        
        // Exercise 3: Wrapper Object Pool (-128 to 127)
        Integer int1 = 127;
        Integer int2 = 127;
        Integer int3 = 128;
        Integer int4 = 128;
        
        System.out.println("\nWrapper Object Pool Testing:");
        System.out.println("127 == 127: " + (int1 == int2));    // true (uses pool)
        System.out.println("128 == 128: " + (int3 == int4));    // false (outside pool)
        System.out.println("128 equals 128: " + int3.equals(int4)); // true
        
        // Exercise 4: Mixed Operations
        Integer wrapNum = 50;
        int primNum = 50;
        System.out.println("\nMixed operations:");
        System.out.println(wrapNum + primNum);  // auto-unboxing occurs
        System.out.println(wrapNum.compareTo(primNum));  // auto-boxing occurs
    }

    public static void exercises() {
        // Exercise 1: String Method Chaining
        String sentence = "Java Programming";
        String processed = sentence
                                  .toLowerCase()
                                 .substring(5)
                                 .concat(" is fun");
        
        System.out.println("Original: '" + sentence + "'");
        System.out.println("Processed: '" + processed + "'");
        
        // Exercise 2: Find all occurrences of a character
        String text = "Mississippi";
        char vowel = 'i';
        int index = text.indexOf(vowel);

        System.out.println("\nFinding the first occurrence of '" + vowel + "' in " + text);
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Character not found.");
        }
    }
    public void valueValue(){
        Integer a =100;
        Integer b = Integer.valueOf(100);
        System.out.println("Value vs New " + (a==b));
        Integer c =100;
        Integer d = Integer.valueOf(100);
        System.out.println("Value vs New " + (c==d));
    }
}

/**
 * Lab Tasks to Complete:

 * Wrapper Class Tasks: Choose TWO
 * 1. valueVsNew(): Demonstrate  valueOf() vs new Integer() differences
 * 2. caching(): Create a method that shows memory impact of wrapper operations
 * 3. parsing(): Write code to demonstrate wrapper class parsing methods   // The string to parse "45.6";
 * 4. helper() Show different scenarios of auto-boxing/unboxing
 * *
 *  * String Method Tasks: Choose ONE
 *  * 1. Create a method that counts all vowels in a string using indexOf()
 *  * 2. Write a method that reverses a string using substring()
 *  * 3. Implement a method that checks if one string contains all characters of another
 *  * 4. Create a method that finds the longest common prefix of two strings
 *  *
 *  Common Pitfalls to Watch For:
 *  * 1. Forgetting string immutability
 *  * 2. Not checking for null before using string methods
 *  * 3. Assuming all Integer objects with same value are ==
 *  * 4. Not considering caching outsde boundaries
 *
 *  *
 * Advanced Exercises:
 * 
 * 1. String Processing Class TextStats
 *    Write a method that processes text and returns statistics:
 *    - Word count : int
 *    - Character count (excluding spaces) : int
 *    - Number of sentences : int
 *    - Most frequent character : char
 *    - Most frequent word: String
 *    -The text : String
 *    
 * Example:
 * public static  TextStats analyzeText(String text) {
 *     // Your implementation here
 * }
 *
 */
