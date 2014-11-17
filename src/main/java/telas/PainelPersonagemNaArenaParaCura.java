package telas;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.IPersonagem;
import modelo.StatusPersonagem;


public class PainelPersonagemNaArenaParaCura extends PainelPersonagemNaArena {


    protected PainelPersonagemNaArenaParaCura(IPersonagem personagem) {
        super(personagem);

        if (personagem.statusPersonagemProperty().get().equals(StatusPersonagem.VIVO)) {

            Button btnSelecionarAlvoCura = new Button(" me cure!!!");
            btnSelecionarAlvoCura.fontProperty().set(Font.font("Verdana", 8));

            btnSelecionarAlvoCura.setOnAction(action -> {
                jogo.selecionarAlvoCura(personagem);
            });

            pnl.getChildren().add(btnSelecionarAlvoCura);
            pnl.getChildren().remove(btnAtacar);
            pnl.getChildren().remove(btnCurar);


        }
    }

    public VBox getScreen() {


        return box;
    }

    public IPersonagem getPersonagem() {
        return personagem;
    }
}
