package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Admin;

@Stateless
@Remote(AdminService.class)
public class AdminServiceImplement implements AdminService {
	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Admin adm) {
		// TODO Auto-generated method stub
		em.persist(adm);
	}

	@Override
	public void resetPassword(Admin adm) {
		// TODO Auto-generated method stub
		adm.setAdmin_password("summit123456");
		em.merge(adm);
	}

	@Override
	public Admin findAdminById(long id) {
		return em.find(Admin.class, id);
	}

	@Override
	public Admin findAdminByUsername(String uname) {
		Admin adm = new Admin();
		List<Admin> admList = em.createQuery("SELECT adm FROM Admin adm WHERE adm.admin_username=:adm_uname")
				.setParameter("adm_uname", uname).getResultList();

		if (admList.get(0) != null) {
			adm = admList.get(0);
			return adm;
		} else {
			return null;
		}
	}

	@Override
	public void edit(Admin adm) {
		em.merge(adm);
	}

}
