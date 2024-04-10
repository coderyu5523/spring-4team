package shop.mtcoding.blog.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.blog.user.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;

    public List<Board> findAll() {
        List<Board> boardList = boardJPARepository.findAll();
        return boardList;
    }

    public BoardResponse.DetailDTO findByIdJoinUser(Integer boardId) {
        Board board = boardJPARepository.findByIdWithUser(boardId).get();
        BoardResponse.DetailDTO detailDTO = new BoardResponse.DetailDTO(board);
        return detailDTO ;
    }

    @Transactional
    public void save(BoardRequest.SaveDTO requestDTO) {
        boardJPARepository.save(requestDTO.toEntity());
    }
}
