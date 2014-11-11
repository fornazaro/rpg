package telas;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by ton on 11/11/14.
 */
public class Inicial {
    private VBox box = new VBox();
    private HBox boxDisponiveis = new HBox();

    public Inicial() {
        box.setPrefSize(800, 600);

        HBox boxMessage = new HBox();
        boxMessage.getChildren().add(new Label("Início, monte sua equipe, adicionando personagens de acordo com a lista abaixo"));
        box.getChildren().add(boxMessage);
        boxDisponiveis.setPrefSize(780, 580);


        box.getChildren().add(boxDisponiveis);
    }

    public VBox getScreen() {


        return box;
    }


    public void addPersonagemDisponivel(PainelPersonagemDisponivel personagemDisponivel) {
        boxDisponiveis.getChildren().add(new Separator());
        boxDisponiveis.getChildren().add(personagemDisponivel.getScreen());
    }
}
