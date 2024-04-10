package shop.mtcoding.blog.board;

import lombok.Data;
import shop.mtcoding.blog.reply.Reply;

import java.util.ArrayList;
import java.util.List;

public class BoardResponse {

    @Data
    public static class DetailDTO{
        private Integer id ;
        private String title ;
        private String content ;
        private String username;
        private Boolean isBoardOwner;
        private List<ReplyDTO> replyList = new ArrayList<>();

        public DetailDTO(Board board,Boolean isBoardOwne,List<Reply> replyList){
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.username = board.getUser().getUsername();
            this.isBoardOwner = isBoardOwner;

            this.replyList = replyList.stream().map(reply -> new ReplyDTO(reply)).toList();

        }

    }

    @Data
    public static class ReplyDTO{
        private Integer id ;
        private String comment ;
        private String username;

        public ReplyDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.username = reply.getUser().getUsername();
        }
    }

}
