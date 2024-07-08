# Functions and Methods
*Whilst Thinking About Scope* 

- Scope 
- Functions 
- Methods 
- Referential transparency 
- Pure and impure functions 

## Scope 

Scope is a term used for what information is available to you, within a class, object, trait, function etc. 
Scopes are hierarchical, and any scope can contain many other scopes within it. 
Scopes can be nested. 

*If the compiler can't find the information it is looking for in the current scope, it will look in it's parent scope for that information.
(The compiler will always take information from the closest scope it can find)*

## Functions and Methods

The distinction between these is difficult 

- Both when named, allow you to define specific steps once and then reuse them in multiple places, this eliminates duplicate code. 
-  The logic can be identifacl however its what we assign that lofic to that decides if it if a function or a method. 

### Function: 

- No different to any other type 
- It can be declared or assigned to a val or even passed into another function or returned by a function 
- Methods are one type of function 

### Method:
- Must use the keyword "def"
- Methods must belong to a class.
- can be overridden with a different implementation 
- We cannot have an anonymous method; it must have a name

#### Is it a function or method??

(number:Int) => number + 1'''

Anonymouse function- is not assigned to anything so can be run but cannot be reused as it has no name. 

val addition = (number:Int) => number + 1

Named Function 
Assigned to a val so we can call it and reuse it in multiple places

def addition (number: Int) = number + 1

Method (also a function :) )

assigned to a kewrowd def, we can call it and resuse it in ,multiple pplaces\

override def addition (number:Int): Int = number + 10

Override method. 
We can override a method and give it a different implementation. Vals are immutable remeber so we cannnot override



### Syntax!

A method is defined like this:

def nameOfMethod(parameters but this can be empty): ReturnType = { 
-> Expression 1
-> Expression 2 
-> Expression 3 etc
-> Expression last - has to return the return type
}

##




