package dal;

import dao.MonstreDAO;

public class Exec {

	public static void main(String[] args) {
		MonstreDAO monstre = new MonstreDAO();
		
		monstre.select();
		//monstre.getById(1);
		//monstre.insert();

	}

}
