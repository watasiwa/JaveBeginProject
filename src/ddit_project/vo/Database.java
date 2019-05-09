package ddit_project.vo;


import java.util.ArrayList;

public class Database {
	//멤버 테이블
	public static ArrayList<MemberVO> tb_member = new ArrayList<MemberVO>();
	
	//게시판 테이블 
	public static ArrayList<BoardVO> tb_board = new ArrayList<BoardVO>();
	
	//댓글 테이블
	public static ArrayList<ReplyVO> tb_reply = new ArrayList<ReplyVO>();
	
	//로그인한 유저의 정보를 담을 변수   로그아웃 시, null로 변수의 값을 없애줘여한다.
	public static MemberVO tb_login = null;
	
	//txt로 읽어온 점심메뉴 값들을 저장하는 List 
	public static ArrayList<String> tb_lunch = new ArrayList<String>();
	
	
	//밥을 먹을 지 말지 저장할 테이블
	public static ArrayList<LunchVO> tb_lunch_member = new ArrayList<LunchVO>();
	
	
	public static int board_no = 0;
	public static int reply_no = 0;
	
}
	