package controle;

import modelo.IPersonagem;


public class Acao {


    private IPersonagem atacante;

    private IPersonagem alvo;

    public void iniciarAcao(IPersonagem p) {
        //finalizando ataque
        atacante = null;
        alvo = null;
        //iniciando novo ataque, selecionando o atacante

        atacante = p;

        System.out.println("Ataque iniciado, o atacante é: " + p.toString());
    }


    public void selecionaAlvo(IPersonagem alvo) {
        this.alvo = alvo;

        System.out.println(" alvo selecionado!!!");

        System.out.println(" Atacante: " + this.atacante + " alvo --> " + this.alvo);

    }

    public void executarAtaque() {
        System.out.println(" executando ataque!!!");
    }

    public IPersonagem getAtacante() {
        return atacante;
    }

    public IPersonagem getAlvo() {
        return alvo;
    }
}
