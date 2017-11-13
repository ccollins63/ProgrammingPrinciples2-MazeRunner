
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
                    direction = "West";
                    x         = x - 1;
                    break;
                }

                else if(maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y+ 1;
                    break;
                }

                else if(maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                    break;
                }

                else(maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y + 1;
                    break;
                }
            }

            case "West":
            {
                if(maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y + 1;
                    break;
                }

                else if(maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                    break;
                }

                else if(maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y+ 1;
                    break;
                }

                else(maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                    break;
                }
            }

            case "North":
            {
                if(maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                    break;
                }

                else if(maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y + 1;
                    break;
                }

                else if(maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                    break;
                }

                else(maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y+ 1;
                    break;
                }
            }

            case "East":
            {
                if(maze[y + 1][x] == 1)
                {
                direction = "South";
                y         = y+ 1;
                break;
                }

                else if(maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                    break;
                }

                else if(maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y + 1;
                    break;
                }

                else(maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                    break;
                }
            }
        }

    }

    //public findExit()
    {
    }
}
