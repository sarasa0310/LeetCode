import java.util.ArrayList;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. m + n 길이의 배열 선언
        ArrayList<Integer> list = new ArrayList<>();

        // 2. nums3에 nums1, nums2 차례대로 병합
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }

        // 3. nums3 오름차순 정렬
        Collections.sort(list);

        // 4. nums1을 nums3로 대치
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }
}