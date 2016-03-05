import java.io.BufferedReader;
import java.io.FileReader;

public class Project3 {
public static void main(String args[])throws Exception{
	//Assignment 3
	// 12/2/2015 James Park ID:23084108

	
	//Also, project3.txt is read when the file is named exactly "project3" in txt format and is in the same folder as the project.
	//AKA the folder with .settings, bin, src, .classpath. and .project and not in the src folder
	//Please look at my project3.txt if there is ambiguity or errors, as the program works when there is one infix expression placed per line in the txt file. Thank you!  
	//Please email me at James.Park08@qmail.cuny.edu if you have any question/problems. Thank you.	
	
	
	
	IFtoPF Converter= new IFtoPF();
	String PostFixString=Converter.getPostFixString();//PostFixString holds the postfix string from the IFtoPF class
	
	FileReader file = new FileReader("project3.txt");
	BufferedReader reader = new BufferedReader(file);
	
	
	
	
	
	
	
	
	String InFixTxt = "";				//inFixTxt is the starting file with nothing in it.
	String readTxt= reader.readLine();	//using the read object from readLine, 
	
	while(readTxt != null){						// This loop reads one line
		InFixTxt += readTxt;					// After reading the line , String InFixTxt receives the string from the line 
		System.out.println("Your infix value is: "+InFixTxt);									// Sysout the infix value						
		System.out.print("Your postFix value is: "); Converter.PostFixConverter(InFixTxt);	// The String is then sent over to the IFtoPF converter to convert and print the PostFix value

		InFixTxt="";							//Sets the string back to "" and reset
		readTxt = reader.readLine();			// readTxt goes onto the next line of the text file.
		
														
		FixQueue FQ = new FixQueue();					// NEW object for Assignment 3. Creates a new FixQueue object.
		FQ.QueueStringChar(Converter.PostFixString);	// This method enqueues the postfix string into the queue
														// The method parameter is the Converter.PostFixString aka the PostFixString value from the Converter class
		FQ.ExpressionTreeCreate();						//ExpressionTreeCreate() creates the expression tree
		FQ.ExpressionTreeEvaluate();					//ExpressionTreeEvalute() evaluates the tree and prints a value
														
														// Can also use FQ.ExpressionTree(); instead of the ExpressionTreeCreate() and ExpressionTreeEvaluate()
	}													// but I choose to just but both.	
	
	
	
	
}
}
