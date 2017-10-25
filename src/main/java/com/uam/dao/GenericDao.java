package com.uam.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uam.entity.Domain;
import com.uam.entity.ProductLobMaster;
import com.uam.util.Filter;


//@Repository
//@Transactional
 //@Component
public class GenericDao <K, E extends Domain<?>>  implements Serializable  {
	
	@PersistenceContext//(unitName="punit")	
	//@Autowired
	//@Qualifier(value = "entityManager")
	 EntityManager entityManager;
	
	private static final long serialVersionUID = 1L;

	
	/*protected JpaTemplate getJpaTemplateEx() throws Exception{
		JpaTemplate template = null;
		try {
			template = getJpaTemplate();
		} catch (Exception e) {
			throw new Exception("failed to acquire JpaTemplate.", e);
		}

		if (template == null) {
			throw new Exception("failed to acquire JpaTemplate.");
		}

		return template;
	}*/

	protected EntityManager getEntityManager() {

		/*EntityManagerFactory emf = entityManager.getEntityManagerFactory();
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(emf);
		if (em == null) {
			System.out
					.println("Warning: got entity manager from jpatemplate. if not on http listener this means we are not using transactions!");
			em = entityManager;
		}
		if(em == null){
			//need to create a brand new entity manager
			em = emf.createEntityManager();
		}*/
		return entityManager;
	}

	public Object findLatestData(String query) {
		Query jpaQuery = getEntityManager().createQuery(query);
		jpaQuery.setMaxResults(1);
		return jpaQuery.getSingleResult();
	}
	
	public int executeUpdateNative(String query) throws Exception
	{
		return executeUpdateNative(query, null);
	}

	public int executeUpdateNative(String query, List<Object> params) throws Exception
	{
		Query jpaQuery = getEntityManager().createNativeQuery(query);
		for (int i = 0; i < params.size(); i++)
		{
			jpaQuery.setParameter(i + 1, params.get(i));
		}
		return jpaQuery.executeUpdate();
	}

