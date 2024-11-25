/**
 * Write a description of class MethodsLab2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MethodsLab2  
{
    

    
    public MethodsLab2()
    {
    }
    public static void forloop(int start, int stop, int increment) {
        System.out.print("start " + start + " : stop " + stop + " : increment " + increment + "\n");
        
        for (int i = start; i < stop; i += increment) {
            System.out.print(i + " ");
        }
        
        System.out.println(); 
    }
    public static void whileloop(int number){
        int i = 0;
        int sum = 0;
        while (number>0){
            sum+=number%10;
            number/=10;
            i++;
        }
        System.out.println(i + " digits totaling " + sum);
     
    }
    public static void addHyphen(String input){
        System.out.println(input);
        String upperCaseString = input.toUpperCase();
        System.out.println(upperCaseString);
        String hyphenatedString = upperCaseString.replace(" ", "-");
        System.out.println(hyphenatedString);
    }
    public static void main(String[]args){
            forloop(2,90,5);
            forloop(-10,8,2);
            forloop(100,150,5);
            whileloop(234);
            whileloop(10000);
            whileloop(123456789);
            whileloop(222222);
            addHyphen("Hello World");
            addHyphen("Jim Bob");
            addHyphen("Computer Science");
            addHyphen("UIL TCEA");
            addHyphen("State Champions");
        }
    }

