package dao.Lodgingadmin;

import java.util.List;

import model.Lodging.Lodgingadmin;

public interface LodgingDao {
	//�߰�
	void insert(Lodgingadmin lodgingadmin);
	//����Ʈ
	List<Lodgingadmin> selectAll();
	//����
	void update(Lodgingadmin lodgingadmin);
	//����
	void delete(int lodging_no);
	//�̸��˻�
	List<Lodgingadmin> lodging_name(String lodging_name);
	
}
