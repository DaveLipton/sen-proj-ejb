package com.mfu.service;

import java.util.List;

import com.mfu.ejb.Position;

public interface PositionService {

	public void add(Position pos);

	public void edit(Position pos);

	public void delete(long pos_id);

	public Position findPositionById(long id);

	public List<Position> listPosition();

}
