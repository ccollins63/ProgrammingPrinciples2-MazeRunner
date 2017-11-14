
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

                if ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else
                {
                    finished = true;
                    break;
                }

                break;
            }

            case "West":
            {
                maze[y][x] = 3;

                if ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else if ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else
                {
                    finished = true;
                }

                break;
            }

            case "North":
            {
                maze[y][x] = 3;

                if ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((maze[y - 1][x] == 1) || (maze[y -1][x] == 3))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else if ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3))
                {
                    direction = "South";
                    y         = y + 1;
                }

                else
                {
                    finished = true;
                }

                break;
            }

            case "East":
            {
                maze[y][x] = 3;

                if ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3))
                {
                direction = "South";
                y         = y + 1;
                }

                else if ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3))
                {
                    direction = "East";
                    x         = x + 1;
                }

                else if ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3))
                {
                    direction = "North";
                    y         = y - 1;
                }

                else if ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3))
                {
                    direction = "West";
                    x         = x - 1;
                }

                else
                {
                    finished = true;
                }

                break;
            }
        }

        maze[y][x] = 2;

        displayMaze();
    }

    public void findExit()
    {
        while (!finished)
        {
            takeStep();
        }
    }
}
