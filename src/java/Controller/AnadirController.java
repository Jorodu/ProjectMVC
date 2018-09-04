
package Controller;

import Model.Conectar;
import Model.Estudiantes;
import Model.EstudiantesValidar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("anadir.htm")
public class AnadirController {
    EstudiantesValidar usuariosValidar;
    private JdbcTemplate jdbcTemplate;
    
    public AnadirController() 
    {
        this.usuariosValidar=new EstudiantesValidar();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("anadir");
        mav.addObject("estudiantes",new Estudiantes());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("estudiantes") Estudiantes u,
                BindingResult result,
                SessionStatus status
        )
    {
        this.usuariosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("anadir");
            mav.addObject("estudiantes",new Estudiantes());
            return mav;
        }else
        {
        this.jdbcTemplate.update
        (
        "insert into table_estudiante (id_estudiante,nombres,apellidos correo,codigo_carnet,id_nivel_estudio) values (?,?,?,?,?,?)",
         u.getId_estudiante(),u.getNombres(),u.getApellidos(),u.getCorreo(),u.getCodigo_carnet(),u.getId_nivel_estudio()
        );
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
}
