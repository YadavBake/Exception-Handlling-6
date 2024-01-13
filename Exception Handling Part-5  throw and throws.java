
																			Exception Handling Part-5 || throw and throws
																		===================================================
 
 
------------------------------------ 
 throw keyword or class or statment 
------------------------------------

 -> 
	
	-------								-------		   -------		     		-------		
	|	  |							    |	  | . . .  |	 |                  |	  |
	|     |							.   |     |        |     |                  |     |
	-------						.	    -------        -------                  -------
	   |					  .                                                    |	
	   |	 ------------>  .             Excetion object      <------------       |	
	   ^	 |                                                              |      ^	
	   |	 |                                                              |      |	
	   |------                                                              -------|
	   |   throw                                                            catch  |
	   ^                                                                           ^
	   |                                                                           |
	Programmer 																	  JVM    
	
	
 -> Sometimes we can create exception object explicitly we can handover to the JVM manually for these we have use throw keyword.

				
			throw   			new ArithmeticException("/by Zero");		
			-----  				------------------------------------		
			  |									|		
        Handover our created    creation of ArithmeticException 
		exception object to 	object explicitly.		
	    the JVM manually.
	
	- Hence the main object of throw keyword is to handover our created exception object to the JVM manually.
	
	- Hence the result of following two programm is excatly same. 
	
	
	Ex. 
	
	class Test{																		  class Test {
		                                                                            	  
		public static void main(String args[]) {                                    	  public static void main(String args[]) {
			                                                                        		  
			System.out.println(10/0);                                               		throw   			new ArithmeticException("/by Zero");
			                                                                        		-----  				------------------------------------
		}                                                                           		  |									|
	} //CE: Exception in thread main: java.lang.ArithmeticException                 	Handover our created    creation of ArithmeticException 
	  //  : / by Zero at Test. main().                                              	exception object to 	object explicitly.
	                                                                                	the JVM manually.
                                                                                    	
																							}
	                                                                                  }//CE: Exception in thread main: java.lang.ArithmeticException       
	                                                                                   //  : / by Zero at Test. main().                                    
  
  In these Case main() method is responsible to create excetion							In these Case programmer is responsible or creating exception 							
  object and handover to the JVM                                                        object explicitly and handover to the JVM manually
		
  
Note:- Best use of throw keyword is for user-defines exception or customized exception.



Case 1: 

	-> throw e ; -> If 'e' referes null then we will get NullPointerException.
	
		Ex. 
	
		class Test {															class Test {
			                                                                    	
			static ArithmeticException e = new ArithmeticException();           	static ArithmeticException e ;
			                                                                    	
			public static void main(String args[]) {                            	public static void main(String args[]) {
				                                                                		
				throw e ;                                                       		throw e;
			}                                                                   	}
		}//RE: ArithmeticException                                              } //RE: NullPointerException
		

 Case 2: 

	-> After throw statement we are not allowed to write any statement directly otherwise we will get compile time error saying unreachable statement.
	
		class Test{																class Test {
			                                                                    	
			public static void main(String args[]) {                            	public static void main(String args[]) {
				                                                                		
				System.out.println(10/0);                                       		throw new ArithmeticException("/ be Zero");
				System.out.println("Hello");                                    		
			}                                                                   		System.out.println("Hello");
		} //RE: ArithmeticException:/by Zero                                    	}
		                                                                        } //CE: unreachable statment. System.out.println("Hello");
		
		
 Case 3: 

	-> We can use throw keyword only for throwable types if we are trying to use for normal java objects we will get compile time error saying incompatible types.
		
	class Test {													class Test extends RuntimeException {
                                                                    	
		public static void main(String args[]) {                    	public static void main(String args[]) {
			                                                        		
			throw new Test();                                       		throw new Test ();
		}                                                           		
	} //CE: incompatible types found:Test                           	}
	 // required java.lang.Throwable                                } RE: Exception in thread "main" Test at Test.main()
	
	
	
	
	
	
	
	
	
		 	
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	






































  
  
  
 

	
	
	
	
	
	