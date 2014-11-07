import controle.Jogo;
import org.junit.Test;

/**
 * Created by ton on 07/11/14.
 */
public class TesteJogo {

    @Test
    public void testaJogo() {

        Jogo jogo = Jogo.getInstance();

        jogo.inicio();

    }
}
