package br.com.opeads.service.genericinterfaceservice;

import java.io.Serializable;
import java.util.List;

public interface GenericInterfaceService <E> extends Serializable{

	List<E> listar();
    
    void remover(E e);
    
    E buscaPorId(E e);
	
}
