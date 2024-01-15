
																			Exception Handling Part-7 || Customized Exceptions
																		=========================================================	

------------------------------------------------------
  Exception Handling Keywords responsibility Summary 
------------------------------------------------------

 1. try---->      To maintain Risky code.

 2. catch---->    To maintain exception handling code.

 3. finally ----> To main clean-up code.

 4. throw ---->   To hand-over our created exception object to the JVM Manually.

 5. throws ---->  To delegate responsibility of exception handling to the caller. 
 
 
 ------------------------------------------------------------
  Various possible compile time errors in exception handling 
 ------------------------------------------------------------

  1. Unreported exception XXX; must be caought or declare to be thrown.

  2. Excetion XXX had already beed caought.
	
  3. Exception XXX is never thrown in body of corresponding try statement.
  
  4. unreachable statement.
  
  5. incompatible type found: Test required: java.lang.Throwable.
  
  6. try without catch or finally.
  
  7. catch without try.
  
  8. finally without try.
  
  
  ----------------------------------------
	Customized Or user define Exceptions 
  ----------------------------------------

  -> Sometimes to meet programming requirements we can define our own exceptions such type of exception are called customized or user define exceptions.


		Ex. ToYoungException, ToOldException,InSufficientFundsExceptions etc.
		
		
 -> 


		class ToYoungException extends RuntimeException  {<----							class Test {
															  |	                        	
															  |								public static void main(String args[]) {					  
			ToYoungException( String s ){					  | 														  	
															  |									int age = Integer.parseInt(args[0]);						  
					super(s);								  |									if(age>60){						  
			}												  |																  
		}													  |										throw new ToYoungException ("Please wait some more time definitly you will get best match");						  
															  |//Defining Customized Excetion 	} 
                                                              |                         		else if(age<18){
		class ToOldException extends RuntimeException {       |                         			
			                                                  |	                        			throw new ToOldException("You age already crossed marrage age and no chance of getting marrage");
			ToOldException(String s) {                        |	                        		}
				                                              |	                        		else {
				super(s);                                     |	                        			
			}												  |	                        			System.out.println("you will get matche details soon by email");
		}<-----------------------------------------------------                         		}
		                                                                                	}
                                                                                        }
  
	
	
   Note:

	1. throw keyword is best suitable for user define or customized exceptions but not for pre-define exceptions.
	
	
	2. It is highlly recomanded to define customized exception as unchecked that is we have to extends RuntimeException but not Exception.


	3. why  we can use super(s) in every customized excetion handling  because to make description available to default Exception handler.
	
							Throwable 
							   ^{
							   |	PrintStackTrace();
				 ------------> |	}
				 | 			Excetion 
				 |			   ^
				 <-------------|
				-------------> |
				|		  RuntimeException
				|			   ^
				<-----------   |
				------------>  |
				|		  ToYoungException
				|		  {
				----------  super(s);
						  }
							
	
	
	
	
	
	
	
	
	
	
	
	
	
				
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  