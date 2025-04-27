package com.server.enums;

public enum Operation {
    // Book CRUD
    CREATE_BOOK,
    READ_BOOK_DATA,
    UPDATE_BOOK,
    DELETE_BOOK,

    // User CRUD
    CREATE_USER,
    READ_USER,
    UPDATE_USER,
    DELETE_USER,

    // GET ALL
    GET_ALL_AUTHORS,
    GET_ALL_BOOKS,
    GET_ALL_USERS,
    GET_ALL_ROLES,

    // MANY-TO-MANY RELATIONS
    GET_AUTHORS_BY_BOOK,
    JOIN_AUTHOR_BOOK,
    SEPARATE_AUTHOR_BOOK,

    // SYSTEM
    LOGIN,
    REGISTER,
    DISCONNECT
}
