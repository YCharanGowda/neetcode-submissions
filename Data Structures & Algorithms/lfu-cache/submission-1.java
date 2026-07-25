class LFUCache {

    int capacity;
    HashMap<Integer,Integer> map = new HashMap<>();
    HashMap<Integer,Integer> freq = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(!map.containsKey(key))
            return -1;

        freq.put(key, freq.get(key)+1);

        return map.get(key);
    }

    public void put(int key, int value) {

        if(capacity == 0) return;

        if(map.containsKey(key)){

            map.put(key,value);
            freq.put(key, freq.get(key)+1);
            return;
        }

        if(map.size() >= capacity){

            int minKey = Collections.min(freq.entrySet(),
                    Map.Entry.comparingByValue()).getKey();

            map.remove(minKey);
            freq.remove(minKey);
        }

        map.put(key,value);
        freq.put(key,1);
    }

    public void display(){
        System.out.println(map);
    }
}