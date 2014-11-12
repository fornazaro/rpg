package telas;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import modelo.IPersonagem;


public class PainelPersonagemAdversarioNaArena extends PainelPersonagemNaArena {


    public PainelPersonagemAdversarioNaArena(IPersonagem personagem) {
        super(personagem);

        Button btnSelecionarAlvo = new Button("Selecionar");
        btnSelecionarAlvo.fontProperty().set(Font.font("Verdana", 8));


        btnSelecionarAlvo.setOnAction(action -> {
            jogo.selecionarAlvoAtaque(personagem);
        });


        pnl.getChildren().add(btnSelecionarAlvo);


    }


}
