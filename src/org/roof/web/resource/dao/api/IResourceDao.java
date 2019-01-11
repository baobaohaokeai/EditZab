package org.roof.web.resource.dao.api;

import java.util.Collection;
import java.util.List;

import org.roof.roof.dataaccess.api.IDaoSupport;
import org.roof.web.resource.entity.Resource;

public interface IResourceDao extends IDaoSupport {

	public abstract List<Resource> loadAll();

	public abstract List<Resource> findModuleByParent(Long parentId);
	
	/**
	 * <p>Description: 可以指定某个节点的id(以它作为顶节点),不局限于顶节点</p>
	 * <p>Title: findModuleByParent</p>
	 * @param parentId
	 * @param id : 某个节点的id(以它作为顶节点)
	 * @return
	 */
	public abstract List<Resource> findModuleByParent(Long parentId, Long id);

	public abstract List<Resource> findModuleByPath(String path);

	public abstract List<Resource> findModuleByPath(String[] path);

	public abstract Long childrenCount(Long id);

	public abstract Collection<Resource> selectByUser(Long userId);

	public abstract Collection<Resource> selectByRole(Long roleId);

}