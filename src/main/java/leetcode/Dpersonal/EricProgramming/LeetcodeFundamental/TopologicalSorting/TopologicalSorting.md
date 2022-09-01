## Topological Sorting
It sorts the directed graph in a linear ordering where each vertices like <strong> uv </strong>
from the vertex u to vertex v,u comes before v in the ordering.

### Applications:
- School class prerequisites
    - Task scheduling system in a distributed system.
    - etc
### Topological Sorting Conditions
- No directed cycles in the graph
- At least one topological sorting for every Directed Acyclic Graph
    - Kahn's algorithm
    - DFS

![](https://i.imgur.com/2z9J2E5.png)

We cannot use topological sorts in cyclic graphs.
We can only perform topological sorting on graphs that are directed acyclic graphs.
The starting point is usually the point of the graph with no entry.

Valid topological sorting orders
- 1,2,3,4,5,6,7,8 (Top to bottom)
- 3,2,1,4,7,6,5,8 (Bottom to top)

![](https://kalkicode.com/pixels/graph/print-a-topological-sort.png)

### Another valid order of sorting would be 
![](https://s3.ap-south-1.amazonaws.com/afteracademy-server-uploads/topological-sorting-illustration-5981c773c98e37bc.png)

## Khan's Algorithm
1. Get all the nodes with no incoming edges onto a Hashset. Then we will declare a result list that will take sorted elements.
2. While hashset is not empty
    1. Take node N from the hashset
    2. add N to the result list.
    3. For each node M that has an edge with N
        1. Remove that edge
        2. if M doesn't have any incoming edges then we are going to add M to the hashset.
3. if graph still have edges then return false
4. Return result.

![](https://github.com/Fas96/T-images-repo/blob/main/topologicalSort.png?raw=true)

Order of deletion and traversing
![](https://github.com/Fas96/T-images-repo/blob/main/topoConnection.png?raw=true)

### Examples
Leetcode 207 Course Schedule
![](https://github.com/Fas96/T-images-repo/blob/main/leetcode207.png?raw=true)

### Code Break Down
In this example we are using a table here in the form of adjacency matrix.The only case here is 
that our matrix is just about getting the last row of the matrix after all the update. so  we used
a 1-D array. 
The course requirements are the 0 index of the course. so we update to find all the course requerements.
```java
      int[] table= new int[numCourses];
    for (int[] course : prerequisites) {
      int curCourse= course[0];
      table[curCourse]++;
    }
```
### Why we need the noIncoming Edges
If the concept of Khan's algorithm is clear, Then it implies we first need to get hold
of all the nodes with no incoming edges.So we can start from any of these nodes.
```java

   Set<Integer> noIncomingEdges= new HashSet<>();
    //find elements that has no incoming edges
    for (int i = 0; i < numCourses; i++) {
      if(table[i]==0)noIncomingEdges.add(i);
    }
```
After we get our node or nodes with no incoming edges we can start from any of these nodes.
But first we need to check if there is any no incoming nodes.
If NONE EXIST it means all nodes are connected and directions are pointed from some node.
THIS IMPLIES THE GRAPH OR NODES GIVEN ARE CYCLIC.
#### NB: Topological sorting does not work with CYCLIC GRAPHS

```java
    //if set is empty that means we have cyclic graph
    if(noIncomingEdges.isEmpty())return false;
```
### Start from this Current Node
The node/nodes with no incoming edge is where we want to start.
and we keep checking if this course is same with our current no incoming 
node.If it is we just update remove the connection with current.
Until all connections to current node is removed.
### Remove me im no longer in this world.
If all the connected nodes to current node is removed then we finally remove the 
current element from the elements with no incoming edges.
so it continues until all the no Incoming nodes are done.

````java

while (!noIncomingEdges.isEmpty()){
      Iterator<Integer> it=noIncomingEdges.iterator();
      Integer element=  it.next();
      //remove the edges the current element has
      for (int course = 0; course < prerequisites.length; course++) {
        //check if prerequisite is equals to current element
        if(prerequisites[course][1]==element){
          int curCourse=prerequisites[course][0];
          //remove the incoming edges of this current course
          table[curCourse]--;
          if(table[curCourse]==0){
            noIncomingEdges.add(curCourse);
          }
        }
      }
      noIncomingEdges.remove(element);
    }
````
### After all the deletions of connected nodes
A case exist where maybe all the connected edges to a node was not able to be deleted.
It implies this course still has at least 1 connected edge or more.
 ```
return  Arrays.stream(table).allMatch(e->e<=0);
```
 
### Code

```java
 public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] table= new int[numCourses];
    for (int[] course : prerequisites) {
      int curCourse= course[0];
      table[curCourse]++;
    }
    Set<Integer> noIncomingEdges= new HashSet<>();
    //find elements that has no incoming edges
    for (int i = 0; i < numCourses; i++) {
      if(table[i]==0)noIncomingEdges.add(i);
    }
    //if set is empty that means we have cyclic graph
    if(noIncomingEdges.isEmpty())return false;

    while (!noIncomingEdges.isEmpty()){
      Iterator<Integer> it=noIncomingEdges.iterator();
      Integer element=  it.next();
      //remove the edges the current element has
      for (int course = 0; course < prerequisites.length; course++) {
        //check if prerequisite is equals to current element
        if(prerequisites[course][1]==element){
          int curCourse=prerequisites[course][0];
          //remove the incoming edges of this current course
          table[curCourse]--;
          if(table[curCourse]==0){
            noIncomingEdges.add(curCourse);
          }
        }
      }
      noIncomingEdges.remove(element);
    }

    //check if there is cycle
    for (int course :table) {
      if(course>0)return false;
    }
    return  Arrays.stream(table).allMatch(e->e<=0);
    }
```


### Source
[Tushar Roy - Coding Made Simple](https://youtu.be/ddTC4Zovtbc) <br>
[Abdul Bari](https://www.youtube.com/watch?v=XB4MIexjvY0&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=45&ab_channel=AbdulBari)<br>
[interviewcake](https://www.interviewcake.com/concept/java/topological-sort#:~:text=The%20topological%20sort%20algorithm%20takes,before%20them%20in%20the%20ordering.)