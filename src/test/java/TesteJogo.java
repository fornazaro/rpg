import controle.Jogo;
import javafx.scene.image.Image;
import org.junit.Test;

import java.awt.*;
import java.io.File;

/**
 * Created by ton on 07/11/14.
 */
public class TesteJogo {

    @Test
    public void testaJogo() {

        Jogo jogo = Jogo.getInstance();

        jogo.inicio();
        String url = "";

        try {
/*            url = this.getClass().getResourceAsStream("mago.png").toString();



            Image  image = new Image(url);*/

            //File file = new File();






        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(url);

        //teste

    }
}
