class Solution {
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }

        for(int i = 0;i<numbers.length;i++){
            int diff = target - numbers[i];
            if(map.containsKey(diff)){
                return new int[]{i+1, map.get(diff)+1};
            }
        }

        return new int[]{};
    }
}
