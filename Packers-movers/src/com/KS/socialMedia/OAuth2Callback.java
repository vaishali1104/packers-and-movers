package com.KS.socialMedia;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/oauth2callback")
public class OAuth2Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String className = "com.sl.Oauth2callback";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String code = request.getParameter("code");
			String urlParameters = "code=" + code + "&client_id=" + Setup.CLIENT_ID + "&client_secret="
					+ Setup.CLIENT_SECRET + "&redirect_uri=" + Setup.REDIRECT_URL + "&grant_type=authorization_code";
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line1 = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			System.out.println(line1);
			
			String s = GsonUtility.getJsonElementString("access_token", line1);//dsfs45fds4f

			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + s);
			conn = url.openConnection();
			
			
			line1 = "";
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				line1 = line1 + line;
			}
			System.out.println("Line 1 => " + line1);
			writer.close();
			reader.close();
			

			GooglePojo data = (GooglePojo) new Gson().fromJson(line1, GooglePojo.class);
			
			RequestDispatcher rd=null;
			UserDao userDao=new UserDao();
			UserBean bean=userDao.getDataByEmail(data.getEmail());
			HttpSession session = request.getSession();
			
			if(bean==null)
			{
				bean = new UserBean();
				bean.setUserEmail(data.getEmail());
				bean.setUserName(data.getName());
				System.out.println("name:"+data.getName());
				bean.setUserTypeId("1");
				UserBean bean2=userDao.insertGoogleUser(bean);
				session.setAttribute("UserBean", bean2);
				if(bean2!=null)
				{
					rd=request.getRequestDispatcher("UserHome.jsp");
				}
				else
				{
					rd=request.getRequestDispatcher("Error.jsp");
				}
			}
			else
			{
				session.setAttribute("UserBean", bean);
				rd = request.getRequestDispatcher("UserHome.jsp");
				
			}
			
//usrdao[-[->get5dat5aby6email(email)
			//if bean ==null
			    //insert
			//else
			//session. home
			 
			rd.forward(request, response);
			//request.getRequestDispatcher("/google.jsp").forward(request, response);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
