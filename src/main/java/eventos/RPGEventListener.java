package eventos;

import java.util.EventListener;


public interface RPGEventListener extends EventListener  {

    void iniciaAtaqueListener(RPGEvent e);

    void selecionarAlvo(RPGEvent event);

    void executaAtaque(RPGEvent event);

    void sofreAtaque(RPGEvent event) ;

    void selecionarAlvoContraAtaque(RPGEvent event);

    void atualizaSituacaoJogo(RPGEvent event);

    void selecionarAlvoCura(RPGEvent event);

    void incrementaVida(RPGEvent event);

    void iniciaCuraListener(RPGEvent event);
}
