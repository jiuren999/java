import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class son{
    public String username;
    public String password;
}

@WebServlet("/json")
public class json extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        son s = objectMapper.readValue(req.getInputStream(),son.class);
        resp.getWriter().write("username = "+s.username+"   "+"password="+s.password);

    }
}
