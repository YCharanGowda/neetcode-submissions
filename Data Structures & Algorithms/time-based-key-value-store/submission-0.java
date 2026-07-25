class TimeMap {

    // Map: key -> list of [timestamp, value]
    private HashMap<String, ArrayList<Pair>> map;

    // Pair class
    static class Pair {
        int time;
        String val;

        Pair(int t, String v) {
            time = t;
            val = v;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        ArrayList<Pair> list = map.get(key);
        
        int left = 0, right = list.size() - 1;
        String res = "";
        
        // Binary search
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).val;
                left = mid + 1; // try to find closer timestamp
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }
}