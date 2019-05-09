package ddit_project.dao.board;

import java.util.ArrayList;

import ddit_project.vo.BoardVO;
import ddit_project.vo.ReplyVO;

public interface BoardDao {

	BoardVO selectBoard(int index);

	int selectBoardidx(int index);

	void createBoard(BoardVO board);

	void deleteBoard(BoardVO board);

	void createReply(ReplyVO reply);

	void removeReply(int replyno);

	void removeReplyAll(int boardno);

	ReplyVO getReplyMember(int replyno);

	ReplyVO updateReply(int replyno);

	ArrayList<ReplyVO> showReply(int boardno);

	ArrayList<BoardVO> showBoardList();
}