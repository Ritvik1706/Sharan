
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rajan_gp8cx31
 */
public class LEAVEDATA extends javax.swing.JInternalFrame {

    /**
     * Creates new form LEAVEDATA
     */String bedno="";
     String roomno="";
    public LEAVEDATA() {
        initComponents();
        showData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        leaveField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("STUID");

        jLabel2.setText("DATE OF LEAVING *dd/mm/yyyy");

        jButton1.setText("CLEAR ROOM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leaveField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(leaveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        empty();
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    void showData() {
        Vector heading = new Vector();
        heading.add("Leaveid");
        heading.add("Roomno");
        heading.add("Bedno");
        heading.add("DateOfLeave");

        try {
            //Establish Connection
            //1. Initalize driver
            Class.forName("oracle.jdbc.OracleDriver");
            //2. Create connection String
            String str = "jdbc:oracle:thin:@localhost:1522:";
            //3. Open connection
            Connection con = DriverManager.getConnection(str, "Sharan", "pg");
            String sql = "select * from leave";
            PreparedStatement ps = con.prepareStatement(sql);
            Vector data = new Vector();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("leaveid"));
                row.add(rs.getString("roomno"));
                row.add(rs.getString("bedno"));
                row.add(rs.getString("dateofleave"));

                data.add(row);

            }

            DefaultTableModel tm = new DefaultTableModel(data, heading);
            jTable1.setModel(tm);
         con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void empty() {
        String id = idField.getText();
        String date = leaveField.getText();
        boolean ok = isValidDate.validdate(date);
        if (ok == false) {
            JOptionPane.showMessageDialog(this, "Leave Date Is Incorrect");
        }
        String status = "Free";
        try {
            //Establish Connection
            //1. Initalize driver
            Class.forName("oracle.jdbc.OracleDriver");
            //2. Create connection String
            String str = "jdbc:oracle:thin:@localhost:1522:";
            //3. Open connection
            Connection con = DriverManager.getConnection(str, "Sharan", "pg");

            String sql = "update studentdata1 set status=?,dateofleaving=? where studentid=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setString(2, date);
            ps.setString(3, id);

            int count = ps.executeUpdate();
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + "Room Cleared !!!");
                return;
            }
         con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void add() {
        try {
            String id=idField.getText();
            String date=leaveField.getText();
            //Establish Connection
            //1. Initalize driver
            Class.forName("oracle.jdbc.OracleDriver");
            //2. Create connection String
            String str = "jdbc:oracle:thin:@localhost:1522:";
            //3. Open connection
            Connection con = DriverManager.getConnection(str, "Sharan", "pg");
            String sql = "select bedno,roomno from studentdata1 where studentid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
              bedno=rs.getString("bedno");
              roomno=rs.getString("roomno");
              System.out.println(bedno);
              System.out.println(roomno);
                String sq2 = "insert into leave values(?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sq2);
            ps1.setString(1, "0");
            ps1.setString(2, roomno);
            ps1.setString(3, bedno);
            ps1.setString(4, date);
            
            int count = ps1.executeUpdate();
                System.out.println("count");

            showData();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Sorry no such Data Exist");
            }
           
        
          con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField leaveField;
    // End of variables declaration//GEN-END:variables
}