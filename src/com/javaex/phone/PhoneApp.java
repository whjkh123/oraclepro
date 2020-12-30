package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		PhoneDao pDao = new PhoneDao();

		List<PersonVo> pList = pDao.dbList();

		Scanner sc = new Scanner(System.in);
		/*
		PersonVo pIsrtVo01 = new PersonVo("이효리", "010-1111-1111", "02-1111-1111");
		PersonVo pIsrtVo02 = new PersonVo("정우성", "010-2222-2222", "02-2222-2222");
		PersonVo pIsrtVo03 = new PersonVo("유재석", "010-3333-3333", "02-3333-3333");
		PersonVo pIsrtVo04 = new PersonVo("이정재", "010-4444-4444", "02-4444-4444");
		PersonVo pIsrtVo05 = new PersonVo("서장훈", "010-5555-5555", "02-5555-5555");

		pDao.dbIsrt(pIsrtVo01);
		pDao.dbIsrt(pIsrtVo02);
		pDao.dbIsrt(pIsrtVo03);
		pDao.dbIsrt(pIsrtVo04);
		pDao.dbIsrt(pIsrtVo05);

		PersonVo pUpdVo = new PersonVo(4, "010-9999-9999", "02-9999-9999");

		pDao.dbUpd(pUpdVo);

		pDao.dbDle(5);

		pList = pDao.dbList();

		for (int i = 0; i < pList.size(); i++) {

			PersonVo pData = pList.get(i);
			System.out.println(pData.person_id + ", " + pData.name + ", " + pData.hp + ", " + pData.company);
		}
		*/
		System.out.println("*****************************************");
		System.out.println("*	      전화번호 관리 프로그램	    	*");
		System.out.println("*****************************************");

		while (true) {
			System.out.println("1.리스트\t" + "2.등록\t" + "3.수정\t" + "4.삭제\t" + "5.검색\t" + "6.종료");
			System.out.println("-----------------------------------------");
			System.out.print(">메뉴번호: ");

			String str = sc.nextLine();

			if (str.equals("6")) {
				System.out.println("************************************");
				System.out.println("*             감사합니다.             *");
				System.out.println("************************************");
				break;
			} else if (str.equals("1")) {
				System.out.println("<1.리스트>");

				pList = pDao.dbList();

				for (int i = 0; i < pList.size(); i++) {

					PersonVo pData = pList.get(i);
					System.out.println(pData.getPerson_id() + ", " + pData.getName() + ", " + pData.getHp() + ", "	+ pData.getCompany());
				}

				System.out.println("");
			} else if (str.equals("2")) {
				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사전화: ");
				String company = sc.nextLine();

				PersonVo pData = new PersonVo(name, hp, company);

				pDao.dbIsrt(pData);

				System.out.println("");
			} else if (str.equals("3")) {
				System.out.println("<3.수정>");

				System.out.print(">번호: ");
				int num = sc.nextInt();
				sc.nextLine();
				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사번호: ");
				String company = sc.nextLine();

				PersonVo pData = new PersonVo(num, name, hp, company);

				pDao.dbUpd(pData);

				System.out.println("");
			} else if (str.equals("4")) {
				System.out.println("<4.삭제>");

				System.out.print(">번호: ");
				int num = sc.nextInt();
				sc.nextLine();

				pDao.dbDle(num);

				System.out.println("");
			} else if (str.equals("5")) {
				System.out.println("<5.검색>");

				System.out.print(">검색어: ");

				str = sc.next();

				if (str.length() > 0) {
					pList = pDao.dbSearch(str);

					for (int i = 0; i < pList.size(); i++) {
						PersonVo pData = pList.get(i);
						System.out.println(pData.getPerson_id() + ", " + pData.getName() + ", " + pData.getHp() + ", "	+ pData.getCompany());
					}
					System.out.println("");
					sc.nextLine();
				}

			} else {
				System.out.println("[다시 입력해주세요.]");
				System.out.println("");
			}

		}

		sc.close();

	}

}
