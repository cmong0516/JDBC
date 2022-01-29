package dbStudy;

public class ClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassDAO dao = new ClassDAO();
		ClassDTO dto = new ClassDTO(1,"Mong",11,22,33);
		dao.insertClass(dto);
	}

}