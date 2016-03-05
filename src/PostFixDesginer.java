
public class PostFixDesginer {

	public PostFixDesginer(){
	};
	
	
	public static boolean isOperator(char op){ // tests whether the character is a operator or not.
		switch(op){
			case '+':
				return true;
			case '-':
				return true;
			case '/':
				return true;
			case '*':
				return true;
			default: return false;
		}		
	}
	
	public boolean parenthesisCheck(char p){// returns true if there is a parenthesis.
		if(p=='(') return true;
		if(p==')') return true;
		else return false;
		
	}
	
	public int operatorPrec(char op){	//Operator Precedence that returns "precedence" values when given operators
		
		if(op=='+') return 2;
		if(op=='-') return 2;
		if(op=='/') return 3;
		if(op=='*') return 3;
		else return 0;
		}
		
	public static boolean isNumeric(String Thestring)  //Evaluates the string if it is numeric or not. Returns true or false
	{  
	try{  
	    int i = Integer.parseInt(Thestring);  
	 }  
	 catch(NumberFormatException nfe){  
	  return false;  
	 }  
	  return true;  
	}
	
	
	public static boolean isVariable(String theString){	//returns true if theString is a variable, else return false.
		if (Character.isLetter(theString.charAt(0)))
			return true
			;
		return false;	
	}
	
	public static int operatorReturn(int left, int right, String operator){		//Basically the method returns a value given a left, right and operator
		if(operator.equals("+")){return left+right;};
		
		if(operator.equals("-")){return left-right;};
		
		if(operator.equals("*")){return left*right;};
		
		if(operator.equals("/")){return left/right;};
		
		return 0;
	}
	
	}

	
	
