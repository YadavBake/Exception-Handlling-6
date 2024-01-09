
																		Exception Handling Part-1 || Introduction
																	================================================

---------
 Agenda 
----------

 1. Introduction.
 2. Runtime stack mechanisam.
 3. Defualt Exception handling java.  
 4. Exception Hierarchy.
 5. Customized exception handling by using try catch.
 6. Methods to print exception information.
 7. try with multiple catch blocks.
 8. finally block.
 9. difference between final,finally,finalize.
10. control flow in try-catch-finally.
11. control flow in nested try-catch-finally.
12. various possible combinations of try catch finally.
13. throw keyword.
14. throws keyword.
15. Exception Handling keyword summary.
16. various possible compile time errors in exception handling.
17. Customized or user defined exception.
18. Top - 10 exception.
19. 1.7 version enhancements.
	  1. try with resources.
	  2. multi-catch block.
	  
========================================================================================================================================================================================================

																					1. Introduction.
																				-----------------------	

->  An unexpected and unwanted event that disturbs normal flow of the program is called exception.

	Ex. Tyred puchered exception, sleeping exception , FileNotFoundException ect.
	
-> It is highly recomanded to handle exceptions and the main objective of exception handling is gressfull termination of the program.

-> Exception handling doesn't mean repairing and exception we have to provide alternative way to continue rest of the program normally, Is the concept of exception handling.

-> For example out requirement is read data from remote file locating at london at runtime if london file is not available our program should not be terminated ab-normal we have to provide some 
   local file to continue rest of the program normally. These way of defining alternative is nothing but exception handling.

	Ex. 
	
		try {
			
			Read data from remote file 
			locating at london
			
		}catch(FileNotFoundException e ) {
			
			use local file and continue rest of 
			the program normally 
			
		}

 
=======================================================================================================================================================================================================

																						2. Runtime stack mechanisam.
																					----------------------------------

->  For every thread JVM will create a runtime stack.

-> Each and every method call performed by that thread will be stored in the currspoding stack.

-> Each entry in the stack is called stack frame or activation record.

-> After compiliting every method call the currspoding entry from stack will be removed.

-> After compiliting all method call the stack will beceomd empty and that empty stack will be distroyed by JVM just before terminating the Thread.

	Ex. 

	class Test {																										|				| |			   	  | |				| |				  |
														|				|                                               | 				| | doMoreStuff() | | 				| |            	  |
		public static void main(String args[]) {		| doMoreStuff()	|                                               |---------------| |---------------| |---------------| |---------------|
														|---------------|   ----------------------------->              |  doStuff()    |>|   doStuff()   |>|  	doStuff()   |>|               |
			doStuff();									|  doStuff()    |                                               |---------------| |---------------| |---------------| |---------------|
		}												|---------------|                                         |---->|   main()      | |   main  ()    | |    Main()     | |   main      <-|
		public static void doStuff() {					|   main      <-|------- Each Entery in the stack is called     ----------------- ----------------- ----------------- -----------------
														-----------------		Activation record or stack frame         Runtime stack     Runtime stack     Runtime stack     Runtime stack 
			doMoreStuff();								 Runtime stack 
		}													for main 
		public static void doMoreStuff() {					 thread 
			
			System.out.println("Hello");			|				|    |				 | 	  |				  | |			    | |				  | |				|  	|				| 
		}                                           |     	        |    |            	 |    | 			  | | doMoreStuff() | | 			  | |            	|   |     	        | 
		                                            |---------------|    |---------------|    |---------------| |---------------| |---------------| |---------------|   |---------------| 
	} // Hello                                      |               |--> |               | -->|  doStuff()    |>|   doStuff()   |>|  	doStuff() |>|               |-->|               |-
                                                    |---------------|    |---------------|    |---------------| |---------------| |---------------| |---------------|   |---------------| 
                                                    |               |    |   main        |    |   main()      | |   main  ()    | |    Main()     | |   main      <-|   |               | 
                                                    -----------------    -----------------    ----------------- ----------------- ----------------- -----------------   ----------------- 
                                                     Runtime stack 																										 This empty stack 		
													   for main 																										 distroyed by JVM 
														Thread 
																					This is stack Trace mechanisam.



























