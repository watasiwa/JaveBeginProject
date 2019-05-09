package ddit_project.vo;

public class ReplyVO {
	/*
	 *댓글(Reply)
	 *
	 * 멤버변수에 접근 할 때, 반드시 메소드(getter/setter)를 통해 접근
	 * ----------------------------------------
	 * 댓글번호  		: reply_no : int					Primary key	
	 * 댓글 내용     : reply_content    : String  
	 * 작성자아이디   : member_id     : String            Foreign key
	 * 작성자   : 	member_name     : String             조인을 하지 않기 위해서 게시판을 만들 때 직접 입력
	 * 부모테이블   :  board_no  : int              Foreign key  //이  댓글이 어떤 게시판에 달려있는 댓글인지를 알기위해 부모 테이블의PK를 알아야함
	 * 작성날짜 : reply_edate   : String			yyyy/mm/dd/hh/mm  시간분초까지
q	 * ----------------------------------------
	 * 
	 * @author Yoon
	 */
	
	private int reply_no;
	private String reply_content;
	private String member_id;  //id와 name헷갈리지 않게 조심
	private String member_name;
	private int board_no;
	private String reply_edate;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getReply_edate() {
		return reply_edate;
	}
	public void setReply_edate(String reply_edate) {
		this.reply_edate = reply_edate;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", reply_content="
				+ reply_content + ", member_id=" + member_id + ", member_name="
				+ member_name + ", board_no=" + board_no + ", reply_edate="
				+ reply_edate + "]";
	}
	
	public String show(){
		return reply_no +"\t" + reply_content + "\t" + member_id + "\t" + reply_edate; 
	}
	
	
	
}
