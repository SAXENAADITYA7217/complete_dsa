class Solution {
    Map<String, Boolean> hm;
    public boolean isScramble(String a, String b) {
        hm = new HashMap<>();
        if (a.length() != b.length()) {
            return false;
        }
        if (a.length() == 0 && b.length() == 0) {
            return true;
        }
        return solve(a, b);

    }

    public boolean solve(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.length() <= 1) {
            return false;
        }
        String key = a+ "," + b;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        int n = a.length();
        boolean flag = false;
        for (int i = 1; i <= n - 1; i++) {
            boolean ifswap = solve(a.substring(0, i), b.substring(n - i)) &&
                    solve(a.substring(i), b.substring(0, n - i));

            boolean notswap = solve(a.substring(0, i), b.substring(0, i)) &&
                    solve(a.substring(i), b.substring(i));

            if (ifswap || notswap) {
                flag = true;
            }

        }
        hm.put(key,flag);
        return flag;
    }
}