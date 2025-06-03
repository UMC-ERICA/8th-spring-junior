package umc.study.service.memberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    void printMyPageInfo(Long memberId);

    Page<Review> getMyReviewList(Long memberId, Integer page);

    Page<MemberMission> getInProgressMissions(Long memberId, Integer page);

    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
