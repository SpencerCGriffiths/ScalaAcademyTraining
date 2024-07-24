# Futures 

futures allow for operations to be performed in parallel meaning that tasks tend to be performed quicker and asynchronously. 

Future acts as a placeholder object for a value that does not yet exist. 

flatMap, foreach, filter etc can be used in conjunction with futures to allow callbacks to be made. 

they resolve around Execution Contexts. These are what are responsible for executing computations. 

The scala concurrent package helps us out here. 

The future apply method is built in when we import scala.concurrent package. 


final def apply[T](body: => T)(implicit executor: Executor): Future[T] = unit.map(_ => body)


Take in an expression. We pass this on:
-> (body: => T)

Take in this implict parameter. Which is of type ExecutionContext:
-> (implicit executor: Executor):

We import this global implicit to help us out:
-> implicit final def global: ExecutionContext = ExecutionContext.global



