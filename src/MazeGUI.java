import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class MazeGUI extends Application
{
    int[][] maze = new int[][]
            {
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
                    {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
            };

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception
    {
        Maze maze1 = new Maze(maze);

        BorderPane border = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        border.setCenter(gridPane);

        HBox topLeftBox = new HBox();
        topLeftBox.setAlignment(Pos.CENTER_LEFT);
        ImageView startHarryPotter = new ImageView(new Image("images/harrypotter.png"));
        startHarryPotter.setFitWidth(100);
        startHarryPotter.setFitHeight(100);
        Text txtStart = new Text("Start");
        topLeftBox.getChildren().addAll(startHarryPotter, txtStart);
        border.setTop(topLeftBox);

        VBox rightBox = new VBox();
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(10);
        rightBox.setPadding(new Insets(10, 10, 10, 10));
        Button btStep       = new Button("Step");
        Button btFindPath   = new Button("Find Path");
        Button btQuit       = new Button("Quit");
        rightBox.getChildren().addAll(btStep, btFindPath, btQuit);
        border.setRight(rightBox);

        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER);
        ImageView triWizardCup = new ImageView(new Image("images/triwizardcup.png"));
        triWizardCup.setFitHeight(100);
        triWizardCup.setFitWidth(100);
        bottomBox.getChildren().add(triWizardCup);
        border.setBottom(bottomBox);

        for (int row = 0; row < maze.length; row++)
        {
            for (int column = 0; column < maze[row].length; column++)
            {
                switch(maze[row][column])
                {
                    case 0:
                    {
                        ImageView imageView = new ImageView(new Image("images/gw4.png"));
                        imageView.setFitWidth(15);
                        imageView.setFitHeight(15);
                        gridPane.getChildren().add(imageView);
                        gridPane.setConstraints(imageView, column, row);
                        break;
                    }

                    case 1:
                    {
                        break;
                    }

                    case 2:
                    {
                        ImageView imageView = new ImageView(new Image("images/harrypotter.png"));
                        imageView.setFitWidth(10);
                        imageView.setFitHeight(10);
                        gridPane.getChildren().add(imageView);
                        gridPane.setConstraints(imageView, row, column);
                        break;
                    }

                    case 3:
                    {
                        ImageView imageView = new ImageView(new Image("images/Harry-Potter-symbol.png"));
                        imageView.setFitWidth(10);
                        imageView.setFitHeight(10);
                        gridPane.getChildren().add(imageView);
                        gridPane.setConstraints(imageView, row, column);                        break;
                    }
                }
            }
        }

        btStep.setOnAction(event ->
        {
            maze1.takeStep();
        });

        btFindPath.setOnAction(event ->
        {
            maze1.findExit();
        });

            Scene scene = new Scene(border, 750, 500);
            primaryStage.setTitle("MazeRunner");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
