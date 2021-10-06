package problems;

public class FirstBadVersion {
    int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
        return badVersion <= version;
    }

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int start, int end) {
        int len = end - start;
        if (len < 100) {
            for (int i = start; i <= end; i++) {
                if (isBadVersion(i)) {
                    return i;
                }
            }
            return Integer.MIN_VALUE;
        }
        boolean findBadVersion = true;
        int lastBadVersion = 0;
        while (start <= end) {
            int mid = (int)(((long)start + (long)end) / 2);
            //System.out.println("" + start + "," + end + "," + mid);

            if (findBadVersion) {
                if (isBadVersion(mid)) {
                    findBadVersion = false;
                    lastBadVersion = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (!isBadVersion(mid)) {
                    return firstBadVersion(mid, lastBadVersion);
                } else {
                    lastBadVersion = mid;
                    end = mid - 1;
                }
            }
        }

        return lastBadVersion;
    }


    public int firstBadVersion2(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        /*FirstBadVersion f = new FirstBadVersion(1702766719);

        long now = System.currentTimeMillis();
        System.out.println(f.firstBadVersion2(2126753390));
        System.out.println(System.currentTimeMillis() - now);

        now = System.currentTimeMillis();
        System.out.println(f.firstBadVersion(2126753390));
        System.out.println(System.currentTimeMillis() - now);*/

        FirstBadVersion f = new FirstBadVersion(2147483647);

        long now = System.currentTimeMillis();
        System.out.println(f.firstBadVersion(2147483647));
        System.out.println(System.currentTimeMillis() - now);

        f = new FirstBadVersion(1);

        now = System.currentTimeMillis();
        System.out.println(f.firstBadVersion(2147483647));
        System.out.println(System.currentTimeMillis() - now);
        //2147483647
        //2147483647
    }
}
