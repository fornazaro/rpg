package eventos;

import java.util.ArrayList;
import java.util.Collection;


public class RPGEventSource {


    private Collection<RPGEventListener> eventListeners = new ArrayList<RPGEventListener>();


    public void disparaInicioAtaque() {
        RPGEvent event = new RPGEvent(this);
        for (RPGEventListener listener : cloneListeners()) {
            listener.iniciaAtaqueListener(event);
        }
    }

    public void disparaInicioAtaque(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.iniciaAtaqueListener(event);
        }
    }

    public void disparaSelecaoDeAlvo(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.selecionarAlvo(event);
        }
    }

    public void disparaExecucaoAtaque(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.executaAtaque(event);
        }
    }

    public void disparaExecucaoCura(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.incrementaVida(event);
        }

    }

    public void disparaInicioCura(Object source) {

        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.iniciaCuraListener(event);
        }

    }

    public void disparaSofrimentoAtaque(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.sofreAtaque(event);
        }
    }

    public void disparaSelecaoDeAlvoCura(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.selecionarAlvoCura(event);
        }
    }

    public void disparaSelecaoDeAlvoContaAtaque(Object source) {
        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.selecionarAlvoContraAtaque(event);
        }

    }

    public void disparaAtualizaSituacaoJogo(Object source) {

        RPGEvent event = new RPGEvent(source);
        for (RPGEventListener listener : cloneListeners()) {
            listener.atualizaSituacaoJogo(event);
        }

    }


    public synchronized void addListener(RPGEventListener listener) {
        if (!eventListeners.contains(listener)) {
            eventListeners.add(listener);
        }
    }

    public synchronized void removeListener(RPGEventListener listener) {
        if (eventListeners.contains(listener)) {
            eventListeners.remove(listener);
        }
    }


    @SuppressWarnings("unchecked")
    private Collection<RPGEventListener> cloneListeners() {

        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação

            return (Collection<RPGEventListener>) (((ArrayList<RPGEventListener>) eventListeners).clone());
        }
    }



}
