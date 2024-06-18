package org.myworkspace.CineSpot.Entities.enums;

public enum Role {
    ADMIN, GUEST, MEMBER;
}
// MEMBER --> registered user : can browse shows, book ticket
// GUEST --> unregistered user : can browse shows, no booking
// ADMIN --> from theater side : add/remove movies/shows +++