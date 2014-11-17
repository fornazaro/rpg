package telas;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import modelo.IPersonagem;
import modelo.StatusPersonagem;


public class PainelPersonagemAdversarioNaArena extends PainelPersonagemNaArena {


    public PainelPersonagemAdversarioNaArena(IPersonagem personagem) {
        super(personagem);

        if (personagem.statusPersonagemProperty().get().equals(StatusPersonagem.VIVO)) {

            Button btnSelecionarAlvo = new Button("Selecionar");
            btnSelecionarAlvo.fontProperty().set(Font.font("Verdana", 8));

            btnSelecionarAlvo.setOnAction(action -> {
                jogo.selecionarAlvoAtaque(personagem);
            });

            pnl.getChildren().add(btnSelecionarAlvo);
            pnl.getChildren().remove(btnAtacar);
            pnl.getChildren().remove(btnCurar);


        }
    }


}
