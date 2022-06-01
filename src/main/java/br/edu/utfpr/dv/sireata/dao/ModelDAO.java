package br.edu.utfpr.dv.sireata.dao;
//SEGUINDO O MESMO PADRÃO DE https://github.com/gabrielcostasilva/dp-factory-method/blob/original-structure/src/main/java/com/example/product/AbstractDataRetriever.java
import java.sql.SQLException;

public abstract class ModelDAO<E> {
    public abstract E buscarPorId(int id) throws SQLException;
    public abstract int salvar(E obj) throws SQLException;
}
