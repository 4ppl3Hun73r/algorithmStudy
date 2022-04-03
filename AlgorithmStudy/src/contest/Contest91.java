package contest;

public class Contest91 {

    public int maximumCandies(int[] candies, long k) {
        // candies[i] 는 쪼갤 수 있음, 병합은 안됨
        // k 명의 아이가 동일한 수의 캔디를 받아야함
        // 최대로 받을 수 있는 캔디의 수는?

        long left = 1;
        long right = 0;
        int max = 0;
        for (int candy : candies) {
            right += candy;
            max = Math.max(max, candy);
        }

        if (right < k) {
            return 0;
        }

        if (k == 1) {
            return max;
        }

        long ans = 1;
        long mid = 0;
        long candy = 0;
        while (left < right) {
            mid = left + (right - left) / 2;

            candy = 0;
            for (int i = 0; i < candies.length; i++) {
                candy += candies[i] / mid;
            }
            System.out.println("left : " + left + ", right : " + right + ", mid : " + mid + ", candy : " + candy);

            if (candy >= k) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid;
            }
        }

        return (int)ans;
    }


    public static void main(String[] args) {
        Contest91 c = new Contest91();

        //System.out.println(c.maximumCandies(new int[]{5,8,6}, 3)); // 5
        //System.out.println(c.maximumCandies(new int[]{4,7,5}, 16)); // 1
        //System.out.println(c.maximumCandies(new int[]{5,6,4,10,10,1,1,2,2,2}, 9)); // 3
//
        //System.out.println(c.maximumCandies(new int[]{4,9,4,7,8,10,3,10,3,9}, 9)); // 4
//
//
        //System.out.println(c.maximumCandies(new int[]{750,253,391,342,151,655,934,601,870,338,866,798,806,795,580,225,225,961,506,536,620,486,834,757,594,657,599,859,121,854,537,903,391,555,983,269,898,961,109,748,832,608,659,233,608,476,564,599,989,875,229,193,725,921,836,534,769,277,639,628,285,563,680,839,403,689,489,979,529,868,514,795,941,464,340,700,997,792,422,645,745,637,908,701,597,455,135,629,981,178,551,595,993,896,700,507,997,884,852,928},
        //        46)); // 659


        System.out.println(c.maximumCandies(new int[]{10000000}, 1)); // 4
    }
}
