
public class IFtoPF {
	String inputString;
	
	public IFtoPF(){}
	ArrayStack SObject=new ArrayStack();
	PostFixDesginer design = new PostFixDesginer();
	String PostFixString;

	public String getPostFixString(){
		return PostFixString;
	}
	
	//Changed from void to string and this method returns a string
	public String PostFixConverter(String s){		// Note to self: Code must be inside a method if it is in another class or it won't work
		inputString=s;
		String outputString="";
		int parenCount=0;
		
		// Starting the loop to turn a string InFix expression into a PostFix expression.
		for(int i=0; i<inputString.length();i++){			//Iterates through string character by character
			char currentCharacter = inputString.charAt(i);	//character currentCharacter is character at inputString(i)
		
			//case 1: if the character is not an operator nor a parenthesis
			if(!design.isOperator(currentCharacter)&&(!design.parenthesisCheck(currentCharacter))){outputString += Character.toString(currentCharacter);} 	//If the character is not an operator and not a parenthesis, the currentCharacter is added  to output string.
			
			
			
			//case 2: if stack is empty and currentCharacter is an operator put it in the stack
			if(design.isOperator(currentCharacter)&&(SObject.isEmpty())){	//If the stack is empty and we have an operator, just insert it
				SObject.push(currentCharacter);
			}
			
			
			
			//case 3: if currentCharacter is an operator and there are no parenthesis
			else if(design.isOperator(currentCharacter)&&(parenCount==0)){															//if the currentCharacter is a operator
				if((design.operatorPrec(currentCharacter))>(design.operatorPrec((Character) SObject.top()))){	//check if the operator precedence is higher than the operation on the "top" (Character is to cast AnyType into a char type)
				SObject.push(currentCharacter);																	//if it is, push a new value
				}
				else if((design.operatorPrec(currentCharacter))==(design.operatorPrec((Character) SObject.top()))){	//if the currentCharacter has equal precedence to the top one
					outputString+= SObject.pop();																	//pop the current top and add the currentCharacter to the stack
					SObject.push(currentCharacter);	
				}
				else if((design.operatorPrec(currentCharacter))<(design.operatorPrec((Character) SObject.top()))){	//if the currentCharacter has a lower precedence than the top stack operator
					while (SObject.isEmpty()==false){																//print out all the operators in the stack
					outputString+= SObject.pop();
					}
				SObject.push(currentCharacter);																		//insert the new operator once all of the operators have been removed.
				}
			}
			
			
			
			
			//case 4: if there is a parenthesis, or there exists a parenthesis, if the currentCharacter is '(' push it on the stack
			// parenCount tells us  whether a parenthesis exists.
			// If a parenthesis exists, ignore cases 1 2 3 and use this loop
			if((design.parenthesisCheck(currentCharacter))||(parenCount>=1)){		//parenCount is to see if there exists a parenthesis in the stack
				if(currentCharacter=='('){
					SObject.push(currentCharacter);
					parenCount++;
				}
				
				else if(design.isOperator(currentCharacter)){															//if the currentCharacter is a operator
					if((design.operatorPrec(currentCharacter))>(design.operatorPrec((Character) SObject.top()))){	//check if the operator precedence is higher than the operation on the "top" (Character is to cast AnyType into a char type)
					SObject.push(currentCharacter);																	//if it is, push a new value
					}
					
					else if((design.operatorPrec(currentCharacter))==(design.operatorPrec((Character) SObject.top()))){	//if the currentCharacter has equal precedence to the top one
						outputString+= SObject.pop();																	//pop the current top and add the currentCharacter to the stack
						SObject.push(currentCharacter);	
					}
					else if((design.operatorPrec(currentCharacter))<(design.operatorPrec((Character) SObject.top()))){  // if the currentCharacter has a higher or equal operator precedence, then print out stack up to until we hit the ( parenthesis
						while( (Character) SObject.top()!='('){
						outputString+= SObject.pop();
						}
						parenCount--;
						SObject.push(currentCharacter);	
					}
				}
				if(currentCharacter==')'){				// If the currentCharacter is ) then pop the remaining stack up to the left parenthesis
					while( (Character) SObject.top()!='('){
					outputString+= SObject.pop();
					}		
					SObject.pop();						// Pop's the parenthesis out after you iterate to the left parenthesis.
					parenCount=0;						//Decrement parenCount so that we know the parenthesis is gone.
				}
			}
		

		
		}
		
		while (SObject.isEmpty()==false){			// This while statement removes the remaining operators in the stack.
		outputString+= SObject.pop();
		}
		
		
		PostFixString=outputString;
		System.out.println(outputString);
		return PostFixString;
	}
}	
		
		