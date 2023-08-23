class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. m + n 길이의 배열 선언
        int[] nums3 = new int[m + n];

        // 2. nums3에 nums1, nums2 차례대로 병합
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        for (int i = m; i < m + n; i++) {
            nums3[i] = nums2[i - m];
        }

        // 3. nums3 오름차순 정렬
        Arrays.sort(nums3);

        // 4. nums1을 nums3로 대치
        for (int i = 0; i < nums3.length; i++) {
            nums1[i] = nums3[i];
        }
    }
}