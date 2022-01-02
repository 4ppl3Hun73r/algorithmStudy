package contest;

public class Contest26 {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int beamCnt = 0;

        int i = 0;
        int r2Cnt = 0;
        while (i < m) {
            int r1Cnt = r2Cnt;
            if (r1Cnt == 0) {
                while (i < m && (r1Cnt = getSecurityDeviceCount(bank[i], n)) == 0) {
                    i++;
                }
            }
            i++;
            r2Cnt = 0;
            while (i < m && (r2Cnt = getSecurityDeviceCount(bank[i], n)) == 0) {
                i++;
            }
            beamCnt += r1Cnt * r2Cnt;
        }

        return beamCnt;
    }

    private int getSecurityDeviceCount(String r, int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (r.charAt(i) == '1') {
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Contest26 c = new Contest26();

        System.out.println(c.numberOfBeams(new String[]{
                "011001","000000","010100","001000"
        }));

        System.out.println(c.numberOfBeams(new String[]{
                "000","111","000"
        }));

        System.out.println(c.numberOfBeams(new String[]{
                "111","111"
        }));
    }

}
