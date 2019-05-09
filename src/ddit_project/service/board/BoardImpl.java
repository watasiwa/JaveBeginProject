package ddit_project.service.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ddit_project.dao.board.BoardDao;
import ddit_project.dao.board.BoardDaoImpl;
import ddit_project.vo.BoardVO;
import ddit_project.vo.Database;
import ddit_project.vo.ReplyVO;
//관리자용
public class BoardImpl implements Board {
   
    String fileRoute = null;
   BoardDao boardDao = new BoardDaoImpl();
   Scanner scanner = new Scanner(System.in);
   
   @Override
   public void showboard() {
      boolean isContinue = true;
      while (isContinue) {
         //게시판 목록 출력
         print(50);
         System.out.println("[자유롭게 묻고 답하는 지식공유 게시판 입니다.]");
         System.out.println("=============================================================================================================================================================================");
         showboardlist();
         //System.out.println("=============================================================================================================================================================================");

         
         System.out.println("[메뉴를 선택해주세요.]"); 
         System.out.println("1.글작성");
         System.out.println("2.게시판 상세보기");
         System.out.println("0.뒤로가기");
         System.out.print(">");
         int menu = scanner.nextInt();
         switch (menu) {
         case 1:
         
            boardDao.createBoard(writeBoard());
            break;
         case 2:
            print(50);
            System.out.println("=============================================================================================================================================================================");
            showboardlist();//게시판 목록 출력
            showDetail(); //상세페이지로 이동
            break;
            
      
         case 0:
            print(50);

            isContinue = false;
            break;
         }
   }

}
   //현재 날짜를 반환해주는 메소드
   @Override
   public String currentdate() {
      Date d = new Date();
      SimpleDateFormat formatType = new SimpleDateFormat("yyyy/MM/dd HH:mm ");
      String s=formatType.format(d);
      return s;
   }

   //게시판 생성 메소드
   @Override
   public BoardVO writeBoard() {
      print(50);
      BoardVO board = new BoardVO();
      System.out.println("[글 작성 페이지 입니다.]");
      System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      
      System.out.println("글의 제목을 입력하세요.");
      System.out.print(">");
      board.setBoard_title(scanner.next());
      
      System.out.println("글의 내용을 입력하세요.");
      System.out.print(">");
      board.setBoard_content(scanner.next());
      
      
      System.out.println("자바파일을 업로드하시겠습니까?");
      System.out.println("1.예");
      System.out.println("2.아니오");
      System.out.print(">");
      int choice = scanner.nextInt();
      scanner.nextLine();
      System.out.print(">");
      if(choice==1){
         String  file = fileRead();
         board.setBoard_file(file);
         System.out.println(board.getBoard_file());
      }
      
      //현재날짜를 리턴받아 저장
      board.setBoard_date(currentdate());

      //조회수를 0으로 초기화
      board.setBoard_readcount(0);
      
      //게시판 번호 부여
      board.setBoard_no(++Database.board_no);
      
      //댓글 수
      board.setBoard_replycount(0);
         
      //작성자 아이디
      board.setMember_id(Database.tb_login.getMember_id());
      
      //작성자 이름 
      board.setMember_name(Database.tb_login.getMember_name());
      System.out.println("작성자 :"+Database.tb_login.getMember_name());
      System.out.println("글이 작성되었습니다.");
      return board;
   }
   
