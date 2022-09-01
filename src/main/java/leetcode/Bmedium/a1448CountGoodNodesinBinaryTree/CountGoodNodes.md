### 1448.(BINARY TREE) Count Good Nodes 🌳

> “Don't get too deep, it leads to over thinking, and over thinking leads to problems that doesn't even exist in the first place.” – Jayson Engay

<hr>
The quote defines how much  human's overthink even in simple situations like "Counting Good Nodes". 
I get baffled to overthink in situations when my seemingly correct code does not past few cases in leetcode submission.
💭Aww well maybe we all overthink at some point. 

## Fails Other Cases But Passes the available test case
It seems pretty easy and all we need to do is keep record of the root,Which i was using 'Temp' to make hold of.
I only traverse other nodes and check if it is equal to or greater than the root(temp).

#### Failing code 

```java
class Solution {
    int res=0;
   TreeNode temp=null;
    public int goodNodes(TreeNode root) {
    if(root==null) return 0;
    temp=root;
    goodNodesCountHelper(root);
    return res;
  }

  private void goodNodesCountHelper(TreeNode root) {
    if(root==null) return;
    if(root.val>=temp.val)res++;
    if(root.left!=null)goodNodesCountHelper(root.left);
    if(root.right!=null)goodNodesCountHelper(root.right);
  }
}
```

<br>

![Passed](https://github.com/Fas96/T-images-repo/blob/main/countGoodNodes.png?raw=true)

<br>
Aww Well that seems to pass. Let's try submitting this.. 

![](https://github.com/Fas96/T-images-repo/blob/main/failingCase.png?raw=true)

Aww well that fails for that test case.Does it help to check some conditions before adding res+=1. Well maybe 
we are just updating the result wrongly

![](https://homecert.com/wp-content/uploads/2017/10/window-leak.jpg)

### ?? Why the error in some test cases??
Sometimes, is we just need to find the root cause and trace it down.
This problem has a tickle down effect and so we can find the cause from the root.
which implies in our goodNodesCountHelper method we need to pass the value of the root.
And use it in finding subsequence values in tree.
??? The question says its clearly

#### How do we do that?
We only check if the current root value is greater than or equal .
```if(root.val>=curVal)res++;```
Well it suffice for our question but how do we know the current value of the nodes we visited?
The question says ``if in the path from root to X there are no nodes with a value greater than X.``
So it implies the visited root in the path should always be less than or equal to the current root.
That means we can add it to response. awwww this clicks back to the `112 Path Sum` question
So in this situation simple we keep  obtaining the maximum value of root  and current node.


#### Working.
```java
  int res=0;
 
    public int goodNodes(TreeNode root) {
    if(root==null) return 0;
    if(root.left==null && root.right==null) return 1;
 
    goodNodesCountHelper(root,root.val);
    return res;
  }

  private void goodNodesCountHelper(TreeNode root,int curVal) {
      if(root==null) return;
     if(root.val>=curVal)res++;
      goodNodesCountHelper(root.left,Math.max(curVal,root.val));
   
      goodNodesCountHelper(root.right,Math.max(curVal,root.val));
      
  }
```

### Summary
Its usually better to read the question carefully. 
Dont over think(Dont complicate your mind).
Know why it fails and why it passes.
