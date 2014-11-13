package telas;

import controle.Jogo;
import eventos.RPGEvent;
import eventos.RPGEventListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Arena extends Application implements RPGEventListener {

    private Jogo jogo = Jogo.getInstance();

    private BorderPane pane = new BorderPane();


    private VBox getRightNode() {
        VBox vBox = new VBox();
        vBox.fillWidthProperty().setValue(true);
        vBox.getChildren().add(new Label("Equipe Adversária (máquina)"));
        vBox.fillWidthProperty().setValue(true);
        vBox.prefHeightProperty().setValue(780);
        return vBox;
    }

    private StackPane getCenterNode() {
        StackPane pane = new StackPane();

        return pane;
    }

    private VBox getLeftNode() {

        VBox vBox = new VBox();
        vBox.fillWidthProperty().setValue(true);
        vBox.getChildren().add(new Label("Equipe do Jogador"));
        vBox.fillWidthProperty().setValue(true);
        vBox.prefHeightProperty().setValue(780);


        return vBox;
    }

    public BorderPane getScreen() {


        return pane;
    }


    @Override
    public void start(Stage stage) throws Exception {
        pane.setPrefSize(800, 600);
        pane.setLeft(getLeftNode());
        pane.setCenter(getCenterNode());
        pane.setRight(getRightNode());


        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.setTitle("ARENA");
        stage.show();

        jogo.buildEquipeAdversaria();

        //exibindo personagens da equipe do jogador
        exibePersonagensEquipeJogador();

        //exibindo personagens da equipe do jogador
        exibePersonagensEquipeAdversaria();


    }

    private void exibePersonagensEquipeAdversaria() {
        VBox boxAdversarios = getRightNode();

        jogo.getEquipeAdversaria().stream().forEach(personagem -> {
            PainelPersonagemAdversarioNaArena p = new PainelPersonagemAdversarioNaArena(personagem);

            p.getScreen().maxWidthProperty().setValue(100);
            p.getScreen().maxHeightProperty().setValue(100);

            p.getScreen().prefWidthProperty().setValue(100);
            p.getScreen().prefHeightProperty().setValue(100);

            p.getScreen().paddingProperty().setValue(new Insets(5));

            boxAdversarios.getChildren().add(p.getScreen());


        });

        pane.setRight(boxAdversarios);


    }

    private void exibePersonagensEquipeJogador() {
        VBox box = getLeftNode();

        jogo.getEquipeJogador().stream().forEach(personagem -> {
            PainelPersonagemNaArena p = new PainelPersonagemNaArena(personagem);

            p.getScreen().maxWidthProperty().setValue(100);
            p.getScreen().maxHeightProperty().setValue(100);

            p.getScreen().prefWidthProperty().setValue(100);
            p.getScreen().prefHeightProperty().setValue(100);

            p.getScreen().paddingProperty().setValue(new Insets(5));

            box.getChildren().add(p.getScreen());


        });

        pane.setLeft(box);
    }

    @Override
    public void iniciaAtaqueListener(RPGEvent e) {

        StackPane boxArena = getCenterNode();

        boxArena.alignmentProperty().setValue(Pos.CENTER);

        VBox box = new VBox();
        box.alignmentProperty().setValue(Pos.CENTER);

        PainelPersonagemNaEquipe p = new PainelPersonagemNaEquipe((modelo.IPersonagem) e.getSource());

        p.getScreen().setPrefSize(200, 200);
        p.getScreen().setMaxSize(200, 200);

        box.getChildren().add(p.getScreen());
        box.getChildren().add(new Label("ATACA!!!"));


        boxArena.getChildren().add(box);

        pane.setCenter(boxArena);

    }

    @Override
    public void selecionarAlvo(RPGEvent event) {
        System.out.println(" executando a seleção e, exibição de alvos");

        StackPane boxArena = getCenterNode();

        boxArena.alignmentProperty().setValue(Pos.TOP_CENTER);

        VBox box = new VBox();
        box.alignmentProperty().setValue(Pos.TOP_CENTER);
        box.getChildren().add(new Label("EQUIPE HUMANA ATACA!!!"));


        PainelPersonagemNaEquipe pAtacante = new PainelPersonagemNaEquipe(jogo.getAtaque().getAtacante());

        pAtacante.getScreen().setPrefSize(200, 200);
        pAtacante.getScreen().setMaxSize(200, 200);

        box.getChildren().add(pAtacante.getScreen());

        box.getChildren().add(new Label(jogo.getAtaque().getAtacante().getNome() + " X " + jogo.getAtaque().getAlvo().getNome()));


        PainelPersonagemNaEquipe pAlvo = new PainelPersonagemNaEquipe((modelo.IPersonagem) event.getSource());

        pAlvo.getScreen().setPrefSize(200, 200);
        pAlvo.getScreen().setMaxSize(200, 200);

        box.getChildren().add(pAlvo.getScreen());

        Button btnContinuar = new Button("Continua");
        btnContinuar.setOnAction(action -> {

            jogo.getEventSource().addListener(jogo.getAtaque().getAlvo());


            jogo.getEventSource().disparaExecucaoAtaque(jogo);

        });

        box.getChildren().add(btnContinuar);

        boxArena.getChildren().add(box);

        pane.setCenter(boxArena);

    }

    @Override
    public void executaAtaque(RPGEvent event) {

        jogo.getEventSource().disparaSofrimentoAtaque(jogo.getAtaque().getAtacante());

        exibePersonagensEquipeJogador();
        exibePersonagensEquipeAdversaria();

        jogo.getEventSource().removeListener(jogo.getAtaque().getAlvo());


    }

    @Override
    public void sofreAtaque(RPGEvent event) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                exibePersonagensEquipeAdversaria();
                exibePersonagensEquipeJogador();
            }
        });


        /**
         * iniciando contra-ataque, ou seja após sofrer um ataque, o sistema deve revidar, ou seja disparar um outro ataque
         * É preciso, selecionar um personagem da lista de personagens da equipe da máquina, e depois selecionar uma ação(atacar ou curar )
         * e depois selecionar um alvo, que deve ser da equipe do jogardor humano. e então disparar um ataque.
         */
        StackPane boxArena = getCenterNode();

        boxArena.alignmentProperty().setValue(Pos.TOP_CENTER);

        VBox box = new VBox();
        box.alignmentProperty().setValue(Pos.CENTER);

        Label lblMsg = new Label();

        box.getChildren().add(lblMsg);


        boxArena.getChildren().add(box);

        pane.setCenter(boxArena);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lblMsg.textProperty().setValue("Processando contra - ataque!!!");

        jogo.selecionarAtacanteParaContraAtaque();
        jogo.iniciarAtaque(jogo.getAtaque().getAtacante());
        jogo.selecionaAlvoContraAtaque();
        jogo.getEventSource().disparaSelecaoDeAlvoContaAtaque(jogo.getAtaque().getAlvo());

    }

    @Override
    public void selecionarAlvoContraAtaque(RPGEvent event) {

        System.out.println(" executando a seleção e, exibição de alvos para Contra-ataque");

        StackPane boxArena = getCenterNode();

        boxArena.alignmentProperty().setValue(Pos.TOP_CENTER);

        VBox box = new VBox();
        box.alignmentProperty().setValue(Pos.TOP_CENTER);
        box.getChildren().add(new Label("EQUIPE MÁQUINA ATACA!!!"));


        PainelPersonagemNaEquipe pAtacante = new PainelPersonagemNaEquipe(jogo.getAtaque().getAtacante());

        pAtacante.getScreen().setPrefSize(200, 200);
        pAtacante.getScreen().setMaxSize(200, 200);

        box.getChildren().add(pAtacante.getScreen());
        box.getChildren().add(new Label(jogo.getAtaque().getAtacante().getNome() + " X " + jogo.getAtaque().getAlvo().getNome()));


        PainelPersonagemNaEquipe pAlvo = new PainelPersonagemNaEquipe((modelo.IPersonagem) event.getSource());

        pAlvo.getScreen().setPrefSize(200, 200);
        pAlvo.getScreen().setMaxSize(200, 200);

        box.getChildren().add(pAlvo.getScreen());

        Button btnContinuar = new Button("Continua");
        btnContinuar.setOnAction(action -> {

            jogo.getEventSource().addListener(jogo.getAtaque().getAlvo());


            jogo.getEventSource().disparaExecucaoAtaque(jogo);

        });

        box.getChildren().add(btnContinuar);

        boxArena.getChildren().add(box);

        pane.setCenter(boxArena);

    }


}
