package modelo.personagens;

import controle.Jogo;
import eventos.RPGEvent;
import javafx.beans.property.SimpleObjectProperty;
import modelo.Antagonista;
import modelo.IPersonagem;
import modelo.Protagonista;
import modelo.StatusPersonagem;


public class Guerreiro extends Antagonista implements IPersonagem {

    public Guerreiro() {
        //  urlImagem = this.getClass().getResourceAsStream("guerreiro.jpg").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome = "GUERREIRO";

        this.descricao = " Antagonista,\n causa dano de : " + this.dano + " \n e tem resistência de : " + this.resistencia;
    }

    @Override
    public double getDano() {
        return this.dano;
    }

    @Override
    public double getResistencia() {
        return this.resistencia;
    }

    @Override
    public String getUrlImagem() {
        return this.urlImagem;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void iniciaAtaqueListener(RPGEvent e) {

    }

    @Override
    public void selecionarAlvo(RPGEvent event) {

    }

    @Override
    public void executaAtaque(RPGEvent event) {

    }

    @Override
    public void selecionarAlvoContraAtaque(RPGEvent event) {

    }

    @Override
    public void atualizaSituacaoJogo(RPGEvent event) {

    }

    @Override
    public void iniciaCuraListener(RPGEvent event) {

    }


    @Override
    public Guerreiro clone() throws CloneNotSupportedException {

        Guerreiro nova = new Guerreiro();

        nova.vida = this.vida;
        nova.dano = this.dano;
        nova.nome = this.nome;
        nova.resistencia = this.resistencia;
        nova.descricao = this.descricao;


        if (this.statusPersonagemProperty().get().equals(StatusPersonagem.VIVO)) {
            nova.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.VIVO);
        } else if (this.statusPersonagemProperty().get().equals(StatusPersonagem.MORTO)) {
            nova.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.MORTO);
        } else if (this.statusPersonagemProperty().get().equals(StatusPersonagem.ATACANDO)) {
            nova.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.ATACANDO);
        } else if (this.statusPersonagemProperty().get().equals(StatusPersonagem.SELECIONADO)) {
            nova.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.SELECIONADO);
        } else if (this.statusPersonagemProperty().get().equals(StatusPersonagem.SENDO_ATACADO)) {
            nova.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.SENDO_ATACADO);
        }


        return nova;
    }

    @Override
    public void sofreAtaque(RPGEvent event) {
        super.sofreAtaque(event);
        this.jogo.getEventSource().removeListener(this);
    }

    public void incrementaVida(RPGEvent event) {

        System.out.println("executando cura no Personagem Guerreiro");

        Jogo curador = (Jogo) event.getSource();

        if (jogo.getAtaque().getAtacante() instanceof Protagonista) {
            Protagonista p = (Protagonista) jogo.getAtaque().getAtacante();

            this.vida = (this.vida + p.getFatorIncremento());

        }


    }


}
