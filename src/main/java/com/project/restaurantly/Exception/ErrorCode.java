package com.project.restaurantly.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
	UNCATEGORIZED_EXCEPTION(504, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
	INVALID(504, "Invalid message key", HttpStatus.BAD_REQUEST),
	UNAUTHENTICATED(504, "Unauthenticated", HttpStatus.UNAUTHORIZED),
	UNAUTHORIZED(505, "You don't have permission", HttpStatus.FORBIDDEN),

	ACCOUNT_EXISTED(504, "Nhân viên đã có tài khoản.", HttpStatus.NOT_FOUND),

	// user name
	USERNAME_INVALID(500, "Tên đăng nhập phải có ít nhất 6 kí tự.", HttpStatus.BAD_REQUEST),
	USERNAME_NOT_EXISTED(504, "Tên đăng nhập không chính xác.", HttpStatus.NOT_FOUND),
	USER_NOT_EXISTED(504, "Tài khoản không chính xác.", HttpStatus.NOT_FOUND),
	USER_NOT_ACTIVE(503, "Tài khoản đã bị khóa.", HttpStatus.NOT_FOUND),
	USERNAME_EXISTED(502, "Tên đăng nhập đã tồn tại.", HttpStatus.BAD_REQUEST),

	// password
	PASSWORD_INVALID(500, "Mật khẩu phải có ít nhất 6 kí tự", HttpStatus.BAD_REQUEST),
	PASSWORD_NO_INCORRECT(500, "Thông tin không chính xác. Vui lòng thử lại.", HttpStatus.NOT_FOUND),
	PASSWORD_NO_MATCH(500, "Mật khẩu mới không được trùng mật khẩu cũ.", HttpStatus.NOT_FOUND),
	OLD_PASS_INCORRECT(500, "Mật khẩu cũ không chính xác. Vui lòng thử lại.", HttpStatus.NOT_FOUND),

	// nhân viên
	EMPLOYEE_NOT_EXISTED(504, "Nhân viên không tồn tại.", HttpStatus.NOT_FOUND),
	EMPLOYEE_EXISTED(504, "Nhân viên đã tồn tại.", HttpStatus.NOT_FOUND),

	// quyền
	ROLE_EXISTED(502, "Quyền đã tồn tại.", HttpStatus.BAD_REQUEST),
	ROLE_NOT_EXISTED(504, "Quyền không tồn tại.", HttpStatus.BAD_REQUEST),

	// menu
	MENU_EXISTED(502, "Mục đã tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),
	MENU_NOT_EXISTED(504, "Mục không tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),
	SUB_MENU_EXISTED(502, "Mục con đã tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),
	SUB_MENU_NOT_EXISTED(504, "Mục con không tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),

	// home_settings
	HOME_SETTING_EXISTED(502, "Cài đặt tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),
	HOME_SETTING_NOT_EXISTED(504, "Cài đặt không tồn tại. Vui lòng chọn một mục khác.", HttpStatus.BAD_REQUEST),

	// products

	// --> foods
	PRODUCTS_FOOD_EXISTED(502, "Sản phẩm đã tồn tại. Vui lòng chọn sản phẩm khác.", HttpStatus.BAD_REQUEST),
	PRODUCTS_FOOD_NOT_EXISTED(504, "Sản phẩm không tồn tại. Vui lòng chọn sản phẩm khác.", HttpStatus.BAD_REQUEST),

	// category
	CATEGORY_EXISTED(502, "Danh mục đã tồn tại. Vui lòng chọn mục khác.", HttpStatus.BAD_REQUEST),
	CATEGORY_NOT_EXISTED(504, "Danh mục không tồn tại. Vui lòng chọn mục khác.", HttpStatus.BAD_REQUEST),

	// favorite, cart
	CART_PRODUCT_EXISTED(502, "Sản phẩm đã có trong giỏ hàng.", HttpStatus.BAD_REQUEST),
	CART_PRODUCT_NOT_EXISTED(504, "Sản phẩm không có trong giỏ hàng.", HttpStatus.BAD_REQUEST),
	FAVORITE_EXISTED(502, "Sản phẩm đã có trong mục yêu thích.", HttpStatus.BAD_REQUEST),
	FAVORITE_NOT_EXISTED(504, "Sản phẩm không có trong mục yêu thích.", HttpStatus.BAD_REQUEST),
	;

	ErrorCode(int code, String message, HttpStatusCode statusCode) {
		this.code = code;
		this.message = message;
		this.statusCode = statusCode;
	}

	private int code;
	private String message;
	private HttpStatusCode statusCode;
}
