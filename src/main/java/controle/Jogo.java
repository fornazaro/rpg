package controle;

import eventos.RPGEventSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modelo.IPersonagem;
import modelo.Placar;
import modelo.StatusPersonagem;
import modelo.personagens.Bruxa;
import modelo.personagens.Cavaleiro;
import modelo.personagens.Guerreiro;
import modelo.personagens.Mago;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Jogo RPG
 * <p/>
 * Padrão singleton
 */
public class Jogo {

    private static Jogo instance;

    private Stage stage;

    private ObservableList<IPersonagem> equipeJogador = FXCollections.observableArrayList();

    private List<IPersonagem> personagems = new ArrayList<IPersonagem>();

    private List<IPersonagem> equipeMaquinas = new ArrayList<IPersonagem>();

    private Acao ataque;

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

        personagems.add(new Mago());
        personagems.add(new Cavaleiro());
        personagems.add(new Bruxa());
        personagems.add(new Guerreiro());


    }

    public List<IPersonagem> getPersonagems() {
        return personagems;
    }

    public void addNovoPersonagemNaEquipe(IPersonagem personagem) {


        try {
            if (!equipeJogador.contains(personagem)) {

                equipeJogador.add(personagem);
            } else {

                if (personagem instanceof Mago) {
                    equipeJogador.add(((Mago) personagem).clone());
                } else if (personagem instanceof Cavaleiro) {
                    equipeJogador.add(((Cavaleiro) personagem).clone());
                } else if (personagem instanceof Bruxa) {
                    equipeJogador.add(((Bruxa) personagem).clone());
                } else if (personagem instanceof Guerreiro) {
                    equipeJogador.add(((Guerreiro) personagem).clone());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

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

        this.equipeMaquinas = null;

        this.equipeMaquinas = new ArrayList<>();

        listaOrigem.forEach(obj -> {

            if (obj instanceof Bruxa) {
                Bruxa bruxa = (Bruxa) obj;

                try {
                    Bruxa nova = bruxa.clone();
                    this.equipeMaquinas.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Cavaleiro) {
                Cavaleiro cavaleiro = (Cavaleiro) obj;

                try {
                    Cavaleiro nova = cavaleiro.clone();
                    this.equipeMaquinas.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Guerreiro) {

                Guerreiro guerreiro = (Guerreiro) obj;

                try {
                    Guerreiro nova = guerreiro.clone();
                    this.equipeMaquinas.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            } else if (obj instanceof Mago) {

                Mago mago = (Mago) obj;

                try {
                    Mago nova = mago.clone();
                    this.equipeMaquinas.add(nova);

                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }


        });

    }

    public void iniciarAtaque(IPersonagem p) {
        this.ataque = null;
        this.ataque = new Acao();
        this.ataque.iniciarAcao(p);

        eventSource.disparaInicioAtaque(p);


    }

    public void iniciaCura(IPersonagem p) {
        this.ataque = null;
        this.ataque = new Acao();
        //selecionando o personagem que vai disparar a cura
        this.ataque.iniciarAcao(p);

        eventSource.addListener(p);
        eventSource.disparaInicioCura(p);


    }

    public List<IPersonagem> getEquipeMaquinas() {
        return equipeMaquinas;
    }

    public void selecionarAlvoAtaque(IPersonagem alvo) {
        this.ataque.selecionaAlvo(alvo);

        eventSource.disparaSelecaoDeAlvo(alvo);

    }

    public RPGEventSource getEventSource() {

        return eventSource;
    }

    public Acao getAtaque() {
        return ataque;
    }


    /**
     * Pode ser implementado um algorítmo que leve N fatores em consideração para o momento de escolher qual personagem
     * vai disparar o contra-ataque, no momento o único critério adotado é que o personagem esteja vivo.
     */
    public void selecionarAtacanteParaContraAtaque() {


        this.equipeMaquinas.stream().forEach(new Consumer<IPersonagem>() {
            @Override
            public void accept(IPersonagem personagem) {
                if (personagem.statusPersonagemProperty().getValue().equals(StatusPersonagem.VIVO)) {
                    iniciarAtaque(personagem);
                    return;
                }
            }
        });


    }

    /**
     * Deve ser implementada uma regra, de acordo com a descrição do trabalho para seleção do alvo
     * do contra-ataque por parte do sistema.
     */
    public void selecionaAlvoContraAtaque() {

        this.equipeJogador.stream().forEach(new Consumer<IPersonagem>() {
            @Override
            public void accept(IPersonagem personagem) {
                if (personagem.statusPersonagemProperty().getValue().equals(StatusPersonagem.VIVO)) {
                    ataque.selecionaAlvo(personagem);
                    return;
                }
            }
        });


    }

    public Placar analizaSituacaoJogo() {

        Placar placar = new Placar();

        //existem personagens vivos na equipe do jogador

        Integer humanosVivos = 0;

        for (IPersonagem humano : this.equipeJogador) {
            if (humano.statusPersonagemProperty().getValue().equals(StatusPersonagem.VIVO)) {
                humanosVivos++;
            }
        }

        placar.setSobreviventesHumanos(humanosVivos.toString());

        //existem personagens vivos na equipe do MAQUINA

        Integer maquinasVivas = 0;

        for (IPersonagem humano : this.equipeMaquinas) {
            if (humano.statusPersonagemProperty().getValue().equals(StatusPersonagem.VIVO)) {
                maquinasVivas++;
            }
        }

        placar.setSobreviventesMaquinas(maquinasVivas.toString());

        if (humanosVivos.equals(0) || maquinasVivas.equals(0)) {
            placar.setJogoFinalizado(true);
        } else {
            placar.setJogoFinalizado(false);
        }

        if (placar.getJogoFinalizado()) {
            if (humanosVivos > maquinasVivas) {
                placar.setVencedor("HUMANOS VENCERAM A PARTIDA!!!");
                placar.setPerdedor("MÁQUINAS PERDERAM A PARTIDA!!!");
            } else {
                placar.setVencedor("MAQUINAS VENCERAM A PARTIDA!!!");
                placar.setPerdedor("HUMANOS PERDERAM A PARTIDA!!!");

            }
        }


        return placar;
    }

    public void selecionarAlvoCura(IPersonagem alvo) {
        System.out.println(" selecionando alvo cura no jogo");
        this.ataque.selecionaAlvo(alvo);

        eventSource.disparaSelecaoDeAlvoCura(alvo);
    }
}
