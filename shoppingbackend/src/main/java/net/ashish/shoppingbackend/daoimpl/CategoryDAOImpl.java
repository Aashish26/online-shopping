package net.ashish.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ashish.shoppingbackend.dao.CategoryDAO;
import net.ashish.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {

			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			System.out.println(" add Category catch block!!");
			return false;
		}

	}

	// Updating a single category

	@Override
	public boolean update(Category category) {
		try {

			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println(" update Category catch block!!");
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {

			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println(" delete Category catch block!!");
			return false;
		}
	}

	
}
