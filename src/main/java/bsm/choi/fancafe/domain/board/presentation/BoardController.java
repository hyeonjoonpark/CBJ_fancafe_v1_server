package bsm.choi.fancafe.domain.board.presentation;

import bsm.choi.fancafe.domain.board.entity.BoardEntity;
import bsm.choi.fancafe.domain.board.presentation.dto.request.BoardUploadRequestDto;
import bsm.choi.fancafe.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public Page<BoardEntity> boardList(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        int adjustedPage = page > 0 ? page - 1 : 0; // 페이지 번호 조정
        PageRequest pageRequest = PageRequest.of(adjustedPage, size);
        return boardService.boardList(pageRequest);
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> boardUpload(@RequestBody BoardUploadRequestDto dto) {
        boardService.save(dto);
        return ResponseEntity.ok().build();
    }
}