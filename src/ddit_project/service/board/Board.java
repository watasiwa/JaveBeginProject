package ddit_project.service.board;

import java.io.File;

import ddit_project.vo.BoardVO;
import ddit_project.vo.ReplyVO;

public interface Board {
	String currentdate();

	ReplyVO writeReply(int index);

	BoardVO writeBoard();

	void showboardlist();

	void showboard();

	void showDetail();

	void updateBoarddetail(BoardVO Board);

	File filePath();

	String fileRead();

	void print(int a);
}