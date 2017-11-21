import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        //get maze array
        int[][] mazeArray = new int[][]{
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
        Maze maze1       = new Maze(mazeArray);
        Scanner input    = new Scanner(System.in);

        //get user input to determine what user wants to do
        while (!maze1.isFinished() && !userInput.equals("quit"))
        {
            //display maze, then determine what user wants to do
            if (maze1.isFirstTime())
            {
                maze1.displayFirstTime();
                maze1.displayMaze();
            }

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

            if (userInput.equals("quit"))
            {
                break;
            }

            //check for case
            switch (userInput)
            {
                case "s":
                {
                    maze1.takeStep();
                    maze1.displayMaze();
                    break;
                }

                case "f":
                {
                    maze1.findExit();
                    maze1.displayMaze();
                    break;
                }

                default:
                {
                    System.out.println("Error in case statement.");
                    break;
                }
            }
        }

        System.out.println("Finished.");
    }
}
