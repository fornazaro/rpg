package telas;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class PainelPersonagemDisponivel {

    private VBox box = new VBox();

   // private static final String url = PainelPersonagemDisponivel.class.getResourceAsStream("merlin_mago.jpg").toString();

    private StringProperty nome;
    private StringProperty descricao;

    public PainelPersonagemDisponivel() {

        box.setPrefSize(280, 280);

        nome = new SimpleStringProperty();
        descricao = new SimpleStringProperty();

        nome.setValue("Mago");
        descricao.setValue("O mago faz magia, tem vida de XXX");

     //   ImageView imagemPersonagem = new ImageView(new Image(url, 30, 70, false, true));

       // box.getChildren().add(imagemPersonagem);
        Label lblNome = new Label();
        lblNome.textProperty().bindBidirectional(nome);


        box.getChildren().add(lblNome);
        Label lblDescricao = new Label();
        lblDescricao.textProperty().bindBidirectional(descricao);
        box.getChildren().add(lblDescricao);

        Button btnAdicionar = new Button("Adicionar");
        box.getChildren().add(btnAdicionar);


        btnAdicionar.setOnAction(action -> {
            System.out.println(" Adicionou mais um jogador");
        });

    }

    public VBox getScreen() {


        return box;
    }
}
