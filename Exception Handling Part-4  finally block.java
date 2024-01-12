
																			Exception Handling Part-4 || finally block
																		================================================	
---------------------
	   final
---------------------

 -> final is the modifier applicable for classes methods and variables.

 -> If a class declared as final then we can't extend that class that is we can't create child class for that class that is inheritance is not possible for final classes. 
 
 -> If a method is final then we can't override that method in the child class.
 
 -> If a variable declared as final then we can't perform re-assignment for that variable.
 
 
 -------------
	finally
 -------------

 -> finally is a block always associated with try-catch to maintaine clean-up code.

		try {
			
			risky code
		}
		catch(
		
		 hadling code 
		 }
		 finally {
			 
			 clean-up code 
		 }
		 
	- The speciality of finally block is it will be executed always irespective of whether exception is rised or not rised and whether handled or not handled.
	

-------------------
	finalize()
-------------------

	->  finalize() is a method always invoked by garbage colletor just before destroying an object to perform clean-up activities.
	
	-> Once a finalize() method complities immeadiatly garbage colletor destroyies that object.
	
	
	
Note: 

	- finally block is responsible to perform clean-up activities related to try block that is whatever resource we opend as the part of try block will be closed inside finally block.
	
	- Where as finalize() method is responsible to perform clean-up activities related to object that is whatever resources associated with object will be deallocated before distroying 
	  an object by using finalize() method.  

---------------------------------------------------
 Various possible combination of try-catch-finally 
---------------------------------------------------

 -> In try-catch-finally order is important.
 
 -> whenever we are writing try compulsory we should write either catch or finally otherwise we will get compile time error that is try without catch or finally is invalid.
 
 -> Whenever we are catch block compulsory try block must be required that is catch without try is invalid.
 
 -> whenever we are writing finally block compulsory we should write try block that is finally without try is invalid.
 
 -> Inside try catch-finally block we can declare try-catch-finally blocks that is nesting of try-catch-finally is allowed.
 
 -> For try-catch-finally blocks curly braces are mandatory.
	

 try {				try {				try { 								try { 				try { 			try { 			try { 				try {			catch(x e) {
                                                                                                                                
 }                  }                   }                                   }                   }               }               }				   }/*CE: 			} /*CE: 
 catch(x e) {       catch(x e) {        catch(x e) {                        catch(x e) {                        catch(x e){     catch(x e){			 try without	   cathc without	
	                	                	                                	                finally {       }               }					catch or fially   try 
 }//valid           }                   }                                   }                   	                            					*/                */
                    catch(y e){         catch(x e){                         finally {           } //valid       try  {          try  {
                    	                	                                	                                	            	
                    }//valid            }                                   } //valid                           }               }
                                        /*CE: exception x has already                                           catch(y e){     finally(y e){
                                        	been cought */                                                      	            	
                                                                                                                } //valid       }


finally{				try { 				try { 								 try {								try {								try {				try {				
	                                                                                                                                                    	                	 
}/*CE:                  }                   }                                    }                                  }                                   	 try {          	 try {
  finally without	    finally{            System.out.println("Hello");         catch(x e){                        catch(x e){                         	 }catch(x e)    	 }
  try                   	                catch(x e) {                                                                                                	 {              }
 */                     }                   	                                 }                                  }                                   	 }              catch(x e) {
                        catch(x e){         }                                    System.out.println("Hello");       System.out.println("Hello");        	catch(x e){     		 
                        	                /*try without catch or finally       catch( y e){                       finally {                           	}//valid        }/*CE: try without catch or 
                        } /*catch without   catch without try */                                                                                        		            finally */
							try */                                               }/* CE:catch without try */        }/* CE:finally  without try */
							                                                     

					
 try {					try {				 try {								try {				try {						 try {
	                                        	                                                                                
	 try {              }                    }                                  }                   }                            }
		                catch(x e){          catch(x e){                        catch(x e) {        catch(x e) {                catch( x e) {
	 }                                      	                                                                                
	 finally{             try {             	  finally {                     }                   }                           }
		                	                		                            finally {           finally {                   
	 }                    }                 	  }                                                                             finally {
  catch(x e){             finally{          	                                  try {               finally {                 
	                    	                 } /*CE: finally without try */     	                	                        }
  }// valid               }                                                       }                   }                         finally {
                        } //valid                                                 catch(x e){       }/*finally without try */   
                                                                                	                                            }/*CE: finally without try */
                                                                                  }
                                                                                }//valid 
																				
  
	try 									try {									try {
		System.out.println("try");          	                                    	
	catch(x e ) {                           }                                       }
		                                    catch(x e)                              catch(x e)
		System.out.println("catch");        	System.out.println("catch")';       {
	}                                       finally{                                }
	finally {                               	                                    finally
		                                    } //invalid 	                           	System.out.println("finally")';
	} //invalid 																	//invalid 
	
	
	
	
	
	
	
	
	
	
	
	
	











	
  
	
  
  
	
	
	
	
  
  
  





  
  
  
  
  



 


 
 







   
	
   
   
	
   
   
   
	
   
   

   
   
   
   
   