package hu.neuron.core.dao;

import java.util.List;

import hu.neuron.core.dto.RoleDto;

public interface RoleDao extends GenericDao<RoleDto> {

	List<RoleDto> findRolesByUser(Long id);
}
