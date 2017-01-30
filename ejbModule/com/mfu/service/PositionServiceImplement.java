package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.ejb.Position;

@Stateless
@Remote(PositionService.class)
public class PositionServiceImplement implements PositionService {

	@PersistenceContext(unitName = "Database")
	EntityManager em;

	@Override
	public void add(Position pos) {
		// TODO Auto-generated method stub
		em.persist(pos);
	}

	@Override
	public void edit(Position pos) {
		// TODO Auto-generated method stub
		em.merge(pos);
	}

	@Override
	public void delete(long pos_id) {
		// TODO Auto-generated method stub
		// DISABLE (CHANGE employee_status)
		// DISABLE (CHANGE employee_status)
		// DISABLE (CHANGE employee_status)
		// DISABLE (CHANGE employee_status)
		// DISABLE (CHANGE employee_status)
		// DISABLE (CHANGE employee_status)
		Position pos = em.find(Position.class, pos_id);

		if (pos != null) {
			em.remove(pos);
		}
	}

	@Override
	public Position findPositionById(long id) {
		Position pos = em.find(Position.class, id);
		return pos;
	}

	@Override
	public List<Position> listPosition() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT pos FROM Position pos").getResultList();
	}

}
