package sogo;

import java.util.regex.Pattern;

public class Errcheck {

	public static void main(String[] args) {
		String id = "abc";

		Errcheck e = new Errcheck();
		String msg = e.numCheck("abc", "123");
		System.out.println(msg);

	}

	public String numCheck(String id, String kakaku) {

		String msg = "";
		String pattern = "^[0-9０-９]+$"; //数字の場合
		boolean rId = Pattern.matches(pattern, id); //idが数字の場合　true
		boolean rKakaku = Pattern.matches(pattern, kakaku); //kakakuが数字の場合　true

		if (rId == false || rKakaku == false) {
			msg = "IDと価格には数字を入力してください";
		}

		String pattern2 = "^(-[1-9]\\\\d*|0)(\\\\.\\\\d+)?$";
		boolean mKakaku = Pattern.matches(pattern2, kakaku); //idが数字の場合　true

		if (mKakaku == true) {
			msg = "IDと価格には整数を入力してください";
			return msg;
		}

		return msg;
	}

	public String extId(String id) {

		String msg = "";
		ShohinDAO shDao = new ShohinDAO();
		shDao.selectAll();

		if (id.equals(shDao.jouken(id))) {

		}
		return null;

	}

}
