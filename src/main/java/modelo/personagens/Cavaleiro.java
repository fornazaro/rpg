package modelo.personagens;

import eventos.RPGEvent;
import javafx.beans.property.SimpleObjectProperty;
import modelo.Antagonista;
import modelo.IPersonagem;
import modelo.Protagonista;
import modelo.StatusPersonagem;


public class Cavaleiro extends Protagonista implements IPersonagem {


    public Cavaleiro() {
        //  urlImagem = this.getClass().getResourceAsStream("cavaleiro.jpg").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome = "CAVALEIRO";
        this.descricao = " Protagonista, \ncausa dano de : " + this.dano + " \n e tem resistência de : " + this.resistencia;
    }

    @Override
    public int getDano() {
        return this.dano;
    }

    @Override
    public int getResistencia() {
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
    public Cavaleiro clone() throws CloneNotSupportedException {

        Cavaleiro nova = new Cavaleiro();

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


}
