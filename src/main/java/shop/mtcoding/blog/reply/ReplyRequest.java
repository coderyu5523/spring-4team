package shop.mtcoding.blog.reply;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import shop.mtcoding.blog.board.Board;
import shop.mtcoding.blog.user.User;

public class ReplyRequest {
    @Data
    public static class SaveDTO{
        private String comment;
        private Integer boardId;

        public Reply toEntity(Board board, User sessionUser){
            return Reply.builder()
                    .comment(comment)
                    .board(board)
                    .user(sessionUser)
                    .build();
        }
    }
}
