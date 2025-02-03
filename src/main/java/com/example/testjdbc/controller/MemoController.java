package com.example.testjdbc.controller;

import com.example.testjdbc.dto.MemoRequestDto;
import com.example.testjdbc.dto.MemoResponseDto;
import com.example.testjdbc.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto) {
        return ResponseEntity.ok(memoService.createMemo(dto));
    }

    @GetMapping("/memos")
    public ResponseEntity<List<MemoResponseDto>> findAll() {
        return ResponseEntity.ok(memoService.findAll());
    }

    @GetMapping("/memos/{memoId}")
    public MemoResponseDto findById(@PathVariable Long memoId) {
        return memoService.findById(memoId);
    }

    @PutMapping("/memos/{memoId")
    public MemoResponseDto updateMemoContent(@PathVariable Long memoId, @RequestBody MemoRequestDto dto) {
        return memoService.updateContent(memoId, dto);

    }

    @DeleteMapping("/memos/{memoId}")
    public void delete(@PathVariable Long memoId) {
        memoService.deleteById(memoId);
    }
}
