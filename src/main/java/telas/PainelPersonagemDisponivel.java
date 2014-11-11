package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.IPersonagem;


public class PainelPersonagemDisponivel {

    private VBox box = new VBox();
    private IPersonagem personagem;


    private StringProperty nome;
    private StringProperty descricao;


    public PainelPersonagemDisponivel(IPersonagem personagem) {
        this.personagem = personagem;

        box.alignmentProperty().setValue(Pos.TOP_CENTER);
        //box.setPrefSize(280, 280);

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

        pnl.getChildren().add(lblNome);
        pnl.getChildren().add(lblDescricao);
        pnl.getChildren().add(btnAdicionar);
        box.getChildren().add(pnl);

        btnAdicionar.setOnAction(action -> {
            System.out.println(" Adicionou mais um jogador");
        });

    }

    public VBox getScreen() {


        return box;
    }

    public IPersonagem getPersonagem() {
        return personagem;
    }
}