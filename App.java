import java.sql.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
public class App extends Application
{
    TextField tf;
    Label response;
    Label label;
    public static void main(String[]args)throws Exception
    {
        launch(args);
                                     
    }
    public void start(Stage obj)throws Exception
    {
          obj.setTitle("Welcome To Banking Management");
          GridPane pane=new GridPane();
          pane.setMinSize(500,500);
          Scene mys=new Scene(pane);
          pane.setVgap(5);
          pane.setHgap(5);
          obj.setScene(mys);
          pane.setAlignment(Pos.CENTER);
          label=new Label("Enter you Credentials");
          TextField txt=new TextField();
          txt.setPromptText("Enter the UserName");
          txt.setPrefColumnCount(25);
          PasswordField txt1=new PasswordField();
          txt1.setPromptText("Enter the Password");
          txt1.setPrefColumnCount(25);
          Button btn=new Button("Log in");
          btn.setOnAction(new EventHandler<ActionEvent>()
          {
            public void handle(ActionEvent ea)
            {
               if(txt.getText().equals("teamproject") && txt1.getText().equals("TEAM"))
               {
                  GridPane pane2=new GridPane();
                  pane2.setMinSize(500,500);
                  pane2.setVgap(5);
                  pane2.setHgap(5);
                  Scene mysc=new Scene(pane2);
                  obj.setScene(mysc);
                  pane2.setAlignment(Pos.CENTER);
                  response=new Label("Menu!!Choose among one");
                  ToggleGroup tg= new ToggleGroup();
                  RadioButton btn1=new RadioButton("Create Account");
                  RadioButton btn2=new RadioButton("Deposit Money");
                  RadioButton btn3=new RadioButton("Withdraw Money");
                  RadioButton btn4=new RadioButton("Account Details");
                  RadioButton btn5=new RadioButton("Update Account");
                  btn1.setToggleGroup(tg);
                  btn2.setToggleGroup(tg);
                  btn3.setToggleGroup(tg);
                  btn4.setToggleGroup(tg);
                  btn5.setToggleGroup(tg);
                  btn1.setOnAction(new EventHandler<ActionEvent>()
                  {
                     public void handle(ActionEvent ae)
                     {
                        if(btn1.isSelected())
                        {
                             
                             GridPane pane1=new GridPane();
                             pane1.setMinSize(500,500);
                             Scene sc=new Scene(pane1);
                             obj.setScene(sc);
                             pane1.setAlignment(Pos.CENTER);
                             tf=new TextField();
                             tf.setPromptText("Enter your name");
                             tf.setPrefColumnCount(25);
                             TextField tf1=new TextField();
                             tf1.setPromptText("Enter your Account ID");
                             tf1.setPrefColumnCount(25);
                             TextField tf2=new TextField();
                             tf2.setPromptText("Age");
                             tf2.setPrefColumnCount(25);
                             TextField tf3=new TextField();
                             tf3.setPromptText("Country");
                             tf3.setPrefColumnCount(25);
                             TextField tf4=new TextField();
                             tf4.setPromptText("Enter you Phone number with Country code");
                             tf4.setPrefColumnCount(15);
                             TextField tf5=new TextField();
                             tf5.setPromptText("Enter the Opening Deposit money");
                             tf5.setPrefColumnCount(15);
                             Separator separator = new Separator();
                             separator.setPrefWidth(180);
                             Button bt=new Button("Submit");
                             Button btn1=new Button("Back");
                             pane1.setPadding(new Insets(10,10,10,10));
                             bt.setOnAction(new EventHandler<ActionEvent>()
                             {
                                public void handle(ActionEvent ae)
                                {
                                 if(tf.getText().equals("")||tf1.getText().equals("")||tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals(""))
                                 {
                                       GridPane dpane1=new GridPane();
                                       dpane1.setMinSize(500,500);
                                       dpane1.setVgap(5);
                                       dpane1.setHgap(5);
                                       dpane1.setAlignment(Pos.CENTER);
                                       Scene scn1=new Scene(dpane1);
                                       obj.setScene(scn1);
                                       Label labe1=new Label("Sorry!!! Process cannot be processed further");
                                       Label labe12=new Label("       due to inadequecy of data     ");
                                       Button bck1=new Button("Go Back");
                                       bck1.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er1)
                                          {
                                             obj.setScene(sc);
                                             obj.show();
                                          }
                                       });
                                       dpane1.add(labe1,0,0);
                                       dpane1.add(labe12,0,1);
                                       dpane1.add(bck1,1,2);
                                       obj.show();

                                 }
                                 else
                                 {
                                 GridPane gdpane=new GridPane();
                                 gdpane.setMinSize(500,500);
                                 Scene mysc=new Scene(gdpane);
                                 obj.setScene(mysc);
                                 gdpane.setAlignment(Pos.CENTER);
                                 Label lx1=new Label("You have successfully created your account");
                                 Button prs1=new Button("Press Here");
                                 String st=tf.getText();
                                 String st1=tf1.getText();
                                 String st2=tf2.getText();
                                 String st3=tf3.getText();
                                 String st4=tf4.getText();
                                 int st5=Integer.parseInt(tf5.getText());
                                 try{
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                 }catch(ClassNotFoundException ne)
                                 {
                                    System.out.println("Connection Failed");
                                 }
                                 try{
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                    Statement stmt=con.createStatement();
                                    String query="INSERT INTO banking values('"+st+"','"+st1+"','"+st2+"','"+st3+"','"+st4+"',"+st5+")";
                                    stmt.executeUpdate(query);
                                 }catch(SQLException qx)
                                 {
                                    qx.printStackTrace();
                                 }
                                 prs1.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent ct)
                                    {
                                       
                                      
                                       obj.setScene(sc);
                                       obj.show();
                                    }
                                 });
                                 gdpane.add(lx1,0,0);
                                 gdpane.add(prs1,0,1);
                                 obj.show();
                                
                              }
                             }
                             });
                             btn1.setOnAction(new EventHandler<ActionEvent>()
                             {
                              public void handle(ActionEvent in)
                              {
                                 obj.setScene(mysc); 
                                 obj.show();
                              }
                             });
                             pane1.setVgap(5);
                             pane1.setHgap(5);
                             pane1.add(tf,0,0);
                             pane1.add(tf1,0,1);
                             pane1.add(tf2,0,2);
                             pane1.add(tf3,0,3);
                             pane1.add(tf4,0,4);
                             pane1.add(tf5,0,5);
                             pane1.add(bt,0,6);
                             pane1.add(btn1,0,7);
                             obj.show();
        
                        }
                     }
                  });
                  btn2.setOnAction(new EventHandler<ActionEvent>()
                  {
                     public void handle(ActionEvent ae)
                     {
                        if(btn2.isSelected())
                        {
                           GridPane grid=new GridPane();
                           grid.setMinSize(500,500);
                           Scene setsc=new Scene(grid);
                           obj.setScene(setsc);
                           grid.setVgap(5);
                           grid.setHgap(5);
                           grid.setAlignment(Pos.CENTER);
                           TextField tx1=new TextField();
                           tx1.setPromptText("Enter the Depositable Amount");
                           tx1.setPrefColumnCount(25);
                           TextField tx2=new TextField();
                           tx2.setPromptText("Enter your Account ID");
                           tx2.setPrefColumnCount(25);
                           Button but=new Button("Submit");
                           Button butn1=new Button("Back");
                           but.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent bt)
                              {
                                  if(tx1.getText().equals("")||tx2.getText().equals(""))
                                 {
                                      GridPane dpane2=new GridPane();
                                      dpane2.setMinSize(500,500);
                                      dpane2.setVgap(5);
                                      dpane2.setHgap(5);
                                      dpane2.setAlignment(Pos.CENTER);
                                      Scene scn2=new Scene(dpane2);
                                      obj.setScene(scn2);
                                      Label labe2=new Label("Process stalled!!!!!!!!!!!!");
                                      Label labe21= new Label("      Incorrect Input     ");
                                      Button bck2=new Button("Go Bak");
                                      bck2.setOnAction(new EventHandler<ActionEvent>()
                                      {
                                       public void handle(ActionEvent er2)
                                       {
                                          obj.setScene(setsc);
                                          obj.show();
                                       }
                                      });
                                      dpane2.add(labe2,0,0);
                                      dpane2.add(labe21,0,1);
                                      dpane2.add(bck2,0,2);
                                      obj.show();
                                 }
                                 else if(tx2.getText().length()>8)
                                       {
                                          GridPane dpane41=new GridPane();
                                          dpane41.setMinSize(500,500);
                                          dpane41.setAlignment(Pos.CENTER);
                                          dpane41.setVgap(5);
                                          dpane41.setHgap(5);
                                          Scene scn41=new Scene(dpane41);
                                          obj.setScene(scn41);
                                          Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                          Button bck41=new Button("Go Back");
                                          bck41.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er41)
                                             {
                                                obj.setScene(setsc);
                                                obj.show();
                                             }
                                          }) ;
                                          dpane41.add(labea4,0,0);
                                          dpane41.add(bck41,0,1);
                                          obj.show();

                                       }
                                 else
                                 {
                                 String AccId1=tx2.getText();
                                 int depo=Integer.parseInt(tx1.getText());
                                 GridPane gdpane1=new GridPane();
                                 gdpane1.setMinSize(500,500);
                                 Scene mysc1=new Scene(gdpane1);
                                 obj.setScene(mysc1);
                                 gdpane1.setAlignment(Pos.CENTER);
                                 Label dep=new Label("You have deposited"+" "+tx1.getText()+" "+"Successfully");
                                 Button prs2=new Button("Press Here");
                                 prs2.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent rs)
                                    {
                                       obj.setScene(setsc);
                                       obj.show();
                                    }
                                 });
                                 try
                                 {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                 }catch(ClassNotFoundException io)
                                 {
                                    System.out.println("Connection Failed");
                                 }
                                 try
                                 {
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");;
                                    Statement stm=con.createStatement();
                                    Statement stm1=con.createStatement();
                                    ResultSet res=stm.executeQuery("SELECT Balance FROM banking  where AccId='"+AccId1+"'");
                                      
                                     while(res.next())
                                     {
                                          int famount=res.getInt("Balance")+depo;
                                          String query="UPDATE banking SET Balance="+famount+" WHERE AccId='"+AccId1+"'";
                                          stm1.executeUpdate(query);
                                       
                                     }
                                     
                                    
                                 }catch(SQLException on)
                                 {
                                    on.printStackTrace();
                                 }
                                 gdpane1.add(dep,0,0);
                                 gdpane1.add(prs2,0,1);
                                 obj.show();
                              }
                            
                           }
                           });
                           butn1.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent ent)
                              {
                                  obj.setScene(mysc);
                                  obj.show();
                              }
                           });
                           grid.add(tx2,0,0);
                           grid.add(tx1,0,1);
                           grid.add(but,0,2);
                           grid.add(butn1,0,3);
                           obj.show();
                        }
                     }
                  });
                  btn3.setOnAction(new EventHandler<ActionEvent>()
                  {
                     public void handle(ActionEvent ae)
                     {
                        if(btn3.isSelected())
                        {
                             GridPane grid2=new GridPane();
                             grid2.setMinSize(500,500);
                             Scene mys2=new Scene(grid2);
                             obj.setScene(mys2);
                             grid2.setAlignment(Pos.CENTER);
                             TextField tft1=new TextField();
                             tft1.setPromptText("Enter Your Account ID");
                             tft1.setPrefColumnCount(25);
                             TextField tft2=new TextField();
                             tft2.setPromptText("Amount Money To Withdraw");
                             tft2.setPrefColumnCount(25);
                             grid2.setVgap(5);
                             grid2.setHgap(5);
                             Button sub=new Button("Submit");
                             Button butn2=new Button("Back");
                             sub.setOnAction(new EventHandler<ActionEvent>()
                             {
                              public void handle(ActionEvent vh1)
                              {
                                    if(tft1.getText().equals("")||tft2.getText().equals(""))
                                    {
                                       GridPane dpane3=new GridPane();
                                       dpane3.setMinSize(500,500);
                                       dpane3.setVgap(5);
                                       dpane3.setHgap(5);
                                       dpane3.setAlignment(Pos.CENTER);
                                       Scene scn3=new Scene(dpane3);
                                       obj.setScene(scn3);
                                       Label labe3=new  Label(" Withdrawal stalled !!!!!!!!!");
                                       Label labe31=new Label("     Inadequate data        ");
                                       Button bck3=new Button("Go Back");
                                       bck3.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er3)
                                          {
                                             obj.setScene(mys2);
                                             obj.show();
                                          }
                                       });
                                       dpane3.add(labe3,0,0);
                                       dpane3.add(labe31,0,1);
                                       dpane3.add(bck3,0,2);
                                       obj.show();
                                    }
                                    else if(tft1.getText().length()>8)
                                       {
                                          GridPane dpane41=new GridPane();
                                          dpane41.setMinSize(500,500);
                                          dpane41.setAlignment(Pos.CENTER);
                                          dpane41.setVgap(5);
                                          dpane41.setHgap(5);
                                          Scene scn41=new Scene(dpane41);
                                          obj.setScene(scn41);
                                          Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                          Button bck41=new Button("Go Back");
                                          bck41.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er41)
                                             {
                                                obj.setScene(mys2);
                                                obj.show();
                                             }
                                          }) ;
                                          dpane41.add(labea4,0,0);
                                          dpane41.add(bck41,0,1);
                                          obj.show();

                                       }
                                    else
                                    {
                                    String AccId12=tft1.getText();
                                    int depo1=Integer.parseInt(tft2.getText());
                                    GridPane gdpane212=new GridPane();
                                    gdpane212.setMinSize(500,500);
                                    Scene mysc12=new Scene(gdpane212);
                                    obj.setScene(mysc12);
                                    gdpane212.setVgap(5);
                                    gdpane212.setHgap(5);
                                    gdpane212.setAlignment(Pos.CENTER);
                                    Label dep1=new Label("You have withdrawn"+" "+tft2.getText()+" "+"Successfully");
                                    Button prs3=new Button("Press Here");
                                    prs3.setOnAction(new EventHandler<ActionEvent>()
                                    {
                                       public void handle(ActionEvent rs2)
                                       {
                                          obj.setScene(mys2);
                                       }
                                    });
                                    try
                                    {
                                       Class.forName("com.mysql.cj.jdbc.Driver");
                                    }catch(ClassNotFoundException ion)
                                    {
                                       System.out.println("Connection Failed");
                                    }
                                    try
                                    {
                                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                       Statement stm1=con.createStatement();
                                       Statement stm12=con.createStatement();
                                       ResultSet res1=stm1.executeQuery("SELECT Balance FROM banking  where AccId='"+AccId12+"'");
                                       gdpane212.add(dep1,0,0);
                                       gdpane212.add(prs3,0,1);
                                       obj.show();
                                        while(res1.next())
                                        {
                                             int famount1=res1.getInt("Balance")-depo1;
                                             String query="UPDATE banking SET Balance="+famount1+" WHERE AccId='"+AccId12+"'";
                                             stm12.executeUpdate(query);
                                             
                                          
                                        }
                                        
                                       
                                    }catch(SQLException on)
                                    {
                                       on.printStackTrace();
                                    }
                        
                                 
                              }
                             }
                             });
                             butn2.setOnAction(new EventHandler<ActionEvent>()
                             {
                              public void handle(ActionEvent act)
                              {
                                 obj.setScene(mysc);
                                 obj.show();
                              }
                             });
                             grid2.add(tft1,0,0);
                             grid2.add(tft2,0,1);
                             grid2.add(sub,0,2);
                             grid2.add(butn2,0,3);
                             obj.show();
                        }
                     }
                  });
                  btn4.setOnAction(new EventHandler<ActionEvent>()
                  {
                     public void handle(ActionEvent ae)
                     {
                        if(btn4.isSelected())
                        {
                             GridPane grid3=new GridPane();
                             grid3.setMinSize(500,500);
                             Scene sc3=new Scene(grid3);
                             obj.setScene(sc3);
                             grid3.setAlignment(Pos.CENTER);
                             grid3.setVgap(5);
                             grid3.setHgap(5);
                             Label lab=new Label("Enter Account ID");
                             TextField tx11=new TextField();
                             tx11.setPromptText("Enter your Account ID");
                             tx11.setPrefColumnCount(25);
                             Button but1=new Button("Submit");
                             Button butn3=new Button("Back");
                             but1.setOnAction(new EventHandler<ActionEvent>()
                             {
                              public void handle(ActionEvent ac)
                              {
                                 if(tx11.getText().equals(""))
                                 {
                                    GridPane dpane4=new GridPane();
                                    dpane4.setMinSize(500,500);
                                    dpane4.setVgap(5);
                                    dpane4.setHgap(5);
                                    dpane4.setAlignment(Pos.CENTER);
                                    Scene scn4=new Scene(dpane4);
                                    obj.setScene(scn4);
                                    Label labe4=new Label("Details fetching stalled!!!!!!!!!!");
                                    Label labe41=new Label("       Inadequate data       ");
                                    Button bck4=new Button("Go Back");
                                    bck4.setOnAction(new EventHandler<ActionEvent>(){
                                       public void handle(ActionEvent er4)
                                       {
                                          obj.setScene(sc3);
                                          obj.show();
                                       }
                                    });
                                    dpane4.add(labe4,0,0);
                                    dpane4.add(labe41,0,1);
                                    dpane4.add(bck4,0,2);
                                    obj.show();
                                 }
                                 else if(tx11.getText().length()>8)
                                 {
                                    GridPane dpane41=new GridPane();
                                    dpane41.setMinSize(500,500);
                                    dpane41.setAlignment(Pos.CENTER);
                                    dpane41.setVgap(5);
                                    dpane41.setHgap(5);
                                    Scene scn41=new Scene(dpane41);
                                    obj.setScene(scn41);
                                    Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                    Button bck41=new Button("Go Back");
                                    bck41.setOnAction(new EventHandler<ActionEvent>(){
                                       public void handle(ActionEvent er41)
                                       {
                                          obj.setScene(sc3);
                                          obj.show();
                                       }
                                    }) ;
                                    dpane41.add(labea4,0,0);
                                    dpane41.add(bck41,0,1);
                                    obj.show();

                                 }
                                 else
                                 {
                                 GridPane gdpane3=new GridPane();
                                 gdpane3.setMinSize(500,500);
                                 Scene mys4=new Scene(gdpane3);
                                 obj.setScene(mys4);
                                 gdpane3.setVgap(5);
                                 gdpane3.setHgap(5);
                                 gdpane3.setAlignment(Pos.CENTER);
                                 try
                                 {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                 }catch(ClassNotFoundException pt)
                                 {

                                 }
                                 try
                                 {
                                    Connection con2=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                    Statement stm2=con2.createStatement();
                                    ResultSet res2=stm2.executeQuery("Select * FROM banking WHERE AccId='"+tx11.getText()+"'");
                                    while(res2.next())
                                    {
                                       String name=res2.getString("Name");
                                       String accid=res2.getString("AccId");
                                       String age=res2.getString("Age");
                                       String country=res2.getString("Country");
                                       String phone=res2.getString("PhoneNo");
                                       String bal=res2.getString("Balance");
                                       Label le1=new Label("Name:"+" "+name);
                                       Label le2=new Label("AccountId:"+" "+accid);
                                       Label le3=new Label("Age:"+" "+age);
                                       Label le4=new Label("Country:"+" "+country);
                                       Label le5=new Label("Phone Number:"+" "+phone);
                                       Label le6=new Label("Account Balance:"+" "+bal);
                                       Button prs4=new Button("Press Here");
                                       prs4.setOnAction(new EventHandler<ActionEvent>()
                                       {
                                          public void handle(ActionEvent rs3)
                                          {
                                             obj.setScene(sc3);
                                             obj.show();
                                          }
                                       });
                                       gdpane3.add(le1,0,0);
                                       gdpane3.add(le2,0,1);
                                       gdpane3.add(le3,0,2);
                                       gdpane3.add(le4,0,3);
                                       gdpane3.add(le5,0,4);
                                       gdpane3.add(le6,0,5);
                                       gdpane3.add(prs4,0,6);
                                       obj.show();
                                    }
                                 }catch(SQLException le)
                                 {

                                 }
                              }
                            }
                             });
                             butn3.setOnAction(new EventHandler<ActionEvent>()
                             {
                              public void handle(ActionEvent one)
                              {
                                 obj.setScene(mysc);
                                 obj.show();
                              }
                             });
                             grid3.add(lab,0,0);
                             grid3.add(tx11,1,0);
                             grid3.add(but1,1,1);
                             grid3.add(butn3,1,2);
                             obj.show();
                        }
                     }
                  });
                  btn5.setOnAction(new EventHandler<ActionEvent>()
                  {
                     public void handle(ActionEvent up)
                     {
                           GridPane grid4=new GridPane();
                           grid4.setMinSize(500,500);
                           Scene mys3=new Scene(grid4);
                           grid4.setVgap(5);
                           grid4.setHgap(5);
                           obj.setScene(mys3);
                           grid4.setAlignment(Pos.CENTER);
                           ToggleGroup tg= new ToggleGroup();
                           Label com=new Label("Enter Which data you want to update");
                           RadioButton btn1=new RadioButton("Name");
                           RadioButton btn2=new RadioButton("Age");
                           RadioButton btn3=new RadioButton("Phone Number");
                           Button butn4=new Button("Back");
                           btn1.setToggleGroup(tg);
                           btn2.setToggleGroup(tg);
                           btn3.setToggleGroup(tg);
                           btn1.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent ev)
                              {
                                 GridPane grid41=new GridPane();
                                 grid41.setMinSize(500,500);
                                 Scene mys41=new Scene(grid41);
                                 obj.setScene(mys41);
                                 grid41.setVgap(5);
                                 grid41.setHgap(5);
                                 grid41.setAlignment(Pos.CENTER);
                                 Label lab41b=new Label("Enter The Account Id");
                                 TextField tx41b=new TextField();
                                 tx41b.setPromptText("Enter your Account Id");
                                 tx41b.setPrefColumnCount(25);
                                 Label lab41a=new Label("Enter The Previous name");
                                 TextField tx41a=new TextField();
                                 tx41a.setPromptText("Enter your Previous name");
                                 tx41a.setPrefColumnCount(25);
                                 Label lab41=new Label("Enter The updated name");
                                 TextField tx41=new TextField();
                                 tx41.setPromptText("Enter your updated name");
                                 tx41.setPrefColumnCount(25);
                                 Button but41=new Button("Submit");
                                 Button butn42=new Button("Back");
                                 but41.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent ti)
                                    {
                                       if(tx41.getText().equals("")||tx41a.getText().equals("")||tx41b.getText().equals(""))
                                       {
                                          GridPane dpane5a=new GridPane();
                                          dpane5a.setMinSize(500,500);
                                          dpane5a.setVgap(5);
                                          dpane5a.setHgap(5);
                                          dpane5a.setAlignment(Pos.CENTER);
                                          Scene scn5a=new Scene(dpane5a);
                                          obj.setScene(scn5a);
                                          Label labe5a=new Label("Inadequte data !!!!!!");
                                          Button bck5a=new Button("Go Back");
                                          bck5a.setOnAction(new EventHandler<ActionEvent>(){
                                             public void handle(ActionEvent er5a)
                                             {
                                                obj.setScene(mys41);
                                                obj.show();
                                             }
                                          });
                                          dpane5a.add(labe5a,0,0);
                                          dpane5a.add(bck5a,0,1);
                                          obj.show();
                                       }
                                       else if(tx41b.getText().length()>8)
                                       {
                                          GridPane dpane41=new GridPane();
                                          dpane41.setMinSize(500,500);
                                          dpane41.setAlignment(Pos.CENTER);
                                          dpane41.setVgap(5);
                                          dpane41.setHgap(5);
                                          Scene scn41=new Scene(dpane41);
                                          obj.setScene(scn41);
                                          Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                          Button bck41=new Button("Go Back");
                                          bck41.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er41)
                                             {
                                                obj.setScene(mys41);
                                                obj.show();
                                             }
                                          }) ;
                                          dpane41.add(labea4,0,0);
                                          dpane41.add(bck41,0,1);
                                          obj.show();

                                       }
                                       else
                                       {
                                       GridPane gdpane4=new GridPane();
                                       gdpane4.setMinSize(500,500);
                                       Scene mys5=new Scene(gdpane4);
                                       gdpane4.setVgap(5);
                                       gdpane4.setHgap(5);
                                       obj.setScene(mys5);
                                       gdpane4.setAlignment(Pos.CENTER);
                                       try
                                       {
                                          Class.forName("com.mysql.cj.jdbc.Driver");
                                       }catch(ClassNotFoundException tf)
                                       {

                                       }
                                       try
                                       {
                                          Connection con4=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                          Statement stm4=con4.createStatement();
                                          String qur="UPDATE banking SET Name='"+tx41.getText()+"'WHERE Name='"+tx41a.getText()+"'AND AccId='"+tx41b.getText()+"'";
                                          stm4.executeUpdate(qur);
                                          Label leb1=new Label("Name updated from"+" "+tx41a.getText()+" "+"to"+" "+tx41.getText()+" "+"Successfully");
                                          Button prs4=new Button("Press Here");
                                          prs4.setOnAction(new EventHandler<ActionEvent>()
                                          {
                                             public void handle(ActionEvent rs4)
                                             {
                                                obj.setScene(mys41);
                                                obj.show();
                                             }
                                          });
                                          gdpane4.add(leb1,0,0);
                                          gdpane4.add(prs4,0,1);
                                          obj.show();
                                       }catch(SQLException ep)
                                       {
                                          ep.printStackTrace();
                                       }
                                       
                                    }
                                  }
                                 });
                                 butn42.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent sc)
                                    {
                                       obj.setScene(mys3);
                                       obj.show();
                                    }
                                 });
                                 grid41.add(lab41b,0,0);
                                 grid41.add(tx41b,1,0);
                                 grid41.add(lab41a,0,1);
                                 grid41.add(tx41a,1,1);
                                 grid41.add(lab41,0,2);
                                 grid41.add(tx41,1,2);
                                 grid41.add(but41,1,3);
                                 grid41.add(butn42,1,4);
                              }

                           });
                           btn2.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent it)
                              {
                                  if(btn2.isSelected())
                                  {
                                    GridPane grid51=new GridPane();
                                    grid51.setMinSize(500,500);
                                    Scene mys51=new Scene(grid51);
                                    obj.setScene(mys51);
                                    grid51.setVgap(5);
                                    grid51.setHgap(5);
                                    grid51.setAlignment(Pos.CENTER);
                                    Label lab51b=new Label("Enter The Account Id");
                                    TextField tx51b=new TextField();
                                    tx51b.setPromptText("Enter your Account Id");
                                    tx51b.setPrefColumnCount(25);
                                    Label lab51a=new Label("Enter The previous age");
                                    TextField tx51a=new TextField();
                                    tx51a.setPromptText("Enter your previous age");
                                    tx51a.setPrefColumnCount(25);
                                    Label lab51=new Label("Enter The updated age");
                                    TextField tx51=new TextField();
                                    tx51.setPromptText("Enter your updated age");
                                    tx51.setPrefColumnCount(25);
                                    Button but51=new Button("Submit");
                                    Button butn52=new Button("Back");
                                    but51.setOnAction(new EventHandler<ActionEvent>()
                                    {
                                       public void handle(ActionEvent ev)
                                       {
                                          if(tx51.getText().equals("")||tx51a.getText().equals("")||tx51b.getText().equals(""))
                                       {
                                          GridPane dpane5a=new GridPane();
                                          dpane5a.setMinSize(500,500);
                                          dpane5a.setVgap(5);
                                          dpane5a.setHgap(5);
                                          dpane5a.setAlignment(Pos.CENTER);
                                          Scene scn5a=new Scene(dpane5a);
                                          obj.setScene(scn5a);
                                          Label labe5a=new Label("Inadequte data !!!!!!");
                                          Button bck5a=new Button("Go Back");
                                          bck5a.setOnAction(new EventHandler<ActionEvent>(){
                                             public void handle(ActionEvent er5a)
                                             {
                                                obj.setScene(mys51);
                                                obj.show();
                                             }
                                          });
                                          dpane5a.add(labe5a,0,0);
                                          dpane5a.add(bck5a,0,1);
                                          obj.show();
                                       }
                                       else if(tx51b.getText().length()>8)
                                       {
                                          GridPane dpane41=new GridPane();
                                          dpane41.setMinSize(500,500);
                                          dpane41.setAlignment(Pos.CENTER);
                                          dpane41.setVgap(5);
                                          dpane41.setHgap(5);
                                          Scene scn41=new Scene(dpane41);
                                          obj.setScene(scn41);
                                          Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                          Button bck41=new Button("Go Back");
                                          bck41.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er41)
                                             {
                                                obj.setScene(mys51);
                                                obj.show();
                                             }
                                          }) ;
                                          dpane41.add(labea4,0,0);
                                          dpane41.add(bck41,0,1);
                                          obj.show();

                                       }
                                          else
                                          {
                                          GridPane gdpane5=new GridPane();
                                          gdpane5.setMinSize(500,500);
                                          Scene mys6=new Scene(gdpane5);
                                          obj.setScene(mys6);
                                          gdpane5.setVgap(5);
                                          gdpane5.setHgap(5);
                                          gdpane5.setAlignment(Pos.CENTER);
                                          try
                                          {
                                             Class.forName("com.mysql.cj.jdbc.Driver");
                                          }catch(ClassNotFoundException tf)
                                          {
   
                                          }
                                          try
                                          {
                                             Connection con5=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                             Statement stm4=con5.createStatement();
                                             String qur="UPDATE banking SET Age='"+tx51.getText()+"'WHERE Age='"+tx51a.getText()+"'AND AccId='"+tx51b.getText()+"'";
                                             stm4.executeUpdate(qur);
                                             Label leb1=new Label("Age updated from"+" "+tx51a.getText()+" "+"to"+" "+tx51.getText()+" "+"Successfully.");
                                             Button prs5=new Button("Press Here");
                                             prs5.setOnAction(new EventHandler<ActionEvent>()
                                             {
                                                public void handle(ActionEvent rs6)
                                                {
                                                   obj.setScene(mys51);
                                                   obj.show();
                                                }
                                             });
                                             gdpane5.add(leb1,0,0);
                                             gdpane5.add(prs5,0,1);
                                             obj.show();
                                          }catch(SQLException ep)
                                          {

                                          }
                                             

                                       }
                                     }
                                    });
                                    butn52.setOnAction(new EventHandler<ActionEvent>()
                                    {
                                       public void handle(ActionEvent onv)
                                       {
                                          obj.setScene(mys3);
                                          obj.show();
                                       }
                                    });
                                    grid51.add(lab51b,0,0);
                                    grid51.add(tx51b,1,0);
                                    grid51.add(lab51a,0,1);
                                    grid51.add(tx51a,1,1);
                                    grid51.add(lab51,0,2);
                                    grid51.add(tx51,1,2);
                                    grid51.add(but51,1,3);
                                    grid51.add(butn52,1,4);
                                  }
                              }
                           });
                           btn3.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent on)
                              {
                                 
                                 {
                                 GridPane grid61=new GridPane();
                                 grid61.setMinSize(500,500);
                                 Scene mys61=new Scene(grid61);
                                 obj.setScene(mys61);
                                 grid61.setVgap(5);
                                 grid61.setHgap(5);
                                 grid61.setAlignment(Pos.CENTER);
                                 Label lab61b=new Label("Enter The Account Id:");
                                 TextField tx61b=new TextField();
                                 tx61b.setPromptText("Enter your Account Id.");
                                 tx61b.setPrefColumnCount(25);
                                 Label lab61a=new Label("Enter The previous phone no:");
                                 TextField tx61a=new TextField();
                                 tx61a.setPromptText("Enter your previous phone no.");
                                 tx61a.setPrefColumnCount(25);
                                 Label lab61=new Label("Enter The updated phone no:");
                                 TextField tx61=new TextField();
                                 tx61.setPromptText("Enter your updated phone no.");
                                 tx61.setPrefColumnCount(25);
                                 Button but61=new Button("Submit");
                                 Button butn62=new Button("Back");
                                 but61.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent ev)
                                    {
                                       if(tx61.getText().equals("")||tx61a.getText().equals("")||tx61b.getText().equals(""))
                                       {
                                          GridPane dpane5a=new GridPane();
                                          dpane5a.setMinSize(500,500);
                                          dpane5a.setVgap(5);
                                          dpane5a.setHgap(5);
                                          dpane5a.setAlignment(Pos.CENTER);
                                          Scene scn5a=new Scene(dpane5a);
                                          obj.setScene(scn5a);
                                          Label labe5a=new Label("Inadequte data !!!!!!");
                                          Button bck5a=new Button("Go Back");
                                          bck5a.setOnAction(new EventHandler<ActionEvent>(){
                                             public void handle(ActionEvent er5a)
                                             {
                                                obj.setScene(mys61);
                                                obj.show();
                                             }
                                          });
                                          dpane5a.add(labe5a,0,0);
                                          dpane5a.add(bck5a,0,1);
                                          obj.show();
                                       }
                                       else if(tx61b.getText().length()>8)
                                       {
                                          GridPane dpane41=new GridPane();
                                          dpane41.setMinSize(500,500);
                                          dpane41.setAlignment(Pos.CENTER);
                                          dpane41.setVgap(5);
                                          dpane41.setHgap(5);
                                          Scene scn41=new Scene(dpane41);
                                          obj.setScene(scn41);
                                          Label labea4=new Label("Invalid Account Id  !!!!!!!");
                                          Button bck41=new Button("Go Back");
                                          bck41.setOnAction(new EventHandler<ActionEvent>(){
                                          public void handle(ActionEvent er41)
                                             {
                                                obj.setScene(mys61);
                                                obj.show();
                                             }
                                          }) ;
                                          dpane41.add(labea4,0,0);
                                          dpane41.add(bck41,0,1);
                                          obj.show();

                                       }
                                       else
                                       {
                                       GridPane gdpane6=new GridPane();
                                       gdpane6.setMinSize(500,500);
                                       Scene mys7=new Scene(gdpane6);
                                       obj.setScene(mys7);
                                       gdpane6.setVgap(5);
                                       gdpane6.setHgap(5);
                                       gdpane6.setAlignment(Pos.CENTER);
                                       try
                                       {
                                          Class.forName("com.mysql.cj.jdbc.Driver");
                                       }catch(ClassNotFoundException tf)
                                       {

                                       }
                                       try
                                       {
                                          Connection con5=DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
                                          Statement stm4=con5.createStatement();
                                          String qur="UPDATE banking SET PhoneNo='"+tx61.getText()+"'WHERE PhoneNo='"+tx61a.getText()+"'AND AccId='"+tx61b.getText()+"'";
                                          stm4.executeUpdate(qur);
                                          Label leb1=new Label("Age updated from"+" "+tx61a.getText()+" "+"to"+" "+tx61.getText()+" "+"Successfully.");
                                          Button prs6=new Button("Press Here");
                                          prs6.setOnAction(new EventHandler<ActionEvent>()
                                          {
                                             public void handle(ActionEvent rs7)
                                             {
                                                obj.setScene(mys61);
                                                obj.show();
                                             }
                                          });
                                          gdpane6.add(leb1,0,0);
                                          gdpane6.add(prs6,0,1);
                                          obj.show();
                                       }catch(SQLException ep)
                                       {

                                       }
                                    }
                                   }
                                 });
                                 butn62.setOnAction(new EventHandler<ActionEvent>()
                                 {
                                    public void handle(ActionEvent tio)
                                    {
                                       obj.setScene(mys3);
                                       obj.show();
                                    }
                                 });
                                 grid61.add(lab61b,0,0);
                                 grid61.add(tx61b,1,0);
                                 grid61.add(lab61a,0,1);
                                 grid61.add(tx61a,1,1);
                                 grid61.add(lab61,0,2);
                                 grid61.add(tx61,1,2);
                                 grid61.add(but61,1,3);
                                 grid61.add(butn62,1,4); 
                                 obj.show();
                              }
                           }
                           });
                           butn4.setOnAction(new EventHandler<ActionEvent>()
                           {
                              public void handle(ActionEvent ont)
                              {
                                 obj.setScene(mysc);
                                 obj.show();
                              }
                           });
                           grid4.add(com,0,0);
                           grid4.add(btn1,0,1);
                           grid4.add(btn2,0,2);
                           grid4.add(btn3,0,3);
                           grid4.add(butn4,0,4);
                           obj.show();

                     }
                  });
                  pane2.add(response,0,0);
                  pane2.add(btn1,0,1);
                  pane2.add(btn2,0,2);
                  pane2.add(btn3,0,3);
                  pane2.add(btn4,0,4);
                  pane2.add(btn5,0,5);
                  obj.show();
                }
                else
                {
                  label.setText("Opps!!!Sorry Invalid  credentials");
                }
              }
            });   
         pane.add(label,0,0);
         pane.add(txt,0,1);
         pane.add(txt1,0,2);
         pane.add(btn,0,3);
         obj.show();
   }
}