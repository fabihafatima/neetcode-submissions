class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int start = 0, end = list.size() - 1;
        String result = "";

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
