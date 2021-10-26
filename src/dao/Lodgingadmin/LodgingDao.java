package dao.Lodgingadmin;

import java.util.List;

import lodging.model.Lodgingadmin;

public interface LodgingDao {
	//�߰�
	void insert(Lodgingadmin lodging);
	//����Ʈ
	List<Lodgingadmin> selectAll();
	//����
	void update(Lodgingadmin lodging);
	//����
	void delete(int lodging_no);
	//���̵�ã�Ƽ� ����Ʈ
	Lodgingadmin selectBylodging_no(int lodging_no);
	
}