package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.IPersonagem;


public class PainelPersonagemNaEquipe {

    private VBox box = new VBox();
    private IPersonagem personagem;


    private StringProperty nome;


    public PainelPersonagemNaEquipe(IPersonagem personagem) {
        this.personagem = personagem;

        box.alignmentProperty().setValue(Pos.TOP_CENTER);
        box.paddingProperty().setValue( new Insets(10));


        nome = new SimpleStringProperty();


        nome.setValue(personagem.getNome());


        Label lblNome = new Label();
        lblNome.fontProperty().set(Font.font("Verdana", 10));
        lblNome.textProperty().bindBidirectional(nome);


        TilePane pnl = new TilePane();


        pnl.styleProperty().setValue("-fx-background-color: #FFFAFA;");

        pnl.getChildren().add(lblNome);


        box.getChildren().add(pnl);


    }

    public VBox getScreen() {


        return box;
    }

    public IPersonagem getPersonagem() {
        return personagem;
    }
}
