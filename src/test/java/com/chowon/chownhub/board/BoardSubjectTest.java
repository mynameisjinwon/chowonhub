package com.chowon.chownhub.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoardSubjectTest {

    @Test
    public void enumTest() {
        String subjectName = BoardSubject.NOTICE.getSubjectName();
        assertThat(subjectName).isEqualTo("notice");
        BoardSubject notice = BoardSubject.valueOf("NOTICE");
        assertThat(notice).isEqualTo(BoardSubject.NOTICE);
    }
}