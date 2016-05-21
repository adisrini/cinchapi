# Cinchapi Hiring Exercise

This is my submission for the Cinchapi hiring exercise. I chose to complete exercises A and B. To summarize, these are the specifications for the exercises:

**Exercise A: Threads and Concurrency**

>Create a Java program that has three threads, respectively A, B and C. Each thread starts at exactly the same time and concurrently increments the value of some global counter (initially set to 0) by exactly 1. Each time a thread increments the value of the counter from old_value to new_value (e.g old_value + 1), it prints new_value onto the console and stores new_value in a collection.

>Each thread should continue to run until the value of the global counter reaches 100 at which point, each thread should print its collection of stored values onto the console. Once complete, the output of your program should be 100 numbers (1-100) in chronological order followed by three collections, each with a distinct subset of the numbers printed.


**Exercise B: Data Structures**

>Given the following implementation rules:

>* You can declare exactly one instance or static variable that holds information on the heap.
>* You cannot use a data structure from the java.util.* package
>* You can use as much non-heap storage as you need.
>* The data structure wil be used within a JVM with a heap size of 64mb.
>* The data structure will be used to store at least 10 million values.
>* Create a data structure that implements the following interface:

>```java
/**
 * Attempt to insert {@code value} into the collection and return 
 * {@code true} if the collection is modified after this method
 * returns (e.g. {@code value} was not already contained in the
 * collection)
 * 
 * @param value a long value to insert into the collection
 * @return {@code true} if {@code value} didn't previously exist in
 * the collection and is inserted
 */
>public boolean insert(long value);

>/**
 * Return {@code true} if {@code value} exists within the collection.
 * 
 * @param value the value for which to check
 * @return {@code true} if {@code value} is contained within the 
 * collection
 */
public boolean contains(long value);
```

The code is well-documented in order to defend design decisions and choices that I made. Further, I developed several test cases for each exercise in the form of JUnit tests in order to confirm functionality. To run the demonstration, please find the JAR file titled ``CinchapiHiringDemo.jar`` in the GitHub repository. After downloading the file to your machine, navigate to the directory where the JAR is located and execute:

``>> java -jar CinchapiHiringDemo.jar``

This will begin the program, which consists of a prompt loop asking users to choose between exercise A or B, or allowing them to quit the loop if desired.

If exercise A is selected, by typing ``A`` into the prompt, the JUnit test program is run for that exercise, including demonstrating functionality of running the threadsafe counter and that all subsets have distinct values with no intersections.

If exercise B is selected, by typing ``B`` into the prompt, the JUnit test program is run for that exercise, including demonstrating functionality of ``contains()``, and ``insert()`` by testing edge cases and other methods for validation.

Finally, the user may type ``Q`` if they desire to quit the program.

One notable feature is that the program is highly extensible. Reflection is used to run exercise demonstrations in the loop, and so creating further demonstrations only requires creation of new classes and no modification of existing classes. This adheres to the open-closed principle of software design. Further, a text file is used to parse thread names, and so many threads can easily be added by simply adding to the text file. This is another example of the open-closed principle.

I had a lot of fun working on these exercises, and I hope you appreciate my submission!
