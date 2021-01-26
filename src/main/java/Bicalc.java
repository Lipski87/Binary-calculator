import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Bi-calc", value = "/bi-calc")
public class Bicalc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String number = request.getParameter("number");
        Pattern pattern = Pattern.compile("^[01]+$");
        Matcher matcher = pattern.matcher(number);

        if (matcher.matches()) {
            Integer.parseInt(number);
            char[] chars = number.toCharArray();
            int counter = 0;
            int sum = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                int pow = (int) (Math.pow(2, counter) * Integer.parseInt(String.valueOf(chars[i])));
                counter++;
                sum += pow;
            }
            response.getWriter().append(number + " to " + sum + " w systemie dziesiętnym<br>").append("<a href='/bi-calc.html'>Wstecz").append("</a>");

        } else if (number.isEmpty()) {

            response.getWriter().append("Nie zostawiaj pustego pola<br>").append("<a href='/bi-calc.html'>Wstecz").append("</a>");

        } else {
            response.getWriter().append("Wartość binarna może się składać tylko z '0' i '1'<br>").append("<a href='/bi-calc.html'>Wstecz").append("</a>");
        }
    }
}
