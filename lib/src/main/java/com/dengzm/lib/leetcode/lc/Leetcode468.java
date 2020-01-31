package com.dengzm.lib.leetcode.lc;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 验证IP地址
 * @date 2020/1/31 11:42
 */
public class Leetcode468 {
    private static final String NEITHER = "Neither";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";

    public String validIPAddress (String IP) {
        if (IP == null || IP.length() == 0) {
            return NEITHER;
        }

        if (IP.length() > 39 || IP.length() < 7) {
            return NEITHER;
        }

        if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) {
            return NEITHER;
        }

        String[] splitted;
        String result;
        if (IP.contains(".")) {
            splitted = IP.split("\\.");
            if (splitted.length != 4) {
                return NEITHER;
            }
            result = IPV4;
        } else {
            splitted = IP.split(":");
            if (splitted.length != 8) {
                return NEITHER;
            }
            result = IPV6;
        }

        for (int i = 0; i < splitted.length; i ++) {
            if (result.equals(IPV4)) {
                try {
                    int integer = Integer.parseInt(splitted[i]);
                    if (integer < 0 || integer > 255) {
                        return NEITHER;
                    }
                    if(splitted[i].length() > 1 && (splitted[i].startsWith("0") || splitted[i].startsWith("-"))) {
                        return "Neither";
                    }
                } catch (NumberFormatException  e) {
                    return NEITHER;
                }
            } else {
                try {
                    long aLong = Long.parseLong(splitted[i], 16);
                    if (aLong < 0) {
                        return NEITHER;
                    }
                    if(splitted[i].length() > 4 || splitted[i].startsWith("-")) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return NEITHER;
                }
            }
        }

        return result;
    }

    public String validIPAddress1 (String IP) {
            if (IP == null) {
                return "Neither";
            }

            // 数字 或 1-9加数字 或 1加数字加数字 或 2加0-4加数字 或 25加0-5
            String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
            String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
            // 数字/a-f/A-F 一共1-4个
            String regex1 = "([\\da-fA-F]{1,4})";
            String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

            String result = "Neither";
            if (IP.matches(regexIPv4)) {
                result = "IPv4";
            } else if (IP.matches(regexIPv6)) {
                result = "IPv6";
            }
            return result;
    }
}
