
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue <String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
      
        if(!set.contains(endWord)) return 0;
        queue.offer(beginWord);
        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                String word = queue.poll();
                if(word.equals(endWord))
                    return steps;
                char[] arr = word.toCharArray();
                for(int j=0; j<arr.length; j++){
                    char original = arr[j];
                 for(char c = 'a'; c<='z'; c++){
                     if(c==original)
                        continue;
                     arr[j] = c;
                     String next = new String(arr);
                     if(set.contains(next)){
                        queue.offer(next);
                        set.remove(next);
                     }
                 }
                 arr[j] = original;
                }
            }
           steps++;
        }
        return 0;
    }
}
