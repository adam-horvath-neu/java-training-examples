package hu.neuron.java.web.views;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

public class LazyUserDataModel extends LazyDataModel<UserVo> {

	private UserService userService;
	private List<UserVo> userList;

	public LazyUserDataModel(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public List<UserVo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		userList = userService.getUserList(first, pageSize, sortField, sortOrder.name(), filters);

		try {
			setRowCount(userService.getUserList().size());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public Object getRowKey(UserVo object) {

		return object.getId();
	}

	@Override
	public UserVo getRowData(String rowKey) {

		try {
			return userService.findUserById(new Long(rowKey));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}
