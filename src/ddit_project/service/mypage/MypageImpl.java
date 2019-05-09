package ddit_project.service.mypage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;





import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ddit_project.dao.mypage.MypageDao;
import ddit_project.dao.mypage.MypageDaoImpl;
import ddit_project.vo.Database;
import ddit_project.vo.MemberVO;

public class MypageImpl implements Mypage {
   Scanner s = new Scanner(System.in);
  
   /*
    * 
    * Mypage 인터페이스를 구현한 클래스 인터페이스에 메소드 추가 삭제 금지 (non-Javadoc)
    * 
    * @see ddit_project.service.mypage.Mypage#join()
    */
   MypageDao mypageDao = new MypageDaoImpl();

   //회원가입
   @Override
   public void join() {
      boolean flagid = false;
      boolean flagpw = false;
      boolean flagemail = false;
      boolean flagtel = false;
      Scanner s = new Scanner(System.in);
      
      MemberVO member = new MemberVO();
      String pw = "";
      
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
      while(!flagid){
	  
      System.out.println("[양식에 맞게 작성해주세요.]");
      System.out.print("아이디> ");
      String input = s.nextLine();
      member.setMember_id(input);
      //아이디 중복인지 확인
      MemberVO memberCheck = mypageDao.selectMember("ID", member.getMember_id());
   
      if(memberCheck != null){//중복되는 아이디가 있을 때
         System.out.print("[이미 사용중인 아이디입니다. 다른 아이디를 입력해주세요.]");    
         }
      else{
    	  flagid = check(input, 0, flagid);
      }
      
      }
   
      //비밀번호 똑같이 맞게쳤는지 확인
      while (!flagpw) {
			System.out.println();
			System.out.print("비밀번호(예 12345!)> ");
			pw = s.nextLine();
			if (flagpw = check(pw, 1, flagpw)) {
				System.out.println();
				System.out.print("비밀번호 확인> ");
				if(pw.equals(s.nextLine())){
					member.setMember_pw(pw);
				}else {
					System.out.print("비밀번호가 일치하지 않습니다. 다시 입력해주세요.> ");
					System.out.println();
					flagpw = false;
				}
			} 
		}
      
      System.out.println();
      System.out.print("이름> ");
      member.setMember_name(s.nextLine());
      System.out.println();
      System.out.print("생년월일(예 19941004)> ");
      member.setMember_birth(s.nextLine());
      System.out.println();
      
      while (!flagemail){
    	    System.out.println();
			System.out.print("이메일(예 test1@nate.com)> ");
			String email = s.nextLine();
			flagemail = check(email, 2, flagemail);
			member.setMember_email(email);
		}
		while (!flagtel){
			System.out.println();
			System.out.print("전화번호(예 01x-xxxx-xxxx)> ");
			String tel = s.nextLine();
			flagtel = check(tel, 3, flagtel);
			member.setMember_tel(tel);
		}
      System.out.println();
      System.out.print("주소> ");
      member.setMember_addr(s.nextLine());
      System.out.println();
      System.out.print("전공: Y" + " / " + "비전공: N> ");
      if(s.nextLine().equalsIgnoreCase("y")){
         member.setMember_major(true);
      }
      if(member.getMember_id().equals("admin")){
    	  member.setMember_auth(true);
      }
      mypageDao.insertMember(member);
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
      System.out.println("[회원가입 정상처리 되었습니다.]");
      System.out.println();
         
      }

      /*
       * 회원가입을 위한 메소드. 비밀번호 중복검사를 통해서값을 비교하는 로직 작성 정규표현식 사용
       */
      // 아이디 중복확인을 검사하는 메소드


   
   @Override
   public void login() {
      // TODO Auto-generated method stub
      /*
       * 로그인을 위한 메소드 아이디와 비밀번호를 입력받는 로직작성
       */
      
      // mypageDao.checklogin(id, pw);
      //객체가 존재하면 tb_login 객체를 생성하고  그곳에 저장
         Scanner s = new Scanner(System.in);
         
         MemberVO member = new MemberVO();
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
            System.out.println("[로그인을 해주세요.]");
            System.out.print("아이디> ");
            member.setMember_id(s.nextLine());
            System.out.println();
            System.out.print("비밀번호> ");
            member.setMember_pw(s.nextLine());
            MemberVO idpwCheck = mypageDao.checklogin(member.getMember_id() ,member.getMember_pw());
            if(idpwCheck == null){
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
                System.out.println("[아이디 또는 비밀번호를 다시 확인해주세요.]");
                System.out.println();
               
            }else{
               Database.tb_login = idpwCheck;
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
             	System.out.println();
             	System.out.println();
               System.out.println("[" + idpwCheck.getMember_id() + "님 로그인 되었습니다.]");
               System.out.println();
               
         }
      }

      
   

