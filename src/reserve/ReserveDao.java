package reserve;

import java.util.List;

public interface ReserveDao {

	public List<Reservation> selectByMemNo(int memNo);
	
	public int[] selectItemNoByResNo(int resNo);
	
	public void delete(int no);
	
}
