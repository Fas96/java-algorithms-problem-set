import isMatch from "./c10RegularExpressionMatching";


describe('isMatch', () => {
    it('isMatch', () => {
        expect(isMatch("aa","a")).toEqual(false);
        expect(isMatch("aa","a*")).toEqual(true);
        expect(isMatch("ab",".*")).toEqual(true);
        expect(isMatch("aab","c*a*b")).toEqual(true);
        expect(isMatch("mississippi","mis*is*p*.")).toEqual(false);
    });
});