   @Override
   public void showMyInfo() {
      boolean isContinue = true;
      while (isContinue) {
         // 내 정보를 보여줌
         mypageDao.showMyInfo(); // //현재 접속한 계정의 객체를 리턴해주는 메소드
         System.out.println(Database.tb_login);
         System.out.println();
         
         System.out.println("[메뉴를 선택해주세요.]"); // 로그인이 되어 있지 않을 경우
         System.out.println("1.수정하기");
         System.out.println("2.탈퇴하기");
         System.out.println("0.뒤로가기");
         int menu = s.nextInt();
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
         switch (menu) {
         //수정하기
         case 1:
            MemberVO member = mypageDao.showMyInfo(); // 현재 로그인 한 값을 리턴받아
                                             // 저장한 후 이 객체의 정보를
                                             // 변경
            /*
             * 수정하기 재 tb_login에 저장되어 있는 객체에 회원가입처럼 스캐너로 받은 값을 .set메소드로
             * 재설정(덮어쓰기) 그런 다음 객체를 저장
             */
            
//               System.out.println("변경하고 싶은 회원의 번호를 입력하세요.");
//                  int index = s.nextInt();
                  s.nextLine();
                  MemberVO a1   =   mypageDao.updateMyInfo(Database.tb_login.getMember_id());
                  MemberVO a2 = new MemberVO();
                  
                  boolean isContinue1= true;
                  while(isContinue1){
                  
                  //singlePrintMember(index);
                	 
                      System.out.println();
                  System.out.println("[변경하고 싶은 정보의 번호를 선택해주세요.]");
                  System.out.println("1.이름 ");
                  System.out.println("2.비밀번호 ");
                  System.out.println("3.생년월일 ");
                  System.out.println("4.이메일 ");
                  System.out.println("5.전화번호 ");
                  System.out.println("6.주소 ");
                  System.out.println("7.전공 / 비전공 ");
                  System.out.println("0.뒤로가기 ");
                  
                  int i = s.nextInt();
                  s.nextLine();
                  switch(i){
                     
                  case 1: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println("[회원정보수정]");
                	  System.out.print("변경하고싶은 이름을 입력해주세요.> ");
                        a2.setMember_name(s.nextLine());
                        if(!a2.getMember_name().equals("\n") ){
                           a1.setMember_name(a2.getMember_name());
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
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println("[이름이 "+ a2.getMember_name() +"(으)로 변경되었습니다.]");
                           System.out.println();
                        } 
                        break;
                        
                  case 2:
                     boolean flag3 = false;
                     boolean flag4 = false;
                     String pw3;
                     String pw4;
            
                     while(!flag3){   
                     

                         System.out.println();       	 
                         System.out.println("[회원정보수정]");
                         System.out.print("현재 사용중인 비밀번호를 입력해주세요.> ");
                  pw3 = s.nextLine();
                  
               if (pw3.equals(Database.tb_login.getMember_pw())) {                     
                        flag3 = true;
               }else{
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
            	   System.out.print("[입력하신 비밀번호가 일치하지 않습니다. 다시 입력해주세요.] ");
            	   System.out.println();
               }
               }
   
                     while(!flag4){
                     
                    System.out.println();	 
                    System.out.print("변경하고싶은 비밀번호를 입력해주세요.> ");
                     pw4 = s.nextLine();   
                     
                     System.out.println();
                     System.out.print("한번 더 입력해 주세요.> ");
                     String pw5 = s.nextLine();   
                     if(pw4.equals(pw5)){
                           a2.setMember_pw(pw4);
                           a1.setMember_pw(pw4);
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
                           System.out.println("[비밀번호가 "+ a2.getMember_pw() +"(으)로 변경되었습니다.]");
                         
                     
                     flag4 = true;
                     }else{
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
                    	 System.out.print("[입력하신 비밀번호가 일치하지 않습니다. 다시 입력해주세요.]");
                     }
                     
                     } 
                     break;    
                     
                        
                  case 3: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                	  System.out.print("변경하고싶은 생년월일을 입력해주세요.(예 19941004)> ");
                        a2.setMember_birth(s.nextLine());
                        if(!a2.getMember_birth().equals("\n")){
                           a1.setMember_birth(a2.getMember_birth());
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
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println("[생년월일이 "+ a2.getMember_birth() +"(으)로 변경되었습니다.]");
                        } 
                        break;
                  
                  case 4: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                	  System.out.print("변경하고싶은 이메일을 입력해주세요.> ");
                        a2.setMember_email(s.nextLine());
                        if(!a2.getMember_email().equals("\n")){
                           a1.setMember_email(a2.getMember_email());
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
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println("[이메일이 "+ a2.getMember_email() +"(으)로 변경되었습니다.]");
                        }
                        break;
                  
                  case 5: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                	  System.out.print("변경하고싶은 전화번호를 입력해주세요.(예 01*-****-****)> ");
                        a2.setMember_tel(s.nextLine());
                        if(!a2.getMember_tel().equals("\n")){
                           a1.setMember_tel(a2.getMember_tel());
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
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println("[전화번호가 "+ a2.getMember_tel() +"(으)로 변경되었습니다.]");
                        }
                        break;
                  
                  case 6: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                	  System.out.print("변경하고싶은 주소를 작성해주세요.> ");
                        a2.setMember_addr(s.nextLine());
                        if(!a2.getMember_addr().equals("\n")){
                           a1.setMember_addr(a2.getMember_addr());
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
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println();
                           System.out.println("[주소가 "+ a2.getMember_addr() +"(으)로 변경되었습니다.]");
                        }
                        break;
                  
                  case 7: 
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
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                	  System.out.print("전공: Y" + " " + "비전공: N> ");
                        if(s.nextLine().equalsIgnoreCase("y")){
                            member.setMember_major(true);
                         }
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
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("[전공이 변경 되었습니다.]");
                        break;                  
        
                  case 0: 
                     isContinue1 = false;
                     
                     }
                  }
               break;

       

         //탈퇴하기
         case 2:
            boolean flag2 = false;

            Scanner s = new Scanner(System.in);
            String pw;
            MemberVO member1 = new MemberVO();
               
            while(!flag2){   
            System.out.print("비밀번호> ");
               pw = s.nextLine();
               System.out.println();
               
            if (pw.equals(Database.tb_login.getMember_pw())) {
                  mypageDao.remove(Database.tb_login);
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
                    System.out.println("[탈퇴가 정상처리 되었습니다.]");
                    System.out.println();
                  isContinue = false;   
                     flag2 = true;
            }else{
               System.out.println("입력하신 비밀번호가 일치하지 않습니다. 다시 입력해주세요.> ");
         
            }
            }
            
         //뒤로가기
         case 0:
                isContinue = false;
            break;

         }

      }

   }

