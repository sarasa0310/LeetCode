import java.util.ArrayList;

class Solution {
    public int removeElement(int[] nums, int val) {
        // val과 같지 않은 요소의 수 k
        int k = 0;

        // val과 다른 요소를 담기 위해 ArrayList 활용
        ArrayList<Integer> list = new ArrayList<>();

        // k수 세기 & ArrayList에 담기
        for (int n : nums) {
            if (n != val) {
                k++;
                list.add(n);
            }
        }

        // nums 재배치
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return k;
    }
}