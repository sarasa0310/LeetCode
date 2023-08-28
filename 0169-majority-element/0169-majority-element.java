class Solution {
    public int majorityElement(int[] nums) {
        // 배열 nums에서 가장 많이 등장하는 요소 찾기
        // 가장 많이 등장하는 요소는 n / 2 이상 존재해야 한다

        // 배열 nums의 각 요소의 등장 빈도를 세어 maxCount 업데이트
        // maxCount를 업데이트 하면서 해당 요소의 인덱스 갱신

        // 1. 각 요소의 등장 빈도를 세어 줄 maxCount
        int maxCount = 0;

        // 2. maxCount가 업데이트 되는 지점의 인덱스를 담아 줄 idx
        int idx = 0;

        // 3. 이중 반복문을 통해 배열 nums를 순회하면서 maxCount 및 idx 업데이트
        for (int i = 0; i < nums.length; i++) {
            // 매번 업데이트 해야 하므로 count를 0으로 갱신
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                // 요소가 같으면 count 업데이트
                if (nums[i] == nums[j]) count++;
            }

            // maxCount 및 idx 갱신
            if (count > maxCount) {
                maxCount = count;
                idx = i;
            }
        }

        // maxCount가 업데이트 된 인덱스 요소를 반환
        return nums[idx];

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