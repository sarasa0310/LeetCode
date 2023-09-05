class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
        - 정수형 배열 nums에서
        - 인덱스 i와 j의 요소 값이 같으면서,
        - 인덱스 i에서 j를 뺐을 때 절대값이 k보다 작거나 같다면 true를 리턴
         */

         // HashMap을 활용
         // key는 nums의 요소, value는 해당 요소의 인덱스로 저장
         Map<Integer, Integer> map = new HashMap<>();

         // nums 배열을 1차원 순회
         for (int i = 0; i < nums.length; i++) {
             // 요소가 이미 key로 등록되어 있으면,
             if (map.containsKey(nums[i])) {
                 // 인덱스를 뺐을 때 절대값이 k보다 작거나 같다면 ture 리턴
                 if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                 } else { // 새로운 인덱스로 업데이트
                    map.put(nums[i], i);
                 }
             } else { // 아직 요소가 key로 등록되어 있지 않다면
                map.put(nums[i], i); // 요소를 key로, 인덱스를 value로 추가
             }
         }

         // 없으면 false 리턴
         return false;

         // 이중 반복문 -> 시간 초과 O(n * n)
        //  for (int i = 0; i < nums.length; i++) {
        //      for (int j = i + 1; j < nums.length; j++) {
        //          if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
        //              return true;
        //          }
        //      }
        //  }
        //  return false;
    }
}