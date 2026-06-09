class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        // 1. Sort data by timestamp first (LeetCode data is not guaranteed to be sorted!)
        int n = username.length;
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new Visit(username[i], timestamp[i], website[i]));
        }
        visits.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));

        // 2. Map users to their sorted website visits
        HashMap<String, List<String>> userToSite = new HashMap<>();
        for (Visit visit : visits) {
            userToSite.putIfAbsent(visit.username, new ArrayList<>());
            userToSite.get(visit.username).add(visit.website);
        }     

        // Global pattern frequency tracker
        HashMap<List<String>, Integer> patternFrequency = new HashMap<>();  

        // 3. Generate 3-combinations per user and ensure they are unique per user
        for (String user : userToSite.keySet()) {
            List<String> sites = userToSite.get(user);
            if (sites.size() < 3) continue;

            // Use a Set to prevent a single user from inflating the count of a pattern
            Set<List<String>> userPatterns = new HashSet<>();

            // NOTE: Patterns do not have to be strictly consecutive! 
            // We must look at all 3-website combinations (i < j < k)
            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        List<String> pattern = List.of(sites.get(i), sites.get(j), sites.get(k));
                        userPatterns.add(pattern);
                    }
                }
            }

            // Update global frequencies using unique patterns from this user
            for (List<String> pattern : userPatterns) {
                patternFrequency.put(pattern, patternFrequency.getOrDefault(pattern, 0) + 1);
            }
        }

        // 4. Find the most frequent and lexicographically smallest pattern
        List<String> resPattern = new ArrayList<>();
        int longest = 0;

        for (List<String> pattern : patternFrequency.keySet()) {
            int count = patternFrequency.get(pattern);
            if (count > longest) {
                longest = count;
                resPattern = pattern;
            } else if (count == longest) {
                // If counts tie, pick the lexicographically smaller one
                if (resPattern.isEmpty() || compareLists(pattern, resPattern) < 0) {
                    resPattern = pattern;
                }
            }
        }

        return resPattern;
    }

    // Helper class to tie data together for sorting
    class Visit {
        String username;
        int timestamp;
        String website;
        Visit(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public int compareLists(List<String> list1, List<String> list2) {
        for (int i = 0; i < 3; i++) {
            int cmp = list1.get(i).compareTo(list2.get(i));
            if (cmp != 0) return cmp;
        }
        return 0;
    }
}
