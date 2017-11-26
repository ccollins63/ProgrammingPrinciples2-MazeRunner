import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;

public class MazeGUI extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception
    {
        Maze maze = new Maze(MazeLoader.manualMaze());

        BackgroundFill mazeBackground = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));

        BackgroundFill controlBackground = new BackgroundFill(Color.DARKGREY, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));

        BorderPane border = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setBackground(new Background(mazeBackground));
        border.setCenter(gridPane);

        //load new font type for HP font
        final Font HPFONT = Font.loadFont(new FileInputStream(new File("src/fonts/HARRYP__.TTF")), 80);

        HBox topLeftBox = new HBox();
        topLeftBox.setBackground(new Background(controlBackground));
        topLeftBox.setAlignment(Pos.CENTER_LEFT);
        ImageView startHarryPotter = new ImageView(new Image("images/harrypotter.png"));
        startHarryPotter.setFitWidth(70);
        startHarryPotter.setFitHeight(120);
        Text txtStart = new Text("Tri Wizard Cup");
        txtStart.setFont(HPFONT);
        txtStart.setFill(Color.WHITE);
        topLeftBox.getChildren().addAll(startHarryPotter, txtStart);
        border.setTop(topLeftBox);

        VBox rightBox = new VBox();
        rightBox.setBackground(new Background(controlBackground));
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(10);
        rightBox.setPadding(new Insets(10, 10, 10, 10));
        Button btStep       = new Button("Step");
        Button btFindPath   = new Button("Find Path");
        Button btQuit       = new Button("Quit");
        rightBox.getChildren().addAll(btStep, btFindPath, btQuit);
        border.setRight(rightBox);

        HBox bottomBox = new HBox();
        bottomBox.setBackground(new Background(controlBackground));
        bottomBox.setAlignment(Pos.CENTER);
        ImageView triWizardCup = new ImageView(new Image("images/triwizardcup.png"));
        triWizardCup.setFitHeight(100);
        triWizardCup.setFitWidth(100);
        Text txtFinish = new Text("Finish");
        txtFinish.setFont(HPFONT);
        txtFinish.setFill(Color.WHITE);
        bottomBox.getChildren().addAll(triWizardCup, txtFinish);
        border.setBottom(bottomBox);

        ImageView harryPotterMouseStart = new ImageView(new Image("images/harrypotter.png"));
        harryPotterMouseStart.setFitWidth(20);
        harryPotterMouseStart.setFitHeight(20);

        //Harry Potter background audio that plays while the program is running
        Media media = new Media(new File("src/sounds/HPtheme.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        bottomBox.getChildren().add(mediaView);


        if (maze.isFirstTime())
        {
            maze.displayFirstTime();
            //HP Theme Audio
            mediaPlayer.play();
        }

        for (int row = 0; row < maze.getMaze().length; row++)
        {
            for (int column = 0; column < maze.getMaze()[row].length; column++)
            {
                if (maze.getMaze()[row][column] == 0)
                {
                    ImageView mazeWalls = new ImageView(new Image("images/gw4.jpg"));
                    mazeWalls.setFitWidth(20);
                    mazeWalls.setFitHeight(20);

                    gridPane.getChildren( ).add(mazeWalls);
                    gridPane.setConstraints(mazeWalls, column, row);
                }

                else if (maze.getMaze()[row][column] == 2)
                {
                    gridPane.getChildren().add(harryPotterMouseStart);
                    gridPane.setConstraints(harryPotterMouseStart, column, row);
                }
            }
        }



        btStep.setOnAction(event ->
        {
            maze.takeStep();

            for (int row = 0; row < maze.getMaze().length; row++)
            {
                for (int column = 0; column < maze.getMaze()[row].length; column++)
                {
                    switch(maze.getMaze()[row][column])
                    {
                        case 2:
                        {
                            boolean removeNode = false;
                            Node oldNode = null;

                            for ( Node node : gridPane.getChildren())
                            {
                                if (((node instanceof ImageView) || (node instanceof Circle))
                                        && gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row)
                                {
                                    removeNode = true;
                                    oldNode = node;
                                    break;
                                }
                            }

                            if (removeNode)
                            {
                                gridPane.getChildren().remove(oldNode);
                            }

                            ImageView harryPotterMouse = new ImageView(new Image("images/harrypotter.png"));
                            harryPotterMouse.setFitWidth(20);
                            harryPotterMouse.setFitHeight(20);

                            gridPane.getChildren().add(harryPotterMouse);
                            gridPane.setConstraints(harryPotterMouse, column, row);
                            break;
                        }

                        case 3:
                        {
                            boolean removeNode = false;
                            Node oldNode = null;

                            for (Node node : gridPane.getChildren())
                            {
                                if (((node instanceof ImageView) || (node instanceof Circle))
                                        && gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row)
                                {
                                    removeNode = true;
                                    oldNode = node;
                                    break;
                                }
                            }

                            if (removeNode)
                            {
                                gridPane.getChildren().remove(oldNode);
                            }

                            Circle harryPotterTrail = new Circle();
                            harryPotterTrail.setFill(Color.BLACK);
                            harryPotterTrail.setRadius(5);

                            gridPane.getChildren().add(harryPotterTrail);
                            gridPane.setConstraints(harryPotterTrail, column, row);
                            break;
                        }
                    }
                }
            }
        });

        btFindPath.setOnAction(event ->
        {
            maze.findExit();
            for (int row = 0; row < maze.getMaze().length; row++)
            {
                for (int column = 0; column < maze.getMaze( )[row].length; column++)
                {
                    switch (maze.getMaze( )[row][column])
                    {
                        case 2:
                        {
                            boolean removeNode = false;
                            Node oldNode = null;

                            for ( Node node : gridPane.getChildren())
                            {
                                if (((node instanceof ImageView) || (node instanceof Circle))
                                        && gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row)
                                {
                                    removeNode = true;
                                    oldNode = node;
                                    break;
                                }
                            }

                            if (removeNode)
                            {
                                gridPane.getChildren().remove(oldNode);
                            }

                            ImageView harryPotterMouse = new ImageView(new Image("images/harrypotter.png"));
                            harryPotterMouse.setFitWidth(20);
                            harryPotterMouse.setFitHeight(20);

                            gridPane.getChildren( ).add(harryPotterMouse);
                            gridPane.setConstraints(harryPotterMouse, column, row);
                            break;
                        }

                        case 3:
                        {
                            boolean removeNode = false;
                            Node oldNode = null;

                            for (Node node : gridPane.getChildren())
                            {
                                if (((node instanceof ImageView) || (node instanceof Circle))
                                        && gridPane.getColumnIndex(node) == column && gridPane.getRowIndex(node) == row)
                                {
                                    removeNode = true;
                                    oldNode = node;
                                    break;
                                }
                            }

                            if (removeNode)
                            {
                                gridPane.getChildren().remove(oldNode);
                            }

                            Circle harryPotterTrail = new Circle();
                            harryPotterTrail.setFill(Color.BLACK);
                            harryPotterTrail.setRadius(5);

                            gridPane.getChildren().add(harryPotterTrail);
                            gridPane.setConstraints(harryPotterTrail, column, row);
                            break;
                        }
                    }
                }
            }
        });

        btQuit.setOnAction(event ->
        {
            primaryStage.close();
        });

        Scene scene = new Scene(border, 850, 600);
        primaryStage.setTitle("MazeRunner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
