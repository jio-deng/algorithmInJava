package com.dengzm.lib.leetcode.lc_501_600;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description TinyURL 的加密与解密
 * @date 2020/6/11 10:19
 */
public class Leetcode535 {
    public class Codec {
        Map<String, String> map = new HashMap<>();
        static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        static final String TINYURL_PREFIX = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            char[] chars = new char[6];
            for (int i = 0; i < 6; i ++) {
                chars[i] = INDEX.charAt((int) (Math.random() * 62));
            }
            String res = TINYURL_PREFIX + String.valueOf(chars);
            map.put(res, longUrl);
            return res;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
