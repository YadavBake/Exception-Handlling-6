
																  Exception Handling Part-3B|| Customized Exception Haning by try-catch
																=========================================================================

--------------------------------------------------------
 5. Customized exception handling by using try catch.
--------------------------------------------------------- 
 
-> It is highly recomanded to handle exception the code which may rise an exception is called risky code and we have to define that code inside try block and currusponding handling code we have 
   to define inside catch block.

	Ex. 
	
	try {
    	
    	Risky code 
    	
    }
    catch(Exception e ) {
    	
    	Handling code 
    	
    }
																						With try-catch															
  Without try-catch                                                 				   ----------------                                                        
 -------------------                                                                                                                        
                                                                    	class Test {                                                        
	class Test {																                                                            
		                                                            		public static void main (String args[]) {                       
		public static void main(String args[]) {                    			                                                            
			                                                        			System.out.println("Stmt-1");                               
			System.out.println("Stmt-1");                           			                                                            
			                                                        			try {                                                       
			System.out.println(10/0);                               				    
			                                                        				System.out.println(10/0);    
			System.out.println("stmt-2");                           			}catch(ArithmeticException e) {    
		}                                                           				    
	} o/p:                                                          				System.out.println(10/2);    
	                                                                			}    
		Stmt-1                                                      			System.out.println("Stmt-3");    
		RE:ArithmeticException:/by Zero                             		}    
		Abnormal termination                                        	} o/p:    
		                                                            	    
		                                                            	Stmt-1    
		                                                            	5    
                                                                    	Stmt-3    
  
 --------------------------- 
  Control flow in try-catch
 ---------------------------
	
	try {
		
			stmt -1 ;								
			stmt -2 ;						
			stmt -3 ;
	}catch(x e ) {
		
		stmt-4;
	}
	stmt-5;
	
	
 Case 1:  If there is no exception 
	
		1,2,3,5 normal Termination.
		
		
 Case 2:  If exception rised at stmt-2 and currusponding catch block matched.
 
		- 1,4,5 normal termination. 
 
 Case 3: If an exception rised at stmt-2 and currusponding catch not block matched.	
	
			1, abnoraml termination.

 Case 4: If an exception rised at stmt-4 or stmt-5 then it is always abnoraml termination.
 

 Note: 
 
	- Within the try block if any where an exception rised then rest of the try block won't be executed even though we handle that exception hance a within the try block we have take only risky code 
	  and length of try block should be as less as possible.
	  
	- In addition to try block there may be chance of rising an exception inside catch and finally blocks.
	
	- If any statement which is not part of try block and rises an exception then it is always abnoraml termination.
	
==========================================================================================================================================================================================================	
	
																						6. Methods to Print exception information 
																					===============================================
 
 ->  Throwable class defines the following methods to print exception information. 
 
			---------------------------------------------------------------------------------
        	|	Method 					  |		Printable format							|
        	------------------------------|-------------------------------------------------|	
        	|		                      |                                                 |
        	|	1. PrintStackTrace() 	  |	Name of Exception: Description and Stack Trace. |
            |	                          |                                                 |
        	|	2. toString()			  |	Name of Exception: Description.                 |
        	|	                          |                                                 |
        	|	3. getMessage()			  |    Description                                  |
			|	                          |                                                 |
			---------------------------------------------------------------------------------
			

		class Test {
																						-------------------------------------------
			public static void main(String args[]) {									|java.lang.ArithmeticException : / by zero |			
																		   |----------> |	at Test main()						   |													
				try {													   |			--------------------------------------------											
																		   |	
					System.out.println(10/0);							   |			-------------------------------------------
				}                                                          |            |java.lang.ArithmeticException : / by zero |
				catch(ArithmeticException e) {                             |     |----->|										   |
					                             o/p                       |     |       --------------------------------------------
					e.printStackTrace();-----------------------------------	 0/p |								
					System.out.println(e); or System.out.println(e.toString);----		-------------------------------------------
					System.out.println(e.getMessage(); ------------------------------>  |				 / by zero				   |
				}                                                o/p                    |										   |
			}                                                                           --------------------------------------------
			
 
  Note: Enternaly default exception handler will use printStackTrace() method to print Exception information to the console.

===========================================================================================================================================================================================================

																					7. try with multiple catch blocks.
																				========================================


  -> The way of handling an exception is different from exception to exception hence a for every exception type it is highly recomanded to take separet catch block that is try with multiple catch 
	 blocks is always possible and recomanded to use.


		try {													try {
			                                                    	
			Risky code                                          	Risky code 
		}                                                       }
		catch(ArithmeticException e ) {                         
			                                                    catch (Exception e ) {
			Perform altenative arithmentic                      	
			operation.                                          }//wrost programming practice
		}
		catch (SQLException e ) {
			
			use Mysql db instead of 
			oracle db.
		}
		catch(FileNotFoundException e) {
			
			use local file instead of 
			remote file .
		}
		catch (Exception e ) {
			
			 default exception handling.
		}// It Best programming practice.
		
		
  LoopHole:1 
  
	- If try with multiple catch blocks prasent then the order of catch blocks is very important we have to take child first and then parent exception otherwise we will get compile time error saying 
	  Exception XXX has already been cought .

	try {												try {	
		                                                	
		risky code                                      	risky code 
	}catch(Exception e){                                }catch(ArithmeticException e){
		                                                		
	}                                                   }	
	catch(ArithmeticException e) {                      catch(Exception e) {	
		                                                		
	}                                                   }	
	                                                    	
	// invalid 											valid                                                     	
	//CE java.lang.ArithmeticException has 
	// already been cought.
    
 
  LoopHole:2 

	- we can't declare two catch block for the same exception otherwise we will get compile time error. 

	try {
		
		risky code 
	}
	catch(ArithmeticException e ) {
		
	}
	catch(ArithmeticException e) {
		
	} //invalid 
	//CE: Exception java.lang.ArithmeticException has been cought.
	
	
	
	
	
	
	
		



































 
	
	
	
	
	
	


































 

































 



	
	
	
	
	
	
	
	
	
	
















	
	