
																		Exception Handling Part-8 || Top-10 Exceptions in java
																	============================================================
 
-------------------------- 
 18. Top - 10 exception. 
--------------------------

 -> Based on the persion who is rising an exception all exceptions are divided into two types or Catogaries.

	1. JVM Exceptions.
	
	2. Programatic Excetions.
	
	
 ------------------	
	JVM Exception 
 ------------------	
 
	-> The exceptions which are rised automatically by JVM whenver a particular events occures are called JVM exceptions.
	
		Ex. 
		
			ArithmeticException, NullPointerException etc.
			
  ------------------------- 
   Programatic Exceptions 
  -------------------------

	-> The exceptions which are rised explicitly either by programmer or by API developer to indicate that something goes wrong are called Programatic Exceptions.
	
		
		Ex. ToOldExcetion, IllegalArgumentException ect.
		
	
 --------------------------------------	
	1. ArrayIndexOutOfBoundsException
 --------------------------------------

	-> It is the child class of RuntimeException and hance it is unchecked .
	
	-> Rised Automatically by the JVM whenver we are trying to access array element with out of range index.
	
		EX. 
	
		int [] x = new int[4]; // valid is 0 to 3 
		System.out.println(x[0]);
		System.out.println(x[10]); // RE: ArrayIndexOutOfBoundsException
		System.out.println(x[-10]); //RE: ArrayIndexOutOfBoundsException 
		
 ----------------------------		
	2. NullPointerException	
 ----------------------------

	-> It is the child class of RuntimeException and hance it is unchecked.
	
	-> Rised automatically by JVM Whenever we are trying to perform any operation on null.
	
	
		Ex. 
		
		String s = null ;
		
		System.out.println(s.length());//RE: NullPointerException
	
	
 ---------------------------	
	3. ClassCastException
 ---------------------------

	-> It is the child class RuntimeExcetion and hence it is unchecked.
	
	-> Rised automatically by JVM whenver we are trying to typecast parent object to child type.
	
		Ex. 
		
		String s = new String("Durgs"); 			Object o = new Object();												Object o = new String("Durga");
		Object o = (Object)s;//valid                String s =(String)o;// invalid RE: ClassCastException                   String s = (String)o;//valid 
		
		
 ----------------------------- 
	4. StackOverflowError
-------------------------------

	-> It is the child class of Error and hence it is unchecked rised automatically by JVM whenver we are trying to perform recursive method called .
	
		Ex. 
	
		class Test { 
		
			public static void m1() {								|	m2()   |
				                                                    |----------|
				m2();                                               |	m1()   |
			}                                                       |----------|
			                                                        |	m2()   |
			public static void m2(){                                |----------|
				                                                    |	m1()   |
				m1();                                               |----------|
			}                                                       |	main() |
			                                                        ------------
			public static void main(String args[]) {		//RE: StackOverflowError
				
				m1();
			}
		}
		
 -----------------------------		
	5. NoClassDefFoundError	
 -----------------------------	
		
	-> It is the child class of Error and hence it is unchecked.
	
	-> Rised automatically by JVM Whenever JMV unable to find required .class file.
	
	
		Ex. 
		
			java Test // RE: NoClassDefFoundError
			
		- If Test.class file is not available then we will RuntimeExcetion saying NoClassDefFoundError:Test.

 ------------------------------------	
	6. ExceptionInInitializerError
 ------------------------------------

	-> It is the child class of Error and hence it is unchecked.
	
	-> Rised automatically by JVM if any exception occures while executing static variable assingments and static blocks.
	
	
		class Test {																				class Test {
			                                                                                        	
			static int x 10/0;                                                                      	static {
		}                                                                                           		
		//RE: ExceptionInInitializerError caused by java.lang.ArithmeticException / by Zero.        		String s = null;
                                                                                                    		System.out.println(s.length());
                                                                                                    	}
		                                                                                            }//RE: ExceptionInInitializerError caused by java.lang.NullPointerException
		
		
		
		
		
		
		




























 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		