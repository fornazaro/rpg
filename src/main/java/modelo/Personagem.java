package modelo;


import eventos.RPGEvent;
import javafx.beans.property.SimpleObjectProperty;

public class Personagem {

    protected String nome;
    protected int dano;
    protected int resistencia;
    protected String urlImagem = null;
    protected String descricao;
    protected int vida = 40;

    protected SimpleObjectProperty<StatusPersonagem> statusPersonagemProperty;

    public Personagem() {
        this.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.VIVO);


    }

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


    public StatusPersonagem getStatusPersonagemProperty() {
        return statusPersonagemProperty.get();
    }

    public SimpleObjectProperty<StatusPersonagem> statusPersonagemProperty() {
        return statusPersonagemProperty;
    }




    public void sofreAtaque(RPGEvent event) {

        IPersonagem atacante = (IPersonagem) event.getSource();
        /**descontar o dano do ataque da vida do personagem,  e depois acrescentando a resistência, caso o atacante seja antagonista, seu poder de ataque é dobrado**/


        if (!statusPersonagemProperty.get().equals(StatusPersonagem.MORTO)) {
            int saldo = 0;

            if (atacante instanceof Antagonista) {
                saldo = (this.vida - (atacante.getDano() * 2)) + this.resistencia;
            } else {
                saldo = (this.vida - atacante.getDano()) + this.resistencia;
            }


            this.vida = saldo;
        }

        if (vida < 1) {
            this.statusPersonagemProperty.setValue(StatusPersonagem.MORTO);
        }


    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", status=" + statusPersonagemProperty +
                '}';
    }
}
