package ddit_project.dao.lunch;

import java.util.ArrayList;

import ddit_project.vo.LunchVO;

public interface LunchDao {
   void insertLunch(String lunch);
   void clearLunch();
   void setLunch(int index, String content);
   ArrayList<String> selectAllLunch();
   int sizeLunch();
   
   void insertLunch_Member(LunchVO lunch);
   void clearLunch_Member();
   void setLunch_Member(int index, LunchVO content);
   ArrayList<LunchVO> selectAllLunch_Member();
   int sizeLunch_Member();
}