import java.util.Arrays;

public class KMP {
    public int[] getNext(String t) {
        int[] next = new int[t.length()];
        int j = 0;//用来依次遍历模式串
        next[0] = 0;

        for (int i = 1; i < t.length(); i++) {
            //前后缀不想等,让j回退到相等的位置或者起点,即前缀长度减少
            while (j >= 1 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            //如果回退完成,i,j相等那么有相等前后缀,长度j+ 1,0到j的区间就是相等前后缀的前缀
            //然后j往后走j++,继续找下一个i的相等前后缀;
            //如果不相等,那么说明没有相等的前后缀,置于0即可
            if (t.charAt(i) == t.charAt(j)) {
                j++;
                next[i] = j;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    public int kmp(String s, String t) {
        if (s.length() < t.length()) {
            return -1;
        }
        int[] next = getNext(t);

        int j = 0;
        //让i不断向后移动
        for (int i = 0; i < s.length(); i++) {
            //如果不相等就回退,回退一次即可
            if (j >= 1 && s.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
            //如果想等就向后移动
            if (s.charAt(i) == t.charAt(j)) {
                j++;//i++在for循环里面
            }
            //j到了模式串的末尾,说明匹配成功,返回在目标串中的位置
            if (j == t.length()) {
                return i - t.length() + 1;//当j指向模式串的末尾时,i还没有++;
            }
        }
        //目标串遍历完,j都没有 到模式串的末尾说明匹配不会成功,目标串中没有模式串
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        int[] next = kmp.getNext("aabaaf");
        System.out.println(Arrays.toString(next));
        System.out.println(kmp.kmp("aabaabaababaaf","aabaaf"));
    }
}
