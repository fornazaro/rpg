package modelo.personagens;

import eventos.RPGEvent;
import modelo.Antagonista;
import modelo.IPersonagem;
import modelo.StatusPersonagem;


public class Bruxa extends Antagonista implements IPersonagem {
    public Bruxa() {
        //  urlImagem = this.getClass().getResourceAsStream("bruxav.jpg").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome = "BRUXA";
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
    public Bruxa clone() throws CloneNotSupportedException {

        Bruxa nova = new Bruxa();

        nova.vida = this.vida;
        nova.dano = this.dano;
        nova.nome = this.nome;
        nova.resistencia = this.resistencia;
        nova.descricao = this.descricao;

        return nova;
    }


}
