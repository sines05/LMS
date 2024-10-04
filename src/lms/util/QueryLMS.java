/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import lms.model.Author;
import lms.model.Publisher;

/**
 *
 * @author Aldrin
 */
public class QueryLMS {

    DBConnection c = new DBConnection();
    private ArrayList<ComboBoxList> list;
    private ArrayList<Object> data;
    private static String al = "";
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    /**
     * @return the list
     */
    public ArrayList<ComboBoxList> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<ComboBoxList> list) {
        this.list = list;
    }

    /**
     * @return the data
     */
    public ArrayList<Object> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ArrayList<Object> data) {
        this.data = data;
    }

    public void addType(lms.model.Type category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `type` (\n"
                    + "  `type`,\n"
                    + "  `description`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, category.getType());
            ps.setString(2, category.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateType(lms.model.Type category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `type` \n"
                    + "SET\n"
                    + "  `type` = ?,\n"
                    + "  `description` = ?  \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, category.getType());
            ps.setString(2, category.getDescription());
            ps.setInt(3, category.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteType(lms.model.Type category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `type` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, category.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectType() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `type`,\n"
                    + "  `description`\n"
                    + "FROM `type` WHERE `deleted` =0 ORDER BY `type` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String unitl = rs.getString("type");
                String descriptionl = rs.getString("description");
                Vector v = new Vector();
                v.add(idl);
                v.add(unitl);
                v.add(descriptionl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void addAuthor(lms.model.Author author) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `author` (`firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?) ;");
            ps.setString(1, author.getFirstname());
            ps.setString(2, author.getMiddlename());
            ps.setString(3, author.getLastname());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAuthor(lms.model.Author author) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `author` \n"
                    + "SET \n"
                    + "  `firstname` = ?,\n"
                    + "  `middlename` = ?,\n"
                    + "  `lastname` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, author.getFirstname());
            ps.setString(2, author.getMiddlename());
            ps.setString(3, author.getLastname());
            ps.setInt(4, author.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(lms.model.Author author) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `author` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, author.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectAuthor() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname` \n"
                    + "  ,CONCAT(`lastname`,', ', `firstname`,' ', SUBSTRING(`middlename`,1,1),'.') AS author \n"
                    + "FROM\n"
                    + "  `author` ORDER BY `lastname` ASC; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String authorl = rs.getString("author");
                Vector v = new Vector();
                v.add(idl);
                v.add(firstnamel);
                v.add(middlenamel);
                v.add(lastnamel);
                v.add(authorl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void addPublisher(lms.model.Publisher publisher) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `publisher` (\n"
                    + "  `publisher`,\n"
                    + "  `address`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, publisher.getName());
            ps.setString(2, publisher.getAddress());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePublisher(lms.model.Publisher publisher) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `publisher` \n"
                    + "SET\n"
                    + "  `publisher` = ?,\n"
                    + "  `address` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, publisher.getName());
            ps.setString(2, publisher.getAddress());
            ps.setInt(3, publisher.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePublisher(lms.model.Publisher publisher) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `publisher` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, publisher.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectPublisher() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `publisher`,\n"
                    + "  `address` \n"
                    + "FROM\n"
                    + "  `publisher` ORDER BY `publisher` ASC; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String publisherl = rs.getString("publisher");
                String addressl = rs.getString("address");
                Vector v = new Vector();
                v.add(idl);
                v.add(publisherl);
                v.add(addressl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void addGenre(lms.model.Genre genre) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `genre` (\n"
                    + "  `typeId`,\n"
                    + "  `genre`,\n"
                    + "  `description`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?) ;");
            ps.setInt(1, genre.getType().getId());
            ps.setString(2, genre.getGenre());
            ps.setString(3, genre.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGenre(lms.model.Genre genre) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `genre` \n"
                    + "SET\n"
                    + "  `typeId` = ?,\n"
                    + "  `genre` = ?,\n"
                    + "  `description` = ?\n"
                    + "WHERE `id` = ? ; ");
            ps.setInt(1, genre.getType().getId());
            ps.setString(2, genre.getGenre());
            ps.setString(3, genre.getDescription());
            ps.setInt(4, genre.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGenre(lms.model.Genre genre) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `genre` \n"
                    + "SET \n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, genre.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectGenre() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "     `genre`.`id`\n"
                    + "    , `genre`.`typeId`\n"
                    + "    , `type`.`type`\n"
                    + "    , `genre`.`genre`\n"
                    + "    , `genre`.`description`\n"
                    + "FROM\n"
                    + "    `genre`\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`) WHERE `genre`.`deleted` =0  order by `type`.`type` asc; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String typeIdl = rs.getString("typeId");
                String typel = rs.getString("type");
                String genrel = rs.getString("genre");
                String descriptionl = rs.getString("description");
                Vector v = new Vector();
                v.add(idl);
                v.add(typeIdl);
                v.add(typel);
                v.add(genrel);
                v.add(descriptionl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void comboBoxType() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `type`\n"
                    + "FROM  `type` ORDER BY `type` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("type");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void categoryComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `category`\n"
                    + "FROM\n"
                    + "  `category` WHERE `deleted` =0  ORDER BY category ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("category");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addCallNumberLine1(lms.model.CallNumberLine1 cN) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `call_number_line1` (\n"
                    + "  `letter`,\n"
                    + "  `description`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, cN.getLetters());
            ps.setString(2, cN.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCallNumberLine1(lms.model.CallNumberLine1 cN) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `call_number_line1` \n"
                    + "SET  \n"
                    + "  `letter` = ?,\n"
                    + "  `description` = ? \n"
                    + "WHERE `id` = ?  ;");
            ps.setString(1, cN.getLetters());
            ps.setString(2, cN.getDescription());
            ps.setInt(3, cN.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCallNumberLine1(lms.model.CallNumberLine1 genre) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `call_number_line1` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, genre.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectCallNumberLine1() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `letter`,\n"
                    + "  `description` \n"
                    + "FROM\n"
                    + " `call_number_line1` ORDER BY `letter` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String letterl = rs.getString("letter");
                String descriptionl = rs.getString("description");
                Vector v = new Vector();
                v.add(idl);
                v.add(letterl);
                v.add(descriptionl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void addPurchaser(lms.model.Purchaser p) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `purchaser` (`firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `mobile_no`,\n"
                    + "  `address`,\n"
                    + "  `email`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?) ;");
            ps.setString(1, p.getFirstname());
            ps.setString(2, p.getMiddlename());
            ps.setString(3, p.getLastname());
            ps.setString(4, p.getMobileNo());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getEmail());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePurchaser(lms.model.Purchaser p) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `purchaser` \n"
                    + "SET  \n"
                    + "  `firstname` =?,\n"
                    + "  `middlename` = ?,\n"
                    + "  `lastname` = ?,\n"
                    + "  `mobile_no` = ?,\n"
                    + "  `address` = ?,\n"
                    + "  `email` = ?  \n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, p.getFirstname());
            ps.setString(2, p.getMiddlename());
            ps.setString(3, p.getLastname());
            ps.setString(4, p.getMobileNo());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getEmail());
            ps.setInt(7, p.getId());

            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePurchaser(lms.model.Purchaser p) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `purchaser` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, p.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectPurchaser() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `mobile_no`,\n"
                    + "  `address`,\n"
                    + "  `email` \n"
                    + "FROM  `purchaser` ORDER BY `lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String mobileNol = rs.getString("mobile_no");
                String addressl = rs.getString("address");
                String emaill = rs.getString("email");
                String purchaserl = lastnamel + ", " + firstnamel + " " + middlenamel.substring(0, 1);

                Vector v = new Vector();
                v.add(idl);
                v.add(firstnamel);
                v.add(middlenamel);
                v.add(lastnamel);
                v.add(purchaserl);
                v.add(mobileNol);
                v.add(addressl);
                v.add(emaill);

                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void purchaserComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`\n"
                    + "  ,CONCAT(`lastname`,\", \",`firstname`,\" \",SUBSTRING(`middlename`,1,1),\".\") AS purchaser \n"
                    + "FROM  `purchaser` ORDER BY `lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("purchaser");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void publisherComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  CONCAT(`publisher`,\"-[\",`address`,\"]\") AS publisher \n"
                    + "FROM  `publisher`  ORDER BY `publisher` ASC; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("publisher");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void callNumberLine1ComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`, CONCAT(`description`,' [',`letter`,']') AS callNumberL1 \n"
                    + "FROM  `call_number_line1` ORDER BY `description` ASC ; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("callNumberL1");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void genreComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `genre`.`id`\n"
                    + "    , CONCAT(`genre`.`genre` , '  [',`type`.`type`,']') AS genre \n"
                    + "FROM\n"
                    + "    `genre`\n"
                    + "    INNER JOIN .`type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`) ORDER BY `genre`.`genre` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("genre");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean loginUser(String username, String password) {
        boolean login = false;
        try {
            c.getDBConn();
            PreparedStatement psmt = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `username`,\n"
                    + "  `password`\n"
                    + "FROM \n"
                    + "  `user` WHERE `username` =? AND `password` =?; ");
            psmt.setString(1, username);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastname = rs.getString("lastname");
                String usernamel = rs.getString("username");
                String passwordl = rs.getString("password");
                login = true;
                lms.model.User user = new lms.model.User(id, firstname, middlenamel, lastname, usernamel, passwordl);
                new LoginUser().setUser(user);
            }
            c.closeConnection();
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println(e2);
        }
        return login;

    }

    public void addRecieveBook(lms.model.BookRecieve br) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `book_receive` (\n"
                    + "  `user_id`,\n"
                    + "  `purchaser_id`, `date` \n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,CURRENT_TIMESTAMP) ;");
            ps.setInt(1, br.getUser().getId());
            ps.setInt(2, br.getPurchaser().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRecieveBooksMaxId() {
        int maxId = 0;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS id \n"
                    + " FROM \n"
                    + "  `book_receive` ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idl = rs.getInt("id");
                maxId = idl;
                // Process data here
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maxId;
    }

    public void addBook(lms.model.Book book) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `book` (\n"
                    + "  `isbn`,\n"
                    + "  `title`,\n"
                    + "  `publisher_id`,\n"
                    + "  `description`,\n"
                    + "  `notes`,\n"
                    + "  `subjects`,\n"
                    + "  `url`,\n"
                    + "  `price`,\n"
                    + "  `callNoL1`,\n"
                    + "  `callNoL2`,\n"
                    + "  `callNoL3`,\n"
                    + "  `callNoL4`,\n"
                    + "  `genre_id`,\n"
                    + "  `book_recieve_id`, `quantity` \n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;");
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getPublisher().getId());
            ps.setString(4, book.getDescription());
            ps.setString(5, book.getNotes());
            ps.setString(6, book.getSubjects());
            ps.setString(7, book.getUrl());
            ps.setFloat(8, book.getPrice());
            ps.setInt(9, book.getCallNoLine1().getId());
            ps.setString(10, book.getCallNoLine2());
            ps.setString(11, book.getCallNoLine3());
            ps.setString(12, book.getCallNoLine4());
            ps.setInt(13, book.getGenre().getId());
            ps.setInt(14, book.getBookRecieve().getId());
            ps.setInt(15, book.getQuantity());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getBookMaxId() {
        int maxId = 0;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS id \n"
                    + " FROM \n"
                    + "  `book` ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int idl = rs.getInt("id");
                maxId = idl;
                // Process data here
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return maxId;
    }

    public void addBookAuthor(lms.model.BookAuthor bookAuthor) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `book_author` (\n"
                    + "  `book_id`,\n"
                    + "  `author_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setInt(1, selectBookMaxId());
            ps.setInt(2, bookAuthor.getAuthor().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCourse(lms.model.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `course` (`course`,\n"
                    + "  `acronym`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, course.getCourse());
            ps.setString(2, course.getAcronym());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(lms.model.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `course` \n"
                    + "SET \n"
                    + "  `course` = ?,\n"
                    + "  `acronym` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, course.getCourse());
            ps.setString(2, course.getAcronym());
            ps.setInt(3, course.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(lms.model.Course course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `course` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, course.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectCourse() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `course`,\n"
                    + "  `acronym`\n"
                    + "FROM\n"
                    + "  `course`  WHERE deleted =0 ORDER BY `course` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("course");
                String acronyml = rs.getString("acronym");
                Vector v = new Vector();
                v.add(idl);
                v.add(coursel);
                v.add(acronyml);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void courseComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `course`\n"
                    + "FROM\n"
                    + "  `course` WHERE deleted =0 ORDER BY `course` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("course");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addStudent(lms.model.Student student) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(student.getPhoto());
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `student` (\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `course_id`,\n"
                    + "  `gender`,\n"
                    + "  `email`,\n"
                    + "  `mobile_no`,\n"
                    + "  `dob`,\n"
                    + "  `address`,\n"
                    + "  `guardian`,\n"
                    + "  `photo`\n"
                    + ") \n"
                    + " VALUES \n"
                    + "  (?,?,?,?,?,?,?,?,?,?,?) ;");
            ps.setString(1, student.getFirstname());
            ps.setString(2, student.getMiddlename());
            ps.setString(3, student.getLastname());
            ps.setInt(4, student.getCourse().getId());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getMobileNo());
            ps.setString(8, student.getDateOfBirth());
            ps.setString(9, student.getAddress());
            ps.setString(10, student.getGuardian());
            ps.setBlob(11, fis, (int) student.getPhoto().length());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(lms.model.Student student, boolean imagel) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            if (imagel == true) {
                fis = new FileInputStream(student.getPhoto());
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `student` \n"
                        + "SET \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `course_id` =?,\n"
                        + "  `gender` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `dob` = ?,\n"
                        + "  `address` = ?,\n"
                        + "  `guardian` = ?,\n"
                        + "  `photo` = ? \n"
                        + "WHERE `id` = ? ;");
                ps.setString(1, student.getFirstname());
                ps.setString(2, student.getMiddlename());
                ps.setString(3, student.getLastname());
                ps.setInt(4, student.getCourse().getId());
                ps.setString(5, student.getGender());
                ps.setString(6, student.getEmail());
                ps.setString(7, student.getMobileNo());
                ps.setString(8, student.getDateOfBirth());
                ps.setString(9, student.getAddress());
                ps.setString(10, student.getGuardian());
                ps.setBlob(11, fis, (int) student.getPhoto().length());
                ps.setInt(12, student.getId());
                ps.execute();
                ps.close();
            } else {
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `student` \n"
                        + "SET \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `course_id` =?,\n"
                        + "  `gender` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `dob` = ?,\n"
                        + "  `address` = ?,\n"
                        + "  `guardian` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setString(1, student.getFirstname());
                ps.setString(2, student.getMiddlename());
                ps.setString(3, student.getLastname());
                ps.setInt(4, student.getCourse().getId());
                ps.setString(5, student.getGender());
                ps.setString(6, student.getEmail());
                ps.setString(7, student.getMobileNo());
                ps.setString(8, student.getDateOfBirth());
                ps.setString(9, student.getAddress());
                ps.setString(10, student.getGuardian());
                ps.setInt(11, student.getId());
                ps.execute();
                ps.close();
            }
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(lms.model.Student author) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `student` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, author.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void comboBoxCourse() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `course`\n"
                    + "FROM\n"
                    + " `course`  ORDER BY `course` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("course");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList selectStudent() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `student`.`id`\n"
                    + "    , `course`.`id` as course_id\n"
                    + "    , CONCAT(`student`.`lastname`, ', ',`student`.`firstname`,' ',SUBSTRING(`student`.`middlename`,1,1),'.')  AS student \n"
                    + "    , `student`.`firstname`\n"
                    + "    , `student`.`middlename`\n"
                    + "    , `student`.`lastname`\n"
                    + "    , `course`.`acronym`\n"
                    + "    , `student`.`gender`\n"
                    + "    , `student`.`email`\n"
                    + "    , `student`.`mobile_no`\n"
                    + "    , `student`.`dob`\n"
                    + "    , DATE_FORMAT(`student`.`dob`,'%b. %d, %Y') AS dobf "
                    + "    , `student`.`address`\n"
                    + "    , `student`.`guardian`\n"
                    + "FROM\n"
                    + "    `student`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`)where `student`.`deleted` =0  ORDER BY `student`.`lastname` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String courseIdl = rs.getString("course_id");
                String studentl = rs.getString("student");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String coursel = rs.getString("acronym");
                String genderl = rs.getString("gender");
                String emaill = rs.getString("email");
                String mobileNol = rs.getString("mobile_no");
                String dobl = rs.getString("dob");
                String dobfl = rs.getString("dobf");
                String addressl = rs.getString("address");
                String guardianl = rs.getString("guardian");

                Vector v = new Vector();
                v.add(idl);
                v.add(courseIdl);
                v.add(studentl);
                v.add(firstnamel);
                v.add(middlenamel);
                v.add(lastnamel);
                v.add(coursel);
                v.add(genderl);
                v.add(emaill);
                v.add(mobileNol);
                v.add(dobl);
                v.add(dobfl);
                v.add(addressl);
                v.add(guardianl);

                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public Blob selectedStudentPicture(lms.model.Student student) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM student  where id  =" + student.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public Blob selectedUserPicture(lms.model.User user) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM user  where id  =" + user.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public Blob selectedBooktPicture(lms.model.Book book) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM book  where id  =" + book.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public void updateStudentBarcode(lms.model.Student student) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "   `student` \n"
                    + "SET\n"
                    + "  `barcode` = ?\n"
                    + "WHERE `id` =? ;  ");
            ps.setLong(1, student.getBarcode());
            ps.setInt(2, student.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public lms.model.Student selectStudentData(lms.model.Student student) {
        lms.model.Student s = new lms.model.Student();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `student`.`id`\n"
                    + "    , `course`.`id` as course_id, course.course \n"
                    + "    , CONCAT(`student`.`lastname`, ', ',`student`.`firstname`,' ',SUBSTRING(`student`.`middlename`,1,1),'.')  AS student \n"
                    + "    , `student`.`firstname`\n"
                    + "    , `student`.`middlename`\n"
                    + "    , `student`.`lastname`\n"
                    + "    , `course`.`acronym`\n"
                    + "    , `student`.`gender`\n"
                    + "    , `student`.`email`\n"
                    + "    , `student`.`mobile_no`\n"
                    + "    , `student`.`dob`\n"
                    + "    , DATE_FORMAT(`student`.`dob`,'%b. %d, %Y') AS dobf "
                    + "    , `student`.`address`\n"
                    + "    , `student`.`guardian`, `student`.`barcode` \n"
                    + "FROM\n"
                    + "    `student`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`)where `student`.`id` =" + student.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                lms.model.Course c = new lms.model.Course();
                c.setId(rs.getInt("course_id"));
                c.setCourse(rs.getString("course"));
                s.setCourse(c);
                s.setFirstname(rs.getString("firstname"));
                s.setMiddlename(rs.getString("middlename"));
                s.setLastname(rs.getString("lastname"));
                s.setGender(rs.getString("gender"));
                s.setEmail(rs.getString("email"));
                s.setMobileNo(rs.getString("mobile_no"));
                s.setDateOfBirth(rs.getString("dob"));
                s.setAddress(rs.getString("address"));
                s.setGuardian(rs.getString("guardian"));
                s.setBarcode(rs.getLong("barcode"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public ArrayList selectBooks() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`url`\n"
                    + "    , `book`.`quantity` \n"
                    + "    , `book`.`price`\n"
                    + "    , `genre`.`genre`\n"
                    + "    , `call_number_line1`.`letter`\n"
                    + "    , `call_number_line1`.`description` as callNoDesc "
                    + "    , publisher.id as publisher_id  "
                    + "    , `call_number_line1`.`id` as callNumberLine1_Id"
                    + "    , `genre`.`id` as genre_id "
                    + "    , `book`.`callNoL2`\n"
                    + "    , `book`.`callNoL3`\n"
                    + "    , `book`.`callNoL4`\n"
                    + "  FROM  \n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `call_number_line1` \n"
                    + "        ON (`book`.`callNoL1` = `call_number_line1`.`id`)\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `genre` \n"
                    + "        ON (`book`.`genre_id` = `genre`.`id`)\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`)WHERE `book`.`lost` =0 OR `book`.`damage` =0 GROUP BY `book`.`isbn`  ORDER BY `book`.`title` ASC ;");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String isbnl = rs.getString("isbn");
                String titlel = rs.getString("title");
                String publisherl = rs.getString("publisher");
                String descriptionl = rs.getString("description");
                String notesl = rs.getString("notes");
                String subjectsl = rs.getString("subjects");
                String urll = rs.getString("url");
                String quantityl = rs.getString("quantity");
                Float pricel = rs.getFloat("price");
                String genrel = rs.getString("genre");
                String callNoLetterl = rs.getString("letter");
                String callNoDescl = rs.getString("callNoDesc");
                String callNol = "[" + callNoLetterl + "]-" + callNoDescl;
                String publisherIdl = rs.getString("publisher_id");
                String callNumberLine1_Idl = rs.getString("callNumberLine1_Id");
                String genreIdl = rs.getString("genre_id");
                String callNoL2l = rs.getString("callNoL2");
                String callNoL3l = rs.getString("callNoL3");
                String callNoL4l = rs.getString("callNoL4");

                Vector v = new Vector();
                v.add(idl);
                v.add(isbnl);
                v.add(titlel);
                for (Author a : new QueryLMS().selectAuthorList(idl)) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                }

                v.add(al);
                v.add(publisherl);
                v.add(descriptionl);
                v.add(notesl);
                v.add(subjectsl);
                v.add(urll);
                v.add(quantityl);
                v.add(df.format(pricel));
                v.add(genrel);
                v.add(callNol);
                v.add(pricel);
                v.add(publisherIdl);
                v.add(callNumberLine1_Idl);
                v.add(genreIdl);
                v.add(callNoL2l);
                v.add(callNoL3l);
                v.add(callNoL4l);

                getData().add(v);
                al = "";
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList<Author> selectAuthorList(Integer idl) {
        ArrayList<lms.model.Author> authorList = new ArrayList<Author>();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_author`.`id`\n"
                    + "    ,`author`.`firstname`\n"
                    + "    ,`author`.`lastname`\n"
                    + "    ,`author`.`middlename`\n"
                    + "    , CONCAT(`author`.`lastname`,', ',`author`.`firstname` ,' ',SUBSTRING(`author`.`middlename`,1,1),'.') AS author \n"
                    + "\n"
                    + " FROM \n"
                    + "    `book_author`\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`) WHERE `book_author`.`book_id` =" + idl);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lms.model.Author author = new Author();
                author.setFirstname(rs.getString("id"));
                author.setFirstname(rs.getString("firstname"));
                author.setLastname(rs.getString("lastname"));
                author.setMiddlename(rs.getString("middlename"));
                authorList.add(author);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public lms.model.Book selectBookDetails(lms.model.Book book) {
        lms.model.Book b = new lms.model.Book();
        ArrayList<lms.model.Author> authorList = new ArrayList<Author>();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `isbn`,\n"
                    + "  `title`,\n"
                    + "  `publisher_id`,\n"
                    + "  `description`,\n"
                    + "  `notes`,\n"
                    + "  `subjects`,\n"
                    + "  `price`\n"
                    + "FROM\n"
                    + "  `book` WHERE `book`.`id` =" + book.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setIsbn(rs.getString("isbn"));
                b.setTitle(rs.getString("title"));

                for (Author a : new QueryLMS().selectAuthorList(book.getId())) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
//                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                    authorList.add(a);
                }
                b.setAuthorList(authorList);
                b.setDescription(rs.getString("description"));
                b.setSubjects(rs.getString("subjects"));
                b.setPrice(rs.getFloat("price"));

            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }

    public void addPhotoToBook(lms.model.BookPhoto bookPhoto) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(bookPhoto.getPhoto());
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `book` \n"
                    + "SET \n"
                    + "  `photo` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setBlob(1, fis, (int) bookPhoto.getPhoto().length());
            ps.setInt(2, bookPhoto.getId());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Blob selectedBookPhoto(lms.model.Book book) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM book  where id  =" + book.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public boolean isBookPhotoNull(lms.model.Book book) {
        boolean pic = false;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM book_photo  where book_id  =" + book.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                if (picturel != null) {
                    pic = true;
                }

            }
            rs.close();
            statement.close();
        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public void comboBoxStudent() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  CONCAT(`lastname`, ', ',`firstname`, ' ', SUBSTRING(`middlename`,1,1),'.') AS studentN \n"
                    + "FROM   `student` WHERE `deleted` = 0  ORDER BY `lastname` ASC;");
            ResultSet rs = statement.executeQuery();
//            this.getList().add(new ComboBoxList("", ""));
            while (rs.next()) {
                String idl = rs.getString("id");
                String studentNl = rs.getString("studentN");
                // Process data here
                this.getList().add(new ComboBoxList(idl, studentNl));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public lms.model.Student selectStudentDataByBarcode(lms.model.Student student) {
        lms.model.Student s = new lms.model.Student();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `student`.`id` as student_id\n"
                    + "    , `course`.`id` as course_id, course.course \n"
                    + "    , CONCAT(`student`.`lastname`, ', ',`student`.`firstname`,' ',SUBSTRING(`student`.`middlename`,1,1),'.')  AS student \n"
                    + "    , `student`.`firstname`\n"
                    + "    , `student`.`middlename`\n"
                    + "    , `student`.`lastname`\n"
                    + "    , `course`.`acronym`\n"
                    + "    , `student`.`gender`\n"
                    + "    , `student`.`email`\n"
                    + "    , `student`.`mobile_no`\n"
                    + "    , `student`.`dob`\n"
                    + "    , DATE_FORMAT(`student`.`dob`,'%b. %d, %Y') AS dobf "
                    + "    , `student`.`address`\n"
                    + "    , `student`.`guardian`, `student`.`barcode` \n"
                    + "FROM\n"
                    + "    `student`\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`)where `student`.`barcode` =" + student.getBarcode() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("student_id"));
                lms.model.Course c = new lms.model.Course();
                c.setId(rs.getInt("course_id"));
                c.setCourse(rs.getString("course"));
                s.setCourse(c);
                s.setFirstname(rs.getString("firstname"));
                s.setMiddlename(rs.getString("middlename"));
                s.setLastname(rs.getString("lastname"));
                s.setGender(rs.getString("gender"));
                s.setEmail(rs.getString("email"));
                s.setMobileNo(rs.getString("mobile_no"));
                s.setDateOfBirth(rs.getString("dob"));
                s.setAddress(rs.getString("address"));
                s.setGuardian(rs.getString("guardian"));
                s.setBarcode(rs.getLong("barcode"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }

    public void addPenalty(lms.model.Penalty penalty) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `penalty` (\n"
                    + "  `rate`,\n"
                    + "  `active`,\n"
                    + "  `user_id`,\n"
                    + "  `days` \n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?) ;");
            ps.setFloat(1, penalty.getRate());
            ps.setBoolean(2, penalty.getActive());
            ps.setInt(3, 1);
            ps.setInt(4, penalty.getDaysToBorrow());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePenalty(lms.model.Penalty penalty) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `penalty` \n"
                    + "SET\n"
                    + "  `rate` = ?,\n"
                    + "  `active` = ?,\n"
                    + "  `days` = ? \n"
                    + "WHERE `id` = ? ;");
            ps.setFloat(1, penalty.getRate());
            ps.setBoolean(2, penalty.getActive());
            ps.setInt(3, penalty.getDaysToBorrow());
            ps.setInt(4, penalty.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePenalty(lms.model.Penalty penalty) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `penalty` \n"
                    + "SET \n"
                    + "  deleted = 1\n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, penalty.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateActiveAllPenalty() {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `penalty` \n"
                    + "SET\n"
                    + "  `active` = 0\n"
                    + "WHERE active =1 ;");
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatedActiveOnePenalty(lms.model.Penalty penalty) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `penalty` \n"
                    + "SET\n"
                    + "  `active` = " + penalty.getActive() + "\n"
                    + "WHERE active =" + penalty.getId() + ";");
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectPenalty() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `penalty`.`id`\n"
                    + "    , `penalty`.`rate`,`penalty`.`days` \n"
                    + "    , `penalty`.`active`\n"
                    + "    , `penalty`.`date_start`\n"
                    + "    ,  DATE_FORMAT(`penalty`.`date_start`,'%b. %d, %Y') AS dateL\n"
                    + "    , CONCAT(user.`lastname`,', ', user.`firstname`,' ', SUBSTRING(user.`middlename`,1,1),'.') AS  userN "
                    + "FROM\n"
                    + "    `penalty`\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`penalty`.`user_id` = `user`.`id`) WHERE user.`deleted` =0 ORDER BY `user`.`lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                Float ratel = rs.getFloat("rate");
                Boolean activel = rs.getBoolean("active");
                String dateTimel = rs.getString("date_start");
                String dateTimeF = rs.getString("dateL");
                String userN = rs.getString("userN");
                String daysl = rs.getString("days");

                Vector v = new Vector();
                v.add(idl);
                v.add(ratel);
                v.add(df.format(ratel));
                v.add(daysl);
                v.add(activel);
                v.add(dateTimel);
                v.add(dateTimeF);
                v.add(userN);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public lms.model.Book selectBookByISBN(lms.model.Book book) {
        lms.model.Book b = new lms.model.Book();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `publisher`.`id` as publisher_id\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`price`  \n"
                    + "\n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`) WHERE `book`.`isbn` =? order by book.id desc ");
            statement.setString(1, book.getIsbn());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                lms.model.Publisher p = new Publisher();
                p.setId(rs.getInt("publisher_id"));
                p.setName(rs.getString("publisher"));
                b.setPublisher(p);
                b.setIsbn(rs.getString("isbn"));
                b.setTitle(rs.getString("title"));
                b.setDescription(rs.getString("description"));
                b.setNotes(rs.getString("notes"));
                b.setSubjects(rs.getString("subjects"));
                b.setPrice(rs.getFloat("price"));
                //Author
                for (Author a : new QueryLMS().selectAuthorList(b.getId())) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                }
                b.setAuthorsName(al);
                al = "";
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return b;
    }

    public Blob selectedStudentPicture(lms.model.Faculty faculty) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM student  where id  =" + faculty.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public lms.model.Book selectManual(lms.model.Book book) {
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `publisher`.`id` as publisher_id\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`price`  \n"
                    + "\n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`) WHERE `book`.`id` =" + book.getId() + " order by book.id desc ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));

                if ((rs.getString("id")) == null) {
                    return book = null;
                }
                book.setId(Integer.parseInt(rs.getString("id")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public void bookComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `title`\n"
                    + "FROM\n"
                    + "  `book`  WHERE `deleted` =0 GROUP BY `title`  ORDER BY `title` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("title");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Integer selectActivePenalty() {
        Integer activte = 0;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`\n"
                    + "FROM\n"
                    + "  `penalty`  WHERE `active` =1 ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer picturel = rs.getInt("id");
                activte = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return activte;
    }

    public void addBookBorrowed(lms.model.BookBorrow bb) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `book_borrowed` (\n"
                    + "  `student_id`,\n"
                    + "  `book_id`,\n"
                    + "  `user_id`,penalty_id \n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?) ;");
            ps.setInt(1, bb.getStudent().getId());
            ps.setInt(2, bb.getBook().getId());
            ps.setInt(3, selectUserId());
            ps.setInt(4, selectActivePenalty());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer selectUserId() {
        Integer activte = 0;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`\n"
                    + "FROM\n"
                    + "  `user`  ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer userIdl = rs.getInt("id");
                activte = userIdl;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return activte;
    }

    public ArrayList selectBorrowedBooks(int studentId) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `book`.`publisher_id`\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`quantity`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`price`\n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `book_borrowed` \n"
                    + "        ON (`book`.`id` = `book_borrowed`.`book_id`)\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `book_author` \n"
                    + "        ON (`book_author`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`) WHERE `book_borrowed`.`student_id` =" + studentId + " AND `book_borrowed`.`book_return` =0     GROUP BY `book_borrowed`.`book_id` ORDER BY `book`.`title` ASC ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String publisher_idl = rs.getString("publisher_id");
                String isbnl = rs.getString("isbn");
                String quantityl = rs.getString("quantity");
                String titlel = rs.getString("title");
                //Author
                for (Author a : new QueryLMS().selectAuthorList(idl)) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                }

                String publisherl = rs.getString("publisher");
                String descriptionl = rs.getString("description");
                String notesl = rs.getString("notes");
                String subjectsl = rs.getString("subjects");
                Float pricel = rs.getFloat("price");
                boolean old = true;

                Vector v = new Vector();
                v.add(idl);
                v.add(publisher_idl);
                v.add(isbnl);
                v.add(quantityl);
                v.add(titlel);
                v.add(al);
                v.add(publisherl);
                v.add(descriptionl);
                v.add(notesl);
                v.add(subjectsl);
                v.add(pricel);
                v.add(df.format(pricel));
                v.add(old);
                getData().add(v);
                al = "";
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public Integer selectBookMaxId() {
        Integer maxId = 0;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS id\n"
                    + "FROM\n"
                    + "  `book` ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("id");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

    public boolean bookReturn(String bookId) {
        boolean pic = false;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `book_return` \n"
                    + "FROM\n"
                    + "  `book_borrowed` WHERE `book_id` =" + bookId + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Boolean picturel = rs.getBoolean("book_return");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pic;
    }

    public Blob selectedBooktPicture(lms.model.BookBorrow bb) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("" + bb.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public lms.model.BookBorrow isBookBorrow(lms.model.BookBorrow bookBorrow) {
        boolean borrowed = false;
        lms.model.BookBorrow bb = new lms.model.BookBorrow();
        lms.model.Student student = new lms.model.Student();
        lms.model.Book book = new lms.model.Book();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `student_id`,\n"
                    + "  `book_id`,\n"
                    + "  `user_id`,\n"
                    + "  `borrowed_date_time`,\n"
                    + "  `return_date_time`,\n"
                    + "  `penalty_id`,\n"
                    + "  `book_return` \n"
                    + "FROM\n"
                    + "  `book_borrowed` WHERE `student_id` =? AND `book_id` =? AND `book_return` =0;");
            statement.setInt(1, bookBorrow.getStudent().getId());
            statement.setInt(2, bookBorrow.getBook().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                Integer studentIdl = rs.getInt("student_id");
                Integer bookIdl = rs.getInt("book_id");
                Boolean bookReturnl = rs.getBoolean("book_id");
                book.setId(bookIdl);
                student.setId(studentIdl);
                bb.setStudent(student);
                bb.setBook(book);
                bb.setReturnBook(bookReturnl);

            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return bb;
    }

    public lms.model.BookBorrow selectBookIdStudentId(Integer studentId, Integer bookId) {
        lms.model.BookBorrow bb = new lms.model.BookBorrow();
        lms.model.Student student = new lms.model.Student();
        lms.model.Book book = new lms.model.Book();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `student_id`,\n"
                    + "  `book_id`,\n"
                    + "  `user_id`,\n"
                    + "  `borrowed_date_time`,\n"
                    + "  `return_date_time`,\n"
                    + "  `penalty_id`,\n"
                    + "  `book_return` \n"
                    + "FROM\n"
                    + "  `book_borrowed` WHERE `student_id` =? AND `book_id` =? AND `book_return` =0;");
            statement.setInt(1, studentId);
            statement.setInt(2, bookId);
            ResultSet rs = statement.executeQuery();
            Integer idl = null;
            bb.setWrongBarcode(true);
            while (rs.next()) {
                idl = rs.getInt("id");
                Integer studentIdl = rs.getInt("student_id");
                Integer bookIdl = rs.getInt("book_id");
                Boolean bookReturnl = rs.getBoolean("book_id");
                book.setId(bookIdl);
                student.setId(studentIdl);
                bb.setId(idl);
                bb.setStudent(student);
                bb.setBook(book);
                bb.setReturnBook(bookReturnl);
                bb.setWrongBarcode(false);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bb;
    }

    public ArrayList selectBorrowedBooksByID(Integer studentId) {
        lms.model.Book b = new lms.model.Book();
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`,`publisher`.`id` as publisher_id\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`url`\n"
                    + "    , `book`.`quantity`\n"
                    + "    , `book`.`price`\n"
                    + "    , `genre`.`genre`\n"
                    + "    , `type`.`type`\n"
                    + "    , `type`.`description`\n"
                    + "    , `call_number_line1`.`letter`\n"
                    + "    , `call_number_line1`.`description`\n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `call_number_line1` \n"
                    + "        ON (`book`.`callNoL1` = `call_number_line1`.`id`)\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `genre` \n"
                    + "        ON (`book`.`genre_id` = `genre`.`id`)\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`)\n"
                    + "    INNER JOIN `book_borrowed` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)WHERE `book_borrowed`.`student_id` =? AND `book_borrowed`.`book_return` =0 ORDER BY `book`.`title` ASC;");
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String publisher_idl = rs.getString("publisher_id");
                String isbnl = rs.getString("isbn");
                String quantityl = rs.getString("quantity");
                String titlel = rs.getString("title");
                //Author
                for (Author a : new QueryLMS().selectAuthorList(idl)) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                }

                String publisherl = rs.getString("publisher");
                String descriptionl = rs.getString("description");
                String notesl = rs.getString("notes");
                String subjectsl = rs.getString("subjects");
                Float pricel = rs.getFloat("price");
                boolean old = true;

                Vector v = new Vector();
                v.add(idl);
                v.add(publisher_idl);
                v.add(isbnl);
                v.add(quantityl);
                v.add(titlel);
                v.add(al);
                v.add(publisherl);
                v.add(descriptionl);
                v.add(notesl);
                v.add(subjectsl);
                v.add(pricel);
                v.add(df.format(pricel));
                v.add(old);
                getData().add(v);
                al = "";

            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return getData();
    }

    public void returnBoorowedBooks(lms.model.BookBorrow bookBorrow) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `book_borrowed` \n"
                    + "SET\n"
                    + "  `return_date_time` = CURRENT_TIMESTAMP(),\n"
                    + "  `book_return` = 1 \n"
                    + "WHERE `student_id` = ? AND `book_id` = ? AND `book_return` = 0 ");
            ps.setInt(1, bookBorrow.getStudent().getId());
            ps.setInt(2, bookBorrow.getBook().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectBooksBorrowed() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book`.`id`\n"
                    + "    , `book`.`isbn`\n"
                    + "    , `book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`url`\n"
                    + "    , `book`.`quantity`\n"
                    + "    , `book`.`price`\n"
                    + "    , `genre`.`genre`\n"
                    + "    , `type`.`type`\n"
                    + "    , `type`.`description`\n"
                    + "    , `call_number_line1`.`letter`\n"
                    + "    , `call_number_line1`.`description` as callNoDesc\n"
                    + "    , `book_author`.`author_id`     , CONCAT(`student`.`lastname`,', ',`student`.`firstname`, ' ',SUBSTRING(`student`.`middlename`,1,1),'.')AS student   \n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `call_number_line1` \n"
                    + "        ON (`book`.`callNoL1` = `call_number_line1`.`id`)\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `genre` \n"
                    + "        ON (`book`.`genre_id` = `genre`.`id`)\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`)\n"
                    + "    INNER JOIN `book_borrowed` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `book_author` \n"
                    + "        ON (`book_author`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`) WHERE `book_borrowed`.`book_return` =0  group by book.id ORDER BY `book_borrowed`.`id` ASC ;");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String isbnl = rs.getString("isbn");
                String titlel = rs.getString("title");
                String publisherl = rs.getString("publisher");
                String descriptionl = rs.getString("description");
                String notesl = rs.getString("notes");
                String subjectsl = rs.getString("subjects");
                String urll = rs.getString("url");
                String quantityl = rs.getString("quantity");
                Float pricel = rs.getFloat("price");
                String genrel = rs.getString("genre");
                String callNoLetterl = rs.getString("letter");
                String callNoDescl = rs.getString("callNoDesc");
                String studentl = rs.getString("student");
                String callNol = "[" + callNoLetterl + "]-" + callNoDescl;
                Vector v = new Vector();
                v.add(idl);
                v.add(idl);
                v.add(studentl);
                v.add(titlel);
                for (Author a : new QueryLMS().selectAuthorList(idl)) {
                    String fname = a.getFirstname();
                    String lname = a.getLastname();
                    String mname = a.getMiddlename();
                    al = al + "[" + lname + ", " + fname + " " + mname.substring(0, 1) + "." + "]";
                }

                v.add(al);
                v.add(publisherl);
                v.add(descriptionl);
                v.add(notesl);
                v.add(subjectsl);
                v.add(urll);
                v.add(quantityl);
                v.add(df.format(pricel));
                v.add(genrel);
                v.add(callNol);
                v.add(pricel);
                getData().add(v);

                al = "";
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectStudentPenalties() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `student`.`id`, `book_borrowed`.`student_id`  \n"
                    + "    , CONCAT(`student`.`lastname`,', ',`student`.`firstname`, ' ', SUBSTRING(`student`.`middlename`,1,1),'.') AS  student \n"
                    + "    , `course`.`course`\n"
                    + "    , SUM((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`)) AS days\n"
                    + "    , FORMAT(`penalty`.`rate`,2) AS rate \n"
                    + "    , FORMAT(SUM(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`)),2) AS penalty  \n"
                    + "FROM\n"
                    + "    `lms`.`book_borrowed`\n"
                    + "    INNER JOIN `lms`.`student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `lms`.`book` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `lms`.`penalty` \n"
                    + "        ON (`book_borrowed`.`penalty_id` = `penalty`.`id`)\n"
                    + "    INNER JOIN `lms`.`course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`) WHERE  `book_borrowed`.`penalty_paid`=0  \n"
                    + "         AND (SELECT SUM((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`)))>0    \n"
                    + "   GROUP BY `book_borrowed`.`student_id` ORDER BY `student`.`lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                Integer studentId = rs.getInt("student_id");
                String titlel = rs.getString("student");
                String daysl = rs.getString("days");
                String ratel = rs.getString("rate");
                String penaltyl = rs.getString("penalty");

                Vector v = new Vector();
                v.add(idl);
                v.add(studentId);
                v.add(titlel);
                v.add(daysl);
                v.add(ratel);
                v.add(penaltyl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectStudentPenalties(int studentId) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_borrowed`.`id`  \n"
                    + "    , CONCAT(`student`.`lastname`,', ',`student`.`firstname`, ' ', SUBSTRING(`student`.`middlename`,1,1),'.') AS  student \n"
                    + "    , `course`.`course`, book.title \n"
                    + "    , (DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`) AS days\n"
                    + "    , FORMAT(`penalty`.`rate`,2) AS rate \n"
                    + "    , FORMAT(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`),2) AS penalty  \n"
                    + "FROM\n"
                    + "    `book_borrowed`\n"
                    + "    INNER JOIN `student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `book` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `penalty` \n"
                    + "        ON (`book_borrowed`.`penalty_id` = `penalty`.`id`)\n"
                    + "    INNER JOIN `course` \n"
                    + "        ON (`student`.`course_id` = `course`.`id`)where `book_borrowed`.`student_id` =? AND (SELECT (DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`))>0   AND  `book_borrowed`.`penalty_paid`=0    ORDER BY `student`.`lastname` ASC ");
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String titlel = rs.getString("title");
                String daysl = rs.getString("days");
                String ratel = rs.getString("rate");
                String penaltyl = rs.getString("penalty");

                Vector v = new Vector();
                v.add(idl);
                v.add(titlel);
                v.add(daysl);
                v.add(ratel);
                v.add(penaltyl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectStudentPenaltyDetails(int studentId) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("select    `book_borrowed`.`id` , `student`.`id` as student_id \n"
                    + "    , CONCAT(`student`.`lastname`,', ',`student`.`firstname`, ' ', SUBSTRING(`student`.`middlename`,1,1),'.') AS  student \n"
                    + "    , `book`.`title`\n"
                    + "    , DATE_FORMAT(`book_borrowed`.`borrowed_date_time`, '%b. %d, %Y  %r') AS borrowedDate\n"
                    + "    , DATE_FORMAT(`book_borrowed`.`return_date_time`,'%b. %d, %Y  %r') AS returnDate \n"
                    + "    , SUM((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`))AS days\n"
                    + "    , `penalty`.`rate` AS rate \n"
                    + "    , SUM(FORMAT(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`),2)) AS penalty  \n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `call_number_line1` \n"
                    + "        ON (`book`.`callNoL1` = `call_number_line1`.`id`)\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `genre` \n"
                    + "        ON (`book`.`genre_id` = `genre`.`id`)\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`)\n"
                    + "    INNER JOIN `book_borrowed` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `penalty` \n"
                    + "        ON (`book_borrowed`.`penalty_id` = `penalty`.`id`)\n"
                    + "    INNER JOIN `book_author` \n"
                    + "        ON (`book_author`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`) \n"
                    + "         WHERE `student`.`id` =? AND 0>( SELECT DATEDIFF(`book_borrowed`.`borrowed_date_time`, `book_borrowed`.`return_date_time`)) ORDER BY `book_borrowed`.`return_date_time`  ASC ;");
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String studentIdl = rs.getString("student_id");
                String studentl = rs.getString("student");
//                String borrowedDatel = rs.getString("borrowedDate");
//                String returnDatel = rs.getString("returnDate");
                String daysl = rs.getString("days");
                String ratel = rs.getString("rate");
                String penaltyAmountl = rs.getString("penalty");

                Vector v = new Vector();
                v.add(idl);
                v.add(studentIdl);
                v.add(studentl);
                v.add(daysl);
                v.add(ratel);
                v.add(penaltyAmountl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectStudentPenalyDetails(int studentId) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_borrowed`.`id`\n"
                    + "    , `student`.`id` AS student_id\n"
                    + "    , CONCAT(`student`.`lastname`,', ',`student`.`firstname`, ' ', SUBSTRING(`student`.`middlename`,1,1),'.') AS  student \n"
                    + "    , `book`.`title`\n"
                    + "    , DATE_FORMAT(`book_borrowed`.`borrowed_date_time`, '%b. %d, %Y  %r') AS borrowedDate\n"
                    + "    , DATE_FORMAT(`book_borrowed`.`return_date_time`,'%b. %d, %Y  %r') AS returnDate \n"
                    + "    , (DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`)AS days\n"
                    + "    , `penalty`.`rate` AS rate \n"
                    + "    , FORMAT(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`),2) AS penalty  \n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `call_number_line1` \n"
                    + "        ON (`book`.`callNoL1` = `call_number_line1`.`id`)\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `genre` \n"
                    + "        ON (`book`.`genre_id` = `genre`.`id`)\n"
                    + "    INNER JOIN `type` \n"
                    + "        ON (`genre`.`typeId` = `type`.`id`)\n"
                    + "    INNER JOIN `book_borrowed` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `penalty` \n"
                    + "        ON (`book_borrowed`.`penalty_id` = `penalty`.`id`)\n"
                    + "    INNER JOIN `book_author` \n"
                    + "        ON (`book_author`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`) \n"
                    + "         WHERE `student`.`id` =? AND 0>( SELECT DATEDIFF(`book_borrowed`.`borrowed_date_time`, `book_borrowed`.`return_date_time`))GROUP BY `book`.`id`  order BY `book_borrowed`.`return_date_time`  ASC ;");
            statement.setInt(1, studentId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String studentIdl = rs.getString("student_id");
                String titlel = rs.getString("title");
                String borrowedDatel = rs.getString("borrowedDate");
                String returnDatel = rs.getString("returnDate");
                String daysl = rs.getString("days");
                String ratel = rs.getString("rate");
                String penaltyAmountl = rs.getString("penalty");

                Vector v = new Vector();
                v.add(idl);
                v.add(titlel);
                v.add(borrowedDatel);
                v.add(returnDatel);
                v.add(daysl);
                v.add(ratel);
                v.add(penaltyAmountl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectBookByAuthor(int bookId) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_author`.`author_id`,`author`.`lastname`,`author`.`firstname`,`author`.`middlename` \n"
                    + "    , CONCAT(`author`.`lastname`,', ',`author`.`firstname`,' ',SUBSTRING(`author`.`middlename`,1,1),'.') AS authorName \n"
                    + "\n"
                    + "FROM\n"
                    + "    `book_author`\n"
                    + "    INNER JOIN `author` \n"
                    + "        ON (`book_author`.`author_id` = `author`.`id`)WHERE `book_author`.`book_id` =?");
            statement.setInt(1, bookId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("author_id");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String authorName = rs.getString("authorName");

                Vector v = new Vector();
                v.add(idl);
                v.add(firstnamel);
                v.add(middlenamel);
                v.add(lastnamel);
                v.add(authorName);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void updateBook(lms.model.Book book) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `book` \n"
                    + "SET  \n"
                    + "  `isbn` = ?,\n"
                    + "  `title` = ?,\n"
                    + "  `publisher_id` = ?,\n"
                    + "  `description` = ?,\n"
                    + "  `notes` =?,\n"
                    + "  `subjects` = ?,\n"
                    + "  `url` = ?,\n"
                    + "  `quantity` = ?,\n"
                    + "  `price` = ?,\n"
                    + "  `callNoL1` = ?,\n"
                    + "  `callNoL2` = ?,\n"
                    + "  `callNoL3` = ?,\n"
                    + "  `callNoL4` = ?,\n"
                    + "  `genre_id` = ?\n"
                    + "WHERE `id` = ? ;");
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getPublisher().getId());
            ps.setString(4, book.getDescription());
            ps.setString(5, book.getNotes());
            ps.setString(6, book.getSubjects());
            ps.setString(7, book.getUrl());
            ps.setInt(8, book.getQuantity());
            ps.setFloat(9, book.getPrice());
            ps.setInt(10, book.getCallNoLine1().getId());
            ps.setString(11, book.getCallNoLine2());
            ps.setString(12, book.getCallNoLine3());
            ps.setString(13, book.getCallNoLine4());
            ps.setInt(14, book.getGenre().getId());
            ps.setInt(15, book.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBookAuthor(lms.model.BookAuthor bookAuthor) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("DELETE \n"
                    + "FROM\n"
                    + "  `book_author` \n"
                    + "WHERE `book_id` =? AND `author_id` =? ");
            ps.setInt(1, bookAuthor.getBook().getId());
            ps.setInt(2, bookAuthor.getAuthor().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAuthortoThisBook(lms.model.BookAuthor bookAuthor) {
        boolean check = false;
        lms.model.BookAuthor ba = new lms.model.BookAuthor();
        lms.model.Book book = new lms.model.Book();
        lms.model.Author author = new lms.model.Author();

        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `book_id`,\n"
                    + "  `author_id`\n"
                    + "FROM\n"
                    + "  `book_author` WHERE `book_id` =? AND `author_id` =? ");
            statement.setInt(1, bookAuthor.getBook().getId());
            statement.setInt(2, bookAuthor.getAuthor().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                Integer bookIdl = rs.getInt("book_id");
                Integer authorIdl = rs.getInt("author_id");
                ba.setId(idl);
                book.setId(bookIdl);
                ba.setBook(book);
                author.setId(authorIdl);
                ba.setAuthor(author);
                check = true;
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

    public void updateBookAuthor(lms.model.BookAuthor bookAuthor) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `book_author` (\n"
                    + "  `book_id`,\n"
                    + "  `author_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setInt(1, bookAuthor.getBook().getId());
            ps.setInt(2, bookAuthor.getAuthor().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPenaltyPayment(lms.model.BookBorrow bookBorrowed) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE\n"
                    + "  `book_borrowed` \n"
                    + "SET\n"
                    + "  `user_receive_penalty` = ?,\n"
                    + "  `penalty_paid` = ?, date_penalty_paid = CURRENT_TIMESTAMP() \n"
                    + " WHERE `id` = ? ;");
            ps.setInt(1, selectUserId());
            ps.setBoolean(2, true);
            ps.setInt(3, bookBorrowed.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectUser() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + " user.id,   CONCAT( `user`.`lastname`,', ', `user`.`firstname`, ' ',SUBSTRING(UPPER(`user`.`middlename`),1,1),'.')AS Uname \n"
                    + "    ,`user`.`firstname`\n"
                    + "    , `user`.`middlename`\n"
                    + "    , `user`.`lastname`\n"
                    + "    , `user`.`email`\n"
                    + "    , `user`.`mobile_no`\n"
                    + "    , `user`.`username`\n"
                    + "    , `user`.`password`\n"
                    + "    , `user`.`photo`\n"
                    + "FROM\n"
                    + "   `user` WHERE user.`deleted` =0 ORDER BY user.`lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String supplierNamel = rs.getString("Uname");
                String firstnamel = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastnamel = rs.getString("lastname");
                String emaill = rs.getString("email");
                String mobileNol = rs.getString("mobile_no");
                String usernamel = rs.getString("username");
                String passwordl = rs.getString("password");

                Vector v = new Vector();
                v.add(idl);
                v.add(supplierNamel);
                v.add(firstnamel);
                v.add(middlenamel);
                v.add(lastnamel);
                v.add(emaill);
                v.add(mobileNol);
                v.add(usernamel);
                v.add(passwordl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void addUser(lms.model.User user, File photo) {
        try {
            FileInputStream fis = null;
            c.getDBConn();
            fis = new FileInputStream(photo);
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `user` (\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `email`,\n"
                    + "  `mobile_no`,\n"
                    + "  `username`,\n"
                    + "  `password`,\n"
                    + "  `photo`) \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?,?,?) ;");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getMiddlename());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getMobileNo());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setBlob(8, fis, (int) photo.length());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(lms.model.User user, File photo, int userId, boolean image) {
        try {
            FileInputStream fis = null;
            c.getDBConn();
            fis = new FileInputStream(photo);
            if (image == false) {
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `user` \n"
                        + "SET  \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `username` = ?,\n"
                        + "  `password` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getMiddlename());
                ps.setString(3, user.getLastname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getMobileNo());
                ps.setString(6, user.getUsername());
                ps.setString(7, user.getPassword());
                ps.setInt(8, userId);
                ps.execute();
                ps.close();
                c.closeConnection();
            } else {
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `user` \n"
                        + "SET  \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `username` = ?,\n"
                        + "  `password` = ?,\n"
                        + "  `photo` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getMiddlename());
                ps.setString(3, user.getLastname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getMobileNo());
                ps.setString(6, user.getUsername());
                ps.setString(7, user.getPassword());
                ps.setBlob(8, fis, (int) photo.length());
                ps.setInt(9, userId);
                ps.execute();
                ps.close();
                c.closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int idl) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("update user  set  deleted = 1  where  id = ? ;");
            ps.setInt(1, idl);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Blob selectUserPicture(int id) {
        Blob photo = null;
        try {

            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM user  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                photo = picturel;
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return photo;
    }

    public void updatePassword(String password) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `user`  SET  `password` = ?    WHERE `id` = ? ;");
            ps.setString(1, password);
            ps.setInt(2, new lms.util.LoginUser().getUser().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectViewRecievedBooks() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_receive`.`id`\n"
                    + "    ,CONCAT(`user`.`lastname`,', ',`user`.`firstname`, ' ',SUBSTRING(`user`.`middlename`,1,1),'.') AS userN\n"
                    + "    , CONCAT(`purchaser`.`lastname`,', ',`purchaser`.`firstname`,' ', SUBSTRING(`purchaser`.`middlename`,1,1),'.') AS purchaserN\n"
                    + "    ,  DATE_FORMAT(`book_receive`.`date`, '%b. %d, %Y  %r') AS dateReceived  \n"
                    + "FROM\n"
                    + "    `book`\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `purchaser` \n"
                    + "        ON (`book_receive`.`purchaser_id` = `purchaser`.`id`)\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`book_receive`.`user_id` = `user`.`id`)ORDER BY `book_receive`.`date` DESC  ;");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer idl = rs.getInt("id");
                String userNl = rs.getString("userN");
                String purchaserNl = rs.getString("purchaserN");
                String dateReceivedl = rs.getString("dateReceived");

                Vector v = new Vector();
                v.add(idl);
                v.add(userNl);
                v.add(purchaserNl);
                v.add(dateReceivedl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectViewRecievedBooksDetails(lms.model.BookRecieve bookReceive) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "    `book`.`quantity`\n"
                    + "    ,`book`.`title`\n"
                    + "    , `publisher`.`publisher`\n"
                    + "    , `book`.`description`\n"
                    + "    , `book`.`notes`\n"
                    + "    , `book`.`subjects`\n"
                    + "    , `book`.`url`\n"
                    + "    , FORMAT(`book`.`price`,2) AS price\n"
                    + "    ,FORMAT(`book`.`quantity`*`book`.`price`,2) AS lineTotal \n"
                    + "   FROM \n"
                    + "    `book`\n"
                    + "    INNER JOIN `book_receive` \n"
                    + "        ON (`book`.`book_recieve_id` = `book_receive`.`id`)\n"
                    + "    INNER JOIN `publisher` \n"
                    + "        ON (`book`.`publisher_id` = `publisher`.`id`)\n"
                    + "    INNER JOIN `purchaser` \n"
                    + "        ON (`book_receive`.`purchaser_id` = `purchaser`.`id`)\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`book_receive`.`user_id` = `user`.`id`)WHERE `book_receive`.`id`=? ORDER BY `book_receive`.`date` DESC ;");
            statement.setInt(1, bookReceive.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer quantityl = rs.getInt("quantity");
                String titlel = rs.getString("title");
                String publisherl = rs.getString("publisher");
                String descriptionl = rs.getString("description");
                String notesl = rs.getString("notes");
                String subjectsl = rs.getString("subjects");
                String urll = rs.getString("url");
                String pricel = rs.getString("price");
                String lineTotall = rs.getString("lineTotal");
                Vector v = new Vector();
                v.add(quantityl);
                v.add(titlel);
                v.add(publisherl);
                v.add(descriptionl);
                v.add(notesl);
                v.add(subjectsl);
                v.add(urll);
                v.add(pricel);
                v.add(lineTotall);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public ArrayList selectUserCollectedPenalties(String start, String end) {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + "    `book_borrowed`.`student_id`  \n"
                    + "    ,CONCAT(`student`.`lastname`,', ',`student`.`firstname`,' ', SUBSTRING(`student`.`middlename`,1,1),'.') AS student \n"
                    + "    , DATE_FORMAT(`book_borrowed`.`date_penalty_paid`, '%b. %d, %Y  %r') AS datePaid \n"
                    + "    ,SUM(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`))) AS days \n"
                    + "    , FORMAT(`penalty`.`rate`,2) AS rate \n"
                    + "    , SUM(FORMAT(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`),2)) AS penalty  "
                    + "    ,SUM(((DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)-`penalty`.`days`)*`penalty`.`rate`)) AS penaltyUF\n"
                    + "FROM\n"
                    + "    `book_borrowed`\n"
                    + "    INNER JOIN `penalty` \n"
                    + "        ON (`book_borrowed`.`penalty_id` = `penalty`.`id`)\n"
                    + "    INNER JOIN `student` \n"
                    + "        ON (`book_borrowed`.`student_id` = `student`.`id`)\n"
                    + "    INNER JOIN `book` \n"
                    + "        ON (`book_borrowed`.`book_id` = `book`.`id`)\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`book_borrowed`.`user_receive_penalty` = `user`.`id`)WHERE  (SELECT (DATEDIFF(`book_borrowed`.`return_date_time`,`book_borrowed`.`borrowed_date_time`)- `penalty`.`days`))>0  \n"
                    + "        AND  ((`book_borrowed`.`date_penalty_paid` >=?) AND (`book_borrowed`.`date_penalty_paid` <=?))  AND `book_borrowed`.`user_receive_penalty`=?\n"
                    + "        GROUP BY `book_borrowed`.`student_id`  \n"
                    + "        ORDER BY `student`.`lastname` ASC ;");
            statement.setString(1, start);
            statement.setString(2, end);
            statement.setInt(3, new lms.util.LoginUser().getUser().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Integer studentIdl = rs.getInt("student_id");
                String studentl = rs.getString("student");
                String datePaidl = rs.getString("datePaid");
                String daysl = rs.getString("days");
                String ratel = rs.getString("rate");
                String penaltyl = rs.getString("penalty");
                String penaltyUFl = rs.getString("penaltyUF");
                Vector v = new Vector();
                v.add(studentIdl);
                v.add(studentl);
                v.add(datePaidl);
                v.add(daysl);
                v.add(ratel);
                v.add(penaltyl);
                v.add(penaltyUFl);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

    public void startComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `date_penalty_paid`,\n"
                    + " DATE_FORMAT(`date_penalty_paid`, '%b. %d, %Y  %r') AS datePaid \n"
                    + "\n"
                    + "FROM\n"
                    + "  `book_borrowed`  WHERE `penalty_paid` >0 AND `user_receive_penalty`=?    GROUP BY  `date_penalty_paid`         ORDER BY  `date_penalty_paid` DESC;");
            statement.setInt(1, new lms.util.LoginUser().getUser().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("date_penalty_paid");
                String coursel = rs.getString("datePaid");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void endComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `date_penalty_paid`,\n"
                    + " DATE_FORMAT(`date_penalty_paid`, '%b. %d, %Y  %r') AS datePaid \n"
                    + "\n"
                    + "FROM\n"
                    + "  `book_borrowed`  WHERE `penalty_paid` >0 AND `user_receive_penalty`=? GROUP BY  `date_penalty_paid`     ORDER BY  `date_penalty_paid` DESC;");
            statement.setInt(1, new lms.util.LoginUser().getUser().getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("date_penalty_paid");
                String coursel = rs.getString("datePaid");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addHoliday(lms.model.Holiday course) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `holiday` ( `holiday`, `date`) \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, course.getHoliday());
            ps.setString(2, course.getDate());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHoliday(lms.model.Holiday holiday) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `holiday` \n"
                    + "SET \n"
                    + "  `holiday` = ?,\n"
                    + "  `date` = ? \n"
                    + "WHERE `id` = ?;");
            ps.setString(1, holiday.getHoliday());
            ps.setString(2, holiday.getDate());
            ps.setInt(3, holiday.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHoliday(lms.model.Holiday holiday) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `holiday` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, holiday.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectHoliday() {
        setData(new ArrayList<>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `holiday`,\n"
                    + "  `date`,\n"
                    + "  DATE_FORMAT(`date`,'%b. %d, %Y') AS dateF \n"
                    + "FROM\n"
                    + "  `holiday` where deleted =0 ORDER BY `date` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String holiday = rs.getString("holiday");
                String date = rs.getString("date");
                String dateF = rs.getString("dateF");
                Vector v = new Vector();
                v.add(idl);
                v.add(holiday);
                v.add(date);
                v.add(dateF);
                getData().add(v);
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getData();
    }

}
