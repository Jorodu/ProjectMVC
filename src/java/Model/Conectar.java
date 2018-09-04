
package Model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
 
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource bdatos=new DriverManagerDataSource();
        bdatos.setDriverClassName("com.mysql.jdbc.Driver");
        bdatos.setUrl("jdbc:mysql://localhost:3306/bdmonitoriasjj");
        bdatos.setUsername("root");
        bdatos.setPassword("");
        return bdatos;
        
    }
}
