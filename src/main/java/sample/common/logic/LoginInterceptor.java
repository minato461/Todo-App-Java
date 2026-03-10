package sample.common.logic;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle
	(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// セッションからログイン情報を取得
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}

}

