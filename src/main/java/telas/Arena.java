package telas;

import controle.Jogo;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Arena extends Application {

    private BorderPane pane = new BorderPane();




    private Node getRightNode() {
        return null;
    }

    private Node getCenterNode() {
        return null;
    }

    private Node getLeftNode() {
        return null;
    }

    public BorderPane getScreen() {


        return pane;
    }


    @Override
    public void start(Stage stage) throws Exception {
        pane.setPrefSize(800, 600);
        pane.setLeft(getLeftNode());
        pane.setCenter(getCenterNode());
        pane.setRight(getRightNode());

        Jogo jogo = Jogo.getInstance();

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setTitle("ARENA");
        stage.show();


    }
}
