class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        /**
        정수형 배열 nums와 정수 k가 주어졌을 때
        nums에서 k번째로 큰 값을 반환
        정렬 없이 해결
         */

        // PriorityQueue 이용하는 방법 - k번째 큰 값을 찾아야 하므로 MaxHeap 이용
        PriorityQueue<Integer> priorityQueue = 
        new PriorityQueue<>(Collections.reverseOrder());

        // priorityQueue에 nums의 값을 모두 담아준다.
        // 자동으로 최대값이 위에 올라오게 된다.
        for (int num : nums) {
            priorityQueue.add(num);
        }

        int result = 0;

        // k번째 큰 값을 찾기위해서 priorityQueue에서 최대값 추출을 k번 수행
        for (int i = 0; i < k; i++) {
            result = priorityQueue.poll();
        }

        // k번째 큰 값 반환
        return result;

        // 역순 정렬 이용방법
        // Integer[] boxedNums = Arrays.stream(nums)
        //                             .boxed()
        //                             .toArray(Integer[]::new);

        // Arrays.sort(boxedNums, Collections.reverseOrder());

        // return boxedNums[k - 1];

        // // 커스텀 Max Heap 사용
        // MaxHeap maxHeap = new MaxHeap(nums.length);

        // // maxHeap에 nums의 요소를 모두 담아준다
        // for (int num : nums) {
        //     maxHeap.insert(num);
        // }

        // int result = 0;

        // // 최대값 추출을 k번 수행한 후 결과 반환
        // for (int i = 0; i < k; i++) {
        //     result = maxHeap.extractMax();
        //     System.out.println(result);
        // }

        // return result;
    }
}

class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int size) {
        this.heap = new int[size + 1];
        this.size = 0;
        this.maxSize = size;
        heap[0] = Integer.MAX_VALUE;
    }

    public void insert(int value) {
        heap[++size] = value;
        heapifyUp(size);
    }

    public int extractMax() {
        int max = heap[1];
        heap[1] = heap[size--];
        heapifyDown(1);
        return max;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return pos * 2 + 1;
    }

    private void heapifyUp(int pos) {
        int tmp = heap[pos];

        while (pos > 0 && tmp > heap[parent(pos)]) {
            heap[pos] = heap[parent(pos)];
            pos = parent(pos);
        }

        heap[pos] = tmp;
    }

    // MaxHeap의 요건을 충족시켜주기 위해 호출하는 heapify
    private void heapifyDown(int pos) {
        // 리프 노드일 경우 종료
        if (pos >= size / 2 && pos <= size) return;

        // heapify가 필요한지 확인
        if (heap[pos] < heap[leftChild(pos)] ||
        heap[pos] < heap[rightChild(pos)]) {

            // 왼쪽 자식 노드가 더 크면
            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                // 왼쪽과 교환
                swap(pos, leftChild(pos));

                // 재귀 호출
                heapifyDown(leftChild(pos));
            } else { // 오른쪽 자식 노드가 더 크거나 같으면
                // 오른쪽과 교환
                swap(pos, rightChild(pos));

                // 재귀 호출
                heapifyDown(rightChild(pos));
            }

        }
            
    }

    // 배열 속 두 요소를 교환해주는 유틸 메서드 swap
    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

}