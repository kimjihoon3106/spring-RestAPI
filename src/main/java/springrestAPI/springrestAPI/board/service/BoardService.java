package springrestAPI.springrestAPI.board.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springrestAPI.springrestAPI.board.dto.request.BoardCreateRequest;
import springrestAPI.springrestAPI.board.dto.request.BoardUpdateRequest;
import springrestAPI.springrestAPI.board.dto.response.BoardCreateResponse;
import springrestAPI.springrestAPI.board.dto.response.BoardGetResponse;
import springrestAPI.springrestAPI.board.dto.response.BoardInfoResponse;
import springrestAPI.springrestAPI.board.entity.Board;
import springrestAPI.springrestAPI.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardCreateResponse boardCreate(BoardCreateRequest boardCreateRequest) {
        if (boardCreateRequest.getName().isBlank() || boardCreateRequest.getAbout().isBlank()) throw new IllegalArgumentException("Name and about must not be blank");
        Board content = new Board();
        content.setId(boardCreateRequest.getId());
        content.setName(boardCreateRequest.getName());
        content.setAbout(boardCreateRequest.getAbout());
        content = boardRepository.save(content);
        return new BoardCreateResponse(content.getId(), content.getName(), content.getAbout());
    }

    @Transactional(readOnly = true)
    public List<BoardGetResponse> boardGets() {
        List<Board> boards = boardRepository.findAll();
        List<BoardGetResponse> boardGetResponses = new ArrayList<>();

        for(Board board : boards) {
            boardGetResponses.add(new BoardGetResponse(board.getId(), board.getName(), board.getAbout()));
        }
        return boardGetResponses;
    }

    @Transactional(readOnly = true)
    public BoardInfoResponse boardGet(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new BoardInfoResponse(board.getId(),board.getName(),board.getAbout());
    }

    @Transactional
    public void boardDelete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        boardRepository.delete(board);
    }

    @Transactional
    public void boardUpdate(BoardUpdateRequest boardUpdateRequest, Long id) {
        Board board = boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        board.setName(boardUpdateRequest.getName());
        board.setAbout(boardUpdateRequest.getAbout());
        boardRepository.save(board);
    }

}
