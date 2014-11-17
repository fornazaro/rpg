package modelo;


public class Protagonista extends Personagem {

    protected double fatorIncremento;


    protected void calcularFatorIncremento() {


        fatorIncremento = this.vida / 2;

        System.out.println("calculando fator de incremento, para 50% da vida que o protagonista tiver");

        System.out.println(" vida: " + this.vida + " fatorIncremento: " + this.fatorIncremento);


    }



    @Override
    public String atacar(Personagem atacado) {
        return super.atacar(atacado);
    }

    public double getFatorIncremento() {
        return fatorIncremento;
    }

}
