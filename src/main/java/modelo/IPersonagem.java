package modelo;


import eventos.RPGEventListener;
import javafx.beans.property.SimpleObjectProperty;

public interface IPersonagem extends RPGEventListener, Cloneable {

    public String getUrlImagem();

    public String getNome();

    public String getDescricao();

    public int getVida();

    public int getDano();

    public SimpleObjectProperty<StatusPersonagem> statusPersonagemProperty();


}
