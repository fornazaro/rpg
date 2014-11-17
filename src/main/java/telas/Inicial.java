package telas;

import controle.Jogo;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.IPersonagem;


public class Inicial {
    private VBox box = new VBox();
    private HBox boxDisponiveis = new HBox();
    private Jogo jogo = Jogo.getInstance();

    private VBox boxEquipeJogador = new VBox();

    private ToolBar toolBar = new ToolBar();

    public Inicial() {
        box.setPrefSize(800, 600);

        HBox boxMessage = new HBox();
        boxMessage.getChildren().add(new Label("Início, monte sua equipe, adicionando personagens de acordo com a lista abaixo"));
        box.getChildren().add(boxMessage);
        boxDisponiveis.setPrefSize(780, 282);

        boxEquipeJogador.setPrefSize(780, 280);

        jogo.getEquipeJogador().addListener(new ListChangeListener<IPersonagem>() {
            @Override
            public void onChanged(Change<? extends IPersonagem> c) {

                boxEquipeJogador.getChildren().clear();
                c.getList().stream().forEach(p -> {
                    adicionaPersonagemNaEquipe(p);
                });
            }


        });


        Button btnIniciaJogo = new Button("Iniciar novo Jogo");
        toolBar.getItems().add(btnIniciaJogo);


        btnIniciaJogo.setOnAction(click -> {
            Arena arena = new Arena();
            try {
                arena.start(jogo.getStage());

                jogo.getEventSource().addListener(arena);
            } catch (Exception e) {
                e.printStackTrace();
            }


        });


        box.getChildren().addAll(boxDisponiveis, new Label("Jogadores selecionados"), boxEquipeJogador, toolBar);


    }

    public VBox getScreen() {


        return box;
    }


    public void addPersonagemDisponivel(PainelPersonagemDisponivel personagemDisponivel) {
        boxDisponiveis.getChildren().add(new Separator());
        personagemDisponivel.getScreen().maxWidthProperty().setValue(100);
        personagemDisponivel.getScreen().paddingProperty().setValue(new Insets(5));
        boxDisponiveis.getChildren().add(personagemDisponivel.getScreen());
    }

    private void adicionaPersonagemNaEquipe(IPersonagem p) {
        PainelPersonagemNaEquipe naEquipe = new PainelPersonagemNaEquipe(p);
        boxEquipeJogador.getChildren().add(new Separator());
        naEquipe.getScreen().maxWidthProperty().setValue(100);
        naEquipe.getScreen().paddingProperty().setValue(new Insets(5));
        boxEquipeJogador.getChildren().add(naEquipe.getScreen());

    }
}
