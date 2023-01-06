package Practical_20;

public class SierpinskiCarpet {
    private char[][] board;

    public SierpinskiCarpet(int boardSize) throws InvalidBoardSizeException {
        // Check that the carpet size is of a valid size.
        if (!isValidSize(boardSize)) {
            throw new InvalidBoardSizeException();
        }

        board = new char[boardSize][boardSize];
        for (int x = 0; x < boardSize; x++)
        for (int y = 0; y < boardSize; y++)
            board[x][y] = '*';

        removeSubArray(board,0, 0, 0, getBoardSize());
    }

    public int getBoardSize() {
        return board.length;
    }

    private boolean isValidSize(int boardSize) {
        // If Log3(boardSize) is a whole number, then the board size is valid.
        // 243 has precision error, resulting in 4.999999999999999 mod 1 = 1. Casting to float solves this issue.
        return (float)(Math.log(boardSize) / Math.log(3)) % 1 == 0;
    }


    /** Removes centre cells from a scaled 3x3 board, interprets every cell as another scaled 3x3 board and repeats.
     * @param board The original board. Useless but the assignment spec requires it for some reason.
     * @param cellIndex The cell index of the new board, starting from 0 from top-left to bottom-right.
     * @param prevStartX The X co-ordinate of the starting cell of the previous sub-board.
     * @param prevStartY The Y co-ordinate of the starting cell of the previous sub-board.
     * @param boardSize The size of the new board.
     */
    private void removeSubArray(char[][] board, int cellIndex, int prevStartX, int prevStartY, int boardSize) {
        // Reinterpret the board as a scaled 3x3 board.
        int multiplier = boardSize / 3;

        // Calculate the top-left X and Y co-ordinates, using the starting X and Y co-ordinates as the origin.
        int startX = prevStartX + (cellIndex / 3) * boardSize;
        int startY = prevStartY + (cellIndex % 3) * boardSize;

        // Calculate the top-left and bottom-right X and Y co-ordinates of the centre cell,
        // which will be removed.
        int centreStartX = startX + multiplier;
        int centreEndX = centreStartX + multiplier;
        int centreStartY = startY + multiplier;
        int centreEndY = centreStartY + multiplier;

        // Remove centre cell from board (1,1).
        for (int x = centreStartX; x < centreEndX; x++)
            for (int y = centreStartY; y < centreEndY; y++)
                board[x][y] = ' ';

        // Do the same but with the remaining split board cells.
        if (boardSize > 3) {
            removeSubArray(board, 0, startX, startY, multiplier);
            removeSubArray(board,1, startX, startY, multiplier);
            removeSubArray(board,2, startX, startY, multiplier);
            removeSubArray(board,3, startX, startY, multiplier);
            // Cell index 4 is the centre and does not need processing.
            removeSubArray(board,5, startX, startY, multiplier);
            removeSubArray(board,6, startX, startY, multiplier);
            removeSubArray(board,7, startX, startY, multiplier);
            removeSubArray(board,8, startX, startY, multiplier);
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(getBoardSize() * (getBoardSize() + 2) + getBoardSize());

        for (int x = 0; x < getBoardSize(); x++) {
            for (int y = 0; y < getBoardSize(); y++)
                sb.append(board[x][y] + " ");

            sb.append("\n");
        }

        // Removes the final space before the final line as the test cases do not have this space.
        return sb.toString();
    }

    public class InvalidBoardSizeException extends Exception {

    }
}
