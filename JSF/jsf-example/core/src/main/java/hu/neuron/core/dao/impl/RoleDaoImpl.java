package hu.neuron.core.dao.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dto.RoleDto;

@Named
@ApplicationScoped
public class RoleDaoImpl implements RoleDao {

	@Override
	public Long save(RoleDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RoleDto upadte(RoleDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> findRolesByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
