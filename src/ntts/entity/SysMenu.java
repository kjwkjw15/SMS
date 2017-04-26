package ntts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sysmenu",uniqueConstraints = {@UniqueConstraint(columnNames="menuId")})
public class SysMenu {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String menuId;
	private String menuName;
	private String perentId;
	private Integer isValid;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getPerentId() {
		return perentId;
	}
	public void setPerentId(String perentId) {
		this.perentId = perentId;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public void SysMenu(){
		System.out.println("fuck Menu");
	}
	
}
