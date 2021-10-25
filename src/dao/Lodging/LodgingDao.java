package dao.Lodging;

import java.util.List;

import model.Lodging;

public interface LodgingDao {
	//�߰�
	void insert(Lodging lodging);
	//����Ʈ
	List<Lodging> selectAll();
	//����
	void update(Lodging lodging);
	//����
	void delete(int lodging_no);
	//���̵�ã�Ƽ� ����Ʈ
	Lodging selectBylodging_no(int lodging_no);
	
}
