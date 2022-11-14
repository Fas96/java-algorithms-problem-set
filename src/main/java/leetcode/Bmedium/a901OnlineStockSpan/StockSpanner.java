package leetcode.Bmedium.a901OnlineStockSpan;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class StockSpanner {
    Stack<int[]> stocks;

    public StockSpanner() {
        stocks = new Stack<>();

    }
    public int next(int price) {
        int res = 1;
        while (!stocks.isEmpty() && stocks.peek()[0] <= price) {
            res += stocks.pop()[1];
        }
        stocks.push(new int[]{price, res});
        return res;
    }
}
