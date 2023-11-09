package co.yedam.admin.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.admin.service.MemberVO;
import co.yedam.common.Command;

public class MemberListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String path = "member/memberList.tiles";

		List<MemberVO> list = new ArrayList<>();
		list.add(new MemberVO());
		req.setAttribute("list", list);

		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
