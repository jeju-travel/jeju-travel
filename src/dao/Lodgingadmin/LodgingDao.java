package dao.Lodgingadmin;

import java.util.List;

import model.Lodging.Lodging_reserve;
import model.Lodging.Lodgingadmin;
import model.Lodging.Lodginghoroscope;

public interface LodgingDao {
	//�߰�
	void insert(Lodgingadmin lodgingadmin);
	void Reserveroominsert(Lodging_reserve lodging_reserve);
	//����Ʈ
	List<Lodgingadmin> selectAll();
	//����
	void update(Lodgingadmin lodgingadmin);
	//����
	void delete(int lodging_no);
	
	Lodgingadmin selectBylodging_no(int lodging_no);
	
	List<Lodginghoroscope> Lodginghoroscope();
	
	//�̸��˻�
	List<Lodgingadmin> lodging_name(String lodging_name);
	
	int recentlodgingReserve();
}
