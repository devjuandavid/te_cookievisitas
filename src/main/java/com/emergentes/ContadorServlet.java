
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUAN DAVID
 */
@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 int contador =0;
            
            //ONTENER EL ARREGLO DE COOKIES CLIENTE
            Cookie[] cukis = request.getCookies();
            if(cukis !=null){
                for(Cookie c : cukis){
                    if(c.getName().equals("visitas")){
                        //ANTES DE LA ASIGNACION SE CONVIERTE UN VALOR EN CADENA
                        contador = Integer.parseInt(c.getValue());
                    }
                }
            }
            contador ++;
            //ANTES DE LA ASIGNACION  SE CONVUIERTE CADENA A VALOR
            Cookie c =new Cookie("visitas", Integer.toString(contador));
            
            c.setMaxAge(30);
            response.addCookie(c);
            //GENERAR CONTENIDO A PARTIR DE SERVLET
            response.setContentType("Text/html");
            
            PrintWriter out = response.getWriter();
            out.println("visitante Nº"+contador);


    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
}
