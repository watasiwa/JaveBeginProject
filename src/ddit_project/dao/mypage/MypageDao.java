package ddit_project.dao.mypage;

import ddit_project.vo.MemberVO;

public interface MypageDao {

   void insertMember(MemberVO member);
   
   MemberVO selectMember(String key, String value);
      
   MemberVO checklogin(String id, String pw);
   
   MemberVO showMyInfo();
   
   MemberVO updateMyInfo(String id);
   
   MemberVO findID(String birth, String tel); //
   
   MemberVO findPW(String id, String tel); //
   
   int findIndex(MemberVO member);
   
   void remove(MemberVO member);
   
   void logout(MemberVO member);
   
}