package shop.mtcoding.blog.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.Optional;

public interface BoardJPARepository extends JpaRepository<Board,Integer> {

    @Query("select b from Board b join fetch b.user where b.id = :boardId")
    Optional<Board> findByIdWithUser(Integer boardId);
}
