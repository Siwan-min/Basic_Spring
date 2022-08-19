package com.example.springweb.member;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    private ArrayList<Member> members = new ArrayList<>() {{
       add(new Member("hong", "홍길동", 20, true));
        add(new Member("shin", "신사임당", 15, false));
        add(new Member("kang", "강감찬", 35, true));

    }};

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findByUserId(String userId) {

        return members.stream().filter(
                m -> m.getUserId().equals(userId)
        ).findAny().get();

        /*Member find = null;
        for(Member member : members){
            if(member.getUserId().equals(userId)){
                find = member;
                break;
            }
        }

        return find;*/
    }

    @Override
    public List<Member> findByGender(boolean gender) {
        return members.stream().filter(m -> m.isGender() == gender).collect(Collectors.toList());
    }

    @Override
    public void delete(String userId) {

        Member member = members.stream().filter(m ->m.getUserId().equals(userId)).findAny().get();
        members.remove(member);
    }
}
