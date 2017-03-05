package br.com.opeads.model.helpers;

import java.io.Serializable;

public class MainMenuNameId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idMainMenu;
	
	private String name;

	public Long getIdMainMenu() {
		return idMainMenu;
	}

	public void setIdMainMenu(Long idMainMenu) {
		this.idMainMenu = idMainMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public  int hashCode() {
        return (idMainMenu + name).hashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MainMenuNameId){
        	MainMenuNameId mainMenuNameId = (MainMenuNameId) obj;
            return mainMenuNameId.idMainMenu == idMainMenu && mainMenuNameId.name == name;
        }
 
        return false;
    }
}
