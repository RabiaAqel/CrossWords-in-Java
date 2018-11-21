rabeaaqel
tigers


______________________________________________________________________________
              ____                                         _ 
             / ___|_ __ ___  ___ _____      _____  _ __ __| |
            | |   | '__/ _ \/ __/ __\ \ /\ / / _ \| '__/ _` |
            | |___| | | (_) \__ \__ \\ V  V / (_) | | | (_| |
             \____|_|  \___/|___/___/ \_/\_/ \___/|_|  \__,_|   
==============================================================================

  
        1
      .---.---.---.
      | C | A | T |
  .---'---'---'---'---.         1. A pet
2 | G | R | E | A | T |         2. Very good
  '---'---'---.---.---.         3. Object Oriented Programming
    3 | O | O | P |             4. A word
      '---'---'---'
      | S |                      
      '---'---.---.---.---.             
    4 | S | W | O | R | D |        
      '---'---'---'---'---'                            
                         
==============================================================================
                             README FOR EX3
                             
                             
==============================================================================


CONTENTS

ex3.jar

README:         this file

------------------------------------------------------------------------------
crosswords Package
------------------------------------------------------------------------------

File                                       Description

Crossword.java                             represents the crossword game
CrosswordEntry.java                        represents a crossword entry    
CrosswordGlossary.java                     represents the crossword glossary      
CrosswordPosition.java                     represents the crossword entry position       
CrosswordQualityBound.java                 implements the upper quality bound of crossword           
CrosswordStructure.java                    represents the crossword structure       
EntriesIterator.java                       implements the crossword entries iterator     
EntryIterator.java                         represents an iterator for entries   
EntryLoader.java                           implements entries creation functionality 
MyCrossword.java                           implements the crossword game
MyCrosswordEntry.java                      implements the crossword entry      
MyCrosswordGlossary.java                   implements the crossword glossary        
MyCrosswordPosition.java                   implements the entry position        
MyCrosswordStructure.java                  implements the crossword structure         
QualityBound.java                          represents the quality upper quality for a node 


----------------------------------------------------------------------
gui Package
----------------------------------------------------------------------

CrosswordViewer.java
                
                
                
----------------------------------------------------------------------
search Package
----------------------------------------------------------------------           
DepthFirstSearch.java
MyDepthFirstSearch.java
SearchBoardNode.java
SearchMove.java                
            
              
----------------------------------------------------------------------
searchsamples Package
----------------------------------------------------------------------
HorseBoard.java
HorseMove.java
HorsePuzzle.java    

==============================================================================
HEIRARCHY
==============================================================================

crossword Package
---------------------------------------------------------------------


                       <<<< Crossword(Interface)  >>>>
                                    |
                                    | [implements] 
                                    |       
                              MyCrossword          


----------------------------------------------------------------------


                 <<<<<<<  SearchMove(Interface) >>>>>>>
				          	      | 
				          	      | [extends]
				          	      |
                        CrosswordEntry(Interface)
                                  |
   				                  | [implements] 
   				                  |         
                           MyCrosswordEntry      



---------------------------------------------------------------------- 
    
                 <<<<<<<< CrosswordGlossary(interface) >>>>>>>>>
                                     |
                                     | [implements] 
                                     |
                        MyCrosswordGlossary(interface)
                                          
                      
      
 ----------------------------------------------------------------------     
                   <<<<<<< CrosswordPosition(interface) >>>>>>>
                                      |          
                                      | [implements]
                                      |
                             MyCrosswordPosition
      
 ----------------------------------------------------------------------     
                  <<<<<<< QualityBound(interface) >>>>>>>
                                     |
                                     | [implements]
                                     |          
                           CrosswordQualityBound
      
      
 ----------------------------------------------------------------------     
            <<<<<<< CrosswordStructure(interface) >>>>>>>
                                  |
                                  | [implements]
                                  |          
     	                 MyCrosswordStructure 
              
      
 ---------------------------------------------------------------------- 
                  
             <<<<<<<<<<<<< Iterator<E>(interface) >>>>>>>>>>>>>
      		                       |
      		                       | [extends]
      		                       |  
                <<<<<<< EntryIterator<E>(interface) >>>>>>>
                                   |
                                   | [implements]
                                   |       
     	        EntriesIterator<E extends CrosswordEntry>    Comparator<T> 
      				              /                            ^
      				             /   [Nested Class]           / [implements]
      				            /                            /         
      	    	CrosswordTermComparator<T>------------------/
 ----------------------------------------------------------------------     		
	   
	  << CrosswordStructure (interface) >>
	   		    	\                                      
	   		    	 \                                    
	   		    	  \                                  
	   [implements]    \
	   		    	    \        Cloneable(Interface)
	   		    	     \         /
	   		    	      \       / [implements]
	   		    	       \     /                          
	  		   MyCrosswordStructure               
				         |
				         |  [Nested Class]
				         |
			  	       Slot 

                          
search package
--------------------------------------------------------------------- 

          <<<<<<<<<< implements DepthFirstSearch<B,M> >>>>>>>>>>
                                |
                                | [implements]
                                |
  MyDepthFirstSearch<B extends SearchBoardNode<M>, M extends SearchMove>
  
           <<<< SearchBoardNode<M extends SearchMove>(Interface) >>>>>
           
                       <<<< SearchMove(Interface) >>>>>
                        
  
           
==============================================================================
MORE DESCRIPTION
==============================================================================                      
                      
The project contains two packages, the main and the filecompile package.

The main package
----------------
Sjavac
This is the main class, the main class compiles the source file which supplied as an argument
to the main method, the main methods checks the validity of the supplied file, constructs
a new compiler and invokes the compile method in order to compile the file.
The class also handles IO exceptions.
In case that the compile runs successfully the main methods reaches the finally clock and
uses system exit value 0.

ReadMyFile
This class reads the sjava file using the bufferedReader and returns the file stream.

ClearComments
This class gets a bufferedReader stream and removes all comments and code white spaces or
empty lines using the clear method, the method returns the code lines array list.

Compiler
This class extends the RegexPattern and compiles the code lines which returned as array list from the 
ClearComments and throws illegal code exceptions at runtime and handles exceptionsusing handleError
method using the exit value 1, the class iterates using the Iterator the code lines and 
reads the syntax using the regular expressions.

RegexPattern
This class holds the regular expressions which used in the compiler class, the class
includes the patternCompile() method which compile the regex's to the suitable patterns.

Variable
This class represents the variable object and holds the variable attributes isFinal, isInitialized
type, value.

Method
This class represents the method object and holds the variable attributes type, localVariables,
body.

IllegalSyntaxException
This class extends the Exception class and handles the illegal sjava syntax statements.

InvalidFileException
This class extends the Exception class and handles file errors.

InvalidUsageException
This class extends the Exception class and handles wrong arguments and usage errors.

The main package
----------------


Name  
The Name Interface implements abstractly a name, it defines the ability to create 
a name object. The class includes three methods isLegal() check if the name legal,
isExist() which checks if the name exists previously and toString() which returns
a string value of the name.

 
Naming       
The Class is a super-class of the (VariableName, MethodName and ParameterName), it implements the
Name interface and represents a Name objec. This class holds the naming regular expression 
in order to match a legal name.

VariableName      
This class extends the Naming class and represents the variable name object.
                
MethodName     
This class extends the Naming class and represents the method name object.

ParameterName
This class extends the Naming class and represents the parameter name object.

Define.java:      
This Interface provides the defining ability of an object, it includes two methods
which provide the functionality of the defining ability, isLegal() checks if it is
a legal declaration and Add() which adds definition.

VariableDefine.java:   
This class implements the Define interface to define a new variable, the class invoked
for defining new variables.
                
LocalVariableDefine.java:   
This class implements the Define interface and extends the VariableDefine class to define 
methods local variable.
                
MethodDefine.java:  
This class implements the Define interface to define a new method.

ValueAssign.java:      
This class is used to handle value assignment cases and implements the required functionality.

Condition.java:   
This class represents the condition statement and provides the functionality to check the 
if the condition is legal.

Call.java:   
This class represents the method calls log and supplies appropriate methods to handle
new or previous calls.

InvalidNameException
This class extends the Exception class and handles invalid naming errors.

DuplicateVariableException
This class extends the Exception class and handles duplicate variables errors.

NotInitializedException
This class extends the Exception class and handles not initialized errors.

TypeMisMatchException
This class extends the Exception class and handles the illegal sjava syntax statements.


==============================================================================
DESIGN AND FUNCTIONALITY
==============================================================================    

The program is organized into two packages in order to group the main tasks 
which read and process the source code, the filecompile packages which groups 
the compiling classes. 

The main package contains the Sjavac main class which gets the source code file 
as an argument through the main method. The main method of Sjavac creates a new 
compiler and invokes the compile method. It also handles the IO exceptions.
The Compile method creates a new bufferedReader and reads the file using 
ReadFromFile class then it attributes the returned buffered stream to the 
clear comments class using the clear() method which returns an array list 
containing the lines excluding comments. The ClearComments creates a new exception
in case found unclosed method. And it suspend to handle the comments errors
in order to print the first illegal statement. The compiler object holds three 
HashMap structures in order to store the class members, methods, method calls
HashMap<String,Variable> which contain the class members - and object of
Variable type contain the variable attributes such as type, isFinal... - 
HashMap<String,Method> contains the class methods - an object of type Method 
represent the method attributes such as localVariables HashMap<String,Variable> ,
type and the method body.
The compiler iterates the code lines arraylist using the iterator and checks
the line syntax whether its variable declaration or method declaration. and
treats such cases by invoking the suitable methods. The Compiler handles
errors concerning illegal sjava code by the exception mechanism.  In case of illegal 
code line or statement it throws an appropriate exception which handled from the 
invoker method.

The filecompile package includes the compiling classes which checks source code
and throws(mostly) to the main package the illegal code exceptions. The Define
Interface provide the defining ability to an object and it allows future declaration
types to be efficiently added. Name Interface represents a name of different sjava
variables or methods. The implementation and the inheritance supplies the 
the sharing ability and inheriting the unique behavior, attributes and functionality
of the Name Interface.

The compiler reads and compile methods body after it iterates the code lines to assure
defined members and method calls. The Call class holds a static HashMap of the methods
calls.
When found method call the program appends it to the static Call HashMap<Strig,String>
where key is the invoked method and value is the invoker. Upon defining a new method
the defining class checks if this method is invoked previously and in such case it removes
it from the HashMap.
Therefore, when the methods is compiled the compiler checks if there exists Call's which  
calls an exisiting methods and removes it. Afterwards, in case the Call's HashMap is not
empty it means that there was undefined method which is invoked somewhere in the sjava code.
As a result the compiler throws an exception and exists using illegal code value.

Questions

6.1
---
The description above specifies the used mechanism to handle illegal sjava statements.
The exception mechanism is used to handle such errors, the Compiler mostly handles 
and catches such exceptions printing and existing using 1 as a return value. 
the compiling and main classes throws such exceptions in case it encounters 
illegal code lines. The Sjava main class handles the IO exceptions and exceptions 
raised upon wrong arguments or wrong file.

6.2
---
Using the advanced java feature, the polymorphism allows efficiently to add new variable types
or new definable objects. Implementing the Define Interface allows a new class or object
to implement the required functionality and provide this ability. Adding a new variable type
could be done by editing the final regular expressions in the RegexPattern.

- Compile a few files together and by that allow the import of new files (i.e., their
methods and members) from one file to the other.
This features could be implemented upon applying minor(negligible) changes in the compile
method of the Compiler. the Compiler as mentioned before reads the file separately using 
the ReadFromFile class. So in that case creating a new compiler from the main class and 
supplying the other files would provide such an ability.

6.3
---
The two main regular expressions is the Variable regex and the method defining regex
which these are the two sjava code components they are matched by the while iteration
which iterates the code lines and captures the matched groups and process the declaration.
The program uses the regular expressions abundantly to recognize certain expression
and capture the required data.







==============================================================================
