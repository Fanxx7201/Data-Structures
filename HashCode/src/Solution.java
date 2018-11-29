/**
 * @ProjectName: HashTable
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description: leetcode问题: 给定一个字符串, 找到他第一个不重复的字符, 并返回它的索引, 如果不存在, 返回-1
 * @Author: fanxx
 * @CreateDate: 2018/11/28 16:51
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Solution {

    public int firstUniqueChar(String s){

        int[] freq = new int[26];

        //遍历字符串
        for (int i = 0; i < s.length() ; i++){
            //s.charAt(i) -- > 拿到字符串的一个字符, 得到他的ASCII码, 减去a的ASCII
            //就相当于将a...z 这26个字母映射到了0...25这样26个索引.
            freq[s.charAt(i) - 'a'] ++;
        }

        //再次遍历字符串, 每一次看一下我们遍历到的字符, 他所对应的频率值, 是否等于1.
        for(int i = 0; i < s.length(); i ++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i; //如果没有索引等于1 , 说明没有字母是重复出现的. return -1
            }
        }
        return -1;
    }

}