   //게시판 목록을 출력하는 메소드
   @Override
   public void showboardlist() {
      System.out.println("게시판번호 \t\t제목        \t\t 작성자 \t 조회수 \t      댓글수     \t\t 작성일");
      System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      if(Database.tb_board.size()>0){
         ArrayList<BoardVO> boardlist=boardDao.showBoardList();
         
         for(int i=boardlist.size()-1; i>=0; i--){ //역순출력 게시판 번호가 작은것이 아래로
            BoardVO boardvo = boardlist.get(i);
            System.out.println(boardvo.show());
         }
      }
         else{
            System.out.println();
            System.out.println("글이 존재하지 않습니다.");
            System.out.println();
         }
      System.out.println("=============================================================================================================================================================================");

   }
   //상세보기 클릭 시 화면
   @Override
   public void showDetail() {
      //print(50);
      boolean isContinue = true;
      boolean isContinue1 = true;
      while(isContinue){
         System.out.println("[상세히 보고 싶은 게시판의 번호를 입력하세요.]");
         System.out.println("0.뒤로가기");
         System.out.print(">");
         
         int index = scanner.nextInt();
         BoardVO board=boardDao.selectBoard(index);
         if(index == 0){
            break;
         }
         else if(board==null){
            System.out.println("[해당 번호가 존재하지 않습니다.]");
            showDetail();
         }
         
         
         int readcount = board.getBoard_readcount() +1 ;//조회수 1증가
         print(50);

         while(isContinue1){
         board.setBoard_readcount(readcount); 
         
         System.out.println("게시판 상세보기");
         System.out.println("===================================================================================================================================================================================================================");
         System.out.println(board.showDetail()); //상세보기 출력
         System.out.println();
         System.out.println("Comment================================================================================================================================================================================================================================================================================================================================================================");
         ArrayList<ReplyVO> Replylist=boardDao.showReply(board.getBoard_no());//댓글출력
         System.out.println("댓글번호             내용                  작성자               작성일");
         if(Replylist.size()==0){
            System.out.println("댓글이 존재하지 않습니다.");
         }
         System.out.println("===================================================================================================================================================================================================================");
         
         for(ReplyVO reply : Replylist){
            System.out.println(reply.show());
         }
         /////////////////////////////////////////////
      //   글의 작성자아이디와 로그인한 아이디가 일치하면 게시글 수정을 보여줌
         if(board.getMember_id().equals(Database.tb_login.getMember_id())){
            System.out.print("1.게시글 수정");
            System.out.print(" 2.게시글 삭제");
            System.out.println();
            System.out.print("3.댓글 작성");
            System.out.print(" 4.댓글 수정");
            System.out.print(" 5.댓글 삭제");
            System.out.println();
            System.out.print("0.뒤로가기");
            System.out.println();
            System.out.print(">");
            index = scanner.nextInt();
            switch(index){
            case 1:
               //작성글 수정
               print(50);
               updateBoarddetail(board);
               break;
            
            case 2:
               //작성글 삭제
               print(50);
               int board_no = board.getBoard_no();
               boardDao.deleteBoard(board);
               boardDao.removeReplyAll(board_no);
               System.out.println("게시판번호 " + board_no +"가 삭제되었습니다.");
               isContinue = false;
               isContinue1 = false;
               
               break;
            
            case 3:
               //댓글작성
            

               boardDao.createReply(writeReply(board.getBoard_no()));
               board.setBoard_replycount(board.getBoard_replycount()+1);//부모글의 댓글 수 하나 증가
               //print(50);
               break;
               
            case 4:
               //댓글 수정

               System.out.println("수정하고 싶은 댓글의 번호를 입력하세요.");
               System.out.println("0.뒤로가기");
               System.out.print(">");
               int replyno = scanner.nextInt();
               
               scanner.nextLine();
               ReplyVO reply=boardDao.updateReply(replyno);
               if(reply == null){
                  print(50);
                  System.out.println("해당 번호는 존재하지 않습니다.");
                  break;
               }
               if(!reply.getMember_id().equals(Database.tb_login.getMember_id())){
                  print(50);

                  System.out.println("댓글의 작성자가 아닙니다.");
                  break;
               }
               System.out.println("내용을 입력하세요");
               System.out.print(">");
               reply.setReply_content(scanner.next());
               print(50);
               System.out.println("댓글의 내용이 변경되었습니다.");
               
               
               break;
            
            case 5:

               System.out.println("삭제하고 싶은 댓글의 번호를 입력하세요");
               System.out.print(">");
               int reply_no =scanner.nextInt();
               //그 값이 존재하는 지 알려주는 메소드삽입
               
               boardDao.removeReply(reply_no);
               
               board.setBoard_replycount(board.getBoard_replycount()-1);
               //댓글 삭제
               print(50);
               System.out.println("댓글이 삭제되었습니다.");
               break;
            
            case 0:
               //뒤로가기
               print(50);

               isContinue = false;
               isContinue1 = false;
               break;
            }
            
            
         }
         else{
            System.out.print("1.게시글 삭제");
            System.out.println();
            System.out.print("2.댓글 작성");
            System.out.print("3.댓글 수정");
            System.out.print("4.댓글 삭제");
            System.out.print("0.뒤로가기");
            System.out.println();
            System.out.print(">");
            index = scanner.nextInt();
            switch(index){
            case 1:
               //작성글 삭제
               print(50);
               int board_no = board.getBoard_no();
               boardDao.deleteBoard(board);
               boardDao.removeReplyAll(board_no);
               System.out.println("게시판번호 " + board_no +"가 삭제되었습니다.");
               isContinue = false;
               isContinue1 = false;
               
               break;
            
            case 2:
               //댓글작성
               
               boardDao.createReply(writeReply(board.getBoard_no()));
               board.setBoard_replycount(board.getBoard_replycount()+1);//부모글의 댓글 수 하나 증가
               break;
               
            case 3:
               //댓글 수정
               System.out.println("수정하고 싶은 댓글의 번호를 입력하세요.");
               System.out.println("0.뒤로가기");
               System.out.print(">");
               int replyno = scanner.nextInt();
               
               scanner.nextLine();
               ReplyVO reply=boardDao.updateReply(replyno);
               if(reply == null){
                  print(50);
                  System.out.println("해당 번호는 존재하지 않습니다.");
                  break;
               }
               if(!reply.getMember_id().equals(Database.tb_login.getMember_id())){
                  print(50);
                  System.out.println("댓글의 작성자가 아닙니다.");
                  break;
               }
               System.out.println("내용을 입력하세요");
               System.out.print(">");
               reply.setReply_content(scanner.next());
               print(50);
               System.out.println("댓글이 수정되었습니다.");
               break;
            
            case 4:
               System.out.println("삭제하고 싶은 댓글의 번호를 입력하세요");
               System.out.print(">");
               int reply_no =scanner.nextInt();
               //그 값이 존재하는 지 알려주는 메소드삽입
               
               boardDao.removeReply(reply_no);
               
               board.setBoard_replycount(board.getBoard_replycount()-1);
               //댓글 삭제
               print(50);
               System.out.println("댓글이 삭제되었습니다.");
               break;
            
            case 0:
               //뒤로가기
               print(50);
               isContinue = false;
               isContinue1 = false;
               break;
            }
            
            
            
         }
         
         
         
         
      
      }
      }
      
   }
   @Override
   public void updateBoarddetail(BoardVO board) {
      fileRoute=null;
      boolean isContinue= true;
      String temp_title=board.getBoard_title();
      String temp_content= board.getBoard_content();
      String temp_file= board.getBoard_file();
      while(isContinue){
         System.out.println("변경을 원하는 부분의 번호를 입력하세요.");
         System.out.println("1.제목변경");
         System.out.println("2.내용변경");
         System.out.println("3.자바파일변경");
         System.out.println("4.저장하기");
         System.out.println("0.뒤로가기");
         System.out.print(">");
         int index = scanner.nextInt();
         scanner.nextLine();
         
         switch (index) {
         case 1:
            //제목변경
            print(50);
            System.out.println("변경하려는 글의 제목을 입력하세요.");
            System.out.print(">");
            temp_title = scanner.nextLine();
            print(50);
         
            
            break; 
            
         case 2:
            //내용변경
            System.out.println("변경하려는 글의 내용을 입력하세요.");
            System.out.print(">");
            temp_content = scanner.nextLine();
            print(50);
            
            break;
            //파일변경
         case 3:
            String  file = fileRead();
            temp_file=file;
            print(50);
            break;
         case 4:
          //저장하기
            System.out.println("글의 내용을 변경하시겠습니까?");
            System.out.println("Y/N");
            System.out.print(">");
            if(scanner.nextLine().equalsIgnoreCase("N")){
               isContinue= false;
               print(50);
               System.out.println("이전 상태로 되돌립니다.");
               break;
            }
            else{
            board.setBoard_title(temp_title);
            board.setBoard_content(temp_content);
            board.setBoard_file(temp_file);
            print(50);
            System.out.println("수정이 완료되었습니다.");
            //showboardlist();
            isContinue= false;
            break;
            }
         
         case 0:
            print(50);
            //showboardlist();
            isContinue= false;
            break;
            //뒤로가기
            
         default:
            System.out.println("해당 번호는 존재하지 않습니다.");
               
         
         }
         
         
      }
   }
   @Override
   public ReplyVO writeReply(int index) {
      ReplyVO reply = new ReplyVO();
      System.out.println("댓글 작성 페이지 입니다.");
      System.out.println("---------------");
      
      //댓글 내용을 입력받음.
      System.out.println("댓글 내용을 입력하세요.");
      System.out.print(">");
      reply.setReply_content(scanner.next());
      //작성날짜    현재날짜를 리턴받아 저장
      reply.setReply_edate(currentdate());


      //게시판 번호 부여  
      reply.setReply_no(++Database.reply_no);
      
      //작성자 이름 
      reply.setMember_name(Database.tb_login.getMember_name());
         
      //작성자 아이디
      reply.setMember_id(Database.tb_login.getMember_id());
      
      //부모글 정보
      reply.setBoard_no(index);
      
      print(50);
      System.out.println("댓글이 작성되었습니다.");
      System.out.println("댓글내용은 "+ reply.getReply_content());
      return reply;
      
   }
   @Override
   public File filePath() {
       if (fileRoute == null) {                  // fileRoute에 경로 및 이름을 한번도 입력을 안했을시에 true
            System.out.print("파일경로부터 이름까지 입력해주세요.>");   
            fileRoute = scanner.nextLine();               // 파일경로 및 이름을 String 변수에 저장                        
         }               
         File lunchFile = new File(fileRoute+".java");    // lunch변수에 파일경로 및 이름저장
         return lunchFile;       
   }
   @Override
   public String fileRead() {
         // 메모장 한글형식 변환후 BufferedReader클래스타입의 reder에 String형식으로 저장
        BufferedReader reder;
        try {
           reder = new BufferedReader(new FileReader(filePath()));
           String lunch = " ";                     // 메모장에서 불러온 값을 임시로 저장하는 String타입 변수
           
           for (int i = 0; i < 300; i++){     
              // 메모장에 있는 31줄까지 복사
              lunch += (reder.readLine()==null)?" ":reder.readLine() +"\n";    
                 }                                 // String lunch변수에 reder에 담긴 값을 저장
              if (lunch != null){  
                 return lunch;                        // lunch변수에 null이 아닌경우만 true
              }
           reder.close();   
        } catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
      return fileRoute;
      
   }
   @Override
   public void print(int a) {
      for(int i=1; i<=a; i++){
         System.out.println();
      }
   }
    
   

}