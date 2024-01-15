
															Exception Handling Part-9 || try with resources and multi-catch block
														==========================================================================
	
 
 --------------------------------
   7. IllegalArgumentException 
 --------------------------------
  
  -> It is the child class of RuntimeException and hence it is unchecked.

  -> Rised explicitly either by programmer or by API developer to Indicate that a method has been invoked with IllegalArgumentException.  
  
  -> The valid range of Thread priority is 1 to 10 if we are trying to set the priority with any other value then we will get RuntimeException saying IllegalArgumentException.
  
		Ex. 
  
		Thread t = new Thread();
		t.setPriority(7);
		t.setPriority(15);// RE: IllegalArgumentException
 
 
 ----------------------------- 
	8. NumberFormatException
 -----------------------------

	-> It is the direct child class of IllegalArgumentException which is the child class of RuntimeException and hence it is unchecked.

    -> Rised explicitly either by programmer or by API developer to indicate that we are trying to convert String to Number and the string is not properly formated.

		Ex. 
	
	
		int i = Integer.parseInt("10"); //valid 
		int i = Integer.parseInt("ten");// RE: NumberFormatException.
		
			RuntimeException	  	
			   |
			   |-->IllegalArgumentException
					  |
					  |--> NumberFormatException
					  
  -----------------------------------					  
	9. IllegalStateException 	
  -----------------------------------
	
	-> It is the child class RuntimException and hence it is unchecked.
	
	-> Rised explicitly either by programmer or by API developer to indicate that a method has been invoked at wrong time.
	
	-> After starting of a thread we are not allowed to restart the  same thread once again otherwise we will get runtime exception saying IllegalThreadStateException. 
	
		Ex. 
		
			Thread t = new Thread();
			t.start();
			.
			.
			.
			t.start();// RE: IllegalThreadStateException
			
  -----------------------  
	10. AssertionError	
  -----------------------

	-> It is the child class of Error and hence it is unchecked.
	
	-> Rised exception either by programmer or by API developer to indicate that assert statement fails.
	
	
		Ex
		
			assert(x>10); //RE: AssertionError
	
		- If 'x' is not gretter then 10 then we will get RuntimeException saying AssertionError.	
			
			
			
	------------------------------------------------------------------------------------------
	|	Exception | Error 								Raised by 							 |
	|----------------------------------------------------------------------------------------|
	|1. ArrayIndexOutOfBoundsException<-----					                             |
	|									  |					                                 |
	|2. NullPointerException			  |			                                         |
	|									  |			                                         |
	|3. ClassCastException				  | ==>    Raised automacatically by JVM hence       |
	|									  |	       these are JVM exceptions                  |
	|4. StackOverflowError				  |                                                  |
	|									  |	                                                 |
	|5. NoClassDefFoundError			  |	                                                 |
	|									  |	                                                 |
	|6. ExceptionInInitializerError<--------	                                             |
	|                                                                                        |
	|7. IllegalArgumentException<----------                                                  |
	|									  |	                                                 |
	|8. NumberFormatException             |                                                  |
	|                                     |=====>	Raised explicitly either by Programmer or|
	|9. IllegalStateException             |			By API develope and hence these are      |
	|                                     |			programetic Exception.                   |
    |10. AssertionError<--------------------	                                             |
    ------------------------------------------------------------------------------------------	
			
