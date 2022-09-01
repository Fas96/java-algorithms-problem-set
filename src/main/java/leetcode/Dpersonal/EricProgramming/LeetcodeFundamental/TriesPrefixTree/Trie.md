

### Trie Insertion

Initialize: cur=root;
for each char c in target string S:
    if cur does not have a child c:
        cur.children[c]=new Trie Node
     cur=cur.children[c]
cur is the node which represents the string S


## Trie Search

Initialize: cur= root
for each char c in target string S:
    if cur does not have  a child c:
        search fails
    cur=cur.children[c]
search successes