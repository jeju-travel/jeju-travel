package dao.Roomadmin;

import java.util.List;

import model.Lodging.Roomadmin;

public interface RoomDao {
	//�߰�
	void insert(Roomadmin roomadmin);
	//����Ʈ
	List<Roomadmin> selectAll();
	//����
	/*void update(Roomadmin roomadmin);*/
	//����
	/*void delete(Roomadmin roomadmin);
	Roomadmin selectByroom_no(int room_no);*/
}
