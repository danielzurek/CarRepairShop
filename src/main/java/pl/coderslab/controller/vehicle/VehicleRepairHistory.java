package pl.coderslab.controller.vehicle;

import pl.coderslab.dao.RepairDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/vehicle/repairs")
public class VehicleRepairHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            List<RepairDao> repairs = RepairDao.findByVehicleId(id);
            request.setAttribute("repairs", repairs);
            getServletContext().getRequestDispatcher("/WEB-INF/views/repair/repairHistory.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}