package telas;

import controle.Jogo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.IPersonagem;


public class PainelPersonagemNaEquipe {

    private VBox box = new VBox();
    private IPersonagem personagem;


    private StringProperty nome;
    private StringProperty descricao;


    public PainelPersonagemNaEquipe(IPersonagem personagem) {
        this.personagem = personagem;

        box.alignmentProperty().setValue(Pos.TOP_CENTER);



        nome = new SimpleStringProperty();
        descricao = new SimpleStringProperty();

        nome.setValue(personagem.getNome());
        descricao.setValue(personagem.getDescricao());

        Label lblNome = new Label();
        lblNome.fontProperty().set(Font.font("Verdana", 10));
        lblNome.textProperty().bindBidirectional(nome);


        Label lblDescricao = new Label();
        lblDescricao.textProperty().bindBidirectional(descricao);
        lblDescricao.fontProperty().set(Font.font("Verdana", 8));


        Button btnAdicionar = new Button("Adicionar");


        TilePane pnl = new TilePane();
        //#FFFAFA
        //pnl.styleProperty().setValue("-fx-background-color: #8fbc8f;");
        pnl.styleProperty().setValue("-fx-background-color: #FFFAFA;");

        pnl.getChildren().add(lblNome);
        pnl.getChildren().add(lblDescricao);
        pnl.getChildren().add(btnAdicionar);
        box.getChildren().add(pnl);

        btnAdicionar.setOnAction(action -> {


            Jogo jogo = Jogo.getInstance();
            jogo.addNovoPersonagemNaEquipe(personagem);


        });

    }

    public VBox getScreen() {


        return box;
    }

    public IPersonagem getPersonagem() {
        return personagem;
    }
}
