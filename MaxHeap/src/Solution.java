import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @ProjectName: MaxHeap
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/27 14:35
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Solution {
    //频次信息的内部类
    private class Freq implements Comparable<Freq>{
        //e : 元素, freq : 频次
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq){
                //当前元素如果频次低, 返回1, 也就是优先级比较高.
                return 1;
            }
            else if(this.freq > another.freq){
                return -1;
            }
            else {
                //两个元素频次相等.
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k){
        //首先对数组中元素出现的频次进行统计-->使用treeMap实现
        //第一个integer是元素, 第二个integer是频次.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums){ //遍历元素
            //如果map中含有这个元素, 就给元素出现频次+1
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                //如果map中没有这个元素, 就给这个元素赋初始值1
                map.put(num, 1);
            }

        }

        //PriorityQueue中元素的类型一定要是可比较的.
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        //遍历映射
        for(int key: map.keySet()){
            if(pq.getSize() < k){ //还没有存够k个元素
                pq.enqueue(new Freq(key, map.get(key)));
            }else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }
}
