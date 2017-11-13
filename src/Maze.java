
public class Maze
{
    private int[][] maze;
    private String direction = "South";
    private int x            = 2;
    private int y            = 0;
    private boolean finished = false;

    public Maze(int[][] array)
    {
        this.maze = array;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void displayMaze()
    {
        System.out.println("_________________________________________________________________________________________");

        for (int row = 0; row < maze.length; row++)
        {
            for (int column = 0; column < maze[row].length; column++)
            {
                System.out.print(maze[row][column]);
            }

            System.out.println("");
        }

        System.out.print("\n" + getDirection() + "\n" + getX() + "\n" + getY());
        System.out.println("_________________________________________________________________________________________");
    }

    public void takeStep()
    {
        switch(direction)
        {
            case "South":
            {
                if (maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if (maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if (maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if (maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y - 1;
                }

                else
                {
                    finished = true;
                    break;
                }
            }

            case "West":
            {
                if (maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if (maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if (maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if (maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                }

                else
                {
                    finished = true;
                }
            }

            case "North":
            {
                if (maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if (maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if (maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if (maze[y + 1][x] == 1)
                {
                    direction = "South";
                    y         = y + 1;
                }

                else
                {
                    finished = true;
                }
            }

            case "East":
            {
                if (maze[y + 1][x] == 1)
                {
                direction = "South";
                y         = y + 1;
                }

                else if (maze[y][x + 1] == 1)
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if (maze[y - 1][x] == 1)
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if (maze[y][x - 1] == 1)
                {
                    direction = "West";
                    x         = x - 1;
                }

                else
                {
                    finished = true;
                }

            }
        }

        maze[y][x] = 2;

        displayMaze();
    }

    public void findExit()
    {
        while (finished)
        {
            takeStep();
        }
    }
}
