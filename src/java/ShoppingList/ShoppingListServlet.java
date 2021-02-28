package ShoppingList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }

        if (action.equals("add")) {

            if (session.getAttribute("items") != null) {
                String item = request.getParameter("item");
                ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
                items.add(item);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            }

            if (session.getAttribute("items") == null) {
                String item = request.getParameter("item");
                ArrayList<String> items = new ArrayList<>();
                items = new ArrayList<>();
                items.add(item);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

            }

        }

        if (action.equals("delete")) {
            String deleted = (String) request.getParameter("radiobutton");
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            for (int i = (items.size() - 1); i >= 0; i--) {
                if (items.get(i).equals(deleted)) {
                    items.remove(i);
                }
            }
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }

    }

}
