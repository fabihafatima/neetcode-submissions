class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map <String, List<String>> words = new HashMap<>();
       for(String curr : strs){
            char[]ch = curr.toCharArray();
            int count[] = new int[26];
            for(int i = 0; i < ch.length; i++){
                count[ch[i]-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int i =0; i< count.length; i++){
                key.append(count[i]);
                key.append("#");
            }
            String k = key.toString();
            words.putIfAbsent(k, new ArrayList());
            words.get(k).add(curr);
       }
        return new ArrayList<>(words.values());
    }
   
}
