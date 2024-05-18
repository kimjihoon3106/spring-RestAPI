package springrestAPI.springrestAPI.board.repository;


import org.springframework.stereotype.Repository;
import springrestAPI.springrestAPI.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
