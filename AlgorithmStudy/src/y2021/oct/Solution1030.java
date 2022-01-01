package y2021.oct;


import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-duplicate-substring/
public class Solution1030 {


    //https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
    // https://leetcode.com/problems/longest-duplicate-substring/discuss/695419/JAVA-%3A-O(n-log-n)-Rabin-Karp-%2B-Binary-Search
    public String longestDupSubstring(String s) {
        String ans = "";
        int left = 1;
        int right = s.length()-1;

        /*

        bantna
        m -> 3 -> 없음
         */
        while(left <= right){
            int m = left + (right - left) / 2;

            String dup = rabinKarp(m, s);

            System.out.println("m: " + m + ", dup: " + dup);

            // null -> 탐색 범위(len을 줄임) -> right를 줄임으로써 1/2 씩 줄임
            // not null -> 탐색 범위를 늘림 -> left를 늘림으로써 1씩 증가
            if(dup != null){
                ans = dup;
                left = m + 1;
            }else{
                right = m - 1;
            }
        }

        return ans;
    }

    /*
     * 아스키값 이랑 2의 제곱을 한것을 더해서 유니크한 해쉬 값을 만들어냄
     *
     * abac
     *  97 * 2^3 + 98 * 2^2 + 97 * 2^1 + 99 * 2^0
     * abaca
     *  97 * 2^4 + 98 * 2^3 + 97 * 2^2 + 99 * 2^1 + 97 * 2^0
     *
     * 충돌 발생할수 있지만 그 확률이 극히 낮아짐
     */
    private String rabinKarp(int size, String s){

        // 해쉬 생성
        long subHash = hash(s.substring(0, size));

        Set<Long> set = new HashSet<>();
        set.add(subHash);

        long pow = 1;
        for (int i = 1; i < size; i++) {
            pow = (pow * 31);
        }
        int n = s.length();
        for (int i = size; i < n; i++) {
            // 슬라이딩 윈도우형태로 다음 hash값을 구해옴
            // substring보다 빠른 연산으로 처리
            subHash = nextHash(pow, subHash, s.charAt(i - size), s.charAt(i));
            if(!set.add(subHash)){
                return s.substring(i - size + 1, i + 1);
            }
        }

        return null;
    }

    private long hash(String s){
        long h = 0;
        long a = 1;

        int n = s.length();
        for (int k = n; k >= 1; k--) {
            char ch = s.charAt(k - 1);
            h += (ch - 'a' + 1) * a;
            a = (a * 31);
        }

        return h;
    }

    private long nextHash(long pow, long hash, char left, char right){
        return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
    }


    public String longestDupSubstringTimeLimit(String s) {
        // String, binary search, sliding window, rolling hash, suffix array, hash function
        /*
                   banana
         */

        String ans = "";
        int left = 1;
        int right = s.length()-1;
        /*
        bantna
        m -> 3 -> 없음

        기존에 시간 초과 났던걸 binary search 적용하니까 초과 안남 :)
         */
        while(left <= right){
            int m = left + (right - left) / 2;

            Set<String> dup = new HashSet<>();
            boolean findDup = false;
            for (int j = 0; j <= s.length() - m; j++) {
                String sub = s.substring(j, j + m);
                // System.out.println(sub);
                if (dup.contains(sub)) {
                    ans = sub;
                    findDup = true;
                    break;
                }
                dup.add(sub);
            }

            // System.out.println("m: " + m + ", dup: " + dup);
            if(findDup){
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution1030 s = new Solution1030();
        System.out.println(s.longestDupSubstringTimeLimit("banana"));
        System.out.println(s.longestDupSubstringTimeLimit("rtbbfywifhhthadpjixdeodqfgjfykvjwagudthnwfjdqyfskgczdzdsomkxfeizyfnmkirnklfevunbwvevymyoxcnddzhrqnengvjrptpgkusjfpcivknmpcptgbkosyujjcpqugnizpfqfxzrpyxmtbvpxqfbrrupmppkxyltyumcxtyefxjqlmpfymxvrbjmxvqtgnorweoujekkbpdzvhzvchdslcbmavwmjnlypoexhqoxfrnglcyhetrhpemrryhoanasaoyfxeznfeqkgqkzxcuphvngwryfouyugtrhxjfkegzgypucmpanrgyourwglemiclqkcubxbjzhkqzqextijwbfyizgylkyjxeuulkurebpovcxklywnwflnvmufbaauloekgtnabkvfvlsghtgqrkvopcablizoqdcxomhhyxtuwdebmjihmchdxtklvdecwvgogwwepqowfuwluklfiibyqaikphnfpfzhralzuuhsptonslvmkfojfdsumnwwacfwqxkotcqewulorinpzmhduhriisuajcpwjeanvyvpyefglpmfcicsglxtwadtrtaxnozxvchwagdyyinhqmhofuknauhwkinwzmrmermnnzndaxmqkgzotjgkxqhfqvgnvzymvcmdqpfiixrkmjpdbelzojbjeublnwcdsckbpwbbwlloxhecimaysjzwbppgmzywbouicyjdcsaffcxxkmwoamjzicswfzhccdlzewmzotyzprhreseqgmafkzkjqzwukrunckowdfajqhyrhhfhjfuzhvwgkwrmmpgribxqchowwvlbppnkofdfdennafqzawkycytghxehrjwdbrgroqfyoxynkketzkmglrsbqaxgfbiwhtuhzlpszsgbybawnguqhyadwteiikbahnhqdpvmobcsozloyyopxsnjlbgisytssbjbbuucqyvobnflnxtd"));
        System.out.println(s.longestDupSubstringTimeLimit("moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc"));
    }
}
