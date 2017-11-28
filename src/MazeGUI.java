import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

public class MazeGUI extends Application
{

    //variable to control timeline
    private int millis = 0;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception
    {
        Maze maze = new Maze(MazeLoader.manualMaze());

        //set background values
        BackgroundFill mazeBackground = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));

        BackgroundFill controlBackground = new BackgroundFill(Color.DARKGREY, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));

        BackgroundFill finalBackground = new BackgroundFill(Color.DARKRED, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));

        BorderPane border = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setBackground(new Background(mazeBackground));
        border.setCenter(gridPane);

        //load new font type for HP font
        final Font ftHPFONT = Font.loadFont(new FileInputStream(new File("src/fonts/HARRYP__.TTF")), 80);

        HBox topLeftBox = new HBox();
        topLeftBox.setBackground(new Background(controlBackground));
        topLeftBox.setAlignment(Pos.CENTER_LEFT);
        ImageView startHarryPotter = new ImageView(new Image("images/harrypotter.png"));
        startHarryPotter.setFitWidth(70);
        startHarryPotter.setFitHeight(120);
        Text txtStart = new Text("Tri Wizard Cup");
        txtStart.setFont(ftHPFONT);
        txtStart.setFill(Color.WHITE);
        topLeftBox.getChildren().addAll(startHarryPotter, txtStart);
        border.setTop(topLeftBox);

        //buttons pane
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
        //"Finished" button that pane will transition to
        Button btFinished   = new Button("Finished!");

        HBox bottomBox = new HBox();
        bottomBox.setBackground(new Background(controlBackground));
        bottomBox.setAlignment(Pos.CENTER);
        Text txtFinish = new Text("Finish");
        txtFinish.setFont(ftHPFONT);
        txtFinish.setFill(Color.WHITE);
        bottomBox.getChildren().addAll(txtFinish);
        border.setBottom(bottomBox);

        //final pane to set "finished"
        VBox finalPane = new VBox();
        finalPane.setAlignment(Pos.CENTER);
        finalPane.setBackground(new Background(finalBackground));
        Label finalText = new Label("Winner!");
        finalText.setFont(ftHPFONT);
        finalText.setTextFill(Color.WHITE);
        ImageView triWizardCup = new ImageView(new Image("images/triwizardcup.png"));
        triWizardCup.setFitHeight(100);
        triWizardCup.setFitWidth(100);
        finalPane.getChildren().addAll(finalText,triWizardCup);


        //set credits. Whoo!
        Text txtProjectBy = new Text("Project By...");
        txtProjectBy.setFont(Font.font("Ariel",50));
        //this puts the text waaaaay off in the distance, so it's not on screen until it needs to be.
        txtProjectBy.xProperty().bind(border.widthProperty().add(3000));

        Text txtCam = new Text("Cam Collins");
        txtCam.setFont(Font.font("Ariel", 40));
        txtCam.xProperty().bind(border.widthProperty().add(3000));

        Text txtCruise = new Text("Cruise Gatzman");
        txtCruise.setFont(Font.font("Ariel", 40));
        txtCruise.xProperty().bind(border.widthProperty().add(3000));

        Text txtNick = new Text("Nick Windham");
        txtNick.setFont(Font.font("Ariel", 40));
        txtNick.xProperty().bind(border.widthProperty().add(3000));

        Text txtHim = new Text("\"He\" has come again...");
        txtHim.setFont(ftHPFONT);
        txtHim.xProperty().bind(border.widthProperty().add(3000));

        //credits pane
        BorderPane creditsPane = new BorderPane();
        creditsPane.setBackground(new Background(controlBackground));


        //invisible line to roll credits
        Line scrollLine = new Line();
        scrollLine.setStroke(Color.TRANSPARENT);
        //bind line to the center of screen going down
        scrollLine.startXProperty().bind(creditsPane.widthProperty().divide(2));
        scrollLine.endXProperty().bind(creditsPane.widthProperty().divide(2));
        scrollLine.startYProperty().bind(creditsPane.heightProperty().add(400));
        scrollLine.endYProperty().bind(creditsPane.heightProperty().subtract(3000));
        creditsPane.getChildren().add(scrollLine);

        //"his" line to scroll. stops midway to display on screen.
        Line scrollHisLine = new Line();
        scrollHisLine.setStroke(Color.TRANSPARENT);
        //bind line to the center of screen going down
        scrollHisLine.startXProperty().bind(creditsPane.widthProperty().divide(2));
        scrollHisLine.endXProperty().bind(creditsPane.widthProperty().divide(2));
        scrollHisLine.startYProperty().bind(creditsPane.heightProperty().add(400));
        scrollHisLine.endYProperty().bind(creditsPane.heightProperty().divide(2));
        creditsPane.getChildren().add(scrollHisLine);

        //set path transitions for text
        PathTransition pathPresentedBy = new PathTransition();
        PathTransition pathCam = new PathTransition();
        PathTransition pathCruise = new PathTransition();
        PathTransition pathNick = new PathTransition();
        PathTransition pathHim = new PathTransition();
        //set node
        pathPresentedBy.setNode(txtProjectBy);
        pathCam.setNode(txtCam);
        pathCruise.setNode(txtCruise);
        pathNick.setNode(txtNick);
        pathHim.setNode(txtHim);
        //set path
        pathPresentedBy.setPath(scrollLine);
        pathCam.setPath(scrollLine);
        pathCruise.setPath(scrollLine);
        pathNick.setPath(scrollLine);
        pathHim.setPath(scrollHisLine);
        //set rate
        pathPresentedBy.setRate(.01);
        pathCam.setRate(.01);
        pathCruise.setRate(.01);
        pathNick.setRate(.01);
        pathHim.setRate(.1);
        //add all the text
        creditsPane.getChildren().addAll(txtProjectBy,txtCam,txtCruise,txtNick,txtHim);


        ImageView harryPotterMouseStart = new ImageView(new Image("images/harrypotter.png"));
        harryPotterMouseStart.setFitWidth(20);
        harryPotterMouseStart.setFitHeight(20);

        //Harry Potter background audio that plays while the program is running
        Media backgroundTheme = new Media(new File("src/sounds/HPtheme.mp3").toURI().toString());
        MediaPlayer bgPlayer = new MediaPlayer(backgroundTheme);
        bgPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        //Sound for each step taken
        Media stepSound = new Media(new File("src/sounds/StepSound.mp3").toURI().toString());
        MediaPlayer stepPlayer = new MediaPlayer(stepSound);

        //Sound for find path button
        Media findPathSound = new Media(new File("src/sounds/FindPath.wav").toURI().toString());
        MediaPlayer findPathPlayer = new MediaPlayer(findPathSound);

        //Finished cheering sound
        Media finishedSound = new Media(new File("src/sounds/FinishCheer.wav").toURI().toString());
        MediaPlayer finishedPlayer = new MediaPlayer(finishedSound);

        //Credits music
        Media creditTheme = new Media(new File("src/sounds/somber.mp3").toURI().toString());
        MediaPlayer creditPlayer = new MediaPlayer(creditTheme);

        //Movie clip
        Media harryPotterClip = new Media(new File("src/video/HarryPotterFinalClip.mp4").toURI().toString());
        MediaPlayer hpClipPlayer = new MediaPlayer(harryPotterClip);
        MediaView hpClipViewer = new MediaView(hpClipPlayer);


        if (maze.isFirstTime())
        {
            maze.displayFirstTime();

            bgPlayer.play();
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
            //make sure the sound is stopped, then play
            stepPlayer.stop();
            stepPlayer.play();

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
                            harryPotterMouse.setFitWidth(15);
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
            //check for isFinished. Transition scene if so
            if (maze.isFinished()){
                rightBox.getChildren().clear();
                rightBox.getChildren().add(btFinished);
            }
        });

        btFindPath.setOnAction(event ->
        {
            maze.findExit();
            findPathPlayer.play();

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
            //check for isFinished. Transition scene if so
            if (maze.isFinished()){
                rightBox.getChildren().clear();
                rightBox.getChildren().add(btFinished);
            }
        });

        btQuit.setOnAction(event ->
        {
            primaryStage.close();
        });

        btFinished.setOnAction(event ->
        {
            bgPlayer.stop();
            border.getChildren().clear();
            border.setCenter(finalPane);
            finishedPlayer.play();
        });

        //set timeline to handle animation and timing for video-to-credits transition
        AnimationTimer animTimerCredits = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //increment time in ms
                millis++;

                //once 33seconds, do transition
                if (millis == 2400){
                    //kill audio feed from video
                    hpClipPlayer.stop();

                    //play audio for credit roll
                    creditPlayer.play();

                    //timeline will control actual animation, using Interpolator and translateXProperty
                    Timeline timeline = new Timeline();
                    KeyValue kv = new KeyValue(hpClipViewer.translateXProperty(), 0, Interpolator.EASE_BOTH);
                    KeyFrame kf = new KeyFrame(javafx.util.Duration.seconds(1), kv);
                    timeline.getKeyFrames().add(kf);
                    //finish animation, clear previous pane and add in the credits pane
                    timeline.setOnFinished(t->{
                        border.getChildren().clear();
                        border.setCenter(creditsPane);
                    });
                    timeline.play();
                }

                //check for 1 second after, animate credit roll
                if (millis >= 2700){
                    pathPresentedBy.play();
                }
                if (millis >= 2800){
                    pathCam.play();
                }
                if (millis >= 2850){
                    pathCruise.play();
                }
                if (millis >= 2900){
                    pathNick.play();
                }
                if(millis >= 3400){
                    pathHim.play();
                }
                if (millis >= 3600){
                    pathHim.stop();
                }

                //set volume to fade, exit stage
                if (millis == 4100){
                    int secondCounter = millis%100;
                    int index = 10;
                    while (index != 0){
                        //decrement volume over seconds.
                        creditPlayer.setVolume(index/10);
                        //check for a second passing, decrement if so
                        if (secondCounter == 0){
                            index--;
                        }
                    }
                    //close when out of while loop
                    primaryStage.close();
                }
            }
        };

        //stop text after anim finishes
        pathHim.setOnFinished(event -> pathHim.stop());


        finalPane.setOnMouseClicked(event ->
        {
            bgPlayer.stop();
            border.getChildren().clear();
            border.setCenter(finalPane);
            finalPane.getChildren().clear();
            finalPane.getChildren().add(hpClipViewer);
            //starts animation timer to auto-end segment
            animTimerCredits.start();
            hpClipPlayer.play();

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
