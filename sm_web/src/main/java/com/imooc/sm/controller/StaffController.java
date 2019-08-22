package com.imooc.sm.controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.global.Tool;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始进入主界面123");
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String account = request.getParameter("account");
        Integer did = Integer.parseInt(request.getParameter("did"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Date bornDate = Tool.formatDate(request.getParameter("bornDate"), "yyyy-MM-dd");
        String info = request.getParameter("info");

        Staff staff = new Staff();
        staff.setAccount(account);
        staff.setDid(did);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setInfo(info);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Staff staff = staffService.get(id);
        List<Department> list = departmentService.getAll();

        request.setAttribute("OBJ", staff);
        request.setAttribute("list",list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        Integer did = Integer.parseInt(request.getParameter("did"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Date bornDate = Tool.formatDate(request.getParameter("bornDate"), "yyyy-MM-dd");
        String info = request.getParameter("info");

        Staff staff = staffService.get(id);
        staff.setAccount(account);
        staff.setDid(did);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setInfo(info);

        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Staff staff = staffService.get(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }









}
