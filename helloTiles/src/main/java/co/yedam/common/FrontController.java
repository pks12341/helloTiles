package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.admin.web.MemberListControl;
import co.yedam.board.web.BoardListControl;
import co.yedam.board.web.GetBoardControl;


//url : *.do
public class FrontController extends HttpServlet {

	// init -> service ->
	Map<String, Command> map = new HashMap<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
	
		map.put("/boardList.do", new BoardListControl());
		
		map.put("/memberList.do", new MemberListControl());
		
//		map.put("/getBoard.do", new GetBoardControl());
//		
//		map.put("/replyList.do", new ReplyListControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController");
		//요청정보의 한글 인코딩 방식.
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI(); // http://localhost:8080/helloJSP/??.do helloJSP 부터가 uri값
		String context = req.getServletContext().getContextPath(); // helloJSP //getContextPath는 프로젝트 이름이다
		String page = uri.substring(context.length());
		System.out.println(page);

		Command controller = map.get(page);
		System.out.println("호출 page : " + page);
		controller.execute(req, resp);
	}

}
