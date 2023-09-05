class Solution {
    public int searchInsert(int[] nums, int target) {
        /**
        - 고유한 정수로 구성된 정렬된 배열
        - 타겟을 찾으면 해당 인덱스를 반환
        - 그렇지 않다면, 정렬 순서 상 삽입되어야 할 인덱스를 반환
         */

         // 1. 왼쪽, 오른쪽 포인터 선언 및 초기화
         int left = 0; // 첫 인덱스
         int right = nums.length - 1; // 마지막 요소 인덱스

         // 2. 포인터가 교차될 때까지 반복
         while (left <= right) {
            int mid = (left + right) / 2; // 중위 인덱스

            if (nums[mid] < target) {
               left = mid + 1; // 왼쪽 포인터 갱신
            } else if (nums[mid] > target) {
               right = mid - 1; // 오른쪽 포인터 갱신
            } else { // nums[mid] == target
               return mid; // 해당 인덱스 반환
            }
         }

         // 3. target을 찾지 못했을 때 적절한 삽입 인덱스는 left
         return left;
    }
}