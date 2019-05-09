package ddit_project.service.mypage;

public interface Mypage {

   //회원가입
   void join();
   
   void login();
   
   void showMyInfo();
   
   void logout();
   
    void findid();//
    
    void findpw();//
    
    boolean check(String input, int index, boolean flag);
}