package modelo;


import controle.Jogo;
import eventos.RPGEvent;
import javafx.beans.property.SimpleObjectProperty;

public class Personagem {


    protected Jogo jogo = Jogo.getInstance();

    protected String nome;
    protected double dano;
    protected double resistencia;
    protected String urlImagem = null;
    protected String descricao;
    protected double vida = 40;


    protected SimpleObjectProperty<StatusPersonagem> statusPersonagemProperty;

    public Personagem() {
        this.statusPersonagemProperty = new SimpleObjectProperty<>(StatusPersonagem.VIVO);


    }

    public double getDano() {
        return this.dano;
    }

    public double getResistencia() {
        return this.resistencia;
    }

    public String atacar(Personagem atacado) {
        return null;
    }

    public void reagir(double reducao) {

    }

    public String getDescricao() {

        return descricao;
    }

    public double getVida() {
        return vida;
    }


    public StatusPersonagem getStatusPersonagemProperty() {
        return statusPersonagemProperty.get();
    }

    public SimpleObjectProperty<StatusPersonagem> statusPersonagemProperty() {
        return statusPersonagemProperty;
    }


    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                ", status=" + statusPersonagemProperty +
                '}';
    }

    public void sofreAtaque(RPGEvent event) {
        IPersonagem atacante = (IPersonagem) event.getSource();
        /**descontar o dano do ataque da vida do personagem,  e depois acrescentando a resistência, caso o atacante seja antagonista, seu poder de ataque é dobrado**/

        if (atacante.statusPersonagemProperty().getValue().equals(StatusPersonagem.VIVO)) {

            if (!atacante.equals(this)) {


                if (!statusPersonagemProperty.get().equals(StatusPersonagem.MORTO)) {
                    double saldo = 0;

                    if (atacante instanceof Antagonista) {
                        saldo = (this.vida - (atacante.getDano() * 2)) + this.resistencia;
                    } else {
                        saldo = (this.vida - atacante.getDano()) + this.resistencia;
                    }


                    this.vida = saldo;
                }

                if (vida < 1) {
                    this.statusPersonagemProperty.setValue(StatusPersonagem.MORTO);
                    jogo.getEventSource().disparaAtualizaSituacaoJogo(this);
                }


            }
        } else {
            System.out.println(" Atacante morto no momento do ataque");
        }


    }


    public void selecionarAlvoCura(RPGEvent event) {
        System.out.println("executando selecionarAlvoCura nos personagens");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personagem that = (Personagem) o;

        if (dano != that.dano) return false;
        if (resistencia != that.resistencia) return false;
        if (vida != that.vida) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (jogo != null ? !jogo.equals(that.jogo) : that.jogo != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (statusPersonagemProperty != null ? !statusPersonagemProperty.equals(that.statusPersonagemProperty) : that.statusPersonagemProperty != null)
            return false;
        if (urlImagem != null ? !urlImagem.equals(that.urlImagem) : that.urlImagem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = jogo != null ? jogo.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        temp = Double.doubleToLongBits(dano);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(resistencia);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (urlImagem != null ? urlImagem.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        temp = Double.doubleToLongBits(vida);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (statusPersonagemProperty != null ? statusPersonagemProperty.hashCode() : 0);
        return result;
    }
}