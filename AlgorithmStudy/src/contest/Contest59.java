package contest;

import java.util.TreeSet;

public class Contest59 {

    public static void main(String[] args) {
        Contest59 c = new Contest59();

    }
}


class Bitset {
    char[] bitset;
    TreeSet<Integer> zeroIdx = new TreeSet<>();
    TreeSet<Integer> oneIdx = new TreeSet<>();
    boolean flip = false;

    public Bitset(int size) {
        bitset = new char[size];
        for (int i = 0; i < size; i++) {
            bitset[i] = '0';
            zeroIdx.add(i);
        }
    }

    public void fix(int idx) {
        if (flip) {
            bitset[idx] = '0';
            zeroIdx.add(idx);
            oneIdx.remove(idx);
        } else {
            bitset[idx] = '1';
            oneIdx.add(idx);
            zeroIdx.remove(idx);
        }
    }

    public void unfix(int idx) {
        if (flip) {
            bitset[idx] = '1';
            zeroIdx.remove(idx);
            oneIdx.add(idx);
        } else {
            bitset[idx] = '0';
            oneIdx.remove(idx);
            zeroIdx.add(idx);
        }
    }

    public void flip() {
        flip = !flip;
    }

    public boolean all() {
        if (flip) {
            return oneIdx.isEmpty();
        }
        return zeroIdx.isEmpty();
    }

    public boolean one() {
        if (flip) {
            return !zeroIdx.isEmpty();
        }
        return !oneIdx.isEmpty();
    }

    public int count() {
        if (flip) {
            return zeroIdx.size();
        }
        return oneIdx.size();
    }

    public String toString() {
        if (flip) {
            StringBuilder sb = new StringBuilder();
            for (char c : bitset) {
                sb.append(c == '0' ? '1' : '0');
            }
            return sb.toString();
            // 뒤집어서 toString해야함.
        }
        return new String(bitset);
    }
}


//[null,null,null,false,null,null,null,false,1,"10","10","10",null,null,true,null,true,true,false,null,null]
//[null,null,null,false,null,null,null,false,1,"10","10","10",null,null,true,null,true,true,false,null,null]

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */