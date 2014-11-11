package rpg;

import controle.Jogo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.IPersonagem;
import telas.Inicial;
import telas.PainelPersonagemDisponivel;

import java.util.List;


public class RPG extends Application {

    //private String url = getClass().getResourceAsStream("mago.jpg").toString();


    @Override
    public void start(Stage primaryStage) throws Exception {

        Jogo jogo = Jogo.getInstance();
        jogo.inicio();

        AnchorPane anchorPane = new AnchorPane();

        Inicial inicial = new Inicial();


        List<IPersonagem> personagemList = jogo.getPersonagems();

        personagemList.stream().forEach(tipoPersonagem -> {
            PainelPersonagemDisponivel p = new PainelPersonagemDisponivel(tipoPersonagem);

            inicial.addPersonagemDisponivel(p);
        });


        VBox vBox = inicial.getScreen();
        vBox.setPrefSize(800, 600);
        anchorPane.getChildren().add(vBox);


        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG");
        primaryStage.show();

    }
}
