class Solution {
    public int maxProfit(int[] prices) {
        /*
        최대 수익 리턴
        수익을 얻지 못한다면, 0 리턴 -> 브루트 포스 시간 한도 초과 O(n*n), 더 나은 방법 찾기
        */

        // 카데인 알고리즘? O(n)

        // 1. 최대 수익 maxProfit 및 최소 가격을 기억하기 위한 minPrice

        int maxProfit = 0; // 수익이 없을 수 있으므로 0으로 초기화
        int minPrice = prices[0]; // 첫번째 가격으로 초기화

        // 2. 배열 prices를 순회하면서 maxProfit 및 minPrice 업데이트

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        // 3. maxProfit 리턴
        return maxProfit;
    }
}