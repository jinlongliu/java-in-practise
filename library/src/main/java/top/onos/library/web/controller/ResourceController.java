package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import top.onos.library.web.domain.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Liu on 2016/11/7.
 */
@Controller
public class ResourceController {
    private static final Log logger = LogFactory.getLog(ResourceController.class);

    @RequestMapping(value = "/login")

    public String login(@ModelAttribute Login login, HttpSession session,
                        Model model) {
        /*ModelAttribute自动创建Login对象实例*/
        model.addAttribute("login", new Login());
        if ("paul".equals(login.getUserName()) &&
                "secret".equals(login.getPassword())) {
            session.setAttribute("loggedIn", Boolean.TRUE);
            /*判断凭证登录*/
            return "Main";
        } else {
            /*进入登录页面*/
            return "LoginForm";
        }
    }

    @RequestMapping(value = "/resource_download")
    public String downloadResource(HttpSession session, HttpServletRequest request,
                                   HttpServletResponse response) {
        if (session == null ||
                session.getAttribute("loggedIn") == null) {
            return "LoginForm";
        }

        /*获取应用真实目录拼接文件目录*/
        String dataDirectory =request.
                getServletContext().getRealPath("/WEB-INF/data");
        /*基于文件目录和文件名创建文件对象实例*/
        File file = new File(dataDirectory, "secret.pdf");
        if (file.exists()) {
            /*设置response相关属性*/
            response.setContentType("application/pdf");
            /*服务端向客户端发文件，如果类型支持，浏览器默认打开，
            *如果需要提示用户保存，则使用下列属性*/
            response.addHeader("Content-Disposition",
                               "attachment; filename=secret.pdf");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (IOException ex) {

            } finally {
                /*关闭文件流操作*/
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {

                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {

                    }
                }
            }
        }
        return null;
    }
}
