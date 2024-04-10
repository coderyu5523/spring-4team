package shop.mtcoding.blog.reply;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.board.BoardJPARepository;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyJPARepository replyJPARepository ;
    private final BoardJPARepository boardJPARepository;

    public void save(ReplyRequest.SaveDTO requstDTO, User sessionUser) {
       Board board = boardJPARepository.findById(requstDTO.getBoardId()).get();
       replyJPARepository.save(requstDTO.toEntity(board,sessionUser));
    }

    @Transactional
    public Integer delete(Integer replyId, User sessionUser) {
       Reply reply = replyJPARepository.findById(replyId).get();
        replyJPARepository.delete(reply);
        return reply.getBoard().getId();

    }
}
