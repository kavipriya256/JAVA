import java.util.*;

class StringHandlingOperations{
int countcharacters(String input){
return input.replaceAll(" ","").length();
}

int countWords(String input){
return input.split(" ").length;
}

String reverseString(String input){
return new StringBuilder(input).reverse().toString();
}

boolean isPalindrome(String input){
String s;
s=input.replaceAll(" ","").toLowerCase();
s=new StringBuilder(s).reverse().toString();

if (s==input){
	return true;
}
else{
	return false;
}
}

String toUppercase(String input){
	String a;
	a=input.toUpperCase();
	return a;
}

String toLowercase(String input){
	String b;
	b=input.toLowerCase();
	return b;
	}

}
class StringHandlingDemo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringHandlingOperations operations = new StringHandlingOperations();

             System.out.println("Enter a string for processing:");
        String input = scanner.nextLine();
             System.out.println("Original String: " + input);
        
        int wordCount = operations.countWords(input);
             System.out.println("Word Count: " + wordCount);
        
        String reversedString = operations.reverseString(input);
             System.out.println("Reversed String: " + reversedString);
        
        boolean isPalindrome = operations.isPalindrome(input);
             System.out.println("Is Palindrome: " + isPalindrome);
        
        String upperCaseString = operations.toUppercase(input);
             System.out.println("Uppercase: " + upperCaseString);
        
        String lowerCaseString = operations.toLowercase(input);
             System.out.println("Lowercase: " + lowerCaseString);

        scanner.close();
    }
}
