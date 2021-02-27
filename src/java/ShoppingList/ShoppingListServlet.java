package ShoppingList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 814545
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            session.invalidate();
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action.equals("register")) {
           
            String username = (String) request.getParameter("username");
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

        if (action.equals("add")) {
            
            if (session.getAttribute("items") == null) {
                String item = request.getParameter("item");
                ArrayList<String> items = new ArrayList<>();
                items.add(item);
                session.setAttribute("items", items);
                //session.setAttribute("number", items.size());
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }

            if (session.getAttribute("items") != null) {
                String item = request.getParameter("item");
                ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
                items.add(item);
                session.setAttribute("items", items);
                //session.setAttribute("number", items.size());
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }

        if (action.equals("delete")) {

            String deleted = (String) request.getParameter("radiobutton");
            session.setAttribute("number", deleted);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

    }

}
