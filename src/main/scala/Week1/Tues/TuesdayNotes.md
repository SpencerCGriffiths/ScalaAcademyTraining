Day 1 notes-
Background of Scala / Intro:

Scala made to improve on Java
Scala is similar to Java in the way it compiles — byte code
As long as JVM exists on the machine it can run on any type of machine.
A JVM reads, checks and runs .class and .jar files. This is fast as byte code is so close to machine code.

You can write Java and Scala code in the same application (not good practice).

IntelliJ
IDE

Check your code while you’re writing it

Provides syntax highlighting and suggestions making ti much faster and more efficient to write your code in.

Plugins to install:
[.ignore, rainbow brackets]

- .ignore
  creates gitIgnore file

- Rainbow brackets
  helps locate missing or wrong brackets



build.sbt is where we put dependencies in client side.


Option 1 - Creating a worksheet:
Src -> main -> Scala -> new -> scalaWorksheet

Using a worksheet:
Press run and it can run the program and instructions


Option 2:  Create an Object

New -> scala class -> object

“Extends App”
object HelloWorld extends App {

}

Syntax:
Printing in Scala
println(“Hello World!”) 

## Storing Values in Scala 

/Users/spencer.griffiths/Documents/ScalaAcademyTraining/src/main/scala/Week1/Tues/StoringValues.sc

Values (Vals) vs Variables (Vars)

Vals:
Vals are immutable and cannot be changed
Often used as the value is always known
Safe more trustworthy code

Vars:
Vars are mutable and can be reassigned
Difficult to know what the value is at a given time
Can cause issues if two parts of the same program are trying to access/manipulate it at the same time. 

**(colloquially people will refer to values as variables)**

Storing Values: 

Suzie went to the shop and bought 5 melons at 50p, 2 apples at 10p and 6 fizzy drinks at £1.20. 

What is the total cost in pence?
/Users/spencer.griffiths/Documents/ScalaAcademyTraining/src/main/scala/Week1/Tues/StoringValues.sc

Types: 

Types are like a label to describe what data you're storing. 
Once defined a value/variable cannot store something that is not of the same type 
Scala offers a variety of data types to model different types of information relevant to the probolem that you as a developer may want to solve. 

Integer (Int)
val one:Int = 1

String (String)
val two:String = "Two"

Booleans (true or false)
val good:Boolean = true


Operators

Operators are symbols that when compuling will perform a specific fucntion. 
Scal;a has many inbuilt operators. We are going to look at 3 commonly used ones

Arithmetic 
+Add
-Minus
=Equals

.gitignore file:
file -> new -> .ignore file -> .gitIgnore -> scala



## Protected Keywords
    & their meaning:

- abstract
Marks a class or trait as being abstract and uninstantiable.
- case
Defines a matching pattern in match expressions and partial functions.
- catch
Catches an exception. An alternate syntax that predates the util.Try monadic collection.
- class
Defines a new class.
- def
Defines a new method.
- do
Part of the do..while loop definition.
- else
The second part of an if..else conditional expression.
- extends
Defines a base type for a class.
- false
One of the two Boolean values.
- final
Marks a class or trait as being nonextendable.
- finally
Executes an expression following a try block. An alternate syntax that predates the util.Try monadic collection.
- for
Begins a for-loop.
- forSome
Defines an existential type. Existential types are a flexible method for specifying type requirements, but are discouraged in general Scala development. See SIP-18 (Scala Improvement Process #18) for details on why existential types are considered an “opt-in” feature in Scala.
- if
The first part of an if..else conditional expression, or the main part of an if conditional statement.
- implicit
Defines an implicit conversion or parameter.
- import
Imports a package, class, or members of a class to the current namespace.
- lazy
Defines a value as being lazy, only defined the first time it is accessed.
- match
Begins a match expression.
- new
Creates a new instance of a class.
- null
A value that indicates the lack of an instance. Has the type Null.
- object
Defines a new object.
- override
Marks a value or method as replacing the member of the same name in a base type.
- package
Defines the current package, an incremental package name, or a package object.
- private
Marks a class member as being inaccessible outside the class definition.
- protected
Marks a class member as being inaccessible outside the class definition or its subclasses.
- return
Explicitly states the return value for a method. By default, the last expression in a method is used as the return value.
- sealed
Marks a class as only allowing subclasses within the current file.
- super
Marks a class member reference as one in the base type, versus one overridden in the current class.
- this
Marks a class member reference as one in the current class, versus a parameter with the same name.
- throw
Raises an error condition that breaks the current flow of operation and only resumes if the error is caught elsewhere.
- trait
Defines a new trait.
- true
One of the two Boolean values.
- try
Marks a range of code for catching an exception. An alternate syntax that predates the util.Try monadic collection.
- type
Defines a new type alias.
- val
Defines a new, immutable value.
- var
Defines a new, mutable variable.
- while
Part of the do..while loop definition.
- with
Defines a base trait for a class.
- yield
Yields the return value from a for-loop.

