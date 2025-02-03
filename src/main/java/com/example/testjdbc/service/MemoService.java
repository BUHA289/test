package com.example.testjdbc.service;

import com.example.testjdbc.dto.MemoRequestDto;
import com.example.testjdbc.dto.MemoResponseDto;
import com.example.testjdbc.entity.Memo;
import com.example.testjdbc.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.MemoryManagerMXBean;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto createMemo(MemoRequestDto dto) {
        Memo memo = new Memo(dto.getContent());
        Memo savedMemo = memoRepository.save(memo);
        MemoResponseDto memoResponseDto = new MemoResponseDto(savedMemo.getId(), savedMemo.getContent());
        return memoResponseDto;
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtoList = new ArrayList<>();
        for (Memo memo : memos) {
            MemoResponseDto dto = new MemoResponseDto(memo.getId(), memo.getContent());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto findById(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalArgumentException("Memo not found"));
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo.getId(), memo.getContent());
        return memoResponseDto;
    }

    @Transactional
    public MemoResponseDto updateContent(Long memoId, MemoRequestDto dto) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalArgumentException("Memo not found"));
    Memo updateMemo = memoRepository.updateContent(memoId, dto.getContent());
    return new MemoResponseDto(updateMemo.getId(), updateMemo.getContent());
    }

    @Transactional
    public void deleteById(Long memoId) {
        memoRepository.findById(memoId).orElseThrow(() -> new IllegalArgumentException("Memo not found"));
        memoRepository.deleteById(memoId);
    }
}