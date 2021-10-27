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
	//���̵�ã�Ƽ� ����Ʈ
	Lodgingadmin selectBylodging_no(int lodging_no);
	
}
