package br.com.opeads.service.genericinterfaceservice;

import java.io.Serializable;
import java.util.List;

public interface GenericInterfaceService <E> extends Serializable{

	List<E> read();
    
    void delete(E e);
    
    E findById(E e);
	
}
