package com.fet.expressnote.framework.exception;

public class ExpressPrintException extends CommonException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2227370122447723330L;
	public ExpressPrintException(ExpressPrintEnum e){
		this.setErrorCode(e.getErrorCode());
		this.setErrorMessage(e.getErrorMessage());
	}
	public static enum ExpressPrintEnum {
        TEST_ERROR("3800","測試用錯誤"),
        OPTIONAL_MUST_ONE_ERROR("3801","請輸入至少一項條件"),
        APPLYDATE_NULL_ERROR("3802","日期缺少起或迄")
        ;
        private final String errorCode;
        private final String errorMessage;

        private ExpressPrintEnum(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        @Override
        public String toString() {
            return errorCode + ": " + errorMessage;
        }
    }
}
