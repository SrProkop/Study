public class HardQuestThree {
    public static void main(String[] args) {
        String[] arrayString = new String[] {"a", "b"};
        System.out.println(longestCommonPrefix(arrayString));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return  "";
        }
        int indexShortString = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[indexShortString].length() > strs[i].length()) {
                indexShortString = i;
            }
        }
        for (int i = 0; i < strs[indexShortString].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[indexShortString].charAt(i) != strs[j].charAt(i)) {
                    if (i == 0) {
                        return "";
                    } else {
                        return strs[indexShortString].substring(0, i);
                    }
                }
            }
            if (strs[indexShortString].length() == i + 1) {
                return strs[indexShortString];
            }
        }
        return  "";
    }
}

