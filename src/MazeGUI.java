
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.text.html.ImageView;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class MazeGUI extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle block = new Rectangle(5,5);
        Rectangle path = new Rectangle(5,5);

        block.setFill(Color.BLACK);
        block.setStroke(Color.GRAY);
        path.setFill(Color.TRANSPARENT);

        Pane pane = new Pane();

        //for (int row = 0; row < array.length; row++)
        {
           // for (int column = 0; column < array[].length; column++)
            {
                switch("maze array right here")
                {
                    case 0:
                    {
                       // gridPane.add(new javafx.scene.image.ImageView(new Image("image/x.gif")), row , column);
                        break;
                    }

                    case 1:
                    {
                       // gridPane.add(new javafx.scene.image.ImageView(new Image("image/o.gif")), row , column);
                        break;
                    }

                    case 2:
                    {
                        //gridPane.add(new javafx.scene.image.ImageView(new Image("image/o.gif")), row , column);
                        break;
                    }

                    case 3:
                    {
                       // gridPane.add(new javafx.scene.image.ImageView(new Image("image/o.gif")), row , column);
                        break;
                    }
                }
            }
        }






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
