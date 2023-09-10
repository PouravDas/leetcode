package com.leetcode.easy.commonPrefix;

//14
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = null;
        for(String s : strs) {
            common = findCommon(common, s);
        }
        return common;
    }
    
    private String findCommon(String s1, String s2) {
        if(s1 == null)
            return s2;
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) 
            	ans.append(s1.charAt(i));
            else
            	break;
        }
        return ans.toString();
    }
}
