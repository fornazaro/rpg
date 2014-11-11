package modelo.personagens;

import modelo.IPersonagem;
import modelo.Protagonista;

/**
 * Created by ton on 07/11/14.
 */
public class Cavaleiro extends Protagonista implements IPersonagem {

    


    public Cavaleiro() {
      //  urlImagem = this.getClass().getResourceAsStream("cavaleiro.jpg").toString();
        this.dano = 10;
        this.resistencia = 5;
        this.nome ="CAVALEIRO";
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


}
