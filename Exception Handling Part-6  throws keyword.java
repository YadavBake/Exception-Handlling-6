
																			Exception Handling Part-6 || throws keyword
																		==================================================


-------------------
  throws keyword
-------------------

	-> In our program if there is possibility of rising checked exception then compulsory we should handle that checked exception otherwise we will get compile time error saying unreported exception
	 xxx must be cought or declared to be thrown.

	Ex. 

	import java.io.*;
	class Test {																		class Test {
		                                                                                
		public static void main(String args[]) {                                           public static void main(String args[]) {
			                                                                            
			PrintWriter pw = new PrintWriter("abc.txt");                                		Thread.sleep(10000);
			pw.println("Hello");                                                           }
			                                                                            } //CE: unreported exception java.lang.InterruptedException 
		}                                                                                 // must be cought or declared to be thrown.
	} //CE: unreported exception java.io.FileNotFoundException;
	  // must be cought or declared to be thrown
	  // PrintWriter pw = new PrintWriter("abc.txt");
	  
	 
  -> We can handle these compile time error by using the following two ways: 
  
  

		1. By using try-catch :											2. By using throws keyword : 
		                                                                
			                                                            	- We can use throws keyword to delegate responsibility of exception handling to the caller then (it may be another 
			class Test {                                                	  method or JVM ) then caller method is responsible to handle that exception.
	                                                                    	
               public static void main(String args[]) {                 	class Test {
					try {                                                   
            		Thread.sleep(10000);                                       public static void main(String args[]) throws InterruptedException {
               }catch(InterruptedException e ) {                            
				                                                            		Thread.sleep(10000);
			   }                                                               }
			}                                                               } 
        } 
		
-> throws keyword required only for checked exceptions and uses of throws keyword for unchecked exceptions there is no use or there is impect.

-> throws keyword required only to convence compiler and uses of throws keyword doesn't prevent ubnormal termination of the programm.



	class Test {
		
		public static void main(String args[]) throws InterruptedException {
			
			doStuff();//CE: unreported exception java.lang.InterruptedException  must be cought to declare to be thrown.
			
		}
		
		public static void doStuff() throws InterruptedException {
			
			doMoreStuff();//CE: unreported exception java.lang.InterruptedException  must be cought to declare to be thrown.
			
		}
		
		public static void doMoreStuff() throws InterruptedException{
			
			
			Thread.sleep(10000); //CE: unreported exception java.lang.InterruptedException  must be cought to declare to be thrown.
		}
	}// abnormal termination.
	 
	- In the above program if we removed at list one throws statement then the code won't compile. 
	 
	

		------------
		|		   | -> 1. We can use to delegate responsibility of exception to the caller (It may be method or JVM )	
		|  throws  | -> 2. It is required only for checked exceptions a usage of throws keyword for unchecked exception there is no impect.
		|	clause | -> 3. It is required only to convience compiler and usage of throws doesn't prevent abnormal termination of program
		------------
		
Note:- It is recomanded to use try-catch over throws keyword.	
		

Case 1: We can use throws keyword for methods and constructors but not for classes .


	class Test throws Exception { //invalid 
		
		Test()  throws Exception {
			
		}
		
		public void m1()  throws Exception {
			
		}
	}


Case 2: We can use throws keyword only for Throwable types if we are trying to use for normal java classes then we will get compile time error saying incompatible types.

	
		class Test {																	class Test extends RuntimeException{
			                                                                            	
			                                                                            	public void m1() throws Test {
			public void m1() throws Test { // invalid                                   
				                                                                        	}
			}                                                                           	
			                                                                            } //valid 
		} //CE: incompatible type found: Test required: java.lang.Throwable


		
Case 3: 

	
		class Test {																							class Test {
			                                                                                                    	
			public static void main (String args[]) {                                                           	public static void main(String args[]) {
				                                                                                                		
				throw new Exception();                                                                          		throw new Error();
				             |---//It is checked Exception                                                                          |---------It is unchecked Exception           		
			}                                                                                                   	}
			                                                                                                    	
		} //CE: unreported Exception java.lang.Exception must be cought or declare to be thrown,                } //RE: Exception in thread "main" java.lang.Error at Test.main()
		
		
		
  Case 4: 

	- within the try block if there is no chance of rising an exception then we can't write catch block for that exception otherwise we will get compile time error saying Exception xxx is never thrwon 
	  in body of corresponding try statement but these rule is applicable only for fully checked exceptions.
	  
	  
	
		class Test {											class Test {											import java.io.*;								
			                                                    	                                                    class Test {
			public static void main(String args[]) {            	public static void main(String args[]) {            	
				                                                		                                                	public static void main(String ars[]) {
				try {                                           		try {                                           		
					                                            			                                            		try {
					System.out.println("Hello");                			System.out.println("Hello");                			
					                                            		}catch(Excetion e) {                            			System.out.println("Hello");
				}catch(ArithmeticException e) {                 			       |-Partially Checked Exception                     }catch(IOException e ){
					      |-unchecked Exception                   		}                                               					|--Fully Checked exception
				}                                               	}                                                   		}
			}                                                   }                                                       	}
		}                                                                                                               } //CE: Exception jav.io.IOException is never thrown in body of curresponding 
																														  // try statement.
		//valid o/p Hello 											valid  o/p  Hello 											

				class Test {														class Test {
            	                                                                	
            	public static void main(String args[]) {                        	public static void main(String args[]) {
            		                                                            		
            		try {                                                       		try {
            			                                                        			
            			System.out.println("InterruptedException e ) {          			System.out.println("Hello");
            				                  //-Fully checked Exception                   }catch (Error e ) {
            			}                                                       					//-unchecked exception.
            		}                                                           		}
            		                                                            	}
            	}                                                               }
			   //CE: exception java.lang.InterruptedException is never 
			   // thrown in body of corresponding try statement.
			
		
		
		
		
		
		
		
		
		
		
		
		
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

































		
		
		
		
		
		
		
		
		