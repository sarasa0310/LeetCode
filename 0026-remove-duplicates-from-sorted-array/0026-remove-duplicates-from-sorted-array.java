import java.util.ArrayList;

class Solution {
    public int removeDuplicates(int[] nums) {
        // 고유한 요소를 담기 위해 ArrayList 사용
        ArrayList<Integer> list = new ArrayList<>();

        // nums의 고유한 요소 수 k
        int k = 0;

        // nums를 전체 순회하면서 list에 없으면 list에 채워준다
        for (int n : nums) {
            if (!list.contains(n)) {
                list.add(n);
                k++;
            }
        }

        // nums 재배치
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; nums.length; j++) {
        //         // nums[k] 재배치 when? 중복 요소가 없을 때
                
        //     }
        // }

        return k;
    }
}