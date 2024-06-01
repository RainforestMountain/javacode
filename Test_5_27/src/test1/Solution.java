package test1;

public class Solution {
    public boolean isUnique(String astr) {
        //位图
        if (astr.length() > 26) {
            return false;
        }
        int tmp = 0;
        for (int i = 0; i < astr.length(); i++) {
            //判断是否出现了两次,当前比特位是0还是1, 0没有出现,1出现一次
            if (((tmp >> (astr.charAt(i) - 'a')) & 1) == 1) {
                return false;
            }
            //是0,修改成1
            tmp = tmp | (1 << (astr.charAt(i) - 'a'));
        }
        return true;
    }
}
