package hu.neuron.java.jdbc.dao;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationDAO {

	public Long save(RegistrationDTO dto) throws Exception;

	public void update(RegistrationDTO dto) throws Exception;

	public void delete(Long id) throws Exception;

	public RegistrationDTO find(Long id) throws Exception;

	public List<RegistrationDTO> findAll() throws Exception;

}
