
																			Exception Handling Part-2 || Default Exception Handling
																		=============================================================	

--------------------------------------
  3. Defualt Exception handling java.
--------------------------------------

 -> Inside a method if any exception occures the method in which it is rise is responsible to an create exception object by including the following information.

		1. Name of Exception.
		
		2. Description of Exception.
		
		3. Location at which Exception occures(Stack Trace).

 -> After creating exception object method handovers that object to the JVM.
 
 -> JVM will check whether the method contains any exception handling code or not if the method doesn't contain exception handler code then JVM terminates that method abnormally and removes the 
	currusponding entry from the stack.
	
 -> Then JVM identifies caller method and checkes whether caller method contains any handling code or not if the caller method doesn't contain handling code then JVM terminates that caller also 
  	abnormally and removes currusponding entry from the stack.
 
 -> This process will be continued until main() method and if the main() method also doesn't contain handling code then JVM terminates main() method also abnormally and removes currusponding entry 
	from the stack.
	
 -> Then JVM handovers responsiblility of exception handling to default exception handler, Which is the part of JVM .

 -> Default exception handler prints exception information in the following formatte and terminates program abnormally.

		Exception in Thread "XXX ": Name of Excetion:description, Stack Trace.



				Ex. 
			
				class Test {
																							
					public static void main(String args[]) {<--								|---------------|
															  |/*This method terminate		| doMoreStuff() | <-- first remove these method entry from runtime stack  by JVM 
						doStuff();							  |	by JVM abnormally */		|---------------|
					}<-----------------------------------------								| doStuff()		|<--- Second remove these method entry from runtime stack  by JVM  		
					public static void doStuff() {<------									|---------------|
														|/*This method terminate			| Main()        |<---- Last remove these method entry from runtime stack  by JVM  
						doMoreStuff();					|	by JVM abnormally */			-----------------
					}<-----------------------------------											
					public static void doMoreStuff() {<--									// After these all process JVM calls default exception handler to throw exception.
														|/*This method terminate 
						System.out.println(10/0);		 |	by JVM abnormally */			/*Exception int thread main :java.lang.ArithmeticException
					} <-----------------------------------									at Test.doMoreStuff(), at Test.doStuff(), at Test.main().*/
				}																			These exception is thrown by default exception handler.
				
			Ex .2 		
  
				
			class Test {															class Test {
				                                                                    	
				public static void main(String args[]){                             	public static void main(String args[]){
					                                                                		doStuff();
					doStuff();                                                      		System.out.println(10/0);
				}                                                                   	}
				public static void doStuff() {                                      	public static void doStuff() {
					                                                                		
					doMoreStuff();                                                  		doMoreStuff();
					System.out.println(10/0);                                       		System.out.println("Hi");
				}                                                                   	}
				public static void doMoreStuff() {                                  	public static void doMoreStuff() {
					                                                                		
					System.out.println("Hello");                                    		System.out.println("Hello");
				}                                                                   	}
			} //abnormal termination                                               }  //abnormal termination
			                                                                        
			Hello                                                                   Hello
			Excetion In thread main: java.lang.ArithmeticException                  Hi 
			at Test.doStuff();                                                      Excetion In thread main: java.lang.ArithmeticException
			at Test.main();                                                         at Test.main();
			
			
	-> In a program at list one method terminates abnormally then the program termination is abnormal termination.
	
	-> If all methods terminated normally then only program termination is normal termination.
	
=========================================================================================================================================================================================================

																				4. Exception Hierarchy.
																			=============================
 -> Throawable class access root for java exception Hierarchy.
 
 -> Throawable class defines two child classes.
 
		1. Exception.
		
		2. Error.
		
 ------------		
  Exception 
 ------------ 
 
  -> Most of the times exception are coused by our program and these are recoverable for example. If our programming requirement is read data from remote file locating at london at runtime if 
	 remote file is not avaiable then we will get runtime exception saying file not found exception.
	 
  -> If FileNotFoundException occures we can provide local file and continue rest of the program normaly.
  
  
		Ex 
		
			try {
				
				/* Read data from remote file 
				 locating at london*/
				 
			}catch(FileNotFoundException e ) {
				
				/*user local file and continue 
				rest of the program normaly*/
			}

----------			
  Error
----------

 -> Most of the times error are not coused by our program and these are due to lack of system resources errors are non-recoverable.

 -> For example If OutOfMemoryError occures beng a programer we can't do anything and the program will be terminated abnormally.

 -> System admin or server admin is responsible to increaces heap memory. 
  
  
	

																				Throawable
																					|
																					|
			----------------------------------------------------------------------------------------------------------------------------------------------
			|																																			 |	
			|																																			 |
		Exception																																	   Error  		
		   |																																			 |		
		   |																																			 | 	
	------------------------------------------------------------------------------------------------------                    ------------------------------------------------------------
	|										|					     |				  |				 |						  |							|				|.....
	|										|						 |				  |	             |						  |							|				|
  RuntimeException					  IOException			ServletException   RemoteException   InterruptedException    VirtualMachineError		AssertionError  ExceptionInInitializerError
   |									|																						 |	
   |->ArithmeticException				|-> EOFException																		 |-> StackOverflowError
   |									|																						 |
   |-> NullPointerExcetion   			|-> FileNotFoundException																 |-> OutOfMemoryError
   |									|
   |-> ClassCastException				|-> InterruptedException 
   |
   |-> IndexOutOfBoundsException
		  |
		  |-> ArrayIndexOutOfBoundsException
		  |
		  |-> StringIndexOutOfBoundsException
 
   |-> IllegalArgumentException		  
   |
   |-> NumberFormatException
	.....































	
			