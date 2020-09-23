package array;

import java.util.*;

public class T347_topKFrequent {

    /*
    思路一：
    hashmap + 桶排序的思路
    用hashmap统计词频，然后将词频作为下标值，把hashmap的结果放入数组中。
    从后向前遍历数组
    (注：同一个词频可能有不止一个数字，所以数组的格式要用list型的）
    时间：on
    空间：on
     */
    public int[] topKFrequent_bucket(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];
        int[] res = new int[k];
        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for (int key: map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        for (int i = list.length - 1,j = 0; i >= 0 && j < k; i--){
            if (list[i] == null) {
                continue;
            }
            for (int l = 0; l < list[i].size(); l++) {
                res[j++] = list[i].get(l);
            }
        }
        return res;
    }

    /*
    思路二：
    hashmap + 最小堆
    堆顶元素最小，如果新入的元素比堆顶大，就把堆顶元素弹出，重新调整成小顶堆


    (新知识
    java自带数据结构：
    PriorityQueue(优先队列)就是堆结构！！！！！默认最小堆
    判断大小的条件可以自己去写Comparator
    可以通过调整Comparator 成为大顶堆，或者小顶堆)
     */
    public int[] topKFrequent_heap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int n: nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key: map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
                /*
                add 和 offer 的区别
                都是插入新元素
                add 插入失败会报错
                offer 会返回false
                 */
            } else if (map.get(key) > map.get(minHeap.peek())) {
                minHeap.remove();
                minHeap.add(key);
                /*
                remove 和 poll的区别
                都是取出顶上的元素(min、max)
                remove在取不到的时候报错
                poll 会返回null
                 */
            }
        }
        int j = 0;
        while (!minHeap.isEmpty()) {
            res[j++] = minHeap.remove();
        }
        return res;
    }




}
