class Solution {
    public int majorityElement(int[] nums) {
        // 배열 nums에서 가장 많이 등장하는 요소 찾기
        // 가장 많이 등장하는 요소는 n / 2 이상 존재해야 한다

        // naive 이중 반복문 
        int maxCount = 0;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        return nums[index];

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