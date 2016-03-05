import java.util.Iterator;
import java.util.Scanner;
public class FixQueue<AnyType> {

	static LinkedQueue LQ = new LinkedQueue();//creates a new Queue to  enter postfix values by character
											  //Note, the LQ is static because we want to be able to open/manipulate it in the TreeStack class
	static LinkedStack LS = new LinkedStack();
	
	public void QueueStringChar(AnyType e){		//Queues the string parameter into the queue via characters
		String eString=e.toString();
		for(int i=0; i<eString.length();i++){			//Casts e to a string and Iterates through string, character by character
			char currentCharacter = eString.charAt(i);	//character currentCharacter is character at eString(i)
			LQ.enqueue(currentCharacter);
		}	
	}

	public static void getDequeue(){
		System.out.println(LQ.first());
		LQ.dequeue();
	}

	
	public void ExpressionTreeCreate(){
		
		//creates the expression tree
		while(LQ.isEmpty()==false){	//Loops through the queue until it is empty
		
			//case 1:value is an operand
			if (PostFixDesginer.isOperator((char) LQ.first())==false){//It checks the first element in the queue to check if it is a operand
				BinaryTree T=new BinaryTree(LQ.first());			//creates a new instance of a BinaryTree T which sets the queue's first as the root
				LS.push(T);											//Push the tree object T into the stack
			};	
			
			//case 2: value is an operator
			if(PostFixDesginer.isOperator((char) LQ.first())==true){	// Note: if operator is chosen, it is a fact that 2 operands have been already inserted into the queue
				
				BinaryTree T = new BinaryTree(LQ.first());
				
				BinaryTree rightChild=(BinaryTree) LS.top();			// Puts the tree on top into the variable rightChild of type BinaryTree
				LS.pop();												//pops the value off the stack
				
				BinaryTree leftChild=(BinaryTree) LS.top();
				LS.pop();
				
				T.attach(leftChild,rightChild);
				
				LS.push(T);	//Push the new tree into the stack
			}
		
			LQ.dequeue();													//dequeues the queue to go onto the next queue
		}
	}
	
	public void ExpressionTreeEvaluate(){				//This method evaluates the expression tree.

		LinkedStack BinaryTStack=new LinkedStack();		//Creates a new Stack in order to push elements  in
		
		BinaryTree completeTreeExpression=(BinaryTree) LS.top();	//type BinaryTree completeTreeExpression holds the top of the stack's completed Arithmetic Expression
		
		Iterator myTreeIterator=completeTreeExpression.iterator();
		
		
		while(myTreeIterator.hasNext()==true){//while myTreeIterator iterator has a value, run the whileloop
			
			String iteratorValueHold = myTreeIterator.next().toString();		// created an variable iteratorValueHold because multiple calls to the .next() skips too much

			//Case 1: the iterator value is a numeric value(1,2,3...)
			if(PostFixDesginer.isNumeric(iteratorValueHold)){				// If the value is a positive integer
				if(Integer.parseInt(iteratorValueHold)>0){					// if statement is to check if the value is greater than 0
				
				BinaryTStack.push(Integer.parseInt(iteratorValueHold));		// push the iteratorValue into the stack
				}															//NOTE, it converts from an iterator object to an int before it stores into the new stack
			};
			
			//Case 2: the iterator value is a variable(a,b,c...)
			if(PostFixDesginer.isVariable(iteratorValueHold)){				//If the value is a variable, run this if statement
				System.out.print("Please enter a number value for the variable "+ iteratorValueHold + ":");
				Scanner inputVariable = new Scanner(System.in);
				String FirstInput= inputVariable.nextLine();				//Scans the user input. Throws exception if it is not a integer
				if(!PostFixDesginer.isNumeric(FirstInput))throw new IllegalStateException("This is not an integer!");
				
				
				int VariableInt=Integer.parseInt(FirstInput);		// Converts the string variable number value into an int then push into the stack.
				BinaryTStack.push(VariableInt);	
			}
			
			//Case 3: the iterator value is a operator(+,*,/...)
			if(PostFixDesginer.isOperator(iteratorValueHold.charAt(0))){	// If the value is an operator, do
				
				
				int rightValue=(int)BinaryTStack.pop();				//Pops the top of the stack and is assigned to value rightValue
				int leftValue=(int) BinaryTStack.pop();				//Pops the top of the stack and is assigned to value leftValue
				int EvaluatedValue=PostFixDesginer.operatorReturn(leftValue,rightValue,iteratorValueHold);	// gets the evaluated value in the EvaluatedValue variable
				BinaryTStack.push(EvaluatedValue);					//Pushes the evaluated  ariable.
				}
				
				
				
				
			}
		System.out.print("Your complete arithmetic value is "+BinaryTStack.top());	//After loop is over, prints out the complete arithmetic value
		System.out.println();
		System.out.println();
		}
	
	
	public void ExpressionTree(){	//Method that just combines the two methods to make it easier to use.
		ExpressionTreeCreate();
		ExpressionTreeEvaluate();
	}

}
	


