//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 480 👎 0


import java.util.*;

//Java：字母异位词分组
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null ||strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> stringListMap = new HashMap<>();
        char tempChar[];
        for(String string: strs) {
            tempChar = string.toCharArray();
            Arrays.sort(tempChar);
            String key = Arrays.toString(tempChar);
            if(!stringListMap.containsKey(key)) {
                stringListMap.put(key,new ArrayList<>());
            }
            stringListMap.get(key).add(string);
        }
        return new ArrayList<>(stringListMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}