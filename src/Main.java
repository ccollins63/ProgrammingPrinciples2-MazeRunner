import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
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

        while ((!maze1.isFinished()) && (!"quit".equals(userInput)))
        {
            if (maze1.isFirstTime())
            {
                maze1.displayFirstTime();
                maze1.displayMaze();
            }

            System.out.println("Type\n'Step' to continue:\n'Find' to proceed to end result:\n'Quit' to exit:\n");
            userInput = input.next().toLowerCase();

            while ((!"step".equals(userInput)) && (!"find".equals(userInput)) && ("quit".equals(userInput)))
            {
                System.out.println("Invalid input detected.\nType\n'Step' to continue:\n'Find' to proceed to end result:\n'Quit' to exit:\n");
                userInput = input.next().toLowerCase();
            }

            if ("quit".equals(userInput))
            {
                break;
            }

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
