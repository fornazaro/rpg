package modelo;


public class Personagem {

    protected String nome;
    protected int dano;
    protected int resistencia;
    protected String urlImagem = null;
    protected String descricao;
    protected  int vida = 100;


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

    public String getDescricao() {

        return descricao;
    }

    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", dano=" + dano +
                ", vida=" + vida +
                '}';
    }
}
