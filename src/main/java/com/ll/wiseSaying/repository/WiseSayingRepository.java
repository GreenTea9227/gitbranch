package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(long id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }

        return null;
    }

    public long write(String content, String authorName) {
        long id = lastWiseSayingId + 1;

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);

        lastWiseSayingId = id; // 방금 새 명언이 생성되었으니, lastWiseSayingId 값을 갱신한다.

        return id;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String content, String authorName) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);
    }
}
