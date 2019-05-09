package ddit_project.service.lunch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import ddit_project.dao.lunch.LunchDao;
import ddit_project.dao.lunch.LunchDaoImpl;
import ddit_project.vo.Database;
import ddit_project.vo.LunchVO;

public class LunchImpl implements Lunch {
   LunchDao lunchDao = new LunchDaoImpl();
   Scanner s = new Scanner(System.in);
   ArrayList<String> lunchList = new ArrayList<String>();  // 식단을 임시 저장할 ArrayList<String> 선언
   String fileRoute = null;                        // 파일 경로 저장하여 null일 시에 다시 입력받게 하는 String 타입
   boolean check = false;                           // 로그인한 유저가 tb_lunch_member에 등록되었는지 확인
   boolean lunchCreateCheck = false;                  // 식단표등록 여부 확인
   Calendar today = Calendar.getInstance(); 
   
   @Override
   public File filePath() {                     // 파일의 경로 및 이름을 scanner로 받아서 File클래스 lunchFile에 저장하여 반환
      if (fileRoute == null) {                  // fileRoute에 경로 및 이름을 한번도 입력을 안했을시에 true
         System.out.print("파일경로부터 이름까지 입력해주세요.\n>");   
         fileRoute = s.nextLine();               // 파일경로 및 이름을 String 변수에 저장                        
      }               
      File lunchFile = new File(fileRoute+".txt");    // lunch변수에 파일경로 및 이름저장
      return lunchFile;                        // file타입의 lunchFile을 리턴
   }
   
