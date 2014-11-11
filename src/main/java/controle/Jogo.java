package controle;

import modelo.IPersonagem;
import modelo.personagens.Bruxa;
import modelo.personagens.Cavaleiro;
import modelo.personagens.Guerreiro;
import modelo.personagens.Mago;

import java.util.ArrayList;
import java.util.List;

/**
 * Jogo RPG
 * *
 */
public class Jogo {

    private static Jogo instance;

    private List<IPersonagem> personagems = new ArrayList<IPersonagem>();


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

        System.out.println(" Iniciando o jogo");
        /**
         * montar a interface inicial do jogo, inializar os objetos necessários
         */

        System.out.println(" Monte sua equipe, exibindo os personagens disponíveis");

        personagems.add(new Bruxa());
        personagems.add(new Guerreiro());
        personagems.add(new Mago());
        personagems.add(new Cavaleiro());


    }

    public List<IPersonagem> getPersonagems() {
        return personagems;
    }
}
