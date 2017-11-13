
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.text.html.ImageView;

import javafx.scene.shape.Rectangle;

public class MazeGUI extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle block = new Rectangle(5,5);
        Rectangle path = new Rectangle(5,5);

        block.setFill(Color.BLACK);
        block.setStroke(Color.GRAY);
        path.setFill(Color.TRANSPARENT);

        Pane pane = new Pane();






    }

    public void DisplayMaze (int[][] array){

        int zero = 0;
        int one = 1;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; i <array.length; j++){

                //if (array[i][j] == zero)

            }


        }



    }
}