	public E findById(K id, Class<E> klass) throws Exception
	{
		return getEntityManager().find(klass, id); // class is keyword
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findByQuery(String name) throws Exception
	{
		Query query = getEntityManager().createQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, int first, int pageSize) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	public Object findNumberByNamedQuery(String name, Map<String, Object> params) throws Exception {
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return (Long)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, Map<String, Object> params, int first, 
			int pageSize) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value) throws Exception
	{
		Query query = null;
		try {
			
		
		 query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String name, String param, Object value, int first, 
			int pageSize) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, int first, int pageSize) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, Map<String, Object> params, int first, int pageSize)  throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);

		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQueryRaw(String name, String param, Object value, int first, int pageSize) throws Exception
	{
		Query query = getEntityManager().createNamedQuery(name);
		query.setParameter(param, value);

		query.setFirstResult(first);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	public List<? extends Object> findByNativeQuery(String qry) throws Exception
	{
		return findByNativeQuery(qry, null);
	}

	@SuppressWarnings("unchecked")
	public List<? extends Object> findByNativeQuery(String qry, List<Object> params) throws Exception
	{
		Query query = getEntityManager().createNativeQuery(qry);
		if (params != null && params.size() > 0)
		{
			for (int i = 0; i < params.size(); i++)
			{
				query.setParameter(i + 1, params.get(i));
			}
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<E> findBySortAndFilter(int first, int pageSize, String sortField, boolean sortOrder, List<Filter> filters, int rowCount[], String className, String baseQuery,
			Map<String, Object> additionalParams, String countQuery)  throws Exception
	{
		StringBuilder query = new StringBuilder();
		boolean where = false;
		boolean whereTemp = false;

		int baseQueryFromIndex = baseQuery.toLowerCase().indexOf("from");
		if (countQuery != null)
		{
			query.append(countQuery);
			where = countQuery.toLowerCase().indexOf("where") > -1;
		}
		else
		{
			query.append("Select count(distinct ");
			query.append(className);
			query.append(" ) ");
			query.append(baseQuery.substring(baseQueryFromIndex));
			where = baseQuery.toLowerCase().indexOf("where") > -1;
		}

		whereTemp = where;

		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			if (!where)
			{
				query.append(" where ");
				where = true;
			}
			else
			{
				query.append(" and ");
			}
			query.append(className);
			query.append(".");
			query.append(filter.getName());

			switch (filter.getType())
			{
				case Contains:
				case StartsWith:
					query.append(" like :");
					break;
				case Equals:
					query.append(" = :");
					break;
			}

			query.append(filter.getName().replace('.', '_'));
		}

		Query jpaQuery = getEntityManager().createQuery(query.toString());
		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			String name = filter.getName().replace('.', '_');
			switch (filter.getType())
			{
				case Contains:
					jpaQuery.setParameter(name, "%" + filter.getValue() + "%");
					break;
				case StartsWith:
					jpaQuery.setParameter(name, filter.getValue() + "%");
					break;
				case Equals:
					jpaQuery.setParameter(name, filter.getValue());
					break;
			}
		}

		if (additionalParams != null && additionalParams.size() > 0)
		{
			for (Entry<String, Object> param : additionalParams.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		rowCount[0] = ((Long) jpaQuery.getSingleResult()).intValue();

		if (rowCount[0] == 0)
		{
			return new ArrayList<E>();
		}

		where = whereTemp;

		query.setLength(0);
		query.append(baseQuery);

		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			if (!where)
			{
				query.append(" where ");
				where = true;
			}
			else
			{
				query.append(" and ");
			}
			query.append(className);
			query.append(".");
			query.append(filter.getName());

			switch (filter.getType())
			{
				case Contains:
				case StartsWith:
					query.append(" like :");
					break;
				case Equals:
					query.append(" = :");
					break;
			}

			query.append(filter.getName().replace('.', '_'));
		}

		if (sortField != null)
		{
			query.append(" order by ").append(className).append(".");
			query.append(sortField);
			query.append(sortOrder ? " asc " : " desc ");
		}

		jpaQuery = getEntityManager().createQuery(query.toString());
		for (Filter filter : filters)
		{
			if (filter.getValue() == null || filter.getValue() == "")
			{
				continue;
			}

			String name = filter.getName().replace('.', '_');

			switch (filter.getType())
			{
				case Contains:
					jpaQuery.setParameter(name, "%" + filter.getValue() + "%");
					break;
				case StartsWith:
					jpaQuery.setParameter(name, filter.getValue() + "%");
					break;
				case Equals:
					jpaQuery.setParameter(name, filter.getValue());
					break;
			}
		}

		if (additionalParams != null && additionalParams.size() > 0)
		{
			for (Entry<String, Object> param : additionalParams.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}

		jpaQuery.setFirstResult(first);
		jpaQuery.setMaxResults(pageSize);

		return jpaQuery.getResultList();
	}

	public void flush() throws Exception
	{
		getEntityManager().flush();
	}

	public E merge(E entity) throws Exception
	{
		return getEntityManager().merge(entity);
	}

	public void persist(E entity) throws Exception
	{
		getEntityManager().persist(entity);
	}

	public void refresh(E entity) throws Exception
	{
		getEntityManager().refresh(entity);
	}

	public void remove(E entity) throws Exception
	{
		getEntityManager().remove(entity);
	}
	
	//added by Prashant on 22-11-2011
	
	public Object findSingleResult(String name)throws Exception{
		//Query jpaQuery = getEntityManager().createQuery(query);
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		return ((Object) jpaQuery.getSingleResult());
	}
	
	public Object findSingleResult(String name, Map<String, Object> params) throws Exception {
		Query query = getEntityManager().createNamedQuery(name);
		for (Entry<String, Object> param : params.entrySet())
		{
			query.setParameter(param.getKey(), param.getValue());
		}
		return (Object)query.getSingleResult();
	}
	
	public int executeUpdate(String query, Map<String, Object> params) throws Exception {
		Query jpaQuery = getEntityManager().createQuery(query);
		if(params != null){
			for (Entry<String, Object> param : params.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
		}
		return jpaQuery.executeUpdate();
		
	}
	
	public int executeUpdate(String query) throws Exception {
		return executeUpdate(query, null);
	}
	
	public int executeUpdateByNamedQuery(String name) throws Exception {
		Query query = getEntityManager().createNamedQuery(name);
		return query.executeUpdate();
	}
	
	public int executeUpdateByNamedQuery(String name, Map<String, Object> params) throws Exception {
		Query jpaQuery = getEntityManager().createNamedQuery(name);
		if(params != null){
			for (Entry<String, Object> param : params.entrySet())
			{
				jpaQuery.setParameter(param.getKey(), param.getValue());
			}
			return jpaQuery.executeUpdate();
		}
		return  executeUpdateByNamedQuery(name);
	}

 
	public Long findTotalPagesByFilters(StringBuilder countQuery , Map<String, Object> params) throws Exception{
		Query jpaCountQuery = getEntityManager().createQuery(countQuery.toString());
		if(params!=null){
		for (Entry<String, Object> param : params.entrySet())
		{
			jpaCountQuery.setParameter(param.getKey(), param.getValue());
		}
		}
		return  (Long)jpaCountQuery.getSingleResult();
	}

	 public Object findSequence(String name) throws Exception{
		 
		 Query q = getEntityManager().createNativeQuery("SELECT NEXTVAL FOR "+name+" AS SEQ_ID FROM sysibm.SYSDUMMY1"); //SEQ_PROSPECTS_ID
		 return q.getSingleResult();
	 }
	
	}
