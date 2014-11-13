package modelo.personagens;


import eventos.RPGEvent;
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
