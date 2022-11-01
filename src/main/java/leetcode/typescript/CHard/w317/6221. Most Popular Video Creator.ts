

function mostPopularCreator(creators: string[], ids: string[], views: number[]): string[][] {
    let result = [];
    let map = new Map();
    //map creater,smallest id,views sum
    for (let i = 0; i < creators.length; i++) {
        let creator = creators[i];
        let id = ids[i];
        let view = views[i];
        if (!map.has(creator)) {
            map.set(creator, [id, view]);
        } else {
            let [id2, view2] = map.get(creator);
            if (id < id2) {
                map.set(creator, [id, view]);
            } else if (id === id2) {
                map.set(creator, [id, view + view2]);
            }
        }
    }
    let max = 0;
    for (let [key, value] of map) {
        let [id, view] = value;
        max = Math.max(max, view);
    }
    for (let [key, value] of map) {
        let [id, view] = value;
        if (view === max) {
            result.push([key, id]);
        }
    }
    return result;



};