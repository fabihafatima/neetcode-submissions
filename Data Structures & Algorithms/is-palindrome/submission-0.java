class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char ch1 = Character.toLowerCase(s.charAt(left));
            char ch2 = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetterOrDigit(ch1)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(ch2)) {
                right--;
                continue;
            }

            if (ch1 != ch2) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}