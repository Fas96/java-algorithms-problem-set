// function findWords(board: string[][], words: string[]): string[] {
//     const charIndicesMap = new Map<string, { y: number; x: number; }[]>()
//     const rows = board.length;
//     const cols = board[0].length;
//
//     const boardSet = board.reduce((set, row, y) => {
//         for (let x = 0; x< row.length; x++) {
//             const c = board[y][x]
//             const charMap = charIndicesMap.get(c);
//             set.add(c);
//             charIndicesMap.set(c, charMap ? [...charMap, { y, x }] : [{ y, x }])
//         }
//         return set
//     }, new Set());
//
//
//
//     const canForm = ({y, x }, wordIdx, word): boolean => {
//         if (wordIdx === word.length) return false;
//         if (board[y][x] != word[wordIdx]) return false;
//         if (wordIdx + 1 === word.length) return true;
//
//         const temp = board[y][x];
//         board[y][x] = '_'
//
//         if (
//             (y - 1 >= 0 && canForm({ y: y - 1, x }, wordIdx + 1, word)) ||
//             (x -1 >= 0 && canForm({ y, x: x - 1 }, wordIdx + 1, word)) ||
//             (x + 1 < cols && canForm({ y, x: x + 1 }, wordIdx + 1, word)) ||
//             (y + 1 < rows && canForm({ y: y + 1, x }, wordIdx + 1, word))
//         ) {
//             board[y][x] = temp;
//             return true
//         }
//
//         board[y][x] = temp;
//         return false;
//     };
//
//
//     return words.reduce((acc: string[], word: string) => {
//         const firstIndices = charIndicesMap.get(word[0]);
//
//         if (
//             word.split('').every((c) => boardSet.has(c)) &&
//             firstIndices.some(idx => canForm(idx, 0, word) )
//         ) {
//             acc.push(word);
//         }
//         return acc;
//     }, []);
// };

function findWords(board: string[][], words: string[]): string[]{

    const rows = board.length;
    const cols = board[0].length;
    const charIndicesMap = new Map<string, { y: number; x: number; }[]>()
    const boardSet = board.reduce((set, row, y) => {
        for (let x = 0; x< row.length; x++) {
            const c = board[y][x]
            const charMap = charIndicesMap.get(c);
            set.add(c);
            charIndicesMap.set(c, charMap ? [...charMap, { y, x }] : [{ y, x }])
        }
        return set
    }, new Set());

    const canForm = ({y, x }, wordIdx, word): boolean => {
        if (wordIdx === word.length) return false;
        if (board[y][x] != word[wordIdx]) return false;
        if (wordIdx + 1 === word.length) return true;

        const temp = board[y][x];
        board[y][x] = '_'

        if (
            (y - 1 >= 0 && canForm({ y: y - 1, x }, wordIdx + 1, word)) ||
            (x -1 >= 0 && canForm({ y, x: x - 1 }, wordIdx + 1, word)) ||
            (x + 1 < cols && canForm({ y, x: x + 1 }, wordIdx + 1, word)) ||
            (y + 1 < rows && canForm({ y: y + 1, x }, wordIdx + 1, word))
        ) {
            board[y][x] = temp;
            return true
        }

        board[y][x] = temp;
        return false;
    };

    return words.reduce((acc: string[], word: string) => {
        const firstIndices = charIndicesMap.get(word[0]);

        if (
            word.split('').every((c) => boardSet.has(c)) &&
            firstIndices.some(idx => canForm(idx, 0, word) )
        ) {
            acc.push(word);
        }
        return acc;
    }, []);


};