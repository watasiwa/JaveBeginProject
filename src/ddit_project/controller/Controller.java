package ddit_project.controller;

import java.util.Scanner;

import ddit_project.service.board.Board;
import ddit_project.service.board.BoardImpl;
import ddit_project.service.board.BoardImpl_false;
import ddit_project.service.lunch.Lunch;
import ddit_project.service.lunch.LunchImpl;
import ddit_project.service.membermanage.MemberManage;
import ddit_project.service.membermanage.MemberManageImpl;
import ddit_project.service.mypage.Mypage;
import ddit_project.service.mypage.MypageImpl;
import ddit_project.vo.Database;
import ddit_project.vo.MemberVO;
/*
 * Contoroller : 메뉴선택 --디자인 (콘솔창의 화면) 
 * Service : 메뉴 기능 수행 -가 --기능이 실행되는
 * 로직 Dao : 데이터베이스 접속 테이블에 접속해서 데이터를 넣고 빼는 로직 
 * Vo : 데이터를 담는 클래스
 * VO로 저장
 */


public class Controller {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean isContinue = true;
		 int count = 0;
		/*로그인 기능이 구현되어 있지 않으므로
		 * 임의로 객체를 생성해 프로젝트를 진행
		 *  */
		/////////////////////////////////////////
		//임시로그인
		/*MemberVO login_id = new MemberVO();
		login_id.setMember_id("admin");
		login_id.setMember_pw("1234");
		login_id.setMember_name("사용자");
		login_id.setMember_auth(true);	 //권한설정
		Database.tb_login = login_id;
		/////////////////////////////////////////
		 
		*/
		
		while (isContinue) {
			/*  
			 *  Database클래스에 tb_login은 하나의 MemberVO 를 저장할 수 있는 객체 
			 *  로그인을 통해 아이디와 패스워드가 일치하면 일치한 객체를 tb_login에 저장
			 *  로그아웃은 tb_login에 있는 MemberVO를 제거 시키는 것 
 			 *  static으로 선언되어 있기때문에, 객체를 생성하지 않아도 되며 
 			 *  사용 시에는 클래스이름.static변수명 으로 접근
 			 *  ex) Database.tb_login
			 */
				//각각의 클래스에 선언된 메소드를 사용하기 위해서 객체 생성
				Mypage mypage = new MypageImpl();
				MemberManage memberManage = new MemberManageImpl();
				Lunch lunch = new LunchImpl();
				Board board = new BoardImpl();
				Board board_false = new BoardImpl_false();
				
			if (Database.tb_login==null) { // tb_login에 PK인 getMember_id값이 존재하지 않을 경우
				System.out.println("<<<비전과 가치를 창조하는 꿈을 가진 인재개발, 대덕인재개발원 206호>>>");
				System.out.println();
				System.out.println("[메뉴를 선택해주세요.]");			 // 로그인이 되어 있지 않을 경우
				System.out.println("1.회원가입");
				System.out.println("2.로그인");
				System.out.println("3.아이디/비밀번호찾기");
				System.out.println("0.종료");
				int menu = s.nextInt();

				
				switch (menu) {
				case 1:
					// 회원가입
					mypage.join();
				    lunch.userLunchCheck(3,count);
				    count++;
					break;
				case 2:
					// 로그인
					mypage.login();
					break; 
					
				case 3:
					// 아이디,비밀번호 찾기
					   System.out.println();
					   System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println();
				       System.out.println("[아이디/비밀번호찾기]");
				       System.out.println("1.아이디찾기");
				       System.out.println("2.비밀번호찾기");
				       System.out.println("0.뒤로가기");
					
					menu = s.nextInt();
				
					
					switch (menu) {
					case 1:
						//아이디찾기
						mypage.findid();
						break;
						
					case 2:
						//비밀번호찾기
						mypage.findpw();
						break;
						
					case 0:
						//뒤로가기
						break;
					
						
					
					default:
						isContinue = false;
						break;
				
					}
					break;
					
				default:
					System.out.println("프로그램이 종료되었습니다.");
					isContinue = false;
					break;
				}

			}
			else if(Database.tb_login.isMember_auth()){//관리자로 로그인을 한 경우 보여지는 화면
				System.out.println("<<<관리자 화면>>>");	
				System.out.println("[메뉴를 선택해주세요.]");	
				System.out.println("1.마이페이지");
				System.out.println("2.로그아웃");
				System.out.println("3.회원관리");
				System.out.println("4.식단표 관리");
				System.out.println("5.지식공유게시판");
				System.out.println();
            
				int menu = s.nextInt();
				switch (menu) {
				case 1:
					// Mypage
					mypage.showMyInfo();
					
					break;
					
				case 2:
					// 로그아웃
					mypage.logout();
					break;
					
				case 3:
					// 회원관리
					memberManage.showMemberInfo();
					break;
					
				case 4:
					// 식단표 관리
					lunch.lunchManagerMenu();
					
					break;
					
				case 5:
					// 질문답변게시판
					board.showboard();

					break;
			
				}
				
				
				
			}
			else if(!Database.tb_login.isMember_auth()){ //일반회원으로 로그인이 된 경우 보여지는 화면
				System.out.println("<<<일반사용자 화면>>>");
				System.out.println("[메뉴를 선택해주세요.]");	
				System.out.println("1.마이페이지");
				System.out.println("2.로그아웃");
				System.out.println("3.식단표보기");
				System.out.println("4.지식공유게시판");
				System.out.println();
              
				int menu = s.nextInt();
				switch (menu) {
				case 1:
					mypage.showMyInfo();
					
					break;
					
				case 2:
					
					mypage.logout();
					break;
					
				case 3:
					lunch.lunchUserMenu();
					break;
					
				case 4:
					board_false.showboard();					
					break;
					
				default :
					System.out.println("[해당메뉴는 존재하지 않습니다.]");
					System.out.println();
					break;
			
				}
				
				
				
				
				
				
				
			}
			
		}

	}
}
