package controle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modelo.IPersonagem;
import modelo.personagens.Bruxa;
import modelo.personagens.Cavaleiro;
import modelo.personagens.Guerreiro;
import modelo.personagens.Mago;

import java.util.ArrayList;
import java.util.List;

/**
 * Jogo RPG
 * *
 */
public class Jogo {

    private static Jogo instance;

    private Stage stage ;

    private ObservableList<IPersonagem> equipeJogador = FXCollections.observableArrayList();

    private List<IPersonagem> personagems = new ArrayList<IPersonagem>();


    // private List<IPersonagem> equipeJogador = new ArrayList<IPersonagem>();

    private List<IPersonagem> equipeMaquina = new ArrayList<IPersonagem>();

    private Jogo() {

    }


    public static Jogo getInstance() {
        if (instance == null) {
            instance = new Jogo();
        }

        return instance;
    }

    public void inicio() {

        System.out.println(" Iniciando o jogo");
        /**
         * montar a interface inicial do jogo, inializar os objetos necessários
         */

        System.out.println(" Monte sua equipe, exibindo os personagens disponíveis");

        personagems.add(new Bruxa());
        personagems.add(new Guerreiro());
        personagems.add(new Mago());
        personagems.add(new Cavaleiro());


    }

    public List<IPersonagem> getPersonagems() {
        return personagems;
    }

    public void addNovoPersonagemNaEquipe(IPersonagem personagem) {

        equipeJogador.add(personagem);

    }

    public ObservableList<IPersonagem> getEquipeJogador() {
        return equipeJogador;
    }

    public Stage getStage() {

        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
