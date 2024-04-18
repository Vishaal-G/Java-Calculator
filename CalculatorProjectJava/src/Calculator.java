//adding the imports needed to perform calculations, input and more
import java.util.Scanner;
import java.text.NumberFormat;
public class Calculator {
	/**
	 * Student: Vishaal Gopalan
	 * Course: ICS3U
	 * Date: May 2nd, 2022
	 * Description of code: A calculator application the user can use to perform basic arithmetic, trigonometric and quadratic expressions and equations
	 */
	public static void main(String[] args) {
		//Initializing variables
		Scanner input = new Scanner(System.in); 
		double sinEval = 0.0, sinRatio = 0.0, tanEval = 0.0, tanRatio = 0.0,cosEval = 0.0, cosRatio = 0.0; 	//variables for my sin,cos, tan results
		double angleDeg = 0, angleMeasure = 0; 	//variables to get the angle in degrees and to convert degrees to radians
		String rad_deg = "";//variable that stores whether or not the user wants the answer in radian or degree format
		String trigType = "";//variable that stores the trig ratio the user wants to evaluate
		
		String spaces = "", underScore = ""; 	//variables to determine how big the calculator size output must be
		int errorCount = 0; //variable that tells how many errors an equation
		boolean isOn = true; //variable that determines whether or not the user has exited the calculator application
		int choiceNum = 0; //variable that determines whether or not the user picks option1 or 2 for the trigonometric calculation
		int optionNum = 0;// variable that stores the option the user chooses in the main menu
		String mathEq = ""; //variable that stores the math expression user enters
		
		String opList = ""; //variable that stores the list of operators in chronological order of the user's math expression
		int total = 0; // variable that stores the total of the user's math expression
		String num1 = "",num2 = ""; //variable that stores the substring of each number before and after the operator in the user's math expression
		int numAscii1 = 0, numAscii2 = 0; //variables that stores the ASCII to decimal conversion of the user's numbers in the math expression
		int opNextToEachOther = 0; //variable that stores if there are two operators next to each other or not
		boolean isCorrect = false; //variable that checks if the user math expression is valid or not
		char plus = '+', minus = '-', mult = '*', div = '/', mod = '%', pow = '^', equal = '='; //variables that store the operators

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		//While loop that runs the whole calculator app
		while (isOn) {
			System.out.println("Welcome to the Speedy Calculator, please choose from one of the options below: ");
			System.out.println("1. Perform A Calculation");
			System.out.println("2. Perform A Trignometric Calculation");
			System.out.println("3. Quadratic Equation Solver");
			System.out.println("4. User Help Manual");
			System.out.println("5. Quit");
			optionNum = input.nextInt();
			input.nextLine(); 
			
			//If statement if the user wants to perform a calculation
			if (optionNum == 1) {
				//Do while that checks if the user's math expression is correct
				do {
					System.out.println("Enter an equation you would like to evaluate:");
				    mathEq = input.nextLine();	
				    System.out.println(mathEq);
					mathEq = mathEq.replaceAll(" ", "");
					if (mathEq.indexOf('=') == -1) {
						System.out.println("This is an error, you need to include an equals sign");
						errorCount += 1;
					}
					
					else if (mathEq.indexOf('=') != mathEq.length()-1) {
						System.out.println("This is an error, you cannot include operations or numbers after the equals sign");
						errorCount += 1;
					}
					
					else if (mathEq.endsWith("-=") || mathEq.endsWith("+=") || mathEq.endsWith("*=") || mathEq.endsWith("/=") || mathEq.endsWith("%=") ||mathEq.endsWith("^=")) {
						System.out.println("This is an error, there is no value after the last operator ");
						errorCount += 1;
					}
					
					else if (mathEq.indexOf("/0") != -1) {
						System.out.println("This is an error, you cannot divide by 0");
						errorCount += 1;
					}
					
					for (int i = 0;i<mathEq.length()-1;i++) {
						if (((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('+')) || ((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('-')) ||((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('/')) ||((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('%')) ||((mathEq.charAt(i)) == ('+') && mathEq.charAt(i+1) == ('^')) ||((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('+')) || ((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('-')) || ((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('/')) ||((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('%')) ||((mathEq.charAt(i)) == ('-') && mathEq.charAt(i+1) == ('^')) || ((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('+')) ||((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('-')) ||((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('/')) ||((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('%')) ||((mathEq.charAt(i)) == ('*') && mathEq.charAt(i+1) == ('^')) || ((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('+')) || ((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('-')) ||((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('/')) || ((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('%')) || ((mathEq.charAt(i)) == ('/') && mathEq.charAt(i+1) == ('^')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('+')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('-')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('/')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('%')) ||((mathEq.charAt(i)) == ('%') && mathEq.charAt(i+1) == ('^')) || ((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('+')) || ((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('-')) ||((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('*')) ||((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('/')) ||((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('%')) ||((mathEq.charAt(i)) == ('^') && mathEq.charAt(i+1) == ('^')) ) {
							errorCount += 1;
							opNextToEachOther += 1;
						}
						
					}//End of For loop for correctness
					
					if (opNextToEachOther == 1) {
						System.out.println("This is an error, you cannot have two operators next to each other");
					}
					if (errorCount == 0) {
						isCorrect = true;
					}
					
					errorCount = 0;
					
				} while (isCorrect == false);
				
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//				
				//If statement that adds all the operators in the user's math expression to a string in chronological order
				if (isCorrect == true) {
						mathEq = mathEq.replace(Character.toString('='),"");
						
						for (int j = 0;j<mathEq.length()-1;j++) {
							
							if (mathEq.charAt(j) == plus || mathEq.charAt(j) == minus || mathEq.charAt(j) == mult ||mathEq.charAt(j) == div ||mathEq.charAt(j) == mod || mathEq.charAt(j) == pow) {
								opList += mathEq.charAt(j);
								
							}
							
						}
						
						//While loop if there are more than one operator in the user's math expression
						while (opList.length() >= 2 ) {
							//Checks if the first index of the operator string is a +, -, *. / or ^
							if (opList.charAt(0) == '+') {
								num1 = mathEq.substring(0,mathEq.indexOf('+'));
								
								//Converts both numbers before and after operator to decimal value from ASCII
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('+') + 1, mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								//Adds the two decimal values to the total and resets the value of numAscii1 and numAscii2
								total = numAscii1 + numAscii2;
								numAscii1 = 0;
								numAscii2 = 0;
								
								//Getting rid of the operator from the operation String and replacing the variable total in for the operation we just did for the math expression
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\+", ""); 
							
								//(Same logic is applied for the else if statements of other operators, only difference is that we will perform another operation with the two decimal numbers that we converted from ASCII and that operation will be removed from the operator string)
								
								
							}
							
							else if (opList.charAt(0) == '-') {
								num1 = mathEq.substring(0,mathEq.indexOf('-'));
								
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('-')+1 , mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								total = numAscii1 - numAscii2;
								numAscii1 = 0;
								numAscii2 = 0;
								
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\-", ""); 
								
								
							}
							
							else if (opList.charAt(0) == '*') {
								num1 = mathEq.substring(0,mathEq.indexOf('*'));
								
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('*') + 1, mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								total = numAscii1 * numAscii2;
								numAscii1 = 0;
								numAscii2 = 0;
								
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\*", ""); 
							
			
							}
							
							else if (opList.charAt(0) == '/') {
								num1 = mathEq.substring(0,mathEq.indexOf('/'));
								
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('/') + 1, mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								if (numAscii1 == 0 || numAscii2 == 0 ) {
									System.out.println("Error");
									errorCount+=1;
								}
								
								total = numAscii1 / numAscii2;
								numAscii1 = 0;
								numAscii2 = 0;
								
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\/", ""); 
						
							
							}
							
							else if (opList.charAt(0) == '%') {
								num1 = mathEq.substring(0,mathEq.indexOf('%'));
								
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('%') + 1, mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								total = numAscii1 % numAscii2;
								numAscii1 = 0;
								numAscii2 = 0;
								
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\%", ""); 
					
							}
							
							else if (opList.charAt(0) == '^') {
								num1 = mathEq.substring(0,mathEq.indexOf('^'));
								
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int) Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('^') + 1, mathEq.indexOf(opList.charAt(1)));
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int)Math.pow(10, num2.length()-1-j);
								}
								
								total = (int) Math.pow(numAscii1, numAscii2);
								numAscii1 = 0;
								numAscii2 = 0;
								
								String combinedExp = mathEq.substring(0,mathEq.indexOf(opList.charAt(1)));
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\^", ""); 
				
							}
					
						}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------//
						//While loop if there is only one operator in the user's math expression
						while (opList.length() == 1) {
							//Same logic as if there are two or more operators, but this will also print the result of the expression to the user
							if (opList.charAt(0) == '+') {
								num1 = mathEq.substring(0,mathEq.indexOf('+'));
				
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('+') + 1, mathEq.length());
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								total = numAscii1 + numAscii2;
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));//
								opList = opList.replaceFirst("\\+", ""); //
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
							}
							
							else if (opList.charAt(0) == '-') {
								num1 = mathEq.substring(0,mathEq.indexOf('-'));
					
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('-') + 1, mathEq.length());
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								total = numAscii1 - numAscii2;
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\-", ""); 
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
							}
							
							else if (opList.charAt(0) == '*') {
								num1 = mathEq.substring(0,mathEq.indexOf('*'));
					
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('*') + 1, mathEq.length());
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								total = numAscii1 * numAscii2;
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));//chagne later cant use to string
								opList = opList.replaceFirst("\\*", ""); //change tostring method later
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
	
							}
							
							else if (opList.charAt(0) == '/') {
								num1 = mathEq.substring(0,mathEq.indexOf('/'));
					
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('/') + 1, mathEq.length());
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								if (numAscii1 == 0 || numAscii2 == 0 ) {
									System.out.println("Error");
									errorCount+=1;
								}
								
								total = numAscii1 / numAscii2;
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\/", ""); 
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
	
							}
							
							else if (opList.charAt(0) == '%') {
								num1 = mathEq.substring(0,mathEq.indexOf('%'));
					
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('%') + 1, mathEq.length());
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								total = numAscii1 + numAscii2;
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));//chagne later cant use to string
								opList = opList.replaceFirst("\\%", ""); //change tostring method later
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
	
							}
							
							else if (opList.charAt(0) == '^') {
								num1 = mathEq.substring(0,mathEq.indexOf('^'));
					
								for (int i = 0;i<num1.length();i++) {
									numAscii1 += ((int)num1.charAt(i)-48) * (int)Math.pow(10, num1.length()-1-i);
								}
								
								num2 = mathEq.substring(mathEq.indexOf('^') + 1, mathEq.length());
								
								for (int j = 0;j<num2.length();j++) {
									numAscii2 += ((int)num2.charAt(j)-48) * (int) Math.pow(10, num2.length()-1-j);
									
								}
								
								total = (int)Math.pow(numAscii1, numAscii2);
								String combinedExp = mathEq.substring(0,mathEq.length());
								mathEq = mathEq.replace(combinedExp, Integer.toString(total));
								opList = opList.replaceFirst("\\^", ""); 
								
								for (int i = 0;i<Integer.toString(total).length();i++) {
									spaces += " ";
									underScore += "_";
								}
								
								System.out.println(" "+  underScore + underScore + underScore);
								System.out.println("|" +underScore+ total + underScore + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + spaces + spaces + spaces + "|");
								System.out.println("|" + underScore + underScore + underScore + "|");
								System.out.println("");
	
							}
						}
						
								
							}
			}// End of option number 1 if statement
			
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------//
			//If the user would like to perform a trigonometric calculation
			if (optionNum == 2) {
				//Do while that makes the user pick whether they want to determine angle or trig ratio
				do {
					System.out.println("To evaulate a trig equation, pick on of the two options below:");
					System.out.println("Option 1. Determine the angle of a given trig ratio");
					System.out.println("Option 2. Evaluate the trig ratio of an angle");
					choiceNum = input.nextInt(); 
				}while (choiceNum != 1 && choiceNum != 2);
				
				input.nextLine();
				
				//If user selects option 1
				if (choiceNum == 1) {
					//Do while that makes the user pick which trig ratio they want to evaluate
					do {
						System.out.println("Would you like to evaluate the trig ratio of sin,cos,or tan?");
						trigType = input.nextLine();
					}while (!(trigType.equalsIgnoreCase("sin") || trigType.equalsIgnoreCase("cos")  || trigType.equalsIgnoreCase("tan")));
					
					//If the user would like to evaluate sin ratio
					if (trigType.equalsIgnoreCase("sin")) {
						//Asks the user for the sin trig ratio
						do {
							System.out.println("What is the ratio you would like to evaluate in sine?");
							sinEval = input.nextDouble();
							sinRatio = Math.asin(sinEval);
						}while (sinEval <= -1 || sinEval >= 1);
						
						//Asks the user whether they want angle in degrees or radians
						do {
							System.out.println("Would you like it in degrees or radians");
							rad_deg = input.nextLine();
							rad_deg = input.nextLine();
							
							if (rad_deg.equalsIgnoreCase("radians")) {
								System.out.println("The trig ratio of arcsin" + " " + sinEval + " is " +  Math.round(sinRatio * 10000.0)/10000.0 + " radians");
								System.out.println("");
							}
							
							else if (rad_deg.equalsIgnoreCase("degrees")) {
								System.out.println("The trig ratio of arcsin" + " " + sinEval + " is " + Math.round((sinRatio * 180/Math.PI)*10000.0)/10000.0 + " degrees");
								System.out.println("");
							}
							
						}while (rad_deg.equalsIgnoreCase("degrees") == true && rad_deg.equalsIgnoreCase("radians") == true); 
					}
					
					//Same logic as sin if statement, just now for cos ratio
					if (trigType.equalsIgnoreCase("cos")) {
						
						do {
							System.out.println("What is the ratio you would like to evaluate in cosine?");
							cosEval = input.nextDouble();
							cosRatio = Math.acos(cosEval);
						}while (cosEval <= -1 || cosEval >= 1);
						
						do {
							System.out.println("Would you like it in degrees or radians");
							rad_deg = input.nextLine();
							rad_deg = input.nextLine();
							
							if (rad_deg.equalsIgnoreCase("radians")) {
								System.out.println("The trig ratio of arccosine" + " " + cosEval + " is " +  Math.round(cosRatio * 10000.0)/10000.0 + " radians");
							}
							
							else if (rad_deg.equalsIgnoreCase("degrees")) {
								System.out.println("The trig ratio of arccosine" + " " + cosEval + " is " + Math.round((cosRatio * 180/Math.PI)*10000.0)/10000.0 + " degrees");
							}
						
						}while (rad_deg.equalsIgnoreCase("degrees") == true && rad_deg.equalsIgnoreCase("radians") == true); 
					}
					
					//Same logic as sin if statement, just now for tan ratio
					if (trigType.equalsIgnoreCase("tan")) {
						
						do {
							System.out.println("What is the ratio you would like to evaluate in tangent?");
							tanEval = input.nextDouble();
							tanRatio = Math.atan(tanEval);
						}while (tanEval == 0);
						
						do {
							System.out.println("Would you like it in degrees or radians");
							rad_deg = input.nextLine();
							rad_deg = input.nextLine();
							
							if (rad_deg.equalsIgnoreCase("radians")) {
								System.out.println("The trig ratio of arctangent" + " " + tanEval + " is " +  Math.round(tanRatio * 10000.0)/10000.0 + " radians");
							}
							
							else if (rad_deg.equalsIgnoreCase("degrees")) {
								System.out.println("The trig ratio of arctangent" + " " + tanEval + " is " + Math.round((tanRatio * 180/Math.PI)*10000.0)/10000.0 + " degrees");
							}
						
						}while (rad_deg.equalsIgnoreCase("degrees") == true && rad_deg.equalsIgnoreCase("radians") == true); 
					}
					
					
				}//End of finding the angle when the user gives trig ratio
				
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
				//If the user would like to find the trig ratio for an angle
				if (choiceNum == 2) {
					
					//Asks user for angle in degrees
					do {
						System.out.println("What is the angle you would like to find a trig ratio for in degrees please?");
						angleDeg = input.nextDouble();
					}while (angleDeg <= 0 && angleDeg >= 360);
					
					//Converts the angle to radians
					angleMeasure = Math.round((angleDeg * Math.PI/180)*1000.0)/1000.0;
					
					//Asks user if they want to find sin, cos, or tan
					do {
						System.out.println("Do you want to find the angle's sine, cosine or tangent?");
						input.nextLine();
						trigType = input.nextLine();
					}while ((!(trigType.equalsIgnoreCase("sin") || trigType.equalsIgnoreCase("cos")  || trigType.equalsIgnoreCase("tan"))));
					
					//Outputs sin of the angle 
					if (trigType.equalsIgnoreCase("sin")) {
						double sinNum = Math.round((Math.sin(angleMeasure))*1000.0)/1000.0;
						System.out.println("The sin of " + angleDeg + " is " + sinNum);
						System.out.println("");
						
					}
					
					//Outputs cosine of the angle
					if (trigType.equalsIgnoreCase("cos")) {
						double cosNum = Math.round((Math.cos(angleMeasure))*1000.0)/1000.0;
						System.out.println("The cosine of " + angleDeg + " is " + cosNum);
						System.out.println("");
						
					}
					
					//Outputs tangent of the angle
					if (trigType.equalsIgnoreCase("tan")) {
						double tanNum = Math.round((Math.tan(angleMeasure))*1000.0)/1000.0;
						System.out.println("The tangent of " + angleDeg + " is " + tanNum);
						System.out.println("");
						
					}
				}//End of finding trig ratio given angle
				
				
			}//End of option two
			
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------//
			//If the user would like to solve a quadratic equation
			if (optionNum == 3) {
				
				//Asks the user for the values of a, b, c of a quadratic equation
				System.out.println("This is the quadratic equation solver, please enter the value of a");
				double a = input.nextDouble();
				System.out.println("Please enter the value of b");
				double b = input.nextDouble();
				System.out.println("Please enter the value of c");
				double c = input.nextDouble();
				
				//Finds discriminant of quadratic equation to determine the number of roots
				double discrimant = b * b - 4.0 * a * c;
				
				//If there are two roots
				if (discrimant > 0.0) {
					double r1 = (-b + Math.pow(discrimant, 0.5)) / (2.0 * a);
	                double r2 = (-b - Math.pow(discrimant, 0.5)) / (2.0 * a);
	                System.out.println("The roots are " + Math.round(r1*100.00)/100.00 + " and " + Math.round(r2*100.00)/100.00);
	                System.out.println("");
				}
				
				//If there is one root
				else if (discrimant == 0.0) {
	                double r1 = -b / (2.0 * a);
	                System.out.println("The root is " + Math.round(r1*100.00)/100.00);
	                System.out.println("");
	            } 
				
				//If there are no roots
				else {
	                System.out.println("The equation has no real roots.");
	                System.out.println("");
	            }
				
			}//End of quadratic equation solver 
			
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
			//If user would like to get to know more about calculator
			if (optionNum == 4) {
				System.out.println("This is the Speedy Calculator, and all in one calculator that can perform a variety of calculations. Speedy can perform artihmetic, trignometric and quadratic operations. Choose from the list of options in the main menu to begin, and I hope you have a great time using Speedy!");
				System.out.println("");
			}//End of user manual
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
			//If user would like to exit
			if (optionNum == 5) {
				System.out.println("Thank you for using Speedy, hope you have a great rest of the day");
				isOn = false;
			}

//--------------------------------------------------------------------------------------------------------------//
				
		}//End of isOn loop that runs the application
				
	}//End of main method
					
}//End of public class