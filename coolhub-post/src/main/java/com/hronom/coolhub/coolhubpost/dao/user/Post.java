package com.hronom.coolhub.coolhubpost.dao.user;

public record Post(
        String id,
        String owner,
        String title,
        String text
) {
}
