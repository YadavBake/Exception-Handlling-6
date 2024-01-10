
																		Exception Handling Part-3A || Checked vs Unchecked Exceptions
																	====================================================================

-----------------------------------
  Checked vs Unchecked Exceptions 
-----------------------------------

 -> The exceptions which are checked by compiler for smooth execution of the program are called checked exceptions.
 
		Ex. HallTicketMissingException, PainNotWorkingException, FileNotFoundException etc. 

 -> In our program if there is chence of rising checked exception then compulsory we should handle that checked exception (Either by try-catch or throws keyword) otherwise we will get compile time 
	error .		
	
	Ex. 
    
	import java.io.*;												import java.io.*;  										import java.io.*;  
	class Test {                                                         class Test {                                        class Test {
		                                                                 	                                                      	
		public static void main(String args[]) {                         	public static void main(String args[])  {           public static void main(String args[]) throws FileNotFoundException {
			                                                             		try {                                             		
			PrintWriter pw = new PrintWriter('abc.txt');                 		PrintWriter pw = new PrintWriter('abc.txt');      		PrintWriter pw = new PrintWriter('abc.txt');
			pw.println("Hello");                                         		pw.println("Hello");                              		pw.println("Hello");
		}                                                                	}catch(FileNotFoundException e ){}                            		
	} //CE: unreported Exception java.io.FileNotFoundException         			}                                           				}
	  // must be cought or declared to be thrown.                      }                                                         } 
	  
	
 -> The exceptions whic are not checked by compiler whether programmer handling or not such type of excetions are called unchecked exceptions.

	Ex. ArithmeticException, BomBlastException, NullPointerException etc.
	
	import java.io.*;  
	  class Test {  
	  	  	
      	public static void main(String args[]) throws FileNotFoundException {    
      		    
      		PrintWriter pw = new PrintWriter('abc.txt');    
      		pw.println("Hello");    
    		System.out.println(10/0);			
    	}    
	} //RE: java.lang.ArithmeticException: / By zero 	
		
      
 Note: 

	1. Whether it is checked or unchecked every exceptions ocurres at runtime only there is no chance of ocurring any exception at compile time.
	
	2. RuntimeException and its child classes, Error and its child classes are unchecked Except these remaining are checked Excetion.

 ----------------------------------------------
  Fully Checked vs Parsially Checked Exception 
 ---------------------------------------------- 

  -> A checked exception is said to be fully checked if and only if all its child classes also checked.

		Ex. IOException, InterruptedException, ServletExction...
		
 -> A checked exception is said to be parsially checked if and only if some of its child classes are unchecked.
 
		Ex. Excetion, Throwable.
		
  Note: The only possible parsially checked exceptions in java are First one Exception and Second Throwable.
  
  Q ) Describe the behaviour of following exceptions ?
  
	1. IOException. // checked(fullyChecked Exception).	
	2. RuntimeException. // Unchecked.
	3. InterruptedException.//checked(fullyChecked Exception).
	4. Error.// unchecked
	5. Throwable.//checked(Partially checked excetion).
	6. ArithmeticException.// unchecked.
	7. NullPointerException.//unchecked.
	8. Exception. //checked(Partially Checked Exception).
	9. FileNotFoundException. // checked (Fully Checked exception).


 																				Throawable
 																					|
 																					|
 			----------------------------------------------------------------------------------------------------------------------------------------------
 			|																																			 |	
 			|																											--------------------------------------------------------------------------
 		Exception(Parsially checked Exception )																			|							   Error  								     |
 		   |																											|								 |		                                 |
 		   |																											|								 | 	                                     |
 	------------------------------------------------------------------------------------------------------              |     ------------------------------------------------------------       |
 	|										|					     |				  |				 |					|	  |							|				|.....                   |
 ---------------------------------			|						 |				  |	             |					|	  |							|				|                        |
 |  RuntimeException			|	  IOException			ServletException   RemoteException   InterruptedException   | VirtualMachineError		AssertionError  ExceptionInInitializerError  |
 |   |							|		|																				|		 |	                                                             |
 |   |->ArithmeticException		|		|-> EOFException																|		 |-> StackOverflowError                                          |
 |   |							|		|																				|		 |                                                               |
 |   |-> NullPointerExcetion   	|		|-> FileNotFoundException														|		 |-> OutOfMemoryError                                            |
 |   |							|		|																				--------------------------------------------------------------------------	
 |   |-> ClassCastException		|		|-> InterruptedException 														// Error and it child classes are unchecked exceptions
 |   |							------- 
 |   |-> IndexOutOfBoundsException    |				// And except is checked exceptions.
 |		  |							 ----------			
 |		  |-> ArrayIndexOutOfBoundsException   |
 |		  |                                    |
 |		  |-> StringIndexOutOfBoundsException  |
 |                                             |
 |   |-> IllegalArgumentException		       |
 |   |                                         |
 |   |-> NumberFormatException                 |
 |	.....                                      |
 ------------------------------------------------
  // RuntimeException and its child classes are 
  // unchecked exception.