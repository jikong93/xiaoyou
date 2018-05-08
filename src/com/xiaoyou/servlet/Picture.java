package com.xiaoyou.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Picture")
public class Picture extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //�þ�ȷ�������ʱ������ͼƬ����
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String formatStr = formatter.format(new Date());
        //ͼƬ�洢·��
        String path = "c:/image/" + formatStr + ".jpg";
        //�洢ͼƬ������·��
        String imagePath="39.105.10.110/"+path;
        //����request���󷵻ؿͻ�������������
        try (ServletInputStream sis = request.getInputStream()) {
            //��ͼƬ��ŵ�ָ����·��
            OutputStream os = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buf = new byte[1024];
            int length = 0;
            //ʹ��sis�Ķ�ȡ���ݵķ���
            length = sis.readLine(buf, 0, buf.length);
            while (length != -1) {
                bos.write(buf, 0, length);
                length = sis.read(buf);
            }
            sis.close();
            bos.close();
            os.close();
            //�ظ����ͻ���ͼƬ��ַ
            out.write("{\"picture\":0}");
            out.write("{\"message\":imagePath}");
            out.println(imagePath);
            out.close();
        } catch (Exception e) {
            //�ظ����ͻ���ͼƬ�洢������Ϣ
            out.write("{\"picture\":1}");
            out.write("{\"message\":\"ͼƬ�洢ʧ��\"}");
            out.println(imagePath);
            out.close();
        }
    }
}