//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 541 👎 0


import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：前 K 个高频元素
public class P347TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if(nums == null) {
                return new int[0];
            }
            Map<Integer,Integer> numTimesMap = new HashMap<>();
            for(int num: nums) {
                if(!numTimesMap.containsKey(num)) {
                    numTimesMap.put(num,1);
                    continue;
                }
                numTimesMap.put(num,numTimesMap.get(num) + 1);
            }
            PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            for(Map.Entry<Integer,Integer> entry: numTimesMap.entrySet()) {
                if(priorityQueue.size() == k && entry.getValue() > priorityQueue.peek().getValue()) {
                    priorityQueue.remove();
                    priorityQueue.offer(new Pair<>(entry.getKey(),entry.getValue()));
                }else{
                    priorityQueue.offer(new Pair<>(entry.getKey(),entry.getValue()));
                }
            }
            int[] result = new int[k];
            for(int i = 0; i < k; i ++) {
                result[i] = priorityQueue.poll().getKey();
            }
            return result;
        }

//leetcode submit region end(Prohibit modification and deletion
}}