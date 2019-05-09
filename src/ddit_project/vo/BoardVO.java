package ddit_project.vo;

public class BoardVO {
   /*
    *게시판(board)
    *
    * 멤버변수에 접근 할 때, 반드시 메소드를 통해 접근
    * ----------------------------------------
    * 게시판번호 : board_no : int               Primary key   
    * 게시판 제목 : board_title : String
    * 게시판 내용 : board_content    : String  
    * 조회수  :  board_readcount   : int
    * 작성자아이디  : member_id     : String         Foreign key
    * 작성자 : member_name         : String      조인을 하지 않기 위해서 게시판을 만들 때 직접 입력
    * 작성날짜 : board_date   : String         yyyy/mm/dd/hh/mm  시간분초까지
    * 댓글 수  :  board_replycount    : int
    * ----------------------------------------
    * 
    * @author Yoon
    */
      //Board VO 의 객체
      private int board_no;
      private String board_title;
      private String board_content;
      private String board_file;
      private int board_readcount;
      private String member_id; //id와 멤버 헷갈리지 않게 조심
      private String member_name;
      private String board_date;
      private int board_replycount;
      public int getBoard_no() {
         return board_no;
      }
      public String getBoard_file() {
         return board_file;
      }
      public void setBoard_file(String board_file) {
         this.board_file = board_file;
      }
      public void setBoard_no(int board_no) {
         this.board_no = board_no;
      }
      public String getBoard_title() {
         return board_title;
      }
      public void setBoard_title(String board_title) {
         this.board_title = board_title;
      }
      public String getBoard_content() {
         return board_content;
      }
      public void setBoard_content(String board_content) {
         this.board_content = board_content;
      }
      public int getBoard_readcount() {
         return board_readcount;
      }
      public void setBoard_readcount(int board_readcount) {
         this.board_readcount = board_readcount;
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
      public String getBoard_date() {
         return board_date;
      }
      public void setBoard_date(String board_date) {
         this.board_date = board_date;
      }
      public int getBoard_replycount() {
         return board_replycount;
      }
      public void setBoard_replycount(int board_replycount) {
         this.board_replycount = board_replycount;
      }
      @Override
      public String toString() {
         return "BoardVO [board_no=" + board_no + ", board_title="
               + board_title + ", board_content=" + board_content
               + ", board_readcount=" + board_readcount + ", member_id="
               + member_id + ", member_name=" + member_name
               + ", board_date=" + board_date + ", board_replycount="
               + board_replycount + "]";
      }
      
      public String showDetail(){
         return "게시판 번호 :"  + board_no + "\n         제목 :" + board_title + "\n       작성자 :" + member_name + "\n       조회수 :" + board_readcount + "\n          날짜 :" + board_date + "\n          내용 :" + board_content + "\n  자바파일 :" + ((board_file==null)?"미첨부":board_file) + "\n       댓글 수 :" +board_replycount+"개";     
            
         
      }
      public String show() {
         return  board_no +"\t\t" + board_title + "\t" + member_name +"\t" + board_readcount + "\t"+ board_replycount +"\t"+ board_date;
      }
      
   
   
   
}