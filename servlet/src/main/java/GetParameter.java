import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getParameter")
public class GetParameter extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //前端通过uri的 query string 传递 username和password 两个属性
        String username = req.getParameter("username");
        if (username==null){
            System.out.println("username 这个key在query string中不存在");
        }
        String password = req.getParameter( "password");
        if (password==null){
            System.out.println("password 这个key在query string 中不存在");
        }
        System.out.println("username = "+username+",password = "+password);

        resp.getWriter().write("password"+password);
    }
}