======================================================================================================================================================================================

																	19. 1.7 version enhancements.
																===================================			
																			
 -> As the part of 1.7v version in exception handling the following two concepts introduced.  						
						
	  1. try with resources.
	  
	  2. multi-catch block.			
			
  -----------------------		
    try with resources	
  -----------------------	
	
  ->  Until 1.6v version it is highlly recomanded to write finally block to close resource which are open as part of try block.

		until 1.6v version 

		BufferReader br = null;													
		                                                                        
		try {                                                                   
			                                                                    
			br = new BufferReader(new FileReader("input.txt");                  
			// use br based on our requirement.                                 
			                                                                    
		}catch (IOException e ) {                                               
			                                                                    
			// handling code                                                    
		}                                                                       
		finally {                                                               
			
			if(br !=null){
				
				br.close();
			}
		}
	
	    - The problems in the these approach are compulsory programmer is required to close the resources inside finally block. It increases complexity of programming.
	
	    - We have to write finally block compulsory and hence it increase length of the code and reduces readability.
			
		- To overcome above problems sun poeple introduced try with resources in 1.7v version.
		
		- The main advantage of try with resources is whatever resources we open as the part of try block will be closed automatically once controll reaches and of try block either 
		  normaly or abnormaly and hence  a we are required to close explicitly so that complexity of programming will be reduced.
		  
		- We are not required to write finally block so that length of the code reduced and readability will be imporoved.
		
			Ex.
		
			try (BufferReader br new BufferReader (new FileReader("input.txt")));
	        													   -----------	
		    															|---> resource
		    {
		    	// Use BufferReader based on our requirement.
		    	// BufferReader will be closed automacatically once controll reaches end of try block 
		    	//Either normally or abnormally and we are not responisible to close explicitly.
		    }
		    catch (IOException e) {
		    	
		    	//handling code
		    	}
		
  --------------		
	Conclusion 	
  --------------

	1. We can declare multiple resources but these resources should be separated with semicolene.

			Syntax 
			
				try ( R1, R2, R3 ) {
					
				}
				
				Ex.
				
					try (FileWriter fw = new FileWriter("Output.txt");FileReader fr = new FileReader("input.txt")) 
													   -------------								 -----------	
															R1 											 R2 
					{
					
					}
	
	2.
	
			-> ALl resources should be AutoCloseable resources.
   
			-> A resource said to be AutoCloseable if and only if corresponding class implements java.lang.AutoCloseable interface.
   
			-> All IO related resources,data base resources and Network related resources are already implmented AutoCloseable interface.
   
			-> Beaing a programmer we are not required to do anything just we should aware the point.
   
			-> AutoCloseable interface came in 1.7v version and it containes only one method close().
   
						public void close(){}
			
	
	3. 
	
		-> All Resource reference variables are implicitly final and hence withint the try block we can't perform re-assingment otherwise we will get compile time error.

		
		
		import java.io.*;
		class TryWithResources {
			public static void main(String args[])  throws Exception {
					
					try { BufferReader br = new BufferedReader(new FileReader("input.txt")))
						{
							br = new BufferedReader (new FileReader("outPut.txt"));
						}
					}
			} //CE: auto-closeable resource br may no be assigned.
	
		-> Until 1.6v version try should be associated with either catch or finally but from 1.7v version onwords we can take only try with sources without catch or finally.
		
			try (R){
				
				
			}
			
	-> The main advantage of try-with-reources is we are not required to write finally block excplicitly because we are not required to close resource explicitly hence a until 1.6v version 
		finally block is just like hero but from 1.7v version onwords it is a dummy and becomes zero.
	
	
	
    -----------------------------
	   multi-catch block.			
	----------------------------
	
	  -> Until 1.6v version even though multiple different exceptions having same handling code for every exceptions type we have to write separate catch block it increases length of the code and 
		 reduces readability.
	  
	  
		try {
			
		}
		catch(ArithmeticException e) {
			
			e.printStackTrace();
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			
			System.out.println(e.getMessage());
		}
		catch(InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	 -> To overcome these problems sun people introduced multiple catch block in 1.7v version.
	 
	 -> According to these we can write a single catch block that can handle multiple different type of excetions.
		
			try {
				
				
			}
			catch(ArithmeticException  | IOException e) {

					e.printStackTrace();
			}
			catch(NullPointerException | InterruptedException e) {
				
				System.out.println(e.getMessage());
			}
			
	-> The main advantage of these approach is length of the code will be reduced and readability will be improved.
	
	
	
			import java.io.*;
			class MultiCatchBlock {
				
				public static void main(String args[]) {
					
					try  {
						
						System.out.println(10/0);
						String s = null;
						System.out.println(s.length());
					}
					catch(ArithmeticException | NullPointerException  e ) {
						
						System.out.println(e);
					}
				}
			}
	 
	  - In the above example whether riased exception is either ArithmeticException or NullPointerException the same catch block can listion.
	  
	  - In multi-catch block there should not be any relation between exceptions (Either child to parent or parent to child or same type) otherwise we will get compile time error.
	  
	  
			Ex.
			
				try {
					
				}
				catch (ArithmeticException | Exception e ){
					
					e.printStackTrace();
				}
				//CE: Alternative in a  multi-catch statement cannot be related by subclassing.
				
				
----------------------
 Exception Propgation 
----------------------

	-> Inside a method if an exception riased and if we are not handling that exception then exception object will be propgated to caller then caller method is responsible to handle exception these 
		process is called exception propgation.
		
--------------------------
  Re-throweing Exception 
--------------------------

	-> We can use these approach to convert one exception type to another exception type .
	
		Ex.
	
		try {
			
			 System.out.println(10/0);
		}
		catch (ArithmeticException e){
			
			throw new NullPointerException ();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
	
































	
			
			
			
			
			
			
			
			
	
	
  