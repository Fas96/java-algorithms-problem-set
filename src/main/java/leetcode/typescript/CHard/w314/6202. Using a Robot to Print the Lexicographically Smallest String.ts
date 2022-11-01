function robotWithString(s: string):string {
    let t="";
    let i=0;
    let j=0;
    while(i<s.length){
        if(s[i]==t[j]){
            i++;
            j++;
        }else{
            t+=s[i];
            i++;
        }
    }
    return t;
}

//test
describe('robotWithString', () => {
    it('robotWithString', () => {
        expect(robotWithString("bdda")).toEqual("addb");
        expect(robotWithString("bac")).toEqual("abc");
        expect(robotWithString("zza")).toEqual("azz");
    }
    );
}
);