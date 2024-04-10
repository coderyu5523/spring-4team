package shop.mtcoding.blog.reply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyJPARepository extends JpaRepository<Reply,Integer> {

    List<Reply> findByBoardId(Integer boardId);
}
