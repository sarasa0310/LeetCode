class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. nums의 요소를 key로, 해당 요소의 인덱스를 value로 저장
        Map<Integer, Integer> map = new HashMap<>();

        // 2. nums를 순회하면서 map을 업데이트
        for (int i = 0; i < nums.length; i++) {
            // target에서 현재 인덱스의 요소를 뺀 값
            int complement = target - nums[i];
            // map에 해당 값이 있다면(즉, 더해서 target이 되므로)
            if (map.containsKey(complement)) {
                // 해당 값의 인덱스와 현재 인덱스로 이루어진 배열 반환
                return new int[]{map.get(complement), i};
            }

            // 아직 찾지 못했으므로, map에 요소와 인덱스를 저장
            map.put(nums[i], i);
        }

        // 3. 없으면 빈 배열 리턴
        return new int[]{};
    }
}