   @Override
   public void logout() {
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
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("[로그아웃이 정상처리 되었습니다.]");
       System.out.println();
      mypageDao.logout(null);
   }

   
   //로그인시 아이디찾기
      @Override
      public void findid() {
         Scanner s = new Scanner(System.in);
         
         MemberVO member = new MemberVO();
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
            System.out.println("[아이디찾기]");   
            System.out.print("생년월일(예 19941004)> ");
            member.setMember_birth(s.nextLine());
            System.out.println();
            System.out.print("전화번호(예 01*-****-****)> ");
            member.setMember_tel(s.nextLine());
            System.out.println();
            MemberVO idCheck = mypageDao.findID(member.getMember_birth(),member.getMember_tel());
            if(idCheck == null){
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
            	System.out.println("[일치하는 정보가 없습니다. 다시 확인해주세요.]");
                System.out.println();
            }else{
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
            	System.out.println("[아이디는 " + idCheck.getMember_id() + " 입니다.]");
            	System.out.println();
         }
      }
         
         
         
         

      
   

   //로그인시 패스워드찾기
   @Override
   public void findpw() {
         Scanner s = new Scanner(System.in);
         
         MemberVO member = new MemberVO();
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
         	System.out.println("[비밀번호찾기]");
         	System.out.print("아이디> ");
            member.setMember_id(s.nextLine());
            System.out.println();
            System.out.print("전화번호(예 01*-****-****)> ");
            member.setMember_tel(s.nextLine());
            System.out.println();
            MemberVO pwCheck = mypageDao.findPW(member.getMember_id(),member.getMember_tel());
            if(pwCheck == null){
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
            	System.out.println("[일치하는 정보가 없습니다. 다시 확인해 주세요.]");
                System.out.println();
            }else{
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
            	System.out.println("[비밀번호는 " + pwCheck.getMember_pw() + " 입니다.]");
            	System.out.println();
         }
      }
      
   @Override
	public boolean check(String input, int index, boolean flag) {
		String[] dialogue = {"아이디는 5~12자 영문자, 숫자만 사용 가능합니다.]",
							"[비밀번호는 6~12자 영문자, 숫자, 특수문자를 사용하세요.]",
							"[이메일은 6~12자 영문자, 숫자만 사용 가능합니다.]",
							"[전화번호는 01x-xxxx-xxxx 형식으로 입력해 주세요.]"};
		Pattern[] pattern = new Pattern[4];
		// 아이디는 5자리이상 12자리 이하로 만들어야 한다.
		pattern[0] = Pattern.compile("[a-zA-Z0-9]{5,12}");
		// 비밀번호는 6자리이상 12자리 이하이며 특수문자 가능 만들어야 한다.
		pattern[1] = Pattern
				.compile("(?=.*[!?@#$%^&*])[a-z0-9!?@#$%z^&*]{6,12}");
		// 이메일은 숫자와문자의 조합으로 6~12자이며 @이를 포함
		pattern[2] = Pattern.compile("[a-z0-9_-]{5,12}@[a-zA-Z_-]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))");
		// 앞에 01이 꼭 들어가야한다.
		pattern[3] = Pattern
				.compile("^01\\d{1,1}-\\d{3,4}-\\d{3,4}");
		
		
		Matcher matcher = pattern[index].matcher(input);
		if (!matcher.matches()) {
			System.out.println(dialogue[index]);
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}
      
      
      
   }

   


   

