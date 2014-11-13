package controle;

import eventos.RPGEventSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modelo.IPersonagem;
import modelo.StatusPersonagem;
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

    private Stage stage;

    private ObservableList<IPersonagem> equipeJogador = FXCollections.observableArrayList();

    private List<IPersonagem> personagems = new ArrayList<IPersonagem>();

    private List<IPersonagem> equipeAdversaria = new ArrayList<IPersonagem>();

    private Ataque ataque;

    private RPGEventSource eventSource = new RPGEventSource();


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

    public void buildEquipeAdversaria() {
        List<IPersonagem> listaOrigem = this.equipeJogador;


        this.equipeAdversaria = null;

        this.equipeAdversaria = new ArrayList<>();

        listaOrigem.forEach(obj -> {

            if (obj instanceof Bruxa) {
                Bruxa bruxa = (Bruxa) obj;

                try {
                    Bruxa nova = bruxa.clone();
                    this.equipeAdversaria.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Cavaleiro) {
                Cavaleiro cavaleiro = (Cavaleiro) obj;

                try {
                    Cavaleiro nova = cavaleiro.clone();
                    this.equipeAdversaria.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Guerreiro) {

                Guerreiro guerreiro = (Guerreiro) obj;

                try {
                    Guerreiro nova = guerreiro.clone();
                    this.equipeAdversaria.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Mago) {

                Mago mago = (Mago) obj;

                try {
                    Mago nova = mago.clone();
                    this.equipeAdversaria.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }


        });

    }

    public void iniciarAtaque(IPersonagem p) {
        this.ataque = null;
        this.ataque = new Ataque();
        this.ataque.iniciarAtaque(p);

        eventSource.disparaInicioAtaque(p);


    }

    public void curar() {

    }

    public List<IPersonagem> getEquipeAdversaria() {
        return equipeAdversaria;
    }

    public void selecionarAlvoAtaque(IPersonagem alvo) {
        this.ataque.selecionaAlvo(alvo);

        eventSource.disparaSelecaoDeAlvo(alvo);

    }

    public RPGEventSource getEventSource() {

        return eventSource;
    }

    public Ataque getAtaque() {
        return ataque;
    }


    /**
     * Pode ser implementado um algorítmo que leve N fatores em consideração para o momento de escolher qual personagem
     * vai disparar o contra-ataque, no momento o único critério adotado é que o personagem esteja vivo.
     */
    public void selecionarAtacanteParaContraAtaque() {

        this.equipeAdversaria.forEach(p -> {
            if (p.statusPersonagemProperty().equals(StatusPersonagem.VIVO)) {
                iniciarAtaque(p);
                return;
            }
        });

    }

    public void selecionaAlvoContraAtaque() {
        this.equipeJogador.forEach(p -> {
            ataque.selecionaAlvo(p);
            return;

        });

    }
}
