package contest;

public class Contest17 {


    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            maxWords = Math.max(sentence.split(" ").length, maxWords);
        }

        return maxWords;

    }

    public static void main(String[] args) {
        Contest17 c = new Contest17();
    }
}
