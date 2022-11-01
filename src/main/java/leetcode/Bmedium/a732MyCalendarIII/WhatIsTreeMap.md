## What is TreeMap in Java

<b>TreeMap</b> is a <b>sorted map</b> implementation based on a <b>red-black tree</b>. The elements are <b>sorted by their keys</b>, which are inserted into the map using the put() method or can be specified in the constructor.
The map is <b>sorted according to the natural ordering of its keys</b>, or <b>by a Comparator</b> provided at map creation time, depending on which constructor is used.

![](https://ivoanjo.me/img/broken-tree-animation.gif)

### So what is red-black tree?

A <b>red-black tree</b> is a <b>self-balancing binary search tree</b> where each node has an extra bit, and that bit is often interpreted as the <b>color</b> (red or black) of the node. 
These color bits are used to ensure the tree remains <b>approximately balanced</b> during insertions and deletions.
There is a <b>perfect balance</b> when all the leaves are at the same level, and there is no empty space between the leaves.
In, this post, our focus is on <b>TreeMap</b> and <b>TreeSet</b> and not on <b>Tree</b> itself.

### Thread Safety in TreeMap

TreeMap is <b>not thread-safe</b>. If multiple threads access a TreeMap concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally. (A structural modification is any operation that adds or deletes one or more mappings; merely changing the value associated with a key that an instance already contains is not a structural modification.)
This is typically accomplished by synchronizing on some object that naturally encapsulates the map.
[Read More on the safety...](https://ivoanjo.me/blog/2018/07/21/writing-to-a-java-treemap-concurrently-can-lead-to-an-infinite-loop-during-reads/)

### TreeMap vs HashMap

HashMap is <b>not sorted</b> while TreeMap is <b>sorted</b> by keys. TreeMap is <b>slower</b> than HashMap because it has to keep the elements in sorted order. TreeMap is <b>not thread-safe</b> while HashMap is <b>thread-safe</b>. HashMap allows one null key and any number of null values while TreeMap doesn't allow any null keys or values.

## How to use TreeMap in Java

### Create TreeMap

```java
TreeMap<String, Integer> map = new TreeMap<>();
```

### Add elements to TreeMap

```java
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);
```

### Initialize TreeMap Comparator

```java
TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
});
```

#### Comparator test case

```java
@Test
public void treeComparatoTest() {
    TreeMap<Integer, String> mp =new TreeMap<>(Comparator.reverseOrder());
    mp.put(1, "fas based");
    mp.put(5, "fas three");
    mp.put(4, "fas fix");
    mp.put(3, "fas abc");
    mp.put(2, "fas learning");
    assertEquals("[5, 4, 3, 2, 1]", mp.keySet().toString());
}
```
This indicates we use all forms of the <b>compareTo()</b> method to compare the keys in the map like priority queue.

### Common TreeMap Methods


| Method | Description |
| --- | --- |
| <b>clear()</b> | Removes all of the mappings from this map. |
| <b>containsKey(Object key)</b> | Returns true if this map contains a mapping for the specified key. |
| <b>containsValue(Object value)</b> | Returns true if this map maps one or more keys to the specified value. |
| <b>entrySet()</b> | Returns a Set view of the mappings contained in this map. |
| <b>firstKey()</b> | Returns the first (lowest) key currently in this map. |
| <b>get(Object key)</b> | Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key. |
| <b>headMap(K toKey)</b> | Returns a view of the portion of this map whose keys are strictly less than toKey. |
| <b>isEmpty()</b> | Returns true if this map contains no key-value mappings. |
| <b>keySet()</b> | Returns a Set view of the keys contained in this map. |
| <b>lastKey()</b> | Returns the last (highest) key currently in this map. |
| <b>put(K key, V value)</b> | Associates the specified value with the specified key in this map. |
| <b>remove(Object key)</b> | Removes the mapping for the specified key from this map if present. |
| <b>size()</b> | Returns the number of key-value mappings in this map. |
| <b>subMap(K fromKey, K toKey)</b> | Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive. |
| <b>tailMap(K fromKey)</b> | Returns a view of the portion of this map whose keys are greater than or equal to fromKey. |
| <b>values()</b> | Returns a Collection view of the values contained in this map. |


### Problem Solving With TreeMap

#### 1. [My Calendar III](https://leetcode.com/problems/my-calendar-iii/)
k-booking between all the previous events. Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

### Solution 1 with No TreeMap
In this case, we generate the times for our interval checks.From the start point we add 1 and from the end point we subtract 1. We then iterate through the times and keep a running total of the number of events. If the running total is greater than k, we return false. If we reach the end of the times array, we return true.

```java
        int[] time; 
        public MyCalendarThree() {
            time = new int[1000001];
        }

        public int book(int start, int end) {
            time[start]++;
            time[end]--;
            int res = 0, cur = 0;
            for (int i = 0; i < 1000001; i++) {
                cur += time[i];
                res = Math.max(res, cur);
            }
            return res;
        }

```

### Solution 2 with TreeMap
In this case, we use a TreeMap to keep track of the number of events at each time. We then iterate through the TreeMap and keep a running total of the number of events. If the running total is greater than k, we return false. If we reach the end of the TreeMap, we return true.

```java
class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0, max = 0;
        for (int v : map.values()) {
            count += v;
            max = Math.max(max, count);
        }
        return max;
    }
}
```
### book method explanation

```java
map.put(start, map.getOrDefault(start, 0) + 1);
map.put(end, map.getOrDefault(end, 0) - 1);
```
we put the first and the end time into our tree map. The value of the start time is 1 and the value of the end time is -1. This is because we want to know how many events are happening at a certain time. If the value is 1, it means that there is an event starting at that time. If the value is -1, it means that there is an event ending at that time. If the value is 0, it means that there is no event happening at that time.

```java
int count = 0, max = 0;
for (int v : map.values()) {
    count += v;
    max = Math.max(max, count);
}
```
We use a for loop to iterate through all the values in the map. We use a variable count to keep track of the number of events happening at a certain time. We use a variable max to keep track of the maximum number of events happening at a certain time. We update the count and max at each time.

### Why we used TreeMap

We used tree map because we know the order of start and end times in the input. We can use a tree map to keep track of the number of events happening at a certain time. We can use a tree map to keep track of the maximum number of events happening at a certain time.


### References

* [TreeMap](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)
* [TreeMap in Java](https://www.geeksforgeeks.org/treemap-in-java-with-examples/)
* [TreeMap in Java](https://www.baeldung.com/java-treemap)
* [TreeMap Not ThreadSafe](https://ivoanjo.me/blog/2018/07/21/writing-to-a-java-treemap-concurrently-can-lead-to-an-infinite-loop-during-reads/)