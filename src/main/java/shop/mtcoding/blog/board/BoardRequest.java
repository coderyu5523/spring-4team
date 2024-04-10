package shop.mtcoding.blog.board;

import lombok.Data;

public class BoardRequest {

    @Data
    public static class SaveDTO{
        private String title;
        private String content;

        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
