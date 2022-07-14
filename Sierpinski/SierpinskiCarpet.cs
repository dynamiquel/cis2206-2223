using System.Text;

namespace Sierpinski;

public class SierpinskiCarpet
{
    public char[,] Board { get; private set; }
    public DimensionSize DimensionSize => (DimensionSize)Board.GetLength(0);

    public SierpinskiCarpet(DimensionSize dimensionSize)
    {
        var numericDimensionSize = (int)dimensionSize;

        Board = CreateNewBoard(numericDimensionSize);
        RemoveCentre();
    }

    /// <summary>
    /// Creates a new Board, initialised completely with '*'.
    /// </summary>
    /// <param name="dimensionSize"></param>
    private static char[,] CreateNewBoard(int dimensionSize)
    {
        var tempBoard = new char[dimensionSize, dimensionSize];
        for (var x = 0; x < tempBoard.GetLength(0); x++)
        for (var y = 0; y < tempBoard.GetLength(1); y++)
            tempBoard[x, y] = '*';

        return tempBoard;
    }

    /// <summary>
    /// 
    /// </summary>
    /// <param name="gridStartFlatIndex">Top-left index of the grid within the Board, represented as a continuous 1D index.</param>
    /// <param name="gridDimensionSize">The size of one of the dimensions of the grid.</param>
    void RemoveCentre()
    {
        for (var x = 0; x < (int)DimensionSize; x++)
        for (var y = 0; y < (int)DimensionSize; y++)
            InRemove(x, y);
    }

    void InRemove(int x, int y)
    {
        while (x != 0 && y != 0)
        {
            if (x % 3 == 1 && y % 3 == 1)
            {
                Board[x, y] = ' ';
                break;
            }

            x /= 3;
            y /= 3;
        }
    }

    public override string ToString()
    {
        // Capacity to fit all characters and the new line characters.
        var sb = new StringBuilder(Board.Length + Board.GetLength(0));
        
        for (var x = 0; x < Board.GetLength(0); x++)
        {
            // Adds a new line for every row after the first row.
            if (x > 0)
                sb.AppendLine();
                
            for (var y = 0; y < Board.GetLength(1); y++)
                sb.Append(Board[x, y]);
        }

        return sb.ToString();
    }
}