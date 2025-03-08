/*
 * This file is generated by jOOQ.
 */
package keywhiz.jooq.tables;


import java.util.Arrays;
import java.util.List;

import keywhiz.jooq.Indexes;
import keywhiz.jooq.Keys;
import keywhiz.jooq.KeywhizdbTest;
import keywhiz.jooq.tables.records.SchemaVersionRecord;
import keywhiz.model.LongConverter;
import keywhiz.model.TimestampConverter;
import keywhiz.model.TinyIntConverter;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SchemaVersion extends TableImpl<SchemaVersionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>keywhizdb_test.schema_version</code>
     */
    public static final SchemaVersion SCHEMA_VERSION = new SchemaVersion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SchemaVersionRecord> getRecordType() {
        return SchemaVersionRecord.class;
    }

    /**
     * The column <code>keywhizdb_test.schema_version.installed_rank</code>.
     */
    public final TableField<SchemaVersionRecord, Long> INSTALLED_RANK = createField(DSL.name("installed_rank"), SQLDataType.INTEGER.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>keywhizdb_test.schema_version.version</code>.
     */
    public final TableField<SchemaVersionRecord, String> VERSION = createField(DSL.name("version"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>keywhizdb_test.schema_version.description</code>.
     */
    public final TableField<SchemaVersionRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.schema_version.type</code>.
     */
    public final TableField<SchemaVersionRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.schema_version.script</code>.
     */
    public final TableField<SchemaVersionRecord, String> SCRIPT = createField(DSL.name("script"), SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.schema_version.checksum</code>.
     */
    public final TableField<SchemaVersionRecord, Long> CHECKSUM = createField(DSL.name("checksum"), SQLDataType.INTEGER, this, "", new LongConverter());

    /**
     * The column <code>keywhizdb_test.schema_version.installed_by</code>.
     */
    public final TableField<SchemaVersionRecord, String> INSTALLED_BY = createField(DSL.name("installed_by"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>keywhizdb_test.schema_version.installed_on</code>.
     */
    public final TableField<SchemaVersionRecord, Long> INSTALLED_ON = createField(DSL.name("installed_on"), SQLDataType.TIMESTAMP(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.TIMESTAMP)), this, "", new TimestampConverter());

    /**
     * The column <code>keywhizdb_test.schema_version.execution_time</code>.
     */
    public final TableField<SchemaVersionRecord, Long> EXECUTION_TIME = createField(DSL.name("execution_time"), SQLDataType.INTEGER.nullable(false), this, "", new LongConverter());

    /**
     * The column <code>keywhizdb_test.schema_version.success</code>.
     */
    public final TableField<SchemaVersionRecord, Boolean> SUCCESS = createField(DSL.name("success"), SQLDataType.TINYINT.nullable(false), this, "", new TinyIntConverter());

    private SchemaVersion(Name alias, Table<SchemaVersionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SchemaVersion(Name alias, Table<SchemaVersionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>keywhizdb_test.schema_version</code> table
     * reference
     */
    public SchemaVersion(String alias) {
        this(DSL.name(alias), SCHEMA_VERSION);
    }

    /**
     * Create an aliased <code>keywhizdb_test.schema_version</code> table
     * reference
     */
    public SchemaVersion(Name alias) {
        this(alias, SCHEMA_VERSION);
    }

    /**
     * Create a <code>keywhizdb_test.schema_version</code> table reference
     */
    public SchemaVersion() {
        this(DSL.name("schema_version"), null);
    }

    public <O extends Record> SchemaVersion(Table<O> child, ForeignKey<O, SchemaVersionRecord> key) {
        super(child, key, SCHEMA_VERSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KeywhizdbTest.KEYWHIZDB_TEST;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.SCHEMA_VERSION_SCHEMA_VERSION_S_IDX);
    }

    @Override
    public UniqueKey<SchemaVersionRecord> getPrimaryKey() {
        return Keys.KEY_SCHEMA_VERSION_PRIMARY;
    }

    @Override
    public SchemaVersion as(String alias) {
        return new SchemaVersion(DSL.name(alias), this);
    }

    @Override
    public SchemaVersion as(Name alias) {
        return new SchemaVersion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SchemaVersion rename(String name) {
        return new SchemaVersion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SchemaVersion rename(Name name) {
        return new SchemaVersion(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, String, String, Long, String, Long, Long, Boolean> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}