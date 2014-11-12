package modelo;


import eventos.RPGEventListener;

public interface IPersonagem extends RPGEventListener,Cloneable {

    public String getUrlImagem();

    public String getNome();

    public String getDescricao();

    public int getVida();

    public int getDano();




}
