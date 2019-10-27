package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.Admin;
import com.util.CookieUtils;

/**
 * Servlet Filter implementation class Myfilter
 */
@WebFilter("/*")
public class Myfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Myfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		try {
			//将ServletRequestת转换成HttpServletRequest
			HttpServletRequest request= (HttpServletRequest) req;
			
			//先判断session还有没有 user,
			Admin user = (Admin) request.getSession().getAttribute("user");
			if(user != null ) {
				//放行,
				chain.doFilter(request, response);
			}else {
				//session失效
				
				//从客户端获取Cookies[]集合
				Cookie[] cookies=request.getCookies();
				//查找名字为Ϊ auto_login 的cookie
				Cookie cookie = CookieUtils.findCookie(cookies, "auto_login");
				//第一次来
				if(cookie ==null) {
					//放行
					chain.doFilter(request, response);
				}else {
					//不是第一次来
					//取值做登录
					String value =cookie.getValue();
					String username = value.split("#")[0];
					String password = value.split("#")[1];
					//封装Bean
					Admin admin=new Admin();
					admin.setUsername(username);
					admin.setPassword(password);
					//访问数据库
					UserDao dao =new UserDaoImpl();
					 user = dao.checkedCount(admin);
					 
					 //存到session域中，方便下次未过期前使用
					 request.getSession().setAttribute("user", user);
					 chain.doFilter(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			chain.doFilter(req, response);
		}	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
