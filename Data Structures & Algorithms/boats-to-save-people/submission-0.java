class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);  // sort weights

                int left = 0;                     // lightest
                        int right = people.length - 1;    // heaviest
                                int boats = 0;

                                        while (left <= right) {

                                                    if (people[left] + people[right] <= limit) {
                                                                    left++;   // pair lightest with heaviest
                                                                                }

                                                                                            right--;      // heaviest always goes
                                                                                                        boats++;      // one boat used
                                                                                                                }

                                                                                                                        return boats;
    }
}