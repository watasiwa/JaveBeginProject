package ddit_project.dao.board;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import ddit_project.vo.BoardVO;
import ddit_project.vo.Database;
import ddit_project.vo.ReplyVO;

public class BoardDaoImpl implements BoardDao {

	@Override
	public void createBoard(BoardVO board) {
		Database.tb_board.add(board);
	}

	@Override
	public ArrayList<BoardVO> showBoardList() {
		return Database.tb_board;
	}

	@Override
	public BoardVO selectBoard(int index) {// index는 게시글의 번호
		for (int i = 0; i < Database.tb_board.size(); i++) {
			BoardVO board = Database.tb_board.get(i);
			if (board.getBoard_no() == index) { // 게시글번호와 일치하는 게시글이 존재하면
				return board;
			}
		}
		return null;

	}

	@Override
	public void deleteBoard(BoardVO board) {
		Database.tb_board.remove(board);
	}

	// 매개변수로 넘어온 index를 pk로 가지고 있는 게시판의 인덱스를 반환 (미완성)
	@Override
	public int selectBoardidx(int index) {
		for (int i = 0; i < Database.tb_board.size(); i++) {
			BoardVO board = Database.tb_board.get(i);
			if (board.getBoard_no() == index) { // 게시글번호와 일치하는 게시글이 존재하면 그 리스트에
												// 인덱스를 반환
				return 123123123;
			}
		}
		return -1;
	}

	@Override
	public void createReply(ReplyVO reply) {
		Database.tb_reply.add(reply);

	}

	@Override
	public ArrayList<ReplyVO> showReply(int boardno) {
		ArrayList<ReplyVO> replyList = new ArrayList<ReplyVO>();
		for (ReplyVO reply : Database.tb_reply) {
			if (reply.getBoard_no() == boardno) {
				replyList.add(reply);
			}
		}
		return replyList;
	}

	@Override
	public void removeReply(int replyno) { // 부모글과
		for (int i = 0; i < Database.tb_reply.size(); i++) {
			ReplyVO reply = Database.tb_reply.get(i);
			if (reply.getReply_no() == replyno) {
				Database.tb_reply.remove(reply);
			}

		}

	}

	@Override
	public void removeReplyAll(int boardno) {
		for (int i = 0; i < Database.tb_reply.size(); i++) {
			ReplyVO reply = new ReplyVO();
			reply = Database.tb_reply.get(i);
			if (reply.getBoard_no() == boardno) {
				Database.tb_reply.remove(reply);
				continue;
			}

		}
	}

	@Override
	public ReplyVO updateReply(int replyno) {
		ReplyVO reply = new ReplyVO();
		for (int i = 0; i < Database.tb_reply.size(); i++) {
			reply = Database.tb_reply.get(i);
			if (reply.getReply_no() == replyno) {
				return reply;
			}

		}
		return null;
	}

	@Override
	public ReplyVO getReplyMember(int replyno) {
		ReplyVO reply = new ReplyVO();
		for (int i = 0; i < Database.tb_reply.size(); i++) {
			reply = Database.tb_reply.get(i);
			if (reply.getReply_no() == replyno) {
				return reply;
			}
		}
		return null;
	}
}