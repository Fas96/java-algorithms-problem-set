 import {maxSumMinProduct} from "./1856. Maximum Subarray Min-Product";

describe("1856. Maximum Subarray Min-Product", () => {
    it("maxSumMinProduct", () => {
        expect(maxSumMinProduct([1,2,3,2])).toEqual(14);
        expect(maxSumMinProduct([2,3,3,1,2])).toEqual(18);
        expect(maxSumMinProduct([3,1,5,6,4,2])).toEqual(60);
    });
})