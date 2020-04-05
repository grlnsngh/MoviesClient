/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movieadminsoapclient.servlet;

import com.mycompany.moviesoap.services.MovieService;
import com.mycompany.moviesoap.services.MovieService_Service;
import com.mycompany.moviesoap.services.Movies;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author grlns
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
@MultipartConfig
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.loadMovies(request);
        RequestDispatcher dispacher = request.getRequestDispatcher("/list.jsp");
        dispacher.forward(request, response);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String addMovie = request.getParameter("add");
        String deleteMovie = request.getParameter("deleteid");
        String updatePage = request.getParameter("updateid");
        String updateMovie = request.getParameter("updateMovie");

        HttpSession session = request.getSession();

        MovieService_Service movieService_Service = new MovieService_Service();
        MovieService port = movieService_Service.getMovieServicePort();

        if (addMovie != null || updateMovie != null) {
            String title = request.getParameter("title");
            String producer = request.getParameter("producer");
            String director = request.getParameter("director");

            Movies m = new Movies();
            m.setTitle(title);
            m.setProducer(producer);
            m.setDirector(director);

            try {
                Part part = request.getPart("img");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                InputStream filecontent = part.getInputStream();
                byte[] buffer = new byte[(int) part.getSize()];
                int read = 0;
                while ((read = filecontent.read(buffer)) != -1) {
                    bytes.write(buffer, 0, read);
                }
                m.setImage(buffer);
                if (addMovie != null) {
                    port.addMovie(m);
                } else {
                    int mId = (int) session.getAttribute("movieId");
                    m.setId(BigDecimal.valueOf(mId));
                    port.updateMovie(m);
                }
            } catch (SOAPFaultException ex) {
                this.loadMovies(request);
                request.setAttribute("handlerError", "Please upload movie without the name of 'Disney' in it.");
                RequestDispatcher dispacher = request.getRequestDispatcher("/add.jsp");
                dispacher.forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("imageError", "Please upload a valid image.");
                ex.printStackTrace();
                RequestDispatcher dispacher = request.getRequestDispatcher("/add.jsp");
                dispacher.forward(request, response);
            }
            this.loadMovies(request);
            RequestDispatcher dispacher = request.getRequestDispatcher("/list.jsp");
            dispacher.forward(request, response);
        }

        if (deleteMovie != null) {
            int mId = Integer.parseInt(deleteMovie);
            port.deleteMovie(BigDecimal.valueOf(mId));
            this.loadMovies(request);
            RequestDispatcher dispacher = request.getRequestDispatcher("/list.jsp");
            dispacher.forward(request, response);
        }

        if (updatePage != null) {
            int mId = Integer.parseInt(updatePage);
            Movies m = port.findMovie(BigDecimal.valueOf(mId));
            byte[] imageData = m.getImage();
            String base64Image = Base64.getEncoder().encodeToString(imageData);
            request.setAttribute("uploadedImg", base64Image);
            session.setAttribute("movieId", mId);
            request.setAttribute("movies", m);
            RequestDispatcher dispacher = request.getRequestDispatcher("/update.jsp");
            dispacher.forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void loadMovies(HttpServletRequest request) {

        MovieService_Service service = new MovieService_Service();
        try {
            MovieService port = service.getMovieServicePort();
            List<Movies> movies = port.viewMovie();
            request.setAttribute("movies", movies);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
