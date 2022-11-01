class PriorityQueue<T,N> {
}

function topKFrequent(words: string[], k: number): string[] {
//     List<String> result = new ArrayList<>();
//     Map<String, Integer> map = new HashMap<>();
//     for(String word : words){
//         map.put(word, map.getOrDefault(word, 0) + 1);
//     }
//
//     List<String> candidates = new ArrayList<>(map.keySet());
//     candidates.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
//
//     for(int i = 0; i < k; i++){
//         result.add(candidates.get(i));
//     }
//
//     return result;
// }

    let result: string[] = [];
    let map: Map<string, number> = new Map();
    for (let word of words) {
        map.set(word, (map.get(word) || 0) + 1);
    }
    let candidates: string[] = Array.from(map.keys());
    candidates.sort((w1, w2) => map.get(w1) == map.get(w2) ? w1.localeCompare(w2) : map.get(w2) - map.get(w1));
    for (let i = 0; i < k; i++) {
        result.push(candidates[i]);
    }
    return result;


};