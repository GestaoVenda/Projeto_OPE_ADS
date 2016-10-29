package br.com.opeads.service.genericinterface;

import java.io.Serializable;
import java.util.List;

public interface GenericInterface <E> extends Serializable{

	List<E> listar();
    
    void inserir(E e);
    
    void alterar(E e);
    
    void remover(E e);
    
    E listarPorId(E e);
	
}
