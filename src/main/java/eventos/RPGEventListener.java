package eventos;

import java.util.EventListener;


public interface RPGEventListener extends EventListener {


    void iniciaAtaqueListener(RPGEvent e);


    void selecionarAlvo(RPGEvent event);
}
