

function getLengthOfOptimalCompression(s: string, k: number): number {
    let map = new Map();
    for(let i=0;i<s.length;i++){
        if(map.has(s[i])){
            map.set(s[i],map.get(s[i])+1);
        }else{
            map.set(s[i],1);
        }
    }
    //sort the map by decending frequency
    // @ts-ignore
    let sortedMap = new Map([...map.entries()].sort((a,b)=>b[1]-a[1]));

    let rle = "";
    // @ts-ignore
    for(let [key,value] of sortedMap){
        if(value>1)rle+=(key+""+value);
        else rle+=(key);
    }
   // get characters in the rle string, and the numbers that follow them as map
    let rleMap = new Map();
    let i=0;
    while(i<rle.length){
        let char = rle[i];
        let num = "";
        i++;
        while(i<rle.length&&rle[i]>='0'&&rle[i]<='9'){
            num+=rle[i];
            i++;
        }

        if(num=="")num="1";

        rleMap.set(char,parseInt(num));
    }

    //sort sortedRleMap by their value digits count and ascending frequency
    // @ts-ignore
    let sortedRleMap = new Map([...rleMap.entries()].sort((a,b)=>a[1]-b[1]));
    // @ts-ignore
    sortedRleMap = new Map([...sortedRleMap.entries()].sort((a,b)=>(a[1]+"").length-(b[1]+"").length));
    //remove k times from the sortedRleMap map
    for(let i=0;i<k;i++){
        let [key,value] = sortedRleMap.entries().next().value;
        if(value==1){
            sortedRleMap.delete(key);
        }else{
            sortedRleMap.set(key,value-1);
        }
    }
    let count = 0;
    // @ts-ignore
    for(let [key,value] of sortedRleMap){
        count++;
        if(value>1){
            count+=value.toString().length;
        }
    }
    return count;

};