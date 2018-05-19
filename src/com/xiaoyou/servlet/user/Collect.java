package com.xiaoyou.servlet.user;

import com.xiaoyou.domain.user.MyCollectDomain;
import com.xiaoyou.jdbc.dao.dao.product.ProductDao;
import com.xiaoyou.jdbc.dao.dao.user.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Collect"},name = "Collect")
public class Collect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        MyCollectDomain my_collect = new MyCollectDomain(request.getParameter("user_name"),Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("mark")));
        int i = new UserDao().collection(my_collect);
        if (i == 0) {
            out.write("{\"collect\":0,\"message\":\"商品收藏成功\"}");
            out.close();
        } else {
            out.write("{\"collect\":1,\"message\":\"商品收藏失败\"}");
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
