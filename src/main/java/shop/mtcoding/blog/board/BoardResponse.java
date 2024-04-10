package shop.mtcoding.blog.board;

import lombok.Data;
import shop.mtcoding.blog.user.User;

public class BoardResponse {

    @Data
    public static class DetailDTO{
        private Integer id ;
        private String title ;
        private String content ;
        private String username;

        public DetailDTO(Board board){
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.username = board.getUser().getUsername();

        }

    }
}
