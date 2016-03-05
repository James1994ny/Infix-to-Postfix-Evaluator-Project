public class ArrayStack<AnyType> implements Stack<AnyType>
{
public static final int DEFAULT_CAPACITY = 1024;
AnyType[] stack;
int topOfStack;	//points to the top value of the stack.
int arraySize=0;//Counts the number of elements in the array.
public ArrayStack() { this(DEFAULT_CAPACITY); }
 

public ArrayStack(int capacity)	// The array capacity is 1024 with topOfStack =-1
 {
 topOfStack = -1;
 stack = (AnyType[]) new Object[capacity];
 }

 
 public int size(){
 	 return arraySize;
 }

 public boolean isEmpty(){
	 if (arraySize==0){ return true;}
	 else return false;
 }
 public void push(AnyType e) throws IllegalStateException{
	 if (arraySize>=1024){
		 throw new IllegalStateException("Array size is over the 1024 capacity!");}		//Throws exception if array size is over 1024
	 
	 arraySize++;
	 topOfStack=topOfStack+1;
	 stack[topOfStack]=e;
 }
 
 public AnyType top()throws IllegalStateException{
	 if (arraySize<=0){					
		 throw new IllegalStateException("Array size is less than or equal to 0. There is no value.");}
	 return stack[topOfStack];
 }
 
 public AnyType pop()throws IllegalStateException{
	 if (arraySize<=0){
		 throw new IllegalStateException("Array size is less than 0!");}
	 
	 AnyType myTopHold=stack[topOfStack]; //Holds the top value before deleting it so you can return it.
	 arraySize--;	// Decrements the size counter.
	 topOfStack--;	// Makes it so the pointer is set to the one below the the top.
	return myTopHold;	// returns value that was on top before it was popped.
 }
}
