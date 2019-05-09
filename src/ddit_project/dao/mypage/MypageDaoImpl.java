package ddit_project.dao.mypage;

import java.util.ArrayList;
import java.util.HashMap;

import ddit_project.vo.Database;
import ddit_project.vo.MemberVO;

public class MypageDaoImpl implements MypageDao {

   @Override
   public void insertMember(MemberVO member) {
      Database.tb_member.add(member);
      
   }

   //회원가입 아이디중복체크
   @Override
   public MemberVO selectMember(String key, String value) {
      /*ID 값과 value값을 비교해 테이블에 아이디가 중복되어 있으면 
       그 MemberVO를 리턴
      없으면 null을 리턴
      (반복문 사용)*/
      for(int i = 0; i < Database.tb_member.size(); i++){
         MemberVO idoverlap = Database.tb_member.get(i);
            
            if(key.equals("ID")){
               if(idoverlap.getMember_id().equals(value)){
                  return idoverlap;
               }
            }
         }
         return null; 
      }
      
   


   //로그인시 아이디 비밀번호 체크
   @Override
   public MemberVO checklogin(String id, String pw) {
      /*입력받은 아이디와 비밀번호와 동일한 값을 가지고 있는 객체가
       * tb_member에 존재하는 지 검사하는 로직 
       * 존재한다면 그 MemberVO객체를 리턴
       */
      for(int i = 0; i < Database.tb_member.size(); i++){
         MemberVO idpwCheck = Database.tb_member.get(i);
            
            if(id.equals(id)&&pw.equals(pw)){
               if(idpwCheck.getMember_id().equals(id)&&idpwCheck.getMember_pw().equals(pw)){
                  return idpwCheck; 
               }
            }
         }   
      return null;
   }
   



   
   
   
    //마이페이지 내정보보여주기
   @Override
   public MemberVO showMyInfo() {

      return Database.tb_login;   
   }

   
   
   @Override
   public MemberVO updateMyInfo(String id) {
      /* 
      findIndex(member);를 사용해서 인덱스값을 받아서
      ArrayList에 값을 변경 
      ArrayList.set(index,member)를 사용
       */
      MemberVO modifyInfo = new MemberVO();
      for(int i=0; i<Database.tb_member.size(); i++){
         modifyInfo = Database.tb_member.get(i);
            if(modifyInfo.getMember_id().equals(id)){
               return modifyInfo;
            }  
      }
       return null;
     }
      
      
      

   

   @Override
   public int findIndex(MemberVO member) {
      /*매개변수로 받은 member객체가 tbtable에 있는 지 검사하고
       * 존재하면 그것의 인덱스(위치)를 반환
       * 
       * 
       */
      return 0;
   }

   //탈퇴하기
   @Override
   public void remove(MemberVO member) {
      //들어온 객체를 매개변수로 tb_login에 있는 값을 삭제
      Database.tb_member.remove(member);
      logout(member);
      
   }


   //로그아웃
   @Override
   public void logout(MemberVO member) {
      Database.tb_login=null;
   
   }

   
   

   //아이디찾기
   @Override
   public MemberVO findID(String birth, String tel) {
         for(int i = 0; i < Database.tb_member.size(); i++){
            MemberVO idCheck = Database.tb_member.get(i);
               
               if(birth.equals(birth)&&tel.equals(tel)){
                  if(idCheck.getMember_birth().equals(birth)&&idCheck.getMember_tel().equals(tel)){
                     return idCheck; 
                  }
               }
            }   
         return null;
      
      }
   


   //패스워드찾기
   @Override
   public MemberVO findPW(String id, String tel) {
         for(int i = 0; i < Database.tb_member.size(); i++){
            MemberVO pwCheck = Database.tb_member.get(i);
               if(id.equals(id)&&tel.equals(tel)){
                  if(pwCheck.getMember_id().equals(id)&&pwCheck.getMember_tel().equals(tel)){
                     return pwCheck; 
                  }
               }
            }   
         return null;
      }   
   }
   



      
      
      
      
      
