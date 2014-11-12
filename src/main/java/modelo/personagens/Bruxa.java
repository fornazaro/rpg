package modelo.personagens;

import eventos.RPGEvent;
import modelo.Antagonista;
import modelo.IPersonagem;


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
    public void sofreAtaque(RPGEvent event) {

        IPersonagem atacante = (IPersonagem) event.getSource();
        /**descontar o dano do ataque da vida do personagem,  e depois acrescentando a resistência, caso o atacante seja antagonista, seu poder de ataque é dobrado**/


        int saldo = 0;

        if (atacante instanceof Antagonista) {
            saldo = (this.vida - (atacante.getDano() * 2)) + this.resistencia;
        } else {
            saldo = (this.vida - atacante.getDano()) + this.resistencia;
        }


        this.vida = saldo;


    }
}
