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
import modelo.Protagonista;


public class PainelPersonagemNaArena {

    private Jogo jogo = Jogo.getInstance();

    private final IPersonagem personagem;
    private VBox box = new VBox();


    private StringProperty nome;
    private StringProperty vida;

    public PainelPersonagemNaArena(IPersonagem personagem) {
        this.personagem = personagem;

        box.alignmentProperty().setValue(Pos.TOP_CENTER);


        nome = new SimpleStringProperty();
        vida = new SimpleStringProperty();

        nome.setValue(personagem.getNome());
        vida.setValue("Vida: " + personagem.getVida() );

        Label lblNome = new Label();
        lblNome.fontProperty().set(Font.font("Verdana", 10));
        lblNome.textProperty().bindBidirectional(nome);


        Label lblVida = new Label();
        lblVida.textProperty().bindBidirectional(vida);
        lblVida.fontProperty().set(Font.font("Verdana", 8));


        TilePane pnl = new TilePane();

        pnl.styleProperty().setValue("-fx-background-color: #FFFAFA;");

        pnl.getChildren().add(lblNome);
        pnl.getChildren().add(lblVida);

        Button btnAtacar = new Button("Atacar");
        btnAtacar.fontProperty().set(Font.font("Verdana", 10));
        pnl.getChildren().add(btnAtacar);

        box.getChildren().add(pnl);

        btnAtacar.setOnAction(action -> {
            jogo.atacar();

        });

        Button btnCurar;

        if (personagem instanceof Protagonista) {
            btnCurar = new Button("Curar");
            btnCurar.fontProperty().set(Font.font("Verdana", 10));
            btnCurar.setOnAction(action -> {
                jogo.curar();

            });

            pnl.getChildren().add(btnCurar);
        }

    }

    public VBox getScreen() {


        return box;
    }

    public IPersonagem getPersonagem() {
        return personagem;
    }
}
