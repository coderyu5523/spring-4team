package shop.mtcoding.blog.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository;

    public List<Board> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Board> boardList = boardJPARepository.findAll(sort);
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

    public Board findById(Integer boardId) {
       Board board = boardJPARepository.findById(boardId).get();
       return board;
    }

    @Transactional
    public void update(BoardRequest.UpdateDTO requestDTO,Integer boardId) {
        Board board = boardJPARepository.findById(boardId).get();
        board.update(requestDTO.getTitle(),requestDTO.getContent());
    }
}
