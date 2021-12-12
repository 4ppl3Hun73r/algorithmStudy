package contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Contest8 {

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker(); // Initialize the tracker system.
        tracker.add("bradford", 2); // Add location with name="bradford" and score=2 to the system.
        tracker.add("branford", 3); // Add location with name="branford" and score=3 to the system.
        System.out.println(tracker.get());              // The sorted locations, from best to worst, are: branford, bradford.
        // Note that branford precedes bradford due to its higher score (3 > 2).
        // This is the 1st time get() is called, so return the best location: "branford".
        tracker.add("alps", 2);     // Add location with name="alps" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, alps, bradford.
        // Note that alps precedes bradford even though they have the same score (2).
        // This is because "alps" is lexicographically smaller than "bradford".
        // Return the 2nd best location "alps", as it is the 2nd time get() is called.
        tracker.add("orland", 2);   // Add location with name="orland" and score=2 to the system.
        System.out.println(tracker.get());               // Sorted locations: branford, alps, bradford, orland.
        // Return "bradford", as it is the 3rd time get() is called.
        tracker.add("orlando", 3);  // Add location with name="orlando" and score=3 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alps, bradford, orland.
        // Return "bradford".
        tracker.add("alpine", 2);   // Add location with name="alpine" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        // Return "bradford".
        System.out.println(tracker.get());               // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        // Return "orland".

    }
}


class SORTracker {
    int queryCnt;
    Comparator<SOR> comparator;
    List<SOR> list;

    public SORTracker() {
        comparator = (o1, o2) -> o2.score - o1.score;
        comparator = comparator.thenComparing(o -> o.name);
        list = new ArrayList<>();
        queryCnt = 0;
    }

    public void add(String name, int score) {
        SOR sor = new SOR(name, score);
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            int cmp = comparator.compare(list.get(mid), sor);
            if (cmp < 0) {
                left = mid + 1;
            } else if (cmp > 0){
                right = mid;
            }

        }
        this.list.add(left, sor);
    }

    public String get() {
        return this.list.get(queryCnt++).name;
    }

    class SOR {
        String name;
        int score;

        public SOR(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String toString() {
            return this.name + "(" + this.score + ")";
        }
    }
}