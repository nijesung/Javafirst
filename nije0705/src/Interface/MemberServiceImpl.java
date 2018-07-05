package Interface;
// import java.io.Serializable;

import Interface.MemberService; // MemberService 인터페이스를 implements 한 클래스를 생성
                                // 하나의 인터페이스를 implements 한 클래스의 이름은 인터페이스 이름 뒤에 Impl 을
                                // 붙이는 것이 관례이다.  


 // public class MemberServiceImpl implements MemberService, Serializable {
    public class MemberServiceImpl implements MemberService {

	@Override
	public boolean idCheck(String id) { // boolean 을 이용한 아이디 중복확인검사
		boolean result = false; // 처음에 기본값을 준다
		
		if(id.equals("root") == false) { // id가 root가 아니라면 true
		result = false;
		}
		return result;
		
	}


	@Override
	public int login(String id, String password) {
		// id 가 root 이고 password가 123123 이면 로그인 성공 - 0
		// id 가 root 이고 password가 123123 이 아니면 비밀번호가 틀림 - 1
		// id 가 root 가 아니면 없는 id - 2
		int result = 2;
		if(id.equals("root")) {
			if(password.equals("123123")) {
				result = 0;
			}
			else {
				result = 1;
			}
		}
		return result;
	}


}

