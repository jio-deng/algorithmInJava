package com.dengzm.lib.leetcode.lc_1_100;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 有效数字
 * @date 2020/1/25 11:34
 */
public class Leetcode065 {
    /**
     *
     * 状态机真的顶
     *
     * state	blank	+/-	  0-9	.	  e	   other
     * 0	      0	     1	  6	    2	  -1	-1
     * 1	      -1	-1	  6	    2	  -1	-1
     * 2	      -1	-1	  3	    -1	  -1	-1
     * 3	      8	    -1	  3	    -1	  4	    -1
     * 4	      -1	7	  5	    -1	  -1	-1
     * 5	      8	    -1	  5	    -1	  -1	-1
     * 6	      8	    -1	  6	    3	  4	    -1
     * 7	      -1	-1	  5	    -1	  -1	-1
     * 8	      8	    -1	  -1	-1	  -1	-1
     *
     * 作者：user8973
     * 链接：https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
            {-1,-1, 6, 2,-1},
            {-1,-1, 3,-1,-1},
            { 8,-1, 3,-1, 4},
            {-1, 7, 5,-1,-1},
            { 8,-1, 5,-1,-1},
            { 8,-1, 6, 3, 4},
            {-1,-1, 5,-1,-1},
            { 8,-1,-1,-1,-1}};

    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;

        char[] ss = s.toCharArray();
        for (int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
//        return (finals & (1 << state)) > 0; // TODO:没看懂。。

        return state == 3 || state == 5 || state == 6 || state == 8;
    }
}
