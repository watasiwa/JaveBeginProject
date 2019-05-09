package ddit_project.vo;

public class MemberVO {
	/*
	 *회원가입한 멤버들의 클래스
	 *
	 * 멤버변수에 접근 할 때, 반드시 메소드(getter/setter)를 통해 접근
	 * ----------------------------------------
	 * 아이디 : member_id : Sting		           Primary key		
	 * 비밀번호  : member_pw : String
	 * 이름		: member_name    : String  
	 * 생년월일 :  member_birth   : String    		yyyy/mm/dd
	 * 이메일   :  member_email   : String
	 * 핸드폰번호 : member_tel     : String
	 * 주소      : member_addr     :String
	 * 전공유무  : member_major    : boolean	   false: 비전공 true: 전공  
	 * 관리자권한 : member_auth    : boolean    false: 일반회원 true: 관리자 
	 * ----------------------------------------
	 * 
	 * @author Yoon
	 */
	
	//memberVO 의 멤버 
	private String member_id;   
	private String member_pw;
	private String member_name;
	private String member_birth;
	private String member_email;
	private String member_tel;
	private String member_addr;
	private boolean member_major;
	private boolean member_auth;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_addr() {
		return member_addr;
	}
	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}
	
	public boolean isMember_major() {
		return member_major;
	}
	public void setMember_major(boolean member_major) {
		this.member_major = member_major;
	}
	public boolean isMember_auth() {
		return member_auth;
	}
	public void setMember_auth(boolean member_auth) {
		this.member_auth = member_auth;
	}
	@Override
	public String toString() {
		return  "\n" + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n" + "\n" + "\n" + "\n" + 
	            "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
				"=============================="
				+ '\n' + "[회원정보]" 
	            + '\n' + "아이디: " + member_id 
	            + '\n' + "비밀번호: " + member_pw 
	            + '\n' + "이름: " + member_name 
				+ '\n' + "생년월일: " + member_birth 
				+ '\n' + "이메일: " + member_email
				+ '\n' + "전화번호: " + member_tel 
				+ '\n' + "주소: " + member_addr
				+ '\n' + "전공: " + ((member_major)?"전공":"비전공")
				+ '\n' + "==============================";
	}
	
	
	
	
	
	
}
