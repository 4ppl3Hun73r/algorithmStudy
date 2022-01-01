package y2021.oct;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class Solution1022 {
    public String frequencySort(String s) {
        char[] lower = new char[26];
        char[] upper = new char[26];
        char[] digit = new char[10];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (Character.isUpperCase(c)) {
                upper[c - 'A']++;
            } else if (Character.isLowerCase(c)) {
                lower[c - 'a']++;
            } else {
                digit[c - '0']++;
            }
        }

        Comparator<Frequency> comparator = new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                return o2.frequency - o1.frequency;
            }
        };
        comparator.thenComparing(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                return (int)o2.c - (int)o1.c;
            }
        });

        PriorityQueue<Frequency> queue = new PriorityQueue<>(comparator);


        for (int i = 0; i < 26; i++) {
            if (upper[i] != 0) {
                queue.add(new Frequency((char)('A' + i), upper[i]));
            }

            if (lower[i] != 0) {
                queue.add(new Frequency((char)('a' + i), lower[i]));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (digit[i] != 0) {
                queue.add(new Frequency((char)('0' + i), digit[i]));
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            Frequency f = queue.poll();

            for (int i = 0; i < f.frequency; i++) {
                arr[idx++] = f.c;
            }
        }


        return new String(arr);
    }

    class Frequency {
        char c;
        int frequency;

        public Frequency(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        Solution1022 s = new Solution1022();
        System.out.println(s.frequencySort("Aabb"));
        System.out.println(s.frequencySort("2a554442f544asfasssffffasss"));

    }
}
