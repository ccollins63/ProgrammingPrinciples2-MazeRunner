public class Maze
{
    private int[][] maze;
    private String direction  = "South";
    private int x             = 2;
    private int y             = 0;
    private boolean finished  = false;
    private boolean firstTime = true;

    public Maze(int[][] array)
    {
        this.maze = array;
    }

    public int[][] getMaze()
    {
        return maze;
    }

    public void setMaze(int[][] maze)
    {
        this.maze = maze;
    }

    public boolean isFirstTime()
    {
        return firstTime;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void displayFirstTime()
    {
        maze[y][x] = 2;
        firstTime = false;
    }

    public void displayMaze(){
        {
            //variable to allow ASCII changes
            char display = ' ';

            System.out.println("_________________________________________________________________________________________");

            for (int row = 0; row < maze.length; row++)
            {
                for (int column = 0; column < maze[row].length; column++)
                {
                    switch (maze[row][column])
                    {
                        case 0:
                        {
                            display = '*';
                            break;
                        }

                        case 1:
                        {
                            display = ' ';
                            break;
                        }

                        case 2:
                        {
                            display = '@';
                            break;
                        }

                        case 3:
                        {
                            display = '~';
                            break;
                        }
                    }

                    System.out.print(display);
                    System.out.print(" ");
                }

                System.out.println("");
            }

            System.out.println("_________________________________________________________________________________________");
        }
    }

    public void takeStep()
    {
        switch(direction)
        {
            case "South":
            {
                maze[y][x] = 3;

                if (y == (maze.length - 1) )
                {
                    finished = true;

                    break;
                }

                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                break;
            }

            case "West":
            {
                maze[y][x] = 3;

                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;

                    break;
                }

                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                break;
            }

            case "North":
            {
                maze[y][x] = 3;

                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;

                    break;
                }

                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y -1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                break;
            }

            case "East":
            {
                maze[y][x] = 3;

                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;

                    break;
                }

                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                break;
            }
        }

        maze[y][x] = 2;
    }

    public void findExit()
    {
        while (!finished)
        {
            takeStep();
        }
    }
}
