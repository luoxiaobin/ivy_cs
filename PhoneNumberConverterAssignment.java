import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
public class PhoneNumberConverterAssignment{
        
//Call method 1: Use the scanner to read the file line by line to create variables for the name and the phone numbers. 
//        import java.util.Scanner;
 
//Call method 2: Remove all non-number characters from the phone number variables.
//Call method 3: for all 11-digit numbers, determine if they should be changed to invalid.
//If not, and their first digit is ‘1’, remove the first digit.
//Call method 4: In the phone number variables, convert any letters to their corresponding numbers.
//Call method 5: Reformat the phone numbers by inserting parentheses, dashes, and spaces.
 
//Create a new File object and assign it a new file that will be writing the new names and phone numbers.
//Create a Printer Writer and link it to the new File object.
//Use the writer to store the names and phone numbers into the file line by line.
//Output each variable (each name and their new corresponding phone number).
 
//Method 1: Create a variable for each line with the name and the unconverted phone number.
//Going through each index of the variables, make the variables for the names by determining the first index that is a ‘+’, ‘(‘, or a digit.
//Create string variables for the phone numbers using the remaining characters.

    public static String cleanup_name (String line) { //String x is the variable of the entire line (name and phone number), string y is the new name variable, string number is the number variable.
        
        String name ="";
        for (int i=0; i < line.length(); i++) {
            //if ((line.charAt(i)!='(') && (line.charAt(i)!='+') && !Character.isDigit(line.charAt(i))) {
            //    name = name + line.charAt(i); //Add the character at index i of variable x if it is not a '(', '+', or a number
            //}

            if ((line.charAt(i)=='(') || (line.charAt(i)=='+') || Character.isDigit(line.charAt(i))) {
                break;
            }
            name = name + line.charAt(i); //Add the character at index i of variable x if it is not a '(', '+', or a number
        }
        return name;
    }

    public static void separateNameAndNumber (String line, String name, String number) { //String x is the variable of the entire line (name and phone number), string y is the new name variable, string number is the number variable.
        
        for (int i=0; i < line.length(); i++) {
            if ((line.charAt(i)!='(') || (line.charAt(i)!='+') || !Character.isDigit(line.charAt(i))) {
                name = name + line.charAt(i); //Add the character at index i of variable x if it is not a '(', '+', or a number
            }
            else if ((line.charAt(i)=='(') || line.charAt(i)==('+') || Character.isDigit(line.charAt(i))) {
                number = number + line.charAt(i); //Add the character at index i of variable x if it is a '(', '+', or a number
            }
        }
    }

//Method 2: Go through each index in each phone number. If it reads as a ‘+’ or ‘-’, it will be removed. Then, remove all spaces.
 
    public static void removeInNumber(String number) { //String number is the phone nunmber parameter
        for (int i=0; i < number.length(); i++) {
            if (number.charAt(i)=='(' || number.charAt(i)=='+' || Character.isDigit(number.charAt(i))) {
                number = number.replace(Character.toString(number.charAt(i)), ""); //if an index is a '(' or '+', it will be removed.
            }
            if (number.charAt(i)==' ') {
                number = number.replace(" ", ""); //remove all spaces in the string.
            }
        }
    }
                       
                   
        //Method 3: Determine the length of each phone number variable. If the variable has 11 characters, check if the first index is equal to ‘1’.
        //If not, change the variable to invalid. If it is, remove the ‘1’.
       
    public static void elevenCharacterStrings (String number) {
        if (number.length()==11) {
            if (number.charAt(0) != 1) {
                number = "invalid number"; //if the first digit of the number is not 1, it becomes invalid.
            }
            else if (number.charAt(0) == 1) {
                number = number.replaceFirst("1", ""); //Replaces the first occurence of '1' with a ''.
            }
        }
    }
 
    //Method 4: Go through each index in each phone number. If it reads a letter, convert the letter to its corresponding number using if statements.
 
    public static void convertToNumbers (String number) {
        for (int i=0; i < number.length(); i++) { //Going through every index value, if it is a letter, change it to its corresponding number.
            if (number.charAt(i) == 'a' || number.charAt(i) == 'b' || number.charAt(i) == 'c') {
                number = number.replace(Character.toString(number.charAt(i)), "2");
            }
            else if (number.charAt(i) == 'd' || number.charAt(i) == 'e' || number.charAt(i) == 'f') {
                number = number.replace(Character.toString(number.charAt(i)), "3");
            }
            else if (number.charAt(i) == 'g' || number.charAt(i) == 'h' || number.charAt(i) == 'i') {
                number = number.replace(Character.toString(number.charAt(i)), "4");
            }
            else if (number.charAt(i) == 'j' || number.charAt(i) == 'k' || number.charAt(i) == 'l') {
                number = number.replace(Character.toString(number.charAt(i)), "5");
            }
            else if (number.charAt(i) == 'm' || number.charAt(i) == 'n' || number.charAt(i) == 'o') {
                number = number.replace(Character.toString(number.charAt(i)), "6");
            }
            else if (number.charAt(i) == 'p' || number.charAt(i) == 'q' || number.charAt(i) == 'r' || number.charAt(i) == 's') {
                number = number.replace(Character.toString(number.charAt(i)), "7");
            }
            else if (number.charAt(i) == 't' || number.charAt(i) == 'u' || number.charAt(i) == 'v') {
                number = number.replace(Character.toString(number.charAt(i)), "8");
            }
            else if (number.charAt(i) == 'w' || number.charAt(i) == 'x' || number.charAt(i) == 'y' || number.charAt(i) == 'z') {
                number = number.replace(Character.toString(number.charAt(i)), "9");
            }
        }
    }
        
//Method 5: Insert parentheses to the first and fifth index. Then, insert a space to the sixth index. Then, insert a dash to the tenth index.
           
    public static String insertParenthesesSpaceDash (String number) {
        return "(" + number.substring(0,2) + ") " + number.substring(3,5) + "-" + number.substring(6,9);
    }

//Method 6: Remove any space at the end of the name variables.

    public static String removeEndSpace (String name) {
        return name.trim();
    }

    public static void main(String [] args){
        
    //Create a new File object and assign the file with the original phone numbers.
    
        File originalPhoneNumbers = new File("./originalPhoneNumbers.txt");

        String line_str="";
        String name_str="";
        String number_str="";

        //Create a Scanner and link it to the File object.
        try {
            Scanner input = new Scanner(originalPhoneNumbers);
            //Creating variables for each line, name, and phone number.

            while (input.hasNextLine()) {
                line_str = input.nextLine();
                System.out.println("Line:" + line_str + "Name:" + cleanup_name(line_str));
                //separateNameAndNumber(line_str, name_str, number_str);
                //System.out.println("Line:" + line_str +"Name:" + name_str + "Number:" + number_str) ;
            }

            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println ("Can't find the contact file!");
        }
    }
}   