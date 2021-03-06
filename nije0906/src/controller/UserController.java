package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.Fighter;


@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserService userService;
    public UserController() {
        super();
        userService = UserServiceImpl.sharedInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 경로에서 프로젝트 경로를 제거
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command =
				requestURI.substring(
					contextPath.length() +1);
		// 세션을 사용하는 경우가 많으므로 여기서 미리 세션을 생성
		HttpSession session = request.getSession();
		
		// command 가 콘솔에 출력이 되지 않으면 URL 을 제대로 처리하지 못한 것
		// form 에서 전송할 때 사용할 URL 과 Servlet 이 처리하는 URL 이 같은 지 확인
		// System.out.println(command);
		
		switch(command) {
		case "user/login":
			// 서비스 메소드 호출
			Fighter user = userService.login(request);
			
			// 로그인에 실패한 경우
			if(user == null) {
				session.setAttribute("user", user);
				session.setAttribute("msg", "email 이나 비밀번호가 틀렸잖아.");
			}else { // 로그인에 성공 한 경우
				session.setAttribute("user", user);
			}
			// 로그인 성공여부에 관계 없이 메인 페이지로 리다이렉트
			// 현재 요청이 user/login 이므로 현재 위치는 user
			// 메인으로 가기 위해서는 user 의 상위로 이동해야 한다.
			response.sendRedirect("../");
			break;
			
		case "user/logout":
			// 세션을 초기화
			session.invalidate();
			// 시작 페이지로 리다이렉트
			response.sendRedirect("../");
			break;
			
		case "user/register":
			// 단순 페이지 이동
			// 출력하는 페이지의 경로를 설정할 때는 URL 을 기준으로 한다.
			// 지금 URL 이 user/register 이므로 기준위치는
			// WebContent 의 fighter 이다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("../fighter/register.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "user/insert":
			// 이 문장이 나오지 않으면 링크 확인
			System.out.println("회원가입 처리");
			boolean r = userService.registerFighter(request);
			if(r == true) {
				// 회원가입에 성공했을 때
				session.setAttribute("msg", "회원 가입이 성공했다.");
				response.sendRedirect("../");
			}else {
				// 회원가입에 실패했을 때 처리
				session.setAttribute("msg", "회원 가입에 실패했다.");
				response.sendRedirect("register");
			}
			
			break;
			
		case "user/emailcheck":
			boolean result = userService.emailCheck(request);
			
			//json 으로 출력할 때는 리턴받은 데이터를 바로 저장하지 말고 JSON 객체로 변환하여 저장
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			// 데이터를 저장
			request.setAttribute("result", obj);
			// 결과 페이지로 포워딩 - 리다이렉트로 가능
			RequestDispatcher dispatcher01 = request.getRequestDispatcher("/fighter/emailcheck.jsp");
			dispatcher01.forward(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
