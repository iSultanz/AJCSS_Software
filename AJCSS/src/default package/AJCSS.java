import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AJCSS extends javax.swing.JFrame {

    public AJCSS() {
        setTitle("AJCSS");
        // To set the general application icon.
        setIconImage(Toolkit.getDefaultToolkit().
                getImage(LoginPage.class.getResource("/images/AJCSSIcon.png")));
        initComponents();
        dataNavigation();
    }

    public static void getLookupData(String s, ArrayList<Lookup> list) {
        String filePath = "C:/AJCSS/" + s;
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            br.close();
            for (int i = 0; i < tableLines.length; i++) {
                Lookup lookupData = new Lookup();
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
                lookupData.setDesc(dataRow[1]);
                lookupData.setCode(Integer.parseInt(dataRow[0]));
                list.add(i, lookupData);
            }

        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getCandidateData() {
        String filePath = "C:/AJCSS/candidates.txt";
        File file = new File(filePath);

        try {
            /** get the first line 
             * get the columns name from the first line
             * set columns name to the jtable model
            **/
            BufferedReader br = new BufferedReader(new FileReader(file));


            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            br.close();

            // extratct data from lines
            // set data to jtable model
            if(candidatesData.isEmpty())
                for (int i = 0; i < tableLines.length; i++) {
                    Candidate can = new Candidate();
                    String line = tableLines[i].toString().trim();
                    String[] dataRow = line.split(",");
                    can.setCanid(Integer.parseInt(dataRow[0]));
                    can.setCanname((dataRow[1]));
                    can.setCanbirth((dataRow[2]));
                    can.setCaneducation(Integer.parseInt(dataRow[3]));
                    can.setCanmajor(Integer.parseInt(dataRow[4]));
                    can.setCangrade((dataRow[5]));
                    can.setCangpa(Double.parseDouble(dataRow[6]));
                    can.setCompany((dataRow[7]));
                    can.setPosition((dataRow[8]));
                    can.setCanyearsexp(Integer.parseInt(dataRow[9]));
                    can.setCaninterviewscore(Integer.parseInt(dataRow[10]));
                    can.setCanemail((dataRow[11]));
                    can.setCanphone((dataRow[12]));
                    can.setCanSalary(Integer.parseInt(dataRow[13]));
                    can.setCangender(Integer.parseInt(dataRow[14]));
                    can.setCanreallocation(Boolean.parseBoolean(dataRow[15]));
                    can.setCandriving(Boolean.parseBoolean(dataRow[16]));
                    can.setCantravel(Boolean.parseBoolean(dataRow[17]));
                    can.setCanaddress((dataRow[18]));
                    can.setCancity((dataRow[19]));
                    can.setCancountry((dataRow[20]));
                    can.setCanskills1cat(Integer.parseInt(dataRow[21]));
                    can.setCanskills1(Integer.parseInt(dataRow[22]));
                    can.setCanskills1value(Integer.parseInt(dataRow[23]));
                    can.setCanskills2cat(Integer.parseInt(dataRow[24]));
                    can.setCanskills2(Integer.parseInt(dataRow[25]));
                    can.setCanskills2value(Integer.parseInt(dataRow[26]));
                    can.setCanskills3cat(Integer.parseInt(dataRow[27]));
                    can.setCanskills3(Integer.parseInt(dataRow[28]));
                    can.setCanskills3value(Integer.parseInt(dataRow[29]));
                    can.setCanskills4cat(Integer.parseInt(dataRow[30]));
                    can.setCanskills4(Integer.parseInt(dataRow[31]));
                    can.setCanskills4value(Integer.parseInt(dataRow[32]));
                    can.setCanskills5cat(Integer.parseInt(dataRow[33]));
                    can.setCanskills5(Integer.parseInt(dataRow[34]));
                    can.setCanskills5value(Integer.parseInt(dataRow[35]));
                    can.setCancomptency1cat(Integer.parseInt(dataRow[36]));
                    can.setCancomptency1(Integer.parseInt(dataRow[37]));
                    can.setCancomptency1value(Integer.parseInt(dataRow[38]));
                    can.setCancomptency2cat(Integer.parseInt(dataRow[39]));
                    can.setCancomptency2(Integer.parseInt(dataRow[40]));
                    can.setCancomptency2value(Integer.parseInt(dataRow[41]));
                    can.setCancomptency3cat(Integer.parseInt(dataRow[42]));
                    can.setCancomptency3(Integer.parseInt(dataRow[43]));
                    can.setCancomptency3value(Integer.parseInt(dataRow[44]));
                    can.setCancomptency4cat(Integer.parseInt(dataRow[45]));
                    can.setCancomptency4(Integer.parseInt(dataRow[46]));
                    can.setCancomptency4value(Integer.parseInt(dataRow[47]));
                    can.setCancomptency5cat(Integer.parseInt(dataRow[48]));
                    can.setCancomptency5(Integer.parseInt(dataRow[49]));
                    can.setCancomptency5value(Integer.parseInt(dataRow[50]));
                    can.setCanjobID(Integer.parseInt(dataRow[51]));
                    can.setCanprocessed(Integer.parseInt(dataRow[52]));
                    candidatesData.add(i, can);
                }
        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getJobsData() {
        String filePath = "C:/AJCSS/Jobs.txt";
        File file = new File(filePath);

        try {
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            BufferedReader br = new BufferedReader(new FileReader(file));

            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            br.close();

            // extratct data from lines
            // set data to jtable model
            if(jobsData.isEmpty())
                for (int i = 0; i < tableLines.length; i++) {
                    Jobs job = new Jobs();
                    String line = tableLines[i].toString().trim();
                    String[] dataRow = line.split(",");
                    job.setJobID(Integer.parseInt(dataRow[0]));
                    job.setJobCat(Integer.parseInt(dataRow[1]));
                    job.setJobSubCat(Integer.parseInt(dataRow[2]));
                    job.setJobGroup(Integer.parseInt(dataRow[3]));
                    job.setJobTitle(dataRow[4]);
                    job.setStatus(Integer.parseInt(dataRow[5]));
                    job.setEducation(Integer.parseInt(dataRow[6]));
                    job.setMinSalary(Integer.parseInt(dataRow[7]));
                    job.setMaxSalary(Integer.parseInt(dataRow[8]));
                    job.setReallocation(Boolean.parseBoolean(dataRow[9]));
                    job.setDriving(Boolean.parseBoolean(dataRow[10]));
                    job.setExpYears(Integer.parseInt(dataRow[11]));
                    job.setTravel(Boolean.parseBoolean(dataRow[12]));
                    job.setInterview(Integer.parseInt(dataRow[13]));
                    job.setGender(Integer.parseInt(dataRow[14]));
                    job.setMajor1(Integer.parseInt(dataRow[15]));
                    job.setMajor2(Integer.parseInt(dataRow[16]));
                    job.setMajor3(Integer.parseInt(dataRow[17]));
                    job.setMajor4(Integer.parseInt(dataRow[18]));
                    job.setMajor5(Integer.parseInt(dataRow[19]));
                    job.setSkillCat1(Integer.parseInt(dataRow[20]));
                    job.setSkillCat2(Integer.parseInt(dataRow[21]));
                    job.setSkillCat3(Integer.parseInt(dataRow[22]));
                    job.setSkillCat4(Integer.parseInt(dataRow[23]));
                    job.setSkillCat5(Integer.parseInt(dataRow[24]));
                    job.setSkill1(Integer.parseInt(dataRow[25]));
                    job.setSkill2(Integer.parseInt(dataRow[26]));
                    job.setSkill3(Integer.parseInt(dataRow[27]));
                    job.setSkill4(Integer.parseInt(dataRow[28]));
                    job.setSkill5(Integer.parseInt(dataRow[29]));
                    job.setSkillValue1(Integer.parseInt(dataRow[30]));
                    job.setSkillValue2(Integer.parseInt(dataRow[31]));
                    job.setSkillValue3(Integer.parseInt(dataRow[32]));
                    job.setSkillValue4(Integer.parseInt(dataRow[33]));
                    job.setSkillValue5(Integer.parseInt(dataRow[34]));
                    job.setCompCat1(Integer.parseInt(dataRow[35]));
                    job.setCompCat2(Integer.parseInt(dataRow[36]));
                    job.setCompCat3(Integer.parseInt(dataRow[37]));
                    job.setCompCat4(Integer.parseInt(dataRow[38]));
                    job.setCompCat5(Integer.parseInt(dataRow[39]));
                    job.setComp1(Integer.parseInt(dataRow[40]));
                    job.setComp2(Integer.parseInt(dataRow[41]));
                    job.setComp3(Integer.parseInt(dataRow[42]));
                    job.setComp4(Integer.parseInt(dataRow[43]));
                    job.setComp5(Integer.parseInt(dataRow[44]));
                    job.setCompValue1(Integer.parseInt(dataRow[45]));
                    job.setCompValue2(Integer.parseInt(dataRow[46]));
                    job.setCompValue3(Integer.parseInt(dataRow[47]));
                    job.setCompValue4(Integer.parseInt(dataRow[48]));
                    job.setCompValue5(Integer.parseInt(dataRow[49]));
                    jobsData.add(i, job);
                }
        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getInstData() {
        String filePath = "C:/AJCSS/inst.csv";
        File file = new File(filePath);
        try {
            // get the first line
            // get the columns name from the first line
            // set columns name to the jtable model
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(columnsName);

            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            br.close();

            // extratct data from lines
            // set data to jtable model
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }

        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getEducationData() {
        String filePath = "C:/AJCSS/education.csv";
        File file = new File(filePath);

        try {
            // get the first line
            // get the columns name from the first line
            BufferedReader br = new BufferedReader(new FileReader(file));

            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            br.close();

            // extratct data from lines
            // set data to jtable model
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(":");
            }
        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getJTableData(ArrayList<Lookup> list) {
        String[] columnsName = {"code", "Description"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(columnsName);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).getDesc();
            int n = list.get(i).getCode();
            Object[] dataRow = {n, s};
            model.addRow(dataRow);
        }
    }
                         
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        buttonGroupGender1 = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldJobID1 = new javax.swing.JTextField();
        jTextFieldJobTitle1 = new javax.swing.JTextField();
        jTextFieldMinSalary1 = new javax.swing.JTextField();
        jTextFieldMaxSalary1 = new javax.swing.JTextField();
        jTextFieldYearsOfExp1 = new javax.swing.JTextField();
        jComboBoxJobCat1 = new javax.swing.JComboBox<>();
        jComboBoxJobSubCat1 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboSkills6 = new javax.swing.JComboBox<>();
        jComboSkills7 = new javax.swing.JComboBox<>();
        jComboSkills8 = new javax.swing.JComboBox<>();
        jComboSkills9 = new javax.swing.JComboBox<>();
        jComboSkills10 = new javax.swing.JComboBox<>();
        jComboSkillsCat6 = new javax.swing.JComboBox<>();
        jComboBoxMajor6 = new javax.swing.JComboBox<>();
        jComboSkillsCat7 = new javax.swing.JComboBox<>();
        jComboSkillsCat8 = new javax.swing.JComboBox<>();
        jComboSkillsCat9 = new javax.swing.JComboBox<>();
        jComboSkillsCat10 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jComboBoxMajor7 = new javax.swing.JComboBox<>();
        jComboBoxMajor8 = new javax.swing.JComboBox<>();
        jComboBoxMajor9 = new javax.swing.JComboBox<>();
        jComboBoxMajor10 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jCheckBoxReallocation1 = new javax.swing.JCheckBox();
        jCheckBoxTravel1 = new javax.swing.JCheckBox();
        jCheckBoxDriving1 = new javax.swing.JCheckBox();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jComboBoxCompCat6 = new javax.swing.JComboBox<>();
        jComboBoxCompCat7 = new javax.swing.JComboBox<>();
        jComboBoxCompCat8 = new javax.swing.JComboBox<>();
        jComboBoxCompCat9 = new javax.swing.JComboBox<>();
        jComboBoxCompCat10 = new javax.swing.JComboBox<>();
        jComboBoxComp6 = new javax.swing.JComboBox<>();
        jComboBoxComp7 = new javax.swing.JComboBox<>();
        jComboBoxComp8 = new javax.swing.JComboBox<>();
        jComboBoxComp9 = new javax.swing.JComboBox<>();
        jComboBoxComp10 = new javax.swing.JComboBox<>();
        jButtonSave = new javax.swing.JButton();
        jSpinnerinterview1 = new javax.swing.JSpinner();
        jSpinnerSkillValue6 = new javax.swing.JSpinner();
        jSpinnerSkillValue7 = new javax.swing.JSpinner();
        jSpinnerSkillValue8 = new javax.swing.JSpinner();
        jSpinnerSkillValue9 = new javax.swing.JSpinner();
        jSpinnerSkillValue10 = new javax.swing.JSpinner();
        jSpinnerCompValue6 = new javax.swing.JSpinner();
        jSpinnerCompValue7 = new javax.swing.JSpinner();
        jSpinnerCompValue8 = new javax.swing.JSpinner();
        jSpinnerCompValue9 = new javax.swing.JSpinner();
        jSpinnerCompValue10 = new javax.swing.JSpinner();
        jComboBoxJobEducation1 = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldJobID = new javax.swing.JTextField();
        jTextFieldJobTitle = new javax.swing.JTextField();
        jTextFieldMinSalary = new javax.swing.JTextField();
        jTextFieldMaxSalary = new javax.swing.JTextField();
        jComboBoxJobCat = new javax.swing.JComboBox<>();
        jComboBoxJobSubCat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboSkills1 = new javax.swing.JComboBox<>();
        jComboSkills2 = new javax.swing.JComboBox<>();
        jComboSkills3 = new javax.swing.JComboBox<>();
        jComboSkills4 = new javax.swing.JComboBox<>();
        jComboSkills5 = new javax.swing.JComboBox<>();
        jComboSkillsCat1 = new javax.swing.JComboBox<>();
        jComboSkillsCat2 = new javax.swing.JComboBox<>();
        jComboSkillsCat3 = new javax.swing.JComboBox<>();
        jComboSkillsCat4 = new javax.swing.JComboBox<>();
        jComboBoxMajor5 = new javax.swing.JComboBox<>();
        jComboSkillsCat5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxMajor1 = new javax.swing.JComboBox<>();
        jComboBoxMajor2 = new javax.swing.JComboBox<>();
        jComboBoxMajor4 = new javax.swing.JComboBox<>();
        jComboBoxMajor3 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButtonPrev = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jCheckBoxReallocation = new javax.swing.JCheckBox();
        jCheckBoxTravel = new javax.swing.JCheckBox();
        jCheckBoxDriving = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxCompCat1 = new javax.swing.JComboBox<>();
        jComboBoxCompCat2 = new javax.swing.JComboBox<>();
        jComboBoxCompCat3 = new javax.swing.JComboBox<>();
        jComboBoxCompCat4 = new javax.swing.JComboBox<>();
        jComboBoxCompCat5 = new javax.swing.JComboBox<>();
        jComboBoxComp1 = new javax.swing.JComboBox<>();
        jComboBoxComp2 = new javax.swing.JComboBox<>();
        jComboBoxComp3 = new javax.swing.JComboBox<>();
        jComboBoxComp4 = new javax.swing.JComboBox<>();
        jComboBoxComp5 = new javax.swing.JComboBox<>();
        jSpinnerexp = new javax.swing.JSpinner();
        jSpinnercomp5 = new javax.swing.JSpinner();
        jSpinnerskill1 = new javax.swing.JSpinner();
        jSpinnerskill2 = new javax.swing.JSpinner();
        jSpinnerskill3 = new javax.swing.JSpinner();
        jSpinnerskill4 = new javax.swing.JSpinner();
        jSpinnerskill5 = new javax.swing.JSpinner();
        jSpinnercomp1 = new javax.swing.JSpinner();
        jSpinnercomp2 = new javax.swing.JSpinner();
        jSpinnercomp3 = new javax.swing.JSpinner();
        jSpinnercomp4 = new javax.swing.JSpinner();
        jSpinnerinterview = new javax.swing.JSpinner();
        update = new javax.swing.JButton();
        jComboBoxEducation = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jTextFieldCandidateID1 = new javax.swing.JTextField();
        jTextFieldCanName1 = new javax.swing.JTextField();
        jTextFieldCanBirthDate1 = new javax.swing.JTextField();
        jComboBoxCanEducation1 = new javax.swing.JComboBox<>();
        jComboBoxCanMajor1 = new javax.swing.JComboBox<>();
        jTextFieldCanGPA1 = new javax.swing.JTextField();
        jTextFieldCanCompany1 = new javax.swing.JTextField();
        jTextFieldCanPosition1 = new javax.swing.JTextField();
        jTextFieldCanSalary1 = new javax.swing.JTextField();
        jTextFieldCanExpYears1 = new javax.swing.JTextField();
        jTextFieldCanAddress1 = new javax.swing.JTextField();
        jTextFieldCanCity1 = new javax.swing.JTextField();
        jTextFieldCanCountry1 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jSpinnerCanCompValue6 = new javax.swing.JSpinner();
        jSpinnerCanCompValue7 = new javax.swing.JSpinner();
        jSpinnerCanCompValue8 = new javax.swing.JSpinner();
        jSpinnerCanCompValue9 = new javax.swing.JSpinner();
        jSpinnerCanCompValue10 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue6 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue7 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue8 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue9 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue10 = new javax.swing.JSpinner();
        jComboBoxCanCompCat6 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat7 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat8 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat9 = new javax.swing.JComboBox<>();
        jComboBoxCanComp6 = new javax.swing.JComboBox<>();
        jComboBoxCanComp7 = new javax.swing.JComboBox<>();
        jComboBoxCanComp8 = new javax.swing.JComboBox<>();
        jComboBoxCanComp9 = new javax.swing.JComboBox<>();
        jComboBoxCanComp10 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat10 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill6 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat6 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill7 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat7 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill8 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat8 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill9 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat9 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill10 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat10 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jCheckBoxCanTravell1 = new javax.swing.JCheckBox();
        jCheckBoxCanDriving1 = new javax.swing.JCheckBox();
        jCheckBoxCanReallocation1 = new javax.swing.JCheckBox();
        jSpinnerCanInterviewScore1 = new javax.swing.JSpinner();
        jComboBoxCanGrade1 = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jTextFieldCanEmail1 = new javax.swing.JTextField();
        jTextFieldCanPhone1 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jButtonCanAdd = new javax.swing.JButton();
        jRadioButtonNewMale = new javax.swing.JRadioButton();
        jRadioButtonNewFemale = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jTextFieldCandidateID = new javax.swing.JTextField();
        jTextFieldCanName = new javax.swing.JTextField();
        jTextFieldCanBirthDate = new javax.swing.JTextField();
        jComboBoxCanEducation = new javax.swing.JComboBox<>();
        jComboBoxCanMajor = new javax.swing.JComboBox<>();
        jTextFieldCanGPA = new javax.swing.JTextField();
        jTextFieldCanCompany = new javax.swing.JTextField();
        jTextFieldCanPosition = new javax.swing.JTextField();
        jTextFieldCanSalary = new javax.swing.JTextField();
        jTextFieldCanExpYears = new javax.swing.JTextField();
        jTextFieldCanAddress = new javax.swing.JTextField();
        jTextFieldCanCity = new javax.swing.JTextField();
        jTextFieldCanCountry = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextFieldCanPhone = new javax.swing.JTextField();
        jTextFieldCanEmail = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jComboBoxCanGrade = new javax.swing.JComboBox<>();
        jSpinnerCanInterviewScore = new javax.swing.JSpinner();
        jCheckBoxCanReallocation = new javax.swing.JCheckBox();
        jCheckBoxCanDriving = new javax.swing.JCheckBox();
        jCheckBoxCanTravel = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jComboBoxCanSkillCat1 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill1 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat2 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill2 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat3 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill3 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat4 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill4 = new javax.swing.JComboBox<>();
        jComboBoxCanSkillCat5 = new javax.swing.JComboBox<>();
        jComboBoxCanSkill5 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat1 = new javax.swing.JComboBox<>();
        jComboBoxCanComp1 = new javax.swing.JComboBox<>();
        jComboBoxCanComp2 = new javax.swing.JComboBox<>();
        jComboBoxCanComp3 = new javax.swing.JComboBox<>();
        jComboBoxCanComp4 = new javax.swing.JComboBox<>();
        jComboBoxCanComp5 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat5 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat4 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat3 = new javax.swing.JComboBox<>();
        jComboBoxCanCompCat2 = new javax.swing.JComboBox<>();
        jSpinnerCanSkillValue1 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue2 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue3 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue4 = new javax.swing.JSpinner();
        jSpinnerCanSkillValue5 = new javax.swing.JSpinner();
        jSpinnerCanCompValue1 = new javax.swing.JSpinner();
        jSpinnerCanCompValue2 = new javax.swing.JSpinner();
        jSpinnerCanCompValue3 = new javax.swing.JSpinner();
        jSpinnerCanCompValue4 = new javax.swing.JSpinner();
        jSpinnerCanCompValue5 = new javax.swing.JSpinner();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButtonPrevCan = new javax.swing.JButton();
        jButtonNextCan = new javax.swing.JButton();
        jButtonCanUpdate = new javax.swing.JButton();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldDesc = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jButtonSaveExit = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonMatch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMathedPersons = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableJobs = new javax.swing.JTable();
        jSlider1 = new javax.swing.JSlider();
        jLabelSlider = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldMatchSkill1 = new javax.swing.JTextField();
        jTextFieldMatchSkill2 = new javax.swing.JTextField();
        jTextFieldMatchSkill3 = new javax.swing.JTextField();
        jTextFieldMatchSkill4 = new javax.swing.JTextField();
        jTextFieldMatchSkill5 = new javax.swing.JTextField();
        jTextFieldMatchSkillValue1 = new javax.swing.JTextField();
        jTextFieldMatchSkillValue2 = new javax.swing.JTextField();
        jTextFieldMatchSkillValue3 = new javax.swing.JTextField();
        jTextFieldMatchSkillValue4 = new javax.swing.JTextField();
        jTextFieldMatchSkillValue5 = new javax.swing.JTextField();
        jTextFieldMatchComp1 = new javax.swing.JTextField();
        jTextFieldMatchComp2 = new javax.swing.JTextField();
        jTextFieldMatchComp3 = new javax.swing.JTextField();
        jTextFieldMatchComp4 = new javax.swing.JTextField();
        jTextFieldMatchComp5 = new javax.swing.JTextField();
        jTextFieldMatchCompValue5 = new javax.swing.JTextField();
        jTextFieldMatchCompValue4 = new javax.swing.JTextField();
        jTextFieldMatchCompValue3 = new javax.swing.JTextField();
        jTextFieldMatchCompValue2 = new javax.swing.JTextField();
        jTextFieldMatchCompValue1 = new javax.swing.JTextField();
        jTextFieldTotMatchCompValues = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextFieldTotMatchSkillValues = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        jTextFieldTotCanSkillValues = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jTextFieldTotCanCompValues = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMathedPersonSkills = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableMathedPersonComp = new javax.swing.JTable();
        jLabel103 = new javax.swing.JLabel();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int safe = JOptionPane.showConfirmDialog
                (null, "Do you want to save changes?!",  "Exit & Save?", 
                JOptionPane.YES_NO_CANCEL_OPTION);
                
                setDefaultCloseOperation(safeExit(safe));
            }

            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }            
        });	

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); 
        jTabbedPane1.setName("exit"); 

        jPanel1.setLayout(null);

        jPanel6.setLayout(null);

        jTextFieldJobID1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextFieldJobID1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldJobID1.setEnabled(false);
        jPanel6.add(jTextFieldJobID1);
        jTextFieldJobID1.setBounds(200, 10, 80, 25);

        jTextFieldJobTitle1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldJobTitle1KeyPressed(evt);
            }
        });
        jPanel6.add(jTextFieldJobTitle1);
        jTextFieldJobTitle1.setBounds(200, 170, 230, 24);
        jPanel6.add(jTextFieldMinSalary1);
        jTextFieldMinSalary1.setBounds(200, 260, 140, 24);
        jPanel6.add(jTextFieldMaxSalary1);
        jTextFieldMaxSalary1.setBounds(200, 300, 140, 24);
        jPanel6.add(jTextFieldYearsOfExp1);
        jTextFieldYearsOfExp1.setBounds(200, 340, 140, 24);

        jComboBoxJobCat1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxJobCat1ItemStateChanged(evt);
            }
        });
        jComboBoxJobCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJobCat1ActionPerformed(evt);
            }
        });
        jPanel6.add(jComboBoxJobCat1);
        jComboBoxJobCat1.setBounds(200, 50, 230, 26);

        jPanel6.add(jComboBoxJobSubCat1);
        jComboBoxJobSubCat1.setBounds(200, 90, 230, 26);

        jLabel30.setText("Job ID");
        jPanel6.add(jLabel30);
        jLabel30.setBounds(70, 10, 60, 30);

        jLabel31.setText("Job category ");
        jPanel6.add(jLabel31);
        jLabel31.setBounds(70, 53, 100, 16);

        jLabel32.setText("Subcategory ");
        jPanel6.add(jLabel32);
        jLabel32.setBounds(70, 90, 80, 20);

        jLabel34.setText("Job title ");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(70, 170, 48, 20);

        jLabel35.setText("Interview score");
        jPanel6.add(jLabel35);
        jLabel35.setBounds(70, 210, 88, 30);

        jLabel36.setText("Min salary");
        jPanel6.add(jLabel36);
        jLabel36.setBounds(70, 260, 68, 20);

        jLabel37.setText("Max salary");
        jPanel6.add(jLabel37);
        jLabel37.setBounds(70, 303, 68, 16);

        jLabel38.setText("Years of experience");
        jPanel6.add(jLabel38);
        jLabel38.setBounds(70, 340, 120, 20);

        jLabel39.setText("Reallocation ");
        jPanel6.add(jLabel39);
        jLabel39.setBounds(260, 642, 80, 20);

        jLabel40.setText("Travelling");
        jPanel6.add(jLabel40);
        jLabel40.setBounds(860, 641, 60, 20);

        jLabel41.setText("Driving license");
        jPanel6.add(jLabel41);
        jLabel41.setBounds(530, 641, 90, 20);

        jPanel6.add(jComboSkills6);
        jComboSkills6.setBounds(730, 130, 138, 26);

        jPanel6.add(jComboSkills7);
        jComboSkills7.setBounds(730, 170, 138, 26);

        jPanel6.add(jComboSkills8);
        jComboSkills8.setBounds(730, 210, 138, 26);

        jPanel6.add(jComboSkills9);
        jComboSkills9.setBounds(730, 250, 138, 26);

        jPanel6.add(jComboSkills10);
        jComboSkills10.setBounds(730, 290, 138, 26);

        jComboSkillsCat6.setName("jComboSkillsCat1");
        jPanel6.add(jComboSkillsCat6);
        jComboSkillsCat6.setBounds(550, 130, 138, 26);

        jPanel6.add(jComboBoxMajor6);
        jComboBoxMajor6.setBounds(200, 430, 230, 26);

        jPanel6.add(jComboSkillsCat7);
        jComboSkillsCat7.setBounds(550, 170, 138, 26);

        jPanel6.add(jComboSkillsCat8);
        jComboSkillsCat8.setBounds(550, 210, 138, 26);

        jPanel6.add(jComboSkillsCat9);
        jComboSkillsCat9.setBounds(550, 250, 138, 26);

        jPanel6.add(jComboSkillsCat10);
        jComboSkillsCat10.setBounds(550, 290, 138, 26);

        jLabel42.setText("Skill ");
        jPanel6.add(jLabel42);
        jLabel42.setBounds(780, 100, 50, 16);

        jLabel43.setText("Skills category ");
        jPanel6.add(jLabel43);
        jLabel43.setBounds(570, 100, 100, 16);

        jLabel44.setText("Minimum requiered value  ");
        jPanel6.add(jLabel44);
        jLabel44.setBounds(940, 400, 165, 16);

        jLabel45.setText("Major 1");
        jPanel6.add(jLabel45);
        jLabel45.setBounds(70, 430, 42, 20);

        jLabel46.setText("Major 2");
        jPanel6.add(jLabel46);
        jLabel46.setBounds(70, 470, 42, 20);

        jLabel47.setText("Major 3");
        jPanel6.add(jLabel47);
        jLabel47.setBounds(70, 510, 42, 20);

        jLabel48.setText("Major 5");
        jPanel6.add(jLabel48);
        jLabel48.setBounds(70, 590, 42, 20);

        jLabel49.setText("Major 4");
        jPanel6.add(jLabel49);
        jLabel49.setBounds(70, 540, 42, 40);

        jPanel6.add(jComboBoxMajor7);
        jComboBoxMajor7.setBounds(200, 470, 230, 26);

        jPanel6.add(jComboBoxMajor8);
        jComboBoxMajor8.setBounds(200, 510, 230, 26);

        jPanel6.add(jComboBoxMajor9);
        jComboBoxMajor9.setBounds(200, 550, 230, 26);

        jPanel6.add(jComboBoxMajor10);
        jComboBoxMajor10.setBounds(200, 590, 230, 26);

        jLabel50.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel50.setText("Requiered comptencies ");
        jPanel6.add(jLabel50);
        jLabel50.setBounds(720, 360, 194, 22);

        jLabel51.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel51.setText("Specializations");
        jPanel6.add(jLabel51);
        jLabel51.setBounds(180, 390, 133, 22);

        jLabel52.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel52.setText("Requiered skills ");
        jPanel6.add(jLabel52);
        jLabel52.setBounds(740, 70, 133, 22);

        jCheckBoxReallocation1.setText("Yes");
        jPanel6.add(jCheckBoxReallocation1);
        jCheckBoxReallocation1.setBounds(360, 640, 49, 24);

        jCheckBoxTravel1.setText("Yes");
        jPanel6.add(jCheckBoxTravel1);
        jCheckBoxTravel1.setBounds(940, 640, 49, 24);

        jCheckBoxDriving1.setText("Yes");
        jPanel6.add(jCheckBoxDriving1);
        jCheckBoxDriving1.setBounds(640, 640, 49, 24);

        jLabel53.setText("Competency category");
        jPanel6.add(jLabel53);
        jLabel53.setBounds(560, 400, 135, 16);

        jLabel54.setText("Competency ");
        jPanel6.add(jLabel54);
        jLabel54.setBounds(760, 400, 80, 16);

        jLabel55.setText("Minimum requiered value  ");
        jPanel6.add(jLabel55);
        jLabel55.setBounds(940, 100, 165, 16);

        jComboBoxCompCat6.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxCompCat6);
        jComboBoxCompCat6.setBounds(550, 430, 140, 26);

        jComboBoxCompCat7.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxCompCat7);
        jComboBoxCompCat7.setBounds(550, 470, 140, 26);

        jComboBoxCompCat8.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxCompCat8);
        jComboBoxCompCat8.setBounds(550, 510, 140, 26);

        jComboBoxCompCat9.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxCompCat9);
        jComboBoxCompCat9.setBounds(550, 550, 140, 26);

        jComboBoxCompCat10.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxCompCat10);
        jComboBoxCompCat10.setBounds(550, 590, 140, 26);

        jComboBoxComp6.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxComp6);
        jComboBoxComp6.setBounds(730, 430, 138, 26);

        jComboBoxComp7.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxComp7);
        jComboBoxComp7.setBounds(730, 470, 138, 26);

        jComboBoxComp8.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxComp8);
        jComboBoxComp8.setBounds(730, 510, 138, 26);

        jComboBoxComp9.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxComp9);
        jComboBoxComp9.setBounds(730, 550, 138, 26);

        jComboBoxComp10.setName("jComboSkillsCat1");
        jPanel6.add(jComboBoxComp10);
        jComboBoxComp10.setBounds(730, 590, 138, 26);

        jButtonSave.setText("Add");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsDataChanged++;
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonSave);
        jButtonSave.setBounds(490, 680, 160, 32);

        jSpinnerinterview1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerinterview1);
        jSpinnerinterview1.setBounds(200, 210, 70, 26);

        jSpinnerSkillValue6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerSkillValue6);
        jSpinnerSkillValue6.setBounds(970, 130, 70, 26);

        jSpinnerSkillValue7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerSkillValue7);
        jSpinnerSkillValue7.setBounds(970, 170, 70, 26);

        jSpinnerSkillValue8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerSkillValue8);
        jSpinnerSkillValue8.setBounds(970, 210, 70, 26);

        jSpinnerSkillValue9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerSkillValue9);
        jSpinnerSkillValue9.setBounds(970, 250, 70, 26);

        jSpinnerSkillValue10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerSkillValue10);
        jSpinnerSkillValue10.setBounds(970, 290, 70, 26);

        jSpinnerCompValue6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerCompValue6);
        jSpinnerCompValue6.setBounds(970, 430, 70, 26);

        jSpinnerCompValue7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerCompValue7);
        jSpinnerCompValue7.setBounds(970, 470, 70, 26);

        jSpinnerCompValue8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerCompValue8);
        jSpinnerCompValue8.setBounds(970, 510, 70, 26);

        jSpinnerCompValue9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerCompValue9);
        jSpinnerCompValue9.setBounds(970, 550, 70, 26);

        jSpinnerCompValue10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel6.add(jSpinnerCompValue10);
        jSpinnerCompValue10.setBounds(970, 590, 70, 26);

        jPanel6.add(jComboBoxJobEducation1);
        jComboBoxJobEducation1.setBounds(200, 130, 230, 26);

        jLabel108.setText("Education");
        jPanel6.add(jLabel108);
        jLabel108.setBounds(70, 130, 60, 20);

        jTabbedPane2.addTab("New Job", jPanel6);

        jPanel5.setLayout(null);

        jTextFieldJobID.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextFieldJobID.setForeground(new java.awt.Color(255, 0, 102));
        jTextFieldJobID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldJobID.setEnabled(false);
        jPanel5.add(jTextFieldJobID);
        jTextFieldJobID.setBounds(200, 10, 80, 25);
        jPanel5.add(jTextFieldJobTitle);
        jTextFieldJobTitle.setBounds(200, 170, 230, 24);
        jPanel5.add(jTextFieldMinSalary);
        jTextFieldMinSalary.setBounds(200, 260, 140, 24);
        jPanel5.add(jTextFieldMaxSalary);
        jTextFieldMaxSalary.setBounds(200, 300, 140, 24);

        jComboBoxJobCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJobCatActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBoxJobCat);
        jComboBoxJobCat.setBounds(200, 50, 230, 26);

        jPanel5.add(jComboBoxJobSubCat);
        jComboBoxJobSubCat.setBounds(200, 90, 230, 26);

        jLabel1.setText("Job ID");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(70, 16, 50, 20);

        jLabel2.setText("Job category ");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(70, 50, 90, 20);

        jLabel4.setText("Subcategory ");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(70, 90, 90, 20);

        jLabel6.setText("Job title ");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(70, 170, 60, 16);

        jLabel7.setText("Interview score");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(70, 206, 88, 30);

        jLabel10.setText("Min salary");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(70, 260, 68, 20);

        jLabel11.setText("Max salary");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(70, 300, 68, 16);

        jLabel12.setText("Years of experience");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(70, 330, 120, 40);

        jLabel13.setText("Reallocation ");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(260, 640, 80, 20);

        jLabel14.setText("Travelling");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(860, 640, 65, 20);

        jLabel15.setText("Driving license");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(530, 640, 90, 20);

        jPanel5.add(jComboSkills1);
        jComboSkills1.setBounds(730, 130, 138, 26);

        jPanel5.add(jComboSkills2);
        jComboSkills2.setBounds(730, 170, 138, 26);

        jPanel5.add(jComboSkills3);
        jComboSkills3.setBounds(730, 210, 138, 26);

        jPanel5.add(jComboSkills4);
        jComboSkills4.setBounds(730, 250, 138, 26);

        jPanel5.add(jComboSkills5);
        jComboSkills5.setBounds(730, 290, 138, 26);

        jComboSkillsCat1.setName("jComboSkillsCat1");
        jComboSkillsCat1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboSkillsCat1ItemStateChanged(evt);
            }
        });
        jComboSkillsCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSkillsCat1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboSkillsCat1);
        jComboSkillsCat1.setBounds(550, 130, 138, 26);

        jPanel5.add(jComboSkillsCat2);
        jComboSkillsCat2.setBounds(550, 170, 138, 26);

        jPanel5.add(jComboSkillsCat3);
        jComboSkillsCat3.setBounds(550, 210, 138, 26);

        jPanel5.add(jComboSkillsCat4);
        jComboSkillsCat4.setBounds(550, 250, 138, 26);

        jPanel5.add(jComboBoxMajor5);
        jComboBoxMajor5.setBounds(200, 590, 230, 26);

        jPanel5.add(jComboSkillsCat5);
        jComboSkillsCat5.setBounds(550, 290, 138, 26);

        jLabel8.setText("Skill ");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(780, 100, 40, 16);

        jLabel9.setText("Skills category ");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(570, 100, 100, 16);

        jLabel16.setText("Minimum requiered value  ");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(940, 400, 150, 16);

        jLabel17.setText("Major 1");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(70, 430, 42, 20);

        jLabel18.setText("Major 2");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(70, 470, 42, 20);

        jLabel19.setText("Major 3");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(70, 510, 42, 20);

        jLabel21.setText("Major 5");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(70, 590, 42, 20);

        jLabel22.setText("Major 4");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(70, 540, 42, 40);

        jPanel5.add(jComboBoxMajor1);
        jComboBoxMajor1.setBounds(200, 430, 230, 26);

        jPanel5.add(jComboBoxMajor2);
        jComboBoxMajor2.setBounds(200, 470, 230, 26);

        jPanel5.add(jComboBoxMajor4);
        jComboBoxMajor4.setBounds(200, 550, 230, 26);

        jPanel5.add(jComboBoxMajor3);
        jComboBoxMajor3.setBounds(200, 510, 230, 26);

        jLabel20.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel20.setText("Requiered comptencies ");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(720, 360, 194, 22);

        jLabel23.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel23.setText("Specializations");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(180, 390, 133, 22);

        jLabel24.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel24.setText("Requiered skills ");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(740, 70, 133, 22);

        jButtonPrev.setText("Previous");
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonPrev);
        jButtonPrev.setBounds(350, 680, 110, 32);

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonNext);
        jButtonNext.setBounds(470, 680, 110, 32);

        jCheckBoxReallocation.setText("Yes");
        jPanel5.add(jCheckBoxReallocation);
        jCheckBoxReallocation.setBounds(360, 640, 49, 24);

        jCheckBoxTravel.setText("Yes");
        jPanel5.add(jCheckBoxTravel);
        jCheckBoxTravel.setBounds(940, 640, 49, 24);

        jCheckBoxDriving.setText("Yes");
        jPanel5.add(jCheckBoxDriving);
        jCheckBoxDriving.setBounds(640, 640, 49, 24);

        jLabel27.setText("Competency category");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(560, 400, 135, 16);

        jLabel28.setText("Competency ");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(760, 400, 80, 16);

        jLabel29.setText("Minimum requiered value  ");
        jPanel5.add(jLabel29);
        jLabel29.setBounds(940, 100, 165, 16);

        jComboBoxCompCat1.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxCompCat1);
        jComboBoxCompCat1.setBounds(550, 430, 138, 26);

        jComboBoxCompCat2.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxCompCat2);
        jComboBoxCompCat2.setBounds(550, 470, 138, 26);

        jComboBoxCompCat3.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxCompCat3);
        jComboBoxCompCat3.setBounds(550, 510, 138, 26);

        jComboBoxCompCat4.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxCompCat4);
        jComboBoxCompCat4.setBounds(550, 550, 138, 26);

        jComboBoxCompCat5.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxCompCat5);
        jComboBoxCompCat5.setBounds(550, 590, 138, 26);

        jComboBoxComp1.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxComp1);
        jComboBoxComp1.setBounds(730, 430, 138, 26);

        jComboBoxComp2.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxComp2);
        jComboBoxComp2.setBounds(730, 470, 138, 26);

        jComboBoxComp3.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxComp3);
        jComboBoxComp3.setBounds(730, 510, 138, 26);

        jComboBoxComp4.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxComp4);
        jComboBoxComp4.setBounds(730, 550, 138, 26);

        jComboBoxComp5.setName("jComboSkillsCat1");
        jPanel5.add(jComboBoxComp5);
        jComboBoxComp5.setBounds(730, 590, 138, 26);
        jPanel5.add(jSpinnerexp);
        jSpinnerexp.setBounds(200, 340, 70, 26);

        jSpinnercomp5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnercomp5);
        jSpinnercomp5.setBounds(970, 590, 70, 26);

        jSpinnerskill1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnerskill1);
        jSpinnerskill1.setBounds(970, 130, 70, 26);

        jSpinnerskill2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnerskill2);
        jSpinnerskill2.setBounds(970, 170, 70, 26);

        jSpinnerskill3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnerskill3);
        jSpinnerskill3.setBounds(970, 210, 70, 26);

        jSpinnerskill4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnerskill4);
        jSpinnerskill4.setBounds(970, 250, 70, 26);

        jSpinnerskill5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnerskill5);
        jSpinnerskill5.setBounds(970, 290, 70, 26);

        jSpinnercomp1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnercomp1);
        jSpinnercomp1.setBounds(970, 430, 70, 26);

        jSpinnercomp2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnercomp2);
        jSpinnercomp2.setBounds(970, 470, 70, 26);

        jSpinnercomp3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnercomp3);
        jSpinnercomp3.setBounds(970, 510, 70, 26);

        jSpinnercomp4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel5.add(jSpinnercomp4);
        jSpinnercomp4.setBounds(970, 550, 70, 26);
        jPanel5.add(jSpinnerinterview);
        jSpinnerinterview.setBounds(200, 210, 70, 26);

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel5.add(update);
        update.setBounds(590, 680, 110, 32);
        
        javax.swing.JButton delete = new javax.swing.JButton("Delete");
        delete.setBounds(710, 680, 110, 32);
        jPanel5.add(delete);
        delete.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                if(!jobsData.isEmpty())
                    if( jobsData.size() >= 2){
                        jobsDataChanged++;
                        if( index == 0 ){
                            jButtonNextActionPerformed(jButtonNextEvent);
                            removedElementsOfJobsData.add(jobsData.remove(index-1));
                            removedElementsIndecesOfJobsData.add(index-1);
                            jButtonPrevActionPerformed(jButtonPrevEvent);
                        }
                        else{
                            if( index == jobsData.size() - 1 ){
                                removedElementsOfJobsData.add(jobsData.remove(index));
                                removedElementsIndecesOfJobsData.add(index);
                                jButtonPrevActionPerformed(jButtonPrevEvent);
                            }
                            else{
                                removedElementsOfJobsData.add(jobsData.remove(index));
                                removedElementsIndecesOfJobsData.add(index);
                                jButtonPrevActionPerformed(jButtonPrevEvent);                            
                            }
                        }
                    }
                    else{
                        jobsDataChanged++;
                        removedElementsOfJobsData.add(jobsData.remove(index));
                        removedElementsIndecesOfJobsData.add(index);
                        jobsData.clear();
                        clearVacantJobsComponents();
                    }
                }
        });

        jPanel5.add(jComboBoxEducation);
        jComboBoxEducation.setBounds(200, 130, 230, 26);

        jLabel5.setText("Education ");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(70, 130, 70, 16);

        jTabbedPane2.addTab("Vacant Jobs", jPanel5);

        jPanel7.setLayout(null);

        jPanel1.add(jTabbedPane2);
        jTabbedPane2.setBounds(0, 0, 1351, 847);

        jTabbedPane1.addTab("Jobs", jPanel1);

        jPanel9.setLayout(null);

        jTextFieldCandidateID1.setEditable(false);
        jPanel9.add(jTextFieldCandidateID1);
        jTextFieldCandidateID1.setBounds(140, 10, 67, 24);
        jPanel9.add(jTextFieldCanName1);
        jTextFieldCanName1.setBounds(140, 50, 256, 24);
        jPanel9.add(jTextFieldCanBirthDate1);
        jTextFieldCanBirthDate1.setBounds(140, 100, 256, 24);

        jPanel9.add(jComboBoxCanEducation1);
        jComboBoxCanEducation1.setBounds(140, 140, 256, 26);

        jPanel9.add(jComboBoxCanMajor1);
        jComboBoxCanMajor1.setBounds(140, 180, 256, 26);
        jPanel9.add(jTextFieldCanGPA1);
        jTextFieldCanGPA1.setBounds(140, 270, 47, 24);
        jPanel9.add(jTextFieldCanCompany1);
        jTextFieldCanCompany1.setBounds(140, 330, 256, 24);
        jPanel9.add(jTextFieldCanPosition1);
        jTextFieldCanPosition1.setBounds(140, 370, 256, 24);
        jPanel9.add(jTextFieldCanSalary1);
        jTextFieldCanSalary1.setBounds(140, 450, 256, 24);
        jPanel9.add(jTextFieldCanExpYears1);
        jTextFieldCanExpYears1.setBounds(140, 410, 256, 24);
        jPanel9.add(jTextFieldCanAddress1);
        jTextFieldCanAddress1.setBounds(140, 580, 256, 24);
        jPanel9.add(jTextFieldCanCity1);
        jTextFieldCanCity1.setBounds(140, 620, 256, 24);
        jPanel9.add(jTextFieldCanCountry1);
        jTextFieldCanCountry1.setBounds(140, 660, 256, 24);

        jLabel79.setText("Candidte ID");
        jPanel9.add(jLabel79);
        jLabel79.setBounds(30, 10, 87, 20);

        jLabel80.setText("Name");
        jPanel9.add(jLabel80);
        jLabel80.setBounds(30, 50, 87, 20);

        jLabel81.setText("Birth date");
        jPanel9.add(jLabel81);
        jLabel81.setBounds(30, 100, 87, 20);

        jLabel82.setText("Education level");
        jPanel9.add(jLabel82);
        jLabel82.setBounds(30, 140, 87, 20);

        jLabel83.setText("Competency value");
        jPanel9.add(jLabel83);
        jLabel83.setBounds(910, 530, 110, 16);

        jLabel84.setText("Competency");
        jPanel9.add(jLabel84);
        jLabel84.setBounds(760, 530, 80, 16);

        jLabel85.setText("Competency  categories");
        jPanel9.add(jLabel85);
        jLabel85.setBounds(500, 530, 150, 16);

        jSpinnerCanCompValue6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanCompValue6);
        jSpinnerCanCompValue6.setBounds(937, 746, 70, 26);

        jSpinnerCanCompValue7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanCompValue7);
        jSpinnerCanCompValue7.setBounds(937, 702, 70, 26);

        jSpinnerCanCompValue8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanCompValue8);
        jSpinnerCanCompValue8.setBounds(937, 658, 70, 26);

        jSpinnerCanCompValue9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanCompValue9);
        jSpinnerCanCompValue9.setBounds(937, 614, 70, 26);

        jSpinnerCanCompValue10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanCompValue10);
        jSpinnerCanCompValue10.setBounds(937, 570, 70, 26);

        jSpinnerCanSkillValue6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanSkillValue6);
        jSpinnerCanSkillValue6.setBounds(940, 410, 70, 26);

        jSpinnerCanSkillValue7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanSkillValue7);
        jSpinnerCanSkillValue7.setBounds(940, 370, 70, 26);

        jSpinnerCanSkillValue8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanSkillValue8);
        jSpinnerCanSkillValue8.setBounds(940, 320, 70, 26);

        jSpinnerCanSkillValue9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanSkillValue9);
        jSpinnerCanSkillValue9.setBounds(940, 280, 70, 26);

        jSpinnerCanSkillValue10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanSkillValue10);
        jSpinnerCanSkillValue10.setBounds(940, 240, 70, 26);

        jPanel9.add(jComboBoxCanCompCat6);
        jComboBoxCanCompCat6.setBounds(490, 614, 158, 26);

        jPanel9.add(jComboBoxCanCompCat7);
        jComboBoxCanCompCat7.setBounds(490, 658, 158, 26);

        jPanel9.add(jComboBoxCanCompCat8);
        jComboBoxCanCompCat8.setBounds(490, 702, 158, 26);

        jPanel9.add(jComboBoxCanCompCat9);
        jComboBoxCanCompCat9.setBounds(490, 746, 158, 26);

        jPanel9.add(jComboBoxCanComp6);
        jComboBoxCanComp6.setBounds(719, 746, 158, 26);

        jPanel9.add(jComboBoxCanComp7);
        jComboBoxCanComp7.setBounds(719, 702, 158, 26);

        jPanel9.add(jComboBoxCanComp8);
        jComboBoxCanComp8.setBounds(719, 658, 158, 26);

        jPanel9.add(jComboBoxCanComp9);
        jComboBoxCanComp9.setBounds(719, 614, 158, 26);

        jPanel9.add(jComboBoxCanComp10);
        jComboBoxCanComp10.setBounds(719, 570, 158, 26);

        jPanel9.add(jComboBoxCanCompCat10);
        jComboBoxCanCompCat10.setBounds(490, 570, 158, 26);

        jPanel9.add(jComboBoxCanSkill6);
        jComboBoxCanSkill6.setBounds(720, 410, 158, 26);

        jPanel9.add(jComboBoxCanSkillCat6);
        jComboBoxCanSkillCat6.setBounds(490, 410, 158, 26);

        jPanel9.add(jComboBoxCanSkill7);
        jComboBoxCanSkill7.setBounds(720, 370, 158, 26);

        jPanel9.add(jComboBoxCanSkillCat7);
        jComboBoxCanSkillCat7.setBounds(490, 370, 158, 26);

        jPanel9.add(jComboBoxCanSkill8);
        jComboBoxCanSkill8.setBounds(720, 320, 158, 26);

        jPanel9.add(jComboBoxCanSkillCat8);
        jComboBoxCanSkillCat8.setBounds(490, 320, 158, 26);

        jPanel9.add(jComboBoxCanSkill9);
        jComboBoxCanSkill9.setBounds(720, 280, 158, 26);

        jPanel9.add(jComboBoxCanSkillCat9);
        jComboBoxCanSkillCat9.setBounds(490, 280, 158, 26);

        jPanel9.add(jComboBoxCanSkill10);
        jComboBoxCanSkill10.setBounds(720, 240, 158, 26);

        jPanel9.add(jComboBoxCanSkillCat10);
        jComboBoxCanSkillCat10.setBounds(490, 240, 158, 26);

        jLabel86.setText("Skills value");
        jPanel9.add(jLabel86);
        jLabel86.setBounds(940, 200, 70, 16);

        jLabel87.setText("Skills");
        jPanel9.add(jLabel87);
        jLabel87.setBounds(780, 200, 67, 16);

        jLabel88.setText("Skills categories");
        jPanel9.add(jLabel88);
        jLabel88.setBounds(520, 200, 95, 16);

        jCheckBoxCanTravell1.setText("Travelling");
        jPanel9.add(jCheckBoxCanTravell1);
        jCheckBoxCanTravell1.setBounds(490, 141, 100, 24);

        jCheckBoxCanDriving1.setText("Driving license");
        jPanel9.add(jCheckBoxCanDriving1);
        jCheckBoxCanDriving1.setBounds(490, 98, 111, 24);

        jCheckBoxCanReallocation1.setText("Reallocation ");
        jCheckBoxCanReallocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCanReallocation1ActionPerformed(evt);
            }
        });
        jPanel9.add(jCheckBoxCanReallocation1);
        jCheckBoxCanReallocation1.setBounds(490, 52, 101, 24);

        jSpinnerCanInterviewScore1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel9.add(jSpinnerCanInterviewScore1);
        jSpinnerCanInterviewScore1.setBounds(140, 490, 70, 26);

        jComboBoxCanGrade1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pass", "Good", "V.good", "Excellent" }));
        jPanel9.add(jComboBoxCanGrade1);
        jComboBoxCanGrade1.setBounds(140, 230, 141, 26);

        jLabel89.setText("Email");
        jPanel9.add(jLabel89);
        jLabel89.setBounds(30, 740, 87, 20);

        jLabel90.setText("Phone");
        jPanel9.add(jLabel90);
        jLabel90.setBounds(30, 700, 87, 20);
        jPanel9.add(jTextFieldCanEmail1);
        jTextFieldCanEmail1.setBounds(140, 740, 256, 24);
        jPanel9.add(jTextFieldCanPhone1);
        jTextFieldCanPhone1.setBounds(140, 700, 256, 24);

        jLabel91.setText("Country");
        jPanel9.add(jLabel91);
        jLabel91.setBounds(30, 660, 87, 20);

        jLabel92.setText("City");
        jPanel9.add(jLabel92);
        jLabel92.setBounds(30, 620, 87, 20);

        jLabel93.setText("Address");
        jPanel9.add(jLabel93);
        jLabel93.setBounds(30, 580, 87, 20);

        jLabel94.setText("Gender");
        jPanel9.add(jLabel94);
        jLabel94.setBounds(30, 530, 87, 20);

        jLabel95.setText("Interview score");
        jPanel9.add(jLabel95);
        jLabel95.setBounds(30, 490, 100, 20);

        jLabel96.setText("Expected salary");
        jPanel9.add(jLabel96);
        jLabel96.setBounds(30, 450, 100, 20);

        jLabel97.setText("Current position");
        jPanel9.add(jLabel97);
        jLabel97.setBounds(30, 370, 100, 20);

        jLabel98.setText("Experience years");
        jPanel9.add(jLabel98);
        jLabel98.setBounds(30, 410, 110, 20);

        jLabel99.setText("Current company");
        jPanel9.add(jLabel99);
        jLabel99.setBounds(30, 330, 110, 20);

        jLabel100.setText("GPA");
        jPanel9.add(jLabel100);
        jLabel100.setBounds(30, 270, 87, 20);

        jLabel101.setText("Grade");
        jPanel9.add(jLabel101);
        jLabel101.setBounds(30, 230, 87, 20);

        jLabel102.setText("Major");
        jPanel9.add(jLabel102);
        jLabel102.setBounds(30, 180, 87, 20);

        jButtonCanAdd.setText("Add");
        jButtonCanAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsDataChanged++;
                jButtonCanAddActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonCanAdd);
        jButtonCanAdd.setBounds(902, 50, 120, 32);

        buttonGroupGender.add(jRadioButtonNewMale);
        jRadioButtonNewMale.setText("Male");
        jRadioButtonNewMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNewMaleActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButtonNewMale);
        jRadioButtonNewMale.setBounds(140, 530, 59, 28);

        buttonGroupGender.add(jRadioButtonNewFemale);
        jRadioButtonNewFemale.setText("Female");
        jRadioButtonNewFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNewFemaleActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButtonNewFemale);
        jRadioButtonNewFemale.setBounds(220, 530, 73, 28);

        jTabbedPane3.addTab("New Candidate", jPanel9);

        jPanel8.setLayout(null);

        jTextFieldCandidateID.setEditable(false);
        jPanel8.add(jTextFieldCandidateID);
        jTextFieldCandidateID.setBounds(140, 10, 67, 24);
        jPanel8.add(jTextFieldCanName);
        jTextFieldCanName.setBounds(140, 50, 256, 24);
        jPanel8.add(jTextFieldCanBirthDate);
        jTextFieldCanBirthDate.setBounds(140, 100, 256, 24);

        jPanel8.add(jComboBoxCanEducation);
        jComboBoxCanEducation.setBounds(140, 140, 256, 26);

        jPanel8.add(jComboBoxCanMajor);
        jComboBoxCanMajor.setBounds(140, 180, 256, 26);
        jPanel8.add(jTextFieldCanGPA);
        jTextFieldCanGPA.setBounds(140, 270, 47, 24);
        jPanel8.add(jTextFieldCanCompany);
        jTextFieldCanCompany.setBounds(140, 330, 256, 24);
        jPanel8.add(jTextFieldCanPosition);
        jTextFieldCanPosition.setBounds(140, 370, 256, 24);
        jPanel8.add(jTextFieldCanSalary);
        jTextFieldCanSalary.setBounds(140, 450, 256, 24);
        jPanel8.add(jTextFieldCanExpYears);
        jTextFieldCanExpYears.setBounds(140, 410, 256, 24);
        jPanel8.add(jTextFieldCanAddress);
        jTextFieldCanAddress.setBounds(140, 580, 256, 24);
        jPanel8.add(jTextFieldCanCity);
        jTextFieldCanCity.setBounds(140, 620, 256, 24);
        jPanel8.add(jTextFieldCanCountry);
        jTextFieldCanCountry.setBounds(140, 660, 256, 24);

        jLabel33.setText("Candidte ID");
        jPanel8.add(jLabel33);
        jLabel33.setBounds(30, 10, 87, 20);

        jLabel56.setText("Name");
        jPanel8.add(jLabel56);
        jLabel56.setBounds(30, 50, 87, 20);

        jLabel57.setText("Birth date");
        jPanel8.add(jLabel57);
        jLabel57.setBounds(30, 100, 87, 20);

        jLabel58.setText("Education level");
        jPanel8.add(jLabel58);
        jLabel58.setBounds(30, 140, 87, 20);

        jLabel59.setText("Major");
        jPanel8.add(jLabel59);
        jLabel59.setBounds(30, 180, 87, 20);

        jLabel60.setText("Grade");
        jPanel8.add(jLabel60);
        jLabel60.setBounds(30, 230, 87, 20);

        jLabel61.setText("GPA");
        jPanel8.add(jLabel61);
        jLabel61.setBounds(30, 270, 87, 20);

        jLabel62.setText("Current company");
        jPanel8.add(jLabel62);
        jLabel62.setBounds(30, 330, 110, 20);

        jLabel63.setText("Experience years");
        jPanel8.add(jLabel63);
        jLabel63.setBounds(30, 410, 110, 20);

        jLabel64.setText("Current position");
        jPanel8.add(jLabel64);
        jLabel64.setBounds(30, 370, 110, 20);

        jLabel65.setText("Expected salary");
        jPanel8.add(jLabel65);
        jLabel65.setBounds(30, 450, 110, 20);

        jLabel66.setText("Interview score");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(30, 490, 110, 20);

        jLabel67.setText("Gender");
        jPanel8.add(jLabel67);
        jLabel67.setBounds(30, 530, 87, 20);

        buttonGroupGender1.add(jRadioButtonMale);
        jRadioButtonMale.setText("Male");
        jRadioButtonMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMaleActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButtonMale);
        jRadioButtonMale.setBounds(140, 530, 59, 28);

        buttonGroupGender1.add(jRadioButtonFemale);
        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemaleActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButtonFemale);
        jRadioButtonFemale.setBounds(220, 530, 73, 28);

        jLabel68.setText("Address");
        jPanel8.add(jLabel68);
        jLabel68.setBounds(30, 580, 87, 20);

        jLabel69.setText("City");
        jPanel8.add(jLabel69);
        jLabel69.setBounds(30, 620, 87, 20);

        jLabel70.setText("Country");
        jPanel8.add(jLabel70);
        jLabel70.setBounds(30, 660, 87, 20);
        jPanel8.add(jTextFieldCanPhone);
        jTextFieldCanPhone.setBounds(140, 700, 256, 24);
        jPanel8.add(jTextFieldCanEmail);
        jTextFieldCanEmail.setBounds(140, 740, 256, 24);

        jLabel71.setText("Phone");
        jPanel8.add(jLabel71);
        jLabel71.setBounds(30, 700, 87, 20);

        jLabel72.setText("Email");
        jPanel8.add(jLabel72);
        jLabel72.setBounds(30, 740, 87, 20);

        jComboBoxCanGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pass", "Good", "V.good", "Excellent" }));
        jPanel8.add(jComboBoxCanGrade);
        jComboBoxCanGrade.setBounds(140, 230, 141, 26);

        jSpinnerCanInterviewScore.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanInterviewScore);
        jSpinnerCanInterviewScore.setBounds(140, 490, 70, 26);
        
        jCheckBoxCanReallocation.setText("Reallocation ");
        jPanel8.add(jCheckBoxCanReallocation);
        jCheckBoxCanReallocation.setBounds(490, 52, 110, 24);

        jCheckBoxCanDriving.setText("Driving license");
        jPanel8.add(jCheckBoxCanDriving);
        jCheckBoxCanDriving.setBounds(490, 102, 111, 24);

        jCheckBoxCanTravel.setText("Travelling");
        jCheckBoxCanTravel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCanTravelActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBoxCanTravel);
        jCheckBoxCanTravel.setBounds(490, 149, 90, 24);

        jLabel73.setText("Skills categories");
        jPanel8.add(jLabel73);
        jLabel73.setBounds(520, 200, 95, 16);

        jLabel74.setText("Skills");
        jPanel8.add(jLabel74);
        jLabel74.setBounds(780, 200, 40, 16);

        jLabel75.setText("Skills value");
        jPanel8.add(jLabel75);
        jLabel75.setBounds(940, 200, 70, 16);

        jPanel8.add(jComboBoxCanSkillCat1);
        jComboBoxCanSkillCat1.setBounds(490, 236, 158, 26);

        jPanel8.add(jComboBoxCanSkill1);
        jComboBoxCanSkill1.setBounds(719, 236, 158, 26);

        jPanel8.add(jComboBoxCanSkillCat2);
        jComboBoxCanSkillCat2.setBounds(490, 280, 158, 26);

        jPanel8.add(jComboBoxCanSkill2);
        jComboBoxCanSkill2.setBounds(719, 280, 158, 26);

        jPanel8.add(jComboBoxCanSkillCat3);
        jComboBoxCanSkillCat3.setBounds(490, 324, 158, 26);

        jPanel8.add(jComboBoxCanSkill3);
        jComboBoxCanSkill3.setBounds(719, 324, 158, 26);

        jPanel8.add(jComboBoxCanSkillCat4);
        jComboBoxCanSkillCat4.setBounds(490, 368, 158, 26);

        jPanel8.add(jComboBoxCanSkill4);
        jComboBoxCanSkill4.setBounds(719, 368, 158, 26);

        jPanel8.add(jComboBoxCanSkillCat5);
        jComboBoxCanSkillCat5.setBounds(490, 412, 158, 26);

        jPanel8.add(jComboBoxCanSkill5);
        jComboBoxCanSkill5.setBounds(719, 412, 158, 26);

        jPanel8.add(jComboBoxCanCompCat1);
        jComboBoxCanCompCat1.setBounds(490, 580, 158, 26);

        jPanel8.add(jComboBoxCanComp1);
        jComboBoxCanComp1.setBounds(720, 580, 158, 26);

        jPanel8.add(jComboBoxCanComp2);
        jComboBoxCanComp2.setBounds(720, 620, 158, 26);

        jPanel8.add(jComboBoxCanComp3);
        jComboBoxCanComp3.setBounds(720, 660, 158, 26);

        jPanel8.add(jComboBoxCanComp4);
        jComboBoxCanComp4.setBounds(720, 700, 158, 26);

        jPanel8.add(jComboBoxCanComp5);
        jComboBoxCanComp5.setBounds(720, 740, 158, 26);

        jPanel8.add(jComboBoxCanCompCat5);
        jComboBoxCanCompCat5.setBounds(490, 740, 158, 26);

        jPanel8.add(jComboBoxCanCompCat4);
        jComboBoxCanCompCat4.setBounds(490, 700, 158, 26);

        jPanel8.add(jComboBoxCanCompCat3);
        jComboBoxCanCompCat3.setBounds(490, 660, 158, 26);

        jPanel8.add(jComboBoxCanCompCat2);
        jComboBoxCanCompCat2.setBounds(490, 620, 158, 26);

        jSpinnerCanSkillValue1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanSkillValue1);
        jSpinnerCanSkillValue1.setBounds(937, 236, 70, 26);

        jSpinnerCanSkillValue2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanSkillValue2);
        jSpinnerCanSkillValue2.setBounds(937, 280, 70, 26);

        jSpinnerCanSkillValue3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanSkillValue3);
        jSpinnerCanSkillValue3.setBounds(937, 324, 70, 26);

        jSpinnerCanSkillValue4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanSkillValue4);
        jSpinnerCanSkillValue4.setBounds(937, 368, 70, 26);

        jSpinnerCanSkillValue5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanSkillValue5);
        jSpinnerCanSkillValue5.setBounds(937, 412, 70, 26);

        jSpinnerCanCompValue1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanCompValue1);
        jSpinnerCanCompValue1.setBounds(940, 580, 70, 26);

        jSpinnerCanCompValue2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanCompValue2);
        jSpinnerCanCompValue2.setBounds(940, 620, 70, 26);

        jSpinnerCanCompValue3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanCompValue3);
        jSpinnerCanCompValue3.setBounds(940, 660, 70, 26);

        jSpinnerCanCompValue4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanCompValue4);
        jSpinnerCanCompValue4.setBounds(940, 700, 70, 26);

        jSpinnerCanCompValue5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jPanel8.add(jSpinnerCanCompValue5);
        jSpinnerCanCompValue5.setBounds(940, 740, 70, 26);

        jLabel76.setText("Competency  categories");
        jPanel8.add(jLabel76);
        jLabel76.setBounds(500, 540, 140, 16);

        jLabel77.setText("Competency");
        jPanel8.add(jLabel77);
        jLabel77.setBounds(760, 540, 90, 16);

        jLabel78.setText("Competency value");
        jPanel8.add(jLabel78);
        jLabel78.setBounds(930, 540, 110, 16);

        jButtonPrevCan.setText("prev");
        jButtonPrevCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevCanActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonPrevCan);
        jButtonPrevCan.setBounds(890, 50, 60, 32);

        jButtonNextCan.setText("next");
        jButtonNextCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextCanActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonNextCan);
        jButtonNextCan.setBounds(962, 50, 60, 32);

        jButtonCanUpdate.setText("Update ");
        jButtonCanUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCanUpdateActionPerformed(evt);
            }
        });
        jPanel8.add(jButtonCanUpdate);
        jButtonCanUpdate.setBounds(890, 100, 132, 32);
        
        jButtonCanDelete = new javax.swing.JButton("Delete");
        jPanel8.add(jButtonCanDelete);
        jButtonCanDelete.setBounds(890, 150, 132, 32);
        jButtonCanDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!candidatesData.isEmpty())
                    if( candidatesData.size() >= 2 ){
                        candidatesDataChanged++;
                        if( canindex == 0 ){
                            jButtonNextCanActionPerformed(jButtonNextCanEvent);
                            removedElementsOfCandidatesData.add(candidatesData.remove(canindex-1));
                            removedElementsIndecesOfCandidatesData.add(canindex-1);
                            jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                        }else
                            if( canindex == candidatesData.size()-1 ){
                                removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                                removedElementsIndecesOfCandidatesData.add(canindex);
                                jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                            }
                            else{
                                removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                                removedElementsIndecesOfCandidatesData.add(canindex);                                            
                                jButtonPrevCanActionPerformed(jButtonPrevCanEvent);
                            }
                    }
                    else{
                        candidatesDataChanged++;
                        removedElementsOfCandidatesData.add(candidatesData.remove(canindex));
                        removedElementsIndecesOfCandidatesData.add(canindex);
                        candidatesData.clear();
                        clearUnprocessedCandidatesComponents();                        
                    }
                }
        });

        jTabbedPane3.addTab("Unprocessed Candidates", jPanel8);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Candidates", jPanel2);

        jPanel3.setLayout(null);

        jLabel3.setText("Select a lookup:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(253, 25, 100, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Institutes", "Majors", "Jobs categories", "Jobs sub categories", "Education levels", "Skills categories", "Skills", "Competencies categories", "Competencies", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(402, 20, 222, 26);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(253, 58, 877, 430);

        jTextFieldCode.setEditable(false);
        jPanel3.add(jTextFieldCode);
        jTextFieldCode.setBounds(330, 512, 86, 24);
        jPanel3.add(jTextFieldDesc);
        jTextFieldDesc.setBounds(330, 548, 800, 24);

        jButtonAdd.setText("Add");
        jPanel3.add(jButtonAdd);
        jButtonAdd.setBounds(330, 590, 65, 32);

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonUpdate);
        jButtonUpdate.setBounds(415, 590, 80, 32);

        jLabel25.setText("Code");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(253, 516, 40, 16);

        jLabel26.setText("Description");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(253, 552, 80, 16);

        jTabbedPane1.addTab("Lookups", jPanel3);

        jButtonSaveExit.setText("Save data to CSV files & Exit");
        jButtonSaveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveExitActionPerformed(evt);
            }
        });

        jButtonExit.setText(" Exit without save");
        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserTypePage noObj = new UserTypePage("AJCSS");
                noObj.setVisible(true);
                setVisible(false);
            }
            
            
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveExit, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(725, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButtonSaveExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(572, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("", jPanel11);

        jPanel4.setLayout(null);

        jButtonMatch.setText("Match");
        jButtonMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMatchActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonMatch);
        jButtonMatch.setBounds(640, 400, 85, 32);

        jTableMathedPersons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMathedPersons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMathedPersonsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMathedPersons);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(455, 464, 335, 161);

        jTableJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableJobs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableJobsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableJobs);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(455, 47, 386, 168);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel4.add(jSlider1);
        jSlider1.setBounds(455, 317, 449, 43);

        jLabelSlider.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelSlider.setText("50");
        jPanel4.add(jLabelSlider);
        jLabelSlider.setBounds(455, 378, 25, 18);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Confirm selection and send list by email to HR manager");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(425, 756, 400, 33);

        jTextFieldMatchSkill1.setEditable(false);
        jPanel4.add(jTextFieldMatchSkill1);
        jTextFieldMatchSkill1.setBounds(35, 58, 345, 24);

        jTextFieldMatchSkill2.setEditable(false);
        jPanel4.add(jTextFieldMatchSkill2);
        jTextFieldMatchSkill2.setBounds(35, 91, 345, 24);

        jTextFieldMatchSkill3.setEditable(false);
        jPanel4.add(jTextFieldMatchSkill3);
        jTextFieldMatchSkill3.setBounds(35, 123, 345, 24);

        jTextFieldMatchSkill4.setEditable(false);
        jPanel4.add(jTextFieldMatchSkill4);
        jTextFieldMatchSkill4.setBounds(35, 157, 345, 24);

        jTextFieldMatchSkill5.setEditable(false);
        jPanel4.add(jTextFieldMatchSkill5);
        jTextFieldMatchSkill5.setBounds(35, 191, 345, 24);

        jTextFieldMatchSkillValue1.setEditable(false);
        jPanel4.add(jTextFieldMatchSkillValue1);
        jTextFieldMatchSkillValue1.setBounds(398, 58, 34, 24);

        jTextFieldMatchSkillValue2.setEditable(false);
        jPanel4.add(jTextFieldMatchSkillValue2);
        jTextFieldMatchSkillValue2.setBounds(398, 91, 34, 24);

        jTextFieldMatchSkillValue3.setEditable(false);
        jPanel4.add(jTextFieldMatchSkillValue3);
        jTextFieldMatchSkillValue3.setBounds(398, 123, 34, 24);

        jTextFieldMatchSkillValue4.setEditable(false);
        jPanel4.add(jTextFieldMatchSkillValue4);
        jTextFieldMatchSkillValue4.setBounds(398, 157, 34, 24);

        jTextFieldMatchSkillValue5.setEditable(false);
        jPanel4.add(jTextFieldMatchSkillValue5);
        jTextFieldMatchSkillValue5.setBounds(398, 191, 34, 24);

        jTextFieldMatchComp1.setEditable(false);
        jPanel4.add(jTextFieldMatchComp1);
        jTextFieldMatchComp1.setBounds(859, 58, 224, 24);

        jTextFieldMatchComp2.setEditable(false);
        jPanel4.add(jTextFieldMatchComp2);
        jTextFieldMatchComp2.setBounds(859, 91, 224, 24);

        jTextFieldMatchComp3.setEditable(false);
        jPanel4.add(jTextFieldMatchComp3);
        jTextFieldMatchComp3.setBounds(859, 123, 224, 24);

        jTextFieldMatchComp4.setEditable(false);
        jPanel4.add(jTextFieldMatchComp4);
        jTextFieldMatchComp4.setBounds(859, 157, 224, 24);

        jTextFieldMatchComp5.setEditable(false);
        jPanel4.add(jTextFieldMatchComp5);
        jTextFieldMatchComp5.setBounds(859, 195, 224, 24);

        jTextFieldMatchCompValue5.setEditable(false);
        jPanel4.add(jTextFieldMatchCompValue5);
        jTextFieldMatchCompValue5.setBounds(1101, 195, 34, 24);

        jTextFieldMatchCompValue4.setEditable(false);
        jPanel4.add(jTextFieldMatchCompValue4);
        jTextFieldMatchCompValue4.setBounds(1101, 165, 34, 24);

        jTextFieldMatchCompValue3.setEditable(false);
        jPanel4.add(jTextFieldMatchCompValue3);
        jTextFieldMatchCompValue3.setBounds(1101, 123, 34, 24);

        jTextFieldMatchCompValue2.setEditable(false);
        jPanel4.add(jTextFieldMatchCompValue2);
        jTextFieldMatchCompValue2.setBounds(1101, 91, 34, 24);

        jTextFieldMatchCompValue1.setEditable(false);
        jPanel4.add(jTextFieldMatchCompValue1);
        jTextFieldMatchCompValue1.setBounds(1101, 58, 34, 24);

        jTextFieldTotMatchCompValues.setEditable(false);
        jPanel4.add(jTextFieldTotMatchCompValues);
        jTextFieldTotMatchCompValues.setBounds(1101, 237, 34, 24);

        jLabel104.setText("Competencies total points");
        jPanel4.add(jLabel104);
        jLabel104.setBounds(860, 240, 170, 16);

        jTextFieldTotMatchSkillValues.setEditable(false);
        jPanel4.add(jTextFieldTotMatchSkillValues);
        jTextFieldTotMatchSkillValues.setBounds(398, 233, 34, 24);

        jLabel105.setText("Skills total points");
        jPanel4.add(jLabel105);
        jLabel105.setBounds(36, 240, 100, 16);

        jTextFieldTotCanSkillValues.setEditable(false);
        jTextFieldTotCanSkillValues.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel4.add(jTextFieldTotCanSkillValues);
        jTextFieldTotCanSkillValues.setBounds(407, 643, 34, 23);

        jLabel106.setText("Candidate's skills total points");
        jPanel4.add(jLabel106);
        jLabel106.setBounds(36, 640, 170, 16);

        jLabel107.setText("Candidate's competencies total points");
        jPanel4.add(jLabel107);
        jLabel107.setBounds(808, 643, 225, 16);

        jTextFieldTotCanCompValues.setEditable(false);
        jTextFieldTotCanCompValues.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel4.add(jTextFieldTotCanCompValues);
        jTextFieldTotCanCompValues.setBounds(1175, 640, 34, 23);

        jTableMathedPersonSkills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTableMathedPersonSkills);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(35, 464, 406, 161);

        jTableMathedPersonComp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTableMathedPersonComp);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(808, 465, 401, 160);

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel103.setText("+   30   +");
        jPanel4.add(jLabel103);
        jLabel103.setBounds(595, 647, 60, 15);

        jTabbedPane1.addTab("Matching", jPanel4);
        
        jTabbedPane1.addTab("", jTabbedPane4);
        jTabbedPane1.setEnabledAt(WIDTH+3, false);
        

        jScrollPane6.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1347, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
        );

        pack();
    }                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        // TODO add your handling code here:
        jLabelSlider.setText(Integer.toString(jSlider1.getValue()));
    }                                     

    private void jTableJobsMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        int selectedRow = jTableJobs.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableJobs.getModel();
        int selectedJob = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        jTextFieldMatchSkill1.setText(getLookupDesc(skillData, jobsData.get(selectedJob).getSkill1()));
        jTextFieldMatchSkill2.setText(getLookupDesc(skillData, jobsData.get(selectedJob).getSkill2()));
        jTextFieldMatchSkill3.setText(getLookupDesc(skillData, jobsData.get(selectedJob).getSkill3()));
        jTextFieldMatchSkill4.setText(getLookupDesc(skillData, jobsData.get(selectedJob).getSkill4()));
        jTextFieldMatchSkill5.setText(getLookupDesc(skillData, jobsData.get(selectedJob).getSkill5()));
        jTextFieldMatchSkillValue1.setText(Integer.toString(jobsData.get(selectedJob).getSkillValue1()));
        jTextFieldMatchSkillValue2.setText(Integer.toString(jobsData.get(selectedJob).getSkillValue2()));
        jTextFieldMatchSkillValue3.setText(Integer.toString(jobsData.get(selectedJob).getSkillValue3()));
        jTextFieldMatchSkillValue4.setText(Integer.toString(jobsData.get(selectedJob).getSkillValue4()));
        jTextFieldMatchSkillValue5.setText(Integer.toString(jobsData.get(selectedJob).getSkillValue5()));
        jTextFieldMatchComp1.setText(getLookupDesc(compCatData, jobsData.get(selectedJob).getCompCat1()));
        jTextFieldMatchComp2.setText(getLookupDesc(compCatData, jobsData.get(selectedJob).getCompCat2()));
        jTextFieldMatchComp3.setText(getLookupDesc(compCatData, jobsData.get(selectedJob).getCompCat3()));
        jTextFieldMatchComp4.setText(getLookupDesc(compCatData, jobsData.get(selectedJob).getCompCat4()));
        jTextFieldMatchComp5.setText(getLookupDesc(compCatData, jobsData.get(selectedJob).getCompCat5()));

        jTextFieldMatchCompValue1.setText(Integer.toString(jobsData.get(selectedJob).getCompValue1()));
        jTextFieldMatchCompValue2.setText(Integer.toString(jobsData.get(selectedJob).getCompValue2()));
        jTextFieldMatchCompValue3.setText(Integer.toString(jobsData.get(selectedJob).getCompValue3()));
        jTextFieldMatchCompValue4.setText(Integer.toString(jobsData.get(selectedJob).getCompValue4()));
        jTextFieldMatchCompValue5.setText(Integer.toString(jobsData.get(selectedJob).getCompValue5()));
        int CompTot = Integer.parseInt(jTextFieldMatchCompValue1.getText())
                + Integer.parseInt(jTextFieldMatchCompValue2.getText())
                + Integer.parseInt(jTextFieldMatchCompValue3.getText())
                + Integer.parseInt(jTextFieldMatchCompValue4.getText())
                + Integer.parseInt(jTextFieldMatchCompValue5.getText());
        int SkillsTot = Integer.parseInt(jTextFieldMatchSkillValue1.getText())
                + Integer.parseInt(jTextFieldMatchSkillValue2.getText())
                + Integer.parseInt(jTextFieldMatchSkillValue3.getText())
                + Integer.parseInt(jTextFieldMatchSkillValue4.getText())
                + Integer.parseInt(jTextFieldMatchSkillValue5.getText());
        jTextFieldTotMatchSkillValues.setText(Integer.toString(SkillsTot));
        jTextFieldTotMatchCompValues.setText(Integer.toString(CompTot));
        jButtonMatch.enableInputMethods(true);
    }                                       

    private void jTableMathedPersonsMouseClicked(java.awt.event.MouseEvent evt) {                                                 
        // TODO add your handling code here:
        int selectedRow = jTableMathedPersons.getSelectedRow();
        int CanSkillsTot = 0;
        int CanCompsTot = 0;
        DefaultTableModel model = (DefaultTableModel) jTableMathedPersons.getModel();
        int selectedCan = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        int selectedCanID = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
        String[] columnsName2 = {"skill", "Score"};
        String[] columnsName3 = {"competency", "Score"};
        DefaultTableModel model2 = (DefaultTableModel) jTableMathedPersonSkills.getModel();
        model2.setRowCount(0);
        model2.setColumnIdentifiers(columnsName2);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableMathedPersonSkills.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTableMathedPersons.getColumnModel().getColumn(0).setCellRenderer(centerRenderer2);
        jTableMathedPersons.getColumnModel().getColumn(1).setCellRenderer(centerRenderer2);
        jTableMathedPersons.getColumnModel().getColumn(2).setCellRenderer(centerRenderer2);
        jTableMathedPersons.getColumnModel().getColumn(3).setCellRenderer(centerRenderer2);
        jTableMathedPersonSkills.setAutoResizeMode(jTableMathedPersonSkills.AUTO_RESIZE_OFF);
        jTableMathedPersonSkills.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableMathedPersonSkills.getColumnModel().getColumn(1).setPreferredWidth(50);
        DefaultTableModel model3 = (DefaultTableModel) jTableMathedPersonComp.getModel();
        model3.setRowCount(0);
        model3.setColumnIdentifiers(columnsName3);
        jTableMathedPersonComp.setAutoResizeMode(jTableMathedPersonComp.AUTO_RESIZE_OFF);
        jTableMathedPersonComp.getColumnModel().getColumn(0).setPreferredWidth(345);
        jTableMathedPersonComp.getColumnModel().getColumn(1).setPreferredWidth(50);
        for (int k = 0; k < MatchedSkillsScore.size(); k++) {
            if (MatchedSkillsScore.get(k).getSkillScoreCanID() == selectedCanID) {
                Object[] rData = {getLookupDesc(skillData, MatchedSkillsScore.get(k).getSkillScore()), MatchedSkillsScore.get(k).getSkillScoreValue()};
                CanSkillsTot = CanSkillsTot + MatchedSkillsScore.get(k).getSkillScoreValue();
                model2.addRow(rData);
            }
        }
        for (int k = 0; k < MatchedCompScore.size(); k++) {
            if (MatchedCompScore.get(k).getCompScoreCanID() == selectedCanID) {
                Object[] cData = {getLookupDesc(compData, MatchedCompScore.get(k).getCompScore()), MatchedCompScore.get(k).getCompScoreValue()};
                CanCompsTot = CanCompsTot + MatchedCompScore.get(k).getCompScoreValue();
                model3.addRow(cData);
            }
        }
        jTextFieldTotCanSkillValues.setText(Integer.toString(CanSkillsTot));
        jTextFieldTotCanCompValues.setText(Integer.toString(CanCompsTot));
    }                                                

    private void jButtonMatchActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        if (!jTableJobs.getSelectionModel().isSelectionEmpty()) {
            int selectedRow = jTableJobs.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jTableJobs.getModel();
            int selectedJob = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
            Jobs matchJob = new Jobs();
            for (int i = 0; i < jobsData.size(); i++) {
                if (jobsData.get(i).getJobID() == selectedJob) {
                    matchJob = jobsData.get(i);
                }
            }
            int PercentLimit = (Integer.parseInt(jLabelSlider.getText()));
            Matching m = new Matching(matchJob, candidatesData);
            ArrayList<Matching.MatchedPersons> mp = m.match();
            String[] columnsName1 = {"Seq", "candidate ID", "Total Score", " Score percentage % "};

            DefaultTableModel model1 = (DefaultTableModel) jTableMathedPersons.getModel();

            jTableMathedPersons.setAutoCreateRowSorter(true);
            model1.setRowCount(0);
            model1.setColumnIdentifiers(columnsName1);
            MatchedSkillsScore.clear();
            MatchedCompScore.clear();

            for (int i = 0; i < mp.size(); i++) {
                int c = mp.get(i).getCandID();
                int s = mp.get(i).getTotalScore();
                int t = mp.get(i).getTotPercent();
                String Skills = mp.get(i).getMatchedSkills();
                String Comps = mp.get(i).getMatchedComps();
                String SkillsValues = mp.get(i).getMatchedSkillsValues();
                String CompsValues = mp.get(i).getMatchedCompsValues();
                String Percent = Integer.toString(t) + "%";
                if (t >= PercentLimit) {
                    Object[] dataRow = {i, c, s, Percent};
                    String[] dataRow2 = Skills.split(",");
                    String[] dataRow3 = Comps.split(",");
                    String[] dataRow4 = SkillsValues.split(",");
                    String[] dataRow5 = CompsValues.split(",");
                    model1.addRow(dataRow);
                    System.out.println("comp string" + CompsValues);
                    for (int j = 0; j < dataRow2.length; j++) {
                        SkillScore ss = new SkillScore();
                        if (dataRow2[j].length() > 0) {
                            ss.setSkillScoreCanID(c);
                        }
                        if (dataRow2[j].length() > 0) {
                            ss.setSkillScore(Integer.parseInt(dataRow2[j]));
                        }
                        if (dataRow4[j].length() > 0) {
                            ss.setSkillScoreValue(Integer.parseInt(dataRow4[j]));
                        }
                        MatchedSkillsScore.add(ss);
                    }
                    for (int j = 0; j < dataRow3.length; j++) {
                        if (dataRow3.length > 0) {
                            CompScore cs = new CompScore();
                            if (dataRow3[j].length() > 0) {
                                cs.setCompScoreCanID(c);
                            }
                            if (dataRow5[j].length() > 0) {
                                cs.setCompScore(Integer.parseInt(dataRow3[j]));
                            }
                            if (dataRow3[j].length() > 0) {
                                cs.setCompcoreValue(Integer.parseInt(dataRow5[j]));
                            }
                            MatchedCompScore.add(cs);
                        }
                    }
                }
            }
        }
    }                                            

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (selectedRow >= 0) {
            model.setValueAt(jTextFieldCode.getText(), selectedRow, 0);
            model.setValueAt(jTextFieldDesc.getText(), selectedRow, 1);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }                                             

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTextFieldCode.setText(model.getValueAt(selectedRow, 0).toString());
        jTextFieldDesc.setText(model.getValueAt(selectedRow, 1).toString());
    }                                    

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        int rows = jTable1.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        int lookupIndex = jComboBox1.getSelectedIndex();
        switch (lookupIndex) {
            case 1:
                getJTableData(majorsData);
                break;
            case 2:
                getJTableData(jobsCatData);
                break;
            case 3:
                getJTableData(jobsSubCatData);
                break;
            case 4:
                getJTableData(educatioData);
                break;
            case 5:
                getJTableData(skillCatData);
                break;
            case 6:
                getJTableData(skillData);
                break;
            case 7:
                getJTableData(compCatData);
                break;
            case 8:
                getJTableData(compData);
                break;
            default:
                break;
        }
    }                                          

    private void jRadioButtonFemaleActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        jRadioButtonFemaleEvent = evt;
        candidatesData.get(canindex).setCangender(2);
    }                                                  

    private void jRadioButtonMaleActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        jRadioButtonMaleEvent = evt;
        candidatesData.get(canindex).setCangender(1);
    }                                                

    private static void jButtonCanUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        jButtonCanUpdateEvent = evt;
        if( !candidatesData.isEmpty()){
            candidatesData.get(canindex).setCanname(jTextFieldCanName.getText());
            candidatesData.get(canindex).setCanaddress(jTextFieldCanAddress.getText());
            candidatesData.get(canindex).setCanbirth(jTextFieldCanBirthDate.getText());
            candidatesData.get(canindex).setCancity(jTextFieldCanCity.getText());
            candidatesData.get(canindex).setCompany(jTextFieldCanCompany.getText());
            candidatesData.get(canindex).setCancountry(jTextFieldCanCountry.getText());
            candidatesData.get(canindex).setCanemail(jTextFieldCanEmail.getText());
            candidatesData.get(canindex).setCanyearsexp(Integer.parseInt(jTextFieldCanExpYears.getText()));
            candidatesData.get(canindex).setCangpa(Double.parseDouble(jTextFieldCanGPA.getText()));
            candidatesData.get(canindex).setCanphone(jTextFieldCanPhone.getText());
            candidatesData.get(canindex).setPosition(jTextFieldCanPosition.getText());
            candidatesData.get(canindex).setCanSalary(Integer.parseInt(jTextFieldCanSalary.getText()));
            candidatesData.get(canindex).setCanreallocation(jCheckBoxCanReallocation.isSelected());
            candidatesData.get(canindex).setCantravel(jCheckBoxCanTravel.isSelected());
            candidatesData.get(canindex).setCandriving(jCheckBoxCanDriving.isSelected());
            candidatesData.get(canindex).setCanmajor(getComboValue(majorsData, jComboBoxCanMajor.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills1cat(getComboValue(skillCatData, jComboBoxCanSkillCat1.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills2cat(getComboValue(skillCatData, jComboBoxCanSkillCat2.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills3cat(getComboValue(skillCatData, jComboBoxCanSkillCat3.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills4cat(getComboValue(skillCatData, jComboBoxCanSkillCat4.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills5cat(getComboValue(skillCatData, jComboBoxCanSkillCat5.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills1(getComboValue(skillData, jComboBoxCanSkill1.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills2(getComboValue(skillData, jComboBoxCanSkill2.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills3(getComboValue(skillData, jComboBoxCanSkill3.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills4(getComboValue(skillData, jComboBoxCanSkill4.getSelectedItem().toString()));
            candidatesData.get(canindex).setCanskills5(getComboValue(skillData, jComboBoxCanSkill5.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency1cat(getComboValue(compCatData, jComboBoxCanCompCat1.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency2cat(getComboValue(compCatData, jComboBoxCanCompCat2.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency3cat(getComboValue(compCatData, jComboBoxCanCompCat3.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency4cat(getComboValue(compCatData, jComboBoxCanCompCat4.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency5cat(getComboValue(compCatData, jComboBoxCanCompCat5.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency1(getComboValue(compData, jComboBoxCanComp1.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency2(getComboValue(compData, jComboBoxCanComp2.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency3(getComboValue(compData, jComboBoxCanComp3.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency4(getComboValue(compData, jComboBoxCanComp4.getSelectedItem().toString()));
            candidatesData.get(canindex).setCancomptency5(getComboValue(compData, jComboBoxCanComp5.getSelectedItem().toString()));

            candidatesData.get(canindex).setCaninterviewscore(Integer.parseInt(jSpinnerCanInterviewScore.getValue().toString()));

            candidatesData.get(canindex).setCanskills1value(Integer.parseInt(jSpinnerCanSkillValue1.getValue().toString()));
            candidatesData.get(canindex).setCanskills2value(Integer.parseInt(jSpinnerCanSkillValue2.getValue().toString()));
            candidatesData.get(canindex).setCanskills3value(Integer.parseInt(jSpinnerCanSkillValue3.getValue().toString()));
            candidatesData.get(canindex).setCanskills4value(Integer.parseInt(jSpinnerCanSkillValue4.getValue().toString()));
            candidatesData.get(canindex).setCanskills5value(Integer.parseInt(jSpinnerCanSkillValue5.getValue().toString()));
            candidatesData.get(canindex).setCancomptency1value(Integer.parseInt(jSpinnerCanCompValue1.getValue().toString()));
            candidatesData.get(canindex).setCancomptency2value(Integer.parseInt(jSpinnerCanCompValue2.getValue().toString()));
            candidatesData.get(canindex).setCancomptency3value(Integer.parseInt(jSpinnerCanCompValue3.getValue().toString()));
            candidatesData.get(canindex).setCancomptency4value(Integer.parseInt(jSpinnerCanCompValue4.getValue().toString()));
            candidatesData.get(canindex).setCancomptency5value(Integer.parseInt(jSpinnerCanCompValue5.getValue().toString()));
        }
        else
            clearUnprocessedCandidatesComponents();
            
    }                                                

    private void jButtonNextCanActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        jButtonNextCanEvent = evt;
        int totUnprocessed = getUnprocesssedCount();
        if (canindex < candidatesData.size() - 1) {
            canindex++;
            displayCandidatesData();
        }
    }                                              

    private void jButtonPrevCanActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        jButtonPrevCanEvent = evt;
        if (canindex > 0) {
            canindex--;
            displayCandidatesData();
        }
    }                                              

    private void jCheckBoxCanTravelActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void jRadioButtonNewFemaleActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        candidatesData.get(canindex).setCangender(2);
    }                                                     

    private void jRadioButtonNewMaleActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        candidatesData.get(canindex).setCangender(1);
    }                                                   

    private void jButtonCanAddActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        Candidate max = Collections.max(candidatesData, Comparator.comparing(s -> s.getCanid()));
        jTextFieldCandidateID1.setText(Integer.toString(max.getCanid() + 1));

        Candidate newCan = new Candidate();
        newCan.setCanid(Integer.parseInt(jTextFieldCandidateID1.getText()));
        newCan.setCanname(jTextFieldCanName1.getText());
        newCan.setCanaddress(jTextFieldCanAddress1.getText());
        newCan.setCanbirth(jTextFieldCanBirthDate1.getText());
        newCan.setCancity(jTextFieldCanCity1.getText());
        newCan.setCompany(jTextFieldCanCompany1.getText());
        newCan.setCancountry(jTextFieldCanCountry1.getText());
        newCan.setCanemail(jTextFieldCanEmail1.getText());
        newCan.setCanyearsexp(Integer.parseInt(jTextFieldCanExpYears1.getText()));
        newCan.setCangpa(Double.parseDouble(jTextFieldCanGPA1.getText()));
        newCan.setCanphone(jTextFieldCanPhone1.getText());
        newCan.setPosition(jTextFieldCanPosition1.getText());
        newCan.setCanSalary(Integer.parseInt(jTextFieldCanSalary1.getText()));
        newCan.setCanreallocation(jCheckBoxCanReallocation1.isSelected());
        newCan.setCantravel(jCheckBoxCanTravell1.isSelected());
        newCan.setCandriving(jCheckBoxCanDriving1.isSelected());
        newCan.setCanmajor(getComboValue(majorsData, jComboBoxCanMajor1.getSelectedItem().toString()));
        newCan.setCanskills1cat(getComboValue(skillCatData, jComboBoxCanSkillCat6.getSelectedItem().toString()));
        newCan.setCanskills2cat(getComboValue(skillCatData, jComboBoxCanSkillCat7.getSelectedItem().toString()));
        newCan.setCanskills3cat(getComboValue(skillCatData, jComboBoxCanSkillCat8.getSelectedItem().toString()));
        newCan.setCanskills4cat(getComboValue(skillCatData, jComboBoxCanSkillCat9.getSelectedItem().toString()));
        newCan.setCanskills5cat(getComboValue(skillCatData, jComboBoxCanSkillCat10.getSelectedItem().toString()));
        newCan.setCanskills1(getComboValue(skillData, jComboBoxCanSkill6.getSelectedItem().toString()));
        newCan.setCanskills2(getComboValue(skillData, jComboBoxCanSkill7.getSelectedItem().toString()));
        newCan.setCanskills3(getComboValue(skillData, jComboBoxCanSkill8.getSelectedItem().toString()));
        newCan.setCanskills4(getComboValue(skillData, jComboBoxCanSkill9.getSelectedItem().toString()));
        newCan.setCanskills5(getComboValue(skillData, jComboBoxCanSkill10.getSelectedItem().toString()));
        newCan.setCancomptency1cat(getComboValue(compCatData, jComboBoxCanCompCat6.getSelectedItem().toString()));
        newCan.setCancomptency2cat(getComboValue(compCatData, jComboBoxCanCompCat7.getSelectedItem().toString()));
        newCan.setCancomptency3cat(getComboValue(compCatData, jComboBoxCanCompCat8.getSelectedItem().toString()));
        newCan.setCancomptency4cat(getComboValue(compCatData, jComboBoxCanCompCat9.getSelectedItem().toString()));
        newCan.setCancomptency5cat(getComboValue(compCatData, jComboBoxCanCompCat10.getSelectedItem().toString()));
        newCan.setCancomptency1(getComboValue(compData, jComboBoxCanComp6.getSelectedItem().toString()));
        newCan.setCancomptency2(getComboValue(compData, jComboBoxCanComp7.getSelectedItem().toString()));
        newCan.setCancomptency3(getComboValue(compData, jComboBoxCanComp8.getSelectedItem().toString()));
        newCan.setCancomptency4(getComboValue(compData, jComboBoxCanComp9.getSelectedItem().toString()));
        newCan.setCancomptency5(getComboValue(compData, jComboBoxCanComp10.getSelectedItem().toString()));

        newCan.setCanskills1value(Integer.parseInt(jSpinnerCanSkillValue1.getValue().toString()));
        newCan.setCanskills2value(Integer.parseInt(jSpinnerCanSkillValue2.getValue().toString()));
        newCan.setCanskills3value(Integer.parseInt(jSpinnerCanSkillValue3.getValue().toString()));
        newCan.setCanskills4value(Integer.parseInt(jSpinnerCanSkillValue4.getValue().toString()));
        newCan.setCanskills5value(Integer.parseInt(jSpinnerCanSkillValue5.getValue().toString()));
        newCan.setCancomptency1value(Integer.parseInt(jSpinnerCanCompValue1.getValue().toString()));
        newCan.setCancomptency2value(Integer.parseInt(jSpinnerCanCompValue2.getValue().toString()));
        newCan.setCancomptency3value(Integer.parseInt(jSpinnerCanCompValue3.getValue().toString()));
        newCan.setCancomptency4value(Integer.parseInt(jSpinnerCanCompValue4.getValue().toString()));
        newCan.setCancomptency5value(Integer.parseInt(jSpinnerCanCompValue5.getValue().toString()));
        newCan.setCanjobID(0);
        newCan.setCanprocessed(1);
        candidatesData.add(newCan);
    }                                             

    private void jCheckBoxCanReallocation1ActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(!candidatesData.isEmpty())
            candidatesDataChanged++;
        else
            jobsDataChanged++;
        
        // TODO add your handling code here:
        updateEvent = evt;
        if( !jobsData.isEmpty() ){
            jobsData.get(index).setJobCat(getComboValue(jobsCatData, jComboBoxJobCat.getSelectedItem().toString()));
            jobsData.get(index).setJobSubCat(getComboValue(jobsSubCatData, jComboBoxJobSubCat.getSelectedItem().toString()));
            jobsData.get(index).setJobTitle(jTextFieldJobTitle.getText());
            jobsData.get(index).setMinSalary(Integer.parseInt(jTextFieldMinSalary.getText()));
            jobsData.get(index).setMaxSalary(Integer.parseInt(jTextFieldMaxSalary.getText()));
            jobsData.get(index).setReallocation(jCheckBoxReallocation.isSelected());
            jobsData.get(index).setTravel(jCheckBoxTravel.isSelected());
            jobsData.get(index).setDriving(jCheckBoxDriving.isSelected());
            jobsData.get(index).setInterview(Integer.parseInt(jSpinnerinterview.getValue().toString()));
            jobsData.get(index).setMajor1(getComboValue(majorsData, jComboBoxMajor1.getSelectedItem().toString()));
            jobsData.get(index).setMajor2(getComboValue(majorsData, jComboBoxMajor2.getSelectedItem().toString()));
            jobsData.get(index).setMajor3(getComboValue(majorsData, jComboBoxMajor3.getSelectedItem().toString()));
            jobsData.get(index).setMajor4(getComboValue(majorsData, jComboBoxMajor4.getSelectedItem().toString()));
            jobsData.get(index).setMajor5(getComboValue(majorsData, jComboBoxMajor5.getSelectedItem().toString()));
            jobsData.get(index).setSkillCat1(getComboValue(skillCatData, jComboSkillsCat1.getSelectedItem().toString()));
            jobsData.get(index).setSkillCat2(getComboValue(skillCatData, jComboSkillsCat2.getSelectedItem().toString()));
            jobsData.get(index).setSkillCat3(getComboValue(skillCatData, jComboSkillsCat3.getSelectedItem().toString()));
            jobsData.get(index).setSkillCat4(getComboValue(skillCatData, jComboSkillsCat4.getSelectedItem().toString()));
            jobsData.get(index).setSkillCat5(getComboValue(skillCatData, jComboSkillsCat5.getSelectedItem().toString()));
            jobsData.get(index).setSkill2(getComboValue(skillData, jComboSkills2.getSelectedItem().toString()));
            jobsData.get(index).setSkill3(getComboValue(skillData, jComboSkills3.getSelectedItem().toString()));
            jobsData.get(index).setSkill4(getComboValue(skillData, jComboSkills4.getSelectedItem().toString()));
            jobsData.get(index).setSkill5(getComboValue(skillData, jComboSkills5.getSelectedItem().toString()));
            jobsData.get(index).setCompCat1(getComboValue(compCatData, jComboBoxCompCat1.getSelectedItem().toString()));
            jobsData.get(index).setCompCat2(getComboValue(compCatData, jComboBoxCompCat2.getSelectedItem().toString()));
            jobsData.get(index).setCompCat3(getComboValue(compCatData, jComboBoxCompCat3.getSelectedItem().toString()));
            jobsData.get(index).setCompCat4(getComboValue(compCatData, jComboBoxCompCat4.getSelectedItem().toString()));
            jobsData.get(index).setCompCat5(getComboValue(compCatData, jComboBoxCompCat5.getSelectedItem().toString()));
            jobsData.get(index).setComp1(getComboValue(compData, jComboBoxComp1.getSelectedItem().toString()));
            jobsData.get(index).setComp2(getComboValue(compData, jComboBoxComp2.getSelectedItem().toString()));
            jobsData.get(index).setComp3(getComboValue(compData, jComboBoxComp3.getSelectedItem().toString()));
            jobsData.get(index).setComp4(getComboValue(compData, jComboBoxComp4.getSelectedItem().toString()));
            jobsData.get(index).setComp5(getComboValue(compData, jComboBoxComp5.getSelectedItem().toString()));
            jobsData.get(index).setSkillValue1(Integer.parseInt(jSpinnerskill1.getValue().toString()));
            jobsData.get(index).setSkillValue2(Integer.parseInt(jSpinnerskill2.getValue().toString()));
            jobsData.get(index).setSkillValue3(Integer.parseInt(jSpinnerskill3.getValue().toString()));
            jobsData.get(index).setSkillValue4(Integer.parseInt(jSpinnerskill4.getValue().toString()));
            jobsData.get(index).setSkillValue5(Integer.parseInt(jSpinnerskill5.getValue().toString()));
            jobsData.get(index).setCompValue1(Integer.parseInt(jSpinnercomp1.getValue().toString()));
            jobsData.get(index).setCompValue2(Integer.parseInt(jSpinnercomp2.getValue().toString()));
            jobsData.get(index).setCompValue3(Integer.parseInt(jSpinnercomp3.getValue().toString()));
            jobsData.get(index).setCompValue4(Integer.parseInt(jSpinnercomp4.getValue().toString()));
            jobsData.get(index).setCompValue5(Integer.parseInt(jSpinnercomp5.getValue().toString()));
        }
        else
            clearVacantJobsComponents();
    }                                      

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        jButtonNextEvent = evt;
        if (index < jobsData.size() -1) {
            index++;
            displayJobsData();
        }
    }                                           

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        jButtonPrevEvent = evt;
        if (index > 0) {
            index--;
            displayJobsData();
        }
    }                                           

    private void jComboSkillsCat1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jComboSkillsCat1ItemStateChanged(java.awt.event.ItemEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jComboBoxJobCatActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Jobs max = Collections.max(jobsData, Comparator.comparing(s -> s.getJobID()));
        jTextFieldJobID1.setText(Integer.toString(max.getJobID() + 1));

        Jobs newJob = new Jobs();
        newJob.setJobID(Integer.parseInt(jTextFieldJobID1.getText()));
        newJob.setJobCat(getComboValue(jobsCatData, jComboBoxJobCat1.getSelectedItem().toString()));
        newJob.setJobSubCat(getComboValue(jobsSubCatData, jComboBoxJobSubCat1.getSelectedItem().toString()));
        newJob.setJobTitle(jTextFieldJobTitle1.getText());
        newJob.setStatus(1);
        newJob.setMinSalary(Integer.parseInt(jTextFieldMinSalary1.getText()));
        newJob.setMaxSalary(Integer.parseInt(jTextFieldMaxSalary1.getText()));
        newJob.setReallocation(jCheckBoxReallocation1.isSelected());
        newJob.setTravel(jCheckBoxTravel1.isSelected());
        newJob.setDriving(jCheckBoxDriving1.isSelected());
        newJob.setInterview(Integer.parseInt(jSpinnerinterview1.getValue().toString()));
        newJob.setMajor1(getComboValue(majorsData, jComboBoxMajor6.getSelectedItem().toString()));
        newJob.setMajor2(getComboValue(majorsData, jComboBoxMajor7.getSelectedItem().toString()));
        newJob.setMajor3(getComboValue(majorsData, jComboBoxMajor8.getSelectedItem().toString()));
        newJob.setMajor4(getComboValue(majorsData, jComboBoxMajor9.getSelectedItem().toString()));
        newJob.setMajor5(getComboValue(majorsData, jComboBoxMajor10.getSelectedItem().toString()));
        newJob.setSkillCat1(getComboValue(skillCatData, jComboSkillsCat6.getSelectedItem().toString()));
        newJob.setSkillCat2(getComboValue(skillCatData, jComboSkillsCat7.getSelectedItem().toString()));
        newJob.setSkillCat3(getComboValue(skillCatData, jComboSkillsCat8.getSelectedItem().toString()));
        newJob.setSkillCat4(getComboValue(skillCatData, jComboSkillsCat9.getSelectedItem().toString()));
        newJob.setSkillCat5(getComboValue(skillCatData, jComboSkillsCat10.getSelectedItem().toString()));
        newJob.setSkill1(getComboValue(skillData, jComboSkills6.getSelectedItem().toString()));
        newJob.setSkill2(getComboValue(skillData, jComboSkills7.getSelectedItem().toString()));
        newJob.setSkill3(getComboValue(skillData, jComboSkills8.getSelectedItem().toString()));
        newJob.setSkill4(getComboValue(skillData, jComboSkills9.getSelectedItem().toString()));
        newJob.setSkill5(getComboValue(skillData, jComboSkills10.getSelectedItem().toString()));
        newJob.setCompCat1(getComboValue(compCatData, jComboBoxCompCat6.getSelectedItem().toString()));
        newJob.setCompCat2(getComboValue(compCatData, jComboBoxCompCat7.getSelectedItem().toString()));
        newJob.setCompCat3(getComboValue(compCatData, jComboBoxCompCat8.getSelectedItem().toString()));
        newJob.setCompCat4(getComboValue(compCatData, jComboBoxCompCat9.getSelectedItem().toString()));
        newJob.setCompCat5(getComboValue(compCatData, jComboBoxCompCat10.getSelectedItem().toString()));
        newJob.setComp1(getComboValue(compData, jComboBoxComp6.getSelectedItem().toString()));
        newJob.setComp2(getComboValue(compData, jComboBoxComp7.getSelectedItem().toString()));
        newJob.setComp3(getComboValue(compData, jComboBoxComp8.getSelectedItem().toString()));
        newJob.setComp4(getComboValue(compData, jComboBoxComp9.getSelectedItem().toString()));
        newJob.setComp5(getComboValue(compData, jComboBoxComp10.getSelectedItem().toString()));
        newJob.setSkillValue1(Integer.parseInt(jSpinnerSkillValue6.getValue().toString()));
        newJob.setSkillValue2(Integer.parseInt(jSpinnerSkillValue7.getValue().toString()));
        newJob.setSkillValue3(Integer.parseInt(jSpinnerSkillValue8.getValue().toString()));
        newJob.setSkillValue4(Integer.parseInt(jSpinnerSkillValue9.getValue().toString()));
        newJob.setSkillValue5(Integer.parseInt(jSpinnerSkillValue10.getValue().toString()));
        newJob.setCompValue1(Integer.parseInt(jSpinnerSkillValue6.getValue().toString()));
        newJob.setCompValue2(Integer.parseInt(jSpinnerSkillValue7.getValue().toString()));
        newJob.setCompValue3(Integer.parseInt(jSpinnerSkillValue8.getValue().toString()));
        newJob.setCompValue4(Integer.parseInt(jSpinnerSkillValue9.getValue().toString()));
        newJob.setCompValue5(Integer.parseInt(jSpinnerSkillValue10.getValue().toString()));        
        jobsData.add(newJob);
        index += 1;
    }                                           

    private void jComboBoxJobCat1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jComboBoxJobCat1ItemStateChanged(java.awt.event.ItemEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jTextFieldJobTitle1KeyPressed(java.awt.event.KeyEvent evt) {                                               
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
            jTextFieldJobTitle1.setEditable(true);
        } else {
            jTextFieldJobTitle1.setEditable(false);
        }
    }                                              

    private void jButtonSaveExitActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
                SaveJobsToCSV();
                SaveCandidatesToCSV();
                SaveLookupsToCSV();
                UserTypePage yesObj = new UserTypePage("AJCSS");
                yesObj.setVisible(true);
                setVisible(false);
    }                                               

    private void SaveCandidatesToCSV() {
        File file = new File("C:/AJCSS/candidates.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            // Clear file content to avoid duplication issue.
            PrintWriter pWriter = new PrintWriter(file);
            pWriter.write("");
            
            for (int i = 0; i < candidatesData.size(); i++) {
                bw.write(candidatesData.get(i).getCanid() + ",");
                bw.write(candidatesData.get(i).getCanname() + ",");
                bw.write(candidatesData.get(i).getCanbirth() + ",");
                bw.write(candidatesData.get(i).getCaneducation() + ",");
                bw.write(candidatesData.get(i).getCanmajor() + ",");
                bw.write(candidatesData.get(i).getCangrade() + ",");
                bw.write(candidatesData.get(i).getCangpa() + ",");
                bw.write(candidatesData.get(i).getCompany() + ",");
                bw.write(candidatesData.get(i).getPosition() + ",");
                bw.write(candidatesData.get(i).getCanyearsexp() + ",");
                bw.write(candidatesData.get(i).getCaninterviewscore() + ",");
                bw.write(candidatesData.get(i).getCanemail() + ",");
                bw.write(candidatesData.get(i).getCanphone() + ",");
                bw.write(candidatesData.get(i).getCanSalary() + ",");
                bw.write(candidatesData.get(i).getCangender() + ",");
                bw.write(candidatesData.get(i).getCanreallocation() + ",");
                bw.write(candidatesData.get(i).getCantravel() + ",");
                bw.write(candidatesData.get(i).getCandriving() + ",");
                bw.write(candidatesData.get(i).getCanaddress() + ",");
                bw.write(candidatesData.get(i).getCancity() + ",");
                bw.write(candidatesData.get(i).getCancountry() + ",");
                bw.write(candidatesData.get(i).getCanskills1cat() + ",");
                bw.write(candidatesData.get(i).getCanskills1() + ",");
                bw.write(candidatesData.get(i).getCanskills1value() + ",");
                bw.write(candidatesData.get(i).getCanskills2cat() + ",");
                bw.write(candidatesData.get(i).getCanskills2() + ",");
                bw.write(candidatesData.get(i).getCanskills2value() + ",");
                bw.write(candidatesData.get(i).getCanskills3cat() + ",");
                bw.write(candidatesData.get(i).getCanskills3() + ",");
                bw.write(candidatesData.get(i).getCanskills3value() + ",");
                bw.write(candidatesData.get(i).getCanskills4cat() + ",");
                bw.write(candidatesData.get(i).getCanskills4() + ",");
                bw.write(candidatesData.get(i).getCanskills4value() + ",");
                bw.write(candidatesData.get(i).getCanskills5cat() + ",");
                bw.write(candidatesData.get(i).getCanskills5() + ",");
                bw.write(candidatesData.get(i).getCanskills5value() + ",");
                bw.write(candidatesData.get(i).getCancomptency1cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency1() + ",");
                bw.write(candidatesData.get(i).getCancomptency1value() + ",");
                bw.write(candidatesData.get(i).getCancomptency2cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency2() + ",");
                bw.write(candidatesData.get(i).getCancomptency2value() + ",");
                bw.write(candidatesData.get(i).getCancomptency3cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency3() + ",");
                bw.write(candidatesData.get(i).getCancomptency3value() + ",");
                bw.write(candidatesData.get(i).getCancomptency4cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency4() + ",");
                bw.write(candidatesData.get(i).getCancomptency4value() + ",");
                bw.write(candidatesData.get(i).getCancomptency5cat() + ",");
                bw.write(candidatesData.get(i).getCancomptency5() + ",");
                bw.write(candidatesData.get(i).getCancomptency5value() + ",");
                bw.write(candidatesData.get(i).getCanjobID() + ",");
                bw.write(candidatesData.get(i).getCanprocessed() + "\n");
            }
            bw.close();
            fw.close();
            pWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(AJCSS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SaveJobsToCSV() {
        File file = new File("C:/AJCSS/Jobs.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            // Clear file content to avoid duplication issue.
            PrintWriter pWriter = new PrintWriter(file);
            pWriter.write("");            
            
            for (int i = 0; i < jobsData.size(); i++) {
                bw.write(jobsData.get(i).getJobID() + ",");
                bw.write(jobsData.get(i).getJobCat() + ",");
                bw.write(jobsData.get(i).getJobSubCat() + ",");
                bw.write(jobsData.get(i).getJobSubCat() + ",");
                bw.write(jobsData.get(i).getJobTitle() + ",");
                bw.write(jobsData.get(i).getStatus() + ",");
                bw.write(jobsData.get(i).getEducation() + ",");
                bw.write(jobsData.get(i).getMinSalary() + ",");
                bw.write(jobsData.get(i).getMaxSalary() + ",");
                bw.write(jobsData.get(i).isReallocation() + ",");
                bw.write(jobsData.get(i).isDriving() + ",");
                bw.write(jobsData.get(i).getExpYears() + ",");
                bw.write(jobsData.get(i).isTravel() + ",");
                bw.write(jobsData.get(i).getInterview() + ",");
                bw.write(jobsData.get(i).getGender() + ",");
                bw.write(jobsData.get(i).getMajor1() + ",");
                bw.write(jobsData.get(i).getMajor2() + ",");
                bw.write(jobsData.get(i).getMajor3() + ",");
                bw.write(jobsData.get(i).getMajor4() + ",");
                bw.write(jobsData.get(i).getMajor5() + ",");
                bw.write(jobsData.get(i).getSkillCat1() + ",");
                bw.write(jobsData.get(i).getSkillCat2() + ",");
                bw.write(jobsData.get(i).getSkillCat3() + ",");
                bw.write(jobsData.get(i).getSkillCat4() + ",");
                bw.write(jobsData.get(i).getSkillCat5() + ",");
                bw.write(jobsData.get(i).getSkill1() + ",");
                bw.write(jobsData.get(i).getSkill2() + ",");
                bw.write(jobsData.get(i).getSkill3() + ",");
                bw.write(jobsData.get(i).getSkill4() + ",");
                bw.write(jobsData.get(i).getSkill5() + ",");
                bw.write(jobsData.get(i).getSkillValue1() + ",");
                bw.write(jobsData.get(i).getSkillValue2() + ",");
                bw.write(jobsData.get(i).getSkillValue3() + ",");
                bw.write(jobsData.get(i).getSkillValue4() + ",");
                bw.write(jobsData.get(i).getSkillValue5() + ",");
                bw.write(jobsData.get(i).getCompCat1() + ",");
                bw.write(jobsData.get(i).getCompCat2() + ",");
                bw.write(jobsData.get(i).getCompCat3() + ",");
                bw.write(jobsData.get(i).getCompCat4() + ",");
                bw.write(jobsData.get(i).getCompCat5() + ",");
                bw.write(jobsData.get(i).getComp1() + ",");
                bw.write(jobsData.get(i).getComp2() + ",");
                bw.write(jobsData.get(i).getComp3() + ",");
                bw.write(jobsData.get(i).getComp4() + ",");
                bw.write(jobsData.get(i).getComp5() + ",");
                bw.write(jobsData.get(i).getCompValue1() + ",");
                bw.write(jobsData.get(i).getCompValue2() + ",");
                bw.write(jobsData.get(i).getCompValue3() + ",");
                bw.write(jobsData.get(i).getCompValue4() + ",");
                bw.write(jobsData.get(i).getCompValue5() + "\n");
            }
            bw.close();
            fw.close();
            pWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(AJCSS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveLookupToCSV(String LookupFile, ArrayList<Lookup> List) {
        File file = new File("C:/AJCSS/" + LookupFile);
        FileWriter fw;
        try {
            fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            // Clear file content to avoid duplication issue.
            PrintWriter pWriter = new PrintWriter(file);
            pWriter.write("");
            
            for (int i = 0; i < List.size(); i++) {
                bw.write(List.get(i).getCode() + ":");
                bw.write(List.get(i).getDesc() + "\n");
            }
            bw.close();
            fw.close();
            pWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(AJCSS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SaveLookupsToCSV() {
        saveLookupToCSV("education1.CSV", educatioData);
        saveLookupToCSV("jobcat1.csv", jobsCatData);
        saveLookupToCSV("jobsubcat1.csv", jobsSubCatData);
        saveLookupToCSV("job-groups1.csv", jobsGroupData);
        saveLookupToCSV("majors1.csv", majorsData);
        saveLookupToCSV("skills-cat1.csv", skillCatData);
        saveLookupToCSV("skills1.csv", skillData);
        saveLookupToCSV("competencies-cat1.csv", compCatData);
        saveLookupToCSV("competency1.csv", compData);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AJCSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AJCSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AJCSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AJCSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AJCSS().setVisible(true);
                dataNavigation();
            }
        });
    }

    public static void dataNavigation() {
        getJobsData();
        getCandidateData();
        getLookupData("education.csv", educatioData);
        getLookupData("jobcat.csv", jobsCatData);
        getLookupData("jobsubcat.csv", jobsSubCatData);
        getLookupData("job-groups.csv", jobsGroupData);
        getLookupData("majors.csv", majorsData);
        getLookupData("skills-cat.csv", skillCatData);
        getLookupData("skills.csv", skillData);
        getLookupData("competencies-cat.csv", compCatData);
        getLookupData("competency.csv", compData);
        initializeJobandCandidateData();
        displayJobsData();
        displayCandidatesData();
        getJobsForMatching();
    }

    public static void initializeJobandCandidateData() {

        jTextFieldJobTitle1.setText("");
        jTextFieldMinSalary1.setText("0");
        jTextFieldMaxSalary1.setText("0");
        jTextFieldYearsOfExp1.setText("0");
        comboFill(jComboBoxMajor6, majorsData);
        comboFill(jComboBoxMajor7, majorsData);
        comboFill(jComboBoxMajor8, majorsData);
        comboFill(jComboBoxMajor9, majorsData);
        comboFill(jComboBoxMajor10, majorsData);
        comboFill(jComboSkillsCat6, skillCatData);
        comboFill(jComboSkillsCat7, skillCatData);
        comboFill(jComboSkillsCat8, skillCatData);
        comboFill(jComboSkillsCat9, skillCatData);
        comboFill(jComboSkillsCat10, skillCatData);
        comboFill(jComboSkills6, skillData);
        comboFill(jComboSkills7, skillData);
        comboFill(jComboSkills8, skillData);
        comboFill(jComboSkills9, skillData);
        comboFill(jComboSkills10, skillData);
        comboFill(jComboBoxCompCat6, compCatData);
        comboFill(jComboBoxCompCat7, compCatData);
        comboFill(jComboBoxCompCat8, compCatData);
        comboFill(jComboBoxCompCat9, compCatData);
        comboFill(jComboBoxCompCat10, compCatData);
        comboFill(jComboBoxComp6, compData);
        comboFill(jComboBoxComp7, compData);
        comboFill(jComboBoxComp8, compData);
        comboFill(jComboBoxComp9, compData);
        comboFill(jComboBoxComp10, compData);
        comboFill(jComboBoxCanEducation, educatioData);
        comboFill(jComboBoxCanMajor, majorsData);
        comboFill(jComboBoxCanEducation1, educatioData);
        comboFill(jComboBoxCanMajor1, majorsData);
        comboFill(jComboBoxCanSkillCat1, skillCatData);
        comboFill(jComboBoxCanSkillCat2, skillCatData);
        comboFill(jComboBoxCanSkillCat3, skillCatData);
        comboFill(jComboBoxCanSkillCat4, skillCatData);
        comboFill(jComboBoxCanSkillCat5, skillCatData);
        comboFill(jComboBoxCanSkillCat6, skillCatData);
        comboFill(jComboBoxCanSkillCat7, skillCatData);
        comboFill(jComboBoxCanSkillCat8, skillCatData);
        comboFill(jComboBoxCanSkillCat9, skillCatData);
        comboFill(jComboBoxCanSkillCat10, skillCatData);
        comboFill(jComboBoxCanSkill1, skillData);
        comboFill(jComboBoxCanSkill5, skillData);
        comboFill(jComboBoxCanSkill2, skillData);
        comboFill(jComboBoxCanSkill3, skillData);
        comboFill(jComboBoxCanSkill4, skillData);
        comboFill(jComboBoxCanSkill6, skillData);
        comboFill(jComboBoxCanSkill7, skillData);
        comboFill(jComboBoxCanSkill8, skillData);
        comboFill(jComboBoxCanSkill9, skillData);
        comboFill(jComboBoxCanSkill10, skillData);
        comboFill(jComboBoxCanCompCat1, compCatData);
        comboFill(jComboBoxCanCompCat2, compCatData);
        comboFill(jComboBoxCanCompCat3, compCatData);
        comboFill(jComboBoxCanCompCat4, compCatData);
        comboFill(jComboBoxCanCompCat5, compCatData);
        comboFill(jComboBoxCanCompCat6, compCatData);
        comboFill(jComboBoxCanCompCat7, compCatData);
        comboFill(jComboBoxCanCompCat8, compCatData);
        comboFill(jComboBoxCanCompCat9, compCatData);
        comboFill(jComboBoxCanCompCat10, compCatData);
        comboFill(jComboBoxCanComp1, compData);
        comboFill(jComboBoxCanComp2, compData);
        comboFill(jComboBoxCanComp3, compData);
        comboFill(jComboBoxCanComp4, compData);
        comboFill(jComboBoxCanComp5, compData);
        comboFill(jComboBoxCanComp6, compData);
        comboFill(jComboBoxCanComp7, compData);
        comboFill(jComboBoxCanComp8, compData);
        comboFill(jComboBoxCanComp9, compData);
        comboFill(jComboBoxCanComp10, compData);
        comboFill(jComboBoxJobCat, jobsCatData);
        comboFill(jComboBoxJobSubCat, jobsSubCatData);
        comboFill(jComboBoxEducation, educatioData);
        comboFill(jComboBoxJobEducation1, educatioData);
        comboFill(jComboBoxMajor1, majorsData);
        comboFill(jComboBoxMajor2, majorsData);
        comboFill(jComboBoxMajor3, majorsData);
        comboFill(jComboBoxMajor4, majorsData);
        comboFill(jComboBoxMajor5, majorsData);
        comboFill(jComboSkillsCat1, skillCatData);
        comboFill(jComboSkillsCat2, skillCatData);
        comboFill(jComboSkillsCat3, skillCatData);
        comboFill(jComboSkillsCat4, skillCatData);
        comboFill(jComboSkillsCat5, skillCatData);
        comboFill(jComboSkills1, skillData);
        comboFill(jComboSkills2, skillData);
        comboFill(jComboSkills3, skillData);
        comboFill(jComboSkills4, skillData);
        comboFill(jComboSkills5, skillData);
        comboFill(jComboBoxCompCat1, compCatData);
        comboFill(jComboBoxCompCat2, compCatData);
        comboFill(jComboBoxCompCat3, compCatData);
        comboFill(jComboBoxCompCat4, compCatData);
        comboFill(jComboBoxCompCat5, compCatData);
        comboFill(jComboBoxComp1, compData);
        comboFill(jComboBoxComp2, compData);
        comboFill(jComboBoxComp3, compData);
        comboFill(jComboBoxComp4, compData);
        comboFill(jComboBoxComp5, compData);
        comboFill(jComboBoxJobCat1, jobsCatData);
        comboFill(jComboBoxJobSubCat1, jobsSubCatData);
    }

    public static void displayCandidatesData() {

        if (canindex >= 0 && canindex < candidatesData.size()) {
            jTextFieldCandidateID.setText(Integer.toString(candidatesData.get(canindex).getCanid()));
            jTextFieldCandidateID.setText(Integer.toString(candidatesData.get(canindex).getCanid()));
            jTextFieldCandidateID.setText(Integer.toString(candidatesData.get(canindex).getCanid()));
            jTextFieldCanAddress.setText((candidatesData.get(canindex).getCanaddress()));
            jComboBoxCanEducation.setSelectedIndex(getComboIndex(educatioData, candidatesData.get(canindex).getCaneducation()));
            jComboBoxCanMajor.setSelectedIndex(getComboIndex(majorsData, candidatesData.get(canindex).getCanmajor()));
            jComboBoxCanGrade.setSelectedIndex(getGradeComboValue(gradeData, candidatesData.get(canindex).getCangrade()));
            jTextFieldCanCompany.setText((candidatesData.get(canindex).getCompany()));

jTextFieldCanBirthDate.setText((candidatesData.get(canindex).getCanbirth()));
            jTextFieldCanCountry.setText((candidatesData.get(canindex).getCancountry()));
            jTextFieldCanEmail.setText(candidatesData.get(canindex).getCanemail());
            jTextFieldCanExpYears.setText(Integer.toString(candidatesData.get(canindex).getCanyearsexp()));
            jTextFieldCanGPA.setText(Double.toString(candidatesData.get(canindex).getCangpa()));
            jTextFieldCanName.setText((candidatesData.get(canindex).getCanname()));
            jTextFieldCanPhone.setText((candidatesData.get(canindex).getCanphone()));
            jTextFieldCanPosition.setText((candidatesData.get(canindex).getPosition()));
            jTextFieldCanSalary.setText(Integer.toString(candidatesData.get(canindex).getCanSalary()));
            jCheckBoxCanReallocation.setSelected(candidatesData.get(canindex).getCanreallocation());
            jCheckBoxCanTravel.setSelected(candidatesData.get(canindex).getCantravel());
            jCheckBoxCanDriving.setSelected(candidatesData.get(canindex).getCandriving());
            jComboBoxCanSkillCat1.setSelectedIndex(getComboIndex(skillCatData, candidatesData.get(canindex).getCanskills1cat()));
            jComboBoxCanSkillCat2.setSelectedIndex(getComboIndex(skillCatData, candidatesData.get(canindex).getCanskills2cat()));
            jComboBoxCanSkillCat3.setSelectedIndex(getComboIndex(skillCatData, candidatesData.get(canindex).getCanskills3cat()));
            jComboBoxCanSkillCat4.setSelectedIndex(getComboIndex(skillCatData, candidatesData.get(canindex).getCanskills4cat()));
            jComboBoxCanSkillCat5.setSelectedIndex(getComboIndex(skillCatData, candidatesData.get(canindex).getCanskills5cat()));
            jComboBoxCanSkill1.setSelectedIndex(getComboIndex(skillData, candidatesData.get(canindex).getCanskills1()));
            jComboBoxCanSkill2.setSelectedIndex(getComboIndex(skillData, candidatesData.get(canindex).getCanskills2()));
            jComboBoxCanSkill3.setSelectedIndex(getComboIndex(skillData, candidatesData.get(canindex).getCanskills3()));
            jComboBoxCanSkill4.setSelectedIndex(getComboIndex(skillData, candidatesData.get(canindex).getCanskills4()));
            jComboBoxCanSkill5.setSelectedIndex(getComboIndex(skillData, candidatesData.get(canindex).getCanskills5()));
            jComboBoxCanCompCat1.setSelectedIndex(getComboIndex(compCatData, candidatesData.get(canindex).getCancomptency1cat()));
            jComboBoxCanCompCat2.setSelectedIndex(getComboIndex(compCatData, candidatesData.get(canindex).getCancomptency2cat()));
            jComboBoxCanCompCat3.setSelectedIndex(getComboIndex(compCatData, candidatesData.get(canindex).getCancomptency3cat()));
            jComboBoxCanCompCat4.setSelectedIndex(getComboIndex(compCatData, candidatesData.get(canindex).getCancomptency4cat()));
            jComboBoxCanCompCat5.setSelectedIndex(getComboIndex(compCatData, candidatesData.get(canindex).getCancomptency5cat()));
            jComboBoxCanComp1.setSelectedIndex(getComboIndex(compData, candidatesData.get(canindex).getCancomptency1()));
            jComboBoxCanComp2.setSelectedIndex(getComboIndex(compData, candidatesData.get(canindex).getCancomptency2()));
            jComboBoxCanComp3.setSelectedIndex(getComboIndex(compData, candidatesData.get(canindex).getCancomptency3()));
            jComboBoxCanComp4.setSelectedIndex(getComboIndex(compData, candidatesData.get(canindex).getCancomptency4()));
            jComboBoxCanComp5.setSelectedIndex(getComboIndex(compData, candidatesData.get(canindex).getCancomptency5()));
            jSpinnerCanCompValue1.setValue((candidatesData.get(canindex).getCancomptency1value()));
            jSpinnerCanCompValue2.setValue((candidatesData.get(canindex).getCancomptency2value()));
            jSpinnerCanCompValue3.setValue((candidatesData.get(canindex).getCancomptency3value()));
            jSpinnerCanCompValue4.setValue((candidatesData.get(canindex).getCancomptency4value()));
            jSpinnerCanCompValue5.setValue((candidatesData.get(canindex).getCancomptency5value()));
            if (candidatesData.get(canindex).getCangender() == 1) {
                jRadioButtonMale.setSelected(true);
                jRadioButtonFemale.setSelected(false);
            } else {
                jRadioButtonMale.setSelected(false);
                jRadioButtonFemale.setSelected(true);
            }
            jSpinnerCanInterviewScore.setValue((candidatesData.get(canindex).getCaninterviewscore()));
            
            jSpinnerCanSkillValue1.setValue((candidatesData.get(canindex).getCanskills1value()));
            jSpinnerCanSkillValue2.setValue((candidatesData.get(canindex).getCanskills2value()));
            jSpinnerCanSkillValue3.setValue((candidatesData.get(canindex).getCanskills3value()));
            jSpinnerCanSkillValue4.setValue((candidatesData.get(canindex).getCanskills4value()));
            jSpinnerCanSkillValue5.setValue((candidatesData.get(canindex).getCanskills5value()));
        }
    }

    public static void displayJobsData() {
        if (index >= 0 && index < jobsData.size()) {

            jTextFieldJobID.setText(Integer.toString(jobsData.get(index).getJobID()));
            jTextFieldJobTitle.setText(jobsData.get(index).getJobTitle());
            jSpinnerinterview.setValue((jobsData.get(index).getInterview()));
            jTextFieldMinSalary.setText(Integer.toString(jobsData.get(index).getMinSalary()));
            jTextFieldMaxSalary.setText(Integer.toString(jobsData.get(index).getMaxSalary()));
            jSpinnerexp.setValue((jobsData.get(index).getExpYears()));
            jSpinnerskill1.setValue((jobsData.get(index).getSkillValue1()));
            jSpinnerskill2.setValue((jobsData.get(index).getSkillValue2()));
            jSpinnerskill3.setValue((jobsData.get(index).getSkillValue3()));
            jSpinnerskill4.setValue((jobsData.get(index).getSkillValue4()));
            jSpinnerskill5.setValue((jobsData.get(index).getSkillValue5()));
            jSpinnercomp1.setValue((jobsData.get(index).getCompValue1()));
            jSpinnercomp2.setValue((jobsData.get(index).getCompValue2()));
            jSpinnercomp3.setValue((jobsData.get(index).getCompValue3()));
            jSpinnercomp4.setValue((jobsData.get(index).getCompValue4()));
            jSpinnercomp5.setValue((jobsData.get(index).getCompValue5()));
            jCheckBoxReallocation.setSelected(jobsData.get(index).isReallocation());
            jCheckBoxTravel.setSelected(jobsData.get(index).isTravel());
            jCheckBoxDriving.setSelected(jobsData.get(index).isDriving());
            jComboBoxJobCat.setSelectedIndex(getComboIndex(jobsCatData, jobsData.get(index).getJobCat()));
            jComboBoxJobSubCat.setSelectedIndex(getComboIndex(jobsSubCatData, jobsData.get(index).getJobSubCat()));
            jComboBoxEducation.setSelectedIndex(getComboIndex(educatioData, jobsData.get(index).getEducation()));
            jComboBoxMajor1.setSelectedIndex(getComboIndex(majorsData, jobsData.get(index).getMajor1()));
            jComboBoxMajor2.setSelectedIndex(getComboIndex(majorsData, jobsData.get(index).getMajor2()));
            jComboBoxMajor3.setSelectedIndex(getComboIndex(majorsData, jobsData.get(index).getMajor3()));
            jComboBoxMajor4.setSelectedIndex(getComboIndex(majorsData, jobsData.get(index).getMajor4()));
            jComboBoxMajor5.setSelectedIndex(getComboIndex(majorsData, jobsData.get(index).getMajor5()));
            jComboSkillsCat1.setSelectedIndex(getComboIndex(skillCatData, jobsData.get(index).getSkillCat1()));
            jComboSkillsCat2.setSelectedIndex(getComboIndex(skillCatData, jobsData.get(index).getSkillCat2()));
            jComboSkillsCat3.setSelectedIndex(getComboIndex(skillCatData, jobsData.get(index).getSkillCat3()));
            jComboSkillsCat4.setSelectedIndex(getComboIndex(skillCatData, jobsData.get(index).getSkillCat4()));
            jComboSkillsCat5.setSelectedIndex(getComboIndex(skillCatData, jobsData.get(index).getSkillCat5()));
            jComboSkills2.setSelectedIndex(getComboIndex(skillData, jobsData.get(index).getSkill2()));
            jComboSkills3.setSelectedIndex(getComboIndex(skillData, jobsData.get(index).getSkill3()));
            jComboSkills4.setSelectedIndex(getComboIndex(skillData, jobsData.get(index).getSkill4()));
            jComboSkills5.setSelectedIndex(getComboIndex(skillData, jobsData.get(index).getSkill5()));
            jComboBoxCompCat1.setSelectedIndex(getComboIndex(compCatData, jobsData.get(index).getCompCat1()));
            jComboBoxCompCat2.setSelectedIndex(getComboIndex(compCatData, jobsData.get(index).getCompCat2()));
            jComboBoxCompCat3.setSelectedIndex(getComboIndex(compCatData, jobsData.get(index).getCompCat3()));
            jComboBoxCompCat4.setSelectedIndex(getComboIndex(compCatData, jobsData.get(index).getCompCat4()));
            jComboBoxCompCat5.setSelectedIndex(getComboIndex(compCatData, jobsData.get(index).getCompCat5()));
            jComboBoxComp1.setSelectedIndex(getComboIndex(compData, jobsData.get(index).getComp1()));
            jComboBoxComp2.setSelectedIndex(getComboIndex(compData, jobsData.get(index).getComp2()));
            jComboBoxComp3.setSelectedIndex(getComboIndex(compData, jobsData.get(index).getComp3()));
            jComboBoxComp4.setSelectedIndex(getComboIndex(compData, jobsData.get(index).getComp4()));
            jComboBoxComp5.setSelectedIndex(getComboIndex(compData, jobsData.get(index).getComp5()));
        }
    }

    public static void getJobsForMatching() {
        String[] columnsName = {"Seq", "Job ID", "Job Title"};
        DefaultTableModel model = (DefaultTableModel) jTableJobs.getModel();
        model.setColumnIdentifiers(columnsName);
        for (int i = 0; i < jobsData.size(); i++) {
            int j = jobsData.get(i).getJobID();
            String s = jobsData.get(i).getJobTitle();
            Object[] dataRow = {i, j, s};
            model.addRow(dataRow);
        }
    }

    public static int getUnprocesssedCount() {
        canindexCount = 0;
        for (int i = 0; i < candidatesData.size(); i++) {
            if (candidatesData.get(i).getCanprocessed() == 1) {
                canindexCount = +1;
            }
        }
        return canindexCount;
    }

    public static String getLookupDesc(ArrayList<Lookup> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).getDesc();
            if (list.get(i).getCode() == key) {
                return s;
            }
        }
        return null;
    }

    public static int getComboValue(ArrayList<Lookup> list, String value) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).getDesc();
            if (list.get(i).getDesc().equals(value)) {
                return list.get(i).getCode();
            }
        }
        return 1;
    }

    public static int getComboIndex(ArrayList<Lookup> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode() == key) {
                return i;
            }
        }
        return 1;
    }

    public static int getGradeComboValue(ArrayList<String> list, String value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                return i;
            }
        }
        return 1;
    }

    public static void comboFill(JComboBox jCombo, ArrayList<Lookup> list) {
        jCombo.removeAllItems();
        DefaultComboBoxModel model = (DefaultComboBoxModel) jCombo.getModel();
        for (int i = 0; i < list.size(); i++) {
            model.addElement(new ComboItems(list.get(i).getDesc(), list.get(i).getCode()));
        }
        jCombo.setModel(model);
    }

    public static void DependcomboFill(JComboBox jCombo, ArrayList<Lookup> list, int base, int range) {
        jCombo.removeAllItems();
        DefaultComboBoxModel model = (DefaultComboBoxModel) jCombo.getModel();
        int j = 0;
        Lookup combodata = new Lookup();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode() > base && list.get(i).getCode() < (base + range)) {
                System.out.println(list.get(i).getCode() + "  " + list.get(i).getDesc());
                model.addElement(new ComboItems(list.get(i).getDesc(), list.get(i).getCode()));
                combodata.setCode(list.get(i).getCode());
                combodata.setDesc(list.get(i).getDesc());
                skillsCombo.add(j, combodata);
            }
        }
        jCombo.setModel(model);
    }
    private static ArrayList<CompScore> MatchedCompScore = new ArrayList();
    private static ArrayList<SkillScore> MatchedSkillsScore = new ArrayList();
    private static ArrayList<String> gradeData = new ArrayList(Arrays.asList("Pass", "Good", "V.Good", "Excellent"));
    
    private static ArrayList<Candidate> candidatesData = new ArrayList();
    private static ArrayList<Integer> removedElementsIndecesOfCandidatesData = new ArrayList<>();
    private static ArrayList<Candidate> removedElementsOfCandidatesData = new ArrayList<>();
    private static ArrayList<Candidate> MathedcandidatesData = new ArrayList();
    
    private static ArrayList<Jobs> jobsData = new ArrayList<>();
    private static ArrayList<Integer> removedElementsIndecesOfJobsData = new ArrayList<>();
    private static ArrayList<Jobs> removedElementsOfJobsData = new ArrayList<>();
    
    private static ArrayList<Jobs> MatchedjobsData = new ArrayList<>();
    private static ArrayList<Lookup> jobsCatData = new ArrayList<>();
    private static ArrayList<Lookup> jobsSubCatData = new ArrayList<>();
    private static ArrayList<Lookup> jobsGroupData = new ArrayList<>();
    private static ArrayList<Lookup> educatioData = new ArrayList<>();
    private static ArrayList<Lookup> majorsData = new ArrayList<>();
    private static ArrayList<Lookup> skillCatData = new ArrayList<>();
    private static ArrayList<Lookup> skillData = new ArrayList<>();
    private static ArrayList<Lookup> skillsCombo = new ArrayList<>();
    private static ArrayList<Lookup> compCatData = new ArrayList<>();
    private static ArrayList<Lookup> compData = new ArrayList<>();
    private static int index = 0;
    private static int canindex = 0;
    private static int canindexCount;

    public class SkillScore {

        private int canID;
        private int skill;
        private int score;

        public int getSkillScoreCanID() {
            return canID;
        }

        /**
         * @param canID
         * the skill to set
         */
        public void setSkillScoreCanID(int canID) {
            this.canID = canID;
        }

        /**
         * @return the skill
         */
        public int getSkillScore() {
            return skill;
        }

        /**
         * @param skill the skill to set
         */
        public void setSkillScore(int skill) {
            this.skill = skill;
        }

        /**
         * @return the value
         */
        public int getSkillScoreValue() {
            return score;
        }

        /**
         * @param score the value to set
         */
        public void setSkillScoreValue(int score) {
            this.score = score;
        }
    }

    public class CompScore {

        private int canID;
        private int comp;
        private int score;

        public int getCompScoreCanID() {
            return canID;
        }

        /**
         * @param canID to set
         */
        public void setCompScoreCanID(int canID) {
            this.canID = canID;
        }

        /**
         * @return the skill
         */
        public int getCompScore() {
            return comp;
        }

        /**
         * @param comp 
         * the skill to set
         */
        public void setCompScore(int comp) {
            this.comp = comp;
        }

        /**
         * @return the value
         */
        public int getCompScoreValue() {
            return score;
        }

        /**
         * @param score
         */
        public void setCompcoreValue(int score) {
            this.score = score;
        }
    }

    private javax.swing.ButtonGroup buttonGroupGender;
    private static javax.swing.ButtonGroup buttonGroupGender1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    static javax.swing.JButton jButtonCanAdd;
    static javax.swing.JButton jButtonCanUpdate;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonMatch;
    static javax.swing.JButton jButtonNext;
    static javax.swing.JButton jButtonNextCan;
    static javax.swing.JButton jButtonPrev;
    static javax.swing.JButton jButtonPrevCan;
    static javax.swing.JButton jButtonSave;
    static javax.swing.JButton jButtonCanDelete;
    private javax.swing.JButton jButtonSaveExit;
    private javax.swing.JButton jButtonUpdate;
    static javax.swing.JCheckBox jCheckBoxCanDriving;
    static javax.swing.JCheckBox jCheckBoxCanDriving1;
    static javax.swing.JCheckBox jCheckBoxCanReallocation;
    static javax.swing.JCheckBox jCheckBoxCanReallocation1;
    static javax.swing.JCheckBox jCheckBoxCanTravel;
    static javax.swing.JCheckBox jCheckBoxCanTravell1;
    static javax.swing.JCheckBox jCheckBoxDriving;
    static javax.swing.JCheckBox jCheckBoxDriving1;
    static javax.swing.JCheckBox jCheckBoxReallocation;
    static javax.swing.JCheckBox jCheckBoxReallocation1;
    static javax.swing.JCheckBox jCheckBoxTravel;
    static javax.swing.JCheckBox jCheckBoxTravel1;
    private javax.swing.JComboBox<String> jComboBox1;
    static javax.swing.JComboBox<String> jComboBoxCanComp1;
    static javax.swing.JComboBox<String> jComboBoxCanComp10;
    static javax.swing.JComboBox<String> jComboBoxCanComp2;
    static javax.swing.JComboBox<String> jComboBoxCanComp3;
    static javax.swing.JComboBox<String> jComboBoxCanComp4;
    static javax.swing.JComboBox<String> jComboBoxCanComp5;
    static javax.swing.JComboBox<String> jComboBoxCanComp6;
    static javax.swing.JComboBox<String> jComboBoxCanComp7;
    static javax.swing.JComboBox<String> jComboBoxCanComp8;
    static javax.swing.JComboBox<String> jComboBoxCanComp9;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat1;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat10;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat2;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat3;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat4;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat5;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat6;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat7;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat8;
    static javax.swing.JComboBox<String> jComboBoxCanCompCat9;
    static javax.swing.JComboBox<String> jComboBoxCanEducation;
    static javax.swing.JComboBox<String> jComboBoxCanEducation1;
    static javax.swing.JComboBox<String> jComboBoxCanGrade;
    static javax.swing.JComboBox<String> jComboBoxCanGrade1;
    static javax.swing.JComboBox<String> jComboBoxCanMajor;
    static javax.swing.JComboBox<String> jComboBoxCanMajor1;
    static javax.swing.JComboBox<String> jComboBoxCanSkill1;
    static javax.swing.JComboBox<String> jComboBoxCanSkill10;
    static javax.swing.JComboBox<String> jComboBoxCanSkill2;
    static javax.swing.JComboBox<String> jComboBoxCanSkill3;
    static javax.swing.JComboBox<String> jComboBoxCanSkill4;
    static javax.swing.JComboBox<String> jComboBoxCanSkill5;
    static javax.swing.JComboBox<String> jComboBoxCanSkill6;
    static javax.swing.JComboBox<String> jComboBoxCanSkill7;
    static javax.swing.JComboBox<String> jComboBoxCanSkill8;
    static javax.swing.JComboBox<String> jComboBoxCanSkill9;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat1;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat10;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat2;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat3;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat4;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat5;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat6;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat7;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat8;
    static javax.swing.JComboBox<String> jComboBoxCanSkillCat9;
    static javax.swing.JComboBox<String> jComboBoxComp1;
    static javax.swing.JComboBox<String> jComboBoxComp10;
    static javax.swing.JComboBox<String> jComboBoxComp2;
    static javax.swing.JComboBox<String> jComboBoxComp3;
    static javax.swing.JComboBox<String> jComboBoxComp4;
    static javax.swing.JComboBox<String> jComboBoxComp5;
    static javax.swing.JComboBox<String> jComboBoxComp6;
    static javax.swing.JComboBox<String> jComboBoxComp7;
    static javax.swing.JComboBox<String> jComboBoxComp8;
    static javax.swing.JComboBox<String> jComboBoxComp9;
    static javax.swing.JComboBox<String> jComboBoxCompCat1;
    static javax.swing.JComboBox<String> jComboBoxCompCat10;
    static javax.swing.JComboBox<String> jComboBoxCompCat2;
    static javax.swing.JComboBox<String> jComboBoxCompCat3;
    static javax.swing.JComboBox<String> jComboBoxCompCat4;
    static javax.swing.JComboBox<String> jComboBoxCompCat5;
    static javax.swing.JComboBox<String> jComboBoxCompCat6;
    static javax.swing.JComboBox<String> jComboBoxCompCat7;
    static javax.swing.JComboBox<String> jComboBoxCompCat8;
    static javax.swing.JComboBox<String> jComboBoxCompCat9;
    static javax.swing.JComboBox<String> jComboBoxEducation;
    static javax.swing.JComboBox<String> jComboBoxJobCat;
    static javax.swing.JComboBox<String> jComboBoxJobCat1;
    static javax.swing.JComboBox<String> jComboBoxJobEducation1;
    static javax.swing.JComboBox<String> jComboBoxJobSubCat;
    static javax.swing.JComboBox<String> jComboBoxJobSubCat1;
    static javax.swing.JComboBox<String> jComboBoxMajor1;
    static javax.swing.JComboBox<String> jComboBoxMajor10;
    static javax.swing.JComboBox<String> jComboBoxMajor2;
    static javax.swing.JComboBox<String> jComboBoxMajor3;
    static javax.swing.JComboBox<String> jComboBoxMajor4;
    static javax.swing.JComboBox<String> jComboBoxMajor5;
    static javax.swing.JComboBox<String> jComboBoxMajor6;
    static javax.swing.JComboBox<String> jComboBoxMajor7;
    static javax.swing.JComboBox<String> jComboBoxMajor8;
    static javax.swing.JComboBox<String> jComboBoxMajor9;
    static javax.swing.JComboBox<String> jComboSkills1;
    static javax.swing.JComboBox<String> jComboSkills10;
    static javax.swing.JComboBox<String> jComboSkills2;
    static javax.swing.JComboBox<String> jComboSkills3;
    static javax.swing.JComboBox<String> jComboSkills4;
    static javax.swing.JComboBox<String> jComboSkills5;
    static javax.swing.JComboBox<String> jComboSkills6;
    static javax.swing.JComboBox<String> jComboSkills7;
    static javax.swing.JComboBox<String> jComboSkills8;
    static javax.swing.JComboBox<String> jComboSkills9;
    static javax.swing.JComboBox<String> jComboSkillsCat1;
    static javax.swing.JComboBox<String> jComboSkillsCat10;
    static javax.swing.JComboBox<String> jComboSkillsCat2;
    static javax.swing.JComboBox<String> jComboSkillsCat3;
    static javax.swing.JComboBox<String> jComboSkillsCat4;
    static javax.swing.JComboBox<String> jComboSkillsCat5;
    static javax.swing.JComboBox<String> jComboSkillsCat6;
    static javax.swing.JComboBox<String> jComboSkillsCat7;
    static javax.swing.JComboBox<String> jComboSkillsCat8;
    static javax.swing.JComboBox<String> jComboSkillsCat9;
    static javax.swing.JLabel jLabel1;
    static javax.swing.JLabel jLabel10;
    static javax.swing.JLabel jLabel100;
    static javax.swing.JLabel jLabel101;
    static javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    static javax.swing.JLabel jLabel108;
    static javax.swing.JLabel jLabel11;
    static javax.swing.JLabel jLabel12;
    static javax.swing.JLabel jLabel13;
    static javax.swing.JLabel jLabel14;
    static javax.swing.JLabel jLabel15;
    static javax.swing.JLabel jLabel16;
    static javax.swing.JLabel jLabel17;
    static javax.swing.JLabel jLabel18;
    static javax.swing.JLabel jLabel19;
    static javax.swing.JLabel jLabel2;
    static javax.swing.JLabel jLabel20;
    static javax.swing.JLabel jLabel21;
    static javax.swing.JLabel jLabel22;
    static javax.swing.JLabel jLabel23;
    static javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    static javax.swing.JLabel jLabel27;
    static javax.swing.JLabel jLabel28;
    static javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    static javax.swing.JLabel jLabel30;
    static javax.swing.JLabel jLabel31;
    static javax.swing.JLabel jLabel32;
    static javax.swing.JLabel jLabel33;
    static javax.swing.JLabel jLabel34;
    static javax.swing.JLabel jLabel35;
    static javax.swing.JLabel jLabel36;
    static javax.swing.JLabel jLabel37;
    static javax.swing.JLabel jLabel38;
    static javax.swing.JLabel jLabel39;
    static javax.swing.JLabel jLabel4;
    static javax.swing.JLabel jLabel40;
    static javax.swing.JLabel jLabel41;
    static javax.swing.JLabel jLabel42;
    static javax.swing.JLabel jLabel43;
    static javax.swing.JLabel jLabel44;
    static javax.swing.JLabel jLabel45;
    static javax.swing.JLabel jLabel46;
    static javax.swing.JLabel jLabel47;
    static javax.swing.JLabel jLabel48;
    static javax.swing.JLabel jLabel49;
    static javax.swing.JLabel jLabel5;
    static javax.swing.JLabel jLabel50;
    static javax.swing.JLabel jLabel51;
    static javax.swing.JLabel jLabel52;
    static javax.swing.JLabel jLabel53;
    static javax.swing.JLabel jLabel54;
    static javax.swing.JLabel jLabel55;
    static javax.swing.JLabel jLabel56;
    static javax.swing.JLabel jLabel57;
    static javax.swing.JLabel jLabel58;
    static javax.swing.JLabel jLabel59;
    static javax.swing.JLabel jLabel6;
    static javax.swing.JLabel jLabel60;
    static javax.swing.JLabel jLabel61;
    static javax.swing.JLabel jLabel62;
    static javax.swing.JLabel jLabel63;
    static javax.swing.JLabel jLabel64;
    static javax.swing.JLabel jLabel65;
    static javax.swing.JLabel jLabel66;
    static javax.swing.JLabel jLabel67;
    static javax.swing.JLabel jLabel68;
    static javax.swing.JLabel jLabel69;
    static javax.swing.JLabel jLabel7;
    static javax.swing.JLabel jLabel70;
    static javax.swing.JLabel jLabel71;
    static javax.swing.JLabel jLabel72;
    static javax.swing.JLabel jLabel73;
    static javax.swing.JLabel jLabel74;
    static javax.swing.JLabel jLabel75;
    static javax.swing.JLabel jLabel76;
    static javax.swing.JLabel jLabel77;
    static javax.swing.JLabel jLabel78;
    static javax.swing.JLabel jLabel79;
    static javax.swing.JLabel jLabel8;
    static javax.swing.JLabel jLabel80;
    static javax.swing.JLabel jLabel81;
    static javax.swing.JLabel jLabel82;
    static javax.swing.JLabel jLabel83;
    static javax.swing.JLabel jLabel84;
    static javax.swing.JLabel jLabel85;
    static javax.swing.JLabel jLabel86;
    static javax.swing.JLabel jLabel87;
    static javax.swing.JLabel jLabel88;
    static javax.swing.JLabel jLabel89;
    static javax.swing.JLabel jLabel9;
    static javax.swing.JLabel jLabel90;
    static javax.swing.JLabel jLabel91;
    static javax.swing.JLabel jLabel92;
    static javax.swing.JLabel jLabel93;
    static javax.swing.JLabel jLabel94;
    static javax.swing.JLabel jLabel95;
    static javax.swing.JLabel jLabel96;
    static javax.swing.JLabel jLabel97;
    static javax.swing.JLabel jLabel98;
    static javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelSlider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    static javax.swing.JRadioButton jRadioButtonFemale;
    static javax.swing.JRadioButton jRadioButtonMale;
    static javax.swing.JRadioButton jRadioButtonNewFemale;
    static javax.swing.JRadioButton jRadioButtonNewMale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSlider jSlider1;
    static javax.swing.JSpinner jSpinnerCanCompValue1;
    static javax.swing.JSpinner jSpinnerCanCompValue10;
    static javax.swing.JSpinner jSpinnerCanCompValue2;
    static javax.swing.JSpinner jSpinnerCanCompValue3;
    static javax.swing.JSpinner jSpinnerCanCompValue4;
    static javax.swing.JSpinner jSpinnerCanCompValue5;
    static javax.swing.JSpinner jSpinnerCanCompValue6;
    static javax.swing.JSpinner jSpinnerCanCompValue7;
    static javax.swing.JSpinner jSpinnerCanCompValue8;
    static javax.swing.JSpinner jSpinnerCanCompValue9;
    static javax.swing.JSpinner jSpinnerCanInterviewScore;
    static javax.swing.JSpinner jSpinnerCanInterviewScore1;
    static javax.swing.JSpinner jSpinnerCanSkillValue1;
    static javax.swing.JSpinner jSpinnerCanSkillValue10;
    static javax.swing.JSpinner jSpinnerCanSkillValue2;
    static javax.swing.JSpinner jSpinnerCanSkillValue3;
    static javax.swing.JSpinner jSpinnerCanSkillValue4;
    static javax.swing.JSpinner jSpinnerCanSkillValue5;
    static javax.swing.JSpinner jSpinnerCanSkillValue6;
    static javax.swing.JSpinner jSpinnerCanSkillValue7;
    static javax.swing.JSpinner jSpinnerCanSkillValue8;
    static javax.swing.JSpinner jSpinnerCanSkillValue9;
    static javax.swing.JSpinner jSpinnerCompValue10;
    static javax.swing.JSpinner jSpinnerCompValue6;
    static javax.swing.JSpinner jSpinnerCompValue7;
    static javax.swing.JSpinner jSpinnerCompValue8;
    static javax.swing.JSpinner jSpinnerCompValue9;
    static javax.swing.JSpinner jSpinnerSkillValue10;
    static javax.swing.JSpinner jSpinnerSkillValue6;
    static javax.swing.JSpinner jSpinnerSkillValue7;
    static javax.swing.JSpinner jSpinnerSkillValue8;
    static javax.swing.JSpinner jSpinnerSkillValue9;
    static javax.swing.JSpinner jSpinnercomp1;
    static javax.swing.JSpinner jSpinnercomp2;
    static javax.swing.JSpinner jSpinnercomp3;
    static javax.swing.JSpinner jSpinnercomp4;
    static javax.swing.JSpinner jSpinnercomp5;
    static javax.swing.JSpinner jSpinnerexp;
    static javax.swing.JSpinner jSpinnerinterview;
    static javax.swing.JSpinner jSpinnerinterview1;
    static javax.swing.JSpinner jSpinnerskill1;
    static javax.swing.JSpinner jSpinnerskill2;
    static javax.swing.JSpinner jSpinnerskill3;
    static javax.swing.JSpinner jSpinnerskill4;
    static javax.swing.JSpinner jSpinnerskill5;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTabbedPane jTabbedPane3;
    public javax.swing.JTabbedPane jTabbedPane4;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTableJobs;
    private static javax.swing.JTable jTableMathedPersonComp;
    private static javax.swing.JTable jTableMathedPersonSkills;
    private static javax.swing.JTable jTableMathedPersons;
    static javax.swing.JTextField jTextFieldCanAddress;
    static javax.swing.JTextField jTextFieldCanAddress1;
    static javax.swing.JTextField jTextFieldCanBirthDate;
    static javax.swing.JTextField jTextFieldCanBirthDate1;
    static javax.swing.JTextField jTextFieldCanCity;
    static javax.swing.JTextField jTextFieldCanCity1;
    static javax.swing.JTextField jTextFieldCanCompany;
    static javax.swing.JTextField jTextFieldCanCompany1;
    static javax.swing.JTextField jTextFieldCanCountry;
    static javax.swing.JTextField jTextFieldCanCountry1;
    static javax.swing.JTextField jTextFieldCanEmail;
    static javax.swing.JTextField jTextFieldCanEmail1;
    static javax.swing.JTextField jTextFieldCanExpYears;
    static javax.swing.JTextField jTextFieldCanExpYears1;
    static javax.swing.JTextField jTextFieldCanGPA;
    static javax.swing.JTextField jTextFieldCanGPA1;
    static javax.swing.JTextField jTextFieldCanName;
    static javax.swing.JTextField jTextFieldCanName1;
    static javax.swing.JTextField jTextFieldCanPhone;
    static javax.swing.JTextField jTextFieldCanPhone1;
    static javax.swing.JTextField jTextFieldCanPosition;
    static javax.swing.JTextField jTextFieldCanPosition1;
    static javax.swing.JTextField jTextFieldCanSalary;
    static javax.swing.JTextField jTextFieldCanSalary1;
    static javax.swing.JTextField jTextFieldCandidateID;
    static javax.swing.JTextField jTextFieldCandidateID1;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldDesc;
    static javax.swing.JTextField jTextFieldJobID;
    static javax.swing.JTextField jTextFieldJobID1;
    static javax.swing.JTextField jTextFieldJobTitle;
    static javax.swing.JTextField jTextFieldJobTitle1;
    private static javax.swing.JTextField jTextFieldMatchComp1;
    private static javax.swing.JTextField jTextFieldMatchComp2;
    private static javax.swing.JTextField jTextFieldMatchComp3;
    private static javax.swing.JTextField jTextFieldMatchComp4;
    private static javax.swing.JTextField jTextFieldMatchComp5;
    private static javax.swing.JTextField jTextFieldMatchCompValue1;
    private static javax.swing.JTextField jTextFieldMatchCompValue2;
    private static javax.swing.JTextField jTextFieldMatchCompValue3;
    private static javax.swing.JTextField jTextFieldMatchCompValue4;
    private static javax.swing.JTextField jTextFieldMatchCompValue5;
    private static javax.swing.JTextField jTextFieldMatchSkill1;
    private static javax.swing.JTextField jTextFieldMatchSkill2;
    private static javax.swing.JTextField jTextFieldMatchSkill3;
    private static javax.swing.JTextField jTextFieldMatchSkill4;
    private static javax.swing.JTextField jTextFieldMatchSkill5;
    private static javax.swing.JTextField jTextFieldMatchSkillValue1;
    private static javax.swing.JTextField jTextFieldMatchSkillValue2;
    private static javax.swing.JTextField jTextFieldMatchSkillValue3;
    private static javax.swing.JTextField jTextFieldMatchSkillValue4;
    private static javax.swing.JTextField jTextFieldMatchSkillValue5;
    static javax.swing.JTextField jTextFieldMaxSalary;
    static javax.swing.JTextField jTextFieldMaxSalary1;
    static javax.swing.JTextField jTextFieldMinSalary;
    static javax.swing.JTextField jTextFieldMinSalary1;
    private static javax.swing.JTextField jTextFieldTotCanCompValues;
    private static javax.swing.JTextField jTextFieldTotCanSkillValues;
    private static javax.swing.JTextField jTextFieldTotMatchCompValues;
    private static javax.swing.JTextField jTextFieldTotMatchSkillValues;
    static javax.swing.JTextField jTextFieldYearsOfExp1;
    static javax.swing.JButton update;
    static java.awt.event.ActionEvent jButtonCanUpdateEvent;
    static java.awt.event.ActionEvent jButtonNextCanEvent;
    static java.awt.event.ActionEvent jButtonPrevCanEvent;
    static java.awt.event.ActionEvent updateEvent;
    static java.awt.event.ActionEvent jButtonPrevEvent;
    static java.awt.event.ActionEvent jButtonNextEvent;
    static java.awt.event.ActionEvent jRadioButtonMaleEvent;
    static java.awt.event.ActionEvent jRadioButtonFemaleEvent;
    static int candidatesDataChanged = 0, candidateComparison = 0;
    static int jobsDataChanged = 0, jobsComparison = 0;
    
    // End of variables declaration                   

    public int safeExit(int safe) {
        switch (safe) {
            case JOptionPane.YES_OPTION: // Yes button is clicked.
                if(!jobsData.isEmpty() || jobsDataChanged != jobsComparison){
                    updateActionPerformed(updateEvent);
                    jobsComparison = jobsDataChanged;
                }
                if(!candidatesData.isEmpty() || candidatesDataChanged != candidateComparison){
                    jButtonCanUpdateActionPerformed(jButtonCanUpdateEvent);
                    candidateComparison = candidatesDataChanged;
                }

                // "Methods those perform save changes operation".                
                SaveJobsToCSV();
                SaveCandidatesToCSV();
                SaveLookupsToCSV();
                UserTypePage yesObj = new UserTypePage("AJCSS");
                yesObj.setVisible(true);
                setVisible(false);
                return DO_NOTHING_ON_CLOSE;           
            
            case JOptionPane.NO_OPTION: // No button is clicked.
                recoveringRemovedElements();
                UserTypePage noObj = new UserTypePage("AJCSS");
                noObj.setVisible(true);
                setVisible(false);
                return DO_NOTHING_ON_CLOSE;
           
            case JOptionPane.CANCEL_OPTION: // Cancel button is clicked.
                return DO_NOTHING_ON_CLOSE; 
                
             // Otherwise, like closing the JOption window without clicking any button.
            default:
                return DO_NOTHING_ON_CLOSE; 
        }   
    }

    /**
     * This method recovers all the removed elements of the following lists: - 
     * {@candidatesData} and {@jobsData}
     * in case of clicking NO_OPTION button.
     **/
    public void recoveringRemovedElements(){
            if(!removedElementsOfCandidatesData.isEmpty() && !removedElementsIndecesOfCandidatesData.isEmpty()){
                int min;
                for(int i = removedElementsOfCandidatesData.size()- 1; i >= 0 ; i--){
                    min = minmumValueOfRemovedElementsIndeces(removedElementsIndecesOfCandidatesData);
                    candidatesData.add(min, removedElementsOfCandidatesData.get(i));
                }
                removedElementsOfCandidatesData.clear();
                removedElementsIndecesOfCandidatesData.clear();
            }
            
            if(!removedElementsOfJobsData.isEmpty() && !removedElementsIndecesOfJobsData.isEmpty()){
                int min;
                for(int i = removedElementsOfJobsData.size() - 1; i >= 0 ; i--){
                    min = minmumValueOfRemovedElementsIndeces(removedElementsIndecesOfJobsData);
                    jobsData.add(min, removedElementsOfJobsData.get(i));
                }
                removedElementsOfJobsData.clear();
                removedElementsIndecesOfJobsData.clear();                
            }
    }
    
    /**
     * This method 
     * @return 
     * the minimum value of the 
     * @param array 
     * elements.
     * it's only receive the following integer lists: - 
     * {@removedElementsIndecesOfCandidatesData } 
     * and {@removedElementsIndecesOfJobsData }.  
     */
    public int minmumValueOfRemovedElementsIndeces(ArrayList<Integer> array){
        int min = array.get(0), j = 0;
        for(int i = 1; i < array.size(); i++){
            if( min > array.get(i)){
                min = array.get(i);
                j = i;
            }
        }
        array.remove(j);
        return min;
    }    
    
    /**
     * This method clears all the components of the Unprocessed Candidates tab.
     * it's only sets every single component to its default value.
     **/
    public static void clearUnprocessedCandidatesComponents(){
        jTextFieldCandidateID.setText("");
        jTextFieldCandidateID.setText("");
        jTextFieldCandidateID.setText("");
        jTextFieldCanAddress.setText("");
        
        jComboBoxCanEducation.setSelectedIndex(0);
        jComboBoxCanMajor.setSelectedIndex(0);
        jComboBoxCanGrade.setSelectedIndex(0);
        
        jTextFieldCanBirthDate.setText("");
        jTextFieldCanCity.setText("");
        jTextFieldCanCompany.setText("");
        jTextFieldCanCountry.setText("");
        jTextFieldCanEmail.setText("");
        jTextFieldCanExpYears.setText("");
        jTextFieldCanGPA.setText("");
        jTextFieldCanName.setText("");
        jTextFieldCanPhone.setText("");
        jTextFieldCanPosition.setText("");
        jTextFieldCanSalary.setText("");
        
        jCheckBoxCanReallocation.setSelected(false);
        jCheckBoxCanTravel.setSelected(false);
        jCheckBoxCanDriving.setSelected(false);
        
        jComboBoxCanSkillCat1.setSelectedIndex(0);
        jComboBoxCanSkillCat2.setSelectedIndex(0);
        jComboBoxCanSkillCat3.setSelectedIndex(0);
        jComboBoxCanSkillCat4.setSelectedIndex(0);
        jComboBoxCanSkillCat5.setSelectedIndex(0);
        
        jComboBoxCanSkill1.setSelectedIndex(0);
        jComboBoxCanSkill2.setSelectedIndex(0);
        jComboBoxCanSkill3.setSelectedIndex(0);
        jComboBoxCanSkill4.setSelectedIndex(0);
        jComboBoxCanSkill5.setSelectedIndex(0);
        
        jComboBoxCanCompCat1.setSelectedIndex(0);
        jComboBoxCanCompCat2.setSelectedIndex(0);
        jComboBoxCanCompCat3.setSelectedIndex(0);
        jComboBoxCanCompCat4.setSelectedIndex(0);
        jComboBoxCanCompCat5.setSelectedIndex(0);
        
        jComboBoxCanComp1.setSelectedIndex(0);
        jComboBoxCanComp2.setSelectedIndex(0);
        jComboBoxCanComp3.setSelectedIndex(0);
        jComboBoxCanComp4.setSelectedIndex(0);
        jComboBoxCanComp5.setSelectedIndex(0);
        
        jSpinnerCanCompValue1.setValue(0);
        jSpinnerCanCompValue2.setValue(0);
        jSpinnerCanCompValue3.setValue(0);
        jSpinnerCanCompValue4.setValue(0);
        jSpinnerCanCompValue5.setValue(0);
                 
        jSpinnerCanInterviewScore.setValue(0);
        
        /** The following code 
         * is making the selection unchecked, for the variables: -
         * {@jRadioButtonMale} & {@jRadioButtonFemale} 
        **/
        buttonGroupGender1.clearSelection();
                                
        jSpinnerCanSkillValue1.setValue(0);
        jSpinnerCanSkillValue2.setValue(0);
        jSpinnerCanSkillValue3.setValue(0);
        jSpinnerCanSkillValue4.setValue(0);
        jSpinnerCanSkillValue5.setValue(0);
    }

    /**
     * This method clears all the components of the Vacant Jobs tab.
     * it's only sets every single component to its default value.
     **/    
    public static void clearVacantJobsComponents(){
        jTextFieldJobID.setText("");
        jTextFieldJobTitle.setText("");
        
        jSpinnerinterview.setValue(0);

        jTextFieldMinSalary.setText("");
        jTextFieldMaxSalary.setText("");
        
        jSpinnerexp.setValue(0);
        
        jSpinnerskill1.setValue(0);
        jSpinnerskill2.setValue(0);
        jSpinnerskill3.setValue(0);
        jSpinnerskill4.setValue(0);
        jSpinnerskill5.setValue(0);
        
        jSpinnercomp1.setValue(0);
        jSpinnercomp2.setValue(0);
        jSpinnercomp3.setValue(0);
        jSpinnercomp4.setValue(0);
        jSpinnercomp5.setValue(0);
        
        jCheckBoxReallocation.setSelected(false);
        jCheckBoxTravel.setSelected(false);
        jCheckBoxDriving.setSelected(false);

        jComboBoxJobCat.setSelectedIndex(0);
        jComboBoxJobSubCat.setSelectedIndex(0);
        jComboBoxEducation.setSelectedIndex(0);
        
        jComboBoxMajor1.setSelectedIndex(0);
        jComboBoxMajor2.setSelectedIndex(0);
        jComboBoxMajor3.setSelectedIndex(0);
        jComboBoxMajor4.setSelectedIndex(0);
        jComboBoxMajor5.setSelectedIndex(0);
        
        jComboSkillsCat1.setSelectedIndex(0);
        jComboSkillsCat2.setSelectedIndex(0);
        jComboSkillsCat3.setSelectedIndex(0);
        jComboSkillsCat4.setSelectedIndex(0);
        jComboSkillsCat5.setSelectedIndex(0);

        jComboSkills2.setSelectedIndex(0);
        jComboSkills3.setSelectedIndex(0);
        jComboSkills4.setSelectedIndex(0);
        jComboSkills5.setSelectedIndex(0);
        
        jComboBoxCompCat1.setSelectedIndex(0);
        jComboBoxCompCat2.setSelectedIndex(0);
        jComboBoxCompCat3.setSelectedIndex(0);
        jComboBoxCompCat4.setSelectedIndex(0);
        jComboBoxCompCat5.setSelectedIndex(0);
        
        jComboBoxComp1.setSelectedIndex(0);
        jComboBoxComp2.setSelectedIndex(0);
        jComboBoxComp3.setSelectedIndex(0);
        jComboBoxComp4.setSelectedIndex(0);
        jComboBoxComp5.setSelectedIndex(0);            
    }
}