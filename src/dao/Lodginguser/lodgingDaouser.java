package dao.Lodginguser;

import java.util.List;

import model.Lodging.Lodgingadmin;

public interface lodgingDaouser {
	//�˻��ϱ�
	List<Lodgingadmin> selectAll();
	//ã�Ƽ� ���
	Lodgingadmin selectBylodging_no(int lodging_no);
}
