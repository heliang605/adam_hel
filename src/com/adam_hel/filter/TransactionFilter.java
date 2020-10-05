package com.adam_hel.filter;

import com.adam_hel.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * ClassName:TransactionFilter
 * Package:com.adam_hel.filter
 * Description:
 *
 * @Date:2020/9/30 20:44
 * @Author:adam_hel@163.com
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();// 提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }
    }

    @Override
    public void destroy() {

    }
}
