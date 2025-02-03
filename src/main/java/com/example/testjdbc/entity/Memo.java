package com.example.testjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Memo {

    @Setter
    private Long id;
    private String content;

    //ㅑㅇ vlfemfmf wpdhlgks skajwl vlfemfmf sjgdmfkrh goTdjdy.
    // 필드를 제외한 나머지 필드를 넣으라고 했어요
    public Memo(String content) {
        this.content = content;
    }
}
