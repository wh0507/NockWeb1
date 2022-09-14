package sogo;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Errcheck {

	//	public static void main(String[] args) {
	//		Errcheck e = new Errcheck();
	//		System.out.println(e.numCheck("abc", "abc"));
	//		System.out.println(e.numCheck("123", "abc"));
	//		System.out.println(e.numCheck("123", "-123"));
	//
	//	}
	public String numCheck(String id, String kakaku) {
		String msg = "";
		//		String pattern = "^[0-9０-９]+$"; //数字の場合
		String pattern = "^[0-9０-９]+$|-[0-9０-９]+$";
		boolean rId = Pattern.matches(pattern, id); //idが数字の場合　true
		boolean rKakaku = Pattern.matches(pattern, kakaku); //kakakuが数字の場合　true

		if (rId == false || rKakaku == false) {
			msg = "IDと価格には「数字」を入力してください";
		} else {
			msg = "IDと価格には「整数」を入力してください";
		}

		return msg;
	}

	//	public static void main(String[] args) {
	//		Errcheck e = new Errcheck();
	//		e.exitId("00007");
	//
	//	}

	public String exitId(String id) {

		String msg = "";
		ShohinDAO shDao = new ShohinDAO();
		ArrayList<ShohinBean> daoId = shDao.selectAll();

		for (int i = 0; i < daoId.size(); i++) {
			String ids = daoId.get(i).getId();
			if (id.contains(ids)) {
				msg = "既に存在しています";
				break;
			}
		}
		return msg;
	}

	public static void main(String[] args) {
		Errcheck e = new Errcheck();
		e.notExitId("10007");
		e.notExitId("00007");

	}

	public String notExitId(String id) {

		String msg = "";
		ShohinDAO shDao = new ShohinDAO();
		ArrayList<ShohinBean> daoId = shDao.selectAll();

		for (int i = 0; i < daoId.size(); i++) {
			String ids = daoId.get(i).getId();
			if (id.contains(ids)) {
				break;
			} else {
				msg = "対象データがありません";
			}
		}
		return msg;
	}

}
