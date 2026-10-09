class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map <Character, Integer> freq1 = new HashMap<>();
        Map <Character, Integer> freq2 = new HashMap<>();

        for(int i =0; i<s.length(); i++){
               char ch= s.charAt(i);
            freq1.put(ch, freq1.getOrDefault(ch, 0)+1);
        }
         for(int i =0; i<t.length(); i++){
               char ch= t.charAt(i);
            freq2.put(ch, freq2.getOrDefault(ch, 0)+1);
        }

        for(char key : freq1.keySet()){
            if(freq2.get(key)==null) return false;
           // if(freq1.get(key)!=freq2.get(key)) return false;   
            if (!freq1.get(key).equals(freq2.get(key))) {
                return false;
            }         
        }
        return true;

    }
}
