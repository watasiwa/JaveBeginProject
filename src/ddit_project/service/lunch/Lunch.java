package ddit_project.service.lunch;

import java.io.File;


public interface Lunch {
	 void lunchManagerMenu();
	   void lunchCreate();
	   void lunchUpdate();
	   File filePath();
	   void filedelete();
	   void lunchInfo();
	   void lunchUserMenu();
	   void userLunchCheck(int input);
	   void fileRead();
	   void fileWrite();
	   public void userLunchCheck(int input,int index);
	   void lunchUserInfo();
	   void lineChange();
	   void lineadd();
  }