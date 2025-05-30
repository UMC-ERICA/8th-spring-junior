package com.umc.spring.service.missionService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Region;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import com.umc.spring.repository.memberRepository.MemberRepository;
import com.umc.spring.repository.missionRepository.MissionRepository;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public MemberMission findMemberMission(Long memberId, Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findByMemberAndMission(member, mission);
    }

    @Override
    public List<Mission> findMissionsByRegionAndStatus(Region region) {
        return missionRepository.findMissionsByRegionAndStatus(region);
    }

    @Override
    public Page<Mission> getMissionListByMemberId(Long memberId, Integer page) {
        Member member = memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (page <= 0) {
            throw new ErrorHandler(ErrorStatus.NEGATIVE_PAGE_NUMBER_REQUEST);
        }

        Page<MemberMission> memberMissions = memberMissionRepository.findAllByMember(member, PageRequest.of(page - 1, 10));

        return memberMissions.map(MemberMission::getMission);
    }

    @Override
    public Page<Mission> getMissionListByRestaurantId(Long restId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        if (page <= 0) {
            throw new ErrorHandler(ErrorStatus.NEGATIVE_PAGE_NUMBER_REQUEST);
        }

        return missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page - 1, 10));
    }

    @Override
    public Page<MemberMission> updateMissionStatusByMissionId(Long missionId, Long memberId, Integer page) {
        if (page <= 0) {
            throw new ErrorHandler(ErrorStatus.NEGATIVE_PAGE_NUMBER_REQUEST);
        }

        MemberMission memberMission = findMemberMission(memberId, missionId);

        Member member = memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (memberMission.getStatus().equals(MemberMissionStatus.WAIT_ACCUMULATE)) {
            memberMission.setStatus(MemberMissionStatus.COMPLETE);
        }

        return memberMissionRepository.findAllByMember(member, PageRequest.of(page - 1, 10));

    }
}
