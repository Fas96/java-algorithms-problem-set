## 102-Binary-Tree-Level-Order-Traversal

<a href="https://leetcode.com/problems/binary-tree-level-order-traversal" target="_blank">binary-tree-level-order-traversal</a>

A breakdown to my understanding of how to traverse a binary search tree level orderly.

<a  href="https://www.youtube.com/watch?v=BNeOE1qMyRA&ab_channel=LiveToCode" target="_blank">What is Call Stack?</a>

In most ubiquitous way of solving binary trees it is either traversing 
* Inorder(Left Root, Right) 
* preOrderly ((Root, Left, Right) )
* and PostOrderly((Left, Right, Root).

In this case we want to traverse in the level order.

We want to travel from the root to left to  right, that is <bold> (root,left,right) </bold>

## Code Break Down
If it helps to know each level has set of values. So each level is going to call List of Values.
So collection of each level list is going to give List of List.

We want to have a `callStackLevels` 
for each level and at each new level we want to create a List to hold its values.
```java
lelVals.add(new LinkedList<Integer>());
```
In situations where the node has no value we just return. And end the call Stack. Remember all recursive functions requires a 
conditional stop. ``` if(root==null) return;```
From above I mentioned we need to create list to hold values of each level. How do we know if we are on new level. We only 
know by increasing the level value by 1 each time we call the stack again. 
```java
      callStackLevels(lelVals,root.left,level+1);
      callStackLevels(lelVals,root.right,level+1);
```
lelVals Holds the Values at each level. When we call a level(height) that is equals to the lelVals array Length or greater than
it it implies we are on a new level. so we add a new List to hold values on that level.
```java
if(level>=lelVals.size()){
        lelVals.add(new LinkedList<Integer>());
      }
```
Well, if this call Stack helps us to call each level and hold the array List then we can simply return
the resulting List of List as the values held from each level.
Initially, the root is at level 0,and ofcourse we keep increasing it till the end of the binary tree.

## Our Call Stack

```java
 public void callStackLevels(List<List<Integer>>  lelVals,TreeNode root,int level) {
      if(root==null) return;
      if(level>=lelVals.size()){
        lelVals.add(new LinkedList<Integer>());
      }
      lelVals.get(level).add(root.val );
      callStackLevels(lelVals,root.left,level+1);
      callStackLevels(lelVals,root.right,level+1);
    }
```
When we call our call Stack on a List of List(result) on the root of our tree with our level being 0. Then the 
result after the call stack bubbles up holds the values of each call.

## Finally, Our Level Order Becomes

```java
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
      callStackLevels(ans,root,0);
    return ans;
    }
```
<pre>
* There is always a better way.
* I am just learning
* Hit me Up with better ways, So I can learn. 
* It is always 감사합니다.
</pre>