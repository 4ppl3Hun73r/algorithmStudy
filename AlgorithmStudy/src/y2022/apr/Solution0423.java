package y2022.apr;

import java.util.HashMap;

// https://leetcode.com/problems/encode-and-decode-tinyurl/
public class Solution0423 {

    public static void main(String[] args) {
        Codec c = new Codec();

        System.out.println(c.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}

class Codec {

    private String prefix = "http://tinyurl.com/";
    HashMap<String, String> cache = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        /*
        https://leetcode.com/problems/design-tinyurl
         -> http://tinyurl.com/4e9iAk
         */
        String shortUrl = prefix + getHashCode(longUrl);
        cache.put(shortUrl, longUrl);

        return shortUrl;
    }

    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private String getHashCode(String longUrl) {

        long hash = 0;
        for (int i = 0; i < longUrl.length(); i++) {
            int ch = longUrl.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                hash = hash * 62 + ch - 'a';
            }
            if ('A' <= ch && ch <= 'Z') {
                hash = hash * 62 + ch - 'A' + 26;
            }
            if ('0' <= ch && ch <= '9') {
                hash = hash * 62 + ch - 'a' + 52;
            }
            
        }

        StringBuilder hashCode = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (hash > 0)
        {
            hashCode.append(map[(int)(hash%62)]);
            hash = hash/62;
        }

        return hashCode.reverse().toString();
    }


    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return cache.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));