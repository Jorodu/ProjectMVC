
package Controller;

import Model.Conectar;
import Model.Estudiantes;
import Model.EstudiantesValidar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("editar.htm")
public class EditarController 
{
    EstudiantesValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;
     
    
    public EditarController() 
    {
        this.usuariosValidar=new EstudiantesValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        int id_estudiante=Integer.parseInt(request.getParameter("id_estudiante"));
        Estudiantes datos=this.selectUsuario(id_estudiante);
        mav.setViewName("editar");
        mav.addObject("estudiantes",new Estudiantes(id_estudiante,datos.getNombres(),datos.getApellidos(),datos.getCorreo(),datos.getCodigo_carnet(),datos.getId_nivel_estudio()));
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("estudiantes") Estudiantes u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.usuariosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            int id_estudiante=Integer.parseInt(request.getParameter("id_estudiante"));
            Estudiantes datos=this.selectUsuario(id_estudiante);
            mav.setViewName("editar");
            mav.addObject("estudiantes",new Estudiantes(id_estudiante,datos.getNombres(),datos.getApellidos(),datos.getCorreo(),datos.getCodigo_carnet(),datos.getId_nivel_estudio()));
            return mav;
        }else
        {
            int id_estudiante=Integer.parseInt(request.getParameter("id_estudiante"));
        this.jdbcTemplate.update(
                    "update table_estudiante "
                + "set nombres=?,"
                + "set apellidos=?,"         
                + "correo=?,"
                + "codigo_carnet=? "
                + "id_nivel_estudio=? "
                + "where "
                + "id_estudiante=? ",
        u.getNombres(),u.getApellidos(),u.getCorreo(),u.getCodigo_carnet(),u.getId_nivel_estudio(),id_estudiante);
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
    public Estudiantes selectUsuario(int id) 
    {
        final Estudiantes user = new Estudiantes();
        String quer = "SELECT * FROM usuarios WHERE id='" + id+"'";
        return (Estudiantes) jdbcTemplate.query
        (quer, new ResultSetExtractor<Estudiantes>() 
            {
                public Estudiantes extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        user.setNombres(rs.getString("nombre"));
                        user.setCorreo(rs.getString("correo"));
                        user.setTelefonos(rs.getString("telefono"));
                    }
                    return user;
                }


            }
        );
    }
}

