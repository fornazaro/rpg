package modelo;


public class Placar {

    private String sobreviventesHumanos;

    private String sobreviventesMaquinas;

    private String vencedor;

    private String perdedor;

    private Boolean jogoFinalizado;

    public String getSobreviventesHumanos() {
        return sobreviventesHumanos;
    }

    public void setSobreviventesHumanos(String sobreviventesHumanos) {
        this.sobreviventesHumanos = sobreviventesHumanos;
    }

    public String getSobreviventesMaquinas() {
        return sobreviventesMaquinas;
    }

    public void setSobreviventesMaquinas(String sobreviventesMaquinas) {
        this.sobreviventesMaquinas = sobreviventesMaquinas;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(String perdedor) {
        this.perdedor = perdedor;
    }

    public Placar(String sobreviventesHumanos, String sobreviventesMaquinas, String vencedor, String perdedor) {
        this.sobreviventesHumanos = sobreviventesHumanos;
        this.sobreviventesMaquinas = sobreviventesMaquinas;
        this.vencedor = vencedor;
        this.perdedor = perdedor;
    }

    public Placar() {

    }

    public Boolean getJogoFinalizado() {
        return jogoFinalizado;
    }

    public void setJogoFinalizado(Boolean jogoFinalizado) {
        this.jogoFinalizado = jogoFinalizado;
    }

    @Override
    public String toString() {
        return "Placar{" +
                "sobreviventesHumanos='" + sobreviventesHumanos + '\'' +
                ", sobreviventesMaquinas='" + sobreviventesMaquinas + '\'' +
                ", vencedor='" + vencedor + '\'' +
                ", perdedor='" + perdedor + '\'' +
                ", jogoFinalizado=" + jogoFinalizado +
                '}';
    }
}
