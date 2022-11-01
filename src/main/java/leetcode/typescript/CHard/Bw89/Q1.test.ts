import {countTime} from './Q1';
describe('Q1', function () {
    it('countTime', function () {
        expect(countTime("??:??")).toEqual(1440);
        expect(countTime("0?:0?")).toEqual(100);
    });
})