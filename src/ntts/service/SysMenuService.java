package ntts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ntts.dao.SysMenuDAO;
import ntts.entity.SysMenu;
@Transactional
@Service("sysMenuService")
public class SysMenuService {
	@Autowired
	private SysMenuDAO sysMenuDAO;
	public List<SysMenu> findAll(){
		return sysMenuDAO.findAll();
	}
}
