/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;

/**
 *
 * @author Admin
 */
abstract public class QLQN <E, K>{
    abstract public boolean insert(E entity)throws Exception;
    abstract public boolean update(E entity)throws Exception;
    abstract public boolean delete(K key)throws Exception;
    abstract public List<E> selectAll() throws Exception;
    abstract public E selectById(K key) throws Exception;
}
