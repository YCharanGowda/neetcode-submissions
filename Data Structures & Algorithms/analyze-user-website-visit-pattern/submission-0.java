class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        int n = username.length;

        // Step 1: Create list of visits
        List<int[]> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new int[]{timestamp[i], i});
        }

        // Sort by timestamp
        Collections.sort(visits, (a, b) -> a[0] - b[0]);

        // Step 2: Map user -> websites
        Map<String, List<String>> userMap = new HashMap<>();

        for (int[] visit : visits) {
            int i = visit[1];
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(website[i]);
        }

        // Step 3: Generate patterns
        Map<String, Integer> patternCount = new HashMap<>();

        for (String user : userMap.keySet()) {
            List<String> sites = userMap.get(user);

            int size = sites.size();
            Set<String> seen = new HashSet<>();

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {

                        String pattern = sites.get(i) + "," + sites.get(j) + "," + sites.get(k);

                        if (seen.add(pattern)) { // avoid duplicate for same user
                            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
                        }
                    }
                }
            }
        }

        // Step 4: Find best pattern
        String result = "";
        int maxCount = 0;

        for (String pattern : patternCount.keySet()) {
            int count = patternCount.get(pattern);

            if (count > maxCount || 
               (count == maxCount && pattern.compareTo(result) < 0)) {
                result = pattern;
                maxCount = count;
            }
        }

        // Step 5: Convert result to list
        return Arrays.asList(result.split(","));
    }
}