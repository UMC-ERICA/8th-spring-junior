package com.umc.spring.service.memberService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.convert.MemberLikeFoodConverter;
import com.umc.spring.domain.Food;
import com.umc.spring.domain.mapping.MemberLikeFood;
import com.umc.spring.repository.foodRepository.FoodRepository;
import com.umc.spring.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.umc.spring.convert.MemberConverter.*;
import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import com.umc.spring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodRepository foodRepository;


    @Override
    @Transactional
    public Member joinMember(JoinDto request) {

        Member newMember = toMember(request) ;
        List<Food> likeFoodList = request.getLikeFoods().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new ErrorHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberLikeFood> memberLikeFoodList = MemberLikeFoodConverter.toMemberListFoodList(likeFoodList);

        memberLikeFoodList.forEach(memberLikeFood -> memberLikeFood.setMember(newMember));

        return memberRepository.save(newMember);
    }


}
