package ddit_project.service.membermanage;



import java.util.ArrayList;
import java.util.Scanner;

import ddit_project.dao.membermanage.MemberManageDao;
import ddit_project.dao.membermanage.MemberManageDaoImpl;
import ddit_project.vo.Database;
import ddit_project.vo.MemberVO;

public class MemberManageImpl implements MemberManage {
   Scanner s = new Scanner(System.in);
   /*
    * MemberManage 인터페이스를 구현한 클래스 인터페이스에 메소드 추가 삭제 금지 (non-Javadoc)
    * 
    * @see ddit_project.service.membermanage.MemberManage#showMemberInfo()
    */

   MemberManageDao memberManageDao = new MemberManageDaoImpl();

   @Override
   public void showMemberInfo() {
      
      boolean isContinue = true;
      while (isContinue) {
         
         printMember();         // 메서드에 반복문을 넣어서 메서드를 호출함.

         // 출력이 끝나고
         System.out.println("[메뉴를 선택해주세요.]"); // 로그인이 되어 있지 않을 경우
         System.out.println("1.회원정보수정");
         System.out.println("2.회원탈퇴");
         System.out.println("0.뒤로가기");
         int menu = s.nextInt();
         
         
         switch (menu) {

         case 1:
            printMember();
            
            System.out.println("[변경하고 싶은 회원의 번호를 선택해주세요.]");
            int index = s.nextInt();
            s.nextLine();
            MemberVO a1=memberManageDao.selectMemberIdx(index);
            MemberVO a2 = new MemberVO();
            
            boolean isContinue1= true;
            while(isContinue1){
            
            singlePrintMember(index);
            
            System.out.println("[변경하고 싶은 정보의 번호를 선택해주세요.]");
            System.out.println("1.이름 ");
            System.out.println("2.비밀번호");
            System.out.println("3.생년월일 ");
            System.out.println("4.이메일 ");
            System.out.println("5.전화번호 ");
            System.out.println("6.주소 ");
            System.out.println("7.전공 / 비전공 ");
            System.out.println("8.관리자권한");
            System.out.println("0.뒤로가기 ");
            
            int i = s.nextInt();
            s.nextLine();
//            String check;
            switch(i){
               
/*            check = s.nextLine();
            if(check.length() <=10){
               a2.setMember_name(check);   
            } else{
               System.out.println("최대범위를 초과하였습니다.");
            }
*/            
                     
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
                System.out.println("[관리자정보수정]");
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
                      System.out.println();
                  	  System.out.println();
                  	  System.out.println();
                  	  System.out.println();
                  	  System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
                      System.out.println();
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
                }
                else {a1.setMember_major(false);}
         		  System.out.println("[전공이 변경 되었습니다.]");
         		  System.out.println();
            	  System.out.println();
            	  System.out.println();
            	  System.out.println();
            	  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  System.out.println();
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
                  
            case 8: 
            	System.out.println();
            	System.out.println();
            	System.out.println();
            	System.out.println();
            	System.out.println();
            	System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            	System.out.println("관리자: Y" + " " + "일반회원: F>"); 
            	if(s.nextLine().equalsIgnoreCase("y")){  
                }
                else {a1.setMember_major(false);}
            		System.out.println("[권한이 변경 되었습니다.]");
    
            		break;
           
            case 0: 
               isContinue1 = false;
               
               }
            }
         break;

         case 2:
            printMember();
            System.out.println();
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("[삭제하고 싶은 회원의 번호를 입력하세요.]");
             index = s.nextInt();
             s.nextLine();
            MemberVO member = memberManageDao.selectMemberIdx(index);
            System.out.print("[정말로 "+ member.getMember_id()+ " 삭제하시겠습니까? (Y/N)]" );
            String i =null;
            i = s.nextLine();
            if(i.equals("Y") || i.equals("y")){
               memberManageDao.removeMemberidx(index);
            } else if(i.equals("N") || i.equals("n")){
               
               break;
            }
               
            String id =   member.getMember_id();
            System.out.println("------------------------------------");
            System.out.println("[아이디 " +id+" 가 삭제 완료되었습니다.]");
         
            break;

         case 0:
            isContinue = false;
            break;
         }

      }

   }

   @Override
   public void printMember() {
      ArrayList<MemberVO> list1 = memberManageDao.showAllMember();// 리스트형태로

      int num = 1;
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("==========================================================================================================================================================================");
      System.out.println("번호   " +  "아이디   " +  "  비밀번호   " + " 이름   " + 
                         " 생년월일   " + "  이메일   "  + "             전화번호   " + "       주소   " +
    		             "       전공   " + "    권한");
      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      for (MemberVO member : list1) {
    	  System.out.println(num + "." + "     " + member.getMember_id() + "\t"  
    		   + member.getMember_pw() + "    "
               + member.getMember_name() + "   "
               + member.getMember_birth() + "   "
               + member.getMember_email() + "   "  
               + member.getMember_tel() + "   " 
               + member.getMember_addr() + "   "  
               + (member.isMember_major() ? "전공" : "비전공") + "   " 
               + (member.isMember_auth() ? "관리자" : "일반회원"));

         num++;
      }
      System.out.println("==========================================================================================================================================================================");
      num = 1;
   }

   @Override
   public void singlePrintMember(int index) {
      ArrayList<MemberVO> list = memberManageDao.showAllMember() ;
      
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println(list.get(index - 1).getMember_id() + " \t "
            + list.get(index - 1).getMember_name() + " \t"
            + list.get(index - 1).getMember_birth() + "\t"
            + list.get(index - 1).getMember_email() + "\t"
            + list.get(index - 1).getMember_tel() + "\t"
            + list.get(index - 1).getMember_addr() + "\t"
            + (list.get(index - 1).isMember_major() ? "전공" : "비전공") + "\t"
            + (list.get(index - 1).isMember_auth() ? "관리자" : "일반인") + "\t"
            + list.get(index - 1).getMember_pw());

   }

}