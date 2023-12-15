package com.example.springhibernate;

import org.hibernate.boot.model.naming.*;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.internal.util.StringHelper;

public class HINamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return sameIdentifier(name);
    }

    private Identifier sameIdentifier(Identifier name) {
        return name!=null ? Identifier.toIdentifier(name.getText()): null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return sameIdentifier(name);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(name);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return sameIdentifier(name);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return sameIdentifier(name);
    }
    private Identifier convertToSnakeCase(final Identifier identifier) {
        if(identifier!=null) {
            /*final String regex = "([a-z])([A-Z])";
            final String replacement = "$1_$2";
            final String newName = identifier.getText()
                    .replaceAll(regex, replacement)
                    .toLowerCase();*/
            return Identifier.toIdentifier("HI_" +identifier.getText());
        }return null;
    }
}
