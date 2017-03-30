### JVM background

			    javac(compiler)                      JVM
Source Code ------------------> Byte Code(.class) -----> Machine Code

- JVM (Java Virtual Machine) is an abstract machine. It is a specification that provides runtime environment in which java bytecode can be executed.
- JRE (JVM+libs) is used to provide runtime environment. It is the implementation of JVM. It physically exists. It contains set of libraries + other files that JVM uses at runtime. 
- JDK (dev kit) physically exists.It contains JRE + development tools.

- Javac is platform independent, only translates source code to something JVM understands
- JVM, JRE and JDK are platform dependent
- [JVM Internals](http://blog.jamesdbloom.com/JVMInternals.html)
