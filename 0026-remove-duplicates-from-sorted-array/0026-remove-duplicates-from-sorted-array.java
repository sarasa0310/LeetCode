class Solution {
    public int removeDuplicates(int[] nums) {
        // two-pointer 전략
        // k를 인덱스로 활용
        int k = 1;

        // 2번째 요소부터 nums 전체 순회
        for (int i = 1; i < nums.length; i++) {
            // 오름차순 정렬되어 있기 때문에 바로 이전 요소랑만 비교해주면 됨
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}