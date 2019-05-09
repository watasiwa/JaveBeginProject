package ddit_project.dao.membermanage;

import java.util.ArrayList;

import ddit_project.vo.MemberVO;

public interface MemberManageDao {

   
   ArrayList<MemberVO> showAllMember();
   
   MemberVO selectMemberIdx(int index);
   
   void removeMemberidx(int index);
   
}