package july;

import java.util.*;

//  https://leetcode.com/problems/word-ladder-ii/solution/ 답은 나오는데
// fixme 오래 걸림.. 개선할려면 bfs 를 이용해서 조정해야함.
public class Solution0725 {

    List<List<String>> shortestPaths = new ArrayList<>();
    int MAX_LENGTH = Integer.MAX_VALUE;
    String endWord;
    Map<String, Set<String>> neighborsMap = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        this.endWord = endWord;

        for (String word : wordList) {
            neighborsMap.put(word, findNeighbors(word, wordSet));
        }

        List<String> path = new ArrayList<>();
        recur(beginWord, path, wordSet);

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < shortestPaths.size(); i++) {
            if (shortestPaths.get(i).size() == MAX_LENGTH) {
                result.add(shortestPaths.get(i));
            }
        }

        return result;
    }

    public void recur(String beginWord, List<String> path, Set<String> wordSet) {
       if (path.size() >= MAX_LENGTH) {
            return ;
        }
        if (beginWord.equals(endWord)) {
            path.add(endWord);
            shortestPaths.add(path);
            MAX_LENGTH = path.size();
            return ;
        }

        wordSet.remove(beginWord);

        Set<String> neighbors = neighborsMap.get(beginWord);
        if (neighbors == null) {
            return ;
        }
        neighbors = new HashSet<>(neighbors);
        path.forEach(neighbors::remove);
        for (String neighbor : neighbors) {
            List<String> newPath = new ArrayList<>(path);
            newPath.add(beginWord);
            Set<String> newWordSet = new HashSet<>(wordSet);
            recur(neighbor, newPath, newWordSet);
        }
    }

    private Set<String> findNeighbors(String word, Set<String> wordSet) {
        Set<String> neighbors = new HashSet<>();
        char charList[] = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];

            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;

                // skip if the character is same as original or if the word is not present in the wordList
                if (c == oldChar || !wordSet.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }

    public static void main(String[] args) throws Exception {
        Solution0725 solution0725 = new Solution0725();

        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = List.of("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");

        long s = System.currentTimeMillis();
        List<List<String>> l = null;//solution0725.findLadders(beginWord, endWord, wordList);
       // System.out.println(l.size() + ":" + l);
        // 51, 4s
        System.out.println((System.currentTimeMillis() - s) / 1000);


        beginWord = "hit";
        endWord = "cog";
        wordList = List.of("hot","dot","dog","lot","log","cog");
        l = solution0725.findLadders(beginWord, endWord, wordList);
        wordList = List.of("hot","dot","dog","lot","log");
        l = solution0725.findLadders(beginWord, endWord, wordList);
    }
}
