package modelo.personagens;


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
}
