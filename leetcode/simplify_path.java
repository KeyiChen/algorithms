public class Solution {
    public String simplifyPath(String path) {
        StringBuffer tokens = new StringBuffer("");
        StringBuffer result = new StringBuffer("");
        
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                tokens.append(path.charAt(i));
                if (i < path.length() - 1) continue;
            }
            
            if (tokens.toString().equals("..")) {
                while (result.length() > 0 && result.charAt(result.length() - 1) != '/') result.deleteCharAt(result.length() - 1);
                if (result.length() > 0) result.deleteCharAt(result.length() - 1);
            }
            else if (!tokens.toString().equals(".") && tokens.length() > 0)
                result.append('/').append(tokens);
            
            while (tokens.length() > 0) tokens.deleteCharAt(0);
        }
        
        if (result.length() == 0) result.append('/');

        return result.toString();
    }
}
