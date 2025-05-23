package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberFoodConverter;
import umc.study.domain.Food;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberFood;
import umc.study.repository.foodRepository.FoodRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.web.dto.MemberRequestDTO;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);

        List<Food> foodList = request.getPreferCategory().stream()
                .map(id -> foodRepository.findById(id)
                        .orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFoodConverter.toMemberFoodList(foodList, newMember);

        memberFoodList.forEach(memberFood -> {memberFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
