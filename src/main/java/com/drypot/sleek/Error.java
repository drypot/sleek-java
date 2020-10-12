package com.drypot.sleek;

public enum Error {
    // General
    INVALID_DATA,
    //INVALID_FORM,

    // Post
    INVALID_CATEGORY,
    INVALID_THREAD,
    INVALID_POST,
    TITLE_EMPTY,
    TITLE_TOO_LONG,
    WRITER_EMPTY,
    WRITER_TOO_LONG,

    // User
    NOT_AUTHENTICATED,
    NOT_AUTHORIZED,
    PASSWORD_WRONG,
}
