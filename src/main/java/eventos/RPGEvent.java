package eventos;

import java.util.EventObject;

/**
 * Classe implementada com o objetivo de servir de base de eventos para um formulário com sub-formularios ou formulários mestre detalhe
 *
 */
public class RPGEvent extends EventObject {

    private static final long serialVersionUID = 5516075349620653481L;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     *
     * @throws IllegalArgumentException if source is null.
     */
    public RPGEvent(final Object source) {
        super(source);
    }
}
