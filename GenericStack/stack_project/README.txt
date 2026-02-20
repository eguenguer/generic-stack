=== Generic Stack – Java Project ===

Structure:
  src/stack/Stack.java              – Generic Stack<T> class
  src/stack/StackFullException.java – Custom exception: stack overflow
  src/stack/StackEmptyException.java– Custom exception: stack underflow
  src/test/StackTest.java           – Test class (Integer + String stack)

Compile & Run:
  javac -d out src/stack/StackFullException.java src/stack/StackEmptyException.java src/stack/Stack.java src/test/StackTest.java
  java -cp out test.StackTest

Create JAR:
  jar cvfe Stack.jar test.StackTest -C out .

Generate JavaDoc:
  javadoc -d doc src/stack/*.java
