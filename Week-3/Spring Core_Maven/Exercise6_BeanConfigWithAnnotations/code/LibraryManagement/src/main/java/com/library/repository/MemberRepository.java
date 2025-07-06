package com.library.repository;

import com.library.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    public Member getMemberDetails() {
        return new Member("Rajeswari");
    }
}
