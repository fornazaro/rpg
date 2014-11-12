package modelo.personagens;


import eventos.RPGEvent;
import modelo.Antagonista;
import modelo.IPersonagem;
import modelo.Protagonista;


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

    @Override
    public Mago clone() throws CloneNotSupportedException {

        Mago nova = new Mago();

        nova.vida = this.vida;
        nova.dano = this.dano;
        nova.nome = this.nome;
        nova.resistencia = this.resistencia;
        nova.descricao = this.descricao;

        return nova;
    }


}
