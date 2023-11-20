package com.fh.proxool;

import org.apache.shardingsphere.driver.governance.api.yaml.YamlGovernanceShardingSphereDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 此示例适用于 hibernate proxool 连接池
 * 需在启动时加载本类
 * @date 2021/12/22 0022
 */
public class DbteDriver implements Driver {

    private DataSource dataSource;

    public DbteDriver(){
        try {
            //文件路径可根据自身项目情况写入配置文件，这里仅供演示
            File globalFile = new File("D:\\code\\database\\jdbc-demo\\spring-MVC-demo\\src\\main\\resources\\sharding.app.yml");
            File dataSource = new File("D:\\code\\database\\jdbc-demo\\spring-MVC-demo\\src\\main\\resources\\dataSource.yml");
            File policyFile = new File("D:\\code\\database\\jdbc-demo\\spring-MVC-demo\\src\\main\\resources\\policy.json");
            //此演示程序使用离线加密策略，实际集成时，请调用无需传入policy.json的接口创建数据源
            //此演示程序的配置文件仅供参考，实际集成时，请使用正式的文件，使用绝对路径
            this.dataSource = YamlGovernanceShardingSphereDataSourceFactory.createDataSource(globalFile, dataSource, true, policyFile, false);
//            this.dataSource = YamlGovernanceShardingSphereDataSourceFactory.createDataSource(globalFile, dataSource, true, false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if(url.startsWith("proxool.demo")) {
            return dataSource.getConnection();
        }
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        //url模式：proxool[.alias]
        return url.startsWith("proxool.demo");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 8;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
