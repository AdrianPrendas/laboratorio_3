package bl;

import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public interface BaseBL<T,K> {
    //CRUD
    public boolean create(T o);
    public T read(K key);
    public List<T> read();
    public boolean update(T o);
    public boolean delete(K key);
}
