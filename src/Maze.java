
public class Maze
{
    private int[][] maze;
    private String direction = "South";
    private int x = 2;
    private int y = 0;

    public Maze(String[][] array)
    {
        this.maze = maze;
    }

   public void displayMaze()
    {
       for (int row = 0; row < maze.length; row++)
        {
            for (int column = 0; column < maze[row].length; column++)
            {
                System.out.print(maze[row][column]);
            }

            System.out.println("");
        }
    }

    public takeStep()
    {
        switch(direction)
        {
            case "South":
            {
                if(maze[y][x - 1] == 1)
                {

                }
                else if(maze[y + 1][x] == 1)
                {

                }
                else if(maze[y][x + 1] == 1)
                {

                }
                else(maze[y - 1][x] == 1)
                {

                }
            }

            case "East":
            {

            }

            case "North":
            {
                if(maze[y][x] = 1)
                {

                }
            }

            case "West":
            {
                if(maze[y][x] = 1)
                {

                }
            }
        }

    }

    //public findExit()
    {
    }
}
