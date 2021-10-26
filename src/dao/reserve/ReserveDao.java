package dao.reserve;

import java.util.List;

import model.Reservation;

public interface ReserveDao {

	public List<Reservation> selectByMemNo(int memNo);
	
	public Reservation selectByResNo(int resNo);

	public int[] selectItemNoByResNo(int resNo);
	
	public void delete(int no);
	
}
