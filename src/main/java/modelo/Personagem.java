package modelo;


public class Personagem {

    protected String nome;
    protected int quantidadeDeVida;
    protected int dano;
    protected int resistencia;


    public int getDano() {
        return this.dano;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public String atacar(Personagem atacado) {
        return null;
    }

    public void reagir(int reducao) {

    }


}
