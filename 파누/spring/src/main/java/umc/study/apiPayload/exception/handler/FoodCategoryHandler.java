package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

  public FoodCategoryHandler() {
    super(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);  // 기본값
  }

  public FoodCategoryHandler(BaseErrorCode errorCode) {
    super(errorCode);  // 확장성까지 갖춘 생성자
  }

  // 선택적으로 정적 팩토리도 가능
  public static FoodCategoryHandler notFound() {
    return new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
  }
}


