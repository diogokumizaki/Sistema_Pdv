
package dao;

import java.util.List;


public interface PatternDao<T> {
    // Metodos a serem implementados
    public void insert(T obj);
    public void update(T obj);
    public void delete(int codigo);
    public List<T> listAll();
    
}
