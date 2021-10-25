package problems;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        /*
        isConnected[i][j] is 1 or 0.
        isConnected[i][i] == 1
        isConnected[i][j] == isConnected[j][i]
        [[1,1,0]
        ,[1,1,0]
        ,[0,0,1]]

        [[1,0,0]
        ,[0,1,0]
        ,[0,0,1]]
         */
        int result = 0;
        int len = isConnected.length;

        for (int i = 0;i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && isConnected[i][j] == 1) {

                }
            }
        }

        return result;
    }
}
