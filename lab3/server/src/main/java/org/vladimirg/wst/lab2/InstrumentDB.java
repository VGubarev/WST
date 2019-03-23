package org.vladimirg.wst.lab2;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("Duplicates")
public class InstrumentDB {
    private Connection connection;

    public InstrumentDB(Connection conn) {
        connection = conn;
    }

    public Integer createInstrument(InstrumentFields instrumentFields) {
        String MIC = instrumentFields.getMIC();
        String ISIN = instrumentFields.getISIN();
        Date validUntil = instrumentFields.getDate();
        Boolean derivative = instrumentFields.isDerivative();

        StringBuilder builder = new StringBuilder();
        builder.append("insert into instruments");

        List<String> fields = new ArrayList<>();
        List<String> values = new ArrayList<>();

        if (MIC != null) {
            fields.add("MIC");
        }
        if (ISIN != null) {
            fields.add("ISIN");
        }
        if (validUntil != null) {
            fields.add("validUntil");
        }
        if (derivative != null) {
            fields.add("derivative");
        }

        if (!fields.isEmpty()) {
            builder.append(" ( ");
            builder.append(String.join(", ", fields));
            builder.append(" ) VALUES ( ");
            Iterator it = fields.iterator();
            builder.append("?");
            it.next();
            while (it.hasNext()) {
                builder.append(", ?");
                it.next();
            }
            builder.append(" )");
        }

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            int id = 0;
            if (MIC != null) {
                stmt.setString(++id, MIC);
            }
            if (ISIN != null) {
                stmt.setString(++id, ISIN);
            }
            if (validUntil != null) {
                stmt.setDate(++id, new java.sql.Date(validUntil.getTime()));
            }
            if (derivative != null) {
                stmt.setBoolean(++id, derivative);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        try {
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(5);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return 0;
    }


    public OperationStatus updateInstrument(InstrumentFields instrumentFields) {
        Integer id = instrumentFields.getId();

        if (id == null) {
            return new OperationStatus(false, "Instrument identifier is required to update instrument");
        }

        String MIC = instrumentFields.getMIC();
        String ISIN = instrumentFields.getISIN();
        Date validUntil = instrumentFields.getDate();
        Boolean derivative = instrumentFields.isDerivative();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("update instruments");

        List<String> values = new ArrayList<>();

        if (MIC != null) {
            values.add("MIC='" + MIC + "'");
        }
        if (ISIN != null) {
            values.add("ISIN='" + ISIN + "'");
        }
        if (validUntil != null) {
            values.add("validUntil=" + validUntil.toString());
        }
        if (derivative != null) {
            values.add("derivative" + derivative.toString());
        }

        if (!values.isEmpty()) {
            builder.append(" set ");
            builder.append(String.join(", ", values));
            builder.append(" where id=").append(id);
        }
        else {
            return new OperationStatus(false, "Nothing to update");
        }


        try {
            stmt.executeUpdate(builder.toString());
            int updates = stmt.getUpdateCount();
            if (updates > 0) {
                return new OperationStatus(true, "Updated " + updates + " instruments");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new OperationStatus(false, "Failed to update instrument:" + e.getSQLState());
        }

        return new OperationStatus(true, "No instruments updated");
    }

    public OperationStatus deleteInstrument(InstrumentFields instrumentFields) {
        Integer id = instrumentFields.getId();
        if (id == null) {
            return new OperationStatus(false, "Instrument identifier is required to delete instrument");
        }

        try {
            PreparedStatement stmt = connection.prepareStatement("delete from instruments where id=?");
            stmt.setInt(1, id);
            int deletes = stmt.executeUpdate();
            if (deletes < 1) {
                return new OperationStatus(false, "No instruments deleted");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new OperationStatus(false, "Delete error: " + e.getSQLState());
        }

        return new OperationStatus(true, "Instrument was deleted");
    }

    public List<Instrument> getInstruments(InstrumentFields instrumentFields) {
        Integer id = instrumentFields.getId();
        String MIC = instrumentFields.getMIC();
        String ISIN = instrumentFields.getISIN();
        Date validUntil = instrumentFields.getDate();
        Boolean derivative = instrumentFields.isDerivative();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("select * from instruments");
        boolean first = true;
        if (id != null) {
            if (first) {
                builder.append(" where ");
                first = false;
            }
            else {
                builder.append(" and ");
            }
            builder.append("id=").append(id);
        }
        if (MIC != null) {
            if (first) {
                builder.append(" where ");
                first = false;
            }
            else {
                builder.append(" and ");
            }
            builder.append("MIC like '").append(MIC).append("'");
        }
        if (ISIN != null) {
            if (first) {
                builder.append(" where ");
                first = false;
            }
            else {
                builder.append(" and ");
            }
            builder.append("ISIN like '").append(ISIN).append("'");
        }
        if (validUntil != null) {
            if (first) {
                builder.append(" where ");
                first = false;
            }
            else {
                builder.append(" and ");
            }
            builder.append("validUntil < '").append(validUntil).append("'");
        }
        if (derivative != null) {
            if (first) {
                builder.append(" where ");
                first = false;
            }
            else {
                builder.append(" and ");
            }
            builder.append("derivative=").append(derivative);
        }

        try {
            ResultSet rs = stmt.executeQuery(builder.toString());
            return parseResultSet(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Instrument> parseResultSet(ResultSet rs) {
        List<Instrument> instruments = new ArrayList<>();
        try {
            while (rs.next()) {
                Instrument instrument = new Instrument();

                instrument.setId(rs.getInt("id"));
                instrument.setDerivative(rs.getBoolean("derivative"));
                instrument.setISIN(rs.getString("ISIN"));
                instrument.setMIC(rs.getString("MIC"));
                instrument.setValidUntil(rs.getTimestamp("validUntil"));

                instruments.add(instrument);
            }
        } catch (SQLException e) {
            Logger.getLogger(InstrumentDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return instruments;
    }
}
