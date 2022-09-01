# What is Big O
#### Roger's Head: Big O! Big O! Big O! Big O! Big O! Big O! Big O! Big O! Big O! Big O! ... ... ...

Big O notation is a simplified analysis on an algorithm's performance as the input
size changes. 

A better quick cheat on what the complexity on some algorithms can be referred
from [BigO Cheat Sheet](https://www.bigocheatsheet.com/) .

### Type of Complexity

 - Time
 - Space

### O(1) Constant Time

In simple terms: As the input size changes, the run time doesn't change.
<img src="https://raw.githubusercontent.com/Fas96/T-images-repo/b6c83833d090bf895f58cd2b4cca51922e687297/constant.svg">

#### Real world Examples
- O(1) - determining if a number is odd or even
- arithmetic operations
<br>
<hr>

### O(n) Linear Time
As input Increase, the runtime also increases.

<img src="https://github.com/Fas96/T-images-repo/blob/main/linearComplexity.png?raw=true" alt="Not found">

```
@startuml 
N -> N: f(N) 
@enduml
```

#### Real world Examples
- O(N) - reading a book
- for loops in search.(worse case)

<hr>

### O(log n) Logarithmic Time
This is the complexity achieved when the given operation is an exponent
of a given number. We divide the operation by the power of given input.

![Logarithmic](https://github.com/Fas96/T-images-repo/blob/main/logarithmic.jpeg?raw=true)

#### Real world Examples

- O(log N) - finding a word in the dictionary (using binary search)
<hr>

### O(nlogn) Time Complexity
In Simple terms for each Linear  operations (O(n) Linear Time) we have O(log n) Logarithmic Time.
consider log(base 2) 8.

#### Real world Examples
- O(N log N) - sorting a deck of playing cards (using merge sort)
<hr>

### O(n^2) Time Complexity
The time given for an operation to finish is the 
square of the input size.
![](https://github.com/Fas96/T-images-repo/blob/main/nsquare.png?raw=true)

#### Real world Examples
- O(N^2) - checking if you have everything on your shopping list in your trolley

<hr>

### O(n!) n-factorial time
A factorial of a n is the product of numbers from 1 up to that number.
f(n!)=n*(n-1)*(n-2)...(1)

![](https://www.chilimath.com/wp-content/uploads/2017/02/ex1_s1-3.png)

#### Real world Examples
- factorials
- permutations
- Hamiltonian path problem
- Travelling salesman problem
- Boolean satisfiability problem 
- N-puzzle
- Knapsack problem
- Subgraph isomorphism problem
- Subset sum problem
- Clique problem
- Vertex cover problem
- Independent set problem
- Graph coloring problem

<hr>

### O(2^n) Exponential Time
The time complexity is equal to Math.pow(2,f(N)) operations.


![](https://appliedgo.net/media/big-o/exponential.png)


#### Real world Examples
- The n-Queens Problem

<hr>

## Summary
In all  operations, Big O is considered for the worse case
of the operation completion.

## Reference

| Type     | Source        |
|----------|---------------|
| Images   | Google        |
| Resource | Youtube       |
| Examples | StackOverflow |
