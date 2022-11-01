import {numDecodings} from "./91. Decode Ways";
//test
describe('numDecodings', () => {

        it('numDecodings', () => {
            expect(numDecodings("12")).toEqual(2);
            expect(numDecodings("226")).toEqual(3);
            expect(numDecodings("0")).toEqual(0);
            expect(numDecodings("06")).toEqual(0);
        }
        );
}
);
