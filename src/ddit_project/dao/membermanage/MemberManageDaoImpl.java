package ddit_project.dao.membermanage;

import java.util.ArrayList;

import ddit_project.vo.Database;
import ddit_project.vo.MemberVO;

public class MemberManageDaoImpl implements MemberManageDao {

   @Override
   public ArrayList<MemberVO> showAllMember() {
   
      return Database.tb_member;
   }

   @Override
   public MemberVO selectMemberIdx(int index) {
      
      //선택한 인덱스의 값에 해당하는 것을 tb_member에서 찾아서 
      ;
      return Database.tb_member.get(index-1);
   }

   @Override
   public void removeMemberidx(int index) {
      // 매개변수로 받은 인덱스-1의 값을 tb_member 에서 제거
      Database.tb_member.remove(index-1);
   }

}