   @Override
	public void fileRead() {							// 메모장에 있는 식단을 tb_lunch에 저장하고, 만약 파일이 없을시에 생성
		try{
			// 메모장 한글형식 변환후 BufferedReader클래스타입의 reder에 String형식으로 저장
			BufferedReader reder = new BufferedReader(new FileReader(filePath()));
			String lunch = null;							// 메모장에서 불러온 값을 임시로 저장하는 String타입 변수
			lunchDao.clearLunch();							// 현재 ArrayList<String>tb_lunch에 있는 값을 전부 지운다.
			for (int i = 0; i < 100; i++){					// 메모장에 있는 31줄까지 복사
				lunch = reder.readLine();					// String lunch변수에 reder에 담긴 값을 저장
				if (lunch != null){		// lunch변수에 null이 아닌경우만 true
					if (lunch != "\n")						
						lunchDao.insertLunch(lunch);			// insertLunch() 호출하여 ArrayList<String>tb_lunch에 저장
				}
			}
			if (!lunchCreateCheck){
				System.out.println("식단표가 등록되었습니다.");
				Thread.sleep(1000);
				lunchCreateCheck = true;
			}
			reder.close();									// BufferedReader클래스의 입력메서드 종료.
			
		}catch(FileNotFoundException e){					// 파일 없으면 파일을 생성하며, 생성시에 권환으로 인하여 오류가 나올 시 알려주는 로직
			System.out.println("파일이 없습니다.");
			try {
				System.out.println("파일을 생성합니다.");
				FileOutputStream fos = new FileOutputStream(filePath());	// 파일생성을 위한 FileOutputStream타입을 선언하여 생성자매개변수로 
				System.out.println("식단표가 등록되었습니다.");
				Thread.sleep(1000);
				fos.close();												// 파일경로 및 이름을 String타입으로 반환 fos.close(); 파일닫기
			} catch (FileNotFoundException e1) {							// 파일생성시 오류
				System.out.println("파일을 생성하는데 권환이 필요하여 생성하지 못했습니다.");	
				fileRoute = null;											// 파일위치 및 이름을 null로 초기화
				return;
			} catch (IOException e1) {										// 입출력 에러
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}catch(IOException e){												// 입출력 에러 
			System.out.println(e);											
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
   @Override
   public void fileWrite() {                                       // 메모장 파일에 글을 작성하고 tb_lunch에 내용을 저장
      boolean loop = true;
      while (loop) {                                             // input에  int형 말고 다른 타입이 올 경우 반복
         try {
            System.out.print("작성할 내용 총 열을 입력해주세요.\n>");
            int input = s.nextInt();                              
            s.nextLine();
            for (int i = 0; i < input; i++) {                        // 작성할 내용의 열을 입력받아서 차례대로(현 메모장 처럼) 작성
               if (i == 0) {
                  System.out.print("작성할 내용을 입력하세요.\n>");
               }
               BufferedWriter write = new BufferedWriter(new FileWriter(   // 파일작성 클래스를 선언 및 생성자 매개변수에
                     fileRoute + ".txt", true));                     // (파일경로 및 이름 , 값이 있을시 그 다음 줄에 작성)
               write.write(s.nextLine());                           // 메모장에 작성할 내용을 사용자에게 입력받는다.
               write.newLine();                                 // 메모장에 줄바꿈
               write.flush();                                    // write변수에 버퍼 지우기
               write.close();                                    // 파일작성 클래스 닫기 
               fileRead();                                       // 메모장에 쓴 내용을 tb_lunch에 저장
            }
            System.out.println("정상적으로 작성하여 저장되었습니다.");
            Thread.sleep(1000);
            loop = false;                                       // 루프 벗어나기
         } catch (IOException e) {                                 // 입출력 에러
            System.out.println(e);   
            
         } catch (InputMismatchException e) {                        // nextInt()시에 다른 타입의 값을 입력할때에 발생되는 오류
            System.out.println("숫자를 입력해주세요.");                     // nextInt후 바로 catch문으로 가기 때문에
            s.nextLine();                                       // nextInt후 \n(개행문자)가 버퍼에 남아있어서 버퍼에 있는 \n(개행문자)삭제 
         } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                                   
      }
   }
   
   @Override
   
   public void lunchCreate() {                        // 글작성하는 loop메뉴 메소드
      fileRead();                                 // 메모장에 있는 식단을 tb_lunch에 저장하고, 만약 파일이 없을시에 생성
      boolean loop = true;                        
      while (loop) {                              // input에  int형 말고 다른 타입이 올 경우 반복
         System.out.println();
         lineadd();
         lunchInfo();                           // tb_lunch에 있는 식단표 출력
         lineadd();
         System.out.println("1.글작성");
         System.out.println("0.뒤로가기");
         System.out.print("메뉴를 선택하세요 \n>");
         try{
            int input = s.nextInt();               
            s.nextLine();                        // nextInt후 \n(개행문자)가 버퍼에 남아있어서 버퍼에 있는 \n(개행문자)삭제 
            switch(input) {            
               case 1:
                  fileWrite();                  // 메모장 파일에 글을 작성하고 tb_lunch에 내용을 저장
                  break;
               case 0:
                  loop = false;                  // 루프 벗어나기
               default :
                  break;
            }
         }catch (InputMismatchException e){            // nextInt()시에 다른 타입의 값을 입력할때에 발생되는 오류
            System.out.println("숫자를 입력해주세요.");      // nextInt후 바로 catch문으로 가기 때문에
            s.nextLine();                        // nextInt후 \n(개행문자)가 버퍼에 남아있어서 버퍼에 있는 \n(개행문자)삭제 
         }
      }
   }
   
   
   
   @Override
   public void lunchUpdate() {                        // 글수정하는 loop메뉴 메소드
      boolean loop = true;
      while (loop) {
         try {
            lunchList = lunchDao.selectAllLunch();      // lunchList변수에 ArrayList<String>tb_lunch에 있는 값을 저장 
            System.out.print("변경할 날짜를 입력해주세요 \n>");
            int index = s.nextInt();
            s.nextLine();                        // nextInt후 \n(개행문자)가 버퍼에 남아있어서 버퍼에 있는 \n(개행문자)삭제 
            
            if (index-1 < lunchList.size()) {         // index - 1은 arrayList의 인덱스 시작번호 0번 부터 사작해서
               System.out.print("변경할 내용을 입력해주세요 \n>");
               String content = s.nextLine();
               
               lunchDao.setLunch(index-1,content);
               
               FileOutputStream fos = new FileOutputStream(filePath());
               BufferedWriter write = new BufferedWriter(new FileWriter(
                     fileRoute + ".txt", true));
               lunchList = lunchDao.selectAllLunch();
               
               for (String i : lunchList){                  
                  write.write(i+"\r\n");
               }
               System.out.println("정상적으로 수정되었습니다.");
               Thread.sleep(1000);
               write.close();
               loop = false;
            } else {
               System.out.println("현재 동록되어 있는 날짜를 입력해주세요.");
            }
         } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            s.nextLine();
         } catch (FileNotFoundException e) {
            System.out.println("해당파일이 없습니다.");
         } catch (IOException e) {
            loop = false;
         } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
   }

   @Override
   public void filedelete() {
      try {
         lunchDao.clearLunch();
         FileOutputStream fos = new FileOutputStream(filePath());
         fileRoute = null;
         lunchCreateCheck = false;
         System.out.println("정상적으로 삭제되었습니다.");
         Thread.sleep(1000);
      } catch (FileNotFoundException | InterruptedException e) {
         e.printStackTrace();
      }
      
   }

   @Override
	public void lunchInfo() {	
		lunchList = lunchDao.selectAllLunch();				// lunchList변수에 ArrayList<String>tb_lunch에 있는 값을 저장
		if(lunchList.size() != 0) {
			for (String i : lunchList){						// lunchList 크기 만큼 돌아가며 반복하며, String i에 값을 하나씩 저장하여 출력
				System.out.println(i);
			}
		} else if (lunchCreateCheck == false){
			System.out.println("등록된 식단표가 없습니다.");
		}
	}
	
	@Override
	public void lunchUserInfo() {	
		lunchList = lunchDao.selectAllLunch();				// lunchList변수에 ArrayList<String>tb_lunch에 있는 값을 저장
		int i = today.get(today.DATE)-1;
		if(lunchList.size() != 0) {		
			System.out.println(lunchList.get(i));
		
		} else if (lunchCreateCheck == false){
			System.out.println("작성된 내용이 없습니다.");
		}
	}
   
   @Override
   public void userLunchCheck(int input) {      // 로그인시에 LunchVO user 객채생성후 Database.tb_lunch_member에 저장
      LunchVO user = new LunchVO(); 
      user.setLunch_id(Database.tb_login.getMember_id());
      user.setLunch_name(Database.tb_login.getMember_name());
      user.setLunch_date(""+today.get(Calendar.DATE));
      int index = 0;
      
      for (int i = 0; i < lunchDao.sizeLunch_Member(); i++){
         if(Database.tb_login.getMember_id().equals
               (Database.tb_lunch_member.get(i).getLunch_id())){
            index = i;
         }
      }
      
      if (input == 1){
         user.setLunch_check("1");
      }else if(input == 2){
         user.setLunch_check("2");
      }else {
         user.setLunch_check("3");
      }
    
      lunchDao.setLunch_Member(index, user);
     
   }
   
   public void userLunchCheck(int input,int index) {      // 로그인시에 LunchVO user 객채생성후 Database.tb_lunch_member에 저장
	      LunchVO user = new LunchVO();
	      user.setLunch_id(Database.tb_member.get(index).getMember_id());
	      user.setLunch_name(Database.tb_member.get(index).getMember_name());
	      user.setLunch_date(""+today.get(Calendar.DATE));
	      
	      if (input == 1){
	         user.setLunch_check("1");
	      }else if(input == 2){
	         user.setLunch_check("2");
	      }else {
	         user.setLunch_check("3");
	      }
	      
	     
	      lunchDao.insertLunch_Member(user);
	   }
   
   public void lunchInfoManager() {
	   lineChange();
      lunchInfo();
      lineadd();
      if (lunchDao.sizeLunch_Member() != 0){
         System.out.println("이름 : 점심유무");
         lineadd();
      }
      int yes = 0, no = 0, notSelected = 0;
      
      for (int i = 0; i < lunchDao.sizeLunch_Member(); i++) {
         int select = Database.tb_lunch_member.get(i).getLunch_check().charAt(0) - '0';
         System.out.printf("%s : %s\n",Database.tb_lunch_member.get(i).getLunch_name(),
                        select == 1 ? "먹음" : select == 2 ? "안먹음" : "선택안함");
         switch(select){
         case 1:
            yes++;
            break;
         case 2:
            no++;
            break;
         default :
            notSelected++;
            break;
         }   
      }
      lineadd();
      System.out.printf("밥 먹는 인원 : %d\t 밥 안먹는 인원 : %d\t 선택 안한 인원 : %d\t 총금액 : %d\n",yes,no,notSelected,yes*3500);
      lineadd();
      System.out.print("0.뒤로가기\n>");
       try {
            System.in.read();
       } catch (IOException e) { }
          
   }
   
   @Override
	public void lineChange() {
		for (int i = 0; i < 80; i++)
			System.out.println();
	}
   
   @Override
	public void lineadd() {
		System.out.println("=======================================================================================================================================================================================");
		
	}
   
   @Override
   public void lunchManagerMenu() {
	  lineChange();
   
      boolean loop = true;
      while (loop) {
         System.out.println();
         lineadd();
         lunchInfo();
         lineadd();
         System.out.println("1.식단표등록");
         System.out.println("2.수정");
         System.out.println("3.전체삭제");
         System.out.println("4.조회");
         System.out.println("5.점심체크");
         System.out.println("0.뒤로가기");
         System.out.print("메뉴를 선택하세요 \n>");
         try{
            int input = s.nextInt();
            s.nextLine();
            switch(input) {
            
            case 1:
               lunchCreate();
               break;
            case 2:
               lunchUpdate();
               break;
            case 3:
               filedelete();
               break;
            case 4:
               lunchInfoManager();
               break;
            case 5:
               lunchUserMenu();
               break;
            case 0:
               loop = false;
            default :
               break;
            }
         }catch (InputMismatchException e){
            System.out.println("숫자를 입력해주세요.");
            s.nextLine();
         }
      }
   }

   @Override
	public void lunchUserMenu() {
	    lineChange();
		
		boolean loop = true;
		while (loop) {
			System.out.println();
			lineadd();
			lunchUserInfo();
			lineadd();
			if(!(today.get(Calendar.DAY_OF_WEEK) == 1 || today.get(Calendar.DAY_OF_WEEK) == 7)) {
				System.out.println("1.먹는다");
				System.out.println("2.안먹는다");
				System.out.println("0.뒤로가기");
				System.out.print("메뉴를 선택하세요 \n>");
				try{
					int input = s.nextInt();
					s.nextLine();
					switch(input) {
					
						case 1:
							userLunchCheck(input);
						case 2:
							userLunchCheck(input);
						case 0:
							loop = false;
						default :
							break;
					}
				}catch (InputMismatchException e){
					System.out.println("숫자를 입력해주세요.");
					s.nextLine();
				}
			}else {
				System.out.println("주말은 쉽니다.");
				loop = false;
			}
		}
	}

	

	
}