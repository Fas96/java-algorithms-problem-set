// class TrieNode:
// def __init__(self):
// self.child = defaultdict(TrieNode)
// self.deleted = False
// def addWord(self, word):
// curr = self
// for c in word: curr = curr.child[c]
//
// class Solution:
// def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
// def serialize(root, seen):
// if not root.child: return ""
// keys = []
// for c, child in root.child.items():
// keys.append(c + ":" + serialize(child, seen))
// key = "(" + "".join(keys) + ")"
// seen[key].append(root)
// return key
//
// def dfsGetValidPaths(root, path, out):
// for c, child in root.child.items():
// if not child.deleted:
// out.append(path + [c])
// dfsGetValidPaths(child, path + [c], out)
//
// trieRoot, seen = TrieNode(), defaultdict(list)
// # Create graph
// for path in sorted(paths):  # Sort paths to get correct orders of children of a subtree
// trieRoot.addWord(path)
//
// # Find duplicated subtrees
// serialize(trieRoot, seen)
//
// # Mark duplicated subtree nodes as deleted
// for nodes in seen.values():
// if len(nodes) >= 2:
// for node in nodes:  # Mark duplicated subtrees as deleted
// node.deleted = True
//
// ans = []
// dfsGetValidPaths(trieRoot, [], ans)
// return ans


class TrieNode {
    child = new Map();
    deleted = false;
    addWord(word) {
        let curr = this;
        for (let c of word) {
            if (!curr.child.has(c)) {
                curr.child.set(c, new TrieNode());
            }
            curr = curr.child.get(c);
        }
    }
}
function serialize(root, seen) {
    if (!root.child.size) return "";
    let keys = [];
    for (let [c, child] of root.child) {
        keys.unshift(c + ":" + serialize(child, seen));
        keys.push(c + ":" + serialize(child, seen));
    }
    let key = "(" + keys.join("") + ")";
    seen[key].push(root);
    return key;
}
function dfsGetValidPaths(root, path, out) {
    for (let [c, child] of root.child) {
        if (!child.deleted) {
            out.push(path.concat(c));
            dfsGetValidPaths(child, path.concat(c), out);
        }
    }
}

function deleteDuplicateFolder(paths: string[][]): string[][] {



    let trieRoot = new TrieNode();
    let seen = new Map();

    for (let path of paths.sort()) {
        trieRoot.addWord(path);
    }

    serialize(trieRoot, seen);


    // @ts-ignore
    for (let nodes of seen.values()) {
        if (nodes.length >= 2) {
            for (let node of nodes) {
                node.deleted = true;
            }
        }
    }

    let ans = [];

    dfsGetValidPaths(trieRoot, [], ans);

    return ans;



};