class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int needed = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.getOrDefault(c, 0) > 0) {
                needed--;
            }

            map.put(c, map.getOrDefault(c, 0) - 1);

            while (needed == 0) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                if (map.get(leftChar) > 0) {
                    needed++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
