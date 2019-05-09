package ddit_project.dao.lunch;

import java.util.ArrayList;

import ddit_project.vo.Database;
import ddit_project.vo.LunchVO;

public class LunchDaoImpl implements LunchDao {

   @Override
   public void insertLunch(String lunch) {
      Database.tb_lunch.add(lunch);
   }

   @Override
   public ArrayList<String> selectAllLunch() {
      return Database.tb_lunch;
   }

   
   @Override
   public void clearLunch() {
      Database.tb_lunch.clear();
   }

   @Override
   public void setLunch(int index, String content) {
      Database.tb_lunch.set(index, content);
      
   }

   @Override
   public void insertLunch_Member(LunchVO lunch) {
      Database.tb_lunch_member.add(lunch);
      
   }

   @Override
   public void clearLunch_Member() {
      Database.tb_lunch_member.clear();
   }

   @Override
   public void setLunch_Member(int index, LunchVO content) {
      Database.tb_lunch_member.set(index, content);
      
   }

   @Override
   public ArrayList<LunchVO> selectAllLunch_Member() {
      return Database.tb_lunch_member;
   }

   @Override
   public int sizeLunch_Member() {
      return Database.tb_lunch_member.size();
   }

   @Override
   public int sizeLunch() {
      return Database.tb_lunch.size();
   }

   


}