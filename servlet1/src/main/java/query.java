import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class pp{

    public String username;
    public String password;
}

@WebServlet("/query")
public class query extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (username==null){
            System.out.println("query中不存在username的value");
        }
        String password = req.getParameter("password");
        if (password==null){
            System.out.println("说明query中不存在password的value");
        }
        System.out.println("password="+password+"   "+"username="+username);
        resp.getWriter().write("username="+username+"   "+"password="+password);
    }
}
