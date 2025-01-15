package com.chowon.chownhub.board;

public enum BoardSubject {
    NOTICE("notice"),
    SPECS("specs"),
    HEART("heart");

    private String subjectName;

    BoardSubject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
