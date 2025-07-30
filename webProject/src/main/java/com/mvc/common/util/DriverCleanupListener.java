package com.mvc.common.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

// 이 클래스는 ServletContextListener를 구현한 리스너로, 웹 애플리케이션 시작 및 종료 시점에 동작.
public class DriverCleanupListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	
    	//DriverManager.getDrivers()를 통해 등록된 JDBC 드라이버 목록을 가져온다.
        Enumeration<Driver> drivers = DriverManager.getDrivers();      //드라이버 얻기 
        while (drivers.hasMoreElements()) {							//드라이버가 여러개일수 있으니 순차접근
            Driver driver = drivers.nextElement();				
            try {
            
            	//각 드라이버가 현재 웹 애플리케이션의 클래스 로더에 의해 로드된 것인지 확인.
                if (driver.getClass().getClassLoader() == Thread.currentThread().getContextClassLoader()) {  //수행되고 있는 요소와 같다면
                
                    DriverManager.deregisterDriver(driver);  //해당 드라이버를 DriverManager.deregisterDriver()로 해제하여 메모리 누수 방지.
                    System.out.println("[INFO] JDBC 드라이버 해제됨: " + driver);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {    // 정적으로 등록돼있는 jdbc 드라이버 해제 
        // 필요 시 초기 작업
    }
}









