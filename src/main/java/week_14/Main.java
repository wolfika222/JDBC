package week_14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by Hp_Workplace on 2017. 06. 07..
 */
public class Main {

    public static void main(String[] args) {

        Connection connection = DbUtil.getConnection();
        ArrayList<Actor> list_actor = new ArrayList<Actor>();


        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(QueryConstants.SELECT_ALL_ACTOR_QUERY);
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setId(rs.getInt(1));
                actor.setFirst_name(rs.getString(2));
                actor.setLast_name(rs.getString(3));
                actor.setLast_update(rs.getString(4));
                list_actor.add(actor);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Actor item : list_actor) {
            System.out.println(item.toString());
        }
    }
}
