📘 CMSC-204 Data Structures Projects Collection <br>
<br>
This repository contains a series of Java programming assignments completed for CMSC 204 (Data Structures) at Montgomery College under the instruction of Professor Khandan Monshi. <br>
<br>
Each assignment demonstrates core data structures and algorithms including stacks, queues, linked lists, trees, hash tables, graphs, recursion, and shortest path algorithms. <br>
<br> <br>
📂 Assignments Overview
<br><br>
🔹 Assignment 1: Password Checker Utility
A validation system that ensures passwords meet strict security requirements using custom exceptions and utility methods.

Features:

Validates password length, character requirements, and sequence rules <br>
Checks for uppercase, lowercase, digits, and special characters <br>
Detects invalid character repetition patterns <br>
Compares passwords and confirms matches <br>
Identifies weak passwords based on length <br>
Processes lists of passwords and returns invalid ones with error messages <br>
Includes comprehensive JUnit tests <br>

Concepts Covered:

Exception handling (custom exceptions) <br>
String processing and validation <br>
Regular expressions (Pattern, Matcher) <br>
ArrayLists <br>
Unit testing (JUnit) <br>
 <br> <br>
🔹 Assignment 2: Stack, Queue, and Notation Converter
A data structures implementation project that builds generic stacks and queues and applies them to expression conversion and evaluation.

Features:

Implements a generic queue (FIFO) using ArrayList <br>
Implements a generic stack (LIFO) using ArrayList <br>
Handles overflow and underflow with custom exceptions <br>
Converts infix expressions to postfix notation <br>
Converts postfix expressions to infix notation <br>
Evaluates postfix expressions using a stack-based algorithm <br>
Includes extensive JUnit testing <br>

Concepts Covered:

Stacks and queues <br>
Generics in Java <br>
Exception handling <br>
Expression parsing and evaluation <br>
Algorithm design <br>
 <br> <br>
🔹 Assignment 3: Doubly Linked List & Sorted List
An implementation of a doubly linked list with bidirectional traversal and a sorted extension.

Features:

Supports adding/removing elements at both ends <br>
Uses a custom ListIterator for forward and backward traversal <br>
Removes elements using a comparator <br>
Maintains sorted order in the extended class <br>
Converts list contents into an ArrayList <br>

Concepts Covered:

Doubly linked lists <br>
Iterators (ListIterator) <br>
Generics and comparators <br>
Inheritance and sorting logic <br>
 <br> <br>
🔹 Assignment 4: Course Database (Hash Table Implementation)
A course management system that stores and retrieves course information using a hash table with chaining.

Features:

Implements a custom hash table using an array of linked lists <br>
Stores course data including ID, CRN, credits, instructor, and room number <br>
Uses a custom hashCode based on CRN values <br>
Handles collisions using separate chaining <br>
Supports adding, updating, and retrieving courses by CRN <br>
Reads course data from files <br>
Displays all courses sorted by instructor <br>

Concepts Covered:

Hash tables <br>
Collision handling (chaining with LinkedLists) <br>
File I/O <br>
Comparable interface <br>
Searching and sorting <br>
 <br> <br>
🔹 Assignment 5: Morse Code Converter (Binary Tree)
A tree-based application that converts Morse code into English text using a binary tree structure.

Features:

Builds a Morse code tree where dots (.) traverse left and dashes (-) traverse right <br>
Recursively inserts and retrieves characters from the tree <br>
Converts Morse code strings into readable English <br>
Supports file-based input conversion <br>
Performs inorder traversal to output tree contents <br>

Concepts Covered:

Binary trees <br>
Recursion <br>
Tree traversal (inorder) <br>
File I/O <br>
Data structure mapping <br>
 <br> <br>
🔹 Assignment 6: Town Graph & Shortest Path (Dijkstra’s Algorithm)
A graph-based system that models towns and roads and computes shortest paths between locations.

Features:

Implements a graph using sets of vertices (towns) and edges (roads) <br>
Supports adding/removing towns and roads <br>
Uses an adjacency-based design <br>
Implements Dijkstra’s algorithm for shortest path computation <br>
Returns formatted step-by-step directions between towns <br>
Includes a manager class for high-level operations using town names <br>
Loads graph data from files <br>

Concepts Covered:

Graph data structures <br>
Sets, maps, and priority queues <br>
Dijkstra’s shortest path algorithm <br>
Object-oriented design (Graph, Town, Road, Manager) <br>
File processing and parsing <br>
