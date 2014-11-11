package rpg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import telas.Inicial;
import telas.PainelPersonagemDisponivel;


public class RPG extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        AnchorPane anchorPane = new AnchorPane();

        Inicial inicial = new Inicial();


        PainelPersonagemDisponivel p1 = new PainelPersonagemDisponivel();

        p1.getScreen().setPrefSize(300,300);


        inicial.addPersonagemDisponivel(p1);

        PainelPersonagemDisponivel p2 = new PainelPersonagemDisponivel();

        p1.getScreen().setPrefSize(300,300);
        inicial.addPersonagemDisponivel(p2);

        PainelPersonagemDisponivel p3 = new PainelPersonagemDisponivel();

        p1.getScreen().setPrefSize(300,300);
        inicial.addPersonagemDisponivel(p3);



        VBox vBox = inicial.getScreen();
        vBox.setPrefSize(800, 600);
        anchorPane.getChildren().add(vBox);


        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG");
        primaryStage.show();

    }
}
