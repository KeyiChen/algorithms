public class Solution {
    public boolean isMatch(String s, String p) {
        assert(s != null && p != null);
        int is = 0, ip = 0;
        int lens = s.length(), lenp = p.length();
        int lastStar = -1, lastChar = -1;
        
        while (is < lens) {
            if (ip < lenp && (p.charAt(ip) == '?' || p.charAt(ip) == s.charAt(is))) {
                ip ++;
                is ++;
                continue;
            } else if (ip < lenp && p.charAt(ip) == '*') {
                while (ip < lenp && p.charAt(ip) == '*') ip++;
                if (ip == lenp) return true;
                lastStar = ip;
                lastChar = is;
                continue;
            } else if (ip == lenp || p.charAt(ip) != s.charAt(is)) {
                if (lastStar == -1) return false;
                ip = lastStar;
                is = (++lastChar);
            } else return false;
        }
        
        while (ip < lenp && p.charAt(ip) == '*') ip++;
        
        return ip == lenp;
    }
}

