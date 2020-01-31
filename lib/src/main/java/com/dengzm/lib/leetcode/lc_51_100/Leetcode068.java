package com.dengzm.lib.leetcode.lc_51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 文本左右对齐
 * @date 2020/1/28 19:49
 */
public class Leetcode068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return result;
        }

        int startIndex = 0;
        int endIndex = 0;
        int curLength = 0;

        while (startIndex < words.length) {

            while (curLength < maxWidth && endIndex <= words.length - 1) {
                if (curLength + words[endIndex].length() > maxWidth) {
                    break;
                }

                curLength += words[endIndex].length() + 1;
                endIndex ++;
            }

            endIndex --;

            int leftSpaces = maxWidth;
            for (int i = startIndex; i <= endIndex; i ++) {
                leftSpaces -= words[i].length();
            }

            StringBuilder sb = new StringBuilder();
            if (endIndex == startIndex){
                sb.append(words[endIndex]);
                if (leftSpaces > 0) {
                    for (int i = 0; i < leftSpaces; i ++) {
                        sb.append(" ");
                    }
                }
            } else {
                if (endIndex == words.length - 1) { // 最后一行 左对齐
                    for (int i = startIndex; i < endIndex; i ++) {
                        sb.append(words[i]);
                        sb.append(" ");
                        leftSpaces --;
                    }

                    sb.append(words[endIndex]);

                    while (leftSpaces > 0) {
                        sb.append(" ");
                        leftSpaces --;
                    }
                } else {
                    int averSplit = leftSpaces / (endIndex - startIndex);
                    int left = leftSpaces % (endIndex - startIndex);

                    for (int i = startIndex; i < endIndex; i ++) {
                        sb.append(words[i]);

                        int l = averSplit;
                        if (left > 0) {
                            l ++;
                            left --;
                        }

                        for (int j = 0; j < l; j ++) {
                            sb.append(" ");
                        }
                    }

                    sb.append(words[endIndex]);
                }
            }

            result.add(sb.toString());

            startIndex = endIndex + 1;
            endIndex = startIndex;
            curLength = 0;
        }

        return result;
    }
}
