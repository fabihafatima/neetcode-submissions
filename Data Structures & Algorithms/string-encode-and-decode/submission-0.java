class Solution {

    public String encode(List<String> strs) {
            String en = "";
            for (String s: strs){
                en = en + s.length() + "#" + s;
            }
            System.out.println(en);
            return en;
    }

    public List<String> decode(String str) {
       List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}

