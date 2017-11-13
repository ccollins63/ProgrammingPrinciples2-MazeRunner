import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        //get maze array
        int[][] maze = new int[][]{
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,0},
                {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

        //set initial variables
        String userInput = "";
        Maze maze1       = new Maze(maze);
        Scanner input    = new Scanner(System.in);

        //get user input to determine what user wants to do
        while (!userInput.equals("quit"))
        {
            //display maze, then determine what user wants to do

            maze1.displayMaze();
            System.out.println("Type \"s\" to continue, type \"f\" to proceed to end result, or \"quit\" to exit.");
            userInput = input.next().toLowerCase();

            //check for valid input, then if quit
            if (!userInput.equals("s") && !userInput.equals("quit") && !userInput.equals("f"))
            {
                while (!userInput.equals("s") && !userInput.equals("quit") && !userInput.equals("f"))
                {
                    System.out.println("Invalid input detected.\nType \"s\" to continue, type \"f\" to proceed to end result, or \"quit\" to exit.");
                    userInput = input.next().toLowerCase();
                }
            }

            else if (userInput.equals("quit"))
            {
                break;
            }

            //check for case
            switch (userInput)
            {
                case "s":
                {
                    maze1.takeStep();
                    break;
                }

                case "f":
                {
                    maze1.findExit();
                    break;
                }

                default:
                {
                    System.out.println("Error in case statement.");
                    break;
                }
            }
        }
    }
}
