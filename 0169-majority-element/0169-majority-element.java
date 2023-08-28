class Solution {
    public int majorityElement(int[] nums) {
        // HashMap 사용 방법
        // nums의 요소를 key로, 등장 빈도를 value로 활용

        // 1. map 선언 및 초기화
        Map<Integer, Integer> map = new HashMap<>();

        // 2. nums를 순회하면서 map 업데이트
        for (int i = 0; i < nums.length; i++) {
            // 2-1. key가 존재하면 등장 빈도 갱신
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            }

            // 2-2. key가 없으면 생성 및 value 1 할당
            else {
                map.put(nums[i], 1);
            }

            // 2-3. n / 2 보다 많이 등장하면 리턴
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;

        // // 요소를 인덱스로 사용하고, 가장 큰 요소가 담긴 인덱스를 반환?

        // // 1. 요소를 인덱스로 쓰기 위해 가장 큰 요소를 찾기
        // int maxNum = Integer.MIN_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] > maxNum) {
        //         maxNum = nums[i];
        //     }
        // }

        // // 2. 가장 큰 요소의 크기 + 1만큼 배열 numsCount 선언
        // int[] numsCount = new int[maxNum + 1];

        // // 3. nums를 순회하면서 해당 요소의 인덱스에 빈도 추가
        // for (int i = 0; i < nums.length; i++) {
        //     numsCount[nums[i]]++;
        // }

        // System.out.println(Arrays.toString(numsCount));

        // // 4. numsCount 배열을 순회하면서 가장 큰 요소가 있는 인덱스 반환
        // int m = 0;

        // for (int i = 1; i < numsCount.length; i++) {
        //     if (numsCount[i] > numsCount[i - 1]) {
        //         m = i;
        //     }
        // }

        // return m;
    }
}