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



.gitignore file:
file -> new -> .ignore file -> .gitIgnore -> scala


