## HashMap Sorting Errors [Entry Result Manipulations]. 
```qute
In Java, the final keyword is used to denote constants. 
It can be used with variables, methods, and classes.
 Once any entity (variable, method or class) is declared 
 final , it can be assigned only once.
```
1. Local Changes Never Used
2. Cannot assign a value to final variable(Well ofcourse)

One of the most important data structures to know is hashmaps. and how to use them 
in functional programming can be a hustle sometimes.

Hash maps can be used to solve problems of all forms.
eg frequency counts,data search etc.
There are many problems that can be solved with hashmaps. 
>In this situation the focus is sorting.

We can sort hashmaps by values or by keys
````java
HashMap<Integer,Integer> hm= new HashMap<>();
//by values
hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())); 
//by keys 
hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey())); 
````



### Local Changes Never Used
![](https://github.com/Fas96/T-images-repo/blob/main/valueChangesNeverUsed.png?raw=true)
Imagine we want to declare some local variable in 
the sorted hashmap, and we want to update the local variable value in the Entryset result.
OUR UPDATE MIGHT NOT OCCUR. The best option we might consider is to declare a final variable outside
our EntrySet result. But we know FINAL VALUES does not update.

### Cannot assign a value to final variable
Well if we decided to update the local variable with an outside variable then, we can do so.
![](https://github.com/Fas96/T-images-repo/blob/main/hmnormalFinalNotWorking.png?raw=true)
This might be what we look for but the IDE is kind enough to tell us we cannot update a final variable like this.
Same in the pre- or post-variable updates.
![](https://github.com/Fas96/T-images-repo/blob/main/cannotAssignValueTofinalVariable.png?raw=true)

### Solution
#### Option 1 FINAL ARRAYS
Well it is clear we cannot update a FINAL variable. but we can declare this as an array

![](https://github.com/Fas96/T-images-repo/blob/main/correctWay.png?raw=true)
The above solves the problem of the FINAL variable not updating.

#### Option 2 AtomicInteger
Atomic Integers extends Number, and we can perform some operations on a number.
some few methods we have is 
![](https://github.com/Fas96/T-images-repo/blob/main/atomicIntegers.png?raw=true)

so in our case we can declare an atomic integer to control our count in the Entry result.
```java
  HashMap<Integer,Integer> hm= new HashMap<>();
        int[]res=new int[k];

        for (int n : nums) {hm.merge(n,1,Integer::sum);}
        
         AtomicInteger cnt = new AtomicInteger();
       hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(e->{
           if(cnt.get() <k){
           res[cnt.getAndIncrement()]= (int) e.getKey();
           }
       });


        return res;
```
#### Summary 
This code was about to get the K most frequency in int arrays Leetcode[347. Top K Frequent Elements(Medium)].
This might not be the most efficient code to count the most frequency,but using methods in functional streams makes it
seem easy.
The alternative suggestions to how to use local variables in entry result can be Manipulated better.
We can decide to extract the result into a variable list. and only loop k times.
```java
 List<Map.Entry<Integer, Integer>> entryList = hm.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        
```
There are definitely smarter way others can do it.



