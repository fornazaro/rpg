package modelo.personagens;


import eventos.RPGEvent;
import javafx.beans.property.SimpleObjectProperty;
import modelo.IPersonagem;
import modelo.Protagonista;
import modelo.StatusPersonagem;


public class Mago extends Protagonista implements IPersonagem {


    public Mago() {
        //   urlImagem = this.getClass().getResourceAsStream("mago.png").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome = "MAGO";

        this.descricao = " Protagonista,\n causa dano de : " + this.dano + " \n e tem resistência de : " + this.resistencia;

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
        return urlImagem;
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
    public Mago clone() throws CloneNotSupportedException {

        Mago nova = new Mago();

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



}
