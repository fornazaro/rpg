package eventos;

import java.util.EventObject;


public class RPGEvent extends EventObject {

    private static final long serialVersionUID = 5516075349620653481L;

    public RPGEvent(final Object source) {
        super(source);
    }
}
