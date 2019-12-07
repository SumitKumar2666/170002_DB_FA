// @ Author Sumit Kumar 170002
package screening;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Userinterface {

	/**********************************************************************************************
	 * 
	 * Attributes
	 * 
	 **********************************************************************************************/

	/*
	 * Constants used to parameterize the graphical user interface. We do not use a
	 * layout manager for this application. Rather we manually control the location
	 * of each graphical element for exact control of the look and feel.
	 */
	private final double BUTTON_WIDTH = 60;
	private final double BUTTON_OFFSET = BUTTON_WIDTH / 2;

	// These are the application values required by the user interface
	

	

	
	

 Button submit = new Button("submit");
 
 TextField reg_no = new TextField("enter the registration_number");
 TextField roll_no = new TextField("enter the roll_number");
    TextField name = new TextField("enter the Name");
	TextField father_name = new TextField("enter the father name");
	TextField mother_name = new TextField("enter the mother name");
	TextField course = new TextField("enter the course name");
	TextField semester = new TextField("enter the semester");
	TextField year = new TextField("enter the year");
	Label Student_Enrollment = new Label("Student Enrollment");
	
	
	String s;
	String y;
	Connection con;

	private double buttonSpace;

	public Userinterface(Pane theRoot, Stage Stage) {

		// There are five gaps. Compute the button space accordingly.
		buttonSpace = mainline.WINDOW_WIDTH / 5;

		// Label theScene with the name of the mainline, centered at the top of the pane
		setupLabelUI(Student_Enrollment, "Arial", 24, mainline.WINDOW_WIDTH, Pos.CENTER, 0, 10);
		
		name.setLayoutX(100);
		name.setLayoutY(140);
		
		reg_no.setLayoutX(100);
		reg_no.setLayoutY(80);
		roll_no.setLayoutX(100);
		roll_no.setLayoutY(110);
		
		father_name.setLayoutX(100);
		father_name.setLayoutY(170);
		
		mother_name.setLayoutX(100);
		mother_name.setLayoutY(200);
		
		course.setLayoutX(100);
		course.setLayoutY(230);
		
		semester.setLayoutX(100);
		semester.setLayoutY(260);
		
		year.setLayoutX(100);
		year.setLayoutY(290);
		
		
		submit.setLayoutX(100);
		submit.setLayoutY(320);

		submit.setOnAction((event)->{
		try {
			submit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		});
		theRoot.getChildren().addAll(Student_Enrollment, name, father_name, mother_name, course, semester, year, submit,reg_no,roll_no);

	}

	private void submit() throws ClassNotFoundException, SQLException {
		
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost/db?autoReconnect=true&useSSL=false", "root", "anshul@1");
				con.setAutoCommit(false);
				PreparedStatement pstm = null;
				

					

					String sql = "INSERT INTO student VALUES('" + reg_no.getText() + "',+'"+ roll_no.getText() +"','"+  name.getText() + "','" + father_name.getText() + "','" + mother_name.getText() + "','"
							+ course.getText() + "','" + semester.getText() + "','" + year.getText() + "')";
					pstm = (PreparedStatement) con.prepareStatement(sql);
					pstm.execute();
					
				con.commit();
				
				con.close();

				System.out.println("Success import excel to mysql table");
			

		
			

			
		
	}

	private void setupTextUI(TextField t, String ff, double f, double w, Pos p, double x, double y, boolean e) {
		t.setFont(Font.font(ff, f));
		t.setMinWidth(w);
		t.setMaxWidth(w);
		t.setAlignment(p);
		t.setLayoutX(x);
		t.setLayoutY(y);
		t.setEditable(e);
	}

	private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y) {
		l.setFont(Font.font(ff, f));
		l.setMinWidth(w);
		l.setAlignment(p);
		l.setLayoutX(x);
		l.setLayoutY(y);
	}

	private void setupButtonUI(Button b, String ff, double f, double w, Pos p, double x, double y) {
		b.setFont(Font.font(ff, f));
		b.setMinWidth(w);
		b.setAlignment(p);
		b.setLayoutX(x);
		b.setLayoutY(y);
	}

	/**********************************************************************************************
	 * 
	 * User Interface Actions
	 * 
	 **********************************************************************************************/

	

}