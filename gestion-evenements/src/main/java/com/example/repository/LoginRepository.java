package com.example.repository;

import com.example.entity.Person;

public interface LoginRepository {
    Person isMember(String email, String password);
}
