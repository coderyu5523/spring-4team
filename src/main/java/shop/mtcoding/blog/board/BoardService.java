package shop.mtcoding.blog.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import shop.mtcoding.blog.reply.Reply;
import shop.mtcoding.blog.reply.ReplyJPARepository;
import shop.mtcoding.blog.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;
    private final ReplyJPARepository replyJPARepository;

    public List<Board> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Board> boardList = boardJPARepository.findAll(sort);
        return boardList;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public BoardResponse.DetailDTO findByIdJoinUser(Integer boardId, User sessionUser) {
        Board board = boardJPARepository.findByIdWithUser(boardId).get();
        List<Reply> replyList = replyJPARepository.findByBoardId(boardId);

        if (sessionUser != null && board.getUser().getId() == sessionUser.getId()) {
            Boolean isBoardOwner = true;
            BoardResponse.DetailDTO detailDTO = new BoardResponse.DetailDTO(board, isBoardOwner,replyList);
            return detailDTO;

        } else {
            Boolean isBoardOwner = false;
            BoardResponse.DetailDTO detailDTO = new BoardResponse.DetailDTO(board, isBoardOwner,replyList);
            return detailDTO;
        }

    }

    @Transactional
    public void save(BoardRequest.SaveDTO requestDTO) {
        boardJPARepository.save(requestDTO.toEntity());
    }

    public Board findById(Integer boardId) {
        Board board = boardJPARepository.findById(boardId).get();
        return board;
    }

    @Transactional
    public void update(BoardRequest.UpdateDTO requestDTO, Integer boardId) {
        Board board = boardJPARepository.findById(boardId).get();
        board.update(requestDTO.getTitle(), requestDTO.getContent());
    }
}
