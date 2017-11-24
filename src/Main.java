import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //obtain usable array, first is the "default" maze
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

        String userInput = "";
        Maze maze1       = new Maze(mazeArray);
        Scanner input    = new Scanner(System.in);

        //set while loop to run until the maze is finished, or the user quits
        while ((!maze1.isFinished()) && (!userInput.equals("quit")))
        {
            if (maze1.isFirstTime())
            {
                maze1.displayFirstTime();
                maze1.displayMaze();
            }

            //get input
            System.out.println("Type\n\"Step\" to continue:\n\"Find\" to proceed to end result:\n\"Quit\" to exit:\n");
            userInput = input.next().toLowerCase();

            //check for validity
            while ((!userInput.equals("step") && (!userInput.equals("find") && (!userInput.equals("quit")))))
            {
                System.out.println("Invalid input detected. Type\n\"Step\" to continue:\n\"Find\" to proceed to end result:\n\"Quit\" to exit:\n");
                userInput = input.next().toLowerCase();
            }

            //check for quit message
            if (userInput.equals("quit"))
            {
                break;
            }

            //determine input
            switch (userInput)
            {
                case "step":
                {
                    maze1.takeStep();
                    maze1.displayMaze();
                    break;
                }

                case "find":
                {
                    maze1.findExit();
                    maze1.displayMaze();
                    break;
                }
            }
        }

        System.out.println("Finished.");
    }
}
