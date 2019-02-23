package com.vladimirg.wst.lab1_server;

import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstrumentDB {
    private Connection connection;

    public InstrumentDB(Connection conn) {
        connection = conn;
    }

    public List<Instrument> getAllInstruments() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from instruments");
        return parseResultSet(rs);
    }

    public List<Instrument> getInstruments(Integer id,
                                           String MIC,
                                           String ISIN,
                                           Date validUntil,
                                           Boolean derivative) throws SQLException {
        Statement stmt = connection.createStatement();
        StringBuilder builder = new StringBuilder();
        builder.append("select * from instruments where ");
        boolean first = true;
        if (id != null) {
            if (!first) {
                builder.append(" and ");
                first = false;
            }
            builder.append("id=").append(id);
        }
        if (MIC != null) {
            if (!first) {
                first = false;
                builder.append(" and ");
            }
            builder.append("MIC like '").append(MIC).append("'");
        }
        if (ISIN != null) {
            if (!first) {
                first = false;
                builder.append(" and ");
            }
            builder.append("ISIN like '").append(ISIN).append("'");
        }
        if (validUntil != null) {
            if (!first) {
                first = false;
                builder.append(" and ");
            }
            builder.append("validUntil < '").append(validUntil).append("'");
        }
        if (derivative != null) {
            if (!first) {
                first = false;
                builder.append(" and ");
            }
            builder.append("derivative=").append(derivative);
        }

        ResultSet rs = stmt.executeQuery(builder.toString());
        return parseResultSet(rs);
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
