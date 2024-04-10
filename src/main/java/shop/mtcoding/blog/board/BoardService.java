package shop.mtcoding.blog.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardJPARepository boardJPARepository ;

    public List<Board> findAll() {
       List<Board> boardList = boardJPARepository.findAll();
       return boardList ;
    }
}
