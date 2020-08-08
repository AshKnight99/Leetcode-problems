/*
688. Knight Probability in Chessboard
On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
*/
class Solution {
    int row_m [] = new int[]{2,2,-2,-2,1,1,-1,-1};
    int col_m[] = new int[]{1,-1,1,-1,2,-2,2,-2};
    double cache[][][];
    public double knightProbability(int N, int K, int r, int c) {
        cache = new double[N][N][K + 1];
        double totalOnBoard = onBoard(N,K,r,c);  
        return totalOnBoard / Math.pow(8.0,(double)K);
    }
    private double onBoard(int N,int K,int r,int c){
        if(r < 0 || r >= N || c < 0 || c >= N)
            return 0;
        if(K == 0)
            return 1;
        if(cache[r][c][K] != 0)
            return cache[r][c][K];
        double prob = 0;
        for(int i = 0;i < 8;i ++){
            int x = r + col_m[i];
            int y = c + row_m[i];
            prob += onBoard(N,K-1,x,y);            
        }
        cache[r][c][K] = prob;
        return prob;
    }
}