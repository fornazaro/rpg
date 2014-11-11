package controle;

import modelo.IPersonagem;

import java.util.ArrayList;
import java.util.List;

/**
 * Jogo RPG
 * **/
public class Jogo {

    private static Jogo instance;


    private List<IPersonagem> equipe1 = new ArrayList<IPersonagem>();

    private List<IPersonagem> equipe2 = new ArrayList<IPersonagem>();

    private Jogo() {

    }


    public static Jogo getInstance() {
        if (instance == null) {
            instance = new Jogo();
        }

        return instance;
    }

    public void inicio() {

        System.out.println(" Iniciando o jogo") ;
        /**
         * montar a interface inicial do jogo, inializar os objetos necessários
         */

        System.out.println(" Monte sua equipe;");



    }
}
