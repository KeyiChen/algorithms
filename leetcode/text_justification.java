public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        int begin = 0, len = 0;
        List<String> result = new ArrayList<String>();
        String line = null;

        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() + i - begin > L) {
                line = makeALine(begin, i - 1, words, len, L, false);
                result.add(line);
                len = 0;
                begin = i;
            }
            len = len + words[i].length();
        }
        line = makeALine(begin, words.length - 1, words, len, L, true);
        result.add(line);
        
        return result;
    }
    
    private String makeALine(int begin, int end, String[] words, int len, int l, boolean lastLine) {
        StringBuffer result = new StringBuffer("");
        int num = end - begin + 1;
        int spaces = l - len;

        for (int i = begin; i < end; i++) {
            result.append(words[i]);
            int gap = lastLine ? 1 : ((i - begin) < (spaces % (num - 1)) ? spaces / (num - 1) + 1: spaces / (num - 1));
            for (int j = 0; j < gap; j++) result.append(' ');
        }
        result.append(words[end]);
        while (result.length() < l) result.append(' ');

        return result.toString();
    }
}

