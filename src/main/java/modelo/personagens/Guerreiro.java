package modelo.personagens;

import modelo.Antagonista;
import modelo.IPersonagem;


public class Guerreiro extends Antagonista implements IPersonagem {

    public Guerreiro() {
      //  urlImagem = this.getClass().getResourceAsStream("guerreiro.jpg").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome  = "GUERREIRO";

        this.descricao = " Antagonista,\n causa dano de : " + this.dano + " \n e tem resistência de : " + this.resistencia;
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
}
