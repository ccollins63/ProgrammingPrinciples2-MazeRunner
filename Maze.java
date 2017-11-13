
public class Maze
{
    private int[][] maze;

    {
        this.maze = maze;
    }

   public void displayMaze()
    {
       for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                System.out.print(maze[i][j]);
            }

            System.out.println("");
        }
    }

    //public takeStep()
    {
    }

    //public findExit()
    {
    }
}
