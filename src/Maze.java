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

    //returns the array of current maze
    public int[][] getMaze()
    {
        return maze;
    }

    //used to set the current maze to a new array
    public void setMaze(int[][] maze)
    {
        this.maze = maze;
    }

    //find if the maze is in the "first step" state
    public boolean isFirstTime()
    {
        return firstTime;
    }

    //find if the maze is in the "finished" state
    public boolean isFinished()
    {
        return finished;
    }

    //sets display for the initial "start point", turns off "first step" state
    public void displayFirstTime()
    {
        maze[y][x] = 2;
        firstTime = false;
    }

    //ASCII display for the maze.
    public void displayMaze(){
        {
            //variable to allow ASCII changes
            char display = ' ';

            System.out.println("_________________________________________________________________________________________");

            for (int row = 0; row < maze.length; row++)
            {
                for (int column = 0; column < maze[row].length; column++)
                {
                    //switch statement to determine which character to display
                    //0 = wall, 1 = pathway, 2 = current position, 3 = past positions
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
                    System.out.print(display + " ");
                }
                //finishes columns, moves to next row
                System.out.println("");
            }

            System.out.println("_________________________________________________________________________________________");
        }
    }

    //the logic operator for the program.
    //Will begin with the supposed South direction, since the maze entrance is at the top
    public void takeStep()
    {
        //get the current facing direction, then apply logic to navigate maze
        switch(direction)
        {
            case "South":
            {
                maze[y][x] = 3;

                //check if the pointer is at the lowest plausible y point. If so, it's done.
                if (y == (maze.length - 1) )
                {
                    finished = true;
                    break;
                }

                //check to the right first (west)
                //check bounds, then against x-1 (west). Set new direction.
                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                //check bounds, then against y+1 (south). Set new direction.
                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                //check bounds, then against x+1 (east). Set new direction.
                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                //check bounds, then against y-1 (north). Set new direction.
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

                //check if the position is to the far-left of maze. If so, it's done.
                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;
                    break;
                }

                //check to the right first (north)
                //check bounds, then against y+1 (north). Set new direction.
                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                //check bounds, then against x-1 (west). Set new direction.
                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                //check bounds, then against y-1 (south). Set new direction.
                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                //check bounds, then against x+1 (east). Set new direction.
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

                //check if position is at the top, and not the firstStep. If so, it's done.
                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;
                    break;
                }

                //check to the right first (east)
                //check bounds, then against x+1 (east). Set new direction.
                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                //check bounds, then against y-1 (north). Set new direction.
                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y -1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                //check bounds, then against x-1 (west). Set new direction.
                else if ((x > 0) && ((maze[y][x - 1] == 1) || (maze[y][x - 1] == 3)))
                {
                    direction = "West";
                    x         = x - 1;
                }

                //check bounds, then against y+1 (south). Set new direction.
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

                //check if position is on the far-right of maze. If so, it's done.
                if ((y == (maze.length - 1)) && maze[y][x] == 1)
                {
                    finished = true;
                    break;
                }

                //check right first (south)
                //check bounds, then against y-11 (south). Set new direction.
                else if ((y < (maze.length - 1)) && ((maze[y + 1][x] == 1) || (maze[y + 1][x] == 3)))
                {
                    direction = "South";
                    y         = y + 1;
                }

                //check bounds, then against x+1 (east). Set new direction.
                else if ((x < (maze[y].length - 1)) && ((maze[y][x + 1] == 1) || (maze[y][x + 1] == 3)))
                {
                    direction = "East";
                    x         = x + 1;
                }

                //check bounds, then against y+1 (north). Set new direction.
                else if ((y > 0) && ((maze[y - 1][x] == 1) || (maze[y - 1][x] == 3)))
                {
                    direction = "North";
                    y         = y - 1;
                }

                //check bounds, then against x-1 (west). Set new direction.
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

    //run takeStep until endpoint.
    public void findExit()
    {
        while (!finished)
        {
            takeStep();
        }
    }
}
